package by.messagestorage;

import by.messagestorage.message.Message;
import by.messagestorage.message.MessageUtil;

import java.io.FileNotFoundException;

/**
 * Created by User on 24.05.2016.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        MessageUtil messageUtil = new MessageUtil();
        messageUtil.loadMessages();

        for(Message message : messageUtil.getMessages()){
            System.out.println(message);
        }
    }

}
