package com.j.m2.montano.cursoandroidfinal.Adapters;

/**
 * Created by Juan on 8/22/2017.
 */


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.j.m2.montano.cursoandroidfinal.Activitys.DetailActivity;
import com.j.m2.montano.cursoandroidfinal.Fragments.CardContentFragment;
import com.j.m2.montano.cursoandroidfinal.Model.Lugar;
import com.j.m2.montano.cursoandroidfinal.R;

import java.util.ArrayList;
import java.util.List;

/**
 * AdapterFragmentLista to display recycler view.
 */
public class AdaptadorCard extends RecyclerView.Adapter<AdaptadorCard.ViewHolder> {

    private final Drawable[] mPlacePictures;
    List<Lugar> lugares = new ArrayList<>();

    public AdaptadorCard(Context context, List<Lugar> lug) {
        this.lugares = lug;
        Resources resources = context.getResources();

        TypedArray a = resources.obtainTypedArray(R.array.place_avator);
        mPlacePictures = new Drawable[a.length()];
        for (int i = 0; i < mPlacePictures.length; i++) {
            mPlacePictures[i] = a.getDrawable(i);
        }
        a.recycle();
    }

    @Override
    public AdaptadorCard.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AdaptadorCard.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.picture.setImageDrawable(mPlacePictures[position]);
        holder.name.setText(lugares.get(position).getNombre_lugar());
        holder.description.setText(lugares.get(position).getDescripcion());
    }

    /*@Override
    public void onBindViewHolder(CardContentFragment.ViewHolder holder, int position) {
        holder.picture.setImageDrawable(mPlacePictures[position]);
        holder.name.setText(lugares.get(position).getNombre_lugar());
        holder.description.setText(lugares.get(position).getDescripcion());
    }*/

    @Override
    public int getItemCount() {
        return lugares.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView picture;
        private TextView name;
        private TextView description;

        private ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.card_image);
            name = (TextView) itemView.findViewById(R.id.card_title);
            description = (TextView) itemView.findViewById(R.id.card_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });

            // Adding Snackbar to Action Button inside card
            Button button = (Button) itemView.findViewById(R.id.action_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Action is pressed",
                            Snackbar.LENGTH_LONG).show();
                }
            });

            ImageButton favoriteImageButton =
                    (ImageButton) itemView.findViewById(R.id.favorite_button);
            favoriteImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Added to Favorite",
                            Snackbar.LENGTH_LONG).show();
                }
            });

            ImageButton shareImageButton = (ImageButton) itemView.findViewById(R.id.share_button);
            shareImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Share article",
                            Snackbar.LENGTH_LONG).show();
                }
            });
        }


    }

}




