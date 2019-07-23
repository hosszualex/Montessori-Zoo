package com.example.montessorizoo;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    private ArrayList<Animal_item> mAnimalList;

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
        }


    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

    if(AnimalsList.returnBool()==false)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.animal_item, viewGroup, false);
        AnimalViewHolder avh = new AnimalViewHolder(v,mListener);

        return avh;
    }
        else
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.animal_item_card, viewGroup, false);
        AnimalViewHolder avh_card = new AnimalViewHolder(v,mListener);

        return avh_card;
    }


}

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder animalViewHolder, int position) {
        Animal_item currentItem = mAnimalList.get(position);
        animalViewHolder.mImageView.setImageResource(currentItem.getmImageAnimal());
        animalViewHolder.mTitle.setText(currentItem.getmName());
        animalViewHolder.mDesc.setText(currentItem.getmDesc());
}

    @Override
    public int getItemCount() {

    return mAnimalList.size();
    }
}
