package com.mx.fic.inventory.business;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reflections.Reflections;
import org.reflections.adapters.MetadataAdapter;
import org.reflections.scanners.Scanner;
import org.reflections.serializers.Serializer;
import org.reflections.util.Utils;
import org.reflections.vfs.Vfs;

import com.mx.fic.inventory.business.builder.config.TransferObjectAssembler;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.ProductDTO;
import com.mx.fic.inventory.persistent.Product;

@RunWith (Arquillian.class)
public class ProductBeanTest {
	@EJB (mappedName="ProductBean")
	ProductBean product;

	@Deployment
	public static JavaArchive createDeployment(){
		return ShrinkWrap.create(JavaArchive.class, "testEJB.jar")
				.addClasses(ProductBean.class,ProductDTO.class,BaseDTO.class,Product.class)
				.addPackage(Utils.class.getPackage())
				.addPackage(Scanner.class.getPackage())
				.addPackage(Serializer.class.getPackage())
				.addPackage(Vfs.class.getPackage())
				.addPackage(MetadataAdapter.class.getPackage())
				.addPackage(TransferObjectAssembler.class.getPackage())
				.addPackage(Reflections.class.getPackage())
				.addPackage(Product.class.getPackage())
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@Test
	public void test() {
        System.out.println( "Hello World!" );
        ProductBean prodBean= new ProductBean();
        ProductDTO productDTO = new ProductDTO();
        prodBean.save(productDTO);
	}

}
