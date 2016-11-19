package com.nulogy.nupack;

import java.math.BigDecimal;

public class CostEstimationServiceImpl implements CostEstimationService {

    private static final long serialVersionUID = 605983168667407298L;

    @Override
    public BigDecimal estimate(BigDecimal initialCost, Labour labour) {
        return initialCost.multiply(labour.getMarkUp().add(BigDecimal.ONE));
    }

}
