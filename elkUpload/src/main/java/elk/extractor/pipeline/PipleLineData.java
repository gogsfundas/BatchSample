package elk.extractor.pipeline;

import java.io.Serializable;
import java.util.List;

public class PipleLineData implements Serializable {

	// all data set to UI and then pass it to job 
	//
	//
	///Extractor;
	//Transformer_xmltoHtml
	//Transformaer_PI
	public List <String> pipeline ; 
	public Long JobId;
	public JobData jobData;
	public PipleLineData(List<String> pipeline, Long i, JobData jobData) {
		super();
		this.pipeline = pipeline;
		JobId = i;
		this.jobData = jobData;
	}
	
}
