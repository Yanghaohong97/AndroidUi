package com.cvte.androidui.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
//import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.cvte.androidui.R;

/**
 * Created by Hanson on 2021/8/14.
 */

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public LinearAdapter(Context context,OnItemClickListener listener){
        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        if(viewType == 0){
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false));
//        }else{
//            return new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item_2,parent,false));
//        }
    }

    @Override
    public void onBindViewHolder(LinearAdapter.LinearViewHolder holder, final int position) {
        holder.textView.setText("Hello World!");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return 0;

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public LinearViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_title1);
        }
    }


    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
