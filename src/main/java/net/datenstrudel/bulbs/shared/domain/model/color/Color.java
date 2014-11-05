package net.datenstrudel.bulbs.shared.domain.model.color;

import java.util.List;

/**
 * @author Thomas Wendzinski
 * @version 1.0
 * @param <T>
 * @created 08-Jun-2013 23:02:11
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

}