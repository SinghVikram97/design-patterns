package org.vikram.commanddesignpattern.receiver;

public class AirConditioner {
    private boolean isOn;
    public void turnOnAC(){
        this.isOn=true;
        System.out.println("AC is turned on");
    }

    public void turnOffAC(){
        this.isOn=false;
        System.out.println("AC is turned off");
    }
}
