package com.lakshaygrover2926.beatgrid;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BeatgridActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return BeatGridFragment.newInstance();
    }
}
