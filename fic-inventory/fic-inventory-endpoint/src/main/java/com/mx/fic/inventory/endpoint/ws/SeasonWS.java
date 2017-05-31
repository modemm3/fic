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
import com.mx.fic.inventory.business.SeasonBean;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.SeasonDTO;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.endpoint.response.SeasonResponse;

@Path("/season")
public class SeasonWS {

	@EJB(mappedName="SeasonBean")
	private SeasonBean seasonBean;
	private static final Logger logger = LoggerFactory.getLogger(SeasonWS.class);
	
	@POST
	@Path("saveSeason")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveSeason(SeasonDTO seasonDTO){
		SeasonResponse response = new SeasonResponse();
		Message message = new Message();
		logger.info("saveSeason");
		
		try{
			if((seasonDTO!=null && seasonDTO.getName()!=null) &&
					seasonDTO.getCompanyId()!=null){
				seasonBean.save(seasonDTO);
				message.setCode(200);
				message.setMessage("exito");
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
	@Path("getSeasonByCompany/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getseasonByCompany(@PathParam("companyId") Integer companyId){
		SeasonResponse response = new SeasonResponse();
		Message message = new Message();
		List<SeasonDTO> seasonDTOLst= null;
		
		try{
			if(companyId!=null){
				seasonDTOLst= seasonBean.getAllByCompany(companyId);
				response.setSeasonDTOLst(seasonDTOLst);
				message.setCode(200);
				message.setMessage("exito");
			}else{
				message.setCode(400);
				message.setMessage("error => Es requerido el id de la compañía");
			}
		}catch(PersistenceException e){
			message.setCode(500);
			message.setMessage("error => Error interno");
		}catch(Exception e){
			logger.error("error al obtener los estatus por compañía");
			message.setCode(500);
			message.setMessage("error => Error interno");
		}
		response.setMessage(message);
		return Response.status(message.getCode()).entity(response).build();		
	}
	
}
