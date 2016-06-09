package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class ViewRoomHistoryRequestBuilder extends RequestBuilder<ViewRoomHistoryRequest> {
    private final String roomIdOrName;
    private Integer startIndex;
    private Integer maxResults;
    private String date;
    private String endDate;

    public ViewRoomHistoryRequestBuilder(String roomIdOrName, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        if (roomIdOrName == null || roomIdOrName.isEmpty()) {
            throw new IllegalArgumentException("roomIdOrName is required.");
        }
        this.roomIdOrName = roomIdOrName;
    }

    public ViewRoomHistoryRequestBuilder setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
        return this;
    }

    public ViewRoomHistoryRequestBuilder setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
        return this;
    }

    public ViewRoomHistoryRequestBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public ViewRoomHistoryRequestBuilder setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    @Override
    public ViewRoomHistoryRequest build() {
        return new ViewRoomHistoryRequest(startIndex, maxResults, date, endDate, roomIdOrName, accessToken, baseUrl, httpClient, executorService);
    }

}
