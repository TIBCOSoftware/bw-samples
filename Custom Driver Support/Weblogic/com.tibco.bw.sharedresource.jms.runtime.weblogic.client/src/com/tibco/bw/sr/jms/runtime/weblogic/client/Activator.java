package com.tibco.bw.sr.jms.runtime.weblogic.client;

import java.util.LinkedList;
import java.util.List;

import javax.naming.spi.InitialContextFactory;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.tibco.bw.sr.jms.runtime.api.JMSProviderHelper;

import weblogic.jndi.WLInitialContextFactory;

public class Activator implements BundleActivator {
	private static BundleContext context = null;
	private final List<ServiceRegistration<?>> registry = new LinkedList<ServiceRegistration<?>>();
	
	public static BundleContext getContext() {
		return context;
	}
	
	public void start(BundleContext bundleContext) throws Exception {
		context = bundleContext;
		
		final WLInitialContextFactory contextFactory = new WLInitialContextFactory();
	    ServiceRegistration<?> serviceRegistration = context.registerService(
	    		new String[] { InitialContextFactory.class.getName(), WLInitialContextFactory.class.getName() }, contextFactory, null
	    );
	    registry.add( serviceRegistration );
		
	    final WebLogicJMSProvider weblogicJMSProvider = new WebLogicJMSProvider();
	    serviceRegistration = context.registerService( JMSProviderHelper.class.getName(), weblogicJMSProvider, null );
	    registry.add( serviceRegistration );
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		for ( ServiceRegistration<?> service : registry ) { 
			service.unregister();
		}
		registry.clear();
		context = null;
	}
}
