package MainPackage;

import FutureValue.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {

	private Spinner ValueYearSpinner;
	private EditText AmmountOfInvestment;
	private EditText RateOfInterest;
	private EditText FV;
	private Button calculate;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Spinner control for years
		ValueYearSpinner = (Spinner) findViewById(R.id.spinner1);
		AmmountOfInvestment = (EditText) findViewById(R.id.editText1);
		AmmountOfInvestment.addTextChangedListener(new TextWatcher(){
		
			public void afterTextChanged(Editable s) {
				checkReady();}

			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

		
			public void onTextChanged(CharSequence s, int start, int before, int count) {}
		});
		RateOfInterest = (EditText) findViewById(R.id.editText2);
		RateOfInterest.addTextChangedListener(new TextWatcher(){
			
			public void afterTextChanged(Editable s) {
				checkReady();}

			
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

			
			public void onTextChanged(CharSequence s, int start, int before, int count) {}
		});

		FV = (EditText)findViewById(R.id.editText3);
		calculate = (Button) findViewById(R.id.button1);

		calculate.setOnClickListener(new OnClickListener(){

			
			public void onClick(View v){
				Ready();
			}

		});
	}

	private void checkReady() {
		if( (!(AmmountOfInvestment.getText().toString().equals("")))  &
				(!(RateOfInterest.getText().toString().equals(""))) ){
			calculate.setEnabled(true);

		}else
			calculate.setEnabled(false);	

	}

	private void Ready() {
		double amnt = Double.parseDouble(AmmountOfInvestment.getText().toString());
		double rate = Double.parseDouble(RateOfInterest.getText().toString());
		double yr = Double.parseDouble((String) ValueYearSpinner.getSelectedItem());
		double FVal = amnt*Math.pow(1+(rate/1200), yr*12);
		String futVal = String.format("%1$,.2f", FVal);
		FV.setText(futVal);
		
	}

	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
