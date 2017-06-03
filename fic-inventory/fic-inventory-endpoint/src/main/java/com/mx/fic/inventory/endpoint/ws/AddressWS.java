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

import com.mx.fic.inventory.business.AddressBean;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.AddressDTO;
import com.mx.fic.inventory.endpoint.response.AddressResponse;
import com.mx.fic.inventory.endpoint.response.Message;

@Path("/address")
public class AddressWS {

	@EJB(mappedName="AddressBean")
	private AddressBean addressBean;
	
	private static final Logger logger = LoggerFactory.getLogger(AddressWS.class);
	
	@POST
	@Path("saveAddress")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveAddress(final AddressDTO addressDTO){
		logger.info("Entra a guardar la dirección => "+ addressDTO);
		AddressResponse response = new AddressResponse();
		Message message = new Message();
		
		logger.info("saveAddress");
		
		try{
			if((addressDTO.getStatusId()!=null && addressDTO.getTypeAddressId()!=null) 
					&& addressDTO.getCompanyId()!=null){
				addressBean.save(addressDTO);
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
	@Path("getAddressByCompany/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAddressByCompany(@PathParam("companyId") Integer companyId){
		logger.info("Entra a obtener la dirección por la compañía => "+ companyId);
		AddressResponse response = new AddressResponse();
		List<AddressDTO> addressDTOLst = null;
		Message message = new Message();
		
		try{
		if(companyId!=null){
			addressDTOLst = new ArrayList<AddressDTO>();
			addressDTOLst = addressBean.getAllByCompany(companyId);
			response.setAddressDTOLst(addressDTOLst);
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
