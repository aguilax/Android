package aguilax.mispaquetes.actividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Respuesta extends Activity{
	TextView tv10;
	Button bt10;
	Button bt20;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_respuesta);
		Bundle extras =getIntent().getExtras();
		String nombre=extras.getString("nombre");
		Log.d("Pakito"," "+nombre);
		tv10=(TextView)findViewById(R.id.textView10);
		bt10=(Button)findViewById(R.id.button10);
		bt20=(Button)findViewById(R.id.button20);
		tv10.setText("Hola " +nombre +" .¿Aceptas las conciciones?");
		bt10.setText(R.string.aceptar);
		bt20.setText(R.string.rechazar);
	}
	public void botonClick(View view){
	int nBoton=Integer.parseInt((String) view.getTag());
	switch(nBoton){
		
		case 1:Toast.makeText(this,"Boton 1 ",Toast.LENGTH_SHORT).show();
			Intent i =new Intent();
			i.putExtra("resultado", true);
			setResult(RESULT_OK, i);
			finish();
			break;
			
		case 2:Toast.makeText(this,"Boton 2 ",Toast.LENGTH_SHORT).show();
		 
		   Intent in =new Intent();
		   in.putExtra("resultado", false);
			setResult(RESULT_OK, in);
		   finish();
		   break;	
	 }
	}
}
