package com.example.mediaproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.mediaproject.Data.UserInfo;
import com.example.mediaproject.Data.UserModel;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateUserInfo extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    protected FirebaseStorage firebaseStorage;
    protected FirebaseDatabase firebaseDatabase;
    protected FirebaseAuth firebaseAuth;
    protected DatabaseReference DBresgerce = null;

    private ImageView Update_UserImage;
    private EditText Update_UserDisPlayName;
    private EditText Update_UserPost;
    private RadioGroup Update_CheckedSex;
    private RadioButton Update_male;
    private RadioButton Update_female;
    private Button UserInfoLoad;

    private Uri filepath;

    String UserEmail;
    String UserImage;
    String UserSex;
    String UserProviderId;
    String Uid;
    String UserPost;
    String UserPassword;
    String UserDisplayName;

    HashMap<String, Object> UserDataUpdate = null;
    Map<String, Object> UserValue = null;
    com.example.mediaproject.Data.UserInfo UserInfo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_info);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();

        Update_UserDisPlayName = (EditText) findViewById(R.id.Update_UserDisPlayName);
        Update_UserPost = (EditText) findViewById(R.id.Update_UserPost);
        Update_UserImage = (ImageView) findViewById(R.id.Update_UserImage);
        UserInfoLoad = (Button) findViewById(R.id.UserInfoLoad);
        Update_CheckedSex = (RadioGroup) findViewById(R.id.Update_CheckedSex);
        Update_male = (RadioButton) findViewById(R.id.Update_male);
        Update_female = (RadioButton) findViewById(R.id.Update_female);

        Update_UserImage.setOnClickListener(this);
        UserInfoLoad.setOnClickListener(this);
        Update_CheckedSex.setOnCheckedChangeListener(this);

        final FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        firebaseDatabase.getReference().child("UserInfo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    UserModel get = snapshot.getValue(UserModel.class);


                    if (currentUser.getUid().equals(get.Uid)) {
                        Uid = get.Uid;
                        UserDisplayName = get.UserDisplayName;
                        UserProviderId = get.UserProviderId;
                        UserImage = get.UserImage;
                        UserPost = get.UserPost;
                        UserSex = get.UserSex;
                        UserEmail = get.UserEmail;
                        UserPassword = get.UserPassword;

                        Update_UserDisPlayName.setText(get.UserDisplayName);

                        if (UserImage != null) {
                            Glide.with(UpdateUserInfo.this)
                                    .load(get.UserImage)
                                    .apply(new RequestOptions().override(150, 150))
                                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(15)))
                                    .into(Update_UserImage);
                        }

                        if (UserPost != null) {
                            Update_UserPost.setText(get.UserPost);
                        }

                        if (UserSex != null) {
                            if (UserSex.equals("남자")) {
                                Update_male.setChecked(true);
                            } else if (UserSex.equals("여자")) {
                                Update_female.setChecked(true);
                            } else { }
                        }

                    } //if end
                } // for end
            } //onDataChange end

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


//        if (model.UserImage != null) {
//            Update_UserImage.setImageResource(Integer.parseInt(model.UserImage));
//        }


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Update_UserImage) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent, 001);

        } else if (v.getId() == R.id.UserInfoLoad) {
            if (filepath != null) {
                // 업로드 진행 Dialog 보기
                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("업로드중...");
                progressDialog.show();

                //파이어베이스 스토리지 경로 설정
                final StorageReference storageReference = firebaseStorage.getReferenceFromUrl("gs://mediaproject-2176a.appspot.com")
                        .child("UserImage/" + firebaseAuth.getCurrentUser().getUid() + ".png");


                final UploadTask uploadTask = storageReference.putFile(filepath);
                uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if (!task.isSuccessful()) {
                            throw task.getException();
                        }
                        return storageReference.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        Uri downloadUri = task.getResult();

                        //실시간 데이터베이스 게시판 데이터 전송
                        Log.d("UpdateUserInfo", downloadUri.toString());

                        DBresgerce = FirebaseDatabase.getInstance().getReference();
                        UserDataUpdate = new HashMap<>();

                        UserDisplayName = String.valueOf(Update_UserDisPlayName.getText());
                        UserPost = String.valueOf(Update_UserPost.getText());

                        UserInfo = new UserInfo(Uid, UserEmail, downloadUri.toString(), UserSex, UserPost, UserPassword, UserDisplayName, UserPassword);
                        UserValue = UserInfo.toMap();

                        UserDataUpdate.put("/UserInfo/" + firebaseAuth.getCurrentUser().getUid(), UserValue);
                        DBresgerce.updateChildren(UserDataUpdate);

                        progressDialog.dismiss(); //업로드 진행 Dialog 상자 닫기
                        Toast.makeText(getApplicationContext(), "업로드 완료!", Toast.LENGTH_SHORT).show();
                        finish();


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss(); //업로드 진행 Dialog 상자 닫기
                        Toast.makeText(getApplicationContext(), "업로드 실패!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });


            } else {
                DBresgerce = FirebaseDatabase.getInstance().getReference();
                UserDataUpdate = new HashMap<>();

                UserDisplayName = String.valueOf(Update_UserDisPlayName.getText());
                UserPost = String.valueOf(Update_UserPost.getText());

                UserInfo = new UserInfo(Uid, UserEmail, UserImage, UserSex, UserPost, UserPassword, UserDisplayName, UserPassword);
                UserValue = UserInfo.toMap();

                UserDataUpdate.put("/UserInfo/" + firebaseAuth.getCurrentUser().getUid(), UserValue);
                DBresgerce.updateChildren(UserDataUpdate);
                finish();
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 001) {
            if (resultCode == RESULT_OK) {
                try {
                    filepath = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                    Update_UserImage.setImageBitmap(bitmap);


                } catch (Exception e) {
                    e.getStackTrace();
                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.Update_male) {
            Toast.makeText(UpdateUserInfo.this, "남자", Toast.LENGTH_LONG).show();
            UserSex = "남자";
        } else if (checkedId == R.id.Update_female) {
            Toast.makeText(UpdateUserInfo.this, "여자", Toast.LENGTH_LONG).show();
            UserSex = "여자";
        } else {
            UserSex = null;
        }
    }
}
