package com.mx.fic.inventory.endpoint.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;

public class CORSResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(final ContainerRequestContext requestContext, final ContainerResponseContext responseContext)
			throws IOException {
		final MultivaluedMap<String, Object> headers;
		headers = responseContext.getHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Credentials", "true");
		headers.add("Access-Control-Allow-Headers", "x-requested-with, origin, Content-Type, accept, auth-token, authorization, session");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
		headers.add("Access-Control-Max-Age", "1000");
		headers.add("Access-Control-Expose-Headers", "session");		
	}

}
