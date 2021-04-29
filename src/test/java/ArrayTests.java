import arrays.ArrayPractice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static arrays.ArrayPractice.oneAway;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayTests {

    @ParameterizedTest()
    @ValueSource(strings = {"toma", "hi", "omar", "abcdefghijklmnopqrstuvwxyz", "a"})
    public void validArrayTest(String input) {

        Assertions.assertTrue(ArrayPractice.isUnique(input));
    }

    @ParameterizedTest()
    @ValueSource(strings = {"tomato", "hello", "ontario", "abcdefghijklmnopqrstuvwxyyz"})
    public void invalidArrayTest(String input) {

        assertFalse(ArrayPractice.isUnique(input));
    }

    // and then somewhere in this test class
    private static Stream<Arguments> generator() {

        return Stream.of(
                Arguments.of("Mr John Smith    ".toCharArray(), 13, "Mr%20John%20Smith"),
                Arguments.of("Hilmi Abou-Saleh  ".toCharArray(), 16, "Hilmi%20Abou-Saleh"),
                Arguments.of("The Cat Jumped Over The Wall          ".toCharArray(), 20, "The%20Cat%20Jumped%20Over%20The%20Wall"),
                Arguments.of("MrJohn".toCharArray(), 6, "MrJohn"));
    }

    @ParameterizedTest()
    @MethodSource("generator")
    public void validUrlifyTests(char[] input, int length, String expected) {

        assertEquals(new String(ArrayPractice.urlify(input, length)), expected, new String(input)  + "!=" + expected);
    }




    private static Stream<Arguments> oneAwayGenerator() {

        return Stream.of(
                Arguments.of("pale".toCharArray(), "ple".toCharArray()),
                Arguments.of("pales".toCharArray(), "pale".toCharArray()),
                Arguments.of("pale".toCharArray(), "bale".toCharArray()),
                Arguments.of("pale".toCharArray(), "bake".toCharArray()));
    }

    @ParameterizedTest()
    @MethodSource("oneAwayGenerator")
    public void validOneAwayTests(char[] one, char[] two) {

        assertTrue(oneAway(one, two));
    }


}
