package elk.extractor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import elk.extractor.jama.controller.JamaExtractorController;
import elk.extractor.pipeline.PipleLineData;

public interface IExtractor {
  //public void startJob (Object... variable)throws Exception ;
	public void startJob (PipleLineData pipelineData)throws Exception ;
	public void stopJob ()throws Exception ;
	public void restartJob() throws Exception ;
	
}
