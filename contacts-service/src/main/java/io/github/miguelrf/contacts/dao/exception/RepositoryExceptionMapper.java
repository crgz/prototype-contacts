package io.github.miguelrf.contacts.dao.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import io.github.miguelrf.contacts.rest.responses.ErrorResponse;
import io.github.miguelrf.contacts.rest.util.MediaTypeWithCharset;

@Provider
public class RepositoryExceptionMapper implements ExceptionMapper<RepositoryException> {

	@Override
	public Response toResponse(RepositoryException exception) {
		ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), 123);
		return Response.status(Status.BAD_REQUEST).type(MediaTypeWithCharset.APPLICATION_JSON_UTF8)
				.entity(errorResponse).build();
	}

}
