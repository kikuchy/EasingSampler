package net.kikuchy.easingsampler;

import android.animation.TimeInterpolator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SettingFragment.SettingChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.preview_placeholder, PreviewFragment.newInstance(), "PREVIEW_AREA")
                    .add(R.id.setting_placeholder, SettingFragment.newInstance(), "SETTING_AREA")
                    .commit();
        }
    }

    @Override
    public void onAnimationSettingChanged(TimeInterpolator interpolator, long duration) {
        PreviewFragment preview = (PreviewFragment) getSupportFragmentManager()
                .findFragmentById(R.id.preview_placeholder);
        preview.applyAnimationSetting(interpolator, duration);
    }

    @Override
    public void onActorSettingChanged(ActorForm form) {
        PreviewFragment preview = (PreviewFragment) getSupportFragmentManager()
                .findFragmentById(R.id.preview_placeholder);
        preview.applyActorSetting(form);
    }
}
