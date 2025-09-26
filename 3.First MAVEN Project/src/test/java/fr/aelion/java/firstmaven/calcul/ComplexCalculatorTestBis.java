package fr.aelion.java.firstmaven.calcul;

import fr.aelion.java.firstmaven.exceptions.BadParamException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// with mockito-junit-jupiter
@ExtendWith(MockitoExtension.class)
public class ComplexCalculatorTestBis {

    @Mock
    Calculator calculator;               // Mockito creates the mock

    @InjectMocks
    ComplexCalculator complexCalculator;  // Injects the mock into the SUT
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

        when(calculator.add(a, b)).thenReturn(6);

        int currentResult = complexCalculator.doComplexComputation(a, b, c);

        // verifier hypothese
        Assertions.assertEquals(expectedResult, currentResult);
    }
}
