package com.codeblast.uithread;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;

public class MainActivity extends ActionBarActivity implements SensorEventListener, OnClickListener {

    private static final String TAG = MainActivity.class.getName();

    private static final String FILENAME = "myFile.txt"; //file where data is written

    Button button1;

    Button button2;

    Sensor accelerometer;

    //layout variables
    TableLayout t1;

    TextView dataReading; //declare data text object

    Integer count = 0;

    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize sensor manager
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //initialize accelerometer
        accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //mSensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_FASTEST);

        t1 = (TableLayout) findViewById(R.id.main_table);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    /**
     * onResume() registers the accelerometer for listening
     * to the events
     */
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_FASTEST);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void onSensorChanged(SensorEvent event) {
        //if sensor status result is unreliable return
        if (event.accuracy == SensorManager.SENSOR_STATUS_UNRELIABLE) {
            return;
        }

        Sensor sensor = event.sensor;

        //check sensor type
        if (sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            //assign directions
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            try {
                //write to text file the x, y, and z values each type a sensor detects change
                writeToFile(Float.toString(x), Float.toString(y), Float.toString(z));
                //return string of text file
                String textFromFileString = readFromFile();
                TableRow tr = new TableRow(this);
                if (count % 2 != 0) {
                    tr.setBackgroundColor(Color.GRAY);
                }
                tr.setId(100 + count);
                tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));

                //show data read from file
                dataReading = new TextView(this);
                dataReading.setId(200 + count);
                dataReading.setText(textFromFileString);
                dataReading.setPadding(2, 0, 5, 0);
                dataReading.setTextColor(Color.WHITE);
                tr.addView(dataReading);
                //finally add data to table row
                t1.addView(tr, new TableLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
                        ActionBar.LayoutParams.WRAP_CONTENT));
                count++;
                Log.i("LIMA", "Add row. There are now " + t1.getChildCount() + "rows");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                mSensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_FASTEST);
                break;
            case R.id.button2:
                mSensorManager.unregisterListener(this);
        }
    }

    /**
     * writeToFile: writes data recordings of accelerometer to text file
     */
    void writeToFile(String x, String y, String z) throws IOException {
        //get exact instance of time in which call to write is being made
        Calendar c = Calendar.getInstance();
        //create string to print to text using values in parameter
        String s = c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + ":" + c
                .get(Calendar.MILLISECOND) + " - " + "x: " + x + " y: " + y + " z: " + z + "\n";
        try {
            //append new string to file
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    openFileOutput(FILENAME, Context.MODE_PRIVATE));
            BufferedWriter bw = new BufferedWriter(outputStreamWriter);
            bw.write(s);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            Log.e(TAG, "File write failed: " + e.toString());
        }
    }

    private String readFromFile() {
        String ret = "";
        try {
            //open text file to read from
            InputStream inputStream = openFileInput(FILENAME);
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    //continue appending to stringBuilder until you've reached the end of file
                    stringBuilder.append(receiveString);
                }
                inputStream.close();
                ret = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            Log.e(TAG, "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e(TAG, "Can not read file: " + e.toString());
        }
        return ret;
    }
}
