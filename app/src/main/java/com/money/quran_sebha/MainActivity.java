package com.money.quran_sebha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView sebhaCard, quranCard, azkarCard, asmaa_allahCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setData();

        onClick();

    }

    private void setData() {
        sebhaCard = findViewById(R.id.sebhaCard);
        quranCard = findViewById(R.id.quranCard);
        azkarCard = findViewById(R.id.azkarCard);
        asmaa_allahCard = findViewById(R.id.asmaa_allahCard);
    }

    private void onClick() {
        sebhaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SebhaActivity.class));
            }
        });
        quranCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, QuranActivity.class));
            }
        });
        azkarCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AzkarActivity.class));
            }
        });
        asmaa_allahCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NamesAllahActivity.class));
            }
        });
    }

}