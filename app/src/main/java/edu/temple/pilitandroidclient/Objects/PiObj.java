package edu.temple.pilitandroidclient.Objects;

import java.io.Serializable;
import java.util.ArrayList;

import edu.temple.pilitandroidclient.Objects.LEDconfigObj;

public class PiObj implements Serializable {

    int piId;
    String piAddress;
    int port;
    ArrayList<LEDconfigObj> LEDstripList;
    public String customName;   //ie living room, bedroom, etc


    // constructor for adding a new Pi (no led config necessary)
    public PiObj(String piAddress, int port, String customName) {
        this.piAddress = piAddress;
        this.port = port;
        this.customName = customName;
        LEDstripList = new ArrayList<LEDconfigObj>();
    }

    public void addStrip (int ledCount){
        int newStripId = LEDstripList.size();       //index where new configObj will be placed
        LEDconfigObj newConfigObj = new LEDconfigObj(ledCount,newStripId );     //initialize new configObj
        LEDstripList.add(newConfigObj);             //add new configObj to list
    }

    //FOR TESTING ONLY!!!
    public void addStrip (String desc){
        //int newStripId = LEDstripList.size();       //index where new configObj will be placed
        LEDconfigObj newConfigObj = new LEDconfigObj(desc);     //initialize new configObj
        LEDstripList.add(newConfigObj);             //add new configObj to list
    }

    public void removeStrip (int stripId) {
        LEDstripList.remove(stripId);

        //updates the stripID of each configObj to match it's index in the array
        for(int i = 0; i < LEDstripList.size(); i++){
            LEDstripList.get(i).stripId = i;
        }
    }

    //param i: index of LED strip (same as strip Id)
    //returns: LEDconfigObj of the LED strip selected
    public LEDconfigObj getLEDconfigObj(int i){
        return LEDstripList.get(i);
    }


    //Must override so the name is displayed in drop down on User screen
    @Override
    public String toString() {
        return customName;
    }
}