package com.example.mediaproject;

import android.os.Bundle;

public class RecommendActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_recommend);

//            TestDataTestView = (TextView) findViewById(R.id.TestDataTestView);
//            DBresgerce = FirebaseDatabase.getInstance().getReference();
//            DBresgerce.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                        String key = postSnapshot.getKey();
//                        HashMap<String, HashMap<String, Object>> test = (HashMap<String, HashMap<String, Object>>) postSnapshot.getValue();
//
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//                    Log.w("Database", "Failed to read value.", databaseError.toException());
//
//                }
//            });


    }

    @Override
    protected void onResume() {
        super.onResume();
        setSelected(R.id.navigation_menu1);
    }
}
