package org.example;

public class Main {
    public static void main(String[] args) {

        CarNumberPricingCalculator carNumberPricingCalculator = new CarNumberPricingCalculator();

        System.out.println("Price: " + carNumberPricingCalculator.calculatePrice("SNAKE"));
    }
}