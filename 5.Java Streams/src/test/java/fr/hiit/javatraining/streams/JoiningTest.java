package fr.hiit.javatraining.streams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static fr.hiit.javatraining.streams.Joining.namesToString;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JoiningTest {

    @Test
    public void toStringShouldReturnPeopleNamesSeparatedByComma() {
        Person sara = new Person("Sara Conor", 4, "Human");
        Person terminator = new Person("Terminator", 40, "Cyborg");
        Person shwarzy = new Person("Arnold Shwarz", 42, "Human");
        List<Person> collection = asList(sara, terminator, shwarzy);
        assertThat(namesToString(collection), is("Names: Sara Conor, Terminator, Arnold Shwarz."));
    }

}
