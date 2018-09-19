package myapp.bmp.com.dbapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import myapp.bmp.com.dbapp.Fragment.FragmentLogin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_main);
        if(s==null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentMain,new FragmentLogin())
                    .commit();
        }
    }
}
