package elk.extractor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import elk.extractor.jama.controller.JamaExtractorController;
import elk.extractor.jama.controller.JamaJobComponent;
@Component
public class ExtractorFactory {
	//extractor factory 
	
	  @Autowired JamaJobComponent jamaJobComponent;
	 
	  @Autowired JamaExtractorController jamaExtractorController;
	//get pipeline for configured job 
	
	//call coming from scheduler 

	
	 public IExtractor   getExtractor(EXTRACTORTYPE Type ) throws Exception {
		 switch (Type) 
	        { 
	        case JAMA: 
	            System.out.println("JAMA"); 
	            return jamaExtractorController;
	          
	        default: 
	            System.out.println("We are working on this type of extractor "); 
	            break; 
	        } 
		 
		 
		 	  
		  
		 return null; 
	 
	 }
}
