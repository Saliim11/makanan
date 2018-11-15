package com.saliim.makanan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.saliim.makanan.network.ApiService;
import com.saliim.makanan.network.ConfigRetrofit;
import com.saliim.makanan.pojo.ResponseUser;
import com.saliim.makanan.pojo.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_admin)
    RadioButton btnAdmin;
    @BindView(R.id.btn_user)
    RadioButton btnUser;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_pindah_reg)
    TextView btnPindahReg;

    String usernamaLog, passwordLog, levelLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_login, R.id.btn_pindah_reg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:

                masukLogin();

                break;

            case R.id.btn_pindah_reg:
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                break;
        }
    }

    private void masukLogin() {
        if (btnAdmin.isChecked()){
            levelLog = "admin";
        } else{
            levelLog = "user biasa";
        }

        usernamaLog = etUsername.getText().toString();
        passwordLog = etPassword.getText().toString();

        if (usernamaLog.isEmpty()){
            etUsername.setError("harus di isi");
        }else if (passwordLog.isEmpty()){
            etPassword.setError("harus id isi");
        } else {
            ApiService apiService = ConfigRetrofit.getInsteance();
            Call<ResponseUser>call = apiService.user(usernamaLog, passwordLog, levelLog);
            call.enqueue(new Callback<ResponseUser>() {
                @Override
                public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                    if (response.isSuccessful()){
                        String msg = response.body().getMsg();
                        String result = response.body().getResult();
                        Toast.makeText(MainActivity.this, msg + result, Toast.LENGTH_SHORT).show();

                        Log.d("FORM", "username: '" + usernamaLog+ "' password:'" +passwordLog+ "' level:'" + levelLog + "'");
                        Log.d("FORM", result+msg);

                        if(result.equals("1")){
                            startActivity(new Intent(MainActivity.this, AfterLoginActivity.class));
                            AfterLoginActivity.USERID = response.body().getUser().getIdUser();
                            finish();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseUser> call, Throwable t) {
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
