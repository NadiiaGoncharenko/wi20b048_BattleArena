package Observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private List<Subscriber> subscribers;

    public Publisher() {
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void send( String s, String message) {
        for (Subscriber subscriber: subscribers) {
            subscriber.notify(s,message);
        }
    }
}
