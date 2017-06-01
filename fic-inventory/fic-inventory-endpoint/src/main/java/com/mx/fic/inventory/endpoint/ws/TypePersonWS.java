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
import com.mx.fic.inventory.business.TypePersonBean;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.TypePersonDTO;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.endpoint.response.TypePersonResponse;

@Path("/typePerson")
public class TypePersonWS {

	@EJB(mappedName ="TypePersonBean")
	private TypePersonBean typePersonBean;
	private static final Logger logger = LoggerFactory.getLogger(TypePersonWS.class);
	
	@POST
	@Path("saveTypePerson")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveTypePerson(TypePersonDTO typePersonDTO){
		TypePersonResponse response = new TypePersonResponse();
		Message message = new Message();
		
		logger.info("saveTypePerson");
		
		try{
			if((typePersonDTO!=null && typePersonDTO.getCompanyId()!=null) && 
					(typePersonDTO.getName()!=null && !typePersonDTO.getName().equals(""))){
				typePersonBean.save(typePersonDTO);
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
	@Path("getTypePersonByCompany/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getTypePersonByCompany(@PathParam("companyId") final Integer companyId){
		TypePersonResponse response = new TypePersonResponse();
		Message message = new Message();
		List<TypePersonDTO> typePersonDTOLst = null;
		
		try{
			if(companyId != null){
				typePersonDTOLst = new ArrayList<TypePersonDTO>();
				typePersonDTOLst = typePersonBean.getAllByCompany(companyId);
				response.setTypePersonDTOLst(typePersonDTOLst);
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
