package com.nulogy.nupack.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.nulogy.nupack.CostEstimationServiceImpl;
import com.nulogy.nupack.object.BaseLabour;
import com.nulogy.nupack.object.ElectronicsLabour;
import com.nulogy.nupack.object.FoodLabour;
import com.nulogy.nupack.object.Labour;
import com.nulogy.nupack.object.PharmaceuticalLabour;
import com.nulogy.nupack.service.CostEstimationService;

@TestConfiguration
public class NupackTestConfig {

    @Bean
    @Qualifier("baseLabour")
    public Labour getBaseLabour() {
        return new BaseLabour();
    }
    
    @Bean
    @Qualifier("foodLabour")
    public Labour getFoodLabour() {
        return new FoodLabour();
    }
    
    @Bean
    @Qualifier("pharmaceuticalLabour")
    public Labour getPharmaceuticalLabour() {
        return new PharmaceuticalLabour();
    }
    
    @Bean
    @Qualifier("electronicsLabour")
    public Labour getElectronicsLabour() {
        return new ElectronicsLabour();
    }
    
    @Bean
    @Qualifier("baseLabour_1")
    public Labour getBaseLabour_1() {
        return new BaseLabour(1);
    }
    
    @Bean
    @Qualifier("foodLabour_1")
    public Labour getFoodLabour_1() {
        return new FoodLabour(1);
    }
    
    @Bean
    @Qualifier("pharmaceuticalLabour_1")
    public Labour getPharmaceuticalLabour_1() {
        return new PharmaceuticalLabour(1);
    }
    
    @Bean
    @Qualifier("electronicsLabour_1")
    public Labour getElectronicsLabour_1() {
        return new ElectronicsLabour(1);
    }
    
    @Bean
    public CostEstimationService getCostEstimationService() {
        return new CostEstimationServiceImpl();
    }
}
