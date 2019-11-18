package com.example.mediaproject.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mediaproject.Data.UserModel;
import com.example.mediaproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9!@.#$%^&*?_~]{6,16}$");

    private FirebaseAuth firebaseAuth;

    private EditText editTextEmail;
    private EditText editTextName;
    private EditText editTextPassword;
    private Button signup;
    private String email = "";
    private String name = "";
    private String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();

        editTextEmail = (EditText) findViewById(R.id.signupActivity_email);
        editTextName = (EditText) findViewById(R.id.signupActivity_name);
        editTextPassword = (EditText) findViewById(R.id.signupActivity_password);
        signup = (Button) findViewById(R.id.signupActivity_button);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if(editTextEmail.getText().toString() == null || editTextName.toString() == null
//                        || editTextPassword.getText().toString() == null) {
//                    Toast.makeText(SignupActivity.this, "failed", Toast.LENGTH_SHORT).show();
//                    return;
//                }


                email = editTextEmail.getText().toString();
                name = editTextName.getText().toString();
                password = editTextPassword.getText().toString();

                if (isValidEmail() && isValidName() && isValidPasswd()) {
                    createUser(email, password);
                }


            }
        });

    }

    private void createUser(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        UserModel userModel = new UserModel();
                        userModel.UserEmail = editTextEmail.getText().toString();
                        userModel.UserDisplayName = editTextName.getText().toString();
                        userModel.UserPassword = editTextPassword.getText().toString();
                        userModel.Uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                        userModel.UserProviderId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                        userModel.UserImage = null;
                        userModel.UserPost = null;
                        userModel.UserSex = null;


                        String uid = task.getResult().getUser().getUid();
                        FirebaseDatabase.getInstance().getReference().child("users").child(uid).setValue(userModel);

                        if (task.isSuccessful()) {
                            Toast.makeText(SignupActivity.this, "회원가입 완료", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignupActivity.this, LoginActivityNew.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(SignupActivity.this, "다시 입력해주세요", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    // 이메일 유효성 검사
    private boolean isValidEmail() {
        if (email.isEmpty()) {
            // 이메일 공백
            Toast.makeText(this, "이메일을 입력해주세요", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            // 이메일 형식 불일치
            Toast.makeText(this, "이메일을 다시 입력해주세요", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    // 비밀번호 유효성 검사
    private boolean isValidPasswd() {
        if (password.isEmpty()) {
            // 비밀번호 공백
            Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
            // 비밀번호 형식 불일치
            Toast.makeText(this, "비밀번호를 6자리 이상 입력해주세요", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean isValidName() {
        if (name.isEmpty()) {
            Toast.makeText(this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }


}
