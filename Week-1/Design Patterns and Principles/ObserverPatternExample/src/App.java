import java.util.ArrayList;
import java.util.List;

public class App {

    interface Observer {
        void update(String videoTitle);
    }

    interface Channel {
        void subscribe(Observer o);
        void unsubscribe(Observer o);
        void notifySubscribers();
    }

    static class YouTubeChannel implements Channel {
        private List<Observer> subscribers = new ArrayList<>();
        private String latestVideo;

        public void uploadVideo(String title) {
            this.latestVideo = title;
            notifySubscribers();
        }

        public void subscribe(Observer o) {
            subscribers.add(o);
        }

        public void unsubscribe(Observer o) {
            subscribers.remove(o);
        }

        public void notifySubscribers() {
            for (Observer o : subscribers) {
                o.update(latestVideo);
            }
        }
    }

    static class Subscriber implements Observer {
        private String name;

        public Subscriber(String name) {
            this.name = name;
        }

        public void update(String videoTitle) {
            System.out.println(name + " notified: New video uploaded - " + videoTitle);
        }
    }

    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();

        Observer s1 = new Subscriber("Amit");
        Observer s2 = new Subscriber("Riya");

        channel.subscribe(s1);
        channel.subscribe(s2);

        channel.uploadVideo("Java Design Patterns");
        channel.uploadVideo("Observer Pattern Explained");
    }
}