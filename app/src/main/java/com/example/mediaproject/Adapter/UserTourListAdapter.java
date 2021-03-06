package com.example.mediaproject.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mediaproject.CommentActicity;
import com.example.mediaproject.Data.UserModel;
import com.example.mediaproject.Data.UserTourListData;
import com.example.mediaproject.Data.UserTourListModel;
import com.example.mediaproject.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserTourListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();


    private List<UserTourListData> UserTourListData;
    private List<String> UidLists;


    public UserTourListAdapter() {
    }

    ;

    public UserTourListAdapter(List<UserTourListData> UserTourListData, List<String> UidLists) {
        this.UserTourListData = UserTourListData;
        this.UidLists = UidLists;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.community_cv, parent, false);
        return new UserTourListHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof UserTourListHolder) {
            ((UserTourListHolder) holder).CommunitiyUserEmail.setText(UserTourListData.get(position).getImageName());

            String tag = "#" + TagTrim(UserTourListData.get(position).getTitle()) + " " +
                    "#" + UserTourListData.get(position).getCat2() + " " +
                    "#" + UserTourListData.get(position).getCat3() + " " +
                    Tagsplit(UserTourListData.get(position).getAddr());

            ((UserTourListHolder) holder).CommunityTag.setText(tag);
            ((UserTourListHolder) holder).CommunitiyDescription.setText(UserTourListData.get(position).getDescription());
            ((UserTourListHolder) holder).CommunitiyCreateDate.setText(UserTourListData.get(position).getCreateDate());
            String count = String.valueOf("댓글 " + UserTourListData.get(position).CommentCount + "개");
            ((UserTourListHolder) holder).CommnitiyCommentCount.setText(count);
            Glide.with(holder.itemView.getContext()).load(UserTourListData.get(position).ImageUri).into(((UserTourListHolder) holder).CommunitiyUserImage);

            ((UserTourListHolder) holder).CommunityCheckedLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onHeartClicked(firebaseDatabase.getReference().child("UserTourListImage").child(UidLists.get(position)));

                }
            });
            //하트 개수 받아오기
            ((UserTourListHolder) holder).CommunityDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onDeleteClicked(position);
                }
            });


            firebaseDatabase.getReference().child("UserTourListImage").child(UidLists.get(position)).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    UserTourListModel get = dataSnapshot.getValue(UserTourListModel.class);
                    if (get.stars.containsKey(firebaseAuth.getCurrentUser().getUid())) {
                        ((UserTourListHolder) holder).CommunityCheckedLike.setImageResource(R.drawable.heart);
                        String count = String.valueOf(get.starCount);
                        ((UserTourListHolder) holder).CommunityuHeartCount.setText("좋아요 " + count + "개");
                    } else {
                        ((UserTourListHolder) holder).CommunityCheckedLike.setImageResource(R.drawable.heart_botom);
                        String count = String.valueOf(get.starCount);
                        ((UserTourListHolder) holder).CommunityuHeartCount.setText("좋아요 " + count + "개");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


            if (UserTourListData.get(position).getUid().equals(firebaseAuth.getCurrentUser().getUid())) {
                ((UserTourListHolder) holder).CommunityDelete.setVisibility(View.VISIBLE);
            } else {
                ((UserTourListHolder) holder).CommunityDelete.setVisibility(View.INVISIBLE);
            }

            firebaseDatabase.getReference().child("UserInfo").child(UserTourListData.get(position).Uid).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    UserModel get = dataSnapshot.getValue(UserModel.class);
                    String CheckImage;
                    CheckImage = get.UserImage;
                    if (CheckImage != null) {
                        Glide.with(holder.itemView.getContext()).load(CheckImage).into(((UserTourListHolder) holder).Community_ortherUserImage);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            ((UserTourListHolder) holder).CommnitiyCommentCount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(holder.itemView.getContext(), CommentActicity.class);
                    intent.putExtra("UidLists", UidLists.get(position).toString());
                    holder.itemView.getContext().startActivity(intent);
                }
            });


        } // if end
    } //onBindViewHolder end

    @Override
    public int getItemCount() {
        return UserTourListData.size();
    }


    public static class UserTourListHolder extends RecyclerView.ViewHolder {
        ImageView CommunitiyUserImage;
        ImageView CommunityCheckedLike;
        ImageView CommunityDelete;
        ImageView Community_ortherUserImage;
        TextView CommunitiyUserEmail;
        TextView CommunitiyDescription;
        TextView CommunitiyCreateDate;
        TextView CommunityuHeartCount;
        TextView CommnitiyCommentCount;
        TextView CommunityTag;


        public UserTourListHolder(@NonNull View itemView) {
            super(itemView);
            CommunitiyUserImage = itemView.findViewById(R.id.CommnitiyUserImage);
            CommunitiyUserEmail = itemView.findViewById(R.id.CommnitiyUserEmail);
            CommunitiyDescription = itemView.findViewById(R.id.CommnitiyDescription);
            CommunitiyCreateDate = itemView.findViewById(R.id.CommnitiyCreateDate);
            CommunityCheckedLike = itemView.findViewById(R.id.CommnityCheckedLike);
            CommunityuHeartCount = itemView.findViewById(R.id.CommnitiyLikeCount);
            CommunityDelete = itemView.findViewById(R.id.CommunityDelete);
            Community_ortherUserImage = itemView.findViewById(R.id.Community_ortherUserImage);
            CommnitiyCommentCount = itemView.findViewById(R.id.CommnitiyCommentCount);
            CommunityTag = itemView.findViewById(R.id.CommunityTag);
        }
    } //UserTourListHolder end

    public String TagTrim(String text){
        String target = text.replace(" ","");

          return target;
    }


    public String Tagsplit(String text) {
        String target = text;
        String[] arrays = target.split(" ");
        String result = "#" + arrays[0] + " " +
                         "#" + arrays[1] + " " ;


        return result;
    }

    private void onHeartClicked(DatabaseReference postRef) {
        postRef.runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {
                UserTourListModel userTourListModel = mutableData.getValue(UserTourListModel.class);
                if (userTourListModel == null) {
                    return Transaction.success(mutableData);
                }

                if (userTourListModel.stars.containsKey(firebaseAuth.getCurrentUser().getUid())) {
                    // Unstar the post and remove self from stars
                    userTourListModel.starCount = userTourListModel.starCount - 1;
                    userTourListModel.stars.remove(firebaseAuth.getCurrentUser().getUid());
                } else {
                    // Star the post and add self to stars
                    userTourListModel.starCount = userTourListModel.starCount + 1;
                    userTourListModel.stars.put(firebaseAuth.getCurrentUser().getUid(), true);
                }

                // Set value and report transaction success
                mutableData.setValue(userTourListModel);
                return Transaction.success(mutableData);
            }


            @Override
            public void onComplete(DatabaseError databaseError, boolean b,
                                   DataSnapshot dataSnapshot) {
                // Transaction completed
            }
        });
    } //onHeartClicked end

    private void onDeleteClicked(final int position) {
        firebaseStorage.getReference().child("UserTourListImage").child(UserTourListData.get(position).getCreateDate().toString() + ".png").delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                firebaseDatabase.getReference().child("UserTourListImage").child(UidLists.get(position)).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("성공", "성공");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("실패", "실패");
                    }
                });
            } //firebaseStorage onSuccess end
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("실패", "실패");
            }
        });


    } //onDeleteClicked end

} //UserTourListAdapter end

