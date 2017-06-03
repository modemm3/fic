package com.mx.fic.inventory.endpoint.ws;

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

import com.mx.fic.inventory.business.MovementConceptBean;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.MovementConceptDTO;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.endpoint.response.MovementConceptResponse;

@Path("/movementConcept")
public class MovementConceptWS {

	@EJB(mappedName="MovementConceptBean")
	private MovementConceptBean  movementConceptBean;
	
	private static final Logger logger = LoggerFactory.getLogger(MovementConceptBean.class);
	
	@POST
	@Path("saveMovementConcept")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveMovementConcept(MovementConceptDTO movementConceptDTO){
		logger.info("Entra a guardar el concepto movimiento => "+ movementConceptDTO);
		MovementConceptResponse response = new MovementConceptResponse();
		Message message = new Message();
		
		try{
			if((movementConceptDTO!=null && movementConceptDTO.getName()!=null) 
					&& (movementConceptDTO.getCompanyId()!=null && movementConceptDTO.getStatusId()!=null)){
				movementConceptBean.save(movementConceptDTO);
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
	
	@POST
	@Path("getMovementConcetpByCompany/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getMovementConcetpByCompany(@PathParam("companyId") Integer companyId){
		logger.info("Entra a obtener el concepto movimiento por compañía => "+ companyId);
		MovementConceptResponse response = new MovementConceptResponse();
		Message message = new Message();
		List<MovementConceptDTO> movementConceptDTOLst = null;
		
		try{
			if(companyId != null){
				movementConceptDTOLst = movementConceptBean.getAllByCompany(companyId);
				response.setMovementConceptLst(movementConceptDTOLst);
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
		}catch(Exception e){
			message.setCode(500);
			message.setMessage("error => Error interno");
			logger.error("Exception => " + e);			
		}
		response.setMessage(message);
		return Response.status(message.getCode()).entity(response).build();		
	}
	
	
}
