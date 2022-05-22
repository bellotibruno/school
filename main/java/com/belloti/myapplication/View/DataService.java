package com.belloti.myapplication.View;

import com.belloti.myapplication.Model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DataService {



    @GET("/posts")
    Call<List<Post>> recuperarPostagens();

    @POST("/posts")
    Call<Post> salvarPostagem(@Body Post postagem);

    //userId=1234&title=Título postagem&body=Corpo postagem
    @FormUrlEncoded
    @POST("/posts")
    Call<Post> salvarPostagem(
            @Field("userId") String userId,
            @Field("title") String title,
            @Field("body") String body
    );

    @PUT("/posts/{id}")
    Call<Post> atualizarPostagem(@Path("id") int id, @Body Post postagem );

    @PATCH("/posts/{id}")
    Call<Post> atualizarPostagemPatch(@Path("id") int id, @Body Post postagem );

    @DELETE("/posts/{id}")
    Call<Void> removerPostagem(@Path("id") int id);

}
