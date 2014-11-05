/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.datenstrudel.bulbs.shared.domain.model.color;

import junit.framework.TestCase;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;

/**
 *
 * @author Thomas Wendzinski
 */
public class ColorSchemeTest extends TestCase {
    
    private static final Logger log = LoggerFactory.getLogger(ColorSchemeTest.class);
    public ColorSchemeTest(String testName) {
        super(testName);
    }

    public void testRGBtoHSB() {
        System.out.println("RGBtoHSB");
        ColorRGB rgb = new ColorRGB(255, 255, 255);
        ColorHSB result = ColorScheme.RGBtoHSB(rgb);
        log.info("HSB: "+result);
        
        rgb = new ColorRGB(255, 0, 0);
        result = ColorScheme.RGBtoHSB(rgb);
        log.info("RGB: " + rgb + "HSB: "+result);
        rgb = new ColorRGB(255, 125, 0);
        result = ColorScheme.RGBtoHSB(rgb);
        log.info("RGB: " + rgb + "HSB: "+result);
        rgb = new ColorRGB(255, 255, 0);
        result = ColorScheme.RGBtoHSB(rgb);
        log.info("RGB: " + rgb + "HSB: "+result);
        
        rgb = new ColorRGB(0, 255, 0);
        result = ColorScheme.RGBtoHSB(rgb);
        log.info("RGB: " + rgb + "HSB: "+result);
        rgb = new ColorRGB(0, 0, 255);
        result = ColorScheme.RGBtoHSB(rgb);
        log.info("RGB: " + rgb + "HSB: "+result);
    }
    public void testHSBtoRGB() {
        
        System.out.println("RGBtoHSB");
        ColorHSB hsb = new ColorHSB(1f, 0f, 1f);
//        ColorRGB result = ColorScheme.HSBtoRGB(hsb);
        ColorRGB result = ColorScheme.HSBtoRGB(0.3891050f, 1f, 1f);
        log.info("HSB: " + hsb + "RGB: "+result);
        
//        hsb = new ColorRGB(255, 0, 0);
//        result = ColorScheme.RGBtoHSB(hsb);
//        log.info("RGB: " + hsb + "HSB: "+result);
    }
}
