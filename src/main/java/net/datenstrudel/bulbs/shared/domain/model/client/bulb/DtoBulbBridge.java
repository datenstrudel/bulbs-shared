package net.datenstrudel.bulbs.shared.domain.model.client.bulb;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import net.datenstrudel.bulbs.shared.domain.model.bulb.BulbBridgeAddress;
import net.datenstrudel.bulbs.shared.domain.model.bulb.BulbsPlatform;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Thomas Wendzinski
 */
@ApiModel(
    description = "Represents devices' controller of a specific vendor(platform)"
)
public class DtoBulbBridge {

    //~ Member(s) //////////////////////////////////////////////////////////////
    /** Used as ID as well */
    private String bridgeId;
    private String macAddress;
    private String name;
    @NotNull
    @Valid
    @ApiModelProperty(required = true, value="IP address of this device controller")
    private BulbBridgeAddress localAddress;
    @NotNull
    @ApiModelProperty(required = true,value="Of what venodr is this controller", allowableValues = "_EMULATED , PHILIPS_HUE")
    private BulbsPlatform platform;
    private Boolean online;
    private Integer countBulbs;
    
    //~ Construction ///////////////////////////////////////////////////////////
    public DtoBulbBridge() {
    }
    
    //~ Method(s) //////////////////////////////////////////////////////////////
    public String getBridgeId() {
        return bridgeId;
    }
    public void setBridgeId(String id) {
        this.bridgeId = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getMacAddress() {
        return macAddress;
    }
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public BulbBridgeAddress getLocalAddress() {
        return localAddress;
    }
    public void setLocalAddress(BulbBridgeAddress localAddress) {
        this.localAddress = localAddress;
    }

    public BulbsPlatform getPlatform() {
        return platform;
    }
    public void setPlatform(BulbsPlatform platform) {
        this.platform = platform;
    }

    public Boolean isOnline() {
        return online;
    }
    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Integer getCountBulbs() {
        return countBulbs;
    }
    public void setCountBulbs(Integer countBulbs) {
        this.countBulbs = countBulbs;
    }
    

}
