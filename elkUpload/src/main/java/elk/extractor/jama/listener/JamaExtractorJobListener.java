package elk.extractor.jama.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;

import elk.extractor.jama.config.ConfigurationParameter;
import elk.extractor.pipeline.PipleLineData;


public class JamaExtractorJobListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		PipleLineData pipleLineData = (PipleLineData)jobExecution.getJobParameters().getParameters().get("jobandpipelineData").getValue();
		System.out.println(" JOB IS GOING TO START FOR ORG : "+pipleLineData.pipeline.get(0));
		System.out.println(" JOB IS GOING TO START FOR JOB ID : "+pipleLineData.JobId);
		
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		//send job end message 
		if ( jobExecution.getStatus() == BatchStatus.COMPLETED)
		{
			System.out.println(" Jama batch is completed !!");
		}
		if ( jobExecution.getStatus() ==BatchStatus.STOPPED)
		{
			System.out.println(" Jama batch is STOPPED !!");
		}
		 else if(jobExecution.getStatus() == BatchStatus.FAILED){
			 System.out.println(" Jama batch JOB FAILED");
		    }
		
		}
}


