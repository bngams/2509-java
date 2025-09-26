package fr.aelion.java.firstmaven.calcul;

import fr.aelion.java.firstmaven.exceptions.BadParamException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CalculatorTest {

    private final Calculator calculator = new Calculator();

    /**
     * This scenarios can check basic addition between nembers
     * @throws BadParamException
     */
    @Test // @annotation "fonctionnelle"
    void addition() throws BadParamException {
        // hypothèse
        int expectedResult = 4;

        // operation
        int a = 2;
        int b = 2;
        int currentResult = calculator.add(a, b);

        // verifier hypothese
        Assertions.assertEquals(expectedResult, currentResult);
    }

    @Test
    void additionShouldTriggerExceptionIfOneEqualsZero() {
        // hypothèse
        int expectedResult = 4;

        // operation
        int a = 2;
        int b = 0;

         Assertions.assertThrows(BadParamException.class, () -> {
            int currentResult = calculator.add(a, b);
        });
    }
}
