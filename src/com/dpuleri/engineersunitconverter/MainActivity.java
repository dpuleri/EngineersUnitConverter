package com.dpuleri.engineersunitconverter;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import java.lang.*;

public class MainActivity extends Activity {

	private double lengthEdit1; //init length vars
	private double lengthEdit2;
	private double lengthConversion = 39.3701;
	private boolean shutUpLength = true;
	
	private double volumeEdit1; //init volume vars
	private double volumeEdit2;
	private double volumeConversion = 39.3701;
	private boolean shutUpVolume = true;
	
	private double pressureEdit1; //init pressure vars
	private double pressureEdit2;
	private double pressureConversion = 39.3701;
	private boolean shutUpPressure = true;
	
	
	EditText lengthET1; //init length editables
	EditText lengthET2;
	Spinner lengthUnitSpinner;
	
	EditText volumeET1; //init volume editables
	EditText volumeET2;
	Spinner volumeUnitSpinner;
	
	EditText pressureET1; //init pressure editables
	EditText pressureET2;
	Spinner pressureUnitSpinner;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if(savedInstanceState == null){
			
			// Just started
			
			lengthEdit1 = 0.0; //length
			lengthEdit2 = 0.0; 
		    lengthConversion = 0.0;
		    
		    
		    volumeEdit1 = 0.0; //volume
			volumeEdit2 = 0.0; 
		    volumeConversion = 0.0;
		    
		    pressureEdit1 = 0.0; //pressure
			pressureEdit2 = 0.0; 
		    pressureConversion = 0.0;
			
		} else {
			
			// App is being restored
			lengthEdit1 = 0.0; //length
			lengthEdit2 = 0.0; 
		    lengthConversion = 0.0;
		    
		    
		    volumeEdit1 = 0.0; //volume
			volumeEdit2 = 0.0; 
		    volumeConversion = 0.0;
		    
		    pressureEdit1 = 0.0; //pressure
			pressureEdit2 = 0.0; 
		    pressureConversion = 0.0;
		}
					
		//Getting the values from the fields--LENGTH
		lengthET1 = (EditText) findViewById(R.id.editLength1);
		lengthET2 = (EditText) findViewById(R.id.editLength2);
		
		lengthUnitSpinner = (Spinner) findViewById(R.id.lengthUnit);
		lengthUnitSpinner.setPrompt("Units");
		addItemSelectedListenerToSpinnerLength();
				
		//Setting listeners
		lengthET1.addTextChangedListener(lengthEdit1ChangListener);
		lengthET2.addTextChangedListener(lengthEdit2ChangListener);
		
		
		//Getting the values from the fields--VOLUME
		volumeET1 = (EditText) findViewById(R.id.editVolume1);
		volumeET2 = (EditText) findViewById(R.id.editVolume2);
				
		volumeUnitSpinner = (Spinner) findViewById(R.id.volumeUnit);
		volumeUnitSpinner.setPrompt("Units");
		addItemSelectedListenerToSpinnerVolume();
						
		//Setting listeners
		volumeET1.addTextChangedListener(volumeEdit1ChangListener);
		volumeET2.addTextChangedListener(volumeEdit2ChangListener);
		
		
		//Getting the values from the fields--PRESSURE
		pressureET1 = (EditText) findViewById(R.id.editPressure1);
		pressureET2 = (EditText) findViewById(R.id.editPressure2);
						
		pressureUnitSpinner = (Spinner) findViewById(R.id.pressureUnit);
		pressureUnitSpinner.setPrompt("Units");
		addItemSelectedListenerToSpinnerPressure();
								
		//Setting listeners
		pressureET1.addTextChangedListener(pressureEdit1ChangListener);
		pressureET2.addTextChangedListener(pressureEdit2ChangListener);
				
				
	}
	
	
	// BEGIN LENGTH STUFF
	private void addItemSelectedListenerToSpinnerLength() {
		// TODO Auto-generated method stub
		lengthUnitSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				//String value = lengthUnitSpinner.getSelectedItem().toString();
			/*	lengthConversion = (lengthUnitSpinner.getSelectedItem().toString().equals("meters-in"))?39.3701:0;
				Log.d("lengthConversion", "Value: " + lengthUnitSpinner.getSelectedItem().toString());
				lengthConversion = (String.valueOf(lengthUnitSpinner.getSelectedItem()).equals("feet-mile"))?0.000189394:0;
				lengthConversion = (String.valueOf(lengthUnitSpinner.getSelectedItem()).equals("in-feet"))?0.0833333:0;
				lengthConversion = (String.valueOf(lengthUnitSpinner.getSelectedItem()).equals("mile-kilometer"))?1.60934:0;*/
				String value = lengthUnitSpinner.getSelectedItem().toString();
				Log.d("value", "Value: " + value);
				if (value.equals("feet-mile")) {
					lengthConversion = 0.000189394;
				}
				else if (value.equals("in-feet")) {
					lengthConversion = 0.0833333;
				}
				else if (value.equals("mile-kilometer")) {
					lengthConversion = 1.60934;
				}
				else if (value.equals("meters-in")) {
					lengthConversion = 39.3701;
				}
				updateLength(0);
				Log.d("value", "lengthConversion: " + lengthConversion);

			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private TextWatcher lengthEdit1ChangListener = new TextWatcher() {

		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			try {
				//addItemSelectedListenerToSpinner();
				if (shutUpLength) {
					lengthEdit1 = Double.parseDouble(s.toString());
					Log.d("value", "lengthEdit1 first: " + lengthEdit1);
					updateLength(2);
					
				}
			}
			catch (NumberFormatException e) {
				/*lengthEdit1 = 0.0;*/
			}
			
		}
		
	};
	
	private TextWatcher lengthEdit2ChangListener = new TextWatcher() {

		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			try {
				if (shutUpLength) {
					lengthEdit2 = Double.parseDouble(s.toString());
					updateLength(1);
				}
				
			}
			catch (NumberFormatException e) {
				/*lengthEdit2 = 0.0;*/
			}
			
		}
		
	};
	
	private void updateLength(int which) {
		//which means update which one
		shutUpLength = false;
		if (which == 1) {
			lengthEdit1 = lengthEdit2 / lengthConversion;
			lengthET1.setText(String.format("%.3f", lengthEdit1));
		}
		else if (which == 2) {
			lengthEdit2 = lengthEdit1 * lengthConversion;
			lengthET2.setText(String.format("%.3f", lengthEdit2));
		}
		else {
			lengthET1.setText("0.0");
			lengthET2.setText("0.0");
		}
		shutUpLength = true;
	}
	
	// END LENGTH STUFF
	
	
	
	
	
	// BEGIN VOLUME STUFF
	private void addItemSelectedListenerToSpinnerVolume() {
		// TODO Auto-generated method stub
		volumeUnitSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				//String value = volumeUnitSpinner.getSelectedItem().toString();
			/*	volumeConversion = (volumeUnitSpinner.getSelectedItem().toString().equals("meters-in"))?39.3701:0;
				Log.d("volumeConversion", "Value: " + volumeUnitSpinner.getSelectedItem().toString());
				volumeConversion = (String.valueOf(volumeUnitSpinner.getSelectedItem()).equals("feet-mile"))?0.000189394:0;
				volumeConversion = (String.valueOf(volumeUnitSpinner.getSelectedItem()).equals("in-feet"))?0.0833333:0;
				volumeConversion = (String.valueOf(volumeUnitSpinner.getSelectedItem()).equals("mile-kilometer"))?1.60934:0;*/
				String value = volumeUnitSpinner.getSelectedItem().toString();
				Log.d("value", "Value: " + value);
				if (value.equals("meters cubed-liters")) {
					volumeConversion = 1000;
				}
				else if (value.equals("meters cubed-feet cubed")) {
					volumeConversion = 35.3146667;
				}
				else if (value.equals("milimeters cubed-milileters")) {
					volumeConversion = 0.001;
				}
				else if (value.equals("meters cubed-gallons")) {
					volumeConversion = 264.172052;
				}
				else if (value.equals("oz-cups")) {
					volumeConversion = 0.125;
				}
				else if (value.equals("cups-quart")) {
					volumeConversion = 0.25;
				}
				else if (value.equals("quart-gallon")) {
					volumeConversion = 0.25;
				}
				updateVolume(0);
				Log.d("value", "volumeConversion: " + volumeConversion);

			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private TextWatcher volumeEdit1ChangListener = new TextWatcher() {

		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			try {
				//addItemSelectedListenerToSpinner();
				if (shutUpVolume) {
					volumeEdit1 = Double.parseDouble(s.toString());
					Log.d("value", "volumeEdit1 first: " + volumeEdit1);
					updateVolume(2);
					
				}
			}
			catch (NumberFormatException e) {
				/*volumeEdit1 = 0.0;*/
			}
			
		}
		
	};
	
	private TextWatcher volumeEdit2ChangListener = new TextWatcher() {

		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			try {
				if (shutUpVolume) {
					volumeEdit2 = Double.parseDouble(s.toString());
					updateVolume(1);
				}
				
			}
			catch (NumberFormatException e) {
				/*volumeEdit2 = 0.0;*/
			}
			
		}
		
	};
	
	private void updateVolume(int which) {
		//which means update which one
		shutUpVolume = false;
		if (which == 1) {
			volumeEdit1 = volumeEdit2 / volumeConversion;
			volumeET1.setText(String.format("%.3f", volumeEdit1));
		}
		else if (which == 2) {
			volumeEdit2 = volumeEdit1 * volumeConversion;
			volumeET2.setText(String.format("%.3f", volumeEdit2));
		}
		else {
			volumeET1.setText("0.0");
			volumeET2.setText("0.0");
		}
		shutUpVolume = true;
	}
	
	// END VOLUME STUFF
	
	
	
	
	// BEGIN PRESSURE STUFF
	private void addItemSelectedListenerToSpinnerPressure() {
		// TODO Auto-generated method stub
		pressureUnitSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				//String value = pressureUnitSpinner.getSelectedItem().toString();
			/*	pressureConversion = (pressureUnitSpinner.getSelectedItem().toString().equals("meters-in"))?39.3701:0;
				Log.d("pressureConversion", "Value: " + pressureUnitSpinner.getSelectedItem().toString());
				pressureConversion = (String.valueOf(pressureUnitSpinner.getSelectedItem()).equals("feet-mile"))?0.000189394:0;
				pressureConversion = (String.valueOf(pressureUnitSpinner.getSelectedItem()).equals("in-feet"))?0.0833333:0;
				pressureConversion = (String.valueOf(pressureUnitSpinner.getSelectedItem()).equals("mile-kilometer"))?1.60934:0;*/
				String value = pressureUnitSpinner.getSelectedItem().toString();
				Log.d("value", "Value: " + value);
				if (value.equals("bars-Pa")) {
					pressureConversion = 100000;
				}
				else if (value.equals("bars-kPa")) {
					pressureConversion = 100;
				}
				else if (value.equals("bars-atm")) {
					pressureConversion = 0.986923267;
				}
				else if (value.equals("bars-mmHg")) {
					pressureConversion = 750.061683;
				}
				else if (value.equals("bars-psia")) {
					pressureConversion = 14.5037738007;
				}
				else if (value.equals("pKa-mmHg")) {
					pressureConversion = 7.50061683;
				}
				else if (value.equals("pKa-atm")) {
					pressureConversion = 0.00986923267;
				}
				else if (value.equals("pKa-psia")) {
					pressureConversion = 0.145037738;
				}
				else if (value.equals("atm-psia")) {
					pressureConversion = 14.6959488;
				}
				updatePressure(0);
				Log.d("value", "pressureConversion: " + pressureConversion);

			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private TextWatcher pressureEdit1ChangListener = new TextWatcher() {

		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			try {
				//addItemSelectedListenerToSpinner();
				if (shutUpPressure) {
					pressureEdit1 = Double.parseDouble(s.toString());
					Log.d("value", "pressureEdit1 first: " + pressureEdit1);
					updatePressure(2);
					
				}
			}
			catch (NumberFormatException e) {
				/*pressureEdit1 = 0.0;*/
			}
			
		}
		
	};
	
	private TextWatcher pressureEdit2ChangListener = new TextWatcher() {

		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			try {
				if (shutUpPressure) {
					pressureEdit2 = Double.parseDouble(s.toString());
					updatePressure(1);
				}
				
			}
			catch (NumberFormatException e) {
				/*pressureEdit2 = 0.0;*/
			}
			
		}
		
	};
	
	private void updatePressure(int which) {
		//which means update which one
		shutUpPressure = false;
		if (which == 1) {
			pressureEdit1 = pressureEdit2 / pressureConversion;
			pressureET1.setText(String.format("%.3f", pressureEdit1));
		}
		else if (which == 2) {
			pressureEdit2 = pressureEdit1 * pressureConversion;
			pressureET2.setText(String.format("%.3f", pressureEdit2));
		}
		else {
			pressureET1.setText("0.0");
			pressureET2.setText("0.0");
		}
		shutUpPressure = true;
	}
	
	// END PRESSURE STUFF
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
