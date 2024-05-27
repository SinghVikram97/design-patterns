package org.vikram.decoratorpattern;

import org.vikram.decoratorpattern.component.BasePizza;
import org.vikram.decoratorpattern.component.FarmhousePizza;
import org.vikram.decoratorpattern.decorators.ExtraCheeseDecorator;
import org.vikram.decoratorpattern.decorators.MushroomDecorator;

public class Main {
    public static void main(String[] args) {
        // Farmhouse Pizza with extra cheese and mushroom
        BasePizza mushroomExtraCheeseFarmhousePizza = new MushroomDecorator(new ExtraCheeseDecorator(new FarmhousePizza()));
        System.out.println(mushroomExtraCheeseFarmhousePizza.cost()); // 200+10+15
    }
}
