package com.jtp.hcontactlist.Univercity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.jtp.hcontactlist.Retrofit.RetrofitAPI;
import com.jtp.hcontactlist.Retrofit.RetrofitManager;
import com.jtp.hcontactlist.databinding.ActivityUnivercityBinding;
import com.jtp.hcontactlist.model.University;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UnivercityActivity extends AppCompatActivity {
    ActivityUnivercityBinding binding;
    List<University>  universityList;
    UnivercityAdapter uad;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUnivercityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        searchView=binding.searchitem;
        setdataAPI();
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
               filterList(newText);
                return true;
            }
        });


    }

    private void filterList(String newText) {
        List<University> filterlist = new ArrayList<>();
        for (University u : universityList) {
            if (u.getName().toLowerCase().contains(newText.toLowerCase())) {
                filterlist.add(u);
            }
        }

        if (filterlist.isEmpty()) {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_LONG).show();
        } else {
            uad.setFilteredList(filterlist);
        }
    }

    private void setdataAPI() {
            RetrofitManager.getRetrofitUniv() .getalllist().enqueue(new Callback<List<University>>() {
                @Override
                public void onResponse(Call<List<University>> call, Response<List<University>> response) {
                   universityList =response.body();
                    // for (int i=0;i<u.size())

                    Log.d("Message aa","line no 44");
                    //Adapter conectivity
                    uad=new UnivercityAdapter(universityList);
                    LinearLayoutManager ll=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
                    binding.UnivercityRV.setLayoutManager(ll);
                    binding.UnivercityRV.setHasFixedSize(true);
                    Log.d("Message","line no 50");
                    binding.UnivercityRV.setAdapter(uad);
                }

                @Override
                public void onFailure(Call<List<University>> call, Throwable t) {
                    Log.d("Message aa","line no 56  "+t);

                }
            });
        }
        }

