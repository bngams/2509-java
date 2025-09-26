package fr.aelion.java.firstmaven.calcul;

import fr.aelion.java.firstmaven.exceptions.BadParamException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ComplexCalculatorTest {

    private final Calculator calculatorMock = mock(Calculator.class);
    private final ComplexCalculator complexCalculator = new ComplexCalculator(calculatorMock);

    /**
     * This scenarios can check complex  compute  between numbers with mockito
     * @throws BadParamException
     */
    @Test
    // @annotation "fonctionnelle"
    void compute() throws BadParamException {
        // hypothèse
        int expectedResult = 8;


        // operation
        int a = 2;
        int b = 2;
        int c = 2;

        when(calculatorMock.add(a, b)).thenReturn(6);

        int currentResult = complexCalculator.doComplexComputation(a, b, c);

        // verifier hypothese
        Assertions.assertEquals(expectedResult, currentResult);
    }
}
