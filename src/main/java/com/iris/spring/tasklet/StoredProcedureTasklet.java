package com.iris.spring.tasklet;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;

import com.iris.spring.mapper.PersonMapper;
import com.iris.spring.model.Person;


/*
 * Custom tasklet to execute the stored procedure
 */
public class StoredProcedureTasklet implements Tasklet {

	private DataSource dataSource;
	private String sql;
	
	
	
	public DataSource getDataSource() {
		return dataSource;
	}



	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}



	public String getSql() {
		return sql;
	}



	public void setSql(String sql) {
		this.sql = sql;
	}



	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {
		// TODO Auto-generated method stub
		
		List<Person> result=new ArrayList<Person>();
		JdbcTemplate template=new JdbcTemplate(getDataSource());
		result=template.query(sql,new PersonMapper());
		System.out.println("No of Records affected "+result);

		
		return RepeatStatus.FINISHED;
	}

}

