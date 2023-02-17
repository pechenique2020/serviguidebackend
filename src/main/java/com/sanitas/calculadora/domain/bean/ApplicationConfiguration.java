package com.sanitas.calculadora.domain.bean;

import com.sanitas.calculadora.usecase.CalculadoraCompute;
import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public CalculadoraCompute getDomainCalculadoraConputeService() {
        return new CalculadoraCompute();
    }

    @Bean
    public TracerImpl getDomainTracerAPIService() {
        return new TracerImpl();
    }


}
