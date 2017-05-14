package com.mx.fic.inventory.business;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reflections.Reflections;
import org.reflections.adapters.MetadataAdapter;
import org.reflections.scanners.Scanner;
import org.reflections.serializers.Serializer;
import org.reflections.util.Utils;
import org.reflections.vfs.Vfs;

import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.business.builder.config.TransferObjectAssembler;
import com.mx.fic.inventory.dto.ProductDTO;
import com.mx.fic.inventory.persistent.Product;
import com.mx.fic.inventory.services.ProductRemote;

@RunWith (Arquillian.class)
public class ProductBeanTest {
	@EJB(mappedName="ProductBean")
	ProductRemote product;

	@Deployment
	public static JavaArchive createDeployment(){
		return ShrinkWrap.create(JavaArchive.class, "testEJB.jar")
				.addClasses(ProductBean.class,ProductRemote.class)
				.addPackage(ProductDTO.class.getPackage())
				.addPackage(ProductRemote.class.getPackage())
				.addPackage(Product.class.getPackage())
//				.addPackage(BuilderConfiguration.class.getPackage())
				.addPackage(Utils.class.getPackage())
				.addPackage(Scanner.class.getPackage())
				.addPackage(Serializer.class.getPackage())
				.addPackage(Vfs.class.getPackage())
				.addPackage(MetadataAdapter.class.getPackage())
				.addPackage(TransferObjectAssembler.class.getPackage())
				.addPackage(Reflections.class.getPackage())
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@Test
	public void test() {
        System.out.println( "Hello World!" );
        final ProductBean prodBean= new ProductBean();
        final ProductDTO productDTO = new ProductDTO();
        prodBean.save(productDTO);
	}

}
