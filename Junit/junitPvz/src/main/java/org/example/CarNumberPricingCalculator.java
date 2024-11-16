package org.example;

import java.util.Arrays;

class CarNumberPricingCalculator {

	

	/**
	 * Naudojam TDD
	 * Kursime programą Regitrai, kuri turi paskaičiuoti kainą pagal
	 * pageidautiną automobilio numerį. Kainą politika yra tokia:
	 *
	 * Jeigu visos
	 * trys raidės yra vienodos, arba jeigu visi trys skaičiai vienodi arba
	 * "001","666" - numerio kaina 1000 eur.
	 *
	 * Jeigu trys raidės vienodos IR trys
	 * skaičiai vienodi - numerio kaina 5000 EUR.
	 *
	 * Jeigu raidžių rinkinys yra
	 * vienas iš "GOD", "KLR", "BOS" numerio kaina 2000 EUR.
	 *
	 * Jeigu prie aukščiau
	 * minėto raidžių rinkinio pridėsime tris vienodus skaičius - 7000 EUR.
	 *
	 *
	 * Jeigu numeris yra ne iš trijų simbolių ir trijų skaičių (1-6 simboliai)
	 * jis yra vardinis - kaina 10 000 EUR.
	 *
	 *
	 * Jei skaičiuoklei paduodamas blogo formato numeris - turi mesti 
	 * IllegalArgumentException su pranešimu - "Incorrect plate number format. Must be 1-6 symbols
	 * latin letters and number combination"
	 *
	 *
	 * mažosiomis ir d P.S. NIEKADA realiose sistemose nenaudokite float/double
	 * pinigų ir kitoms tikslioms operacijoms tam naudokite BigDecimal tipą!
	 */
	 
	//testo metodo pvz.:
	//@Test
	// public void testAllNumbersAndLettersAreTheSameCost5000() {
	//	assertEquals(new Double(5000.0), priceCalc.calculatePrice("AAA111"));
	//}
	 
	 
	 public double calculatePrice(String number) {

		 if(number.isEmpty() || number.length() > 6){
			 throw new IllegalArgumentException("Incorrect plate number format. Must be 1-6 symbols latin letters and number combination");
		 }
		 
		 double numberPlatePrice = 10000;
		 String[] numberPlateChars;

		 numberPlateChars =  number.split("");
		 System.out.println(Arrays.toString(numberPlateChars));


		 boolean firstRule = number.length() == 6 && ((numberPlateChars[0].equals(numberPlateChars[1]) && numberPlateChars[1].equals(numberPlateChars[2]))
                 || (numberPlateChars[3].equals(numberPlateChars[4]) && numberPlateChars[4].equals(numberPlateChars[5]))
                 || ((numberPlateChars[3].equals("0") || numberPlateChars[3].equals("6"))
                 && (numberPlateChars[4].equals("0") || numberPlateChars[4].equals("6"))
                 && (numberPlateChars[5].equals("1") || numberPlateChars[5].equals("6"))));

		 boolean secondRule = number.length() == 6 && (numberPlateChars[0].equals(numberPlateChars[1]) && numberPlateChars[1].equals(numberPlateChars[2]))
				 && (numberPlateChars[3].equals(numberPlateChars[4]) && numberPlateChars[4].equals(numberPlateChars[5]));

		 boolean thirdRule = (number.contains("GOD") || number.contains("KLR") || number.contains("BOS"));

		 boolean forthRule = number.length() == 6 && (thirdRule)
				 && (numberPlateChars[3].equals(numberPlateChars[4]) && numberPlateChars[4].equals(numberPlateChars[5]));


		 if(firstRule && !secondRule && !forthRule){
			 numberPlatePrice = 1000;
		 } else if(secondRule){
			 numberPlatePrice = 5000;
		 } else if(thirdRule && !forthRule){
			 numberPlatePrice = 2000;
		 } else if(forthRule){
			 numberPlatePrice = 7000;
		 }

		 return numberPlatePrice;

	 }
	
}