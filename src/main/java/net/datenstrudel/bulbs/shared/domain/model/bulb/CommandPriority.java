package net.datenstrudel.bulbs.shared.domain.model.bulb;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import net.datenstrudel.bulbs.shared.domain.model.ValueObject;

/**
 * A value of {@link BulbActuatorCommand}. This type is used in order to manage concurrent
 * control of Bulbs from different applications. <br /><br />
 * There are two types, <code>STANDARD</code> and <code>OVERRIDE</code>. Usually commands
 * are supposed to have <code>STANDARD</code> priority. In case a concurrent application
 * likes to apply commands it sends the 1st command with <code>OVERRIDE</code> priority
 * to put itself in charge. All subsequent commands shall be sent with 
 * <code>STANDARD</code> priority. This way it is made sure that different applications
 * can control the same bulbs without clashing, due to only commands coming from the application
 * that last sent with ovverride priority are actually executed. 
 * 
 * @author Thomas Wendzinski
 */
@ApiModel(value="Whether to override or not an existing actuation that might currently taking place")
public class CommandPriority implements ValueObject<CommandPriority>{

    //~ Member(s) //////////////////////////////////////////////////////////////
    public static final int OVERRIDE = 0;
    public static final int STANDARD = 1;


    @ApiModelProperty(value = "Override or standard behavior", allowableValues = "0, 1")
    private final int priority;

    @ApiModelProperty(hidden = true)
    private Integer overrideTempMillis;
    
    //~ Construction ///////////////////////////////////////////////////////////
    private CommandPriority() {
        this.priority = 0;
    }
    public CommandPriority(int priority, int durationMillis) {
        if(priority != OVERRIDE)throw new IllegalArgumentException(
                "Priority '"+priority+"' not allowed for this constructor!");
        this.priority = priority;
        this.overrideTempMillis = durationMillis;
    }
    public CommandPriority(int priority) {
        this.priority = priority;
    }
    public static CommandPriority overrideTemporary(int durationMillis){
        CommandPriority res = new CommandPriority(OVERRIDE, durationMillis);
        return res;
    }
    public static CommandPriority standard(){
        return new CommandPriority(STANDARD);
    }
    public static CommandPriority override(){
        return new CommandPriority(OVERRIDE);
    }
    
    //~ Method(s) //////////////////////////////////////////////////////////////
    public int getPriority() {
        return priority;
    }
    public Integer getOverrideTempMillis() {
        return overrideTempMillis;
    }

    private void setOverrideTempMillis(Integer overrideTempMillis) {
        this.overrideTempMillis = overrideTempMillis;
    }
    
    //~ Private Artifact(s) ////////////////////////////////////////////////////

    @Override
    public boolean sameValueAs(CommandPriority other) {
        if(other == null) return false;
        if(this.priority != other.priority)return false;
        if(this.overrideTempMillis == null && other.overrideTempMillis != null)return false;
        if(this.overrideTempMillis != null && other.overrideTempMillis == null)return false;
        if(this.overrideTempMillis != other.overrideTempMillis )return false;
        return true;
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.priority;
        hash = 73 * hash + (this.overrideTempMillis != null ? this.overrideTempMillis.hashCode() : 0);
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
        final CommandPriority other = (CommandPriority) obj;
        return this.sameValueAs(other);
    }
    
    

}
