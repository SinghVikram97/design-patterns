package org.vikram.factorypattern.factorymethod;

interface Button{
    void display();
}

class BlackButton implements Button {
    @Override
    public void display() {
        System.out.println("Black Button");
    }
}

class WhiteButton implements Button {
    @Override
    public void display() {
        System.out.println("White Button");
    }
}

interface ButtonFactory{
    Button getButton();
}

class BlackButtonFactory implements ButtonFactory{
    @Override
    public Button getButton() {
        return new BlackButton();
    }
}

class WhiteButtonFactory implements ButtonFactory{
    @Override
    public Button getButton() {
        return new WhiteButton();
    }
}

public class Main {
    public static void main(String[] args) {
        // Now button factory can be injected dynamically depending on the theme using dependency injection
        ButtonFactory buttonFactory = new BlackButtonFactory();
        Button button = buttonFactory.getButton();
        button.display();
    }
}
