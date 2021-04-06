package com.example.tugaskedua;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnSubmit;
    private TextView tvName,tvNim,tvScore;
    private EditText et_Name,et_Nim,et_Score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = findViewById(R.id.btn_Submit);
        et_Name = findViewById(R.id.et_Name);
        et_Nim = findViewById(R.id.et_Nim);
        et_Score = findViewById(R.id.et_Score);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sName = et_Name.getText().toString();
                String sNim = et_Nim.getText().toString();
                String sScore = et_Score.getText().toString();


                if(TextUtils.isEmpty(sName)){
                    et_Name.setError("Nama Tidak Boleh Kosong!");
                }
                else if(TextUtils.isEmpty(sNim)){
                    et_Nim.setError("NIM Tidak Boleh Kosong!");
                }
                else if(TextUtils.isEmpty(sScore)){
                    et_Score.setError("Nilai Tidak Boleh Kosong!");
                }
                else {
                    double nilai = Double.parseDouble(sScore);
                    sScore = hitungNilai(nilai);
                    setContentView(R.layout.activity_secondary);
                    tvName = findViewById(R.id.tv_Name);
                    tvNim = findViewById(R.id.tv_Nim);
                    tvScore= findViewById(R.id.tv_Score);

                    tvName.setText("Nama : " + sName);
                    tvNim.setText("NIM    : " + sNim);
                    tvScore.setText("Nilai   : " + sScore);
                }
            }
        });
    }

    protected String hitungNilai(double nilai){
        if (nilai > 3.66 && nilai <= 4 ){
            return "A";
        }
        else if(nilai > 3.33 && nilai <= 3.66 ){
            return "A-";
        }
        else if(nilai > 3 && nilai <= 3.33 ){
            return "B+";
        }
        else if(nilai > 2.66 && nilai <= 3 ){
            return "B";
        }
        else if(nilai > 2.33 && nilai <= 2.66 ){
            return "B-";
        }
        else if(nilai > 2 && nilai <= 2.33 ){
            return "C+";
        }
        else if(nilai > 1.66 && nilai <= 2 ){
            return "C";
        }
        else if(nilai > 1.33 && nilai <= 1.66 ){
            return "C-";
        }
        else if(nilai > 1 && nilai <= 1.33 ){
            return "D+";
        }
        else if(nilai >= 0 && nilai <= 1 ){
            return "D";
        }
        else{
            return "Nilai yang dimasukkan salah!";
        }

    }

}