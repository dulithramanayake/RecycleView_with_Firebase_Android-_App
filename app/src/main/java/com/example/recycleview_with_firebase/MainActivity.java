package com.example.recycleview_with_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    LinearLayoutManager mLinearLayoutManager;
    RecyclerView mRecyleView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;
    FirebaseRecyclerAdapter<Model,ViewHolder> firebaseRecyclerAdapter;

    FirebaseRecyclerOption<Model> options;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mLinearLayoutManager=new LinearLayoutManager(this);
        mLinearLayoutManager.setReverseLayout(true);
        mLinearLayoutManager.setStackFromEnd(true);

        mRecyleView=findViewById(R.id.rexcycleView);
        mDatabaseReference=mFirebaseDatabase.getReference("Data");

        showData();

    }

    private void showData() {

        options= new FirebaseRecyclerOption.Builder<Model>().setQuery(mDatabaseReference,Model.class).buil();

        firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Model, ViewHolder>()


    }
}