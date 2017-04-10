package example.harsh.com.multibhashi_task.main_activity;

import android.content.Intent;

import example.harsh.com.multibhashi_task.list_activity.ListActivity;

/**
 * Created by Harsh on 08-04-2017.
 */

public class mainActivityPresenter implements mainActivityInterfaces.prsntrToView{

    private mainActivityInterfaces.viewToPrsntr mView;
    public mainActivityPresenter( mainActivityInterfaces.viewToPrsntr mView ) {
        this.mView = mView;
    }
    @Override
    public void getStarted() {

        Intent intent = new Intent(mView.getContext(), ListActivity.class);
        mView.gotoActivity(intent);
    }
}
