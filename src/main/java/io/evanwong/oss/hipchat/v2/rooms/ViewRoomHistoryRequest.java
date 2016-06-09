package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.GetRequest;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class ViewRoomHistoryRequest extends GetRequest<MessageItems> {
    private final String roomIdOrName;
    private Integer startIndex;
    private Integer maxResults;
    private String date;
    private String endDate;

    public ViewRoomHistoryRequest(Integer startIndex, Integer maxResults, String date, String endDate, String roomIdOrName, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.roomIdOrName = roomIdOrName;
        this.startIndex = startIndex;
        this.maxResults = maxResults;
        this.date = date;
        this.endDate = endDate;
    }
    @Override
    protected Map<String, Object> toQueryMap() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("reverse", "false");

        if (startIndex != null) {
            params.put("start-index", startIndex);
        }

        if (maxResults != null) {
            params.put("max-results", maxResults);
        }

        if (date != null) {
            params.put("date", maxResults);
        }

        if (endDate != null) {
            params.put("end-date", maxResults);
        }

        return params;
    }

    @Override
    protected String getPath() {
        return "/room/" + this.roomIdOrName + "/history";
    }
}
