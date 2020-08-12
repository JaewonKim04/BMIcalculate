package com.example.bmitester;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioButton;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static float weg_num;//몸무게를 받는 변수
    static float heg_num;//키를 받는 변수
    static int RadioCheck=0;//성별을 받아두는 변수
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button cheack=(Button)findViewById(R.id.check);                       //체크를 시작하는 버튼
        final EditText weg=(EditText)findViewById(R.id.weg);                 //몸무게를 받는 EditText
        final EditText heg=(EditText)findViewById(R.id.heg);                //키를 받는 EditText
        RadioGroup Gender =(RadioGroup)findViewById(R.id.gender);          //성별을 받는 RadioGroup



        RadioGroup.OnCheckedChangeListener radiocheck=new RadioGroup.OnCheckedChangeListener(){   //성별 체크 시작
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,@IdRes int i)
            {
                if(i== R.id.man)                                        //남자면
                {
                    RadioCheck=1;                                       //번수를 1로 변경
                }
                else if(i==R.id.woman)                                  //여자면
                {
                    RadioCheck=2;                                       //변수를 2로 변경
                }
                                                    //둘다 아니면 변수는 0으로 유지
            }
        };
        Gender.setOnCheckedChangeListener(radiocheck);
        Button.OnClickListener onClickListener = new Button.OnClickListener() //체크 시작버튼을 누르면
        {
            @Override
            public void onClick(View v) {

                String getweg=weg.getText().toString();                                    //EditText에 있는 몸무게 저장
                String getheg=heg.getText().toString();                                   //EditText에 있는 키 저장
                if(getweg.getBytes().length>0&&getheg.getBytes().length>0&&RadioCheck>0) //저장한몸무게의 글자길이가 0초과,저장한 키의 글자길이가 0초과,성별변수가 0이 아니면
                {

                    weg_num=Float.parseFloat(weg.getText().toString());                           //실수변수에 몸무게 저장
                    heg_num=Float.parseFloat(heg.getText().toString());                          //실수변수에 키 저장
                    Intent intent = new Intent(getApplicationContext(),ResertActivity.class);   //
                    startActivity(intent);                                                     //결과엑티비티 시작
                }
                else if(TextUtils.isEmpty(heg.getText())) //그렇지않고 키가 비어있으면
                {
                    Toast fail=Toast.makeText(getApplicationContext(),"키를 입력하세요",Toast.LENGTH_SHORT); fail.show();
                }
                else if(TextUtils.isEmpty(weg.getText()))//그렇지않고 몸무게가 비어있으면
                {
                    Toast fail=Toast.makeText(getApplicationContext(),"무게를 입력하세요",Toast.LENGTH_SHORT); fail.show();
                }
                else
                {
                    Toast fall=Toast.makeText(getApplicationContext(), "성별을 입력하세요", Toast.LENGTH_SHORT);fall.show();
                }


            }
        };
        cheack.setOnClickListener(onClickListener);





    }

}