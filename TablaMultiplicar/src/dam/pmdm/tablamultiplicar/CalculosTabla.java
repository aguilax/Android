package dam.pmdm.tablamultiplicar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Esta clase calcula la tabla de multiplicar del numero introducido en  el campo de texto
 * de la activity inicial,que es recibida por el objeto bundle
 * @atuthor Francisco Aguilar
 * @Version 31/10/2013 
 */
public class CalculosTabla extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent i = getIntent();  //recupera el intet actual
		Bundle b = i.getExtras();// bundle contiene todos los datos enviados
									// desde el intent
		int numero = Integer.parseInt(b.getString("text1"));// cargamos el
															// contenido del
															// put extra que hemos puesto en el intent
															//que coincde con el contenido del et1	
		String resultado = "";
		for (int x = 1; x < 11; x++) {

			resultado = resultado + (numero + " X " + x + "=" + (numero * x) + "\n").toString();
		}

		i.putExtra("Tabla", resultado);// añadimos al intent otra etiqueta cuyo
										// contenido es un string
										// con el resultado
		setResult(Activity.RESULT_OK, i);// establecemos el resultado que
		CalculosTabla.this.finish();
	}

}
