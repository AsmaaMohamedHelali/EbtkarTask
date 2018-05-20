package com.example.android.ebtkartask.utils.webservice;


import com.example.android.ebtkartask.models.response.UsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MyTaskAPI {

    @GET
    Call<UsersResponse> getUsers(@Url String url);


}
