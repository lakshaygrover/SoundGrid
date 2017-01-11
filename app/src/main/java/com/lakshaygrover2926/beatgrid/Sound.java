package com.lakshaygrover2926.beatgrid;

/**
 * Created by LAKSHAY on 1/10/2017.
 */
public class Sound {

    private String mAssetPath;
    private String mName;
    private Integer mSoundId;
    public Sound(String assetpath){
        mAssetPath = assetpath;
        String[] components = assetpath.split("/");
        String filename = components[components.length-1];
        mName = filename.replace(".wav", "");

    }

    public String getAssetPath(){
        return mAssetPath;
    }

    public String getName(){
        return mName;
    }

    public Integer getSoundId(){
        return mSoundId;
    }

    public void setSoundId(Integer e){
        mSoundId = e;
    }
}
