package com.mx.fic.inventory.business;

import com.mx.fic.inventory.dto.ProductDTO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ProductBean prodBean= new ProductBean();
        ProductDTO productDTO = new ProductDTO();
        prodBean.save(productDTO);
    }
}
