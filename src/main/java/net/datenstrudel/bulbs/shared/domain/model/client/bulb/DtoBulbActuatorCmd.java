package net.datenstrudel.bulbs.shared.domain.model.client.bulb;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import net.datenstrudel.bulbs.shared.domain.model.bulb.BulbState;
import net.datenstrudel.bulbs.shared.domain.model.bulb.CommandPriority;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

/**
 * Wraps all information necessary in order to invoke the change of a Bulb's state.
 */
@ApiModel(
        description = "Concrete actuation command to address one specific bulb.",
        parent=DtoAbstractActuatorCmd.class,
        discriminator = "type"
)
public class DtoBulbActuatorCmd
        extends DtoAbstractActuatorCmd<DtoBulbActuatorCmd>{

    //~ Member(s) //////////////////////////////////////////////////////////////
    @NotNull
    @Size(min=36)
	private String bulbId;

    @ApiModelProperty(allowableValues = "BULB", position = 1, required = true)
    private String type = "BULB";
    
    //~ Construction ///////////////////////////////////////////////////////////
    public DtoBulbActuatorCmd(){}
    public DtoBulbActuatorCmd(String bulbId, String appId, CommandPriority priority, List<BulbState> states, boolean loop) {
        super(appId, priority, states, loop);
        this.bulbId = bulbId;
    }

    //~ Method(s) //////////////////////////////////////////////////////////////
    public String getBulbId() {
        return bulbId;
    }
    public void setBulbId(String bulbId) {
        this.bulbId = bulbId;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean sameValueAs(DtoBulbActuatorCmd other) {
        return this.equals(other);
    }
    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 97 * hash + (this.bulbId != null ? this.bulbId.hashCode() : 0);
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
        final DtoBulbActuatorCmd other = (DtoBulbActuatorCmd) obj;
        if( !super.equals(obj))return false;
        if (!Objects.equals(this.bulbId, other.bulbId)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "BulbActuatorCommand{" 
                + "appId=" + appId 
                + ", bulbId=" + bulbId 
//                + ", userApiKey=" + userApiKey 
                + ", priority=" + priority 
                + ", states=" + states 
            + '}';
    }
    
    //~ Private Artifact(s) ////////////////////////////////////////////////////
}