package net.datenstrudel.bulbs.shared.domain.model;

/**
 * @param <T> Type of realizing class.
 */
public interface ValueObject<T> {

	/**
     * @param other to compare
     * @return whether <code>other</code> is the same value as <code>this</code>. That applies
     * when all members of the objects compared are equal.
	 */
	public boolean sameValueAs(T other);

}