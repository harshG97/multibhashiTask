package example.harsh.com.multibhashi_task.list_activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import example.harsh.com.multibhashi_task.Models.Item;
import example.harsh.com.multibhashi_task.R;



public class ListActivity extends AppCompatActivity implements ListActivityInterfaces.viewToPrsntr {

    Adapter mAdapter;
    List<Item> items = new ArrayList<>();
    private ListActivityInterfaces.prsntrToView mPresenter = new ListActivityPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final RecyclerView mrecyclerView = (RecyclerView) findViewById(R.id.audioList);


        String fileName = "MyFile";


        FileOutputStream outputStream = null;
        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);

        } catch (Exception e) {
            e.printStackTrace();
        }
        items = mPresenter.getJsonAndDisplay(mrecyclerView, outputStream);

    }



    public Context getContext(){
        return getApplicationContext();
    }

    @Override
    public void gotoActivity(Intent i) {

        startActivity(i);
    }




}
