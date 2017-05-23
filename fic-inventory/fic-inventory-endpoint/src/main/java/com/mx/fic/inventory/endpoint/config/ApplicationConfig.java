/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.fic.inventory.endpoint.config;

import org.glassfish.jersey.server.ResourceConfig;

import com.mx.fic.inventory.endpoint.filter.CORSResponseFilter;

/**
 * */
@javax.ws.rs.ApplicationPath("/services")
public class ApplicationConfig extends ResourceConfig {

	public ApplicationConfig() {
		packages("com.mx.fic.inventory.endpoint.ws");
		register(CORSResponseFilter.class);
	}
    

    
}
