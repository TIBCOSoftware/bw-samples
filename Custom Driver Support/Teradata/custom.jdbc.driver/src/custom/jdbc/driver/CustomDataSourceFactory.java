/************************************************************************
 * Copyright (c) 2016 Tibco Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 
 * Contributors:
 *     Tibco Software - initial API and implementation
 *     TIBCO 
 ************************************************************************/

package custom.jdbc.driver; 
 
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import javax.sql.XADataSource;
import org.osgi.service.jdbc.DataSourceFactory;

 
/****************************** TODO ************************************
 * Import the packages from jar that contain the data source and drivers* 
 * by hovering over the data source class name with your mouse and      *
 * select the import option												*
 ************************************************************************/

public class CustomDataSourceFactory implements DataSourceFactory {

	/**
	 * This Method must have the data source object instantiated, set its properties and return the instance
	 * @param props: a persistent set of properties
	 * @return returns a Data Source Object
	 * @throws SQLException: An exception that provides information on a database access error or other errors.
	 */
	@Override
	public DataSource createDataSource(Properties props) throws SQLException {
		com.ncr.teradata.TeraDataSource theInstance = new com.ncr.teradata.TeraDataSource();
		setProperties(theInstance, props);
		return theInstance;
	}

	/**
	 * This Method must have the Connection Pool Data Source object instantiated, set its properties and return the instance of a connection pool
	 * @param props: a persistent set of properties
	 * @return returns a connection pool data source  Object
	 * @throws SQLException: An exception that provides information on a database access error or other errors.
	 */
	@Override
	public ConnectionPoolDataSource createConnectionPoolDataSource(Properties props) throws SQLException {
		com.ncr.teradata.TeraConnectionPoolDataSource theInstance = new com.ncr.teradata.TeraConnectionPoolDataSource();
		setProperties(theInstance, props);
		return theInstance;
	}

	/**
	 * XA Drivers are currently not supported, an exception must be thrown 
	 * @throws SQLException
	 */
	@Override
	public XADataSource createXADataSource(Properties props) throws SQLException {		
		throw new SQLException("NOT SUPPORTED");
	}

	/**
	 * This Method must have an database driver object instantiated, set its properties and return the instance 
	 * @param props: a persistent set of properties 
	 * @return returns a database driver
	 * @throws SQLException: An exception that provides information on a database access error or other errors.
	 */
	@Override
	public Driver createDriver(Properties props) throws SQLException {		
		return new com.teradata.jdbc.TeraDriver();
	}

	/**
	 * Private internal method that its whole purpose is prepare the driver/data source properties
	 * @param ds the dataset to be used with the connection
	 * @param properties set of properties that will be used to connect to the database
	 */
	private void setProperties(final com.teradata.jdbc.TeraConnectionPoolDataSource ds, final Properties properties) {
	      Properties props = (Properties) properties.clone();
	      
	      String url = (String) props.remove(DataSourceFactory.JDBC_URL);    	  
	      String server = (String) props.remove(DataSourceFactory.JDBC_SERVER_NAME);
	      String port = (String) props.remove(DataSourceFactory.JDBC_PORT_NUMBER);
	      String dbName = (String) props.remove(DataSourceFactory.JDBC_DATABASE_NAME);
	      Integer loginTimeout = (Integer) props.remove("loginTimeout");
	      
	      String user = (String) props.remove(DataSourceFactory.JDBC_USER);
	      String password = (String) props.remove(DataSourceFactory.JDBC_PASSWORD);
	      
	     
	      /**NOTE: if your driver supports URL Property it is recommended that you use it  
	       *       in place of the the  Server Name, Port Number, and Database Name properties.
	       *       Usage Example. ds.setUrl(url);
	       * **/
	      
	      /*TODO: If your drivers returns empty for the following properties
	  		  Server, Port, DbName
  		  you must provide them manually.*/
	     // ds.setServerName(server);
	      //ds.setPortNumber(Integer.valueOf(port));
	      //ds.setDatabaseName(dbName);
	      ds.setDSName("172.16.1.159");
	      ds.setPassword(password);      
	      ds.setUser(user);

	       
	      if(loginTimeout != null){
				 ds.setLoginTimeout(loginTimeout.intValue()/1000);  
	      }
	     
	}
	
	private void setProperties(final com.teradata.jdbc.TeraDataSource ds, final Properties properties) {
	      Properties props = (Properties) properties.clone();
	      
	      String url = (String) props.remove(DataSourceFactory.JDBC_URL);    	  
	      String server = (String) props.remove(DataSourceFactory.JDBC_SERVER_NAME);
	      String port = (String) props.remove(DataSourceFactory.JDBC_PORT_NUMBER);
	      String dbName = (String) props.remove(DataSourceFactory.JDBC_DATABASE_NAME);
	      Integer loginTimeout = (Integer) props.remove("loginTimeout");
	      
	      String user = (String) props.remove(DataSourceFactory.JDBC_USER);
	      String password = (String) props.remove(DataSourceFactory.JDBC_PASSWORD);
	      
	     
	      /**NOTE: if your driver supports URL Property it is recommended that you use it  
	       *       in place of the the  Server Name, Port Number, and Database Name properties.
	       *       Usage Example. ds.setUrl(url);
	       * **/
	      
	      /*TODO: If your drivers returns empty for the following properties
	  		  Server, Port, DbName
		  you must provide them manually.*/
	      ds.setServerName(server);
	      //ds.setPortNumber(Integer.valueOf(port));
	      ds.setDatabaseName(dbName);
	      ds.setPassword(password);      
	      ds.setUser(user);

	       
	      if(loginTimeout != null){
				 ds.setLoginTimeout(loginTimeout.intValue()/1000);  
	      }
	     
	}
}
