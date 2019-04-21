package com.example.recyclerviewtugas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {


    TextView txtName, txtRemarks, txtDesk;
    ImageView imgFoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("name");
        String remarks = intent.getStringExtra("remarks");
        String foto = intent.getStringExtra("foto");
        String desk = intent.getStringExtra("desk");

        txtName = findViewById(R.id.name);
        txtRemarks = findViewById(R.id.remarks);
        txtDesk = findViewById(R.id.desk);
        imgFoto = findViewById(R.id.foto);

        txtName.setText(nama);
        txtRemarks.setText(remarks);
        txtDesk.setText(desk);
        Glide.with(this)
                .load(foto)
                .apply(new RequestOptions().override(350, 550))
                .into(imgFoto);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (savedInstanceState == null) {
            setActionBarTitle("Detail");
        }

    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        onBackPressed();
        return true;
    }
}
