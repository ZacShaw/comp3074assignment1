package ca.gbc.comp3074.comp3074assignment1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView output1,output2,output3,output4;
    private EditText edit1,edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output1 = (TextView)findViewById(R.id.textOutput);
        edit1 = (EditText)findViewById(R.id.editText1);
        edit2 = (EditText)findViewById(R.id.editText2);

        findViewById(R.id.calculate_button).setOnClickListener(
                new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        String txt1 = edit1.getText().toString();
                        String txt2 = edit2.getText().toString();
                        Double hourly_rate = Double.valueOf(txt1);
                        Double no_of_hours = Double.valueOf(txt2);
                        Double pay;
                        Double overtime;
                        if (no_of_hours < 40){
                            pay=no_of_hours*hourly_rate;
                            overtime = 0.00;
                        }
                        else{
                            pay=(no_of_hours-40)*hourly_rate*1.5 + 40*hourly_rate;
                            overtime = (no_of_hours-40)*hourly_rate*1.5;
                        }
                        Double tax=pay*0.18;
                        Double total=pay-tax;
                        String pay_txt = pay.toString();
                        output1.setText(pay_txt);
                    }
                }
        );
    }

    public void about(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
}