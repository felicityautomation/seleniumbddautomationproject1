package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class LoggingUtility {
	
	public static Logger getLogger(String classNameAndMethodName) {
		Logger logger = LogManager.getLogger(classNameAndMethodName);
		Configurator.initialize(null, "log4j2.properties");
		return logger;
	}

}
