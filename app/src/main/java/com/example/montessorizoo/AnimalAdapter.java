package com.example.montessorizoo;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> implements Filterable {
    private List<Animal_item> mAnimalList;
    private List<Animal_item> mAnimalListFull;

    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){

        mListener = listener;
    }

public static class AnimalViewHolder extends  RecyclerView.ViewHolder {

    public ImageView mImageView;
    public TextView mTitle;
    public TextView mDesc;


        public AnimalViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
        super(itemView);

        mImageView = itemView.findViewById(R.id.image_item);
        mTitle = itemView.findViewById(R.id.textView_title);
        mDesc = itemView.findViewById(R.id.textView_desc);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION)
                        listener.onItemClick(position);
                }
            }
        });


        }
    }

        public  AnimalAdapter(ArrayList<Animal_item> animalList){
            mAnimalList = animalList;
            mAnimalListFull = new ArrayList<>(animalList);
        }


    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

    if(AnimalsList.returnViewType()==0)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.animal_item, viewGroup, false);
        AnimalViewHolder avh = new AnimalViewHolder(v,mListener);

        return avh;
    }
        else
            if(AnimalsList.returnViewType()==1)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.animal_item_card, viewGroup, false);
        AnimalViewHolder avh_card = new AnimalViewHolder(v,mListener);

        return avh_card;
    }
        else
            if(AnimalsList.returnViewType()==2)
            {
                View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.animal_item_grid, viewGroup, false);
                AnimalViewHolder avh_grid = new AnimalViewHolder(v,mListener);

                return avh_grid;
            }

    return null;
}

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder animalViewHolder, int position) {

        if(AnimalsList.returnViewType()==0 || AnimalsList.returnViewType()==1)
        {
            Animal_item currentItem = mAnimalList.get(position);
            animalViewHolder.mImageView.setImageResource(currentItem.getmImageAnimal());
        animalViewHolder.mTitle.setText(currentItem.getmName());
        animalViewHolder.mDesc.setText(currentItem.getmDesc());
        }
        else
            if(AnimalsList.returnViewType()==2)
            {
                Animal_item currentItem = mAnimalList.get(position);
                animalViewHolder.mImageView.setImageResource(currentItem.getmImageAnimal());
            }



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

            List<Animal_item> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                filteredList.addAll(mAnimalListFull);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Animal_item item : mAnimalListFull){
                    if(item.getmRegion().toLowerCase().trim().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return  results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            mAnimalList.clear();
            mAnimalList.addAll((List)results.values);
            notifyDataSetChanged();

        }
    };


}
