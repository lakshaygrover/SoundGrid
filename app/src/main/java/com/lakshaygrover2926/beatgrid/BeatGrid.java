package com.lakshaygrover2926.beatgrid;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by LAKSHAY on 1/10/2017.
 */
public class BeatGrid {

    private static final String TAG = "BeatGrid";
    private static final String SOUNDS_FOLDER = "sample_sounds";
    private static final int MAX_SOUNDS = 5;
    private SoundPool mSoundPool;


    private List<Sound> mSounds = new ArrayList<>();
    private AssetManager mAssets;

    public BeatGrid(Context context){
        mAssets = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
        loadsounds();
    }
    public void play(Sound sound){
        Integer soundId = sound.getSoundId();
        if(soundId == null){
            return;
        }
        mSoundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    private void loadsounds(){
        String[] soundNames;
        try {
            soundNames = mAssets.list(SOUNDS_FOLDER);
            Log.i(TAG, "Found "+soundNames.length+" sounds");
        }catch (IOException ioe){
             Log.e(TAG, "Could not find", ioe);
            return;
        }

        for(String filemane : soundNames){
            try {
                String assetPath = SOUNDS_FOLDER + "/" + filemane;
                Sound sound = new Sound(assetPath);
                load(sound);
                mSounds.add(sound);
            } catch (IOException ioe){
                Log.e(TAG, "Could nit load "+ filemane, ioe);
            }
        }
    }

    private void load(Sound sound) throws IOException{
        AssetFileDescriptor assetFileDescriptor = mAssets.openFd(sound.getAssetPath());
        int soundId = mSoundPool.load(assetFileDescriptor, 1);
        sound.setSoundId(soundId);
    }

    public List<Sound> getSounds(){
        return mSounds;
    }

    public void release(){
        mSoundPool.release();
    }
}
