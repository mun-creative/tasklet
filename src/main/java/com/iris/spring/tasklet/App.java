package com.iris.spring.tasklet;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext ctx=new ClassPathXmlApplicationContext("job.xml");
        Job job=(Job) ctx.getBean("springBatchCsvToDbJob");
        JobLauncher launcher=(JobLauncher)ctx.getBean("jobLauncher");
        try
        {
        	JobExecution execution=launcher.run(job,new JobParameters());
        	System.out.println(execution.getExitStatus());
        	
        }catch(Exception i)
        {
        	i.printStackTrace();
        }
        
    }
}
