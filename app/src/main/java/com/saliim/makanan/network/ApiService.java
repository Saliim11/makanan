package com.saliim.makanan.network;

import com.saliim.makanan.pojo.ResponseMakanan;
import com.saliim.makanan.pojo.ResponseRegister;
import com.saliim.makanan.pojo.ResponseUser;
import com.saliim.makanan.pojo.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("registeruser.php")
    Call<ResponseRegister> response_create_data(
            @Field("vsnama")String nama,
            @Field("vsalamat")String alamat,
            @Field("vsjenkel")String jenkel,
            @Field("vsnotelp")String notelp,
            @Field("vsusername")String username,
            @Field("vslevel")String level,
            @Field("vspassword")String password
    );

    @FormUrlEncoded
    @POST("loginuser.php")
    Call<ResponseUser> user(
            @Field("edtusername")String edtusername,
            @Field("edtpassword")String edtpassword,
            @Field("vslevel")String level
            );

    @GET("getdatamakanan.php")
    Call<ResponseMakanan> makan(
            @Field("vsiduser")String vsiduser,
            @Field("vsidkastrkategorimakanan")String vskateg
    );

}
