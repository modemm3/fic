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

import com.mx.fic.inventory.business.CompanyBeanLocal;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.request.CompanyRequest;

@Path("/company")
public class CompanyWS {
	
	@EJB(mappedName="CompanyBean")
	CompanyBeanLocal companyBean;
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyWS.class);
	
	@POST
	@Path("saveCompanyAddress")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveCompanyAddress(CompanyRequest request){
		Message message = new Message();
		logger.info("request:{}",request);
		try{
			if(request.getCompanyDTO()!=null && request.getAddressDTO()!=null){
				companyBean.saveCompanyAddress(request);
				message.setCode(200);
				message.setMessage("exito");
			}else{
				message.setCode(400);
				message.setMessage("error => Elementos requeridos vienen nulos, favor de validar");
			}
			
		}catch (PersistenceException e) {
			message.setCode(500);
			message.setMessage("error => Error interno");
			logger.error("Persistence=> " + e);			
		} catch (Exception e){
			message.setCode(500);
			message.setMessage("error => Error interno");
			logger.error("Exception => " + e);			
		}
		
		return Response.status(message.getCode()).entity(message).build();
	}

}
