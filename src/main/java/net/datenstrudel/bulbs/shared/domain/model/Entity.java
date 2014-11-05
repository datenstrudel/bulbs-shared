package net.datenstrudel.bulbs.shared.domain.model;

import java.io.Serializable;

/**
 *
 * @param <T> implementing class type
 * @param <ID> 
 * @author Thomas Wendzinski
 */
public abstract class Entity<T extends Entity, ID> extends IdentifiedDomainObject<ID> 
        implements Serializable {

    //~ Member(s) //////////////////////////////////////////////////////////////
    //~ Construction ///////////////////////////////////////////////////////////
    //~ Method(s) //////////////////////////////////////////////////////////////
    /**
     * Entities compare by identity, not by attributes.
     *
     * @param other The other entity.
     * @return true if the identities are the same, regardles of other attributes.
     */
    public boolean sameIdentityAs(T other){
        if(other == null) return false;
        return this.getId().equals(other.getId());
    }

    //~ Private Artifact(s) ////////////////////////////////////////////////////
}
