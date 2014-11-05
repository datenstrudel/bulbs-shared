package net.datenstrudel.bulbs.shared.domain.model;

/**
 * @param <T> Type of realizing class.
 * @author Thomas Wendzinski
 * @version 1.0
 * @created 08-Jun-2013 23:02:11
 */
public interface ValueObject<T> {

	/**
	 * 
     * @param other
     * @return whether <code>other</code> is the same value as <code>this</code>. That applies
     * when all members of the objects compared are equal.
	 */
	public boolean sameValueAs(T other);

}