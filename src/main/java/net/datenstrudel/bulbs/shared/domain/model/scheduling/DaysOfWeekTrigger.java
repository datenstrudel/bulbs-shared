package net.datenstrudel.bulbs.shared.domain.model.scheduling;

import com.wordnik.swagger.annotations.ApiModel;
import org.quartz.CronExpression;

/**
 * //TODO: Implement me!
 * @author Thomas Wendzinski
 */
@ApiModel(value="Triggers at several das of week.", parent = Trigger.class)
public class DaysOfWeekTrigger extends  Trigger{

    @Override
    public CronExpression toCronExpression() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isExpired() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sameValueAs(Trigger other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //~ Member(s) //////////////////////////////////////////////////////////////
    //~ Construction ///////////////////////////////////////////////////////////
    //~ Method(s) //////////////////////////////////////////////////////////////
    //~ Private Artifact(s) ////////////////////////////////////////////////////

}
