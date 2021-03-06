package com.mx.fic.inventory.endpoint.ws;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import org.slf4j.LoggerFactory;

import com.mx.fic.inventory.business.StatusBeanLocal;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.StatusDTO;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.endpoint.response.StatusResponse;

@Path("/status")
public class StatusWS {
	
	@EJB(mappedName="StatusBean")
	private StatusBeanLocal statusBean;
	
	private static final Logger logger = LoggerFactory.getLogger(StatusWS.class);
	
	@POST
	@Path("saveStatus")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveStatus(StatusDTO statusDTO){
		logger.info("Entra a guardar el estatus => "+ statusDTO);
		StatusResponse response = new StatusResponse();
		Message message = new Message();
		
		try{
			if((statusDTO!= null && statusDTO.getName()!= null) && 
					statusDTO.getCompanyId()!=null){
				statusBean.save(statusDTO);
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
	@Path("getStatusByCompany/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getStatusByCompany(@PathParam("companyId") Integer companyId){
		logger.info("Entra a obtener el estatus de la compañía => "+ companyId);
		StatusResponse response = new StatusResponse();
		List<StatusDTO> statusDTOLst= null;
		Message message = new Message();
		
		try{
			if(companyId!= null ){
				statusDTOLst= statusBean.getAllByCompany(companyId);
				response.setStatusDTOLst(statusDTOLst);
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
