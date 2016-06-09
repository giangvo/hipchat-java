package io.evanwong.oss.hipchat.v2.rooms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import io.evanwong.oss.hipchat.v2.users.UserItem;

import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageItem {
    String id;
    String message;
    String type;
    String date;
    FileItem file;

    @JsonDeserialize(using = UserItemDeserializer.class)
    UserItem from;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FileItem getFile() {
        return file;
    }

    public void setFile(FileItem file) {
        this.file = file;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public UserItem getFrom() {
        return from;
    }

    public void setFrom(UserItem from) {
        this.from = from;
    }

    public static class UserItemDeserializer extends JsonDeserializer<UserItem> {
        @Override
        public UserItem deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode node = jp.getCodec().readTree(jp);
            if (node.getNodeType() == JsonNodeType.OBJECT) {
                UserItem userItem = new UserItem();
                userItem.setName(node.get("name").asText());
                userItem.setMentionName(node.get("mention_name").asText());
                userItem.setId(node.get("id").asInt());

                return userItem;
            }

            return null;
        }
    }
}
