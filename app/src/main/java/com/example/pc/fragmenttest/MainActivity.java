package com.example.pc.fragmenttest;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFragContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragContainer = (FrameLayout)findViewById(R.id.fragment_container);
        Button btnTab1 = (Button)findViewById(R.id.btnTab1);
        Button btnTab2 = (Button)findViewById(R.id.btnTab2);

        btnTab1.setOnClickListener(btnTabClick);
        btnTab2.setOnClickListener(btnTabClick);

        callFragment(1);    //처음에 fragment1이 보이게
    }

    private View.OnClickListener btnTabClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){     //Id로 구분하면됨
                case R.id.btnTab1:
                    callFragment(1);
                    break;

                case R.id.btnTab2:
                    callFragment(2);
                    break;
            }//end swich
        }
    };  //end OnclickListener

    //프래그먼트 표시
    private void callFragment(int fragmentNo){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (fragmentNo){
            case 1:
                Fragment1 fragment1 = new Fragment1();
                transaction.replace(R.id.fragment_container, fragment1);        //fragment가 얹어질 레이아웃, fragment
                transaction.commit();   //commit해줘야 fragment장착됨
                break;
            case 2:
                Fragment2 fragment2 = new Fragment2();
                transaction.replace(R.id.fragment_container, fragment2);
                transaction.commit();
                break;
        }

    }//end callFragment

}
