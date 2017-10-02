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

import com.mx.fic.inventory.business.ValuationBeanLocal;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.ValuationDTO;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.endpoint.response.ValuationResponse;

@Path("/valuation")
public class ValuationWS {
	@EJB(mappedName="ValuationBean")
	ValuationBeanLocal valuationBean;
	
	private static final Logger logger = LoggerFactory.getLogger(ValuationWS.class);
	
	@POST
	@Path("saveValuation")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveValuation(ValuationDTO valuationDTO){
		System.out.println("valuation "+ valuationDTO);
		logger.info("Entra a guardar la valuación => "+ valuationDTO);
		ValuationResponse response = new ValuationResponse();
		Message message = new Message();
		
		logger.info("saveValuation");
		
		try{
			if((valuationDTO.getCompanyId()!=null) &&
					(valuationDTO.getDateEnd()!=null && valuationDTO.getDateStart()!=null) &&
					valuationDTO.getExerciseFiscal()!=null &&
					(valuationDTO.getStatusId()!=null && valuationDTO.getValuationTypeId()!=null)){
				valuationBean.saveValuation(valuationDTO);
				message.setCode(200);
				message.setMessage("exito");
			}else{
				message.setCode(400);
				message.setMessage("error => Elementos requeridos vienen nulos, favor de validar");
				
			}
		} catch (PersistenceException e) {
			message.setCode(500);
			message.setMessage("error => Error interno");
			logger.error("Persistence=> " + e);									
		} catch (Exception e){
			message.setCode(500);
			message.setMessage("error => Error interno");
			logger.error("Exception => " + e);									
		}
		response.setMessage(message);
		
		return Response.status(message.getCode()).entity(response).build();
	}
	
	@POST
	@Path("getValuationByCompany/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getValuationByCompany(@PathParam("companyId") Integer companyId){
		logger.info("Entra a obtener la valuación de la compañía => "+ companyId);
		ValuationResponse response = new ValuationResponse();
		List<ValuationDTO> valuationDTOLst = null;
		Message message = new Message();
		
		try{
			if(companyId != null){
				valuationDTOLst = new ArrayList<ValuationDTO>();
				valuationDTOLst = valuationBean.getAllByCompany(companyId);
				response.setValuationDTOLst(valuationDTOLst);
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
