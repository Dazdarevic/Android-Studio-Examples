package com.example.fakultet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fakultet.model.User;
import com.example.fakultet.remote.APIUtils;
import com.example.fakultet.remote.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    UserService userService;
    EditText edUId;
    EditText edUsername;
    Button btnSave;
    Button btnBack;
    Button btnDelete;
    TextView txtUId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        edUId = (EditText) findViewById(R.id.edtUId);
        txtUId = (TextView) findViewById(R.id.txtUId);
        edUsername = (EditText) findViewById(R.id.edtUsername);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        userService = APIUtils.getUserService();

        Bundle extras = getIntent().getExtras();
        String userId = extras.getString("userId");
        String userName = extras.getString("userName");

        edUId.setText(userId);
        edUsername.setText(userName);

        if(userId != null && userId.trim().length() > 0) {
            edUId.setFocusable(false);
            txtUId.setVisibility(View.VISIBLE);
            edUId.setVisibility(View.VISIBLE);
            edUsername.setVisibility(View.VISIBLE);
        } else {
            txtUId.setVisibility(View.INVISIBLE);
            edUId.setVisibility(View.INVISIBLE);
            edUsername.setVisibility(View.INVISIBLE);
        }


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User u = new User();
                u.setName(edUsername.getText().toString());
                if(userId != null && userId.trim().length() > 0) {
                    //update user
                    updateUser(Integer.parseInt(userId), u);
                } else {
                    //save user
                    addUser(u);
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteUser(Integer.parseInt(userId));
                Intent intent = new Intent(UserActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addUser(User u) {
        Call<User> call = userService.addUser(u);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(UserActivity.this, "User created successfully",
                            Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

    public void updateUser(int id, User u) {
        Call<User> call = userService.updateUser(id, u);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(UserActivity.this, "User updated successfully",
                            Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

    public void deleteUser(int id) {
        Call<User> call = userService.deleteUser(id);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(UserActivity.this, "User deleted successfully",
                            Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }
}