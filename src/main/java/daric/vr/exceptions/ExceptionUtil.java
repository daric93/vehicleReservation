package daric.vr.exceptions;

import javax.ws.rs.core.Response;

public class ExceptionUtil {
    public static Response getResponseWithMessage(String message, int status){
        return Response.status(status).entity(message).build();
    }
}
