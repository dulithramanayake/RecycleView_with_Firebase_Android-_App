package com.example.recycleview_with_firebase;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mview;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mview=itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mClickListner.OnItemClick(view,getAdapterPosition());

            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                mClickListner.OnItemLongClick(view,getAdapterPosition());

                return true;
            }
        });
    }

    public void setDeatils(Context ctx, String title, String image){

        TextView mTitle=mview.findViewById(R.id.rTitle);
        ImageView mImage=mview.findViewById(R.id.rImage);

        mTitle.setText(title);

        Picasso.get().load(image).into(mImage);


    }

    private ViewHolder.ClickListner mClickListner;

    public interface  ClickListner{


        void OnItemClick (View view,int position);
        void OnItemLongClick (View view,int position);
    }

    public void setOnClickListner(ViewHolder.ClickListner clickListner){

        mClickListner=clickListner;
    }
}
