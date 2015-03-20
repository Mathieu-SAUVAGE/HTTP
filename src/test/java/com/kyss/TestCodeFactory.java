package com.kyss;

import com.kyss.CodeFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mathieu SAUVAGE
 */
public class TestCodeFactory {
	private static Logger LOGGER = LoggerFactory.getLogger(TestCodeFactory.class);
	@Test
	public void createTestNumericCode() {
		LOGGER.debug(CodeFactory.createNumericCode(10));
	}
}
