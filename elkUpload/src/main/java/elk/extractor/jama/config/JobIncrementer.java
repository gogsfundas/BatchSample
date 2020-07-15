package elk.extractor.jama.config;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;


@Component
public class JobIncrementer implements JobParametersIncrementer {

    public JobParameters getNext(JobParameters parameters) {
        if (parameters==null || parameters.isEmpty()) {
            return new JobParametersBuilder().addLong("JobId", 1L).toJobParameters();
        }
        long id = parameters.getLong("JobId",1L) + 1;
        return new JobParametersBuilder().addLong("JobId", id).toJobParameters();
    }
}