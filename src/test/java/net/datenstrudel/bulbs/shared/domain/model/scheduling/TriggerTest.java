/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.datenstrudel.bulbs.shared.domain.model.scheduling;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.quartz.CronExpression;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Thomas Wendzinski
 */
public class TriggerTest {
    
    public TriggerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    @Before
    public void setUp() {
    }

    @Test
    public void testNextTriggerTime() {
        System.out.println("nextTriggerTime");
        Date result = new PointInTimeTrigger(new Date(new Date().getTime() - 1000l), "UTC").nextTriggerTime();
        assertEquals(null, result);
    }

    public class TriggerImpl extends Trigger {
        @Override
        public CronExpression toCronExpression() {
            return null;
        }
        @Override
        public boolean isExpired() {
            return false;
        }
        @Override
        public boolean sameValueAs(Trigger other) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
