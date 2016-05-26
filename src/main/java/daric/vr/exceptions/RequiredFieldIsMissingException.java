package daric.vr.exceptions;

import javax.ws.rs.ClientErrorException;

import static daric.vr.exceptions.ExceptionUtil.getResponseWithMessage;

public class RequiredFieldIsMissingException extends ClientErrorException {
    public RequiredFieldIsMissingException(String message) {
        super(message, getResponseWithMessage(message, 400));
    }
}
