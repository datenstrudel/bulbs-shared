package net.datenstrudel.bulbs.shared.domain.model.scheduling;

import com.wordnik.swagger.annotations.ApiModel;
import org.quartz.CronExpression;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TimeZone;

/**
 *
 * @author Thomas Wendzinski
 */
@ApiModel(value="Triggers at specific point in tume, once.", parent = Trigger.class)
public final class PointInTimeTrigger extends Trigger {

    //~ Member(s) //////////////////////////////////////////////////////////////
    @NotNull
    private Date startAt;
    private String timezoneId = "UTC";
    private transient CronExpression cronExpression = null;
    
    //~ Construction ///////////////////////////////////////////////////////////
    private PointInTimeTrigger() {}
    public PointInTimeTrigger(Date startAt, String timezoneId) {
        setStartAt(startAt);
        setTimezoneId(timezoneId);
    }
    public PointInTimeTrigger(CronExpression exp){
        setTimezoneId(exp.getTimeZone().getID());
        StringTokenizer tk = new StringTokenizer(exp.getCronExpression(), " \t");
        String[] cronFields = new String[7];
        int i = 0;
        while(tk.hasMoreTokens()){
            cronFields[i++] = tk.nextToken();
        }
        LocalDateTime now = LocalDateTime.now(ZoneId.of(timezoneId));
        try{
            LocalDateTime datetime = LocalDateTime.of(
                    cronFields[6] == null ? now.getYear() : Integer.parseInt(cronFields[6]), 
                    Integer.parseInt(cronFields[4]),
                    Integer.parseInt(cronFields[3]),
                    Integer.parseInt(cronFields[2]),
                    Integer.parseInt(cronFields[1]),
                    Integer.parseInt(cronFields[0]),
                    0 );
            setStartAt(Date.from(datetime.toInstant(ZoneOffset.UTC)));
        }catch(NumberFormatException nfex){
            throw new IllegalArgumentException("Couldn't reconstruct "
                    + "PointInTimeTrigger from cronExpression: " + exp.getCronExpression());
        }
    }

    //~ Method(s) //////////////////////////////////////////////////////////////
    @Override
    public CronExpression toCronExpression() {
        if(this.cronExpression != null) return cronExpression;
        Instant date_utc = startAt.toInstant();
        LocalDateTime date = LocalDateTime.ofInstant(
                date_utc, ZoneId.of(timezoneId) );
        
        StringBuilder res_cron = new StringBuilder(32);
        res_cron.append( date.getSecond() ).append(" ")
                .append( date.getMinute() ).append(" ")
                .append( date.getHour() ).append(" ")
                .append( date.getDayOfMonth() ).append(" ")
                .append( date.getMonthValue() ).append(" ")
                .append( "? ")
                .append( date.getYear() )
                ;
        CronExpression res;
        try {
            res = new CronExpression(res_cron.toString());
            res.setTimeZone(TimeZone.getTimeZone(timezoneId));
            this.cronExpression = res;
            return res;
        } catch (ParseException ex) {// should never reach here!
            throw new RuntimeException("An error in trigger algorithm has "
                    + "been detected. Blame the programmer!");
        }
    }
    @Override
    public boolean isExpired() {
        return new Date().getTime() > startAt.getTime();
    }

    public Date getStartAt() {
        return startAt;
    }
    public String getTimezoneId() {
        return timezoneId;
    }

    //~ ////////////////////////////////////////////////////////////////////////
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.startAt);
        hash = 59 * hash + Objects.hashCode(this.timezoneId);
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj)return true;
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PointInTimeTrigger other = (PointInTimeTrigger) obj;
        if (!Objects.equals(this.startAt, other.startAt)) {
            return false;
        }
        if (!Objects.equals(this.timezoneId, other.timezoneId)) {
            return false;
        }
        return true;
    }
    @Override
    public boolean sameValueAs(Trigger other) {
        return this.equals(other);
    }
    @Override
    public String toString() {
        return "PointInTimeTrigger{" + "startAt=" + startAt + ", timezoneId=" + timezoneId + '}';
    }
    
    //~ Private Artifact(s) ////////////////////////////////////////////////////
    private void setStartAt(Date startAt) {
        if(startAt == null) throw new IllegalArgumentException("Member 'startAt' must not be null!");
        this.startAt = new Date( (startAt.getTime() / 1000l) * 1000); // clean millis 
    }
    private void setTimezoneId(String timezoneId) {
        if(timezoneId == null) throw new IllegalArgumentException("Member 'timezoneId' must not be null!");
        this.timezoneId = timezoneId;
    }

}
