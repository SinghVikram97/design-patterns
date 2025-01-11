package org.vikram.decoratorpattern.decorators;

import org.vikram.decoratorpattern.component.BasePizza;

public class ExtraCheeseDecorator extends ToppingDecorator{
    private final BasePizza basePizza;

    public ExtraCheeseDecorator(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return 10+this.basePizza.cost();
    }
}
