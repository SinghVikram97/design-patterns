package org.vikram.commanddesignpattern.command;

import org.vikram.commanddesignpattern.receiver.AirConditioner;

public class TurnACOffCommand implements ICommand{
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
