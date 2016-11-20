package com.nulogy.nupack;

import java.math.BigDecimal;

public class PharmaceuticalLabour extends BaseLabour {
    
    private static final long serialVersionUID = 1L;

    public PharmaceuticalLabour() {
        super();
    }
    
    public PharmaceuticalLabour(int people) {
        super(people);
    }
    
    @Override
    public BigDecimal getMarkUp() {
        return BigDecimal.valueOf(0.075).add(super.getMarkUp());
    }

}
