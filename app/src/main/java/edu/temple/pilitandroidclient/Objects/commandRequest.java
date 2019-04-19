package edu.temple.pilitandroidclient.Objects;

public class commandRequest {
    PiObj pi;
    LEDConfigPattern config;

    public commandRequest(String piName, String userName, String LEDconfigPatternDescription){
        pi = new PiObj(piName, userName);
        config = new LEDConfigPattern(LEDconfigPatternDescription, 30);
    }

    public commandRequest(String piName, String userName, LEDConfigPattern configPattern){
        pi = new PiObj(piName, userName);
        config = configPattern;
    }
}
