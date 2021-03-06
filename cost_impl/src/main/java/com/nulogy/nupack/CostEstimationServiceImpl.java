package com.nulogy.nupack;

import java.math.BigDecimal;

import com.nulogy.nupack.object.Labour;
import com.nulogy.nupack.object.ValidationException;
import com.nulogy.nupack.service.CostEstimationService;

public class CostEstimationServiceImpl implements CostEstimationService {

    private static final long serialVersionUID = 1L;

    @Override
    public BigDecimal estimate(BigDecimal initialCost, Labour labour) {
        if (initialCost == null) {
            throw new ValidationException("Initial cost cannot be null");
        }
        if (initialCost.compareTo(BigDecimal.ZERO) < 0) {
            throw new ValidationException("Initial cost cannot be less than 0");
        }
        return initialCost.multiply(labour.getMarkUp().add(BigDecimal.ONE));
    }

}
