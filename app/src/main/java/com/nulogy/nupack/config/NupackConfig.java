package com.nulogy.nupack.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nulogy.nupack.CostEstimationServiceImpl;
import com.nulogy.nupack.object.BaseLabour;
import com.nulogy.nupack.object.ElectronicsLabour;
import com.nulogy.nupack.object.FoodLabour;
import com.nulogy.nupack.object.Labour;
import com.nulogy.nupack.object.PharmaceuticalLabour;
import com.nulogy.nupack.service.CostEstimationService;

@Configuration
public class NupackConfig {

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
    public CostEstimationService getCostEstimationService() {
        return new CostEstimationServiceImpl();
    }
}
