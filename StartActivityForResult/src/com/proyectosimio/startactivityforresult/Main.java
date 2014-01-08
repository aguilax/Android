package com.proyectosimio.startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 
 * @author ProyectoSimio
 *
 */
public class Main extends Activity {
	
	private EditText etNombre, etApellido;
	private final static int NOMBRE = 0;
	private final static int APELLIDO = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		etNombre = (EditText)findViewById(R.id.etNombre);
		etApellido = (EditText)findViewById(R.id.etApellido);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_CANCELED) {
			Toast.makeText(this, "Resultado cancelado", Toast.LENGTH_SHORT)
					.show();
		} else {
			String resultado = data.getExtras().getString("RESULTADO");
			switch (requestCode) {
			case NOMBRE:
				etNombre.setText(resultado);
				break;
			case APELLIDO:
				etApellido.setText(resultado);
				break;
			}
		}
	}

	public void rellenarNombre(View v) {
		Intent i = new Intent(this, RellenarCampos.class);
		
		startActivityForResult(i, NOMBRE);
	}
	
	public void rellenarApellido(View v) {

		Intent i = new Intent(this, RellenarCampos.class);
		
		startActivityForResult(i, APELLIDO);
	}

}
