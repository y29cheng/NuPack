package com.nulogy.nupack;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Model representing the cost of labour
 * @author George
 *
 */
public interface Labour extends Serializable {
    
    /**
     * Get the margin of markup
     * @return the margin of markup
     */
    BigDecimal getMarkUp();

}
