package elk.extractor.jama.step;


import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;



public class JamaExtractorReader implements ItemReader {

	private String[] message = {"Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
			"Java Spring batching reading" , " Java Spring batching reading","Java Spring batching reading" , " Java Spring batching reading",
					
	"Java Spring batching reading"};
 private int counter = 0; 
 
	

	@Override
	public Object read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if( counter < message.length)
		{
		 // read all data  from array 
			return message [counter++]; 
		}else {
			counter =0; 
		}
		return null;
	}

}
