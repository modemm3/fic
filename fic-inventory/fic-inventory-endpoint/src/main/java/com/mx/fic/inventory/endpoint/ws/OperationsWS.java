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

import com.mx.fic.inventory.business.OperationsBeanLocal;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.OperationsDTO;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.endpoint.response.OperationsResponse;

@Path("/operations")
public class OperationsWS {

	@EJB(mappedName="OperationsBean")
	private OperationsBeanLocal operationsBean;
	
	private static final Logger logger = LoggerFactory.getLogger(OperationsWS.class);
	
	@POST
	@Path("saveOperations")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveOperations(OperationsDTO operationsDTO){
		System.out.println ("=> "+operationsDTO);

		logger.info("saveOperations inicia save operation => "+ operationsDTO);
		OperationsResponse response = new OperationsResponse();
		Message message = new Message();
		
		try{
			if((operationsDTO!=null && 
					operationsDTO.getCompanyId()!=null) && 
						(operationsDTO.getStatusId()!=null && operationsDTO.getTimeUnitId()!=null) && 
							(operationsDTO.getStocks()!=null && operationsDTO.getProductDTO()!=null) &&
							(operationsDTO.getUnitPrice()!=null && operationsDTO.getUnitPrice()>0) &&
							operationsDTO.getOperationMasterId()!=null){
				operationsBean.save(operationsDTO);
				message.setCode(200);
				message.setMessage("exito");
			}else{
				message.setCode(400);
				message.setMessage("error => Elementos requeridos para operacion vienen nulos, favor de validar");			
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
	@Path("getOperationsByCompany/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getOperationsByCompany(@PathParam("companyId") Integer companyId){
		logger.info("Entra a eliminar la operacion de la compañía => "+ companyId);
		List<OperationsDTO> operationsDTOLst = null;
		OperationsResponse response = new OperationsResponse();
		Message message = new Message();
		
		try{
			if(companyId!=null){
				operationsDTOLst = new ArrayList<OperationsDTO>();
				operationsDTOLst = operationsBean.getAllByCompany(companyId);
				if(operationsDTOLst!=null && operationsDTOLst.size()>0){
					message.setCode(200);
					message.setMessage("exito");
					response.setOperationsDTOLst(operationsDTOLst);
				}else{
					message.setCode(204);
					message.setMessage("No contenido");
				}
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
