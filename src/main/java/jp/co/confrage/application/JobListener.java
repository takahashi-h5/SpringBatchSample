package jp.co.confrage.application;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class JobListener extends JobExecutionListenerSupport{
	@Override
	public void beforeJob(JobExecution jobExecution) {
	super.beforeJob(jobExecution);
	System.out.println("�W���u�J�n");
	}
	 
	@Override
	public void afterJob(JobExecution jobExecution) {
	super.afterJob(jobExecution);
	System.out.println("�W���u�I��");
	}
}
