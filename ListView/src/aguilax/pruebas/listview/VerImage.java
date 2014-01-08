package aguilax.pruebas.listview;

import aguilax.pruebas.kk5.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class VerImage extends Activity {
	TextView tv10;
	TextView tv20;
	ImageView iv10;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.verimagen);
		tv10=(TextView)findViewById(R.id.textView10);
		tv20=(TextView)findViewById(R.id.textView20);
		iv10=(ImageView)findViewById(R.id.imageView10);
		Bundle extras=getIntent().getExtras();
		String titulo=extras.getString("titulo");
		String subtitulo=extras.getString("subtitulo");
		
		int  imagen=extras.getInt("nomImagen");
		
		iv10.setImageResource(imagen);
		tv10.setText(titulo);
		tv20.setText(subtitulo);
		//iv10.setImageResource(imagen);
	}

}
