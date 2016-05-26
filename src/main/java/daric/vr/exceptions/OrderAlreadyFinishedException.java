package daric.vr.exceptions;

import javax.ejb.ApplicationException;
import javax.ws.rs.ClientErrorException;

import static daric.vr.exceptions.ExceptionUtil.getResponseWithMessage;

@ApplicationException(rollback = true)
public class OrderAlreadyFinishedException extends ClientErrorException {
    public OrderAlreadyFinishedException(String message) {
        super(message, getResponseWithMessage(message, 406));
    }
}
