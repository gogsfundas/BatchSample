package elk.extractor.jama.config;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.launch.support.ExitCodeMapper;
import org.springframework.context.annotation.Configuration;
@Configuration 
public class JamaJobExitCodeMapper implements ExitCodeMapper {

	  @Override
	  public int intValue(String exitCode) {
	    if(ExitStatus.COMPLETED.getExitCode().equals(exitCode)) {
	      return 0;
	    } else if(ExitStatus.FAILED.getExitCode().equals(exitCode)) {
	      return 1;
	    } else if("COMPLETED WITH SKIPS".equals(exitCode)) {
	      return 3;
	    } else {
	      return 2;
	    }
	  }

	}