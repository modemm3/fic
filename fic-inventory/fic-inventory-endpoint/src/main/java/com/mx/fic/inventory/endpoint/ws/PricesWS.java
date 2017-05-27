package com.mx.fic.inventory.endpoint.ws;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mx.fic.inventory.business.PricesBean;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.PricesDTO;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.endpoint.response.PricesResponse;

@Path("/prices")
public class PricesWS {
	@EJB(mappedName="PricesBean")
	private PricesBean pricesBean;
	
	private static final Logger logger = LoggerFactory.getLogger(PricesWS.class);
	
	@POST
	@Path("savePrice")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response savePrice(PricesDTO pricesDTO){
		PricesResponse response = new PricesResponse();
		Message message = new Message();
		
		logger.info("savePrice");
		
		try{
			if((pricesDTO.getPrice()!=null && pricesDTO.getCompanyDTO()!=null) && 
					(pricesDTO.getProductDTO()!=null && pricesDTO.getSeasonDTO()!=null)
					&& (pricesDTO.getStatusDTO()!=null && pricesDTO.getTypePriceDTO()!=null)){
				pricesBean.save(pricesDTO);
				message.setCode(200);
				message.setMessage("exito");				
			}else{
				message.setCode(400);
				message.setMessage("error => Elementos requeridos vienen nulos, favor de validar");
			}
			
		} catch (PersistenceException e) {
			message.setCode(500);
			message.setMessage("error => Error interno");
		} catch (Exception e){
			message.setCode(500);
			message.setMessage("error => Error interno");
		}
		response.setMessage(message);
		
		return Response.status(message.getCode()).entity(response).build();
	}
	
	

}
