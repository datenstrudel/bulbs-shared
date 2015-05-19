package net.datenstrudel.bulbs.shared.domain.model.client.group;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import net.datenstrudel.bulbs.shared.domain.model.bulb.BulbState;
import net.datenstrudel.bulbs.shared.domain.model.bulb.CommandPriority;
import net.datenstrudel.bulbs.shared.domain.model.client.bulb.DtoAbstractActuatorCmd;

import javax.validation.constraints.Size;
import java.util.List;

/**
 *
 * @author Thomas Wendzinski
 */
@ApiModel(
        description = "Control a group of bulbs by their respetive group ID. This way you can simultaneously control devices.",
        parent=DtoAbstractActuatorCmd.class,
        discriminator = "type"
)
public class DtoGroupActuatorCmd
        extends DtoAbstractActuatorCmd<DtoGroupActuatorCmd> {

    //~ Member(s) //////////////////////////////////////////////////////////////
    @ApiModelProperty(required = true)
    @Size(min=36)
	private String groupId;
    @ApiModelProperty(required = true,  allowableValues = "GROUP",  position = 1)
    private String type = "GROUP";
	
    //~ Construction ///////////////////////////////////////////////////////////
	public DtoGroupActuatorCmd(){}
    public DtoGroupActuatorCmd(
            String groupId,
            String appId,
            CommandPriority priority,
            List<BulbState> states,
            boolean loop) {
        super(appId, priority, states, loop);
        this.groupId = groupId;
    }
    
    
    //~ Method(s) //////////////////////////////////////////////////////////////
    @Override
    public String getType() {
        return type;
    }
    
    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    
    @Override
    public boolean sameValueAs(DtoGroupActuatorCmd other) {
        return this.equals(other);
    }
    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 97 * hash + (this.groupId != null ? this.groupId.hashCode() : 0);
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
        final DtoGroupActuatorCmd other = (DtoGroupActuatorCmd) obj;
        if(!super.equals(obj))return false;
        if (this.groupId != other.groupId && (this.groupId == null || !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "BulbActuatorCommand{" 
                + "appId=" + appId 
                + ", groupId=" + groupId 
                + ", priority=" + priority
                + ", states=" + states 
            + '}';
    }
    //~ Private Artifact(s) ////////////////////////////////////////////////////
}
