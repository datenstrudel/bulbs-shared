package net.datenstrudel.bulbs.shared.domain.model.bulb;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import net.datenstrudel.bulbs.shared.domain.model.ValueObject;
import net.datenstrudel.bulbs.shared.domain.model.color.Color;

import java.io.Serializable;

/**
 * A value object that represents the state of a bulb.
 */
@ApiModel(value = "Defines a single state of a single bulb.")
public class BulbState implements ValueObject<BulbState>, Serializable {

    //~ Member(s) //////////////////////////////////////////////////////////////
    @ApiModelProperty(required = false, value = "Color of this state")
	private Color<?> color;
    @ApiModelProperty(required = false, value = "whether the device is enabled")
    private boolean enabled;
    
    /**
     * Time in milliseconds that expires before application of <code>this</code> state 
     */
    private int transitionDelay = 0;
    
    //~ Construction ///////////////////////////////////////////////////////////
	private BulbState(){
    }
    public BulbState(boolean enabled) {
        this.enabled = enabled;
    }
    public BulbState(Color color, boolean enabled) {
        this.color = color;
        this.enabled = enabled;
    }
    public BulbState(Color color, boolean enabled, int transitionDelay) {
        this.color = color;
        this.enabled = enabled;
        this.transitionDelay = transitionDelay;
    }
    
    public BulbState withNewEnabledState(boolean enabled){
        return new BulbState(this.color, enabled, this.transitionDelay);
    }
    public BulbState withNewColor(Color color){
        return new BulbState(color, enabled, this.transitionDelay);
    }
    public BulbState withTransitionDelay(int transitionDelay){
        return new BulbState(color, enabled, transitionDelay);
    }
    public BulbState withColorAndTransitionDelay(Color color, int transitionDelay){
        return new BulbState(color, enabled, transitionDelay);
    }
    /**
     * Merge the <code>updated</code> state into <code>this</code>', returning a new object,
     * leaving <code>this</code> as is
     * @param updated the new state to merge from
     * @return new merged state
     */
    public BulbState mergeUpdated(BulbState updated){
        BulbState res = this.withNewEnabledState(updated.getEnabled());
        if(updated.getColor() != null ) 
            res.setColor(updated.getColor());
        return res;
    }

    //~ Method(s) //////////////////////////////////////////////////////////////
    public Color getColor(){
		return color;
	}
	public boolean getEnabled(){
		return enabled;
	}
    public int getTransitionDelay() {
        return transitionDelay;
    }
    
    @Override
	public boolean sameValueAs(BulbState other){
		if(other == null) return false;
        return this.equals(other);
	}
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.color != null ? this.color.hashCode() : 0);
        hash = 67 * hash + (this.enabled ? 1 : 0);
        hash = 67 * hash + this.transitionDelay;
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        final BulbState other = (BulbState) obj;
        if (this.color != other.color && (this.color == null || !this.color.equals(other.color))) {
            return false;
        }
        if (this.enabled != other.enabled) {
            return false;
        }
        if (this.transitionDelay != other.transitionDelay) {
            return false;
        }
        return true;
    }
    public boolean equalsInteger(Object obj) {
        if(this == obj) return true;
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        final BulbState other = (BulbState) obj;
        if (this.color != other.color && (this.color == null || !this.color.equalsInteger(other.color))) {
            return false;
        }
        if (this.enabled != other.enabled) {
            return false;
        }
        if (this.transitionDelay != other.transitionDelay) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "BulbState{" 
                + "color=" + color 
                + ", enabled=" + enabled 
                + ", transitionDelay=" + transitionDelay
                + '}';
    }
    
    
    //~ Private Artifact(s) ////////////////////////////////////////////////////
    private void setColor(Color color) {
        this.color = color;
    }
    private void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    private void setTransitionDelay(int transitionDelay) {
        this.transitionDelay = transitionDelay;
    }
    
}