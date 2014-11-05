package net.datenstrudel.bulbs.shared.domain.model.client.preset;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import net.datenstrudel.bulbs.shared.domain.model.bulb.BulbState;
import net.datenstrudel.bulbs.shared.domain.model.bulb.CommandPriority;
import net.datenstrudel.bulbs.shared.domain.model.client.bulb.DtoAbstractActuatorCmd;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Thomas Wendzinski
 */
@ApiModel(
        value="Apply a preset",
        parent=DtoAbstractActuatorCmd.class,
        discriminator = "type"
)
public class DtoPresetActuatorCmd extends DtoAbstractActuatorCmd<DtoPresetActuatorCmd>{

    //~ Member(s) //////////////////////////////////////////////////////////////
    @ApiModelProperty(required = true, value = "Preset ID")
    @Size(min=36)
    private String presetId;
    @ApiModelProperty(required = true, allowableValues = "PRESET", position = 1)
    private String type = "PRESET";

    //~ Construction ///////////////////////////////////////////////////////////
    public DtoPresetActuatorCmd() {
    }
    public DtoPresetActuatorCmd(
            String presetId,
            String appId,
            CommandPriority priority,
            List<BulbState> states,
            boolean loop) {
        super(appId, priority, states, loop);
        this.presetId = presetId;
    }
    
    //~ Method(s) //////////////////////////////////////////////////////////////
    
    @Override
    public String getType() {
        return type;
    }
    
    public String getPresetId() {
        return presetId;
    }
    public void setPresetId(String presetId) {
        this.presetId = presetId;
    }
    
    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 29 * hash + Objects.hashCode(this.presetId);
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
        final DtoPresetActuatorCmd other = (DtoPresetActuatorCmd) obj;
        if(! super.equals(obj))return false;
        if (!Objects.equals(this.presetId, other.presetId)) {
            return false;
        }
        return true;
    }
    @Override
    public boolean sameValueAs(DtoPresetActuatorCmd other) {
        return this.equals(other);
    }

    //~ Private Artifact(s) ////////////////////////////////////////////////////
}
