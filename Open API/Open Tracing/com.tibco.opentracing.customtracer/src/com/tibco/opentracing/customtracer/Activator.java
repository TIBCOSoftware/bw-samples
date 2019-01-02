package com.tibco.opentracing.customtracer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.tibco.bw.tpcl.io.opentracing.TracingHelper;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		TracingHelper.deregisterServices();
		Activator.context = null;
	}

}
