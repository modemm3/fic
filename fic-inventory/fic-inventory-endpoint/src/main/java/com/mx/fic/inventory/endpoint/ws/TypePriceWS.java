package com.mx.fic.inventory.endpoint.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.business.TypePriceBeanLocal;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.TypePriceDTO;
import com.mx.fic.inventory.endpoint.response.TypePriceResponse;

/**
 * Se expone el servicio que contiene las operaciones de los tipos de
 * precio pertenecientes a una compañía
 * @author developer
 *
 */
@Path("/typePrice")
public class TypePriceWS {
	@EJB(mappedName= "TypePriceBean")
	private TypePriceBeanLocal typePriceBean;
	private static final Logger logger = LoggerFactory.getLogger(TypePriceWS.class);

	@POST
	@Path("saveTypePrice")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveTypePrice(TypePriceDTO typePriceDTO){
		logger.info("Entra a guardar el tipo de precio => "+ typePriceDTO);
		TypePriceResponse response = new TypePriceResponse();
		Message message = new Message();
		
		logger.info("saveTypePrice");
		
		try{
			if((typePriceDTO!=null && typePriceDTO.getName()!=null) && 
					(typePriceDTO.getCompanyId()!=null && typePriceDTO.getStatusId()!=null)){
				typePriceBean.save(typePriceDTO);
				message.setCode(200);
				message.setMessage("exito");
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

	@PUT
	@Path("typePriceById")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response typePriceById(TypePriceDTO typePriceDTO){
		logger.info("Entra a actualiar el tipo de precios => "+ typePriceDTO);
		TypePriceResponse response = new TypePriceResponse();
		Message message = new Message();
		boolean update = false;
		try{
			if((typePriceDTO!=null && typePriceDTO.getName()!=null && typePriceDTO.getStatusId()!=null) && 
					(typePriceDTO.getId()!=null && typePriceDTO.getDescription()!=null)){
				update = typePriceBean.update(typePriceDTO);
				if(update){
					message.setCode(200);
					message.setMessage("exito");
				}else{
					message.setCode(204);
					message.setMessage("No se actualizo el registro, verifique que exista");
				}
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
	@Path("getTypePriceByCompany/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getTypePriceByCompany(@PathParam("companyId") final Integer companyId){
		logger.info("Entra a obtener el tipo de precio de la compañía => "+ companyId);
		TypePriceResponse response = new TypePriceResponse();
		List<TypePriceDTO> typePriceDTOLst= null;
		Message message = new Message();
		
		try{
			if(companyId!= null){
				typePriceDTOLst = new ArrayList<TypePriceDTO>();
				typePriceDTOLst= typePriceBean.getAllByCompany(companyId);
				response.setTypePriceDTOLst(typePriceDTOLst);
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
