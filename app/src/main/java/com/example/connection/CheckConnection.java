package com.example.connection;

import java.net.InetAddress;

public final class CheckConnection {
    public boolean isConnected() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }

    }

}
