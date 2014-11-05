package net.datenstrudel.bulbs.shared.domain.model.client.preset;

import net.datenstrudel.bulbs.shared.domain.model.client.bulb.DtoAbstractActuatorCmd;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thomas Wendzinski
 */
public class DtoPreset{

    //~ Member(s) //////////////////////////////////////////////////////////////
    private String presetId;
    @NotNull
    private String name;
    @NotNull
    @Size(min = 1)
    private List<DtoAbstractActuatorCmd> states = new ArrayList<>();

    //~ Construction ///////////////////////////////////////////////////////////
    public DtoPreset() {
    }
    
    //~ Method(s) //////////////////////////////////////////////////////////////

    public String getPresetId() {
        return presetId;
    }
    public void setPresetId(String presetId) {
        this.presetId = presetId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<DtoAbstractActuatorCmd> getStates() {
        return states;
    }
    public void setStates(List<DtoAbstractActuatorCmd> states) {
        this.states = states;
    }
    
    //~ Private Artifact(s) ////////////////////////////////////////////////////
}
