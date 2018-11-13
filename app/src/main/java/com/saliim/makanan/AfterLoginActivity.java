package com.saliim.makanan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.saliim.makanan.adapter.CustomAdapter;
import com.saliim.makanan.network.ApiService;
import com.saliim.makanan.network.ConfigRetrofit;
import com.saliim.makanan.pojo.DataMakananItem;
import com.saliim.makanan.pojo.ResponseMakanan;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemSelected;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AfterLoginActivity extends AppCompatActivity {

    @BindView(R.id.list)
    RecyclerView list;
    @BindView(R.id.spin)
    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        ButterKnife.bind(this);

        final String[] fruit = new String[]{
                "All", "Martabak", "Aneka Nasi", "Aneka Ayam & Bebek", "Snack & Jajanan", "Pizza & Pasta", "Bakmie"
        };

        ArrayAdapter<String> adapterFruit = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruit);
        spin.setAdapter(adapterFruit);

        list.setLayoutManager(new LinearLayoutManager(this));

    }

    private void getData(String user, String makanan) {
        ApiService apiService = ConfigRetrofit.getInsteance();
        Call<ResponseMakanan> call = apiService.makan(user, makanan);
        call.enqueue(new Callback<ResponseMakanan>() {
            @Override
            public void onResponse(Call<ResponseMakanan> call, Response<ResponseMakanan> response) {
                List<DataMakananItem> makananItem = response.body().getDataMakanan();
                CustomAdapter adapter = makananItem.size() > 0 ?
                        new CustomAdapter(AfterLoginActivity.this, makananItem) : null;

                list.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResponseMakanan> call, Throwable t) {
                Toast.makeText(AfterLoginActivity.this, "gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnItemSelected(R.id.spin)
    public void spinnerItemSelected(int position) {
        String pos = String.valueOf(position);
        Toast.makeText(this, pos, Toast.LENGTH_SHORT).show();
        getData("114", pos);
    }
}
