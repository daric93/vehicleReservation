package daric.vr.services;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class DuplicateEntryException extends Exception{
    public DuplicateEntryException(String message, Throwable cause) {
        super(message, cause);
    }
}
