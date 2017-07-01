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

import com.mx.fic.inventory.business.ValuationTypeBeanLocal;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.ValuationTypeDTO;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.endpoint.response.ValuationTypeResponse;

@Path("/valuationType")
public class ValuationTypeWS {
	@EJB(mappedName="ValuationTypeBean")
	private ValuationTypeBeanLocal valuationTypeBean;
	private static final Logger logger = LoggerFactory.getLogger(ValuationTypeWS.class);
	
	@POST
	@Path("saveValuationType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveValuationType(ValuationTypeDTO valuationTypeDTO){
		logger.info("Entra a guardar el tipo de valuación => "+ valuationTypeDTO);
		ValuationTypeResponse response = new ValuationTypeResponse();
		Message message = new Message();
		
		logger.info("saveValuationType");
		
		try{
		if(valuationTypeDTO!=null &&(valuationTypeDTO.getName()!=null && valuationTypeDTO.getKeyValuation()!=null)){
			valuationTypeBean.save(valuationTypeDTO);
			message.setCode(200);
			message.setMessage("exitos");
		}else{
			message.setCode(400);
			message.setMessage("error => Elementos requeridos vienen nulos, favor de validar");			
		}
		}catch(PersistenceException e){
			message.setCode(500);
			message.setMessage("error => Error interno");
			logger.error("Persistence=> " + e);									
		}catch(Exception e){
			message.setCode(500);
			message.setMessage("error => Error interno");
			logger.error("Exception => " + e);			
		}
		response.setMessage(message);
		
		return Response.status(message.getCode()).entity(response).build();
	
	}
	
	@POST
	@Path("getAllValuationType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllValuationType(){
		logger.info("Entra a obtener los tipos de valuaciones existentes");
		ValuationTypeResponse response = new ValuationTypeResponse();
		List<ValuationTypeDTO> valuationTypeDTOLst = null;
		Message message = new Message();
		
		try{
				valuationTypeDTOLst = new ArrayList<ValuationTypeDTO>();
				valuationTypeDTOLst = valuationTypeBean.getAll();
				message.setCode(200);
				message.setMessage("exito");
				response.setValuationTypeLst(valuationTypeDTOLst);
		
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
