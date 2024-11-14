package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {

    @Test
    @DisplayName("Sum two numbers")
    void testAdd(){
        Calc calc = new Calc();
        int result = calc.add(1,2);

        assertEquals(3, result, "1 + 2 should be 3");
    }

    @Test
    void testDivide(){
        Calc calc = new Calc();
        int result = calc.divide(4,2);


    }
}
