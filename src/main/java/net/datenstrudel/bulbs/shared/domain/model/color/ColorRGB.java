package net.datenstrudel.bulbs.shared.domain.model.color;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author Thomas Wendzinski
 * @version 1.0
 */
@ApiModel(
        value="RGB a.k.a. Red-Green-Blue color implementation",
        parent= Color.class,
        discriminator = "COLOR_SCHEME"
)
public class ColorRGB extends Color<ColorRGB> implements Serializable {

    //~ Member(s) //////////////////////////////////////////////////////////////
    @ApiModelProperty(allowableValues = "0,255", required = true)
    private int red;
    @ApiModelProperty(allowableValues = "0,255", required = true)
    private int green;
    @ApiModelProperty(allowableValues = "0,255", required = true)
    private int blue;
    @ApiModelProperty(allowableValues = "RGB", required = true, position = 1)
    private final ColorScheme COLOR_SCHEME = ColorScheme.RGB;

    //~ Construction ///////////////////////////////////////////////////////////
    public ColorRGB() {
    }
    public ColorRGB(int red, int green, int blue) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }
    
    //~ Method(s) //////////////////////////////////////////////////////////////
    public int getRed() {
        return red;
    }
    public int getGreen() {
        return green;
    }
    public int getBlue() {
        return blue;
    }

    // ~ ///////////////////////////////////////////////////////////////////////
    @Override
    public List<Color> linearInterpolation(ColorRGB interpolationEnd, int count) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    // ~ ///////////////////////////////////////////////////////////////////////
    public ColorScheme colorScheme(){
		return COLOR_SCHEME;
	}
    public ColorScheme getColorScheme(){
        return COLOR_SCHEME;
    }
    public void setColorScheme(ColorScheme s){
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ColorRGB colorRGB = (ColorRGB) o;

        if (blue != colorRGB.blue) return false;
        if (green != colorRGB.green) return false;
        if (red != colorRGB.red) return false;
        if (COLOR_SCHEME != colorRGB.COLOR_SCHEME) return false;

        return true;
    }
    @Override
    public int hashCode() {
        int result = red;
        result = 31 * result + green;
        result = 31 * result + blue;
        result = 31 * result + (COLOR_SCHEME != null ? COLOR_SCHEME.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ColorRGB{" + "r=" + red + ", g=" + green + ", b=" + blue + '}';
    }

    //~ Private Artifact(s) ////////////////////////////////////////////////////
    private void setRed(int red) {
        assert(red <= 255 && red >=0);
        this.red = red;
    }
    private void setGreen(int green) {
        assert(green <= 255 && green >=0);
        this.green = green;
    }
    private void setBlue(int blue) {
        assert(blue <= 255 && blue >=0);
        this.blue = blue;
    }
    
    
    

    

}