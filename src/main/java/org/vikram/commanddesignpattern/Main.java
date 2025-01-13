package org.vikram.commanddesignpattern;

// Invoker
class RemoteControl {
    ICommand onButton;
    ICommand offButton;

    public RemoteControl(ICommand onButton, ICommand offButton) {
        this.onButton = onButton;
        this.offButton = offButton;
    }

    public void clickOnButton(){
        onButton.execute();
    }

    public void clickOffButton(){
        offButton.execute();
    }
}

// Command
interface ICommand {
    void execute();
    void unexecute();
}

// Concrete commands
class TurnACOffCommand implements ICommand {
    private AirConditioner airConditioner;

    public TurnACOffCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        this.airConditioner.turnOffAC();
    }

    @Override
    public void unexecute() {
        this.airConditioner.turnOnAC();
    }
}

class TurnACOnCommand implements ICommand {
    private AirConditioner airConditioner;

    public TurnACOnCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        this.airConditioner.turnOnAC();
    }

    @Override
    public void unexecute() {
        this.airConditioner.turnOffAC();
    }
}

// Reciever
class AirConditioner {
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


public class Main {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();

        ICommand turnAcOnCommand = new TurnACOnCommand(airConditioner);
        ICommand turnAcOffCommand = new TurnACOffCommand(airConditioner);

        RemoteControl remoteControl = new RemoteControl(turnAcOnCommand, turnAcOffCommand);

        remoteControl.clickOnButton();
        remoteControl.clickOffButton();
    }
}
