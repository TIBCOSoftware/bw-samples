package com.tibco.bw.sr.jms.runtime.weblogic.client;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import weblogic.jndi.WLInitialContextFactory;

import com.tibco.bw.sharedresource.trinity.ssl.client.runtime.SSLClientResource;
import com.tibco.bw.sr.jms.runtime.api.JMSProviderHelper;
import com.tibco.bw.sr.jms.runtime.weblogic.client.decorators.WebLogicConnectionFactoryWrapper;

public class WebLogicJMSProvider implements JMSProviderHelper {
	private final ConcurrentHashMap<String, ConnectionFactory> connectionFactories = new ConcurrentHashMap<String, ConnectionFactory>();
	private final ConcurrentHashMap<String, Destination> destinations = new ConcurrentHashMap<String, Destination>();
	
	public WebLogicJMSProvider() {
	}
	
	public synchronized ConnectionFactory lookupConnectionFactory(String connectionFactoryName, Hashtable<String, String> properties, SSLClientResource sslClient) throws NamingException {
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader( WLInitialContextFactory.class.getClassLoader() );
			
			final String key = connectionFactoryKey( connectionFactoryName, properties );
			ConnectionFactory connectionFactory = connectionFactories.get( key );
			if ( connectionFactory != null ) {
				return connectionFactory;
			}
			
			final InitialContext initialContext = new InitialContext( properties );
			connectionFactory = new WebLogicConnectionFactoryWrapper( (ConnectionFactory) initialContext.lookup( connectionFactoryName ) );
			connectionFactories.put( key, connectionFactory );
			return connectionFactory;
		}
	    finally {
	      Thread.currentThread().setContextClassLoader( classLoader );
	    }
	}
	
	public synchronized Destination resolveDestination(String destinationName, Hashtable<String, String> properties, Session session) throws NamingException, JMSException {
		final String key = destinationKey( destinationName, properties );
		Destination destination = destinations.get( key );
		if ( destination != null ) {
			return destination;
		}
		
		// IMPL Note: For now let us focus on JNDI lookups only. Disabling direct mode.
		// Direct access.
//		final String initialFactory = properties.get( InitialContext.INITIAL_CONTEXT_FACTORY );
//		if ( initialFactory == null || "".equals( initialFactory ) ) {
//			destination = createDestination( session, destinationName );
//			destinations.put( key , destination );
//			return destination;
//		}
		
		// JNDI lookup.
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader( WLInitialContextFactory.class.getClassLoader() );
			final InitialContext initialContext = new InitialContext( properties );
			destination = (Destination) initialContext.lookup( destinationName );
			destinations.put( key, destination );
			return destination;
		}
		catch ( NamingException exception ) {
			// IMPL Note: See above.
//			if ( destination == null && session != null ) {
//				try {
//					destination = createDestination( session, destinationName );
//				}
//				catch ( JMSException e ) {
//					throw new JMSException( "Destination resolution failed due to: " + e.getMessage() + ". Root cause: " + exception.getMessage() + "." );
//				}
//			}
//			if ( destination != null ) {
//				return destination;
//			}
			throw exception;
		}
		finally {
			Thread.currentThread().setContextClassLoader( classLoader );
		}
	}
	
	public ConnectionFactory createGenericConnectionFactory(String providerURL, String paramString2, String userName, String password, SSLClientResource sslClient) throws JMSException {
		throw new UnsupportedOperationException( "Operation not supported! " + providerURL + ", " + paramString2 + ", " + userName + ", " + password );
	}
	
	public QueueConnectionFactory createQueueConnectionFactory(String providerURL, String paramString2, String userName, String password, SSLClientResource sslClient) throws JMSException {
		throw new UnsupportedOperationException( "Operation not supported! " + providerURL + ", " + paramString2 + ", " + userName + ", " + password );
	}
	
	public TopicConnectionFactory createTopicConnectionFactory(String providerURL, String paramString2, String userName, String password, SSLClientResource sslClient) throws JMSException {
		throw new UnsupportedOperationException( "Operation not supported! " + providerURL + ", " + paramString2 + ", " + userName + ", " + password );
	}
	
	public int getCustomAckMode(String text) {
		return Session.AUTO_ACKNOWLEDGE;
	}
	
	public void recoverForCustomAck(int ackMode, Message message) throws JMSException {
	}
	
	public boolean isDisconnectedorFatalException(Exception exception) {
		return false;
	}
	
	public String getInitialContextFactory() {
		return WLInitialContextFactory.class.getName();
	}
	
	private String connectionFactoryKey(String connectionFactoryName, Hashtable<String, String> properties) {
		return properties.get( InitialContext.PROVIDER_URL ) + ":" + connectionFactoryName;
	}
	
	private String destinationKey(String destinationName, Hashtable<String, String> properties) {
		return properties.get( InitialContext.PROVIDER_URL ) + ":" + destinationName;
	}
	
	@SuppressWarnings("unused")
	private Destination createDestination(Session session, String destinationName) throws JMSException {
		if ( session instanceof QueueSession ) {
			return session.createQueue( destinationName );
		}
		if ( session instanceof TopicSession ) {
			return session.createTopic( destinationName );
		}
		throw new JMSException( "Unknown type of destination: " + destinationName + "." );
	}

	@Override
	public ConnectionFactory createUFOGenericConnectionFactory(String arg0,
			String arg1, String arg2, String arg3, SSLClientResource arg4)
			throws JMSException {
		throw new JMSException("Unsupported operation!");
	}

	@Override
	public QueueConnectionFactory createUFOQueueConnectionFactory(String arg0,
			String arg1, String arg2, String arg3, SSLClientResource arg4)
			throws JMSException {
		throw new JMSException("Unsupported operation!");
	}

	@Override
	public TopicConnectionFactory createUFOTopicConnectionFactory(String arg0,
			String arg1, String arg2, String arg3, SSLClientResource arg4)
			throws JMSException {
		throw new JMSException("Unsupported operation!");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Destination resolveDestination(String arg0,
			Hashtable<String, String> arg1, Session arg2, SSLClientResource arg3)
			throws NamingException, JMSException {
		// TODO Auto-generated method stub
		
		return resolveDestination(arg0, arg1, arg2);
	}
}
