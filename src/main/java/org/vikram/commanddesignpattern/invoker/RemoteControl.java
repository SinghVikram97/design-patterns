package org.vikram.commanddesignpattern.invoker;

import org.vikram.commanddesignpattern.command.ICommand;

public class RemoteControl {
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
