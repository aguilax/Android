package aguilax.listView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class VerImagen extends Activity {
	TextView tv10;
	TextView tv20;
	ImageView iv10;
	TextView tv30;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comprarentradas);
		tv10=(TextView)findViewById(R.id.textView20);
		tv20=(TextView)findViewById(R.id.textView20);
		iv10=(ImageView)findViewById(R.id.imageView20);
		tv30=(TextView)findViewById(R.id.tVnumentradas2);
		Bundle extras=getIntent().getExtras();
		String titulo=extras.getString("titulo");
		String subtitulo=extras.getString("subtitulo");
		Integer numEntradas=extras.getInt("numEntradas");
		int  imagen=extras.getInt("nomImagen");
		
		iv10.setImageResource(imagen);
		tv10.setText(titulo);
		tv20.setText(subtitulo);
		tv30.setText(tv30.getText()+" "+numEntradas);
		//iv10.setImageResource(imagen);
	}

}
