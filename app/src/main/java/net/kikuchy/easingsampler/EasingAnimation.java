package net.kikuchy.easingsampler;

import android.view.View;
import android.view.ViewPropertyAnimator;

/**
 * Created by kikuchy on 2016/10/02.
 */

public enum EasingAnimation {
    FADE_OUT("Fade Out") {
        @Override
        ViewPropertyAnimator presetAnimation(ViewPropertyAnimator naked) {
            return naked.alpha(0f);
        }

        @Override
        void reset(View target) {
            target.setAlpha(1f);
        }
    },

    FADE_IN("Fade In") {
        @Override
        ViewPropertyAnimator presetAnimation(ViewPropertyAnimator naked) {
            return naked.alpha(1f);
        }

        @Override
        void reset(View target) {
            target.setAlpha(0f);
        }
    },

    FALL("fall") {
        @Override
        ViewPropertyAnimator presetAnimation(ViewPropertyAnimator naked) {
            return naked.translationY(300f);
        }

        @Override
        void reset(View target) {
            target.setTranslationY(0f);
        }
    };

    private String name;

    EasingAnimation(String name) {
        this.name = name;
    }

    abstract ViewPropertyAnimator presetAnimation(ViewPropertyAnimator naked);

    abstract void reset(View target);

    @Override
    public String toString() {
        return name;
    }
}
