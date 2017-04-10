package example.harsh.com.multibhashi_task.audio_activity;

import android.support.v4.app.FragmentTransaction;

import example.harsh.com.multibhashi_task.Downloader.DownloadHandler;
import example.harsh.com.multibhashi_task.R;
import example.harsh.com.multibhashi_task.audio_activity.Fragments.FragmentFive;
import example.harsh.com.multibhashi_task.audio_activity.Fragments.FragmentFour;
import example.harsh.com.multibhashi_task.audio_activity.Fragments.FragmentOne;
import example.harsh.com.multibhashi_task.audio_activity.Fragments.FragmentThree;
import example.harsh.com.multibhashi_task.audio_activity.Fragments.FragmentTwo;

/**
 * Created by Harsh on 10-04-2017.
 */

public class AudioActivityPresenter implements AudioActivityInterfaces.prsntrToView{

    private AudioActivityInterfaces.viewToPrsntr mView;
    public AudioActivityPresenter( AudioActivityInterfaces.viewToPrsntr mView ) {
        this.mView = mView;
    }

    @Override
    public void attachFragment(FragmentTransaction ft, int i) {

        //FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        switch (i) {

            case 1: ft.replace(R.id.frame, new FragmentOne());
                break;
            case 2: ft.replace(R.id.frame, new FragmentTwo());
                break;
            case 3: ft.replace(R.id.frame, new FragmentTwo());
                break;
            case 4: ft.replace(R.id.frame, new FragmentThree());
                break;
            case 5: ft.replace(R.id.frame, new FragmentFour());
                break;
            case 6: ft.replace(R.id.frame, new FragmentFive());
                break;
        }

        ft.commit();

    }



    @Override
    public void downloadAudio(String url, String num) {

        DownloadHandler download = new DownloadHandler(url,num);
        download.downloadAudio();

    }


}
