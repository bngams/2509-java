package fr.aelion.java.firstmaven.calcul;

import fr.aelion.java.firstmaven.exceptions.BadParamException;

public class Calculator {

    /**
     * Return addition result of a and b
     * @param a
     * @param b
     * @return
     */
    int add(int a, int b) throws BadParamException {
        if(a == 0 || b == 0) throw new BadParamException("Cannot use 0 values");
        return a + b;
    }
}