package net.datenstrudel.bulbs.shared.domain.model.scheduling;

import org.junit.Test;
import org.quartz.CronExpression;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Thomas Wendzinski
 */
public class PointInTimeTriggerTest {
    
    @Test
    public void testToCronExpression() {
        System.out.println("toCronExpression");
        PointInTimeTrigger instance = new PointInTimeTrigger(
                Date.from(LocalDateTime.of(2000, Month.MAY, 2, 13, 1, 5).toInstant(ZoneOffset.UTC)),
                "Europe/Berlin"
        );
        String expResult = "5 1 15 2 5 ? 2000"; // We know its DST in May (+2 hours)
        CronExpression result = instance.toCronExpression();
        assertEquals(expResult, result.getCronExpression());
    }
    @Test
    public void testIsExpired() throws Exception{
        System.out.println("isExpired");
        PointInTimeTrigger instance = new PointInTimeTrigger(
                new Date(new Date().getTime() + 1000l),
                "Europe/Berlin"
        );
        boolean result = instance.isExpired();
        assertEquals(false, result);
        Thread.sleep(2000l);
        result = instance.isExpired();
        assertEquals(true, result);
    }


}
