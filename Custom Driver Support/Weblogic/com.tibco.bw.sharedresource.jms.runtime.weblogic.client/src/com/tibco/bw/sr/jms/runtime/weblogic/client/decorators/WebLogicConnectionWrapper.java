package com.tibco.bw.sr.jms.runtime.weblogic.client.decorators;

import javax.jms.Connection;
import javax.jms.ConnectionConsumer;
import javax.jms.ConnectionMetaData;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.ServerSessionPool;
import javax.jms.Session;
import javax.jms.Topic;

import weblogic.jndi.WLInitialContextFactory;

public class WebLogicConnectionWrapper implements Connection {
	private final Connection connection;
	
	public WebLogicConnectionWrapper(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void close() throws JMSException {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader( WLInitialContextFactory.class.getClassLoader() );
			connection.close();
		}
		finally {
			Thread.currentThread().setContextClassLoader( classLoader );
		}
	}

	@Override
	public ConnectionConsumer createConnectionConsumer(Destination destination, String messageSelector, ServerSessionPool sessionPool, int maxMessages) throws JMSException {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader( WLInitialContextFactory.class.getClassLoader() );
			return connection.createConnectionConsumer( destination, messageSelector, sessionPool, maxMessages );
		}
		finally {
			Thread.currentThread().setContextClassLoader( classLoader );
		}
	}

	@Override
	public ConnectionConsumer createDurableConnectionConsumer(Topic topic, String subscriptionName, String messageSelector, ServerSessionPool sessionPool, int maxMessages) throws JMSException {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader( WLInitialContextFactory.class.getClassLoader() );
			return connection.createDurableConnectionConsumer( topic, subscriptionName, messageSelector, sessionPool, maxMessages );
		}
		finally {
			Thread.currentThread().setContextClassLoader( classLoader );
		}
	}

	@Override
	public Session createSession(boolean transacted, int acknowledgeMode) throws JMSException {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader( WLInitialContextFactory.class.getClassLoader() );
			return connection.createSession( transacted, acknowledgeMode );
		}
		finally {
			Thread.currentThread().setContextClassLoader( classLoader );
		}
	}

	@Override
	public String getClientID() throws JMSException {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader( WLInitialContextFactory.class.getClassLoader() );
			return connection.getClientID();
		}
		finally {
			Thread.currentThread().setContextClassLoader( classLoader );
		}
	}

	@Override
	public ExceptionListener getExceptionListener() throws JMSException {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader( WLInitialContextFactory.class.getClassLoader() );
			return connection.getExceptionListener();
		}
		finally {
			Thread.currentThread().setContextClassLoader( classLoader );
		}
	}

	@Override
	public ConnectionMetaData getMetaData() throws JMSException {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader( WLInitialContextFactory.class.getClassLoader() );
			return connection.getMetaData();
		}
		finally {
			Thread.currentThread().setContextClassLoader( classLoader );
		}
	}

	@Override
	public void setClientID(String clientID) throws JMSException {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader( WLInitialContextFactory.class.getClassLoader() );
			connection.setClientID( clientID );
		}
		finally {
			Thread.currentThread().setContextClassLoader( classLoader );
		}
	}

	@Override
	public void setExceptionListener(ExceptionListener listener) throws JMSException {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader( WLInitialContextFactory.class.getClassLoader() );
			connection.setExceptionListener( listener );
		}
		finally {
			Thread.currentThread().setContextClassLoader( classLoader );
		}
	}

	@Override
	public void start() throws JMSException {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader( WLInitialContextFactory.class.getClassLoader() );
			connection.start();
		}
		finally {
			Thread.currentThread().setContextClassLoader( classLoader );
		}
	}

	@Override
	public void stop() throws JMSException {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader( WLInitialContextFactory.class.getClassLoader() );
			connection.stop();
		}
		finally {
			Thread.currentThread().setContextClassLoader( classLoader );
		}
	}
}
