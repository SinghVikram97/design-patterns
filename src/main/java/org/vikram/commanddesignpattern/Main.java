package org.vikram.commanddesignpattern;

import org.vikram.commanddesignpattern.command.ICommand;
import org.vikram.commanddesignpattern.command.TurnACOffCommand;
import org.vikram.commanddesignpattern.command.TurnACOnCommand;
import org.vikram.commanddesignpattern.invoker.RemoteControl;
import org.vikram.commanddesignpattern.receiver.AirConditioner;

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
