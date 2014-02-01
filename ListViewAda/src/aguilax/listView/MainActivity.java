package aguilax.listView;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
        private TextView lblMensaje;
        private ListView lv1;
        private Entradas entrada[];       
        private AdaptadorTitulares adaptador=null;;  
       
@Override
  public void onCreate (Bundle savedInstanceState){
	  super.onCreate(savedInstanceState);   
	  int nEnt=preferencias();	
	  entrada=new Entradas[]{
	      		new Entradas("Copito de nieve","Ser diferente no es facil!!","i1",nEnt),
	      		new Entradas("Alvin y las ardillas","Fiesta en alta mar!!!","i2",nEnt),
	      		new Entradas("Vicky el vikingo","El martillo de Thor","i3",nEnt),
	      		new Entradas("Happy feet 2","Cada pase cuenta","i4",nEnt),
	      		new Entradas("Arthur chrismas","las mejores navidades","i5",nEnt),
	      		new Entradas("El topo","el que busca Fabra","i6",nEnt),
	      		new Entradas("La conspiración","la que los bancos ","i7",nEnt),
	      		};
	  setContentView(R.layout.activity_main);
	  //creamos  el adaptador llamando al constructor de adaptador de abajo
	  adaptador=new AdaptadorTitulares(this);
	  lblMensaje =(TextView)findViewById(R.id.textView1);
	  lblMensaje.setText("Peliculas disponibles");
	  lv1=(ListView)findViewById(R.id.listView1);
	  lv1.setAdapter(adaptador);
	  
    lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
    @Override
	public void onItemClick(AdapterView<?> parent, View v, int position,long id) {
			//cargamos el contexto del adaptador para poder sacar el id de la foto
			Context context= adaptador.getContext();
			int res=context.getResources().getIdentifier("drawable/" + entrada[position].getImagen(), null, context.getPackageName());
			//Hacemos el intent pasandole los datos que obtenemos del array y del id de la foto
			Intent i=new Intent(MainActivity.this,CompraEntradas.class);
				  i.putExtra("nomImagen",res);
				  i.putExtra("titulo",entrada[position].getTitular());
				  i.putExtra("subtitulo",entrada[position].getSubtitulo());
				  i.putExtra("numEntradas",entrada[position].getnumEntradas());
				  i.putExtra("posicion",position);		
			startActivityForResult(i, 1);//OJO hay que poner 1,ver api,no vale RESULT_Ok		      
		}});    
  }
  


  /* (non-Javadoc)
 * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
 */
@Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		 if(resultCode!=RESULT_CANCELED){
			  Log.d("Pako","he vuelto");
			  int numEntradas=data.getExtras().getInt("resultado");
			  int posicion=data.getExtras().getInt("posicion");
			  entrada[posicion].setNumEntradas(numEntradas);//modifico los datos del arra
			  adaptador=new AdaptadorTitulares(this);//creo un nuevo adaptador
			 lv1.setAdapter(adaptador);//se lo asigno al list adapter
		 }	
   }
 
  /**
   * Obtenemos las preferencias,si no las hay por defecto seran 11
 * @return numero de entradas almacenadas en el archivo de preferencias (10)
 */
public int preferencias(){
	  	  
	  SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE); 
	  SharedPreferences.Editor editor = prefs.edit();
	  editor.putInt("entradas", 10); //aqui variamos el numero de entradas
	  editor.commit();
	  int nEnt=prefs.getInt("entradas", 11);
	  return nEnt;
  }

  /**
 * Clase interna auxiliar para usarla en el adaptador detilularres 
 *
 */
static class ViewHolder {
    	TextView titulo;
    	TextView subtitulo;
    	ImageView imagen; 
    	TextView numEntradas;
  }
    	 
   /**
    * clase interna que controla como se muestra cada item de la lista extiende a arrayAdapter 
    * @author Paco
    */
  class AdaptadorTitulares extends ArrayAdapter<Entradas>{

        Activity context;   
        //constructor
        AdaptadorTitulares(Activity context) {
        	super(context,R.layout.titulares,entrada);//reconstuimos con el layout personalizado
        	this.context= context;
        }
     //getView metodo de adapter.getView();   
      public View getView(int position,View convertView,ViewGroup parent){
        	
    	    View item = convertView;
        	ViewHolder holder;
        	if(item == null)
        	{
	        	LayoutInflater inflater = context.getLayoutInflater();
	        	item = inflater.inflate(R.layout.titulares, null);
	        	holder = new ViewHolder();
	        	holder.imagen = (ImageView)item.findViewById(R.id.imageView10);
	        	holder.titulo = (TextView)item.findViewById(R.id.lblTitulo);
	        	holder.subtitulo = (TextView)item.findViewById(R.id.labelSubtitulo);
	        	holder.numEntradas=(TextView)item.findViewById(R.id.tVnumEntradas);
	        	item.setTag(holder);
        	}
        	else{holder = (ViewHolder)item.getTag();}
        	
        	holder.titulo.setText(entrada[position].getTitular());
        	holder.subtitulo.setText(entrada[position].getSubtitulo());
        	holder.numEntradas.setText("Entradas disponibles= "+entrada[position].getnumEntradas().toString());
        	int res_imagen = context.getResources().getIdentifier("drawable/" + entrada[position].getImagen(), null, context.getPackageName());
        	//Log.d("pako",""+res_imagen);
        	holder.imagen.setImageResource(res_imagen);//asigno el recurso obtenido(un integer)que se corresponde con la imagen
        	return(item);  	
        } 
        
         
   }
  
  
}