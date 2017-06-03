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

import com.mx.fic.inventory.business.ProviderBean;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.ProviderDTO;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.endpoint.response.ProviderResponse;

@Path("/provider")
public class ProviderWS {
	
	@EJB(mappedName="ProviderBean")
	private ProviderBean providerBean;
	
	private static final Logger logger = LoggerFactory.getLogger(ProviderWS.class);
	
	@POST
	@Path("saveProvider")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveProvider(final ProviderDTO providerDTO){
		logger.info("Entra a guardar el proveedor => "+ providerDTO);
		ProviderResponse response = new ProviderResponse();
		Message message = new Message();
		
		try{
			if((providerDTO!=null && providerDTO.getCompanyId()!=null) &&
					(providerDTO.getCompanyId()!=null && providerDTO.getStatusId()!=null)){
				providerBean.save(providerDTO);
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
	@Path("getProviderByCompany/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getProviderByCompany(@PathParam("companyId") final Integer companyId){
		logger.info("Entra a obtener el proveedor de la companía => "+ companyId);
		ProviderResponse response = new ProviderResponse();
		List<ProviderDTO> providerDTOLst = null;
		Message message = new Message();
		
		try{
			if(companyId != null){
				providerDTOLst = new ArrayList<ProviderDTO>();
				providerDTOLst = providerBean.getAllByCompany(companyId);
				response.setProviderDTOLst(providerDTOLst);
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
