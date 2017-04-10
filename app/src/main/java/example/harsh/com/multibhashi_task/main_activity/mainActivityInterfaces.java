package example.harsh.com.multibhashi_task.main_activity;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Harsh on 08-04-2017.
 */

public interface mainActivityInterfaces {
    interface prsntrToView{
         void getStarted();
    }

    interface viewToPrsntr{
         Context getContext();
        void gotoActivity(Intent i);
    }
}
