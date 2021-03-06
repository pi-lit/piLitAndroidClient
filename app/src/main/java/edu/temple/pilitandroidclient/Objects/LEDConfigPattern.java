package edu.temple.pilitandroidclient.Objects;


import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

import edu.temple.pilitandroidclient.Activities.Login;

public class LEDConfigPattern implements Serializable {
    public String configName = " ";
    public String userName = Login.userName;    //TODO
    public String description;
    public ArrayList<Command> commandArray;
    public boolean isPublic = true;             //TODO //false, is not added made public until user indicates that config should
                                                //be made public
    public int ledNum = 30;  //TODO returned as 0 from server on login, why?
    //--------------------------------------------
    String _id;
    String _v;


    //for android use only
    public ArrayList<Timestamp> allCustomTimestamps;
    public ArrayList<Integer> rangeForRainbowEffect;
    public ArrayList<Command> flashCommands;
    public boolean flashOn = false;

    public LEDConfigPattern(String description, int numberOfLights) {
        this.description = description;
        this.commandArray = new ArrayList<>();
        this.ledNum = numberOfLights;
    }


    public void createFlashCommandArray() {
        this.flashCommands = new ArrayList<>();

        for (int i = 0; i < commandArray.size(); i++) {
            if (commandArray.get(i).effect.equalsIgnoreCase("flash")) {
                flashCommands.add(commandArray.get(i));
            }
        }
    }


    public void createRainbowRangeArray() {
        rangeForRainbowEffect = new ArrayList<>();

        for (int i = 0; i < this.commandArray.size(); i++) {
            if (this.commandArray.get(i).effect.equalsIgnoreCase("rainbow")) {
                for (int j = 0; j < commandArray.get(i).range.length; j++) {
                    rangeForRainbowEffect.add(commandArray.get(i).range[j]);
                }
                System.out.println("Rainbow Range:: " + rangeForRainbowEffect.toString());
            }
        }
    }

    public void createCustomTimestampArray() {
        Gson gson = new Gson();
        String jsonCmdStr = gson.toJson(this.commandArray);
        System.out.println("GSON COMMAND STR" + jsonCmdStr);
        allCustomTimestamps = new ArrayList<>();

        for (int i = 0; i < this.commandArray.size(); i++) {
            if (this.commandArray.get(i).effect.equalsIgnoreCase("custom")) {
                for (int j = 0; j < this.commandArray.get(i).timestamps.size(); j++) {

                    allCustomTimestamps.add(this.commandArray.get(i).timestamps.get(j));
                    //System.out.println("ADDED TIME STAMP: " + this.commandArray.get(i).timestamps.get(j).toString());
                }
                this.commandArray.get(i).injectRangeIntoChildTimestamps();
            }

        }
    }

    @Override
    public String toString() {
        return configName;
    }
}
