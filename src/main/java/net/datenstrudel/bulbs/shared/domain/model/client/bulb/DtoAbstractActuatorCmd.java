package net.datenstrudel.bulbs.shared.domain.model.client.bulb;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import net.datenstrudel.bulbs.shared.domain.model.ValueObject;
import net.datenstrudel.bulbs.shared.domain.model.bulb.BulbState;
import net.datenstrudel.bulbs.shared.domain.model.bulb.CommandPriority;
import net.datenstrudel.bulbs.shared.domain.model.client.group.DtoGroupActuatorCmd;
import net.datenstrudel.bulbs.shared.domain.model.client.preset.DtoPresetActuatorCmd;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Thomas Wendzinski
 * @param <T>
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @Type(value = DtoBulbActuatorCmd.class, name = "BULB"),
        @Type(value = DtoGroupActuatorCmd.class, name = "GROUP"),
        @Type(value = DtoPresetActuatorCmd.class, name = "PRESET"),
        @Type(value = DtoActuationCancelCmd.class, name = "CANCEL") })
@ApiModel(
        subTypes = {DtoBulbActuatorCmd.class, DtoActuationCancelCmd.class, DtoGroupActuatorCmd.class, DtoPresetActuatorCmd.class},
        discriminator = "type",
        description = "Abstract base command for bulb controls of any kind."
)
public abstract class DtoAbstractActuatorCmd<T extends DtoAbstractActuatorCmd>
        implements ValueObject<T>, Serializable{

    //~ Member(s) //////////////////////////////////////////////////////////////
    @NotNull
    @ApiModelProperty(required = true)
    protected String appId;
    @ApiModelProperty(required = false, allowableValues = "0,1")
    protected CommandPriority priority = CommandPriority.standard();
    /**
	 * Contains a bunch of states that are applied sequentially. The time between two
	 * changes is defined in <code>transitionDelay</code>.
	 * The list must contain at least one element.
	 */
    @Size(min = 1)
    @ApiModelProperty(required = true)
    protected List<BulbState> states;
    @ApiModelProperty(required = false)
    protected boolean loop = false;

    //~ Construction ///////////////////////////////////////////////////////////
    public DtoAbstractActuatorCmd() {
    }
    public DtoAbstractActuatorCmd(
            String appId,
            CommandPriority priority,
            List<BulbState> states, 
            boolean loop) {
        this.appId = appId;
        this.priority = priority;
        this.states = states;
        this.loop = loop;
    }
    
    //~ Method(s) //////////////////////////////////////////////////////////////
    /**
     * @return Type discriminator that helps JSON deserializer to find specific type of
     * <code>DtoAbstractActuatorCmd</code>
     */
    public abstract String getType();

    public String getAppId() {
        return appId;
    }
    public void setAppId(String appId) {
        this.appId = appId;
    }

    public CommandPriority getPriority() {
        return priority;
    }
    public void setPriority(CommandPriority priority) {
        this.priority = priority;
    }

    public List<BulbState> getStates() {
        return states;
    }
    public void setStates(List<BulbState> states) {
        this.states = states;
    }
    
    public boolean isLoop() {
        return loop;
    }
    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.appId != null ? this.appId.hashCode() : 0);
        hash = 41 * hash + (this.priority != null ? this.priority.hashCode() : 0);
        hash = 41 * hash + (this.states != null ? this.states.hashCode() : 0);
        hash = 41 * hash + (this.loop ? 1 : 0 );
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if ( !(obj instanceof DtoAbstractActuatorCmd) ) {
            return false;
        }
        final DtoAbstractActuatorCmd<?> other = (DtoAbstractActuatorCmd<?>) obj;
        if (this.appId != other.appId && (this.appId == null || !this.appId.equals(other.appId))) {
            return false;
        }
        if (this.priority != other.priority && (this.priority == null || !this.priority.equals(other.priority))) {
            return false;
        }
        if (this.states != other.states && (this.states == null || !this.states.equals(other.states))) {
            return false;
        }
        if (this.loop != other.loop) {
            return false;
        }
        return true;
    }
    
    //~ Private Artifact(s) ////////////////////////////////////////////////////
    
}
