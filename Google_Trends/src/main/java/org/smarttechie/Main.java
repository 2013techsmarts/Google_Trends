package org.smarttechie;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GoogleTrendsBatchConfiguration.class);
	       /* app.setWebEnvironment(false);
	        ConfigurableApplicationContext ctx= app.run(args);*/
	       JobLauncher jobLauncher = context.getBean(JobLauncher.class);
	        Job addNewPodcastJob = context.getBean("importUserJob", Job.class);
        	JobParameters jobParameters = new JobParametersBuilder()
    		.addDate("date", new Date())
    		.toJobParameters();  
        	jobLauncher.run(addNewPodcastJob, jobParameters);
        	System.exit(0);
        	
    }

	

}
