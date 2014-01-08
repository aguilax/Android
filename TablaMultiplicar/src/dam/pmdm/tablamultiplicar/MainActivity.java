package dam.pmdm.tablamultiplicar;


import com.example.tablamultiplicar.R;

import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;
/**
 * Esta Programa calcula la tabla de multiplicar del numero introducido en  el campo de texto
 * de la activity inicial,que es recibida por el objeto bundle por la cativity CalculosTabla
 * quew se encargara de hacer los calculos necesarios y de pasar un string formateado para que
 * se represente en el edittext2
 * @atuthor Francisco Aguilar
 * @Version 31/10/2013 
 */
public class MainActivity extends Activity {
	private static final int REQUEST_TEST=0;
	private EditText eT1;
	private EditText eT2;
  /**
   * Se crea la actividad principal que contiene un objeto bundle 
   *  
   */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.activity_inicial);//uso mi layout personalizado
			
		eT2=(EditText)this.findViewById(R.id.editText2);
		eT1=(EditText)this.findViewById(R.id.editText1);
		
		Button bt1=(Button)this.findViewById(R.id.button1);
		Display display=getWindowManager().getDefaultDisplay();
		int ancho=display.getWidth();//para centrar el texto,me dice deprecated pero funciona
		int centradoH =ancho/3;
		Log.d("paco",String.valueOf(centradoH));
		eT2.setPadding(centradoH, 0, 0, 0);	
		
		bt1.setOnClickListener(new OnClickListener() {
			
			/* Genero un listener para el boton
			 * @see android.view.View.OnClickListener#onClick(android.view.View)
			 */
			@Override
	        public void onClick(View v) {
			Intent i=new Intent(MainActivity.this,CalculosTabla.class);// creo un intent
			String texto1=eT1.getText().toString();//creo una variable string y le asigno el contenido de editext1
			i.putExtra("text1",texto1);//lo sumamos como contenido extra al intent
			startActivityForResult(i,REQUEST_TEST); //arranco la activitie
				
			}
		});	
	}
	
	/* Recogemos los resultados cuando termina la activity 2 CalculosTabla
	 * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode,int resultCode,Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
				
			if(resultCode==Activity.RESULT_OK){
				
			    eT2.setText(data.getExtras().get("Tabla").toString());	

		}
	}
 

}
 