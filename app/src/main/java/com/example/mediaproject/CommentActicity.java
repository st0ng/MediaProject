package com.example.mediaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mediaproject.Data.CommentModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CommentActicity extends AppCompatActivity {

    private String UidLists;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    private EditText CommentContent;
    private Button CommentLoad;
    private RecyclerView CommnitiyCommentRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        CommentContent = (EditText) findViewById(R.id.CommentContent);
        CommentLoad = (Button) findViewById(R.id.CommentLoad);
        CommnitiyCommentRecyclerView = (RecyclerView) findViewById(R.id.CommnitiyCommentRecyclerView);


        Intent intent = getIntent();
        UidLists = intent.getExtras().getString("UidLists");

        CommnitiyCommentRecyclerView.setLayoutManager(new LinearLayoutManager(CommentActicity.this));
        CommnitiyCommentRecyclerView.setAdapter(new RecyclerViewAdapter());



        firebaseDatabase.getReference().child("UserTourListImage" + UidLists + "/Comments").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        CommentLoad.setOnClickListener(new View.OnClickListener() { // 채팅 올릴 때
            @Override
            public void onClick(View v) {
                CommentModel load = new CommentModel();
                load.Uid = firebaseAuth.getCurrentUser().getUid();
                load.Messages = String.valueOf(CommentContent.getText());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a h:mm");
                Date now = new Date();
                load.Date = formatter.format(now);
                firebaseDatabase.getReference().child("UserTourListImage/" + UidLists + "/Comments").push().setValue(load);
            }
        }); // commentLoad Button end
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        List<CommentModel> comment = new ArrayList<>();

        public RecyclerViewAdapter() {
            firebaseDatabase.getReference().child("UserTourListImage/" + UidLists + "/Comments").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    comment.clear();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        comment.add(snapshot.getValue(CommentModel.class));
                    }
                    notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat, parent, false);
            return new MessageViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ((MessageViewHolder) holder).content.setText(comment.get(position).Messages);
            ((MessageViewHolder) holder).uid.setText(comment.get(position).Uid);
            ((MessageViewHolder) holder).date.setText(comment.get(position).Date);
        }

        @Override
        public int getItemCount() {
            return comment.size();
        }

        private class MessageViewHolder extends RecyclerView.ViewHolder {
            TextView content;
            TextView uid;
            TextView date;

            public MessageViewHolder(View view) {
                super(view);
                content = (TextView) view.findViewById(R.id.ChatComment);
                uid = (TextView) view.findViewById(R.id.ChatUid);
                date = (TextView) view.findViewById(R.id.Chatdate);
            }
        }
    }
}
