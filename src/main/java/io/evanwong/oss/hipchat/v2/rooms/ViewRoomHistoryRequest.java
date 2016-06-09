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
    private boolean reverse = false;

    public ViewRoomHistoryRequest(Integer startIndex, Integer maxResults, String date, String endDate, boolean reverse, String roomIdOrName, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.roomIdOrName = roomIdOrName;
        this.startIndex = startIndex;
        this.maxResults = maxResults;
        this.date = date;
        this.endDate = endDate;
        this.reverse = reverse;
    }

    @Override
    protected Map<String, Object> toQueryMap() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("reverse", String.valueOf(reverse));

        if (startIndex != null) {
            params.put("start-index", startIndex);
        }

        if (maxResults != null) {
            params.put("max-results", maxResults);
        }

        if (date != null) {
            params.put("date", date);
        }

        if (endDate != null) {
            params.put("end-date", endDate);
        }

        return params;
    }

    @Override
    protected String getPath() {
        return "/room/" + this.roomIdOrName + "/history";
    }
}
