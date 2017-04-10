package example.harsh.com.multibhashi_task.list_activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import example.harsh.com.multibhashi_task.Models.Item;
import example.harsh.com.multibhashi_task.R;

/**
 * Created by Harsh on 09-04-2017.
 */

public class Adapter  extends RecyclerView.Adapter<Adapter.SeasonViewHolder> {

    private List<Item> Items = new ArrayList<>();
    private int rowLayout;
    private Context context;

    OnItemClickListener mItemClickListener;


    public  class SeasonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        TextView name;


        LinearLayout Holder;


        public SeasonViewHolder(View v) {
            super(v);

            name = (TextView) v.findViewById(R.id.name);

            Holder=(LinearLayout)v.findViewById(R.id.mainHolder);
            Holder.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(itemView, getPosition());
            }

        }

    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener =  mItemClickListener;
    }

    public Adapter(List<Item> items, int rowLayout, Context context) {
        this.Items = items;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public Adapter.SeasonViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new SeasonViewHolder(view);
    }


    @Override
    public void onBindViewHolder(SeasonViewHolder holder, final int position) {



        holder.name.setText("Audio Track " + Items.get(position).getId());


    }



    @Override
    public int getItemCount() {
        return Items.size() ;
    }


}
