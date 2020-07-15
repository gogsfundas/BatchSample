package elk.extractor.jama.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class JamaExtractorWritter  implements ItemWriter<String>{

	@Override
	public void write(List<? extends String> messages) throws Exception {
		for ( String msg: messages) {
			System.out.println("writing  data ...");
			System.out.println(msg);
		}
		
	}

}
