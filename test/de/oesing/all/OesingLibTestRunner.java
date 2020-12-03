package de.oesing.all;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;

public class OesingLibTestRunner {

	@RunWith(JUnitPlatform.class)

	@SelectClasses({ OesingLibStringTest.class, OesingLibArrayTest.class })

	class JunitTestSuite {
	}

	public static void main(final String[] args) {
		final Result result = JUnitCore.runClasses(JunitTestSuite.class);

		for (final Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.printf("Ran %s tests in %s ms. Success: %s, failure: %s\n", result.getRunCount(),
				result.getRunTime(), (result.getRunCount() - result.getFailureCount()),result.getFailureCount());
	}

}
