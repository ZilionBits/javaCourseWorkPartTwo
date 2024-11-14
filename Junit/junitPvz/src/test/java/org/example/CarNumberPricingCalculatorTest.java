package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarNumberPricingCalculatorTest {

    private CarNumberPricingCalculator carNumberPricingCalculator;


    @BeforeEach
    void setCarNumberPricingCalculatorTest() {
        carNumberPricingCalculator = new CarNumberPricingCalculator();
    }


    @Test
    @DisplayName("Price:1000")
    void testCalculatePrice(){

        assertEquals(1000.0, carNumberPricingCalculator.calculatePrice("AAA984"),"Numbers plate AAA984 price must be 1000.0");
        assertEquals(1000.0, carNumberPricingCalculator.calculatePrice("TTT146"),"Numbers plate TTT146 price must be 1000.0");
        assertEquals(1000.0, carNumberPricingCalculator.calculatePrice("END999"),"Numbers plate END999 price must be 1000.0");
        assertEquals(1000.0, carNumberPricingCalculator.calculatePrice("LJY333"),"Numbers plate LJY333 price must be 1000.0");
        assertEquals(1000.0, carNumberPricingCalculator.calculatePrice("UNF001"),"Numbers plate UNF001 price must be 1000.0");
        assertEquals(1000.0, carNumberPricingCalculator.calculatePrice("ERT666"),"Numbers plate ERT666 price must be 1000.0");

    }


}
