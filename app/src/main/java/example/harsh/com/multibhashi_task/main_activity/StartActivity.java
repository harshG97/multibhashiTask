package example.harsh.com.multibhashi_task.main_activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import example.harsh.com.multibhashi_task.R;

public class StartActivity extends AppCompatActivity implements mainActivityInterfaces.viewToPrsntr {
    private mainActivityInterfaces.prsntrToView mPresenter = new mainActivityPresenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }



    public void gotoActivity(Intent i){
        startActivity(i);
    }

    public void btnClick(View v){
        mPresenter.getStarted();
    }
}
