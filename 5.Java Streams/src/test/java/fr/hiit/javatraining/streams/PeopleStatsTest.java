package fr.hiit.javatraining.streams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static fr.hiit.javatraining.streams.PeopleStats.*;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PeopleStatsTest {

    Person sara = new Person("Sara Conor", 4, "Human");
    Person terminator = new Person("Terminator", 40, "Cyborg");
    Person shwarzy = new Person("Arnold Shwarz", 42, "Human");
    List<Person> collection = asList(sara, shwarzy, terminator);

    @Test
    public void getStatsShouldReturnAverageAge() {
        assertThat(getStats(collection).getAverage(),
                is((double)(4 + 40 + 42) / 3));
    }

    @Test
    public void getStatsShouldReturnNumberOfPeople() {
        assertThat(getStats(collection).getCount(),
                is((long)3));
    }

    @Test
    public void getStatsShouldReturnMaximumAge() {
        assertThat(getStats(collection).getMax(),
                is(42));
    }

    @Test
    public void getStatsShouldReturnMinimumAge() {
        assertThat(getStats(collection).getMin(),
                is(4));
    }

    @Test
    public void getStatsShouldReturnSumOfAllAges() {
        assertThat(getStats(collection).getSum(),
                is((long)(40 + 42 + 4)));
    }

}
