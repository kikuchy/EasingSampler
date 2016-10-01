package net.kikuchy.easingsampler;

import android.view.View;
import android.view.ViewPropertyAnimator;

/**
 * Created by kikuchy on 2016/10/02.
 */

public enum EasingAnimation {
    FADE_OUT {
        @Override
        ViewPropertyAnimator presetAnimation(ViewPropertyAnimator naked) {
            return naked.alpha(0f);
        }

        @Override
        void reset(View target) {
            target.setAlpha(1f);
        }
    };

    abstract ViewPropertyAnimator presetAnimation(ViewPropertyAnimator naked);

    abstract void reset(View target);
}
