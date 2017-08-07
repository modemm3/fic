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

import com.mx.fic.inventory.business.OperationMasterBeanLocal;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.OperationMasterDTO;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.endpoint.response.OperationMasterResponse;

@Path("/operationMaster")
public class OperationMasterWS {
	                 
	@EJB(mappedName="OperationMasterBean")
	private OperationMasterBeanLocal operationMasterBean;
	
	private static final Logger logger = LoggerFactory.getLogger(OperationMasterWS.class);
	
	@POST
	@Path("saveOperationMaster")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveOperationMaster(OperationMasterDTO operationMasterDTO){
		logger.info("save ", operationMasterDTO);
		OperationMasterResponse response = new OperationMasterResponse();
		Message message = new Message();
		int operationMasterId=0;
		
		try{
			if(operationMasterDTO.getCompanyId()!=null && operationMasterDTO.getMovementTypeId()!=null
					&& operationMasterDTO.getOperationDate()!=null && operationMasterDTO.getStatusId()!=null){
				operationMasterId = operationMasterBean.save(operationMasterDTO);
				if(operationMasterId!=0){
					response.setOperationMasterId(operationMasterId);
					message.setCode(200);
					message.setMessage("exito");
				}else{
					message.setCode(204);
					message.setMessage("Not content");
				}
			}else{
				message.setCode(400);
				message.setMessage("error => Elementos requeridos vienen nulos, favor de validar");
			}
		}catch(PersistenceException e){
			logger.error("Error WS ", e);
			message.setCode(500);
			message.setMessage("Internal Error");
		}catch(Exception e){
			logger.error("Error WS ",  e);
			message.setCode(500);
			message.setMessage("Internal Error");
		}
		response.setMessage(message);
		return Response.status(message.getCode()).entity(response).build();
			
	}
	
}
