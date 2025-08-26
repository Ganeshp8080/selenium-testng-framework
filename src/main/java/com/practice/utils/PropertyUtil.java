package com.practice.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

import com.practice.constants.FrameworkConstants;
import com.practice.enums.ConfigProperties;

public final class PropertyUtil {

	private PropertyUtil() {

	}

	private static final Map<String, String> CONFIGMAP = new HashMap<String, String>();

	private static Properties property = new Properties();

	static {

		try {
			FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath());
			property.load(file);

			/*
			 * With KeySet
			 * 
			 * for (Object key : property.keySet()) { CONFIGMAP.put(String.valueOf(key),
			 * property.getProperty(String.valueOf(key))); }
			 */

			/*
			 * With lambda expression
			 * 
			 * property.entrySet().forEach(entry ->
			 * CONFIGMAP.put(String.valueOf(entry.getKey()),
			 * String.valueOf(entry.getValue()))) ;
			 * 
			 */

			for (Entry<Object, Object> entry : property.entrySet()) {

				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// loading property file only once with the help of map
	public static String get(ConfigProperties configProperty) throws Exception {

		if (Objects.isNull(configProperty.toString().toLowerCase()) || Objects.isNull(CONFIGMAP)) {

			throw new Exception("Property " + configProperty.toString().toLowerCase() + " is not found in config.properties file");

		}

		return CONFIGMAP.get(configProperty.toString().toLowerCase());

	}

	// loading property file each time
	public static String getValue(ConfigProperties configProperty) throws Exception {

		String value = "";

		FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath());

		property.load(file);
		value = property.getProperty(configProperty.toString().toLowerCase());
		if (Objects.isNull(value)) {

			throw new Exception("Property " + configProperty.toString().toLowerCase() + " is not found in config.properties file");
		}

		return value.trim();
	}

}
