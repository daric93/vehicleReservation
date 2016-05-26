package daric.vr.exceptions;

import javax.ws.rs.NotFoundException;

import static daric.vr.exceptions.ExceptionUtil.getResponseWithMessage;

public class EntryNotFoundException extends NotFoundException {
    public EntryNotFoundException(String message) {
        super(message, getResponseWithMessage(message, 404));
    }
}
