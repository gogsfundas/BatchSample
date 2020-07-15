package elk.extractor;

import elk.extractor.pipeline.JobData;
import elk.extractor.pipeline.PipleLineData;

public abstract class Extractor 
{
	public PipleLineData pipleLineData;
	public JobData jobData ; 
    
	public void jobStatus( )
	{
		// no job  is running 
		// default job is running 
	}
	
    
}
