package com.example.android1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

	EditText editTextinvestment;
	EditText editTextInterestRate;
	EditText editTextYears;
	EditText editTextFutureValue;
	Button button1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editTextinvestment = (EditText) findViewById(R.id.editTextinvestment);
		editTextInterestRate = (EditText) findViewById(R.id.editTextInterestRate);
		editTextYears = (EditText) findViewById(R.id.editTextYears);
		editTextFutureValue = (EditText) findViewById(R.id.editTextFutureValue);

		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				double investmentAmount = Double.parseDouble(editTextinvestment
						.getText().toString());
				double years = Double.parseDouble(editTextYears.getText()
						.toString());
				double annualInterestRate = Double
						.parseDouble(editTextInterestRate.getText().toString());

				double amount = Engine.investmentCalculator(
						investmentAmount, years, annualInterestRate); 

				editTextFutureValue.setText(amount + "");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
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
