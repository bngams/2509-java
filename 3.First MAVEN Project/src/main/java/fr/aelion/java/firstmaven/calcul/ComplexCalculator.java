package fr.aelion.java.firstmaven.calcul;

import fr.aelion.java.firstmaven.exceptions.BadParamException;

public class ComplexCalculator {

    public Calculator calculator;

    public ComplexCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public int doComplexComputation(int a, int b, int c) throws BadParamException {
        int result = this.calculator.add(a, b);
        return result + c;
    }
}
