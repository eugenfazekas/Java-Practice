
public class ChainPatternDemo {
	
	
	private static AbstractLogger getChainOfLoggers() {
		
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger consoleLOgger = new ConsoleLogger(AbstractLogger.INFO);
		
		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLOgger);
		
		return errorLogger;
	}

	public static void main(String[] args) {

		AbstractLogger loggerChain = getChainOfLoggers();
		
		loggerChain.logMessage(AbstractLogger.INFO, "This is an information");
		
		loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information");
		
		loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information");
	}
}
