package com.example.mediaproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mediaproject.Data.UserTourListData;
import com.example.mediaproject.Data.UserTourListModel;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CommunityTourListLoad extends AppCompatActivity {

    protected FirebaseStorage firebaseStorage;
    protected FirebaseDatabase firebaseDatabase;
    protected FirebaseAuth firebaseAuth;
    protected DatabaseReference databaseReference;

    //실시간 데이터베이스 송신 변수 선어
    HashMap<String, Object> childUpdates = null;
    Map<String, Object> userValue = null;
    UserTourListData userTourListData = null;
    UserTourListModel userTourListModel = null;

    String fileDate;
    String filename;

    private Uri filepath;
    private Button communityTourListGalleryLoad;
    private Button communityTourListFinalUpload;
    private EditText CommunitytourListPost;
    private ImageView CommunityTourListImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_tour_list_load);

        firebaseStorage = FirebaseStorage.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        CommunityTourListImage = (ImageView) findViewById(R.id.CommunityTourListImage);
        communityTourListGalleryLoad = (Button) findViewById(R.id.communityTourListGalleryLoad);
        communityTourListFinalUpload = (Button) findViewById(R.id.communityTourListFinalUpload);
        CommunitytourListPost = (EditText) findViewById(R.id.CommunitytourListPost);

        String NullImage ="https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.e-himart.co.kr%2Fapp%2Fgoods%2FgoodsDetail%3FgoodsNo%3D0002267911&psig=AOvVaw0raNbtrEqzp0IOilBiSssj&ust=1574397944505000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCNix58S_-uUCFQAAAAAdAAAAABAR";
//                Glide.with(this).load(NullImage).into(CommunityTourListImage);


        CommunityTourListImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 0);
            }
        });

        communityTourListGalleryLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 0);
            }
        });

        communityTourListFinalUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadTourList();
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                try {
                    filepath = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                    CommunityTourListImage.setImageBitmap(bitmap);


                } catch (Exception e) {
                    e.getStackTrace();
                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void UploadTourList() {
        if (filepath != null) {

            // 업로드 진행 Dialog 보기
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("업로드중...");
            progressDialog.show();


            //날짜 기준의 파일명 생성
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a h:mm");
            Date now = new Date();

            fileDate = formatter.format(now);
            filename = fileDate + ".png";

            //파이어베이스 스토리지 경로 설정
            final StorageReference storageReference = firebaseStorage.getReferenceFromUrl("gs://mediaproject-2176a.appspot.com")
                    .child("UserTourListImage/" + filename);


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
                    userTourListModel = new UserTourListModel();
                    userTourListModel.Uid = firebaseAuth.getCurrentUser().getUid();
                    userTourListModel.UserEmail = firebaseAuth.getCurrentUser().getEmail();
                    userTourListModel.ImageUri = downloadUri.toString();
                    userTourListModel.ImageName = firebaseAuth.getCurrentUser().getDisplayName();
                    userTourListModel.description = String.valueOf(CommunitytourListPost.getText());
                    userTourListModel.CreateDate = fileDate;
                    userTourListModel.starCount = 0;
                    userTourListModel.CommentCount = 0;
                    userTourListModel.stars = null;
                    userTourListModel.Comments = null;

                    databaseReference.child("UserTourListImage").push().setValue(userTourListModel);

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
            Toast.makeText(getApplicationContext(), "파일을 먼저 선택하세요.", Toast.LENGTH_SHORT).show();
        }
    }
}



