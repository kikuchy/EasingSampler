package net.kikuchy.easingsampler;

import android.animation.TimeInterpolator;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

/**
 * Created by kikuchy on 2016/09/30.
 */

public enum InterpolatorType {
    LINER("Liner") {
        @Override
        public TimeInterpolator generateInterpolator(float force) {
            return new LinearInterpolator();
        }
    },

    ACCELERATE("Accelerate") {
        @Override
        public TimeInterpolator generateInterpolator(float force) {
            return new AccelerateInterpolator(force);
        }
    },

    ACCELERATE_DECELERATE("AccelerateDecelerate") {
        @Override
        public TimeInterpolator generateInterpolator(float force) {
            return new AccelerateDecelerateInterpolator();
        }
    },

    ANTICIPATE("Anticipate") {
        @Override
        public TimeInterpolator generateInterpolator(float force) {
            return new AnticipateInterpolator(force);
        }
    },

    ANTICIPATE_OVERSHOOT("AnticipateOvershoot") {
        @Override
        public TimeInterpolator generateInterpolator(float force) {
            return new AnticipateOvershootInterpolator(force);
        }
    },

    BOUNCE("Bounce") {
        @Override
        public TimeInterpolator generateInterpolator(float force) {
            return new BounceInterpolator();
        }
    },

    Cycle("Cycle") {
        @Override
        public TimeInterpolator generateInterpolator(float force) {
            return new CycleInterpolator(force);
        }
    },

    Decelerate("Decelerate") {
        @Override
        public TimeInterpolator generateInterpolator(float force) {
            return new DecelerateInterpolator(force);
        }
    },

    FAST_OUT_LINEAR("FastOutLinear") {
        @Override
        public TimeInterpolator generateInterpolator(float force) {
            return new FastOutLinearInInterpolator();
        }
    },

    FAST_OUT_SLOW_IN("FastOutSlowIn") {
        @Override
        public TimeInterpolator generateInterpolator(float force) {
            return new FastOutSlowInInterpolator();
        }
    },

    LINEAR_OUT_SLOW_IN("LinearOutSlowIn") {
        @Override
        public TimeInterpolator generateInterpolator(float force) {
            return new LinearOutSlowInInterpolator();
        }
    },

    OVERSHOOT("Overshoot") {
        @Override
        public TimeInterpolator generateInterpolator(float force) {
            return new OvershootInterpolator(force);
        }
    };

    private String label;

    InterpolatorType(String label) {
        this.label = label;
    }

    public abstract TimeInterpolator generateInterpolator(float force);

    @Override
    public String toString() {
        return label;
    }
}
