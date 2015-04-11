package de.koehler.money.bondary;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("resources")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> rootResources = new HashSet<Class<?>>();
		rootResources.add(AccountsResource.class);
		return rootResources;
	}
}
