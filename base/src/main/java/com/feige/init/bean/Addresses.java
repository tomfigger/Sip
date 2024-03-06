package com.feige.init.bean;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;

import java.io.Serializable;

public class Addresses implements ExtensionElement, Serializable {
    private String ofrom;


    public static final String NAMESPACE = "http://jabber.org/protocol/address";
    public static final String ELEMENT = "addresses";

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


    public String getOfrom() {
        return ofrom;
    }

    public void setOfrom(String ofrom) {
        this.ofrom = ofrom;
    }
}
