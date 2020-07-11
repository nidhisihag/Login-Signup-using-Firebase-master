package com.example.shiva.try1;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DashboardActivity extends AppCompatActivity {

    String EmailHolder;

    Button LogOUT ;

    RecyclerView recyclerView;
    DatabaseReference mDatabase;
    //@SuppressLint("SetTextI18n")
    public static final String TAG="LOGIN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        LogOUT = (Button)findViewById(R.id.button1);


        Intent intent = getIntent();

        // Receiving User Email Send By MainActivity.
        EmailHolder = intent.getStringExtra(login.userEmail);
        mDatabase= FirebaseDatabase.getInstance().getReference().child("table");
        mDatabase.keepSynced(true);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Setting up received email to TextView.


        // Adding click listener to Log Out button.

        LogOUT.setOnClickListener(new View.OnClickListener() {
           // @Override
            public void onClick(View v) {


                //Finishing current DashBoard activity on button click.
               finish();

                Toast.makeText(DashboardActivity.this,"Log Out Successfull", Toast.LENGTH_LONG).show();
                //Intent intent=new Intent(DashboardActivity.this,login.class);
                //startActivity(intent);
               /*if (v.getId() == R.id.button1) {
                    AuthUI.getInstance()
                            .signOut(this)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                public void onComplete(@NonNull Task<Void> task) {
                                    // user is now signed out
                                    startActivity(new Intent(DashboardActivity.this, login.class));
                                    finish();
                                }
                            });
                }*/

            }
        });




    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Blog,BlogViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Blog, BlogViewHolder>
                (Blog.class,R.layout.activity_info,BlogViewHolder.class,mDatabase) {
            @Override
            protected void populateViewHolder(BlogViewHolder blogViewHolder, Blog blog, int i) {
                blogViewHolder.setTableno(blog.getTableno());
                blogViewHolder.setOrder(blog.getOrder());
                blogViewHolder.setPrice(blog.getPrice());
                blogViewHolder.setTime(blog.getTime());
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
    public static class BlogViewHolder extends RecyclerView.ViewHolder
    {
        View mView;
        public BlogViewHolder(View itemView)
        {
            super(itemView);
            mView=itemView;
        }
        public void setTableno(int tableno){
            TextView post_table=(TextView)mView.findViewById(R.id.table_no);
            post_table.setText("Table no: "+" "+Integer.toString(tableno));
        }
        public void setOrder(String order){
            TextView post_order=(TextView)mView.findViewById(R.id.order);
            post_order.setText("Order: "+order);
        }
        public void setPrice(int price){
            TextView post_order=(TextView)mView.findViewById(R.id.price);
            post_order.setText("Price: "+" "+Integer.toString(price));
        }
        public void setTime(int time){
            TextView post_order=(TextView)mView.findViewById(R.id.time);
            post_order.setText("Time taken: "+" "+Integer.toString(time));
        }
    }



}


