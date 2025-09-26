package fr.hiit.javatraining.streams;


import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static fr.hiit.javatraining.streams.Grouping.*;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupingTest {

    @Test
    public void partitionAdultsShouldSeparateKidsFromAdults() {
        Person sara = new Person("Sara Conor", 4, "Human");
        Person terminator = new Person("Terminator", 40, "Cyborg");
        Person shwarzy = new Person("Arnold Shwarz", 42, "Human");
        List<Person> collection = asList(sara, shwarzy, terminator);
        Map<String, List<Person>> result = groupByNationality(collection);
        assertThat(result.get("Human"), is(asList(sara, shwarzy)));
        assertThat(result.get("Cyborg"), is(asList(terminator)));
    }

}
