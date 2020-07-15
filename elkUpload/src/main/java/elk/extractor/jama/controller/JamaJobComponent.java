package elk.extractor.jama.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import elk.extractor.IExtractor;
import elk.extractor.pipeline.PipleLineData;
@Component
public class JamaJobComponent  implements IExtractor {
	   @Autowired
	    JobLauncher jobLauncher;
	 
	    @Autowired
	    Job jamaExtractionJob;
	
	    
	    public String startJamaExtractor() throws Exception {

		/*
		 * JobParameters jobParameters = new JobParametersBuilder().addLong("time",
		 * System.currentTimeMillis()) .toJobParameters();
		 * JobLauncher.run(jamaExtractionJob, jobParameters);
		 */
    return "Jama service extractor is started"; 
}
	
	    @Override
	public void startJob(PipleLineData pipelineData) throws Exception {
	       JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                   .toJobParameters();
            jobLauncher.run(jamaExtractionJob, jobParameters);

     //  return "Jama service extractor is started"; 
	}

		@Override
		public void stopJob() throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void restartJob() throws Exception {
			// TODO Auto-generated method stub
			
		}
}
