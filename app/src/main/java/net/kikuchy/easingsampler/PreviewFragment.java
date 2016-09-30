package net.kikuchy.easingsampler;


import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PreviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PreviewFragment extends Fragment {


    public PreviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PreviewFragment.
     */
    public static PreviewFragment newInstance() {
        PreviewFragment fragment = new PreviewFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_preview, container, false);
    }

    public void applySetting(final TimeInterpolator interpolator, final long duration) {
        View actor = getView().findViewById(R.id.actor);
        actor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                view
                        .animate()
                        .alpha(0f)
                        .setInterpolator(interpolator)
                        .setDuration(duration)
                        .setListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                view.animate().setDuration(2000).alpha(1f).start();
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        })
                        .start();
            }
        });
        actor.performClick();
    }
}
