package com.example.tien_trinh_asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView txtthongtin;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtthongtin = (TextView) findViewById(R.id.txt);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TienTrinh().execute();
            }
        });
    }


    private class TienTrinh extends AsyncTask<Void, String, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtthongtin.setText("Bắt đầu:"+ "\n");
        }

        @Override
        protected String doInBackground(Void... voids) {// hàm xữ lý tiến trình

            //Giả lập tiến trình  từ 1 -> 5 và dùng hàm pulishProgress() ghi lại xong đưa xuống onPregressUpdate()
            for(int i = 1; i < 5 ; i++ )
            {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress("Xong việc" + i +"\n");

            }

            return "Xong rồi \n";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtthongtin.append(s);// đợi và nhận kết quả từ doInBackground()
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txtthongtin.append(values[0]);// phần tử thứ 0
        }
    }
}
