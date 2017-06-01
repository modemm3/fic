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
import com.mx.fic.inventory.business.MeasureUnitBean;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.MeasureUnitDTO;
import com.mx.fic.inventory.endpoint.response.MeasureUnitResponse;
import com.mx.fic.inventory.endpoint.response.Message;

@Path("/measureUnit")
public class MeasureUnitWS {
	@EJB(mappedName="MeasureUnitBean")
	private MeasureUnitBean measureUnitBean;
	private static final Logger logger = LoggerFactory.getLogger(MeasureUnitWS.class);

	@POST
	@Path("saveMeasureUnit")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveMeasureUnit(MeasureUnitDTO measureUnitDTO){
		MeasureUnitResponse response = new MeasureUnitResponse();
		Message message = new Message();
		logger.info("saveMeasureUnit");
		
		try{
			if((measureUnitDTO!=null && measureUnitDTO.getName()!=null) &&
					measureUnitDTO.getCompanyId()!=null){
				measureUnitBean.save(measureUnitDTO);
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
	@Path("getMeasureUnitByCompany/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getMeasureUnitByCompany(@PathParam("companyId") Integer companyId){
		MeasureUnitResponse response = new MeasureUnitResponse();
		List<MeasureUnitDTO> measureUnitDTOLst = null;
		Message message = new Message();
		
		try{
			if(companyId!=null){
				measureUnitDTOLst = new ArrayList<MeasureUnitDTO>();
				measureUnitDTOLst = measureUnitBean.getAllByCompany(companyId);
				response.setMeasureUnitDTOLst(measureUnitDTOLst);
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
