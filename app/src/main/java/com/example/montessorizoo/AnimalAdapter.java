package com.example.montessorizoo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.montessorizoo.activities.AnimalsListActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> implements Filterable {
    private List<Animal> mAnimalList = new ArrayList<>();
    private List<Animal> mAnimalListFull = new ArrayList<>();

    private OnItemClickListener mListener;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {

        mListener = listener;
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTitle;
        public TextView mDesc;
        Context context;


        public AnimalViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.image_item);
            mTitle = itemView.findViewById(R.id.textView_title);
            mDesc = itemView.findViewById(R.id.textView_desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION)
                            listener.onItemClick(position);
                    }
                }
            });
        }
    }


    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        if (AnimalsListActivity.returnViewType() == 0) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.animal_item, viewGroup, false);
            AnimalViewHolder avh = new AnimalViewHolder(v, mListener);

            return avh;
        } else if (AnimalsListActivity.returnViewType() == 1) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.animal_item_card, viewGroup, false);
            AnimalViewHolder avh_card = new AnimalViewHolder(v, mListener);

            return avh_card;
        } else if (AnimalsListActivity.returnViewType() == 2) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.animal_item_grid, viewGroup, false);
            AnimalViewHolder avh_grid = new AnimalViewHolder(v, mListener);

            return avh_grid;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder animalViewHolder, int position) {

        if (AnimalsListActivity.returnViewType() == 0 || AnimalsListActivity.returnViewType() == 1) {
            Animal currentItem = mAnimalList.get(position);
            animalViewHolder.mTitle.setText(currentItem.getmName());
            animalViewHolder.mDesc.setText(currentItem.getmDesc());
            Picasso.get().load(currentItem.getmImageAnimalURL()).into(animalViewHolder.mImageView);

        } else if (AnimalsListActivity.returnViewType() == 2) {
            Animal currentItem = mAnimalList.get(position);
            Picasso.get().load(currentItem.getmImageAnimalURL()).into(animalViewHolder.mImageView);
        }
    }

    public AnimalAdapter(List<Animal> animalList) {

        mAnimalList = animalList;
        mAnimalListFull = new ArrayList<>(animalList);

    }


    @Override
    public int getItemCount() {
        return mAnimalList.size();
    }

    //filtering by the regions
    @Override
    public Filter getFilter() {
        return animalFilter;
    }

    private Filter animalFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<Animal> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mAnimalListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Animal item : mAnimalListFull) {
                    if (item.getmRegion().toLowerCase().trim().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            mAnimalList.clear();
            mAnimalList.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };


}
