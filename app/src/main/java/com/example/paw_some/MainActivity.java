package com.example.paw_some;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.paw_some.api.ApiInterface;
import com.example.paw_some.api.ApiUtils;
import com.example.paw_some.api.DogData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView Name;
    private TextView Temperament;
    private TextView LifeSpan;
    private ImageView Image;

    private List<DogData> list;
    String Dog_name = "Golden Retriever";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        if(getIntent().getStringExtra("Dog_name")!= null)
            Dog_name = getIntent().getStringExtra("Dog_name");

        Name= findViewById(R.id.name_text_view);
        Temperament = findViewById(R.id.origin_text_view);
        LifeSpan = findViewById(R.id.lifeSpan_text_view);
        Image = findViewById(R.id.dog_image_view);

        Name.setOnClickListener(v-> startActivity(new Intent(MainActivity.this,MainActivity2.class)));

        ApiUtils.getApiInterface().getDogData().enqueue(new Callback<List<DogData>>() {
            @Override
            public void onResponse(Call<List<DogData>> call, Response<List<DogData>> response) {
                list.addAll(response.body());
                for(int i=0; i<list.size(); i++){
                    if(list.get(i).getName().equals(Dog_name)){
                        String name = list.get(i).getName();
                        String life_span = list.get(i).getLife_span();
                        String temperament = list.get(i).getTemperament();
                        Map<String,String> img = list.get(i).getImage();
                        String url = img.get("url");
                        Picasso.get().load(url).into(Image);
                        Name.setText(name);
                        LifeSpan.setText(life_span);
                        Temperament.setText(temperament);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<DogData>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"ERROR",Toast.LENGTH_SHORT);

            }
        });


    }


}