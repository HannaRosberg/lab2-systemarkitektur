package exceptionmapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class InvalidProductStateExceptionMapper implements ExceptionMapper<InvalidWarehouseOperationException> {
    private static final Logger logger = LoggerFactory.getLogger(InvalidProductStateExceptionMapper.class);

    @Override
    public Response toResponse(InvalidWarehouseOperationException e) {
        logger.error("Exception of type IllegalProductWarehouseStateException happened.");
        return Response.status(Response.Status.NOT_ACCEPTABLE)
                .entity("This endpoint doesn't seem to accept your request")
                .build();
    }
}