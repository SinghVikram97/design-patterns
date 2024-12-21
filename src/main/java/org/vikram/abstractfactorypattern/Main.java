package org.vikram.abstractfactorypattern;

interface Button{
    void display();
}

interface Icon{
    void display();
}

class WindowsButton implements Button{
    @Override
    public void display() {
        System.out.println("Rendering windows button");
    }
}

class WindowsIcon implements Icon{
    @Override
    public void display() {
        System.out.println("Rendering icons for windows");
    }
}

class MacButton implements Button{
    @Override
    public void display() {
        System.out.println("Rendering Mac button");
    }
}

class MacIcon implements Icon{
    @Override
    public void display() {
        System.out.println("Rendering icons for Mac");
    }
}

interface UIFactory{
    Button getButton();
    Icon getIcon();
}

class WindowsUIFactory implements UIFactory{
    @Override
    public Button getButton() {
        return new WindowsButton();
    }

    @Override
    public Icon getIcon() {
        return new WindowsIcon();
    }
}

class MacUIFactory implements UIFactory{
    @Override
    public Button getButton() {
        return new MacButton();
    }

    @Override
    public Icon getIcon() {
        return new MacIcon();
    }
}

public class Main {
    public static void main(String[] args) {
        // Based on os inject the factory
        UIFactory uiFactory = new MacUIFactory();
        uiFactory.getButton().display();
        uiFactory.getIcon().display();
    }
}
