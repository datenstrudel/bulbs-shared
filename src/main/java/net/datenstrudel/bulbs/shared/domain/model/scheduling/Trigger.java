package net.datenstrudel.bulbs.shared.domain.model.scheduling;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import net.datenstrudel.bulbs.shared.domain.model.ValueObject;
import org.quartz.CronExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Date;

/**
 * <p>
 * Base type description of Bulb Framework's scheduler triggers. For different kinds and
 * purposes of triggers an implementation might be created. Of course, we can represent almost
 * any kind of scheduling rule as {@link CronExpression} but we don't want to expect
 * any client beeing capable of dealing with its complexity. Thus the different implementations
 * shall abstract from CronTrigger's complexity and provide an easy interface to clients to epxress
 * different, specific kinds of schedules.
 * </p>
 * <p>
 * <b>Note</b>, that implementations must implement a constructor, expecting a {@link CronExpression}
 * from which the whole state of the trigger can be reconstructed.
 * </p>
 *
 * @see net.datenstrudel.bulbs.shared.domain.model.scheduling.DaysOfWeekTrigger
 * @see net.datenstrudel.bulbs.shared.domain.model.scheduling.IntervalTrigger
 * @see net.datenstrudel.bulbs.shared.domain.model.scheduling.PointInTimeTrigger
 * @author Thomas Wendzinski
 */
@ApiModel(value = "Defines the actual trigger time(s)", discriminator = "type",
        subTypes = {DaysOfWeekTrigger.class, PointInTimeTrigger.class, IntervalTrigger.class})
public abstract class Trigger implements  ValueObject<Trigger> {
    
    static final Logger log = LoggerFactory.getLogger(Trigger.class);
    @ApiModelProperty(allowableValues = "DaysOfWeekTrigger, PointInTimeTrigger, InervalTrigger")
    private String type = this.getClass().getSimpleName();
    
    //~ ///////////////////////////////////////////////////////////////////////
    /**
     * @return this trigger as cron expression
     */
    public abstract CronExpression toCronExpression();
    /**
     * @return whether the trigger won't fire again
     */
    public abstract boolean isExpired();
    
    public final Date nextTriggerTime(){
        return this.toCronExpression().getNextValidTimeAfter(new Date());
    }

    /**
     * Factory method for implementations of <code>Trigger</code> by <code>CronExpression</code>
     * and type.
     * @param <T>
     * @param type
     * @param cronExpression
     * @return 
     * @throws java.text.ParseException 
     */
    public static <T extends Trigger> T fromCronExpression(Class<T> type, String cronExpression) throws ParseException{
        return fromCronExpression(type, new CronExpression(cronExpression));
    }
    public static <T extends Trigger> T fromCronExpression(Class<T> type, CronExpression cronExpression){
        try {
            Constructor<T> con = type.getConstructor(CronExpression.class);
            T res = con.newInstance(cronExpression);
            return res;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            log.error("Couldn' create Trigger instance from cron expression. "
                    + "You need to implement a constructor expecting a valid CronExpression", ex);
            throw new IllegalArgumentException("Couldn't create Trigger instance from cron expression.", ex);
        }
    };
    
    
    
}
