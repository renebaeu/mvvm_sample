package de.r_baeumer.mvvmsample.news;


public interface ControllerLiveCycleMethods {

    /**
     * This could be called if we need an init after a deInit. If we don't need that, we can init stuff within the constructor
     */
    void init();

    /**
     * Use this to clear resources or more important, dispose (stop) network calls
     */
    void deInit();
}
