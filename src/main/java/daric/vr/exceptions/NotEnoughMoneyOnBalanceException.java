package daric.vr.exceptions;

import javax.ws.rs.ClientErrorException;

import static daric.vr.exceptions.ExceptionUtil.getResponseWithMessage;

public class NotEnoughMoneyOnBalanceException extends ClientErrorException {
    public NotEnoughMoneyOnBalanceException(String message) {
        super(message, getResponseWithMessage(message, 402));
    }
}
