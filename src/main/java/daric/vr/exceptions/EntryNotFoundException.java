package daric.vr.exceptions;

import javax.ejb.ApplicationException;
import javax.ws.rs.NotFoundException;

import static daric.vr.exceptions.ExceptionUtil.getResponseWithMessage;

@ApplicationException(rollback = true)
public class EntryNotFoundException extends NotFoundException {
    public EntryNotFoundException(String message) {
        super(message, getResponseWithMessage(message, 404));
    }
}
