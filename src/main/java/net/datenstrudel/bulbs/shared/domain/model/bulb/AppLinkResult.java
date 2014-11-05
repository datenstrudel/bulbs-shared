package net.datenstrudel.bulbs.shared.domain.model.bulb;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thomas Wendzinski
 * @deprecated 
 */
public class AppLinkResult {

    //~ Member(s) //////////////////////////////////////////////////////////////
    String apiKey;
    /* BridgeId + '-' + bridge.name => linked*/
    Map<String, Boolean> linkStates = new HashMap<String, Boolean>();
    /* BridgeId + '-' + bridge.name => error message */
    Map<String, String> linkErrors = new HashMap<String, String>();
    
    
    //~ Construction ///////////////////////////////////////////////////////////
    private AppLinkResult(){}
    public AppLinkResult(String apiKey) {
        this.apiKey = apiKey;
    }

    //~ Method(s) //////////////////////////////////////////////////////////////
    /**
     * @return the apiKey that authenticates the app that was linked for 
     * further requests.
     */
    public String getApiKey() {
        return apiKey;
    }
    public Map<String, Boolean> getLinkStates() {
        return linkStates;
    }
    /**
     * @param bridge should contain unique bridge ID concatenated with a dash and its name.
     * @param state whether link was established
     */
    public void addLinkState(String bridge, boolean state){
        linkStates.put(bridge, state);
    }

    public Map<String, String> getLinkErrors() {
        return linkErrors;
    }
    public void addLinkError(String bridge, String errorMsg){
        linkErrors.put(bridge, errorMsg);
    }
    
    //~ Private Artifact(s) ////////////////////////////////////////////////////
    private void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
    private void setLinkStates(Map<String, Boolean> linkStates) {
        this.linkStates = linkStates;
    }
    private void setLinkErrors(Map<String, String> linkErrors) {
        this.linkErrors = linkErrors;
    }
    

}
