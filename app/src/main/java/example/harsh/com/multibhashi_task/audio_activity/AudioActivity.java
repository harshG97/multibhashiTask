package example.harsh.com.multibhashi_task.audio_activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import example.harsh.com.multibhashi_task.R;

public class AudioActivity extends AppCompatActivity implements AudioActivityInterfaces.viewToPrsntr{


    int i;
    ArrayList<String> params = new ArrayList<>();
    TextView text;

    private AudioActivityInterfaces.prsntrToView mPresenter = new AudioActivityPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        text = (TextView)findViewById(R.id.audioName);


        params = getIntent().getStringArrayListExtra("parameters");
        i = Integer.parseInt(params.get(6)) + 1;

        text.setText("Audio " + Integer.toString(i));

        if(i!=1){
            downloadCurrent();
        }

        downloadNext();


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        mPresenter.attachFragment(ft, i);


    }

    public void Next(View v){
        i++;
        if(i<7) {
            text.setText("Audio " + Integer.toString(i));
            downloadNext();
            mPresenter.attachFragment(getSupportFragmentManager().beginTransaction(), i);
        }
    }

    public void downloadNext() {
        mPresenter.downloadAudio(params.get(i), Integer.toString(i+1));
    }

    public void downloadCurrent(){
        mPresenter.downloadAudio(params.get(i-1), Integer.toString(i));

    }


}
