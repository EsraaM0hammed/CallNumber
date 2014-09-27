package com.example.callnumber;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	Button call;
	//String num = "*868*1#"; Code
	
	//String uri = "tel:" + num.trim(); // when You Want To Call Code 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		call = (Button) findViewById(R.id.Call);
		call.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				makeCall();

			}

		
		});
	}
	private void makeCall() {
		Log.i("Make call", "");

		Intent callIntent = new Intent(Intent.ACTION_CALL);
		//callIntent.setData(Uri.parse("tel:" + Uri.encode(num.trim()))); //when you want to call code
		callIntent.setData(Uri.parse("tel:050123456"));
		callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(callIntent);

		try {
			startActivity(callIntent);
			finish();
			Log.i("Finished making a call...", "");
		} catch (android.content.ActivityNotFoundException ex) {
			Toast.makeText(MainActivity.this,
					"Call faild, please try again later.",
					Toast.LENGTH_SHORT).show();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

}
