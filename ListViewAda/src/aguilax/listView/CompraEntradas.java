package aguilax.listView;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;

public class CompraEntradas extends Activity implements OnClickListener {
	private TextView tv10 = null;
	private TextView tv20 = null;
	private ImageView iv10 = null;
	private TextView tv30 = null;
	private Button btnAceptar = null;
	private Button btnCancelar = null;
	private EditText eTnumEntradas = null, eTnombre = null, eTdni = null;
	private String titulo = null;
	private String subtitulo = null;
	private Integer numEntradas = 0;
	private int entradas = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.comprarentradas);
	//asignamos los views del xml a las variables java
		tv10 = (TextView) findViewById(R.id.textView20);
		tv20 = (TextView) findViewById(R.id.textView30);
		iv10 = (ImageView) findViewById(R.id.imageView20);
		tv30 = (TextView) findViewById(R.id.tVnumentradas2);
		btnAceptar = (Button) findViewById(R.id.bOk);
		btnCancelar = (Button) findViewById(R.id.bCancelar);
		eTnumEntradas = (EditText) findViewById(R.id.eTnumEntradas);
		eTnombre = (EditText) findViewById(R.id.eTtuNumbre);
		eTdni = (EditText) findViewById(R.id.eTdni);
	//asignamos los click listener a los botones
		btnAceptar.setOnClickListener(this);
		btnCancelar.setOnClickListener(this);
	//obtenemos los extras del intent
		Bundle extras = getIntent().getExtras();
		titulo = extras.getString("titulo");
		subtitulo = extras.getString("subtitulo");
		numEntradas = extras.getInt("numEntradas");
		int imagen = extras.getInt("nomImagen");
	//asignammos valores a las views
		iv10.setImageResource(imagen);
		tv10.setText(titulo);
		tv20.setText(subtitulo);
		tv30.setText(tv30.getText() + " " + numEntradas);
	}

	@Override
	public void onClick(View v) {

		// getId devuelve el identificador de la vista
		int id = v.getId();
		if (!eTnumEntradas.getText().toString().equals("")){           // evitamos que devuelva null
		entradas = Integer.parseInt(eTnumEntradas.getText().toString());
		}
		
		switch (id) {
		
			case R.id.bOk:// si es igual al id del boton ok
				if ((eTnombre.getText().toString().equals("") || (eTdni.getText().toString().equals("")))) {
					Toast.makeText(this, "Debes rellenar todos los campos",Toast.LENGTH_SHORT).show();
					break;
				}
				if (numEntradas >= entradas) {	
					if (!compruebaDni()){
						break;
					}
					confirmacion();
					
				}else{Toast.makeText(this, "No hay tantas entradas", Toast.LENGTH_SHORT).show();}
				break;
				
			case R.id.bCancelar:// si es igual al id del boton cancelar
				Intent i = getIntent();
				setResult(RESULT_CANCELED, i);
				finish();
				break;
		}
	}
	
	/**
	 * busca la ultima letra del dni a ver si esta en el alfabeto
	 * @return true si es valido
	 * @return false si es invalido
	 */
	public boolean compruebaDni(){	
		String cadena = (eTdni.getText().toString()).toUpperCase();
		int nLetra = cadena.length();
		String letra = cadena.substring(nLetra - 1, nLetra);
		Log.d("Pako", letra);
		String letrasAcomparar = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

		if ((letrasAcomparar.indexOf(letra)) == -1) {//si la letra obtenida del dni no esta en el alfabeto =-1
			Toast.makeText(this, "Dni incorrecto", Toast.LENGTH_SHORT).show();
			return false;
		}else{
			return true;
		}	
	}

	/**
	 * Cronstruye una ventana emergente de confirmacion y dependiendo del resultado acepta 
	 * o cancela la compra
	 */
	public void confirmacion() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(
				"¿Está seguro que quiere comprar " + entradas
						+ " entradas para " + titulo)
				.setTitle("Confirmación")
				.setCancelable(false)
				.setNegativeButton("Cancelar",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						})
				.setPositiveButton("Continuar",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								int entradasResto = numEntradas - entradas;
								Intent i = getIntent();
								i.putExtra("resultado", entradasResto);
								setResult(RESULT_OK, i);
								finish();
							}
						});
		AlertDialog alert = builder.create();
		alert.show();
	}
}
