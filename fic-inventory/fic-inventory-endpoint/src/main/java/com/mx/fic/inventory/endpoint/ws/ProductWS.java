package com.mx.fic.inventory.endpoint.ws;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.mx.fic.inventory.business.ProductBean;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.ProductDTO;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.endpoint.response.ProductResponse;

@Path("/product")
public class ProductWS {
	@EJB(mappedName="ProductBean") 
	private ProductBean productBean;

	@POST
	@Path("authenticate")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response saveProduct(@FormParam("productDTO") final ProductDTO productDTO){
		ProductResponse response = new ProductResponse();
		Message message = new Message();
		int status=200;
		
		try {
			if((productDTO.getName()!=null && !productDTO.getName().equals("")) &&
					(productDTO.getMeasureUnitDTO()!= null && productDTO.getMeasureUnitDTO().getId()!=null)
					&& (productDTO.getCompanyDTO()!=null && productDTO.getCompanyDTO().getId()!=null)
					&& productDTO.getStatusDTO()!= null && productDTO.getStatusDTO().getId()!=null){
				productBean.save(productDTO);
				message.setCode(200);
				message.setMessage("exito");
				response.setMessage(message);
			}else{
				status= 400;
				message.setCode(400);
				message.setMessage("error => Elementos requeridos vienen nulos, favor de validar");
				response.setMessage(message);
			}
		} catch (PersistenceException e) {
			status=500;
			message.setCode(500);
			message.setMessage("error => Error interno");
			response.setMessage(message);
			e.printStackTrace();
		} catch (Exception e){
			status= 500;
			message.setCode(500);
			message.setMessage("error => Error interno");
			response.setMessage(message);
			e.printStackTrace();
		}
		
		return Response.status(status).entity(response).build();
	}
}
