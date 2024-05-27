package org.vikram.decoratorpattern.decorators;

import org.vikram.decoratorpattern.component.BasePizza;

public class MushroomDecorator extends ToppingDecorator{
    private BasePizza basePizza;

    public MushroomDecorator(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return 15+this.basePizza.cost();
    }
}
