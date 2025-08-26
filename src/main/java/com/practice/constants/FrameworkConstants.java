package com.practice.constants;

public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	final static String RESOURCE_PATH = System.getProperty("user.dir") + "/src/test/resources";

	static final String CHROMEDRIVER_PATH = RESOURCE_PATH + "/executables/chromedriver";

	final static String CONFIGFILE_PATH = RESOURCE_PATH + "/config/config.properties";
	
	final static int EXPLICIT_WAIT = 10;

	public static int getExplicitWait() {
		return EXPLICIT_WAIT;
	}

	public static String getChromeDriverPath() {
		return CHROMEDRIVER_PATH;
	}

	public static String getConfigFilePath() {

		return CONFIGFILE_PATH;
	}

}
