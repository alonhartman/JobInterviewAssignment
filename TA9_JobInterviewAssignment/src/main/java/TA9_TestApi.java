import Base.ConstantStrings;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TA9_TestApi {

    OkHttpClient client;

    @Before
    public void setUp() {
        if(client == null) {
            client = new OkHttpClient();
        }
    }

    @Test
    public void test_doesUserExist_TRUE() throws IOException {
        String phoneNumber = "0000000000";
        String url = String.format(ConstantStrings.GET_IS_USER_EXIST, phoneNumber);
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();
        Assert.assertTrue(String.format("The phone number %s doesn't exist", phoneNumber), responseBody != "");
    }

}
