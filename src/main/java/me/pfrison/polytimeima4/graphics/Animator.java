package me.pfrison.polytimeima4.graphics;

import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

public class Animator {
    static void animateIn(View view){
        view.setAlpha(0f);
        view.setTranslationY(100);
        view.setTranslationX(0);
        view.animate()
                .alpha(1f)
                .setDuration(100)
                .translationY(0)
                .translationX(0)
                .setListener(null);
    }

    static void animateOutIn(final View view, final Runnable next){
        view.setAlpha(1f);
        view.setTranslationY(0);
        view.setTranslationX(0);
        view.animate()
                .alpha(0f)
                .setDuration(100)
                .translationY(100)
                .translationX(0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(android.animation.Animator animation) {
                        next.run();
                        view.animate()
                                .alpha(1f)
                                .setDuration(100)
                                .translationY(0)
                                .translationX(0)
                                .setListener(null);
                    }
                });
    }

    static void animateLeft(final View view, final Runnable next){
        view.setAlpha(1f);
        view.setTranslationX(0);
        view.setTranslationY(0);
        view.animate()
                .alpha(0f)
                .setDuration(100)
                .translationX(100)
                .translationY(0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(android.animation.Animator animation) {
                        next.run();
                        view.setTranslationX(-100);
                        view.animate()
                                .alpha(1f)
                                .setDuration(100)
                                .translationX(0)
                                .translationY(0)
                                .setListener(null);
                    }
                });
    }

    static void animateRight(final View view, final Runnable next){
        view.setAlpha(1f);
        view.setTranslationX(0);
        view.setTranslationY(0);
        view.animate()
                .alpha(0f)
                .setDuration(100)
                .translationX(-100)
                .translationY(0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(android.animation.Animator animation) {
                        next.run();
                        view.setTranslationX(100);
                        view.animate()
                                .alpha(1f)
                                .setDuration(100)
                                .translationX(0)
                                .translationY(0)
                                .setListener(null);
                    }
                });
    }

    public static void animateAchievement(final View view, final Runnable next){
        view.setAlpha(0f);
        view.setTranslationY(-300);
        view.animate()
                .alpha(1f)
                .setDuration(700)
                .translationY(0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(android.animation.Animator animation) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                view.animate()
                                        .alpha(0f)
                                        .setDuration(700)
                                        .translationY(-300)
                                        .setListener(new AnimatorListenerAdapter() {
                                            @Override
                                            public void onAnimationEnd(android.animation.Animator animation) {
                                                next.run();
                                                view.setTranslationY(0);
                                            }
                                        });
                            }
                        }, 5000);
                    }
                });
    }
}
