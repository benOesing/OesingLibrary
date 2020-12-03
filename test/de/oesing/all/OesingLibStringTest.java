package de.oesing.all;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OesingLibStringTest {

	@ParameterizedTest
	@CsvSource({
		// valid input
		"DLXXXIV,584", // Real example
		"MMMMCMXCIX,4999", // Edge case
		// invalid input
		"'',-1", // Negative
		"'',0", // Zero
		"'',5000" // Out of value set
	})
	void testAsRomanNumber(final String expected, final int input) {
		assertTimeout(Duration.ofSeconds(5), () -> {
			assertEquals(expected, OesingLibString.asRomanNumber(input));
		});
	}

	@ParameterizedTest
	@CsvSource({
		// valid input
		"0,'',''", // Empty
		"3,'',abc", // Insertion
		"1,azc,abc", // Substitution
		"1,abcd,abc", // Deletion
		"4,many,plenty", // Real example
		"3,abc,ABC", // Case
	})
	void testEditDistanceUnweighted(final int expected, final String s1, final String s2) {
		assertTimeout(Duration.ofSeconds(5), () -> {
			assertEquals(expected, OesingLibString.editDistance(s1, s2));
		});
	}

	@ParameterizedTest
	@CsvSource({
		// invalid input
		"'',🙈🙈🙈", // Emoji
		"'',!?#", // Symbols
	})
	void testEditDistanceUnweightedThrowsException(final String s1, final String s2) {
		assertThrows(IllegalArgumentException.class, () -> {
			OesingLibString.editDistance(s1, s2);
		});
	}

	@ParameterizedTest
	@CsvSource({
		// valid input
		"3,'',abc,2,1,0", // Insertion
		"5,azc,abc,3,3,5", // Substitution
		"5,abcd,abc,5,0,0", // Deletion
		"12,many,plenty,2,2,4", // Real example
		"14,many,plenty,3,3,4" // Real example
	})
	void testEditDistanceWeighted(final int expected, final String s1, final String s2, final int deletion,
			final int insertion, final int substitution) {
		assertTimeout(Duration.ofSeconds(5), () -> {
			assertEquals(expected, OesingLibString.editDistance(s1, s2, deletion, insertion, substitution));
		});
	}

}
