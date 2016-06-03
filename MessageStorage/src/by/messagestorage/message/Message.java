package by.messagestorage.message;

/**
 * Created by User on 24.05.2016.
 */
public class Message {

    private String id;
    private String message;
    private String author;
    private long timestamp;

    public Message(String id, String message, String author, long timestamp) {
        this.id = id;
        this.message = message;
        this.author = author;
        this.timestamp = timestamp;
    }

    public String getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public String getAuthor() {
        return this.author;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    @Override
    public String toString() {
        return "[id: "+id+", message: "+message+", author: "+author+", timestamp: "+timestamp+"]";
    }
}
