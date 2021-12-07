package com.thenewboston.a06_gestures;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {


    private TextView vensMessage;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button vensButton = (Button) findViewById(R.id.vensButton);
        vensButton.setOnClickListener(
                v -> {
                    @SuppressLint("CutPasteId") TextView vensText = (TextView) findViewById(R.id.vensMessage);
                    vensText.setText("Good job!");
                }
        );


        vensButton.setOnLongClickListener(
                v -> {
                    TextView vensText = (TextView) findViewById(R.id.vensMessage);
                    vensText.setText("Wrong Step");
                    return true;
                }
        );

        vensMessage = (TextView) findViewById(R.id.vensMessage);
        this.gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        vensMessage.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        vensMessage.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        vensMessage.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        vensMessage.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        vensMessage.setText("onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        vensMessage.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        vensMessage.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        vensMessage.setText("onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        vensMessage.setText("onFling");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}