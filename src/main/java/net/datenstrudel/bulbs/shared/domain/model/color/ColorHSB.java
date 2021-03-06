package net.datenstrudel.bulbs.shared.domain.model.color;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Wendzinski
 */
@ApiModel(
        value="HSB a.k.a. Hue - Saturation - Brightness color implementation",
        parent = Color.class,
        discriminator = "colorScheme"
)
public class ColorHSB extends Color<ColorHSB> implements Serializable {

    //~ Member(s) //////////////////////////////////////////////////////////////
	/**
	 * D=[0;360]
	 */
    @ApiModelProperty(allowableValues = "0,360", required = true)
	private final float hue;
	/**
	 * D=[0;255]
	 */
    @ApiModelProperty(allowableValues = "0,255", required = true)
	private final float saturation;
	/**
	 * D=[0;255]
	 */
    @ApiModelProperty(allowableValues = "0,255", required = true)
	private final float brightness;

    @JsonIgnore
    @ApiModelProperty(value = "colorScheme", allowableValues = "HSB", required = true, position = 1)
    private final ColorScheme COLOR_SCHEME = ColorScheme.HSB;

    //~ Construction ///////////////////////////////////////////////////////////
	private ColorHSB(){
        brightness = 255f;
        hue = 0f;
        saturation = 255f;
	}

    /**
     * Init HSB color given hue, saturation, brightness
     * @param hue in range [0, 360]
     * @param saturation in range [0, 255]
     * @param brightness in range [0, 255]
     */
    public ColorHSB(float hue, float saturation, float brightness) {
        assert(hue >= 0f && hue <= 360f);
        assert(saturation >= 0f && saturation <= 255f);
        assert(brightness >= 0f && brightness <= 255f);
        this.hue = hue;
        this.saturation = saturation;
        this.brightness = brightness;
    }

    //~ Method(s) //////////////////////////////////////////////////////////////
    public float getHue() {
        return hue;
    }
    public float getSaturation() {
        return saturation;
    }
    public float getBrightness() {
        return brightness;
    }

    // ~ ///////////////////////////////////////////////////////////////////////
    /**
     * TODO: Only forward hue interpolation supported. -- Support backward as well, depending on distance
     * @param interpolationEnd
     * @param count
     * @return
     */
    @Override
    public List<Color> linearInterpolation(ColorHSB interpolationEnd, int count) {
        final List<ColorHSB> res = new ArrayList<>(count);
        final float step_Brightness = (interpolationEnd.brightness - this.brightness) / count;
        final float step_Hue = (interpolationEnd.hue - this.hue) / count;
        final float step_Sat = (interpolationEnd.saturation - this.saturation) / count;
        
        res.add(this);
        ColorHSB tmpColor;
        for (int i = 1; i < count; i++) {
            tmpColor = res.get(i-1);
            res.add( new ColorHSB(
                    tmpColor.hue + step_Hue, tmpColor.saturation + step_Sat, tmpColor.brightness + step_Brightness
            )) ;
        }
        res.add(interpolationEnd);
        return (List) res;
    }

    // ~ ///////////////////////////////////////////////////////////////////////
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ColorHSB colorHSB = (ColorHSB) o;

        if (Float.compare(colorHSB.brightness, brightness) != 0) return false;
        if (Float.compare(colorHSB.hue, hue) != 0) return false;
        if (Float.compare(colorHSB.saturation, saturation) != 0) return false;
        if (COLOR_SCHEME != colorHSB.COLOR_SCHEME) return false;

        return true;
    }

    public boolean equalsInteger(Color o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ColorHSB colorHSB = (ColorHSB) o;

        if (Integer.compare((int) colorHSB.brightness, (int)brightness) != 0) return false;
        if (Integer.compare((int) colorHSB.hue, (int) hue) != 0) return false;
        if (Integer.compare((int) colorHSB.saturation, (int) saturation) != 0) return false;
        if (COLOR_SCHEME != colorHSB.COLOR_SCHEME) return false;

        return true;
    }
    @Override
    public int hashCode() {
        int result = (brightness != +0.0f ? Float.floatToIntBits(brightness) : 0);
        result = 31 * result + (hue != +0.0f ? Float.floatToIntBits(hue) : 0);
        result = 31 * result + (saturation != +0.0f ? Float.floatToIntBits(saturation) : 0);
        result = 31 * result + (COLOR_SCHEME != null ? COLOR_SCHEME.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ColorHSB{" + "brightness=" + brightness + ", hue=" + hue + ", saturation=" + saturation + '}';
    }

    @Override
    public ColorScheme colorScheme() {
        return COLOR_SCHEME;
    }
    public ColorScheme getColorScheme(){
        return COLOR_SCHEME;
    }
    public void setColorScheme(ColorScheme s){
    }
    //~ Private Artifact(s) ////////////////////////////////////////////////////


}