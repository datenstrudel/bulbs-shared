package net.datenstrudel.bulbs.shared.domain.model.scheduling;

import com.wordnik.swagger.annotations.ApiModel;
import org.quartz.CronExpression;

import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * //TODO: Implement!
 * @author Thomas Wendzinski
 */
@ApiModel(value="Variable interval trigger", parent = Trigger.class)
public class IntervalTrigger extends Trigger{

    //~ Member(s) //////////////////////////////////////////////////////////////
    private Date startAt;
    private ChronoUnit intervalUnit;
    private int interval;
    private ChronoUnit lengthUnit;
    private int length;
    
    //~ Construction ///////////////////////////////////////////////////////////

    //~ Method(s) //////////////////////////////////////////////////////////////
    @Override
    public CronExpression toCronExpression() {
//        ChronTrigger
//        intervalUnit.compareTo(intervalUnit)
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //~ Private Artifact(s) ////////////////////////////////////////////////////

    @Override
    public boolean isExpired() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sameValueAs(Trigger other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
