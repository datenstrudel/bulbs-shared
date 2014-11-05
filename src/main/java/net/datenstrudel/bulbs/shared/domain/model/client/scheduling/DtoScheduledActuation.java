package net.datenstrudel.bulbs.shared.domain.model.client.scheduling;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import net.datenstrudel.bulbs.shared.domain.model.client.bulb.DtoAbstractActuatorCmd;
import net.datenstrudel.bulbs.shared.domain.model.scheduling.Trigger;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Thomas Wendzinski
 */
@ApiModel(value = "Define which commands shall be executed _when_.")
public class DtoScheduledActuation {

    //~ Member(s) //////////////////////////////////////////////////////////////
    private String scheduledActuationId;

    @ApiModelProperty(required = true)
    private String name;

    @NotNull
    @Size(min = 1)
    @Valid
    @ApiModelProperty(required = true)
    private List<DtoAbstractActuatorCmd> states;

    @NotNull
    @Valid
    @ApiModelProperty(required = true)
    private Trigger trigger;

    private Boolean activated;
    private Boolean deleteAfterExecution = true;

    @ApiModelProperty(hidden = true)
    private Date created;
    @ApiModelProperty(hidden = true)
    private Date nextTriggerTime;

    //~ Construction ///////////////////////////////////////////////////////////
    //~ Method(s) //////////////////////////////////////////////////////////////
    public String getScheduledActuationId() {
        return scheduledActuationId;
    }
    public void setScheduledActuationId(String scheduledActuationId) {
        this.scheduledActuationId = scheduledActuationId;
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

    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    public Boolean isDeleteAfterExecution() {
        return deleteAfterExecution;
    }
    public void setDeleteAfterExecution(Boolean deleteAfterExecution) {
        this.deleteAfterExecution = deleteAfterExecution;
    }

    public Trigger getTrigger() {
        return trigger;
    }
    public void setTrigger(Trigger Trigger) {
        this.trigger = Trigger;
    }
    
    public Date getNextTriggerTime() {
        return nextTriggerTime;
    }
    public void setNextTriggerTime(Date nextTriggerTime) {
        this.nextTriggerTime = nextTriggerTime;
    }
    
    public Boolean isActivated() {
        return activated;
    }
    public void setActivated(Boolean activated) {
        this.activated = activated;
    }
    
    //~ Private Artifact(s) ////////////////////////////////////////////////////

    
}
