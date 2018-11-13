package com.saliim.makanan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.saliim.makanan.adapter.CustomAdapter;
import com.saliim.makanan.network.ApiService;
import com.saliim.makanan.network.ConfigRetrofit;
import com.saliim.makanan.pojo.DataMakananItem;
import com.saliim.makanan.pojo.ResponseMakanan;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AfterLoginActivity extends AppCompatActivity {

    @BindView(R.id.list)
    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        ButterKnife.bind(this);

        list.setLayoutManager(new LinearLayoutManager(this));

        getData();
    }

    private void getData() {
        ApiService apiService = ConfigRetrofit.getInsteance();
        Call<ResponseMakanan>call = apiService.makan();
        call.enqueue(new Callback<ResponseMakanan>() {
            @Override
            public void onResponse(Call<ResponseMakanan> call, Response<ResponseMakanan> response) {
                List<DataMakananItem>makananItem = response.body().getDataMakanan();

                Log.d("Data Makanan", String.valueOf(makananItem.get(0)));

                CustomAdapter adapter = new CustomAdapter(AfterLoginActivity.this, makananItem);
                list.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResponseMakanan> call, Throwable t) {
                Toast.makeText(AfterLoginActivity.this, "gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
