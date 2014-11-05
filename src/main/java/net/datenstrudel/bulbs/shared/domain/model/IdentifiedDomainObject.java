package net.datenstrudel.bulbs.shared.domain.model;

import java.io.Serializable;

/**
 *
 * @param <ID> 
 * @author Thomas Wendzinski
 */
public abstract class IdentifiedDomainObject<ID> implements Serializable{
    //~ Member(s) //////////////////////////////////////////////////////////////
    private ID id;
    private Long version;
    
    //~ Construction ///////////////////////////////////////////////////////////
    public IdentifiedDomainObject() {
    }

    //~ Method(s) //////////////////////////////////////////////////////////////
    public  ID getId() {
        return id;
    }
    protected void setId(ID id) {
        this.id = id;
    }

    protected Long getVersion() {
        return version;
    }
    protected void setVersion(Long version) {
        this.version = version;
    }
    
    //~ Private Artifact(s) ////////////////////////////////////////////////////
	

}
