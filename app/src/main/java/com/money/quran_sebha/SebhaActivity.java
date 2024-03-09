package com.money.quran_sebha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Slide;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SebhaActivity extends AppCompatActivity {
    SliderView sliderView;
    SliderAdapter adapter;
    TextView btnSebha, score;
    int i, y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sebha);

        btnSebha = findViewById(R.id.btnSebha);
        sliderView = findViewById(R.id.imageSlider);
        score = findViewById(R.id.score);

        adapter = new SliderAdapter(this);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(1);

        SharedPreferences sharedPreferences = getSharedPreferences("saveScore1", MODE_PRIVATE);
        String saveScore = sharedPreferences.getString("saveScore1", "");
        if (!saveScore.equals("")) {
            y = Integer.parseInt(saveScore);
            score.setText("عدد تسابيحك اليوم هو: " + y);
        }

        renewItems();

        onClick();

    }
    private void onClick() {
        btnSebha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == 33) {
                    i = 0;
                    sliderView.startAutoCycle();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            sliderView.stopAutoCycle();
                        }
                    },1000);
                }
                i++;
                y++;
                btnSebha.setText(i + "/33");
                score.setText("عدد تسابيحك اليوم هو: " + y);
            }
        });
    }

    public void renewItems() {
        List<SliderItem> sliderItemList = new ArrayList<>();
        //dummy data
        for (int i = 0; i < 8; i++) {
            SliderItem sliderItem = new SliderItem();
            if (i == 0) {
                sliderItem.setImageUrl("https://i.postimg.cc/8PXp14Dq/allah-akbar.jpg");
            } else if (i == 1) {
                sliderItem.setImageUrl("https://i.postimg.cc/SNkdyLV7/hamdllah.jpg");
            } else if (i == 2) {
                sliderItem.setImageUrl("https://i.postimg.cc/bwF9H7P3/sobhan-allah.jpg");
            } else if (i == 3) {
                sliderItem.setImageUrl("https://i.postimg.cc/d0yrRD4V/la-alah-ela-allah.jpg");
            } else if (i == 4) {
                sliderItem.setImageUrl("https://i.postimg.cc/Y9NFVZcc/hasby.jpg");
            } else if (i == 5) {
                sliderItem.setImageUrl("https://i.postimg.cc/XqQCN57Q/astthfar.jpg");
            } else if (i == 6) {
                sliderItem.setImageUrl("https://i.postimg.cc/zXGhtx0M/la-hawl.jpg");
            } else {
                sliderItem.setImageUrl("https://i.postimg.cc/kgVb9Brv/sobhan-allah-bhamdah.jpg");
            }
            sliderItemList.add(sliderItem);
        }
        adapter.renewItems(sliderItemList);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = getSharedPreferences("saveScore1", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("saveScore1", String.valueOf(y));
        editor.apply();
    }

}