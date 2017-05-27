/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.fic.inventory.endpoint.config;

import java.util.Set;

import javax.ws.rs.core.Application;

import com.mx.fic.inventory.endpoint.filter.CORSResponseFilter;
import com.mx.fic.inventory.endpoint.ws.MeasureUnitWS;
import com.mx.fic.inventory.endpoint.ws.PricesWS;
import com.mx.fic.inventory.endpoint.ws.ProductWS;
import com.mx.fic.inventory.endpoint.ws.SeasonWS;
import com.mx.fic.inventory.endpoint.ws.StatusWS;
import com.mx.fic.inventory.endpoint.ws.TimeUnitWS;
import com.mx.fic.inventory.endpoint.ws.TypePriceWS;

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
		resources.add(MeasureUnitWS.class);
		resources.add(PricesWS.class);
		resources.add(SeasonWS.class);
		resources.add(StatusWS.class);
		resources.add(TypePriceWS.class);
		resources.add(TimeUnitWS.class);
		resources.add(CORSResponseFilter.class);
		
	}
    

    
}
