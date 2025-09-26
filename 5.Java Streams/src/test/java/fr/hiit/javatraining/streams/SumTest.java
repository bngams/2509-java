package fr.hiit.javatraining.streams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static fr.hiit.javatraining.streams.Sum.*;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/*
Sum all elements of a collection
 */
public class SumTest {

    @Test
    public void calculateShouldReturnSumOfAllIntegersInCollection() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        assertThat(calculate(numbers), is(1 + 2 + 3 + 4 + 5));
    }

}
