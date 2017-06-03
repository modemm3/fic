/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.fic.inventory.endpoint.config;

import java.util.Set;
import javax.ws.rs.core.Application;
import com.mx.fic.inventory.endpoint.filter.CORSResponseFilter;
import com.mx.fic.inventory.endpoint.ws.AddressWS;
import com.mx.fic.inventory.endpoint.ws.InventoryWS;
import com.mx.fic.inventory.endpoint.ws.LoginWS;
import com.mx.fic.inventory.endpoint.ws.MeasureUnitWS;
import com.mx.fic.inventory.endpoint.ws.MovementConceptWS;
import com.mx.fic.inventory.endpoint.ws.MovementTypeWS;
import com.mx.fic.inventory.endpoint.ws.OperationsWS;
import com.mx.fic.inventory.endpoint.ws.PricesWS;
import com.mx.fic.inventory.endpoint.ws.TypeAddressWS;
import com.mx.fic.inventory.endpoint.ws.TypePersonWS;
import com.mx.fic.inventory.endpoint.ws.ProductWS;
import com.mx.fic.inventory.endpoint.ws.ProviderWS;
import com.mx.fic.inventory.endpoint.ws.SeasonWS;
import com.mx.fic.inventory.endpoint.ws.StatusWS;
import com.mx.fic.inventory.endpoint.ws.TimeUnitWS;
import com.mx.fic.inventory.endpoint.ws.TypePriceWS;
import com.mx.fic.inventory.endpoint.ws.ValuationTypeWS;
import com.mx.fic.inventory.endpoint.ws.ValuationWS;

/**
 * */
@javax.ws.rs.ApplicationPath("/services")
public class ApplicationConfig extends Application {

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
		resources.add(ValuationTypeWS.class);
		resources.add(CORSResponseFilter.class);
		resources.add(MovementConceptWS.class);
		resources.add(MovementTypeWS.class);
		resources.add(TypeAddressWS.class);
		resources.add(AddressWS.class);
		resources.add(ProviderWS.class);
		resources.add(ValuationTypeWS.class);
		resources.add(ValuationWS.class);
		resources.add(OperationsWS.class);
		resources.add(TypePersonWS.class);
		resources.add(InventoryWS.class);
		resources.add(LoginWS.class);

	}
    
}
