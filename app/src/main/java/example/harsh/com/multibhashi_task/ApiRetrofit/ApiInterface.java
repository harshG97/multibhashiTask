package example.harsh.com.multibhashi_task.ApiRetrofit;

/**
 * Created by Harsh on 09-04-2017.
 */
import example.harsh.com.multibhashi_task.Models.JsonRecieved;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {
    @GET("bins/hoo8n")
    Call<JsonRecieved> recieveJson();



}
