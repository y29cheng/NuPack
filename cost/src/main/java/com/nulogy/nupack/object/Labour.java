package com.nulogy.nupack.object;

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
    
    /**
     * Set the number of people
     * @param people the number of people
     */
    void setNumberOfPeople(int people);
    
    /**
     * Get the number of people
     * @return the number of peoplw
     */
    int getNumberOfPeople();
}
