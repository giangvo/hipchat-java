package io.evanwong.oss.hipchat.v2.rooms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.evanwong.oss.hipchat.v2.users.UserItem;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageItem {
    String id;
    String message;
    String type;
    String date;
    FileItem file;
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
}
