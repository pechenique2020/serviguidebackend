package com.sanitas.calculadora.entrypoint;

import com.sanitas.calculadora.domain.bean.CalculateException;
import com.sanitas.calculadora.domain.bean.ResultCompute;
import com.sanitas.calculadora.usecase.CalculadoraCompute;
import lombok.RequiredArgsConstructor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.corp.calculator.TracerImpl;

@RestController
@RequiredArgsConstructor
public class CalculadoraResource {
    private final CalculadoraCompute calculadoraCompute;

    private final TracerImpl tracer;

    @PostMapping(value = "/calcular")
    public ResponseEntity<ResultCompute> calcularValores(@RequestParam("valor_a") String valueA,@RequestParam("valor_b") String valueB) {
        try{
            ResultCompute resultado =this.calculadoraCompute.computeEntries(valueA,valueB);
            tracer.trace(resultado);
            return ResponseEntity.ok(resultado);

        }catch (Exception e){
            ResultCompute body = new ResultCompute();
            body.setMsgError(e.getMessage());
            return new ResponseEntity<>(body,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
