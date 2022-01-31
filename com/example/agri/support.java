package com.example.agri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class support extends AppCompatActivity {

    private RecyclerView chatsRV;
    private EditText userMsgEdt;
    private FloatingActionButton sendMsgFAB;
    private final String BOT_KEY = "bot";
    private final String USER_KEY = "user";

    private ArrayList<ChatsModel> chatsModelArrayList;
    private ChatRVAdopter chatRVAdopter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support);

        chatsRV = findViewById(R.id.idRVchats);
        userMsgEdt = findViewById(R.id.idEditMessage);
        sendMsgFAB = findViewById(R.id.idFABSend);

        chatsModelArrayList = new ArrayList<>();
        chatRVAdopter= new ChatRVAdopter(chatsModelArrayList,this);

        LinearLayoutManager manager = new LinearLayoutManager(this);

        chatsRV.setLayoutManager(manager);
        chatsRV.setAdapter(chatRVAdopter);

        sendMsgFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userMsgEdt.getText().toString().isEmpty()){
                    Toast.makeText(support.this, "Please enter your Message", Toast.LENGTH_SHORT).show();
                    return;
                }
                getResponse(userMsgEdt.getText().toString());
                userMsgEdt.setText("");

            }
        });




    }

    private void getResponse(String message){
        chatsModelArrayList.add(new ChatsModel(message,USER_KEY));
        chatRVAdopter.notifyDataSetChanged();

        String url = "http://api.brainshop.ai/get?bid=163073&key=N18F9d6UlsvgOKbw&uid=[uid]&msg="+message;

        String BASE_URL = "http://api.brainshop.ai/";

        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<MsgModal> call = retrofitAPI.getMessage(url);

        call.enqueue(new Callback<MsgModal>() {
            @Override
            public void onResponse(Call<MsgModal> call, Response<MsgModal> response) {
                if(response.isSuccessful()){
                    MsgModal model = response.body();
                    chatsModelArrayList.add(new ChatsModel(model.getCnt(),BOT_KEY));
                    chatRVAdopter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<MsgModal> call, Throwable t) {

                chatsModelArrayList.add(new ChatsModel("Policies from the Government \n Pradhan Mantri KrishiSinchai Yojana \n Pradhan Mantri Fasal Bhima Yojana ", BOT_KEY));
                chatRVAdopter.notifyDataSetChanged();
            }
        });



    }
}