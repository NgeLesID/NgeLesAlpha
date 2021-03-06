package com.example.ngelesalpha.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ngelesalpha.R;
import com.example.ngelesalpha.assignment;
import com.example.ngelesalpha.model.LearningCategory_model;
import com.example.ngelesalpha.search;

import java.util.List;

/**
 * Created by Timothy on 7/30/2016.
 */
public class RecycleAdapterLearningCategory extends RecyclerView.Adapter<RecycleAdapterLearningCategory.MyViewHolder>   {

    private List<LearningCategory_model> mData;
    private LayoutInflater mInflater;
    private Context context;

    public RecycleAdapterLearningCategory(Context context, List<LearningCategory_model> data) {
        this.context=context;
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item_learning_category, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        LearningCategory_model currentObj = mData.get(position);
        holder.setData(currentObj, position);

        holder.itemView.setOnClickListener((v)-> {
            Intent a = new Intent(v.getContext(),search.class);
            context.startActivity(a);
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView imgThumb;
        int position;
        LearningCategory_model current;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.category_name);
            imgThumb = (ImageView) itemView.findViewById(R.id.ListImage);
        }

        public void setData(LearningCategory_model current, int position) {
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageId());
            this.position = position;
            this.current = current;
        }
    }
}
