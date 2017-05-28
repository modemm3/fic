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
import com.mx.fic.inventory.business.TimeUnitBean;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.TimeUnitDTO;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.endpoint.response.TimeUnitResponse;

@Path("/timeUnit")
public class TimeUnitWS {
	
	@EJB(mappedName="TimeUnitBean")
	TimeUnitBean timeUnitBean;
	
	private static final Logger logger = LoggerFactory.getLogger(TimeUnitWS.class);

	@POST
	@Path("saveTimeUnit")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveTimeUnit(final TimeUnitDTO timeUnitDTO) throws PersistenceException{
		TimeUnitResponse response = new TimeUnitResponse();
		Message message = new Message();
		
		logger.info("saveTimeUnit");

		try{
			if((timeUnitDTO!= null && timeUnitDTO.getName()!=null) && timeUnitDTO.getId()!=null){
				timeUnitBean.save(timeUnitDTO);
				message.setCode(200);
				message.setMessage("exito");
			}else{
				message.setCode(400);
				message.setMessage("error => Elementos requeridos vienen nulos, favor de validar");			
			}
		} catch (PersistenceException e) {
			message.setCode(500);
			message.setMessage("error => Error interno");
		} catch (Exception e){
			message.setCode(500);
			message.setMessage("error => Error interno");
		}
		
		response.setMessage(message);
		
		return Response.status(message.getCode()).entity(response).build();				
	}
	
	@POST
	@Path("getTimeUnitByCompany/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getTimeUnitByCompany(@PathParam("companyId") Integer companyId){
		TimeUnitResponse response = new TimeUnitResponse();
		List<TimeUnitDTO> timeUnitDTOLst = null;
		Message message = new Message();
		
		try{
			if(companyId!=null){
				timeUnitDTOLst = timeUnitBean.getAllByCompany(companyId);
				response.setTimeUnitDTOLst(timeUnitDTOLst);
				message.setCode(200);
				message.setMessage("exito");
			}else{
				message.setCode(400);
				message.setMessage("error => Es requerido el id de la compañía");			
			}
		}catch(PersistenceException e){
			message.setCode(500);
			message.setMessage("error => Error interno");
		}catch (Exception e){
			message.setCode(500);
			message.setMessage("error => Error interno");
		}
		response.setMessage(message);
		
		return Response.status(message.getCode()).entity(response).build();	
	}
}
