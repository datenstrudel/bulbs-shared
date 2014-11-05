package net.datenstrudel.bulbs.shared.domain.model.identity;

import net.datenstrudel.bulbs.shared.domain.model.ValueObject;

import java.io.Serializable;

/**
 *
 * @author Thomas Wendzinski
 */
public class AppId implements ValueObject<AppId>, Serializable{

    //~ Member(s) //////////////////////////////////////////////////////////////
    private String uniqueAppName;

    //~ Construction ///////////////////////////////////////////////////////////
    public AppId() {
    }
    public AppId(String uniqueAppName) {
        this.uniqueAppName = uniqueAppName;
    }
    
    //~ Method(s) //////////////////////////////////////////////////////////////
    public String getUniqueAppName() {
        return uniqueAppName;
    }
    private void setUniqueAppName(String uniqueAppName) {
        this.uniqueAppName = uniqueAppName;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.uniqueAppName != null ? this.uniqueAppName.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AppId other = (AppId) obj;
        if ((this.uniqueAppName == null) ? (other.uniqueAppName != null) : !this.uniqueAppName.equals(other.uniqueAppName)) {
            return false;
        }
        return true;
    }
    public boolean sameValueAs(AppId other) {
        return this.equals(other);
    }
    @Override
    public String toString() {
        return uniqueAppName;
    }
    
    //~ Private Artifact(s) ////////////////////////////////////////////////////






}
