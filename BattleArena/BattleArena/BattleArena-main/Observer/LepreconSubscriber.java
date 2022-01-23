package Observer;

public class LepreconSubscriber implements Subscriber {
    @Override
    public void notify(String s, String message) {
        String message1= String.format(s, message);
        System.out.print("Breaking News: " + message1 +"\n");
    }
}
