package com.nulogy.nupack;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nulogy.nupack.config.NupackTestConfig;
import com.nulogy.nupack.object.Labour;
import com.nulogy.nupack.service.CostEstimationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={NupackTestConfig.class})
public class CostEstimationServiceImplSpringTest {

    @Autowired
    @Qualifier("baseLabour")
    private Labour baseLabour;
    
    @Autowired
    @Qualifier("foodLabour")
    private Labour foodLabour;
    
    @Autowired
    @Qualifier("pharmaceuticalLabour")
    private Labour pharmaceuticalLabour;
    
    @Autowired
    @Qualifier("electronicsLabour")
    private Labour electronicsLabour;
    
    @Autowired
    @Qualifier("baseLabour_1")
    private Labour baseLabour_1;
    
    @Autowired
    @Qualifier("foodLabour_1")
    private Labour foodLabour_1;
    
    @Autowired
    @Qualifier("pharmaceuticalLabour_1")
    private Labour pharmaceuticalLabour_1;
    
    @Autowired
    @Qualifier("electronicsLabour_1")
    private Labour electronicsLabour_1;
    
    @Autowired
    private CostEstimationService costEstimationService;
    
    @Test
    public void testEstimate() {
        Assert.assertEquals(new BigDecimal("12.4845"), costEstimationService.estimate(BigDecimal.valueOf(12.3), baseLabour));
        Assert.assertEquals(new BigDecimal("14.0835"), costEstimationService.estimate(BigDecimal.valueOf(12.3), foodLabour));
        Assert.assertEquals(new BigDecimal("13.4070"), costEstimationService.estimate(BigDecimal.valueOf(12.3), pharmaceuticalLabour));
        Assert.assertEquals(new BigDecimal("12.7305"), costEstimationService.estimate(BigDecimal.valueOf(12.3), electronicsLabour));
        Assert.assertEquals(new BigDecimal("12.6321"), costEstimationService.estimate(BigDecimal.valueOf(12.3), baseLabour_1));
        Assert.assertEquals(new BigDecimal("14.2311"), costEstimationService.estimate(BigDecimal.valueOf(12.3), foodLabour_1));
        Assert.assertEquals(new BigDecimal("13.5546"), costEstimationService.estimate(BigDecimal.valueOf(12.3), pharmaceuticalLabour_1));
        Assert.assertEquals(new BigDecimal("12.8781"), costEstimationService.estimate(BigDecimal.valueOf(12.3), electronicsLabour_1));
    }
    
}
