package com.joey.ruler;

import com.joey.ruler.library.Ruler;
import com.joey.ruler.library.RulerHandler;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	Ruler ruler;
	TextView result;
	EditText editText;
	Button button;
	Ruler ruler2;
	TextView result2;
	EditText editText2;
	Button button2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ruler = (Ruler)findViewById(R.id.ruler);
		result = (TextView)findViewById(R.id.result_text);
		ruler.setRulerHandler(rulerHandler);
		editText = (EditText)findViewById(R.id.edit_text);
		button = (Button)findViewById(R.id.button);
		button.setOnClickListener(clickListener);
		
		ruler2 = (Ruler)findViewById(R.id.ruler2);
		result2 = (TextView)findViewById(R.id.result_text2);
		ruler2.setRulerHandler(rulerHandler2);
		editText2 = (EditText)findViewById(R.id.edit_text2);
		button2 = (Button)findViewById(R.id.button2);
		button2.setOnClickListener(clickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private RulerHandler rulerHandler = new RulerHandler() {
		
		@Override
		public void markScrollto(int max, int min, float val) {
			// TODO Auto-generated method stub
			int hour = max;
			int minute = min*6 + (int)(val *6);
			result.setText(String.format("%02d:%02d", hour,minute));
		}
	};
	private RulerHandler rulerHandler2 = new RulerHandler() {
		
		@Override
		public void markScrollto(int max, int min, float val) {
			// TODO Auto-generated method stub
			
			result2.setText(String.format("%f", ((float)max+((float)min+val)/10)));
		}
	};
	
	private View.OnClickListener clickListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Log.i("MainActivity","onClick");
			
			switch(v.getId())
			{
			case R.id.edit_text:
				String msg = editText.getText().toString();
				if(msg == null ||msg.isEmpty())
					return;
				result.setText(msg);
				ruler.scrollToTime(msg);
			case R.id.edit_text2:
				break;
			}
		
		}
	};
}
