package com.sanitas.calculadora.domain.bean;

import com.sanitas.calculadora.usecase.CalculadoraCompute;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public CalculadoraCompute getDomainOrdersService() {
        return new CalculadoraCompute();
    }
}
