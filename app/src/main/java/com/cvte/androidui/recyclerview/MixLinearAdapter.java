package com.cvte.androidui.recyclerview;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cvte.androidui.R;

//import android.support.v7.widget.RecyclerView;

/**
 * Created by Hanson on 2021/8/14.
 */

public class MixLinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public MixLinearAdapter(Context context, OnItemClickListener listener){
        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 0){
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false));
        }else{
            return new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item_2,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position) == 0) {
            ((LinearViewHolder)holder).textView.setText("Hello World!");
        } else {
            ((LinearViewHolder2)holder).textView.setText("耶！");
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
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

    class LinearViewHolder2 extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public LinearViewHolder2(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_title2);
            imageView = (ImageView) itemView.findViewById(R.id.iv_mix);
            imageView.setImageResource(R.drawable.icon);
        }
    }


    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
