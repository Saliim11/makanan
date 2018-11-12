package com.saliim.makanan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.saliim.makanan.network.ApiService;
import com.saliim.makanan.network.ConfigRetrofit;
import com.saliim.makanan.pojo.ResponseRegister;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.et_nama)
    EditText etNama;
    @BindView(R.id.et_alamat)
    EditText etAlamat;
    @BindView(R.id.et_jenkel)
    EditText etJenkel;
    @BindView(R.id.et_notelp)
    EditText etNotelp;
    @BindView(R.id.et_reg_username)
    EditText etRegUsername;
    @BindView(R.id.et_reg_password)
    EditText etRegPassword;
    @BindView(R.id.btn_reg_admin)
    RadioButton btnRegAdmin;
    @BindView(R.id.btn_reg_user)
    RadioButton btnRegUser;
    @BindView(R.id.btn_register)
    Button btnRegister;

    String snama, salamat, sjenkel, snotelp, susername, spassword,  level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btn_register)
    public void onViewClicked() {
        registerUser();

        untukEditText();
    }

    private void untukEditText() {
        if (snama.isEmpty()){
            etNama.setError("harus di isi");
        }else if (salamat.isEmpty()){
            etAlamat.setError("harus di isi");
        } else if (sjenkel.isEmpty()) {
            etJenkel.setError("harus di isi");
        }else if (snotelp.isEmpty()) {
            etNotelp.setError("harus di isi");
        }else if (spassword.isEmpty()) {
            etRegPassword.setError("harus di isi");
        }else if (susername.isEmpty()) {
            etRegUsername.setError("harus di isi");
        } else {

            ApiService apiService = ConfigRetrofit.getInsteance();
            Call<ResponseRegister>call = apiService.response_create_data(snama,salamat,sjenkel,snotelp,susername,level,spassword);
            call.enqueue(new Callback<ResponseRegister>() {
                @Override
                public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {

                    if (response.isSuccessful()) {
                        String msg = response.body().getMsg();
                        String result = response.body().getResult();
                        Toast.makeText(RegisterActivity.this, msg + result, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));

                    }
                }

                @Override
                public void onFailure(Call<ResponseRegister> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    private void registerUser() {
        if (btnRegAdmin.isChecked()){
            level = "admin";
        }else{
            level = "user biasa";
        }
        snama = etNama.getText().toString();
        salamat = etAlamat.getText().toString();
        sjenkel = etJenkel.getText().toString();
        snotelp = etNotelp.getText().toString();
        susername = etRegUsername.getText().toString();
        spassword = etRegPassword.getText().toString();


    }
}
