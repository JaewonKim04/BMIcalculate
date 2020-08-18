package com.example.bmitester;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class ResertActivity extends AppCompatActivity {



    ImageView fact;
    TextView repeat;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
    super.onCreate(savedInstanceState);
        setContentView(R.layout.finalview_sub);
        Button restart=(Button)findViewById(R.id.restart);
        fact=(ImageView)findViewById(R.id.fact);
        repeat=(TextView)findViewById(R.id.Repeat);
        fact.setImageResource(R.drawable.loading);
        float wegcheck=MainActivity.weg_num;                           //계산을 위해 몸무게를 저장
        float hegcheck=MainActivity.heg_num/100;                      //계산을 위해 키를 저장(키를 cm로 입력받았기 때문에 m로 바꾸기위해서 100으로 나눠줌)
        float check=wegcheck/(hegcheck*hegcheck);                    //bmi결과(BMI=Weight/(Height*Height))를 저장해둠
        if(MainActivity.RadioCheck==1)                 //남자면
        {
            if(check<20)                             //20이하면 저체중
            {
            fact.setImageResource(R.drawable.mylch);
            repeat.setText("살좀쪄라멸치야" +
                    "(bmi수치:"+check+")");
            }
            else if(check>=20&&check<25)
            {
                fact.setImageResource(R.drawable.eegn);//20이상25미만은 정상
                repeat.setText("딱좋습니다훈련생!!" +
                        "(bmi수치:"+check+")");
            }
            else if(check>=25)
            {
                fact.setImageResource(R.drawable.pig);//25이상은 과체중
                repeat.setText("살좀빼라돼지야" +
                        "(bmi수치:"+check+")");
            }
        }
        else if(MainActivity.RadioCheck==2)//여자면
        {
            if(check<18.5)                                     //18.5미만이면 저체중
            {
                fact.setImageResource(R.drawable.mylch);
                repeat.setText("살좀 찌워야겠다^^" +
                        "(bmi수치:"+check+")");
            }
            else if(check>=18.5&&check<25)                    //18.5이상,25미만은 정상
            {
                fact.setImageResource(R.drawable.images);
                repeat.setText("어머 딱좋다" +
                        "(bmi수치:"+check+")");
            }
            else if(check>=25)                                //25이상은 과체중
            {
                fact.setImageResource(R.drawable.pig);
                repeat.setText("살을빼보는게 어떻겠니?^^" +
                        "(bmi수치:"+check+")");
            }
        }

        restart.setOnClickListener(new Button.OnClickListener() //재시작 버튼을 누르면
        {
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            @Override
            public void onClick(View view)
            {
                fact.setImageResource(R.drawable.loading);//로딩중 사진으로 바뀌고
                MainActivity.RadioCheck=0;               //남여 변수는 다시 0으로 바꾸고
                repeat.setText("로딩중");                //로딩중 표시
                startActivity(intent);                   //매인액티비티를 시작한다

            }
        });


    }
}
