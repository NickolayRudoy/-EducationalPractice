package by.messagestorage.message;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by User on 24.05.2016.
 */
public class MessageHelper {

    private static final JSONParser jsonParser = new JSONParser();

    public static JSONObject messageToJSONObject(Message message){

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", message.getId());
        jsonObject.put("author", message.getAuthor());
        jsonObject.put("text", message.getMessage());
        jsonObject.put("timestamp", message.getTimestamp());

        return jsonObject;
    }

    public static JSONObject stringToJsonObject(String json) throws ParseException {

        return JSONObject.class.cast(jsonParser.parse(json.trim()));
    }

    public static Message jsonObjectToMessage(JSONObject jsonObject){
        String id = (String) jsonObject.get("id");
        String author = (String) jsonObject.get("author");
        String text = (String) jsonObject.get("text");
        long timestamp = (long) jsonObject.get("timestamp");

        return new Message(id, text, author, timestamp);
    }
}
