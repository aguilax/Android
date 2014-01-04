package dam.pmdm.ciclodevida;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class CicloactivityMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cicloactivity_main);
		Toast.makeText(this, "onStart event", Toast.LENGTH_SHORT).show();
		
	}
	
	
	
	@Override protected void onResume(){
		super.onResume();
		Toast.makeText(this,"onResume evet",Toast.LENGTH_SHORT).show();
	}
	@Override protected void onPause(){
		super.onPause();
		Toast.makeText(this,"onPause event",Toast.LENGTH_SHORT).show();
	}
	@Override protected void onStop(){
		super.onStop();
		Toast.makeText(this,"onStop event", Toast.LENGTH_SHORT).show();
		
	}
	@Override protected void onRestart(){
		super.onRestart();
		Toast.makeText(this, "onRestart event",Toast.LENGTH_SHORT).show();
	}
	@Override protected void onDestroy(){
		super.onDestroy();
		Toast.makeText(this,"onDestroy event", Toast.LENGTH_SHORT).show();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cicloactivity_main, menu);
		return true;
	}

}
