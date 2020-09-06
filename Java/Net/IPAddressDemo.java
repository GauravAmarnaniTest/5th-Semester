//Author : Gaurav Amarnani.

import java.net.*;
import static java.lang.System.out;

public class IPAddressDemo {
    public static void main(String...args) {
        try {
            InetAddress[] inetAddresses = InetAddress.getAllByName("www.abc.com");
            for(int i = 0; i<inetAddresses.length; i++) {
                out.println("IP Address no. " + (i+1) + "\nIP Address : "  + inetAddresses[i]);
            }
        }
        catch (Exception e) {
            out.println("Exception : " + e);
        }
    }
}