package example.harsh.com.multibhashi_task.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Harsh on 09-04-2017.
 */

public class Item {
    @SerializedName("itemId")
    private String id;

    @SerializedName("desc")
    private String desc;

    @SerializedName("audio")
    private String audio;

    public Item(String id, String desc, String audio){
        this.audio = audio;
        this.desc = desc;
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAudio() {
        return audio;
    }

    public String getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }
}
