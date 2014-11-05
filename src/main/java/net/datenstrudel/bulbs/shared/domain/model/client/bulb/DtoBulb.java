package net.datenstrudel.bulbs.shared.domain.model.client.bulb;

import net.datenstrudel.bulbs.shared.domain.model.bulb.BulbState;

/**
 *
 * @author Thomas Wendzinski
 */
public class DtoBulb {

    //~ Member(s) //////////////////////////////////////////////////////////////
    private String name;
    private String bulbId;
    private Boolean online;
    private BulbState state;
    private DtoBulbBridge bridge;
    
    //~ Construction ///////////////////////////////////////////////////////////
    public DtoBulb() {
    }

    //~ Method(s) //////////////////////////////////////////////////////////////
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getBulbId() {
        return bulbId;
    }
    public void setBulbId(String bulbId) {
        this.bulbId = bulbId;
    }

    public Boolean getOnline() {
        return online;
    }
    public void setOnline(Boolean online) {
        this.online = online;
    }

    public BulbState getState() {
        return state;
    }
    public void setState(BulbState state) {
        this.state = state;
    }

    public DtoBulbBridge getBridge() {
        return bridge;
    }
    public void setBridge(DtoBulbBridge bridge) {
        this.bridge = bridge;
    }
    
    //~ Private Artifact(s) ////////////////////////////////////////////////////
}
