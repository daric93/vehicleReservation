package daric.vr.services;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class OrderAlreadyFinishedException extends Exception {
    public OrderAlreadyFinishedException(String message) {
        super(message);
    }
}
