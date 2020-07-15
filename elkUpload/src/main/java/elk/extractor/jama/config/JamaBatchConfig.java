package elk.extractor.jama.config;
import java.util.Map;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobOperator;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import elk.extractor.jama.listener.JamaExtractorJobListener;
import elk.extractor.jama.step.JamaExtractorProcessor;
import elk.extractor.jama.step.JamaExtractorReader;
import elk.extractor.jama.step.JamaExtractorWritter;
import elk.extractor.pipeline.PipleLineData;

@Configuration
public class JamaBatchConfig {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired 
	JobIncrementer jobIncrementer;

	
	@Bean	
	public Job jamaExtractionJob() {
	
		 PipleLineData pipleLineData ; 
				 
			return jobBuilderFactory.get("jamaExtractionJob")
					
				.incrementer(jobIncrementer)
				.listener(jamaJobListner())
				.flow(jamaGeneralpipleLine())
				.end()
				.build();
	}

	
	@SuppressWarnings("unchecked")
	@Bean
	public Step jamaGeneralpipleLine() {
		return stepBuilderFactory.get("jamaGeneralpipleLine")
				.<String, String> chunk(1)
				.reader(new JamaExtractorReader())
				.processor(new JamaExtractorProcessor())
				.writer(new JamaExtractorWritter())
				.build();
	}
	@Bean
	public JobExecutionListener jamaJobListner() {
		return new JamaExtractorJobListener();
	}
	
	@Bean
	public JobOperator jobOperator(final JobLauncher jobLauncher, final JobRepository jobRepository,
	        final JobRegistry jobRegistry, final JobExplorer jobExplorer) {
	    final SimpleJobOperator jobOperator = new SimpleJobOperator();
	    jobOperator.setJobLauncher(jobLauncher);
	    jobOperator.setJobRepository(jobRepository);
	    jobOperator.setJobRegistry(jobRegistry);
	    jobOperator.setJobExplorer(jobExplorer);
	    return jobOperator;
	}

	@Bean
	public JobExplorer jobExplorer(final DataSource dataSource) throws Exception {
	    final JobExplorerFactoryBean bean = new JobExplorerFactoryBean();
	    bean.setDataSource(dataSource);
	    bean.setTablePrefix("JAMA_");
	    bean.setJdbcOperations(new JdbcTemplate(dataSource));
	    bean.afterPropertiesSet();
	    return bean.getObject();
	}
	
	/*
	 * @Override protected JobRepository createJobRepository() throws Exception {
	 * JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
	 * factory.setDataSource(dataSource);
	 * factory.setTransactionManager(transactionManager);
	 * factory.setIsolationLevelForCreate("ISOLATION_SERIALIZABLE");
	 * factory.setTablePrefix("BATCH_"); factory.setMaxVarCharLength(1000); return
	 * factory.getObject(); }
	 */
	
	
	}
	

