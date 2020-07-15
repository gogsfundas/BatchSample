package elk.extractor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import elk.extractor.ExtractorFactory;
import elk.extractor.pipeline.JobData;
import elk.extractor.pipeline.PipleLineData;
@RestController 
public class ExtractorController {
@Autowired
ExtractorFactory extractorFactory;

PipleLineData pipelineData ;

//test coded to simulate test hit 
@RequestMapping("/startExtractorJob")
public void startjob() {
	
	JobData jobData = new JobData();
	jobData.setClient("009");
	
	jobData.setType(EXTRACTORTYPE.JAMA);
	List <String > pipeline  = new ArrayList<String>();
	pipeline.add("extractor");
	
	
	 pipelineData = new PipleLineData(pipeline, 1005L, jobData);
	
	startExtractorJob ( pipelineData);
}
	

public void startExtractorJob (PipleLineData pipelineData)
{
	
	try {
		
		
		IExtractor extractor = extractorFactory.getExtractor(pipelineData.jobData.Type);
	    extractor.startJob(pipelineData);
	
	
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}

public void stopExtractorJob() {
	IExtractor extractor;
	try {
		 extractor = extractorFactory.getExtractor(pipelineData.jobData.Type);
		 extractor.stopJob();
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


@RequestMapping("/stopJob")
public void stobJobTest() {
	stopExtractorJob();
}



}

