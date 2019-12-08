package com.tibco.custom.configuration.management;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tibco.bw.runtime.customProps.ExternalApplicationProperties;

public class GetPropertyValues implements ExternalApplicationProperties {
	private final Logger logger = LoggerFactory.getLogger(CONFIG_MANAGEMENT_LOGGER);

	@Override
	public Map<String, String> getExternalApplicationProperties(String appName) {
		Map<String, String> valueMap = new HashMap<>();
		try {
			getPropValues(valueMap);
		} catch (Exception e) {
			logger.error("Application Prop updated" + e.getMessage());
		}
		return valueMap;
	}

	private Map<String, String> getPropValues(Map<String, String> valueMap)
			throws Exception {
		try {
			Properties props = new Properties();
			try (InputStream configFile = GetPropertyValues.class.getResourceAsStream("/resources/config.properties")) {
				props.load(configFile);

			} catch (IOException ex) {
				logger.error("Could not read properties from the config file due to error: " + ex);;
			}
			@SuppressWarnings("unchecked")
			Enumeration<String> enums = (Enumeration<String>) props.propertyNames();
			while (enums.hasMoreElements()) {
				String key = enums.nextElement();
				String value = props.getProperty(key);
				valueMap.put(key, value);
			}

		} catch (Throwable e) {
			throw new Exception("Failed to load properties from the config property file.", e);
		}
		return valueMap;
	}
}
