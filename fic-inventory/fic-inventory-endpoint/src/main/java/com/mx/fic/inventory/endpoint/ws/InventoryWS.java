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

import com.mx.fic.inventory.business.InventoryBean;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.InventoryDTO;
import com.mx.fic.inventory.dto.ProductDTO;
import com.mx.fic.inventory.endpoint.response.InventoryResponse;
import com.mx.fic.inventory.endpoint.response.Message;

@Path("/inventoryWS")
public class InventoryWS {
	@EJB(mappedName="InventoryBean")
	private InventoryBean inventoryBean;
	
	private static final Logger logger = LoggerFactory.getLogger(InventoryWS.class);
	
	@POST
	@Path("saveInventory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveInventory(InventoryDTO inventoryDTO){
		InventoryResponse response = new InventoryResponse();
		Message message = new Message();
		
		logger.info("saveInventory");
		
		try{
			if(inventoryDTO.getCompanyId()!=null){
				inventoryBean.save(inventoryDTO);
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
	@Path("getInventoryByCompany/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getInventoryByCompany(@PathParam("companyId") Integer companyId){
		InventoryResponse response = new InventoryResponse();
		Message message = new Message();
		List<InventoryDTO> inventoryDTOLst = null;
		
		try{
			if(companyId!=null){
				inventoryDTOLst = new ArrayList<InventoryDTO>();
				
				inventoryDTOLst = inventoryBean.getAllByCompany(companyId);
				response.setInventoryDTOLst(inventoryDTOLst);
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
	
	public Response getInventoryByProdAndComp(ProductDTO productDTO){
		InventoryResponse response = new InventoryResponse();
		Message message = new Message();
		List<InventoryDTO> inventoryDTOLst = new ArrayList<InventoryDTO>();
		InventoryDTO invDTO = null;
		
		try{
			if(productDTO!=null && (productDTO.getId()!=null && productDTO.getCompanyId()!=null)){
				inventoryDTOLst = new ArrayList<InventoryDTO>();
				invDTO = inventoryBean.findProductByCompany(productDTO);
				
				if(invDTO!=null && (invDTO.getId()!=null && invDTO.getId()!=0)){
					response.setInventoryDTOLst(inventoryDTOLst);
				}
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
