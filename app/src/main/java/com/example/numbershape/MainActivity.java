package com.example.numbershape;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    class Number {
        int number;
        public boolean isTriangular() {
            int sum=1;
            int triangularNum = 1;
            while(triangularNum < number) {
                triangularNum++;
                triangularNum+=sum;
            }
            if(triangularNum==number) {return true;}
            else {return false;}
        }
        public boolean isSquare() {
            double square = Math.sqrt(number);
            if(square==Math.floor(square)) {return true;}
            else {return false;}
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testNumber(View view) {
        EditText editText = findViewById(R.id.et_num);

        if(editText.getText().toString().isEmpty()) {
            Toast.makeText(this,"Please enter the number",Toast.LENGTH_SHORT).show();
        }
        else {
            Number num = new Number();
            num.number = Integer.parseInt(editText.getText().toString());
            String message = editText.getText().toString();
            if(num.isTriangular()&&num.isSquare()){
                message+=" is square and triangular";
            }else if(num.isSquare()) {
                message+=" is a Square Number but not triangular";
            }else {
                message+=" is triangular but not square";
            }

            Toast.makeText(this,message,Toast.LENGTH_LONG).show();

        }
    }
}