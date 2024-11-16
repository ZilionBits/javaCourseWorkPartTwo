package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNumberPricingCalculatorTest {

    private CarNumberPricingCalculator carNumberPricingCalculator;


    @BeforeEach
    void setCarNumberPricingCalculatorTest() {
        carNumberPricingCalculator = new CarNumberPricingCalculator();
    }


    @Test
    @DisplayName("Price:1000")
    void testCalculatePrice1000(){

        assertEquals(1000.0, carNumberPricingCalculator.calculatePrice("AAA984"),"Numbers plate AAA984 price must be 1000.0");
        assertEquals(1000.0, carNumberPricingCalculator.calculatePrice("TTT146"),"Numbers plate TTT146 price must be 1000.0");
        assertEquals(1000.0, carNumberPricingCalculator.calculatePrice("END999"),"Numbers plate END999 price must be 1000.0");
        assertEquals(1000.0, carNumberPricingCalculator.calculatePrice("LJY333"),"Numbers plate LJY333 price must be 1000.0");
        assertEquals(1000.0, carNumberPricingCalculator.calculatePrice("UNF001"),"Numbers plate UNF001 price must be 1000.0");
        assertEquals(1000.0, carNumberPricingCalculator.calculatePrice("ERT666"),"Numbers plate ERT666 price must be 1000.0");

    }
    @Test
    @DisplayName("Price:5000")
    void testCalculatePrice5000(){

        assertEquals(5000.0, carNumberPricingCalculator.calculatePrice("BBB666"),"Numbers plate BBB666 price must be 5000.0");
        assertEquals(5000.0, carNumberPricingCalculator.calculatePrice("RRR111"),"Numbers plate RRR111 price must be 5000.0");

    }

    @Test
    @DisplayName("Price:2000")
    void testCalculatePriceCustomName(){

        assertEquals(2000.0, carNumberPricingCalculator.calculatePrice("GOD"),"Numbers plate GOD price must be 2000.0");
        assertEquals(2000.0, carNumberPricingCalculator.calculatePrice("KLR"),"Numbers plate KLR price must be 2000.0");
        assertEquals(2000.0, carNumberPricingCalculator.calculatePrice("BOS"),"Numbers plate BOS price must be 2000.0");

    }

    @Test
    @DisplayName("Price:7000")
    void testCalculatePriceCustomNameWithSameNumbers(){

        assertEquals(7000.0, carNumberPricingCalculator.calculatePrice("GOD000"),"Numbers plate GOD000 price must be 7000.0");
        assertEquals(7000.0, carNumberPricingCalculator.calculatePrice("KLR666"),"Numbers plate KLR666 price must be 7000.0");
        assertEquals(7000.0, carNumberPricingCalculator.calculatePrice("BOS888"),"Numbers plate BOS888 price must be 7000.0");

    }

    @Test
    @DisplayName("Price:10000")
    void testCalculatePriceCustomNameMax6AnySymbols(){

        assertEquals(10000.0, carNumberPricingCalculator.calculatePrice("X"),"Numbers plate X price must be 10000.0");
        assertEquals(10000.0, carNumberPricingCalculator.calculatePrice("JAVA"),"Numbers plate JAVA price must be 10000.0");

    }

    @Test
    @DisplayName("IllegalArgumentException")
    void testCalculatePriceIllegalArgumentException(){

        Exception exception = assertThrows(IllegalArgumentException.class, () -> carNumberPricingCalculator.calculatePrice("PROGRAM"));
        assertEquals("Incorrect plate number format. Must be 1-6 symbols latin letters and number combination", exception.getMessage());
    }




}
