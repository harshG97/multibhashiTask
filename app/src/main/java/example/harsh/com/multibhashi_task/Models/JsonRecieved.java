package example.harsh.com.multibhashi_task.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Harsh on 09-04-2017.
 */
 public class JsonRecieved {
    @SerializedName("data")
    private List<Item> json;

    public JsonRecieved(List<Item> json){
        this.json = json;
    }

    public void setJson(List<Item> json) {
        this.json = json;
    }

    public List<Item> getJson() {
        return json;
    }
}
