package com.nulogy.nupack.object;

import java.math.BigDecimal;

public class FoodLabour extends BaseLabour {

    private static final long serialVersionUID = 1L;

    public FoodLabour() {
        super();
    }
    
    public FoodLabour(int people) {
        super(people);
    }
    
    @Override
    public BigDecimal getMarkUp() {
        return BigDecimal.valueOf(0.13).add(BigDecimal.valueOf(getNumberOfPeople()).multiply(BigDecimal.valueOf(0.012))).add(BigDecimal.ONE).multiply(MARKUP.add(BigDecimal.ONE)).subtract(BigDecimal.ONE);
    }

}
