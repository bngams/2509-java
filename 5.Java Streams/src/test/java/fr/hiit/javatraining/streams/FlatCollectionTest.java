package fr.hiit.javatraining.streams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static fr.hiit.javatraining.streams.FlatCollection.transform;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FlatCollectionTest {

    @Test
    public void transformShouldFlattenCollection() {
        List<List<String>> collection = asList(asList("Viktor", "Eddy"), asList("John", "Doe", "Bird"));
        List<String> expected = asList("Viktor", "Eddy", "John", "Doe", "Bird");
        assertThat(transform(collection), equalTo(expected));
    }

}
