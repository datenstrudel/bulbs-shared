package net.datenstrudel.bulbs.shared.domain.model.bulb;

import net.datenstrudel.bulbs.shared.domain.model.ValueObject;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.BitSet;
import java.util.Optional;

/**
 * Value that contains address data in order to communicate with BulbBridge
 * Hardware
 */
public class BulbBridgeAddress implements ValueObject<BulbBridgeAddress>, Serializable {
    //~ Member(s) //////////////////////////////////////////////////////////////
    @NotNull @Size(min = 3)
	private String host;
    @NotNull @Min(1) @Max(65535)
	private Integer port;

    private String macAddress;
    
    //~ Construction ///////////////////////////////////////////////////////////
	private BulbBridgeAddress(){}
    public BulbBridgeAddress(String host, Integer port) {
        setHost(host);
        setPort(port);
    }
    public BulbBridgeAddress(String host, Integer port, String macAddress) {
        setHost(host);
        setPort(port);
        setMacAddress(macAddress);
    }

    //~ Method(s) //////////////////////////////////////////////////////////////
    public String getHost() {
        return host;
    }
    public Integer getPort() {
        return port;
    }
    private String getMacAddress() {
        return macAddress;
    }
    public Optional<String> macAddress() {
        return Optional.ofNullable(macAddress);
    }

    public String toHttpAddress(){
        return "http://" + host + ":" + port + "/";
    }
    public InetAddress toInetAddress() {
        try {
            return InetAddress.getByName(host);
        } catch (UnknownHostException e) {
            throw new RuntimeException("Unknown host: " + host);
        }
    }

    /**
     * @return <code>This'</code> address broadcast address representation with
     * subnet mask <code>255.255.255.0</code>
     */
    public InetAddress toBroadcastAddress(){
        byte[] addressHost = toInetAddress().getAddress();
        BitSet res = BitSet.valueOf(new byte[]{0, 0, 0, -1}); // flipped
        res.or(BitSet.valueOf(addressHost));
        try{
            return InetAddress.getByAddress(res.toByteArray());
        } catch (UnknownHostException e) {
            throw new RuntimeException("Unknown host: " + host);
        }
    }

    /**
     * @param subnetMask which the broadcast address is based on
     * @return The boradcast address of <code>this</code> by applying
     * given <code>subnetMask</code>
     */
    protected InetAddress toBroadcastAddress(InetAddress subnetMask){
        byte[] addressHost = toInetAddress().getAddress();
        byte[] sMask =  subnetMask.getAddress();

        for(int i = 0; i < sMask.length; i++){
            sMask[i]= (byte) ~sMask[i];
        }

        BitSet res = BitSet.valueOf(sMask);
        res.or(BitSet.valueOf(addressHost));
        try{
            return InetAddress.getByAddress(res.toByteArray());
        } catch (UnknownHostException e) {
            throw new RuntimeException("Unknown host: " + host);
        }
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
    private void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }


}