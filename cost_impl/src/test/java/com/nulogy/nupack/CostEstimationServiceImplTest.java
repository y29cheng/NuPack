package com.nulogy.nupack;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;

import java.math.BigDecimal;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nulogy.nupack.object.BaseLabour;
import com.nulogy.nupack.object.ElectronicsLabour;
import com.nulogy.nupack.object.FoodLabour;
import com.nulogy.nupack.object.Labour;
import com.nulogy.nupack.object.PharmaceuticalLabour;
import com.nulogy.nupack.object.ValidationException;
import com.nulogy.nupack.service.CostEstimationService;

@Test(description="Test CostEstimationService methods")
public class CostEstimationServiceImplTest {

    private CostEstimationService service;
    
    @BeforeClass
    public void setUp() {
        service = new CostEstimationServiceImpl();
    }
    
    @Test(description="Test estimate mock", dataProvider = "mockDataSet")
    public void testEstimateMock(BigDecimal initialCost, Labour labour, BigDecimal expected) {
        replay(labour);
        Assert.assertEquals(service.estimate(initialCost, labour), expected);
    }
    
    @Test(description="Test estimate", dataProvider = "costDataSet")
    public void testEstimate(BigDecimal initialCost, Labour labour, BigDecimal expected) {
        Assert.assertEquals(service.estimate(initialCost, labour), expected);
    }
    
    @SuppressWarnings("finally")
    @Test(description="Test exception", expectedExceptions= { ValidationException.class }, dataProvider = "exceptionDataSet")
    public void testException(BigDecimal initialCost, Labour labour, String expectedMessage) {
        ValidationException exception = null;
        try {
            service.estimate(initialCost, labour);
        } catch (ValidationException e) {
            exception = e;
        } finally {
            Assert.assertEquals(exception == null ? null : exception.getMessage(), expectedMessage);
            throw exception;
        }
    }
    
    @DataProvider(name = "exceptionDataSet")
    public Object[][] getExceptionDataSet() {
        return new Object[][] {
            { null, new BaseLabour(), "Initial cost cannot be null" },
            { BigDecimal.valueOf(-1), new BaseLabour(), "Initial cost cannot be less than 0" }
        };
    }
    
    @DataProvider(name = "mockDataSet")
    public Object[][] getMockDataSet() {
        Labour l1 = mock(Labour.class);
        expect(l1.getMarkUp()).andReturn(BigDecimal.valueOf(0));
        
        Labour l2 = mock(Labour.class);
        expect(l2.getMarkUp()).andReturn(BigDecimal.valueOf(0.3));
        
        Labour l3 = mock(Labour.class);
        expect(l3.getMarkUp()).andReturn(BigDecimal.valueOf(-0.2));
        
        return new Object[][] {
            { BigDecimal.valueOf(12.3), l1, BigDecimal.valueOf(12.3) },
            { BigDecimal.valueOf(12.3), l2, BigDecimal.valueOf(15.99) },
            { BigDecimal.valueOf(12.3), l3, BigDecimal.valueOf(9.84) },
        };
    }
    
    @DataProvider(name = "costDataSet")
    public Object[][] getCostDataSet() {
        Labour l1 = new BaseLabour();
        
        Labour l2 = new FoodLabour();
        
        Labour l3 = new PharmaceuticalLabour();
        
        Labour l4 = new ElectronicsLabour();
        
        Labour l5 = new BaseLabour(1);
        
        Labour l6 = new FoodLabour(1);
        
        Labour l7 = new PharmaceuticalLabour(1);
        
        Labour l8 = new ElectronicsLabour(1);
        
        return new Object[][] {
            { BigDecimal.valueOf(12.3), l1, new BigDecimal("12.915000") },
            { BigDecimal.valueOf(12.3), l2, new BigDecimal("14.593950") },
            { BigDecimal.valueOf(12.3), l3, new BigDecimal("13.883625") },
            { BigDecimal.valueOf(12.3), l4, new BigDecimal("13.173300") },
            { BigDecimal.valueOf(12.3), l5, new BigDecimal("13.069980") },
            { BigDecimal.valueOf(12.3), l6, new BigDecimal("14.748930") },
            { BigDecimal.valueOf(12.3), l7, new BigDecimal("14.038605") },
            { BigDecimal.valueOf(12.3), l8, new BigDecimal("13.328280") }
        };
    }
}
