package com.research.sensortest;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener{
	
	//UI
	private TextView acceView0;
	private TextView acceView1;
	private TextView acceView2;
	private TextView gravView0;
	private TextView gravView1;
	private TextView gravView2;
	private TextView gyroView0;
	private TextView gyroView1;
	private TextView gyroView2;
	private TextView liacceView0;
	private TextView liacceView1;
	private TextView liacceView2;
	private TextView rotvecView0;
	private TextView rotvecView1;
	private TextView rotvecView2;
	private TextView rotvecView3;
	private TextView magView0;
	private TextView magView1;
	private TextView magView2;
	private TextView orientView0;
	private TextView orientView1;
	private TextView orientView2;
	
	//Sensor values for display
	private SensorManager mSensorManager0;
	private SensorManager mSensorManager1;
	private SensorManager mSensorManager2;
	private SensorManager mSensorManager3;
	private SensorManager mSensorManager4;
	private SensorManager mSensorManager5;
	private SensorManager mSensorManager6;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//find the views
		acceView0 = (TextView)findViewById(R.id.acce_0);
		acceView1 = (TextView)findViewById(R.id.acce_1);
		acceView2 = (TextView)findViewById(R.id.acce_2);
		gravView0 = (TextView)findViewById(R.id.gravity_0);
		gravView1 = (TextView)findViewById(R.id.gravity_1);
		gravView2 = (TextView)findViewById(R.id.gravity_2);
		gyroView0 = (TextView)findViewById(R.id.gyro_0);
		gyroView1 = (TextView)findViewById(R.id.gyro_1);
		gyroView2 = (TextView)findViewById(R.id.gyro_2);
		liacceView0 = (TextView)findViewById(R.id.linear_acce_0);
		liacceView1 = (TextView)findViewById(R.id.linear_acce_1);
		liacceView2 = (TextView)findViewById(R.id.linear_acce_2);
		rotvecView0 = (TextView)findViewById(R.id.rot_vec_0);
		rotvecView1 = (TextView)findViewById(R.id.rot_vec_1);
		rotvecView2 = (TextView)findViewById(R.id.rot_vec_2);
		rotvecView3 = (TextView)findViewById(R.id.rot_vec_3);
		magView0 = (TextView)findViewById(R.id.mag_0);
		magView1 = (TextView)findViewById(R.id.mag_1);
		magView2 = (TextView)findViewById(R.id.mag_2);
		orientView0 = (TextView)findViewById(R.id.orient_0);
		orientView1 = (TextView)findViewById(R.id.orient_1);
		orientView2 = (TextView)findViewById(R.id.orient_2);
		
		//init sensormanager
		mSensorManager0 = (SensorManager) getSystemService(SENSOR_SERVICE);
		mSensorManager1 = (SensorManager) getSystemService(SENSOR_SERVICE);
		mSensorManager2 = (SensorManager) getSystemService(SENSOR_SERVICE);
		mSensorManager3 = (SensorManager) getSystemService(SENSOR_SERVICE);
		mSensorManager4 = (SensorManager) getSystemService(SENSOR_SERVICE);
		mSensorManager5 = (SensorManager) getSystemService(SENSOR_SERVICE);
		mSensorManager6 = (SensorManager) getSystemService(SENSOR_SERVICE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	  @SuppressWarnings("deprecation")
	@Override
	  protected void onResume() {
	    super.onResume();
	    // register this class as a listener for the orientation and
	    // accelerometer sensors
	    mSensorManager0.registerListener(this,
		        mSensorManager0.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
		        SensorManager.SENSOR_DELAY_NORMAL);
	    mSensorManager1.registerListener(this,
	        mSensorManager1.getDefaultSensor(Sensor.TYPE_GRAVITY),
	        SensorManager.SENSOR_DELAY_NORMAL);
	    mSensorManager2.registerListener(this,
		        mSensorManager2.getDefaultSensor(Sensor.TYPE_GYROSCOPE),
		        SensorManager.SENSOR_DELAY_NORMAL);
	    mSensorManager3.registerListener(this,
		        mSensorManager3.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),
		        SensorManager.SENSOR_DELAY_NORMAL);
	    mSensorManager4.registerListener(this,
		        mSensorManager4.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR),
		        SensorManager.SENSOR_DELAY_NORMAL);
	    mSensorManager5.registerListener(this,
		        mSensorManager5.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
		        SensorManager.SENSOR_DELAY_NORMAL);
	    mSensorManager6.registerListener(this,
		        mSensorManager6.getDefaultSensor(Sensor.TYPE_ORIENTATION),
		        SensorManager.SENSOR_DELAY_NORMAL);
	  }

	  @Override
	  protected void onPause() {
	    // unregister listener
	    super.onPause();
	    mSensorManager0.unregisterListener(this);
	    mSensorManager1.unregisterListener(this);
	    mSensorManager2.unregisterListener(this);
	    mSensorManager3.unregisterListener(this);
	    mSensorManager4.unregisterListener(this);
	    mSensorManager5.unregisterListener(this);
	    mSensorManager6.unregisterListener(this);
	  }

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		switch (event.sensor.getType()){
			case Sensor.TYPE_ACCELEROMETER:
				getAcceleration(event);
				break;
			case Sensor.TYPE_GRAVITY:
				getGravity(event);
				break;
			case Sensor.TYPE_GYROSCOPE:
				getGyro(event);
				break;
			case Sensor.TYPE_LINEAR_ACCELERATION:
				getLinearAcce(event);
				break;
			case Sensor.TYPE_ROTATION_VECTOR:
				getRotVect(event);
				break;
			case Sensor.TYPE_MAGNETIC_FIELD:
				getMagnetic(event);
				break;
			case Sensor.TYPE_ORIENTATION:	
				getOrient(event);
				break;
			default:
				//do nothing
		}
		
	}
	
	//acceleration
	private void getAcceleration(SensorEvent event){
		acceView0.setText(String.valueOf(event.values[0]));
		acceView1.setText(String.valueOf(event.values[1]));
		acceView2.setText(String.valueOf(event.values[2]));
		
	}
	//gravity
	private void getGravity(SensorEvent event){
		gravView0.setText(String.valueOf(event.values[0]));
		gravView1.setText(String.valueOf(event.values[1]));
		gravView2.setText(String.valueOf(event.values[2]));
		
	}
	//gyro
	private void getGyro(SensorEvent event){
		gyroView0.setText(String.valueOf(event.values[0]));
		gyroView1.setText(String.valueOf(event.values[1]));
		gyroView2.setText(String.valueOf(event.values[2]));
	}
	//lieaner acce
	private void getLinearAcce(SensorEvent event){
		liacceView0.setText(String.valueOf(event.values[0]));
		liacceView1.setText(String.valueOf(event.values[1]));
		liacceView2.setText(String.valueOf(event.values[2]));
	}
	//rot vector
	private void getRotVect(SensorEvent event){
		rotvecView0.setText(String.valueOf(event.values[0]));
		rotvecView1.setText(String.valueOf(event.values[1]));
		rotvecView2.setText(String.valueOf(event.values[2]));
		//TODO:debug why there is no value[3]
		//rotvecView3.setText(String.valueOf(event.values[3]));
	}
	//rot vector
	private void getMagnetic(SensorEvent event){
		magView0.setText(String.valueOf(event.values[0]));
		magView1.setText(String.valueOf(event.values[1]));
		magView2.setText(String.valueOf(event.values[2]));
	}
	//rot vector
	private void getOrient(SensorEvent event){
		orientView0.setText(String.valueOf(event.values[0]));
		orientView1.setText(String.valueOf(event.values[1]));
		orientView2.setText(String.valueOf(event.values[2]));
	}
	
	

}
