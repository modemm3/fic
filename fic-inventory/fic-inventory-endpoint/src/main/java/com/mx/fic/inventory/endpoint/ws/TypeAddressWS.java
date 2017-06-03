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
import com.mx.fic.inventory.business.TypeAddressBean;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.TypeAddressDTO;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.endpoint.response.TypeAddressResponse;
import com.mx.fic.inventory.persistent.TypeAddress;

@Path("/typeAddress")
public class TypeAddressWS {
	@EJB(mappedName="TypeAddressBean")
	private TypeAddressBean typeAddressBean;
	
	private static final Logger logger = LoggerFactory.getLogger(TypeAddress.class);
	
	@POST
	@Path("saveTypeAddress")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveTypeAddress(TypeAddressDTO typeAddressDTO){
		logger.info("Entra a guardar el tipo de dirección => "+ typeAddressDTO);
		TypeAddressResponse response = new TypeAddressResponse();
		Message message = new Message();
		
		try{
			if((typeAddressDTO!=null && typeAddressDTO.getName()!=null) &&
					typeAddressDTO.getCompanyId()!=null){
				typeAddressBean.save(typeAddressDTO);
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
	@Path("getTypeAddressByCompany/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getTypeAddressByCompany(@PathParam("companyId") Integer companyId){
		logger.info("Entra a obtener el tipo de dirección de la compañía => "+ companyId);
		final TypeAddressResponse response = new TypeAddressResponse();
		List<TypeAddressDTO> typeAddresDTOLst = null;
		Message message = new Message();
		
		try{
			if(companyId != null){
				
				typeAddresDTOLst = typeAddressBean.getAllByCompany(companyId);
				response.setTypeAddressDTOLst(typeAddresDTOLst);
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
