package com.example.pythonintegrator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO:
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
            Log.d("Debug","Python Started");
        }

        Python py = Python.getInstance();
        PyObject pyobj = py.getModule("script");

        PyObject result = pyobj.callAttr("main", "5", "10");
        Log.d("Debug", result.toString());
    }
}