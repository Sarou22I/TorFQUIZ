package com.example.torf_quiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tvResult = findViewById(R.id.tvResult);

        boolean isCorrect = getIntent().getBooleanExtra("isCorrect", false);

        if (isCorrect) {
            tvResult.setText("צדקת!");
            LinearLayout MYLinearLayoutCorrect= findViewById(R.id.main);
            MYLinearLayoutCorrect.setBackgroundColor(getColor(R.color.correctColor));
        } else {
            tvResult.setText("טעית...");
            LinearLayout MYLinearLayoutFalse= findViewById(R.id.main);
            MYLinearLayoutFalse.setBackgroundColor(getColor(R.color.wrongColor));
        }
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}