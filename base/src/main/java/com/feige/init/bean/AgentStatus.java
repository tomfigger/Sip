package com.feige.init.bean;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;

import java.io.Serializable;

public class AgentStatus implements ExtensionElement , Serializable {
    private int maxChats;
    private int currentChats;
    private String chatShow;

    public void setMaxChats(int maxChats) {
        this.maxChats = maxChats;
    }

    public int getMaxChats() {
        return maxChats;
    }

    public void setCurrentChats(int currentChats) {
        this.currentChats = currentChats;
    }

    public int getCurrentChats() {
        return currentChats;
    }

    public static final String NAMESPACE = "http://jabber.org/protocol/workgroup";
    public static final String ELEMENT = "agent-status";

    @Override
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override
    public String getElementName() {
        return ELEMENT;
    }

    @Override
    public CharSequence toXML(XmlEnvironment xmlEnvironment) {
        return null;
    }

    public void setChatShow(String chatShow) {
        this.chatShow = chatShow;
    }

    public String getChatShow() {
        return chatShow;
    }
}
