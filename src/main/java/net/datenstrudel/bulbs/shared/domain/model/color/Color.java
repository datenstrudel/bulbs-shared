package net.datenstrudel.bulbs.shared.domain.model.color;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.wordnik.swagger.annotations.ApiModel;

import java.util.List;

/**
 * @author Thomas Wendzinski
 * @param <T>
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "colorScheme")
@JsonSubTypes({
        @Type(value = ColorHSB.class, name = "HSB"),
        @Type(value = ColorRGB.class, name = "RGB") })
@ApiModel(
        subTypes = {ColorRGB.class, ColorHSB.class},
        discriminator = "type",
        description = "Abstract base command for bulb controls of any kind."
)
public abstract class Color<T extends Color>{

    /**
     * @return the color scheme that a specific realization of this interface represents.
     */
	public abstract ColorScheme colorScheme();
    /**
     * Linear interpolation from <code>this</code> to <code>interpolationEnd</code>
     * @param interpolationEnd
     * @param count
     * @return 
     */
    public abstract List<Color> linearInterpolation(T interpolationEnd, int count);

    /**
     * @param other
     * @return whether <code>this</code>' color values equal <code>other</code>s by taking only
     * its integer value representations into account.
     */
    public boolean equalsInteger(Color other){
        return false;
    }

}