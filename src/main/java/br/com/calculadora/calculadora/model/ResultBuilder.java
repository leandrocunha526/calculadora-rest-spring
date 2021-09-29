package br.com.calculadora.calculadora.model;

import java.math.*;

public class ResultBuilder {

    private ResultBuilder(){ }

    public static ApiResult getResult(Object result){
        return ApiResult.withResult(result.toString());
    }

    public static ApiResult getResult(BigDecimal result){
        return ApiResult.withResult(result.toPlainString());
    }

    public static ApiResult getResultFromError(String errorMessage){
        return ApiResult.withResult(errorMessage);
    }
}
