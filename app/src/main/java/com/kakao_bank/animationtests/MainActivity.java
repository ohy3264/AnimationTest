package com.kakao_bank.animationtests;

import android.animation.ObjectAnimator;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import com.kakao_bank.animationtests.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Boolean toggle = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setHandlers(new EventHandlers());
        binding.iconImageView.setRotation(180);
    }

    public class ViewModel {

    }

    public class EventHandlers {

        public void startViewAnimationButtonClicked() {
            RotateAnimation rotateAnimation;
            if (toggle) {
                rotateAnimation = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(300);
                rotateAnimation.setFillAfter(true);
                toggle = false;
            } else {
                rotateAnimation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(300);
                rotateAnimation.setFillAfter(true);
                toggle = true;
            }
            binding.iconImageView.startAnimation(rotateAnimation);
        }

        public void startViewPropertyAnimationButtonClicked() {
            if (toggle) {
                binding.iconImageView.animate().rotation(180);
                toggle = false;
            } else {
                binding.iconImageView.animate().rotation(0);
                toggle = true;
            }
        }

        public void startViewObjectAnimationButtonClickerd() {
            ObjectAnimator objectAnimator;
            if (toggle) {
                objectAnimator = ObjectAnimator.ofFloat(binding.iconImageView, View.ROTATION, 180, 0);
            } else {
                objectAnimator = ObjectAnimator.ofFloat(binding.iconImageView, View.ROTATION, 0, 180);
            }
            objectAnimator.start();
        }
    }
}
