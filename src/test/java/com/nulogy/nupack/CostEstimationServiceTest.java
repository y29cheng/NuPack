package com.nulogy.nupack;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;

import java.math.BigDecimal;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(description="Test CostEstimationService methods")
public class CostEstimationServiceTest {

    private CostEstimationService service;
    
    @BeforeClass
    public void setUp() {
        service = new CostEstimationServiceImpl();
    }
    
    @Test(description="Test estimate", dataProvider = "costDataSet")
    public void testEstimate(BigDecimal initialCost, Labour labour, BigDecimal expected) {
        replay(labour);
        Assert.assertEquals(service.estimate(initialCost, labour), expected);
    }
    
    @DataProvider(name = "costDataSet")
    public Object[][] getCostDataSet() {
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
}
