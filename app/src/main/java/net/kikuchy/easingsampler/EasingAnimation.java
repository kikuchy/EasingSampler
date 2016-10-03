package net.kikuchy.easingsampler;

import android.util.Size;
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
        void reset(View target, Size stageSize) {
            target.setAlpha(1f);
        }
    },

    FADE_IN("Fade In") {
        @Override
        ViewPropertyAnimator presetAnimation(ViewPropertyAnimator naked) {
            return naked.alpha(1f);
        }

        @Override
        void reset(View target, Size stageSize) {
            target.setAlpha(0f);
        }
    },

    FALL("fall") {
        @Override
        ViewPropertyAnimator presetAnimation(ViewPropertyAnimator naked) {
            return naked.translationY(300f);
        }

        @Override
        void reset(View target, Size stageSize) {
            target.setTranslationY(0f);
        }
    },

    SQUEEZE_LEFT("Squeeze Left") {
        @Override
        ViewPropertyAnimator presetAnimation(ViewPropertyAnimator naked) {
            return naked.translationX(0f);
        }

        @Override
        void reset(View target, Size stageSize) {
            target.setX(-1f * target.getWidth());
        }
    },

    SQUEEZE_RIGHT("Squeeze Right") {
        @Override
        ViewPropertyAnimator presetAnimation(ViewPropertyAnimator naked) {
            return naked.translationX(0f);
        }

        @Override
        void reset(View target, Size stageSize) {
            target.setTranslationX((stageSize.getWidth() + target.getWidth()) / 2);
        }
    },

    SQUEEZE_DOWN("Squeeze Down") {
        @Override
        ViewPropertyAnimator presetAnimation(ViewPropertyAnimator naked) {
            return naked.translationY(0f);
        }

        @Override
        void reset(View target, Size stageSize) {
            target.setY(-1f * target.getHeight());
        }
    },

    SQUEEZE_UP("Squeeze Up") {
        @Override
        ViewPropertyAnimator presetAnimation(ViewPropertyAnimator naked) {
            return naked.translationY(0f);
        }

        @Override
        void reset(View target, Size stageSize) {
            target.setTranslationY((stageSize.getHeight() + target.getHeight()) / 2);
        }
    };

    private String name;

    EasingAnimation(String name) {
        this.name = name;
    }

    abstract ViewPropertyAnimator presetAnimation(ViewPropertyAnimator naked);

    abstract void reset(View target, Size stageSize);

    @Override
    public String toString() {
        return name;
    }
}
