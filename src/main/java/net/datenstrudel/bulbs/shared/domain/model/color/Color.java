package net.datenstrudel.bulbs.shared.domain.model.color;

import java.util.List;

/**
 * @author Thomas Wendzinski
 * @param <T>
 */
public abstract class Color<T extends Color>{

    /**
     * @return the color scheme a specific realization of this interface represents.
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