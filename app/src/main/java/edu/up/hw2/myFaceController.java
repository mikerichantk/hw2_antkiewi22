/*
@author: Mikey Antkiewicz
 */

package edu.up.hw2;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class myFaceController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, Spinner.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {
    myFace controllerFace;
    int red;
    int green;
    int blue;
    int currentRadioButton;
    int checkedB;

    // constructor
    public myFaceController(myFace initFace){
        controllerFace = initFace;
    }
    // onClick method
    @Override
    public void onClick(View view) {
        // call randomize and then invalidate
        controllerFace.randomize();
        controllerFace.invalidate();

    }
    // onProgressChanged method
    @Override
    public void onProgressChanged(SeekBar seek, int progress, boolean user) {
        int ID = seek.getId();
        // decipher which seekbar is being changed
        if(ID == R.id.seekBarRed){
            red = seek.getProgress();
        }
        else if(ID == R.id.seekBarGreen){
            green = seek.getProgress();
        }
        else if(ID == R.id.seekBarBlue){
            blue = seek.getProgress();
        }
        // could not get the radio buttons to work
        if(currentRadioButton == checkedB){
            controllerFace.setHairColor(red, green, blue);
        }
        else if(currentRadioButton == (checkedB+1)){
            controllerFace.setEyeColor(red, green, blue);
        }
        else if(currentRadioButton == (checkedB+2)){
            controllerFace.setSkinColor(red, green, blue);
        }
        // after not being able to get the radio buttons to work,
        // I decided to make the input of the hair, eyes, and skin
        // different to show that I was able to set and change the colors
        // for each part
        controllerFace.setEyeColor(green, red, blue);
        controllerFace.setSkinColor(red, green, blue);
        controllerFace.setHairColor(blue, red, green);
        controllerFace.invalidate();

    }
    // onStartTrackingTouch method
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    // onStopTrackingTouch method
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
    // onItemSelected method
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }
    // onNothingSelected method
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    // onCheckedChanged method
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checked) {
        // could not get the radio buttons to work
        // tried to set the currentRadioButton variable to correspond with the checked parameter
        checkedB = checked;
        if(checked == R.id.radioButtonEyes){
            currentRadioButton = checkedB;
        }
        else if(checked == R.id.radioButtonHair){
            currentRadioButton = checkedB + 1;
        }
        else if(checked == R.id.radioButtonSkin){
            currentRadioButton = checkedB + 2;
        }
        controllerFace.invalidate();
    }
}
/*
 External Citation
 Date:     30 September 2019
 Problem:  Could not understand how to differentiate the seek bars
 Resource:
https://stackoverflow.com/questions/8719632/multiple-seekbars-listener
 Solution: compare seekbar.getId() with R.id.seekBar
 */
/*
 External Citation
 Date:     30 September 2019
 Problem:  Could not understand how to differentiate the radio buttons
 Resource:
https://stackoverflow.com/questions/24992936/how-to-check-if-a-radiobutton-is-checked-in-a-radiogroup-in-android
 Solution: still could not figure it out but tried to mimic what I found on stack
 */