package net.kikuchy.easingsampler;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by kikuchy on 2016/09/30.
 */

public class SettingFragment extends Fragment {
    private SettingChangeListener listener = null;
    private SeekBar duration;
    private Spinner easing;
    private SeekBar force;
    private Switch actorForm;

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
        duration = (SeekBar) rootView.findViewById(R.id.durationSeek);
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
                relayAnimationSettingValues();
            }
        });
        easing = (Spinner) rootView.findViewById(R.id.easingSpinner);
        final ArrayAdapter<InterpolatorType> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, InterpolatorType.values());
        easing.setAdapter(adapter);
        easing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                relayAnimationSettingValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        final TextView forceValue = (TextView) rootView.findViewById(R.id.forceValue);
        force = (SeekBar) rootView.findViewById(R.id.forceSeek);
        force.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                forceValue.setText(String.format("%2f", i * 1f / seekBar.getMax()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                relayAnimationSettingValues();
            }
        });
        actorForm = (Switch) rootView.findViewById(R.id.actorForm);
        actorForm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                relayActorSettingValues();
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
        relayAnimationSettingValues();
    }

    private void relayAnimationSettingValues() {
        InterpolatorType interpolatorType = (InterpolatorType) easing.getSelectedItem();
        float forceValue = force.getProgress() / force.getMax();
        listener.onAnimationSettingChanged(interpolatorType.generateInterpolator(forceValue), duration.getProgress());
    }

    private void relayActorSettingValues() {
        ActorForm form = (actorForm.isChecked()) ? ActorForm.RECTANGLE : ActorForm.CIRCLE;
        listener.onActorSettingChanged(form);
    }

    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    public interface SettingChangeListener {
        void onAnimationSettingChanged(TimeInterpolator interpolator, long duration);

        void onActorSettingChanged(ActorForm form);
    }
}
