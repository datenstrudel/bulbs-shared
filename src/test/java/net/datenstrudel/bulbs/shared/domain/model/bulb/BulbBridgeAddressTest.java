package net.datenstrudel.bulbs.shared.domain.model.bulb;

import org.junit.Test;

import java.net.Inet4Address;
import java.net.InetAddress;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BulbBridgeAddressTest {

    @Test
    public void toInetAddressBroadcast_WithGivenSubnetMask() throws Exception {
        BulbBridgeAddress address = new BulbBridgeAddress("192.168.1.2", -1);

        InetAddress actual = address.toBroadcastAddress(Inet4Address.getByName("255.255.255.0"));
        System.out.println("Actual: " + actual);
        assertThat(actual, is(Inet4Address.getByName("192.168.1.255")));
    }



}