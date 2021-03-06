package com.mx.fic.inventory.endpoint.ws;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mx.fic.inventory.business.PricesBeanLocal;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.PricesDTO;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.endpoint.response.PricesResponse;

@Path("/prices")
public class PricesWS {
	@EJB(mappedName="PricesBean")
	private PricesBeanLocal pricesBean;
	
	private static final Logger logger = LoggerFactory.getLogger(PricesWS.class);
	
	@POST
	@Path("savePrice")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response savePrice(PricesDTO pricesDTO){
		logger.info("Entr a guardar el precio => "+ pricesDTO);
		PricesResponse response = new PricesResponse();
		Message message = new Message();
		
		logger.info("savePrice");
		
		try{
			if((pricesDTO.getPrice()!=null && pricesDTO.getCompanyId()!=null) && (pricesDTO.getProductId()!=null && pricesDTO.getSeasonId()!=null)
					&& (pricesDTO.getStatusId()!=null && pricesDTO.getTypePriceId()!=null)){
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
			logger.error("Persistence=> " + e);						
		} catch (Exception e){
			message.setCode(500);
			message.setMessage("error => Error interno");
			logger.error("Exception => " + e);						
		}
		response.setMessage(message);
		
		return Response.status(message.getCode()).entity(response).build();
	}
	
	@POST
	@Path("getPricesByCompany/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getPricesByCompany(@PathParam("companyId") Integer companyId){
		logger.info("Entra a obtener los precios de la compañía => "+ companyId);
		PricesResponse response = new PricesResponse();
		List<PricesDTO> pricesDTOLst = null;
		Message message = new Message();
		
		try{
		if(companyId!=null){
			pricesDTOLst = new ArrayList<PricesDTO>();
			pricesDTOLst= pricesBean.getAllByCompany(companyId);
			response.setPricesDTOLst(pricesDTOLst);
			message.setCode(200);
			message.setMessage("exito");
			
		}else{
			message.setCode(400);
			message.setMessage("error => Es requerido el id de la compañía");
		}
		}catch(PersistenceException e){
			message.setCode(500);
			message.setMessage("error => Error interno");
			logger.error("Persistence=> " + e);						
		}catch (Exception e){
			message.setCode(500);
			message.setMessage("error => Error interno");
			logger.error("Exception => " + e);						
		}
		response.setMessage(message);
		
		return Response.status(message.getCode()).entity(response).build();
		
	}
	
	
	

}
