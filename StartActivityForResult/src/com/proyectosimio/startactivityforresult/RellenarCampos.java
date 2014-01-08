package com.proyectosimio.startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 
 * @author ProyectoSimio
 *
 */
public class RellenarCampos extends Activity {

	Button btAceptar, btCancelar;
	EditText etResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rellenar_campos);
		btAceptar = (Button) findViewById(R.id.btAceptar);
		btCancelar = (Button) findViewById(R.id.btCancelar);
		etResult = (EditText) findViewById(R.id.etResult);

		btAceptar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (etResult.getText().length() != 0) {
					String resultado = etResult.getText().toString();
					Intent i = getIntent();
					i.putExtra("RESULTADO", resultado);
					setResult(RESULT_OK, i);
				} else {
					Toast.makeText(RellenarCampos.this,
							"No se ha introducido nada en el campo de texto",
							Toast.LENGTH_SHORT).show();
				}

			}
		});

		btCancelar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				setResult(RESULT_CANCELED);

			}
		});
	}

}
