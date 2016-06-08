package io.evanwong.oss.hipchat.v2.rooms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageItems {
    List<MessageItem> items;

    public List<MessageItem> getItems() {
        return items;
    }

    public void setItems(List<MessageItem> items) {
        this.items = items;
    }
}
