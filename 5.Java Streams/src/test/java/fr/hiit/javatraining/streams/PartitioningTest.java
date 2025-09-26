package fr.hiit.javatraining.streams;


import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static fr.hiit.javatraining.streams.Partitioning.*;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PartitioningTest {

    @Test
    public void partitionAdultsShouldSeparateKidsFromAdults() {
        Person sara = new Person("Sara Conor", 4, "Human");
        Person terminator = new Person("Terminator", 40, "Cyborg");
        Person shwarzy = new Person("Arnold Shwarz", 42, "Human");
        List<Person> collection = asList(sara, terminator, shwarzy);
        Map<Boolean, List<Person>> result = partitionAdults(collection);
        assertThat(result.get(true), is(asList(terminator, shwarzy)));
        assertThat(result.get(false), is(asList(sara)));
    }

}
