/*
@author: Mikey Antkiewicz
 */
package edu.up.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init myFace
        myFace face = (myFace) findViewById(R.id.myFace);
        // make a myFaceController linking to the surface view
        myFaceController controller = new myFaceController(face);
        // init seekbars, set max value to 255, set listener
        SeekBar rSeekBar = (SeekBar) findViewById(R.id.seekBarRed);
        rSeekBar.setMax(255);
        rSeekBar.setOnSeekBarChangeListener(controller);
        SeekBar gSeekBar = (SeekBar) findViewById(R.id.seekBarGreen);
        gSeekBar.setMax(255);
        gSeekBar.setOnSeekBarChangeListener(controller);
        SeekBar bSeekBar = (SeekBar) findViewById(R.id.seekBarBlue);
        bSeekBar.setMax(255);
        bSeekBar.setOnSeekBarChangeListener(controller);
        // init spinner
        Spinner hairSpinner = (Spinner) findViewById(R.id.spinnerHair);
        // init radio buttons
        RadioButton hairButton = (RadioButton) findViewById(R.id.radioButtonHair);
        RadioButton eyeButton = (RadioButton) findViewById(R.id.radioButtonEyes);
        RadioButton skinButton = (RadioButton) findViewById(R.id.radioButtonSkin);
        // init random button
        Button randButton = (Button) findViewById(R.id.buttonRandom);
    }
}
