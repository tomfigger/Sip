package com.feige.init.bean;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChatLineUp implements ExtensionElement , Serializable {
private List<LineUpUser> list = new ArrayList<>();

    public List<LineUpUser> getList() {
        return list;
    }

    public void setList(List<LineUpUser> list) {
        this.list = list;
    }

    public static final String NAMESPACE = "http://jabber.org/protocol/workgroup";
    public static final String ELEMENT = "notify-queue-details";

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

}
