package com.example.mvvmretrofit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvmretrofit.Model.Article;
import com.example.mvvmretrofit.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MovieArticleAdapter extends RecyclerView.Adapter<MovieArticleAdapter.ViewHolder>{
      private Context context;
      ArrayList<Article> articleArrayList;


    public MovieArticleAdapter(Context context, ArrayList<Article> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_each_row_movie_article,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Article article = articleArrayList.get(position);
        holder.tvTitle.setText(article.getTitle());
        holder.tvAuthorAndPublishedAt.setText("_"+article.getAuthor()+" | " + "Published At:" + article.getPublishedAt());
        holder.tvDescription.setText(article.getDescription());

        Glide.with(context).load(article.getUrlToImage()).into(holder.imageViewCover);

    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageViewCover;
        private final TextView tvTitle;
        private final TextView tvAuthorAndPublishedAt;
        private final TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewCover = itemView.findViewById(R.id.imageViewCover);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthorAndPublishedAt = itemView.findViewById(R.id.tvAuthorAndPublishedAt);
            tvDescription = itemView.findViewById(R.id.tvDescription);



        }
    }
}
