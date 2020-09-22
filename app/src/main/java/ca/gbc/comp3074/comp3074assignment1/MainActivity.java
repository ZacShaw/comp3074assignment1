package ca.gbc.comp3074.comp3074assignment1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declaring variables for use
    private TextView output1,output2,output3,output4;
    private EditText edit1,edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tying variables to text ids
        output1 = (TextView)findViewById(R.id.textOutput1);
        output2 = (TextView)findViewById(R.id.textOutput2);
        output3 = (TextView)findViewById(R.id.textOutput3);
        output4 = (TextView)findViewById(R.id.textOutput4);
        edit1 = (EditText)findViewById(R.id.editText1);
        edit2 = (EditText)findViewById(R.id.editText2);

        //event listener for button code taken from lab 1 and modified
        findViewById(R.id.calculate_button).setOnClickListener(
                new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        //turning text inputs into strings then doubles
                        String txt1 = edit1.getText().toString();
                        String txt2 = edit2.getText().toString();
                        Double hourly_rate = Double.valueOf(txt1);
                        Double no_of_hours = Double.valueOf(txt2);
                        Double pay;
                        Double overtime;
                        String overtime_txt;
                        //if statement to check whether user has <40 hrs of work
                        if (no_of_hours < 40){
                            pay=no_of_hours*hourly_rate;
                            overtime_txt = "N/A";
                        }
                        else{
                            pay=(no_of_hours-40)*hourly_rate*1.5 + 40*hourly_rate;
                            overtime = (no_of_hours-40)*hourly_rate*1.5;
                            //if we just need to see payment amount without overtime just uncomment the line below
                            //pay-=overtime;
                            overtime_txt = overtime.toString();
                        }
                        //calculates tax then subtracts from total
                        Double tax=pay*0.18;
                        Double total=pay-tax;
                        /*These comments are here in case the other overtime code needs to be uncommented
                        Double tax = (pay+overtime)*0.18;
                        *Double total = pay+overtime-tax;*/
                        String pay_txt = pay.toString();
                        output1.setText("$ " + pay_txt);
                        output2.setText("$ " + overtime_txt);
                        String tax_txt = tax.toString();
                        output3.setText("$ " + tax_txt);
                        String total_txt = total.toString();
                        output4.setText("$ " + total_txt);
                    }
                }
        );
    }

    public void about(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
}