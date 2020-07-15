package elk.extractor.jama.logging;

import elk.extractor.ILogging;

public class Logging implements ILogging{

	@Override
	public void write(String component, String eventCode, String message, String detail) {
		// TODO Auto-generated method stub
		System.out.println("Messge coming from  "+ component);
	}

	
}
