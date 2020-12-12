package com.bstu.fit.yarmolik.cinema.RecyclerViewAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bstu.fit.yarmolik.cinema.CheckInternetConnection;
import com.bstu.fit.yarmolik.cinema.Fragments.InfoFilmFragment;
import com.bstu.fit.yarmolik.cinema.ModelAdapter.FilmModel;
import com.bstu.fit.yarmolik.cinema.R;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterFilms extends RecyclerView.Adapter<RecyclerViewAdapterFilms.MyViewHolder> {
    private Context mContext;
    private ArrayList<FilmModel> list;
    private String genreValue;
    CheckInternetConnection checkInternetConnection=new CheckInternetConnection();

    public RecyclerViewAdapterFilms(Context mContext, ArrayList<FilmModel> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_film,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        YoYo.with(Techniques.FadeInRight).playOn(holder.cardView);
        genreValue = list.get(position).getGenre().toString();
        genreValue.replace('?',' ');
        //int index = genreValue.indexOf(',',3);
        //genreValue = genreValue.substring(0,index);
        holder.cardName.setText(list.get(position).getName());
        //holder.cardGenre.setText(list.get(position).getGenre());
        holder.cardGenre.setText(genreValue);
        Picasso.get().load(list.get(position).getLink()).into(holder.image);
        //holder.image.setImageBitmap(list.get(position).getImage());
        if(list.get(position).getRating()==0){
            holder.cardRating.setVisibility(View.GONE);
        }
        else{
            holder.cardRating.setText(list.get(position).getRating().toString());
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    Fragment myFragment = new InfoFilmFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("idFilmAdapter", list.get(position).getId());
                    myFragment.setArguments(bundle);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.recyclerFragmentFilm, myFragment).addToBackStack(null).commit();
                    //mListener.onOpenFragmentS(list.get(position).getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        CardView cardView;
        TextView cardName;
        TextView cardGenre;
        TextView cardRating;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageViewFilmItem);
            cardName=itemView.findViewById(R.id.filmNameTextViewItem);
            cardView=itemView.findViewById(R.id.card_films);
            cardGenre=itemView.findViewById(R.id.genreFilmTextViewItem);
            cardRating=itemView.findViewById(R.id.ratingTextViewItem);
        }
    }
 }
