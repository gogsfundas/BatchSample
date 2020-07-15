package elk.extractor.jama.controller;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import elk.extractor.*;
import elk.extractor.jama.config.ConfigurationParameter;
import java.util.*;
import elk.extractor.pipeline.JobData;
import elk.extractor.pipeline.PipleLineData;
  

@RestController 
public class JamaExtractorController  extends Extractor implements IExtractor  {
	
	PipleLineData  pipleLineData;

    @Autowired
    JobLauncher jobLauncher;
 
    @Autowired
    Job jamaExtractionJob;
    @Autowired 
    JobOperator jobOperator ;
 
    @RequestMapping("/startjob")
    public String startJamaExtractor() throws Exception {

            JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                   .toJobParameters();
            jobLauncher.run(jamaExtractionJob, jobParameters);

       return "Jama service extractor is started"; 
   }

	@Override
	
		public void startJob(PipleLineData  pipleLineData) throws Exception {
		
		 
		if (pipleLineData == null) {
			 System.out.println("EXT_E0009 Extractor need job data  and pipeleind data ");
      }
		 else
		 {
			
			this.pipleLineData = pipleLineData;
			 JobParameters paramJobParameters = getJobParameters() ;
			 jobLauncher.run(jamaExtractionJob, paramJobParameters);
			
		 
		 }
		
	}
	public JobParameters getJobParameters() {
		long jobId = this.pipleLineData.JobId;
	    JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
	    jobParametersBuilder.addLong("JobId", jobId).toJobParameters();
	    jobParametersBuilder.addParameter("jobandpipelineData", new
				 ConfigurationParameter<PipleLineData>(pipleLineData)).toJobParameters();
	    return jobParametersBuilder.toJobParameters();
	}
	
	@Override
	public void stopJob()
	{
	
	try {
		  Set<Long>  executions = jobOperator.getRunningExecutions("jamaExtractionJob");
	
		try {
			jobOperator.stop(executions.iterator().next());
		} catch (NoSuchJobExecutionException | JobExecutionNotRunningException e) {
			 
			e.printStackTrace();
		}
	} catch (NoSuchJobException e) {
		 
		e.printStackTrace();
	}
	}
	

	@Override
	public void restartJob() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
