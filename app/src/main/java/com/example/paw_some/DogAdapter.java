package com.example.paw_some;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.paw_some.api.DogData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogViewHolder> {
    private Context context;
    private List<DogData> list;
    public String url;

    public DogAdapter(Context context, List<DogData> list) {
        this.context = context;
        this.list = list;
    }
    public void filterList(List<DogData> filterList){
        list = filterList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dog_item_layout, parent, false);
        return new DogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {
        DogData data = list.get(position);
        holder.Dog_name.setText(data.getName());
        Map<String,String> img = data.getImage();
        Glide.with(context).load(img.get("url")).into(holder.Dog_image);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, MainActivity.class);
            intent.putExtra("Dog_name",data.getName());
            context.startActivity(intent);
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DogViewHolder extends RecyclerView.ViewHolder {
        private TextView Dog_name;
        private ImageView Dog_image;

        public DogViewHolder(@NonNull View itemView) {
            super(itemView);
            Dog_name = itemView.findViewById(R.id.text_view);
            Dog_image = itemView.findViewById(R.id.image_view);
        }
    }
}
