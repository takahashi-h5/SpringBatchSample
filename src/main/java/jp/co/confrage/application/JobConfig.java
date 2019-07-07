package jp.co.confrage.application;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class JobConfig {
	@Autowired
	private ATasklet tasklet1;
	@Autowired
	private BTasklet tasklet2;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	 
	@Bean
	public Step samplestep3() {
	return stepBuilderFactory.get("step-name1")
	.tasklet(tasklet1)
	.build();
	}
	
	@Bean
	public Step samplestep2() {
	return stepBuilderFactory.get("step-name2")
	.tasklet(tasklet2)
	.build();
	}
	 
	@Bean
	public Job job(@Qualifier("samplestep3") Step step1,@Qualifier("samplestep2") Step step2) {
	return jobBuilderFactory.get("job2")
	.incrementer(new RunIdIncrementer())
//	.listener(listener())
	.start(step1)
	.next(step2)
	.build();
	}
	 
//	@Bean
//	public JobExecutionListener listener() {
//		return new JobListener();
//	}
}
