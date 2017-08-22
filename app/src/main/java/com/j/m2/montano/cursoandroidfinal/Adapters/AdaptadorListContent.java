package com.j.m2.montano.cursoandroidfinal.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.j.m2.montano.cursoandroidfinal.Activitys.DetailActivity;
import com.j.m2.montano.cursoandroidfinal.Fragments.ListContentFragment;
import com.j.m2.montano.cursoandroidfinal.Model.Lugar;
import com.j.m2.montano.cursoandroidfinal.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan on 8/22/2017.
 */

/**
 * AdapterFragmentLista to display recycler view.
 */
public class AdaptadorListContent extends RecyclerView.Adapter<AdaptadorListContent.ViewHolder> {
    // Set numbers of List in RecyclerView.
    private static final int LENGTH = 18;

    private final String[] mPlaces;
    private final Drawable[] mPlaceAvators;
    List<Lugar> lugares = new ArrayList<>();

    public AdaptadorListContent(Context context, List<Lugar> lugares) {
        this.lugares = lugares;
        Resources resources = context.getResources();
        mPlaces = resources.getStringArray(R.array.places);
        //mPlaceDesc = resources.getStringArray(R.array.place_desc);
        TypedArray a = resources.obtainTypedArray(R.array.place_avator);
        mPlaceAvators = new Drawable[a.length()];
        for (int i = 0; i < mPlaceAvators.length; i++) {
            mPlaceAvators[i] = a.getDrawable(i);
        }
        a.recycle();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.avator.setImageDrawable(mPlaceAvators[position]);
        if (lugares.size() != 0) {
            holder.name.setText(lugares.get(position).getNombre_lugar());
            holder.description.setText(lugares.get(position).getBreve_descripcion());
        } else {
            //holder.description.setText(mPlaceDesc[position % mPlaceDesc.length]);
            holder.name.setText(mPlaces[position % mPlaces.length]);
        }
    }

    @Override
    public int getItemCount() {
        return lugares.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView avator;
        private TextView name;
        private TextView description;

        private ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_list, parent, false));
            avator = (ImageView) itemView.findViewById(R.id.list_avatar);
            name = (TextView) itemView.findViewById(R.id.list_title);
            description = (TextView) itemView.findViewById(R.id.list_desc);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }
}
