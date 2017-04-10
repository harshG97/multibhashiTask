package example.harsh.com.multibhashi_task.list_activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import java.io.FileOutputStream;
import java.util.List;

import example.harsh.com.multibhashi_task.Models.Item;

/**
 * Created by Harsh on 09-04-2017.
 */

public interface ListActivityInterfaces {
    interface prsntrToView{
         List<Item> getJsonAndDisplay(final RecyclerView v, FileOutputStream outputStream);
    }

    interface viewToPrsntr{
         Context getContext();
        void gotoActivity(Intent i);
    }
}
