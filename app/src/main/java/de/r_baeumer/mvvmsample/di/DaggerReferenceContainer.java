package de.r_baeumer.mvvmsample.di;


import de.r_baeumer.mvvmsample.di.news.MainComponent;

public class DaggerReferenceContainer {
    private static MainComponent component;

    public static void setComponent(MainComponent component) {
        DaggerReferenceContainer.component = component;
    }

    public static MainComponent getComponent() {
        return component;
    }


}
