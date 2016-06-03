package by.messagestorage.file;

import by.messagestorage.message.Message;
import by.messagestorage.message.MessageHelper;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by User on 24.05.2016.
 */
public class FileUtil {

    private static final String FILE_NAME = "log.txt";

    public void addMessage(Message message){

        try(
                FileOutputStream fos = new FileOutputStream(FILE_NAME, true);
                PrintStream ps = new PrintStream(fos);
                ) {

            ps.println(MessageHelper.messageToJSONObject(message));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void rewrite(List<Message> messages){
        try(
                FileOutputStream fos = new FileOutputStream(FILE_NAME, true);
                PrintStream ps = new PrintStream(fos);
        ) {

            for(Message message : messages){
                ps.println(MessageHelper.messageToJSONObject(message));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Message> loadMessages() throws FileNotFoundException {
        List<Message> list = new ArrayList<>();

        Scanner scanner = new Scanner(new FileReader(FILE_NAME));
        while(scanner.hasNextLine()){

            try {
                JSONObject jsonObject = MessageHelper.stringToJsonObject(scanner.nextLine());

                Message message = MessageHelper.jsonObjectToMessage(jsonObject);

                list.add(message);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        return list;
    }

    public boolean deleteMessage(String messageId) throws FileNotFoundException {
        List<Message> list = loadMessages();

        Iterator<Message> iterator = list.iterator();

        while(iterator.hasNext()){
            Message message = iterator.next();

            if(message.getId().equals(messageId)){
                iterator.remove();
                rewrite(list);
                return true;
            }

        }

        return false;
    }
}
