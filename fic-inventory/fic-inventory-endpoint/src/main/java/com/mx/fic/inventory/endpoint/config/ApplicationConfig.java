/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.fic.inventory.endpoint.config;

import java.util.Set;

import javax.ws.rs.core.Application;

import com.mx.fic.inventory.endpoint.filter.CORSResponseFilter;
import com.mx.fic.inventory.endpoint.ws.ProductWS;

/**
 * */
@javax.ws.rs.ApplicationPath("/services")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
	}
	private void addRestResourceClasses(final Set<Class<?>> resources) {
		resources.add(ProductWS.class);
		resources.add(CORSResponseFilter.class);
	}
    

    
}
