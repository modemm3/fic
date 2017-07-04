package com.mx.fic.inventory.endpoint.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mx.fic.inventory.business.InventoryOperationBeanLocal;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.InventoryOperationDTO;
import com.mx.fic.inventory.endpoint.response.InventoryOperationResponse;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.request.InventoryOperationRequest;

@Path("/InventoryOperation")
public class InventoryOperationWS {
	
	@EJB(mappedName="InventoryOperationBean")
	private InventoryOperationBeanLocal inventoryOperationBean;

	private static final Logger logger = LoggerFactory.getLogger(InventoryOperationWS.class);
	
	@POST
	@Path("getInvOpByProductAndComp")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getInvOpByProductAndComp(final InventoryOperationRequest request){
		logger.info("Se obtiene de la operación de inventario el producto por compañía => "+ request);
		List<InventoryOperationDTO> lstDTO = new ArrayList<InventoryOperationDTO>();
		InventoryOperationResponse response = new InventoryOperationResponse();
		Message message = new Message();
		
		try{
			
			if(request!= null && (request.getCompanyId()!=null && request.getProductId()!=null)){
				lstDTO = inventoryOperationBean.getAllByProductAndCompany(request);
				response.setInventoryOperationDTO(lstDTO);
				message.setCode(200);
				message.setMessage("exito");
			}else{
				message.setCode(400);
				message.setMessage("error => Elementos requeridos vienen nulos, favor de validar");				
			}
			
		}catch(PersistenceException e){
			message.setCode(500);
			message.setMessage("PersistenceException => Error interno");
			logger.error("Persistence => "+ e);
		}catch(Exception e){
			message.setCode(500);
			message.setMessage("Exception => Error interno");
			logger.error("Exception => "+ e);
		}
		
		response.setMessage(message);
		
		return Response.status(message.getCode()).entity(response).build();
	}
}
