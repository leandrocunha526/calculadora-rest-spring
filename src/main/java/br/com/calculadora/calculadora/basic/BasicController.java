package br.com.calculadora.calculadora.basic;

import br.com.calculadora.calculadora.model.ApiResult;
import br.com.calculadora.calculadora.model.ResultBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static br.com.calculadora.calculadora.model.ResultBuilder.getResult;
import static br.com.calculadora.calculadora.model.ResultBuilder.getResultFromError;

@RestController
@RequestMapping
public class BasicController {

    @GetMapping("/add")
    public ApiResult add(@RequestParam BigDecimal augend, @RequestParam BigDecimal addend){
        return getResult(augend.add(addend));
    }

    @GetMapping("/subtract")
    public ApiResult subtract(@RequestParam BigDecimal minuent, @RequestParam BigDecimal subtrahend){
        return getResult(minuent.subtract(subtrahend));
    }

    @GetMapping("/multiply")
    public ApiResult multiply(@RequestParam BigDecimal multiplier, @RequestParam BigDecimal multiplicand){
        return getResult(multiplicand.multiply(multiplicand));
    }

    @GetMapping("/division")
    public ApiResult divide(@RequestParam BigDecimal dividend, @RequestParam BigDecimal divisor){
        if(divisor.equals(BigDecimal.ZERO))
        {
            return getResultFromError("No division by null");
        }
        return getResult(dividend.divide(divisor, RoundingMode.HALF_EVEN));
    }
}
