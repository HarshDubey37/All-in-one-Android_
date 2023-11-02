package com.jtp.hcontactlist.RefreshTime.Refresh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jtp.hcontactlist.R;
import com.jtp.hcontactlist.RefreshTime.Refresh.Jokess.Model.DogBredResponseModel;
import com.jtp.hcontactlist.Retrofit.RetrofitManager;
import com.jtp.hcontactlist.databinding.ActivityRefreshBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RefreshActivity extends AppCompatActivity {
    private ActivityRefreshBinding binding;
    Context context;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRefreshBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        img = findViewById(R.id.Refreshimg);

        //retrofit code
        binding.Refreshlogoimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setup();            }
        });


    }

    private void setup() {

        RetrofitManager.getRetrofitRd().getdetail().enqueue(new Callback<DogBredResponseModel>() {
            @Override
            public void onResponse(Call<DogBredResponseModel> call, Response<DogBredResponseModel> response) {
                DogBredResponseModel dogBredResponseModel=response.body();
                String s=dogBredResponseModel.getMessage();
                //imge view
                Glide.with(RefreshActivity.this).load(s).into(img);

            }

            @Override
            public void onFailure(Call<DogBredResponseModel> call, Throwable t) {

            }
        });
    }
    }
