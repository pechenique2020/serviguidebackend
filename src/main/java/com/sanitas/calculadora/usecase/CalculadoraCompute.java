package com.sanitas.calculadora.usecase;

import com.sanitas.calculadora.domain.bean.CalculateException;
import lombok.RequiredArgsConstructor;

import com.sanitas.calculadora.domain.bean.ResultCompute;

@RequiredArgsConstructor
public class CalculadoraCompute {
    public ResultCompute computeEntries(String valueA, String valueB) throws CalculateException{
        int newValueA = checkEntryValue(valueA);
        int newValueB = checkEntryValue(valueB);
        return computeEntriesValue(newValueA, newValueB);
    }

    private int checkEntryValue(String entryValue) throws CalculateException {
        try{
            int newValue = Integer.valueOf(entryValue);
            return newValue;
        } catch (Exception e){
            throw new CalculateException(e.getMessage());
        }
    }
    private ResultCompute computeEntriesValue(int valueA, int valueB){
        ResultCompute resultCompute = new ResultCompute();
        resultCompute.setResultado(valueA+valueB);
        return resultCompute;
    }
}
