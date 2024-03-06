package com.feige.init.bean;

import org.jivesoftware.smack.packet.Presence;

public class PresenceMode {
    /**
     * An enum to represent the presence mode.
     */

    /**
     * Free to chat.
     */
    public static String chat = Presence.Mode.chat.name();


    public static String dnd = Presence.Mode.dnd.name();
    public static String away = Presence.Mode.away.name();


}
