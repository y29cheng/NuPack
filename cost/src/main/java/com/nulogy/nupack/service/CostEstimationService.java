package com.nulogy.nupack.service;

import java.io.Serializable;
import java.math.BigDecimal;

import com.nulogy.nupack.object.Labour;

/**
 * Service class for estimating labour cost
 * @author George
 *
 */
public interface CostEstimationService extends Serializable {

    /**
     * Estimate the final cost of labour 
     * @param initalCost the initial cost
     * @param labour the required labour
     * @return the final cost 
     */
    BigDecimal estimate(BigDecimal initialCost, Labour labour);
}
