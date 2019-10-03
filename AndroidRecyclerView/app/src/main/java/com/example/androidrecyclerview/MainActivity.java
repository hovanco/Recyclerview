package com.example.androidrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<User> users = new ArrayList<User>();
    RecyclerView recyclerViewUser;
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewUser = findViewById(R.id.recycle_user);
        recyclerViewUser.setLayoutManager(new LinearLayoutManager(this));

        final UserAdapter userAdapter = new UserAdapter();
        recyclerViewUser.setAdapter(userAdapter);

        User user1 = new User("Nam", 9);
        User user2 = new User("Lan", 10);
        User user3 = new User("Ha", 8);

        users.add(user1);
        users.add(user2);
        users.add(user3);

        userAdapter.users = users;

        add = findViewById(R.id.btn_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                users.add(new User("Lan",7));
                userAdapter.notifyDataSetChanged();
            }
        });
    }
}
