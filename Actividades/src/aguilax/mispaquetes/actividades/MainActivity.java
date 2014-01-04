package aguilax.mispaquetes.actividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText et1;
	TextView  tv1;
	TextView tv2;
	Button bt1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView2);
        et1=(EditText)findViewById(R.id.editText1);
        bt1=(Button)findViewById(R.id.button1);
        tv1.setText(R.string.nombre);
        tv2.setText(R.string.Resultado);
        bt1.setText(R.string.verificar);
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
   
    public void ponNombre(View view){
    
    	//Toast.makeText(this,"boton pulsado",Toast.LENGTH_SHORT).show();	
    	Intent i=new Intent(this,Respuesta.class);
    	i.putExtra("nombre", et1.getText().toString());
    	startActivityForResult(i,1234);
    	} 
    
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
    	
    	if(requestCode==1234 ){
    		Log.d("paquito","he entrado" + requestCode +" "+ data.getExtras().getBoolean("resultado"));
    		if (data.getExtras().getBoolean("resultado")){
    			
    			tv2.setText("Gracias "+et1.getText()+" has aceptado la oferta");
    		}else{
    			tv2.setText("Lo siento "+et1.getText()+" NO has aceptado la oferta");
    			
    		}
    		
    	}
    }
}
