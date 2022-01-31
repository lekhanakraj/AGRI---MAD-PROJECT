package com.example.agri;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface RetrofitAPI<url> {

    @GET
    Call<MsgModal> getMessage(@Url String url);

}
