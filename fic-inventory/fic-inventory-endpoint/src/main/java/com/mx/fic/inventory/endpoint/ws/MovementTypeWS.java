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

import com.mx.fic.inventory.business.MovementTypeBean;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.MovementTypeDTO;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.endpoint.response.MovementTypeResponse;

@Path("/movementType")
public class MovementTypeWS {
	@EJB(mappedName="MovementTypeBean")
	private MovementTypeBean movementTypeBean;
	
	private static final Logger logger = LoggerFactory.getLogger(MovementTypeWS.class);
	
	@POST
	@Path("saveMovementType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveMovementType(MovementTypeDTO movementTypeDTO){
		logger.info("Entra a guardar el tipo de movimiento => "+ movementTypeDTO);
		MovementTypeResponse response = new MovementTypeResponse();
		Message message = new Message();
				
		try{
			if((movementTypeDTO!=null && movementTypeDTO.getName()!=null) &&
					(movementTypeDTO.getCompanyId()!=null && movementTypeDTO.getMovementConceptId()!=null) 
					&& movementTypeDTO.getStatusId()!=null){
				movementTypeBean.save(movementTypeDTO);
				message.setCode(200);
				message.setMessage("exito");
			}else{
				message.setCode(400);
				message.setMessage("error => Elementos requeridos vienen nulos, favor de validar");			
			}
			
		}catch(PersistenceException e){
			message.setCode(500);
			message.setMessage("error => Error interno");
		}catch(Exception e){
			message.setCode(500);
			message.setMessage("error => Error interno");
		}
		response.setMessage(message);
		
		return Response.status(message.getCode()).entity(response).build();
	}
	
	@POST
	@Path("getMovementTypeByCompany/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getMovementTypeByCompany(@PathParam("companyId") Integer companyId){
		logger.info("Entra a obtener el tipo de movimiento de la compañía => "+ companyId);
		List<MovementTypeDTO> movementTypeDTOLst = null;
		MovementTypeResponse response = new MovementTypeResponse();
		Message message = new Message();
		
		try{
			if(companyId!=null){
				movementTypeDTOLst = new ArrayList<MovementTypeDTO>();
				movementTypeDTOLst = movementTypeBean.getAllByCompany(companyId);
				message.setCode(200);
				message.setMessage("exito");
				response.setMovementTypeDTOLst(movementTypeDTOLst);				
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
