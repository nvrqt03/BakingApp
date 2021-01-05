package ajmitchell.android.bakingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import ajmitchell.android.bakingapp.databinding.ActivityMainBinding;
import ajmitchell.android.bakingapp.network.BakingApi;

public class MainActivity extends AppCompatActivity  {

    ActivityMainBinding mBinding;
    public static final String TAG = "MainActivity.class";
    BakingApi bakingApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.main_container, MainFragment.class, null)
                    .commit();
        }

    }


}