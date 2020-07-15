package elk.extractor.jama.step;

import org.springframework.batch.item.ItemProcessor;

public class JamaExtractorProcessor  implements ItemProcessor <String,String> {



	@Override
	public String process(String data) throws Exception {
		System.out.println(" processing data .....");
		return data.toUpperCase();
	}

}
