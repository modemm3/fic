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
import com.mx.fic.inventory.business.ProductBean;
import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.ProductDTO;
import com.mx.fic.inventory.endpoint.response.Message;
import com.mx.fic.inventory.endpoint.response.ProductResponse;

@Path("/product")
public class ProductWS {
	@EJB(mappedName="ProductBean") 
	private ProductBean productBean;
	private static final Logger logger = LoggerFactory.getLogger(ProductWS.class);

	@POST
	@Path("saveProduct")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveProduct(ProductDTO productDTO){
		ProductResponse response = new ProductResponse();
		Message message = new Message();
		logger.info("saveProduct");
		
		try {
			if((productDTO.getName()!=null && !productDTO.getName().equals("")) &&
					(productDTO.getMeasureUnitId()!=null && productDTO.getStatusId()!=null)
					&& productDTO.getCompanyId()!=null){
				productBean.save(productDTO);
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
	@Path("getProductByCompany/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getProductByCompany(@PathParam("companyId") Integer companyId){
		ProductResponse response = new ProductResponse();
		List<ProductDTO> productDTOLst= null;
		Message message= new Message();
		logger.info("getProductByCompany");
		
		try{
			if(companyId!= null){
				productDTOLst = new ArrayList<ProductDTO>();
				productDTOLst= productBean.getAllByCompany(companyId);
				response.setProductDTOLst(productDTOLst);
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
