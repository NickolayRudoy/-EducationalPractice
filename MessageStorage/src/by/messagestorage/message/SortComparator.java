package by.messagestorage.message;

import java.util.Comparator;

/**
 * Created by User on 24.05.2016.
 */
public class SortComparator implements Comparator<Message> {

    @Override
    public int compare(Message o1, Message o2) {
        return (int) (o1.getTimestamp() - o2.getTimestamp());
    }
}
