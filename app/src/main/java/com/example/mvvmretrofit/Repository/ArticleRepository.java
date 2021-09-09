package com.example.mvvmretrofit.Repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmretrofit.Response.ArticleResponse;
import com.example.mvvmretrofit.Retrofit.ApiRequest;
import com.example.mvvmretrofit.Retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ArticleRepository {

    private static final String TAG = ArticleRepository.class.getSimpleName();

      private ApiRequest apiRequest;


      public ArticleRepository(){
          apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);

      }


      public LiveData<ArticleResponse> getMovieArticle(String query, String key)
      {
          final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
          apiRequest.getMovieArticles(query, key)
                  .enqueue(new Callback<ArticleResponse>() {
                      @Override
                      public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                          Log.d(TAG, "onResponse response::" +response);

                          if(response.body() != null)
                          {
                              data.setValue(response.body());
                          }


                      }

                      @Override
                      public void onFailure(Call<ArticleResponse> call, Throwable t) {
                           data.setValue(null);
                      }
                  });

          return data;
      }




}
