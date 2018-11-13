package com.saliim.makanan.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.saliim.makanan.BuildConfig;
import com.saliim.makanan.R;
import com.saliim.makanan.pojo.DataMakananItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context context;
    private List<DataMakananItem> datamakan;

    public CustomAdapter(Context context, List<DataMakananItem> datamakan) {
        this.context = context;
        this.datamakan = datamakan;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final String namaM = datamakan.get(i).getMakanan();
        final String fotoM = datamakan.get(i).getFotoMakanan();
        final String tglM = datamakan.get(i).getInsertTime();

        viewHolder.txtText.setText(namaM);
        Picasso.get()
                .load(BuildConfig.BASE_URL + BuildConfig.GAMBAR + fotoM)
                .into(viewHolder.imgGambar);

        Log.d("gambar", BuildConfig.BASE_URL + BuildConfig.GAMBAR + fotoM);
    }

    @Override
    public int getItemCount() {
        return datamakan.size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_gambar)
        ImageView imgGambar;
        @BindView(R.id.txt_text)
        TextView txtText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
