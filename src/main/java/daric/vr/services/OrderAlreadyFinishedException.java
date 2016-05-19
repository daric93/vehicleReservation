package daric.vr.services;

public class OrderAlreadyFinishedException extends Exception {
    public OrderAlreadyFinishedException(String message) {
        super(message);
    }
}
