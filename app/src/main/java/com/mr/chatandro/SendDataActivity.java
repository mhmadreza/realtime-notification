package com.mr.chatandro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.pusher.client.Client;

import cz.msebera.android.httpclient.Header;

public class SendDataActivity extends AppCompatActivity {

    Button kirim;
    EditText nama, pesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);
        initView();
    }

    private void initView() {

        kirim = findViewById(R.id.btn_kirim);
        nama = findViewById(R.id.et_nama_lengkap);
        pesan = findViewById(R.id.et_pesan);

        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNama = nama.getText().toString().trim();
                String getPesan = pesan.getText().toString().trim();

                AsyncHttpClient client = new AsyncHttpClient();
                RequestParams params = new RequestParams();
                params.put("nama", getNama);
                params.put("pesan", getPesan);

                client.post("https://apichat01.000webhostapp.com/send.php", params, new AsyncHttpResponseHandler(){

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    }
                });

            }
        });

    }
}