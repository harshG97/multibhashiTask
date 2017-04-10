package example.harsh.com.multibhashi_task.list_activity;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import example.harsh.com.multibhashi_task.ApiRetrofit.ApiClient;
import example.harsh.com.multibhashi_task.ApiRetrofit.ApiInterface;
import example.harsh.com.multibhashi_task.Downloader.DownloadHandler;
import example.harsh.com.multibhashi_task.Models.Item;
import example.harsh.com.multibhashi_task.Models.JsonRecieved;
import example.harsh.com.multibhashi_task.R;
import example.harsh.com.multibhashi_task.audio_activity.AudioActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Harsh on 09-04-2017.
 */

public class ListActivityPresenter implements ListActivityInterfaces.prsntrToView{

    Adapter mAdapter;
    List<Item> Items= new ArrayList<>();
    private ListActivityInterfaces.viewToPrsntr mView;

    public ListActivityPresenter( ListActivityInterfaces.viewToPrsntr mView ) {
        this.mView = mView;
    }

    public List<Item> getJsonAndDisplay(final RecyclerView v, FileOutputStream outputStream){

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<JsonRecieved> call = apiService.recieveJson();
        call.enqueue(new Callback<JsonRecieved>() {
            @Override
            public void onResponse(Call<JsonRecieved> call, Response<JsonRecieved> response) {
                int statusCode = response.code();

                Items = response.body().getJson();

                LinearLayoutManager linearlayoutManager = new LinearLayoutManager(mView.getContext());
                v.setLayoutManager(linearlayoutManager);
                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(v.getContext(),
                        linearlayoutManager.getOrientation());
                v.addItemDecoration(dividerItemDecoration);
                mAdapter = new Adapter(Items, R.layout.item_row, mView.getContext());
                v.setAdapter(mAdapter);
                mAdapter.setOnItemClickListener(onItemClickListener);

                DownloadHandler download = new DownloadHandler(Items.get(0).getAudio(), "1");
                download.downloadAudio();

            }

            @Override
            public void onFailure(Call<JsonRecieved> call, Throwable t) {
                Log.i("h","k");

            }
        });
        Log.i("json1",Items.toString());


        return Items;
    }

    Adapter.OnItemClickListener onItemClickListener = new Adapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            Intent intent = new Intent(mView.getContext(), AudioActivity.class);
            System.out.println(position);
            ArrayList<String> L = new ArrayList<>();
            for(int i = 0; i<6; ++i) {
                L.add(Items.get(i).getAudio());
            }
            L.add(Integer.toString(position));
            //intent.putExtra("audioNum" , Integer.toString(position+1) );
            intent.putStringArrayListExtra("parameters", L );
            mView.gotoActivity(intent);
        }
    };

}

