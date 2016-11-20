package com.nulogy.nupack;

import java.math.BigDecimal;

public class BaseLabour implements Labour {

    private static final long serialVersionUID = 1L;
    private static final BigDecimal MARKUP = BigDecimal.valueOf(0.015);
    
    private int numberOfPeople;
    
    public BaseLabour() {}
    
    public BaseLabour(int people) {
        if (people < 0) {
            throw new ValidationException("Number of people cannot be less than 0");
        }
        numberOfPeople = people;
    }
    
    @Override
    public void setNumberOfPeople(int people) {
        if (people < 0) {
            throw new ValidationException("Number of people cannot be less than 0");
        }
        numberOfPeople = people;
    }
    
    @Override
    public BigDecimal getMarkUp() {
        return BigDecimal.valueOf(numberOfPeople).multiply(BigDecimal.valueOf(0.012)).add(MARKUP);
    }

}
