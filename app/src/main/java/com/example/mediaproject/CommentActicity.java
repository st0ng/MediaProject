package com.example.mediaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mediaproject.Data.CommentModel;
import com.example.mediaproject.Data.UserModel;
import com.example.mediaproject.Data.UserTourListModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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

    public int CommentCount = 0;


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


        CommentLoad.setOnClickListener(new View.OnClickListener() { // 채팅 올릴 때
            @Override
            public void onClick(View v) {
                CommentModel load = new CommentModel();
                load.Uid = firebaseAuth.getCurrentUser().getUid();
                load.Messages = String.valueOf(CommentContent.getText());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd E요일 HH:mm");
                Date now = new Date();
                load.Date = formatter.format(now);
                CommentContent.setText("");
                firebaseDatabase.getReference().child("UserTourListImage/" + UidLists + "/Comments").push().setValue(load).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        firebaseDatabase.getReference().child("UserTourListImage/" + UidLists).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                UserTourListModel get = dataSnapshot.getValue(UserTourListModel.class);
                                int count = get.CommentCount + 1;
                                firebaseDatabase.getReference().child("UserTourListImage/" + UidLists + "/CommentCount").setValue(count);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });

                    }
                });
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

                    CommentCount = comment.size() + 1;


                    notifyDataSetChanged();
                    CommnitiyCommentRecyclerView.scrollToPosition(comment.size() - 1);
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
        public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
            firebaseDatabase.getReference().child("UserInfo/" + comment.get(position).Uid).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    UserModel get = dataSnapshot.getValue(UserModel.class);
                    ((MessageViewHolder) holder).ChatUid.setText(get.UserDisplayName);
                    Glide.with(holder.itemView.getContext()).load(get.UserImage).into(((MessageViewHolder) holder).ChatUserImage);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            ((MessageViewHolder) holder).ChatComment.setText(comment.get(position).Messages);
            ((MessageViewHolder) holder).Chatdate.setText(comment.get(position).Date);
        }

        @Override
        public int getItemCount() {
            return comment.size();
        }

        private class MessageViewHolder extends RecyclerView.ViewHolder {
            TextView ChatComment;
            TextView ChatUid;
            TextView Chatdate;
            ImageView ChatUserImage;

            public MessageViewHolder(View view) {
                super(view);
                ChatComment = (TextView) view.findViewById(R.id.ChatComment);
                ChatUid = (TextView) view.findViewById(R.id.ChatUid);
                Chatdate = (TextView) view.findViewById(R.id.Chatdate);
                ChatUserImage = (ImageView) view.findViewById(R.id.ChatUserImage);
            }
        }


    }// recyclerview end
}
