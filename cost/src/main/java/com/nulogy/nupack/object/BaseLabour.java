package com.nulogy.nupack.object;

import java.math.BigDecimal;

public class BaseLabour implements Labour {

    private static final long serialVersionUID = 1L;
    protected static final BigDecimal MARKUP = BigDecimal.valueOf(0.05);
    
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
    public int getNumberOfPeople() {
        return numberOfPeople;
    }
    
    @Override
    public BigDecimal getMarkUp() {
        return BigDecimal.valueOf(numberOfPeople).multiply(BigDecimal.valueOf(0.012)).add(BigDecimal.ONE).multiply(MARKUP.add(BigDecimal.ONE)).subtract(BigDecimal.ONE);
    }

}
