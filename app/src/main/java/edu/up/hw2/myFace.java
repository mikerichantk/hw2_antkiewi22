/*
@author: Mikey Antkiewicz
 */
package edu.up.hw2;

import android.view.SurfaceView;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import java.util.Random;

public class myFace extends SurfaceView {
    protected int skinColor = 0;
    protected int eyeColor = 0;
    protected int hairColor = 0;
    protected int hairSytle;
    protected Paint paint = new Paint();

    public void setSkinColor(int red, int green, int blue){
        skinColor = Color.rgb(red, green, blue);
    }
    public void setEyeColor(int red, int green, int blue) {
        eyeColor = Color.rgb(red, green, blue);
    }

    public void setHairColor(int red, int green, int blue) {
        hairColor = Color.rgb(red, green, blue);
    }

    // constructor
    public myFace(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);
        randomize();
    }

    public void randomize(){
        Random rand = new Random();
        skinColor = Color.rgb(rand.nextInt(256),rand.nextInt(256), rand.nextInt(256));
        eyeColor = Color.rgb(rand.nextInt(256),rand.nextInt(256), rand.nextInt(256));
        hairColor = Color.rgb(rand.nextInt(256),rand.nextInt(256), rand.nextInt(256));
        hairSytle = rand.nextInt(3);

    }
    public void drawMouth(Canvas canvas){
        // mouth
        paint.setColor(Color.RED);
        canvas.drawCircle(900, 795,85, paint);
        paint.setColor(skinColor);
        canvas.drawCircle(875, 745,85, paint);
    }
    public void drawEyes(Canvas canvas){
        // eyes
        paint.setColor(Color.WHITE);
        canvas.drawCircle(850, 610,50, paint);
        canvas.drawCircle(975, 610,50, paint);
        // iris
        paint.setColor(eyeColor);
        canvas.drawCircle(860, 620,30, paint);
        canvas.drawCircle(985, 620,30, paint);
        // pupil
        paint.setColor(Color.BLACK);
        canvas.drawCircle(870, 630,10, paint);
        canvas.drawCircle(995, 630,10, paint);
    }
    public void drawFace(Canvas canvas){
        // face
        paint.setColor(skinColor);
        canvas.drawCircle(900,700, 250, paint);
    }
    public void drawHair(Canvas canvas){
        // set color accordingly
        paint.setColor(hairColor);
        // three hair styles which are either one two or three rectangles
        if(hairSytle == 0){
            canvas.drawRect(850, 500, 950, 520, paint);
        }
        else if(hairSytle == 1){
            canvas.drawRect(850, 500, 950, 520, paint);
            canvas.drawRect(860, 490, 940, 520, paint);
        }
        else{
            canvas.drawRect(850, 500, 950, 520, paint);
            canvas.drawRect(860, 490, 940, 520, paint);
            canvas.drawRect(870, 480, 930, 520, paint);
        }
    }
    // on draw method
    public void onDraw(Canvas canvas){
        // call draw face method
        drawFace(canvas);
        // call draw eyes method
        drawEyes(canvas);
        // call draw mouth method
        drawMouth(canvas);
        // call draw hair method
        drawHair(canvas);

    }

}
