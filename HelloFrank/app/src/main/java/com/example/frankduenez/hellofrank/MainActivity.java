package com.example.frankduenez.hellofrank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TextView) findViewById(R.id.textView)).setTextColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.rootView).setBackgroundColor(getResources().getColor(R.color.purplePink));
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newText = ((EditText) findViewById(R.id.editText)).getText().toString();
                if(TextUtils.isEmpty(newText))
                {
                    ((TextView) findViewById(R.id.textView)).setText("Hello from Frank!");
                }
                else
                {
                    ((TextView) findViewById(R.id.textView)).setText(newText);
                }
            }
        });

        findViewById(R.id.rootView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reset the text color to the original
                ((TextView) findViewById(R.id.textView)).setTextColor(getResources().getColor(R.color.black));
                //reset the text back to the orignal
                ((TextView) findViewById(R.id.textView)).setText("Hello from Frank!");
                //reset the background back to the original
                findViewById(R.id.rootView).setBackgroundColor(getResources().getColor(R.color.orange));

            }
        });
        //grab the text the user inputted

    }

    public native String stringFromJNI();
}
