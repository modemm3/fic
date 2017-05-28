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

import com.mx.fic.inventory.business.ValuationTypeBean;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.ValuationTypeDTO;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.endpoint.response.ValuationTypeResponse;

@Path("/valuationType")
public class ValuationTypeWS {
	@EJB(mappedName="ValuationTypeBean")
	private ValuationTypeBean valuationTypeBean;
	private static final Logger logger = LoggerFactory.getLogger(ValuationTypeWS.class);
	
	@POST
	@Path("saveValuationType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveValuationType(ValuationTypeDTO valuationTypeDTO){
		ValuationTypeResponse response = new ValuationTypeResponse();
		Message message = new Message();
		
		logger.info("saveValuationType");
		
		try{
		if(valuationTypeDTO!=null &&(valuationTypeDTO.getName()!=null && valuationTypeDTO.getKeyValuation()!=null)
				&& valuationTypeDTO.getCompanyDTO()!=null){
			valuationTypeBean.save(valuationTypeDTO);
			message.setCode(200);
			message.setMessage("exitos");
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
	@Path("getValuationTypeByCompany/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getValuationTypeByCompany(@PathParam("companyId") final Integer companyId){
		ValuationTypeResponse response = new ValuationTypeResponse();
		List<ValuationTypeDTO> valuationTypeDTOLst = null;
		Message message = new Message();
		
		try{
			if(companyId!=null){
				valuationTypeDTOLst = new ArrayList<ValuationTypeDTO>();
				valuationTypeDTOLst = valuationTypeBean.getAllByCompany(companyId);
				message.setCode(200);
				message.setMessage("exito");
				response.setValuationTypeLst(valuationTypeDTOLst);
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
