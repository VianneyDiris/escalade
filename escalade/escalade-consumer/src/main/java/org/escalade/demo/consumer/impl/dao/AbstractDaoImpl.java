package org.escalade.demo.consumer.impl.dao;



import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDaoImpl {
	
	@Inject
	@Named("DataSourceEscalade")
	private static DataSource dataSource;
	
	protected DataSource getDataSource() {
		return dataSource;
	}
	
	public static void setDataSource(DataSource dataSource) {
        AbstractDaoImpl.dataSource = dataSource;
    }
	
	

}
