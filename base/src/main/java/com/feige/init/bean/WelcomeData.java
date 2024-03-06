package com.feige.init.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * MrLiu253@163.com
 *
 * @time 1/21/22
 * 描述:
 */
public class WelcomeData {
    private List<WelcomeToData> welcomesList;

    public WelcomeData(List<WelcomeToData> welcomesList) {
        this.welcomesList = welcomesList;
    }

    public List<WelcomeToData> getWelcomesList() {
        if (welcomesList == null) {
            return new ArrayList<>();
        }
        return welcomesList;
    }

    public void setWelcomesList(List<WelcomeToData> welcomesList) {
        this.welcomesList = welcomesList;
    }
}
