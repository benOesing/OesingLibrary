package de.oesing.all;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OesingLibArrayTest {

	class Help {
		int a;
		int b;

		public Help(final int a, final int b) {
			this.a = a;
			this.b = b;
		}
	}

	static Stream<Arguments> noDuplicatesData() {
		// valid input
		return Stream.of(Arguments.of(true, new Integer[] { 1, 2, 3, 4, 5 }), // real Example
				Arguments.of(false, new Integer[] { 1, 2, 3, 4, 5, 5 }), // real Example
				Arguments.of(true, new Object[] { new int[] { 1, 2, 3 }, new OesingLibArrayTest(), 2, 4.2 }), // type
				// scramble
				Arguments.of(true, new Integer[] {}), // empty array
				Arguments.of(true,
						new Object[] { new OesingLibArrayTest().new Help(1, 2),
								new OesingLibArrayTest().new Help(1, 2) }), // No equals defined
				// Comparing arrays ofnonprimitives
				Arguments.of(false, new Object[] { new Integer[] { 1, 2, 3 }, new Integer[] { 1, 2, 3 } }),
				// Deep Comparing arrays ofnonprimitives
				Arguments.of(false,
						new Object[] { new Integer[][] { { 1 }, { 2 }, { 3 } },
								new Integer[][] { { 1 }, { 2 }, { 3 } } }),
				// Comparing arrays of primitives
				Arguments.of(false, new Object[] { new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 } }));
	}

	@Test
	void testLinearSearch() {
	}

	@ParameterizedTest
	@MethodSource(value = "noDuplicatesData")
	void testNoDuplicates(final boolean expected, final Object[] arr) {
		assertTimeout(Duration.ofSeconds(5), () -> {
			assertEquals(expected, OesingLibArray.noDuplicates(arr));
		});
	}

	@Test
	void testNoDuplicatesThrowsException() {
		assertThrows(NullPointerException.class, () -> {
			OesingLibArray.noDuplicates(new Integer[] { null, null });
		});
		assertThrows(NullPointerException.class, () -> {
			OesingLibArray.noDuplicates(null);
		});
	}
}
