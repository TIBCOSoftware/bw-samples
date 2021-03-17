package com.tibco.bw.sr.jms.runtime.weblogic.client.decorators;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;


import weblogic.jndi.WLInitialContextFactory;

public class WebLogicConnectionFactoryWrapper implements ConnectionFactory {
	private final ConnectionFactory conectionFactory;
	
	public WebLogicConnectionFactoryWrapper(ConnectionFactory conectionFactory) {
		this.conectionFactory = conectionFactory;
	}
	
	@Override
	public Connection createConnection() throws JMSException {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader( WLInitialContextFactory.class.getClassLoader() );
			return new WebLogicConnectionWrapper( conectionFactory.createConnection() );
		}
		finally {
			Thread.currentThread().setContextClassLoader( classLoader );
		}
	}

	@Override
	public Connection createConnection(String username, String password) throws JMSException {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader( WLInitialContextFactory.class.getClassLoader() );
			return conectionFactory.createConnection( username, password );
		}
		finally {
			Thread.currentThread().setContextClassLoader( classLoader );
		}
	}
}
