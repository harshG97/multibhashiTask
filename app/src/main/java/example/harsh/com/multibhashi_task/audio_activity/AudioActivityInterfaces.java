package example.harsh.com.multibhashi_task.audio_activity;

import android.support.v4.app.FragmentTransaction;

/**
 * Created by Harsh on 10-04-2017.
 */

public interface AudioActivityInterfaces {
    public interface prsntrToView{

        void attachFragment(FragmentTransaction ft, int i);
        void downloadAudio( String url, String num);

    }

    interface viewToPrsntr{

    }

}
