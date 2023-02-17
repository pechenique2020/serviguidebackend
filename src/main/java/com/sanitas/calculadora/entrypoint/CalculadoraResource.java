package com.sanitas.calculadora.entrypoint;

import com.sanitas.calculadora.domain.bean.CalculateException;
import com.sanitas.calculadora.domain.bean.ResultCompute;
import com.sanitas.calculadora.usecase.CalculadoraCompute;
import lombok.RequiredArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CalculadoraResource {
    private final CalculadoraCompute calculadoraCompute;

    @PostMapping(value = "/calcular")
    public ResponseEntity<ResultCompute> calcularValores(@RequestParam("valor_a") String valueA,@RequestParam("valor_b") String valueB) {
        try{
            ResultCompute resultado =this.calculadoraCompute.computeEntries(valueA,valueB);
            return ResponseEntity.ok(resultado);
        }catch (CalculateException e){
            ResultCompute body = new ResultCompute();
            body.setMsgError(e.getMessage());
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
