package net.datenstrudel.bulbs.shared.domain.model.bulb;
import net.datenstrudel.bulbs.shared.domain.model.ValueObject;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Value that contains address data in order to communicate with BulbBridge
 * Hardware
 * @author Thomas Wendzinski
 * @version 1.0
 * @created 08-Jun-2013 23:02:11
 */
public class BulbBridgeAddress implements ValueObject<BulbBridgeAddress>, Serializable {
    //~ Member(s) //////////////////////////////////////////////////////////////
    @NotNull @Size(min = 3)
	private String host;
    @NotNull @Min(1) @Max(65535)
	private Integer port;
    
    //~ Construction ///////////////////////////////////////////////////////////
	private BulbBridgeAddress(){}
    public BulbBridgeAddress(String host, Integer port) {
        setHost(host);
        setPort(port);
    }

    //~ Method(s) //////////////////////////////////////////////////////////////
    public String getHost() {
        return host;
    }
    public Integer getPort() {
        return port;
    }
    
    public String toHttpAddress(){
        return "http://" + host + ":" + port + "/";
    }
    
    @Override
    public boolean sameValueAs(BulbBridgeAddress other) {
        if(other == null)return false;
        if(!host.equals(other.host))return false;
        if(!port.equals(other.port))return false;
        return true;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.host != null ? this.host.hashCode() : 0);
        hash = 89 * hash + (this.port != null ? this.port.hashCode() : 0);
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
        final BulbBridgeAddress other = (BulbBridgeAddress) obj;
        return this.sameValueAs(other);
    }
    @Override
    public String toString() {
        return "BulbBridgeAddress{" + toHttpAddress() + "}";
    }
    
    //~ Private Artifact(s) ////////////////////////////////////////////////////
    private void setHost(String host) {
        if(host.startsWith("http://"))
            this.host = host.replace("http://", "");
        this.host = host;
    }
    private void setPort(Integer port) {
        this.port = port;
    }
    

}