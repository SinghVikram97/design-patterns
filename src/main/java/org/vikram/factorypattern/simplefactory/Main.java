package org.vikram.factorypattern.simplefactory;

interface Button{
    void display();
}

class BlackButton implements Button{
    @Override
    public void display() {
        System.out.println("Black Button");
    }
}

class WhiteButton implements Button{
    @Override
    public void display() {
        System.out.println("White Button");
    }
}

// Simple factory
// We can also have an interface which this factory would implement
class ButtonFactory{
    public Button getButton(String theme){
        if(theme.equals("black")){
            return new BlackButton();
        }else{
            return new WhiteButton();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ButtonFactory buttonFactory = new ButtonFactory();

        Button blackButton = buttonFactory.getButton("black");
        blackButton.display();
    }
}
