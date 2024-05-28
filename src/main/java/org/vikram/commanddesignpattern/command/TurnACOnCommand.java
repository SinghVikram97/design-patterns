package org.vikram.commanddesignpattern.command;

import org.vikram.commanddesignpattern.receiver.AirConditioner;

public class TurnACOnCommand implements ICommand{
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
