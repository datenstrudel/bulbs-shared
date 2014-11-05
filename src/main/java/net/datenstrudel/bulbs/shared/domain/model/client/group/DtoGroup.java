package net.datenstrudel.bulbs.shared.domain.model.client.group;

import net.datenstrudel.bulbs.shared.domain.model.client.bulb.DtoBulb;

import java.util.Set;

/**
 *
 * @author Thomas Wendzinski
 */
public class DtoGroup{

    //~ Member(s) //////////////////////////////////////////////////////////////
    private String groupId;
    private String name;
    private Set<String> bulbIds;
    private Set<DtoBulb> bulbs;
    
    //~ Construction ///////////////////////////////////////////////////////////
    public DtoGroup() {
    }
    public DtoGroup(String groupId, String name, Set<String> bulbIds, Set<DtoBulb> bulbs) {
        this.groupId = groupId;
        this.name = name;
        this.bulbIds = bulbIds;
        this.bulbs = bulbs;
    }
    
    //~ Method(s) //////////////////////////////////////////////////////////////
    public String getGroupId() {
        return groupId;
    }
    public String getName() {
        return name;
    }
    public Set<String> getBulbIds() {
        return bulbIds;
    }
    public Set<DtoBulb> getBulbs() {
        return bulbs;
    }
    
    public void setGroupId(String groupId){
        this.groupId = groupId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBulbIds(Set<String> bulbIds) {
        this.bulbIds = bulbIds;
    }
    public void setBulbs(Set<DtoBulb> bulbs) {
        this.bulbs = bulbs;
    }

    //~ Private Artifact(s) ////////////////////////////////////////////////////

}
