package com.mx.fic.inventory.endpoint.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mx.fic.inventory.business.ProductBean;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.ProductDTO;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.endpoint.response.ProductResponse;

@Path("/product")
public class ProductWS {
	@EJB(mappedName="ProductBean") 
	private ProductBean productBean;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductWS.class);

	@POST
	@Path("authenticate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveProduct(@FormParam("productDTO") final ProductDTO productDTO){
		ProductResponse response = new ProductResponse();
		Message message = new Message();
		int status=200;
		LOGGER.info("Aunthenticate");
		
		try {
			if((productDTO.getName()!=null && !productDTO.getName().equals("")) &&
					(productDTO.getMeasureUnitDTO()!= null && productDTO.getMeasureUnitDTO().getId()!=null)
					&& (productDTO.getCompanyDTO()!=null && productDTO.getCompanyDTO().getId()!=null)
					&& productDTO.getStatusDTO()!= null && productDTO.getStatusDTO().getId()!=null){
				productBean.save(productDTO);
				message.setCode(200);
				message.setMessage("exito");
			}else{
				status= 400;
				message.setCode(400);
				message.setMessage("error => Elementos requeridos vienen nulos, favor de validar");
			}
		} catch (PersistenceException e) {
			status=500;
			message.setCode(500);
			message.setMessage("error => Error interno");
			e.printStackTrace();
		} catch (Exception e){
			status= 500;
			message.setCode(500);
			message.setMessage("error => Error interno");
			e.printStackTrace();
		}
		
		response.setMessage(message);

		return Response.status(status).entity(response).build();
	}
	
	@POST
	@Path("authenticate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getProduct(@FormParam("ProductDTO") final ProductDTO productDTO){
		ProductResponse response = new ProductResponse();
		@SuppressWarnings("unused")
		List<ProductDTO> productDTOLst= null;
		Message message= new Message();
		int status= 200;
		LOGGER.info("Aunthenticate");
		
		try{
			if(productDTO.getCompanyDTO()!= null && productDTO.getCompanyDTO().getId()>0){
				productDTOLst = new ArrayList<ProductDTO>();
				productDTOLst= productBean.getAllByCompany(productDTO.getCompanyDTO().getId());
				message.setCode(200);
				message.setMessage("exito");
			}else{
				status= 400;
				message.setCode(400);
				message.setMessage("error => Es requerido el id de la compañía");
			}
		}catch(PersistenceException e){
			status = 500;
			message.setCode(500);
			message.setMessage("error => Error interno");
			e.printStackTrace();
		}catch (Exception e){
			status= 500;
			message.setCode(500);
			message.setMessage("error => Error interno");
			e.printStackTrace();
		}
		
		response.setMessage(message);
		return Response.status(status).entity(response).build();
	}
}
