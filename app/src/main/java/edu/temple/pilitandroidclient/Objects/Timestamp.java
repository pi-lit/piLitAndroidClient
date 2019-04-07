package edu.temple.pilitandroidclient.Objects;

public class Timestamp {
    ColorObj color = new ColorObj(); //color object (contains R, G, B values)
    int time;                       //time at which color change will take effect
    int brightness;                 //brightness of all lights being changed by command

    public void setTimestamp(ColorObj color, int time, int brightness){ //constructor for Timestamp object
        this.color = color;
        this.time = time;
        this.brightness = brightness;
    }

}
