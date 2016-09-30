package net.kikuchy.easingsampler;

import android.animation.TimeInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.LinearInterpolator;

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

    ANTICIPATE("Anticipate") {
        @Override
        public TimeInterpolator generateInterpolator(float force) {
            return new AnticipateInterpolator(force);
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
