package net.kikuchy.easingsampler;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by kikuchy on 2016/09/30.
 */

public class SettingFragment extends Fragment {
    private SettingChangeListener listener = null;

    public SettingFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView;
        if (savedInstanceState == null) {
            rootView = inflater.inflate(R.layout.flagment_setting, container, false);
        } else {
            rootView = getView();
        }

        final TextView durationValue = (TextView) rootView.findViewById(R.id.durationValue);
        final SeekBar duration = (SeekBar) rootView.findViewById(R.id.durationSeek);
        duration.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                durationValue.setText(String.format("%d", i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                listener.onSettingChanged(new LinearInterpolator(), seekBar.getProgress());
            }
        });
        final Spinner easing = (Spinner) rootView.findViewById(R.id.easingSpinner);
        final ArrayAdapter<InterpolatorType> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, InterpolatorType.values());
        easing.setAdapter(adapter);
        easing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                InterpolatorType interpolatorType = (InterpolatorType) adapterView.getAdapter().getItem(i);
                listener.onSettingChanged(new LinearInterpolator(), duration.getProgress());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof SettingChangeListener)) {
            throw new IllegalStateException("だめぽ");
        }
        listener = (SettingChangeListener) context;
    }

    @Override
    public void onStart() {
        super.onStart();
        listener.onSettingChanged(new LinearInterpolator(), 300);
    }

    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    public interface SettingChangeListener {
        void onSettingChanged(TimeInterpolator interpolator, long duration);
    }
}
