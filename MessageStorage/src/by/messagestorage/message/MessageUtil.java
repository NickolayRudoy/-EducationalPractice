package by.messagestorage.message;

import by.messagestorage.file.FileUtil;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by User on 24.05.2016.
 */
public class MessageUtil {

    private List<Message> messages;
    private FileUtil fileUtil;

    public MessageUtil(){
        messages = new ArrayList<>();
        fileUtil = new FileUtil();
    }

    public boolean add(Message message){

        for(Message item : messages){
            if(item.getId().equals(message.getId())){
                return false;
            }
        }

        messages.add(message);
        fileUtil.addMessage(message);

        return true;
    }

    public boolean delete(String messageId) throws FileNotFoundException {
        Iterator<Message> iterator = messages.iterator();

        while(iterator.hasNext()){
            Message message = iterator.next();
            if(message.getId().equals(messageId)){

                iterator.remove();

                fileUtil.deleteMessage(messageId);

                return true;
            }
        }

        return false;
    }

    public void loadMessages() throws FileNotFoundException {
        messages.addAll(fileUtil.loadMessages());
    }

    public List<Message> getSortChronologicalHistory(){
        List<Message> list = new ArrayList<>();
        list.addAll(messages);
        Collections.sort(messages, new SortComparator());
        return list;
    }

    public List<Message> getMessages(){
        return messages;
    }

    public Message searchAuthor(String author){
        for(Message item : messages){
            if(item.equals(author)){
                return item;
            }
        }

        return null;
    }
}
