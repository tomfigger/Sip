package com.feige.init.bean;

import org.jivesoftware.smack.packet.Presence;

public class PresenceType {
    /**
     * An enum to represent the presence mode.
     */

    /**
     * Free to chat.
     */
    public static String connecting = "connecting";


    public static String available = Presence.Type.available.name();
    public static String unavailable = Presence.Type.unavailable.name();


}
