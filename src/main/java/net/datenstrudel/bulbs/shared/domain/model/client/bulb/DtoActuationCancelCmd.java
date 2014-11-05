package net.datenstrudel.bulbs.shared.domain.model.client.bulb;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Thomas Wendzinski
 */
@ApiModel(
        value="Cancel actuation on supplied device ids",
        description = "Concrete actuation command to address one specific bulb.",
        parent=DtoAbstractActuatorCmd.class,
        discriminator = "type"
)
public class DtoActuationCancelCmd 
        extends DtoAbstractActuatorCmd<DtoActuationCancelCmd>{

    //~ Member(s) //////////////////////////////////////////////////////////////
    @ApiModelProperty(required = true, value = "Device IDs to stop applying transitions to")
    @NotNull
    private Set<String> entityIds;
    @ApiModelProperty(required = true,  allowableValues = "CANCEL",  position = 1)
    private String type = "CANCEL";
    
    //~ Construction ///////////////////////////////////////////////////////////
    public DtoActuationCancelCmd() {
    }

    public Set<String> getEntityIds() {
        return entityIds;
    }
    public void setEntityIds(Set<String> entityIds) {
        this.entityIds = entityIds;
    }

    //~ Method(s) //////////////////////////////////////////////////////////////
    @Override
    public String getType() {
        return type;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 79 * hash + Objects.hashCode(this.entityIds);
        hash = 79 * hash + Objects.hashCode(this.type);
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj)return true;
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DtoActuationCancelCmd other = (DtoActuationCancelCmd) obj;
        if( !super.equals(obj))return false;
        if (!Objects.equals(this.entityIds, other.entityIds)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }
    @Override
    public boolean sameValueAs(DtoActuationCancelCmd other) {
        return this.equals(other);
    }
    

}
