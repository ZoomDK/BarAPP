package user.nicolai.barapp;

import static user.nicolai.barapp.FirstFragment.myThreadConnected;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.VideoView;


import user.nicolai.barapp.databinding.FragmentBoozeBinding;


public class Booze extends Fragment {

    public void startLoading() {
        binding.videoView.setVisibility(View.VISIBLE);
        binding.underLayout.setVisibility(View.GONE);
        binding.overLayout.setBackgroundColor(Color.BLACK);
        binding.videoView.start();
    }

    public static void stopLoading2() {
        binding.videoView.setVisibility(View.GONE);
        binding.underLayout.setVisibility(View.VISIBLE);
        binding.overLayout.setBackgroundColor(Color.alpha(181111));
    }
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    )
    {
        binding = FragmentBoozeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    private static FragmentBoozeBinding binding;

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        VideoView simpleVideoView = binding.videoView;
        simpleVideoView.setVideoURI(Uri.parse("android.resource://" + BuildConfig.APPLICATION_ID + "/" + R.raw.loading));

        simpleVideoView.start();
        binding.videoView.setVisibility(View.GONE);
        this.binding.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                simpleVideoView.start();
            }
        });
        binding.seekBar2.setMax(200);
        binding.seekBar3.setMax(200);
        binding.seekBar4.setMax(200);
        binding.seekBar5.setMax(200);
        binding.seekBar6.setMax(200);


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startLoading();
                int start = 2;
                int progress1 = binding.seekBar2.getProgress();
                int progress2 = binding.seekBar3.getProgress();
                int progress3 = binding.seekBar4.getProgress();
                int progress4 = binding.seekBar5.getProgress();
                int progress5 = binding.seekBar6.getProgress();
                myThreadConnected.write((start+":"+progress1+":"+progress2+":"+progress3+":"+progress4+":"+progress5+":").getBytes());
            }
        });
        binding.imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Booze.this)
                        .navigate(R.id.action_Booze_to_blankFragment);
            }
        });
        binding.seekBar2.setMax(200);
        binding.seekBar3.setMax(200);
        binding.seekBar4.setMax(200);
        binding.seekBar5.setMax(200);
        binding.seekBar6.setMax(200);
        binding.seekBar6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int before;
            int after = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.textView2.setText(String.valueOf(seekBar.getProgress() + " ml"));
                before = seekBar.getProgress();
                if (canTurn() > 200) {
                    seekBar.setProgress(after);
                }
                after = seekBar.getProgress();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                before = seekBar.getProgress();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        binding.seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int before;
            int after = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.textView3.setText(String.valueOf(seekBar.getProgress()+ " ml"));
                before = seekBar.getProgress();
                if (canTurn() > 200) {
                    seekBar.setProgress(after);
                }
                after = seekBar.getProgress();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        binding.seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int before;
            int after = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.textView4.setText(String.valueOf(seekBar.getProgress()+ " ml"));
                before = seekBar.getProgress();
                if (canTurn() > 200) {
                    seekBar.setProgress(after);
                }
                after = seekBar.getProgress();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        binding.seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int before;
            int after = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.textView5.setText(String.valueOf(seekBar.getProgress()+ " ml"));
                before = seekBar.getProgress();
                if (canTurn() > 200) {
                    seekBar.setProgress(after);
                }
                after = seekBar.getProgress();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        binding.seekBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int before;
            int after = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.textView6.setText(String.valueOf(seekBar.getProgress()+ " ml"));
                before = seekBar.getProgress();
                if (canTurn() > 200) {
                    seekBar.setProgress(after);
                }
                after = seekBar.getProgress();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
    }
    public int canTurn() {
        return binding.seekBar2.getProgress() + binding.seekBar3.getProgress() + binding.seekBar4.getProgress() + binding.seekBar5.getProgress() + binding.seekBar6.getProgress();
    }




}