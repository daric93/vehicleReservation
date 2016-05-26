package daric.vr.exceptions;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;

public class RequiredFieldIsMissingException extends ClientErrorException{
    public RequiredFieldIsMissingException(String message) {
        super(message, getResponse(message));
    }
    private static Response getResponse(String message){
        return Response.status(400).entity(message).build();
    }
}
