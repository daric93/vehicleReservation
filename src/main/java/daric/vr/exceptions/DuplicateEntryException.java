package daric.vr.exceptions;

import javax.ejb.ApplicationException;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;

@ApplicationException(rollback = true)
public class DuplicateEntryException extends ClientErrorException{
    public DuplicateEntryException(String message) {
        super(message, getResponse(message));
    }
    private static Response getResponse(String message){
        return Response.status(409).entity(message).build();
    }
}
