package com.belloti.myapplication.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.belloti.myapplication.Model.Post;
import com.belloti.myapplication.R;
import com.belloti.myapplication.View.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequesterActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private TextView textoResultado ;
    private Button botaoRecuperar;
    private List<Post> listaPostagens = new ArrayList<>();
    private DataService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requester);

        textoResultado   = findViewById(R.id.textoResultado );
        botaoRecuperar = findViewById(R.id.buttonRecuperar);


        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        botaoRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //recuperarListaRetrofit();
                //salvarPostagem();
                //atualizarPostagem();
               // removerPostagem();
            }
        });
    }

    private void removerPostagem(){

        Call<Void> call = service.removerPostagem(2);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                if( response.isSuccessful() ){
                    textoResultado.setText( "Status: " + response.code() );
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });

    }
    private void atualizarPostagem(){

        //update post

        Post postagem = new Post();
        postagem.setBody("Corpo da postagem alterado");

        Call<Post> call = service.atualizarPostagemPatch(2, postagem);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if( response.isSuccessful() ){
                    Post postagemResposta = response.body();
                    textoResultado.setText(
                            " Status: " + response.code() +
                                    " id: " + postagemResposta.getId() +
                                    " userId: " + postagemResposta.getUserId() +
                                    " titulo: " + postagemResposta.getTitle() +
                                    " body: " + postagemResposta.getBody()
                    );
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });

    }
    private void salvarPostagem(){

        //recupera o serviço e salva postagem
        Call<Post> call = service.salvarPostagem( "1234", "Título postagem!", "Corpo postagem" );

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if( response.isSuccessful() ){
                    Post postagemResposta = response.body();
                    textoResultado.setText(
                            "Código: " + response.code() +
                                    " id: " + postagemResposta.getId() +
                                    " titulo: " + postagemResposta.getTitle()
                    );
                }

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }
    private void recuperarListaRetrofit(){

        DataService service = retrofit.create(DataService.class);
        Call<List<Post>> call = service.recuperarPostagens();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if( response.isSuccessful() ){
                    listaPostagens = response.body();

                    for (int i=0; i<listaPostagens.size(); i++ ){
                        Post postagem = listaPostagens.get( i );
                        Log.d("resultado", "resultado: " + postagem.getId() + " / " + postagem.getTitle() );
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });

    }

}