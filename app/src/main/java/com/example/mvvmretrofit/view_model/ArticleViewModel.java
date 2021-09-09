package com.example.mvvmretrofit.view_model;

import static com.example.mvvmretrofit.Constant.AppConstant.API_KEY;
import static com.example.mvvmretrofit.Constant.AppConstant.ARTICLE_QUERY;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvmretrofit.Repository.ArticleRepository;
import com.example.mvvmretrofit.Response.ArticleResponse;

public class ArticleViewModel extends AndroidViewModel {

    private ArticleRepository articleRepository;
    private LiveData<ArticleResponse> articleResponseLiveData;


    public ArticleViewModel(@NonNull Application application) {
        super(application);

        articleRepository = new ArticleRepository();
        this.articleResponseLiveData = articleRepository.getMovieArticle(ARTICLE_QUERY, API_KEY);


    }

    public LiveData<ArticleResponse> getArticleResponseLiveData(){
        return articleResponseLiveData;
    }


}
