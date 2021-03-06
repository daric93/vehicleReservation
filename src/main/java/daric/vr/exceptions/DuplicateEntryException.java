package daric.vr.exceptions;

import javax.ejb.ApplicationException;
import javax.ws.rs.ClientErrorException;

import static daric.vr.exceptions.ExceptionUtil.getResponseWithMessage;

@ApplicationException(rollback = true)
public class DuplicateEntryException extends ClientErrorException {
    public DuplicateEntryException(String message) {
        super(message, getResponseWithMessage(message, 409));
    }
}
