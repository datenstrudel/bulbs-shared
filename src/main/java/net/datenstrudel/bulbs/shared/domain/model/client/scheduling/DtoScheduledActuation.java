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

    public DtoScheduledActuation() {
    }

    /**
     *
     * @param activated
     * @param deleteAfterExecution
     * @param name
     * @param states
     * @param trigger
     */
    public DtoScheduledActuation(Boolean activated, Boolean deleteAfterExecution, String name, List<DtoAbstractActuatorCmd> states, Trigger trigger) {
        this.activated = activated;
        this.deleteAfterExecution = deleteAfterExecution;
        this.name = name;
        this.states = states;
        this.trigger = trigger;
    }

    /**
     * All Args Constructor
     * @param activated
     * @param created
     * @param deleteAfterExecution
     * @param name
     * @param nextTriggerTime
     * @param scheduledActuationId
     * @param states
     * @param trigger
     */
    public DtoScheduledActuation(String scheduledActuationId, Boolean activated, Date created, Boolean deleteAfterExecution, String name, Date nextTriggerTime, List<DtoAbstractActuatorCmd> states, Trigger trigger) {
        this.scheduledActuationId = scheduledActuationId;
        this.activated = activated;
        this.created = created;
        this.deleteAfterExecution = deleteAfterExecution;
        this.name = name;
        this.nextTriggerTime = nextTriggerTime;
        this.states = states;
        this.trigger = trigger;
    }
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DtoScheduledActuation that = (DtoScheduledActuation) o;

        if (activated != null ? !activated.equals(that.activated) : that.activated != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (deleteAfterExecution != null ? !deleteAfterExecution.equals(that.deleteAfterExecution) : that.deleteAfterExecution != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (nextTriggerTime != null ? !nextTriggerTime.equals(that.nextTriggerTime) : that.nextTriggerTime != null)
            return false;
        if (scheduledActuationId != null ? !scheduledActuationId.equals(that.scheduledActuationId) : that.scheduledActuationId != null)
            return false;
        if (states != null ? !states.equals(that.states) : that.states != null) return false;
        if (trigger != null ? !trigger.equals(that.trigger) : that.trigger != null) return false;

        return true;
    }
    @Override
    public int hashCode() {
        int result = scheduledActuationId != null ? scheduledActuationId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (states != null ? states.hashCode() : 0);
        result = 31 * result + (trigger != null ? trigger.hashCode() : 0);
        result = 31 * result + (activated != null ? activated.hashCode() : 0);
        result = 31 * result + (deleteAfterExecution != null ? deleteAfterExecution.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (nextTriggerTime != null ? nextTriggerTime.hashCode() : 0);
        return result;
    }

    //~ Private Artifact(s) ////////////////////////////////////////////////////
}
