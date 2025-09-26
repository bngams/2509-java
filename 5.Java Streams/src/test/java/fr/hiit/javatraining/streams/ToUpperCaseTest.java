package fr.hiit.javatraining.streams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static fr.hiit.javatraining.streams.ToUpperCase.*;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ToUpperCaseTest {

    @Test
    public void transformShouldConvertCollectionElementsToUpperCase() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("MY", "NAME", "IS", "JOHN", "DOE");
        assertThat(transform(collection), is(expected));
    }

}
