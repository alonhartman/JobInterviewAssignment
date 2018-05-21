
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest {

    OkHttpClient client = null;
    Request request = null;
    String currentFormattedDate;
    SimpleDateFormat formmatedDate;
    Date now;
    Response response;
    String responseJson;
    String url = "";


    @Before
    public void setUp() {
        if(client == null) {
            client = new OkHttpClient();
        }
        formmatedDate = new SimpleDateFormat("yyyy-MM-dd");
        now = new Date();
        currentFormattedDate = formmatedDate.format(now);
    }

    @Test
    public void verifyGetApiIsSuccess() throws IOException {
        getResponseOfGetLatestApi(Endpoint.latest);
        Assert.assertTrue("Request failed: " + responseJson, responseJson.contains("\"success\":true"));
    }

    @Test
    public void verifyDateOfTodayIsCorrect() throws IOException {
        getResponseOfGetLatestApi(Endpoint.latest);
        Assert.assertTrue(responseJson.contains(String.format("\"date\":\"%s\"", currentFormattedDate)));
    }


    // Private methods
    private void getResponseOfGetLatestApi(Endpoint endpoint) throws IOException {
        switch (endpoint) {
            case latest:
                url = "http://data.fixer.io/api/latest?access_key=e75334e3b8cf3ad81d500a6d58bf3566";
                break;
//            case convert:
//                url = "http://data.fixer.io/api/convert?access_key=e75334e3b8cf3ad81d500a6d58bf3566&from=USD&to=ILS&amount=10";
//                break;
//            case historical:
//                url = "http://data.fixer.io/api/2018-04-01?access_key=e75334e3b8cf3ad81d500a6d58bf3566&base=GBP&symbols=USD,CAD,EUR";
//                break;
//            case timeseries:
//                url = "http://data.fixer.io/api/timeseries?access_key=e75334e3b8cf3ad81d500a6d58bf3566&start_date=2012-05-01&end_date=2012-05-25";
//                break;
//            case fluctuation:
//                url = "http://data.fixer.io/api/convert?access_key=e75334e3b8cf3ad81d500a6d58bf3566&start_date=2015-12-01&end_date=2012-05-25";
//                break;
        }

        client = new OkHttpClient();
        System.out.println("Sending GET request to: " + endpoint + " ; " + url);
        request = new Request.Builder().url(url).build();
        response = client.newCall(request).execute();
        responseJson = response.body().string();

    }


    public enum Endpoint {
        latest,
//        convert,
//        historical,
//        timeseries,
//        fluctuation
    }



}