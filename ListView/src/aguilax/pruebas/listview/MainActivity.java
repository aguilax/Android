package aguilax.pruebas.listview;



import aguilax.pruebas.kk5.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
        
        private TextView lblMensaje;
        private ListView lv1;
        private Titular datos[]=new Titular[]{
        		new Titular("Titulo1","Subtitulo1","images1"),
        		new Titular("Titulo2","Subtitulo2","images2"),
        		new Titular("Titulo3","Subtitulo3","images3"),
        		new Titular("Titulo4","Subtitulo4","images4"),
        		new Titular("Titulo5","Subtitulo5","images5"),
        		new Titular("Titulo1","Subtitulo1","images1"),
        		new Titular("Titulo2","Subtitulo2","images2"),
        		new Titular("Titulo3","Subtitulo3","images3"),
        		new Titular("Titulo4","Subtitulo4","images4"),
        		new Titular("Titulo5","Subtitulo5","images5")};		
  @Override
  public void onCreate (Bundle savedInstanceState){
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);
	  //creamos  el adaptador llamando al constructor de adaptador de abajo
	 final  AdaptadorTitulares adaptador=new AdaptadorTitulares(this);
	  lblMensaje =(TextView)findViewById(R.id.textView1);
	  lv1=(ListView)findViewById(R.id.listView1);
	  lv1.setAdapter(adaptador);
	  
	 lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		 
		@Override
		public void onItemClick(AdapterView<?> parent, View v, int position,long id) {
			lblMensaje.setText(datos[position].getTitular());	
			//cargamos el contexto del adaptador para poder sacar el id de la foto
			Context context= adaptador.getContext();
			int res=context.getResources().getIdentifier("drawable/" + datos[position].getImagen(), null, context.getPackageName());
			//Hacemos el intent pasandole los datos que obtenemos del array y del id de la foto
			Intent i=new Intent(MainActivity.this,VerImage.class);
				   i.putExtra("nomImagen",res);
				   i.putExtra("titulo",datos[position].getTitular());
				   i.putExtra("subtitulo",datos[position].getSubtitulo());
			startActivity(i);
		      
		}
		  
	});
	 
  
	
	
  }
 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    static class ViewHolder {
    	TextView titulo;
    	TextView subtitulo;
    	ImageView imagen; 
    }
    	
    
   /**
    * clase que controla como se muestra cada item de la lista extiende a arrayAdapter 
    * @author Paco
    */
   class AdaptadorTitulares extends ArrayAdapter<Titular>{
        Activity context;
        
        //constructor
        AdaptadorTitulares(Activity context) {
        	super(context,R.layout.titulares,datos);//reconstuimos con el layout personalizado
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
	        	holder.titulo = (TextView)item.findViewById(R.id.lblTitulo);
	        	holder.subtitulo = (TextView)item.findViewById(R.id.labelSubtitulo);
	        	holder.imagen = (ImageView)item.findViewById(R.id.imageView10);
	        	item.setTag(holder);
        	}
        	else
        	{
        		holder = (ViewHolder)item.getTag();
        	}
        	holder.titulo.setText(datos[position].getTitular());
        	holder.subtitulo.setText(datos[position].getSubtitulo());
        	int res_imagen = context.getResources().getIdentifier("drawable/" + datos[position].getImagen(), null, context.getPackageName());
        	Log.d("pako",""+res_imagen);
        	holder.imagen.setImageResource(res_imagen);//asigno el recurso obtenido(un integer)que se corresponde con la imagen
        	return(item);
        	
        	
        	// SIN OPTMIZAR
        	
        	
        	/*LayoutInflater inflater=context.getLayoutInflater();//desplegamos el layout
        	View item=inflater.inflate(R.layout.titulares,null);// se lo asignamos a item
        	TextView lblTitulo=(TextView)item.findViewById(R.id.lblTitulo); //buscamos el textview por id
        	lblTitulo.setText(datos[position].getTitular());//asignando datos a la etiqueta que contiene 
        	TextView lblSubtitulo=(TextView)item.findViewById(R.id.labelSubtitulo);//
        	lblSubtitulo.setText(datos[position].getSubtitulo());
        	ImageView img1=(ImageView)item.findViewById(R.id.imageView1);//buscamos el control de laimagen
        	//obtengo el identificador correspondiente a la imagen que busco
        	int res_imagen = context.getResources().getIdentifier("drawable/" + datos[position].getImagen(), null, context.getPackageName());
        	Log.d("pako",""+res_imagen);
        	img1.setImageResource(res_imagen);//asigno el recurso obtenido(un integer)que se corresponde con la imagen
			return item;*/
        	
        }
     
   }
}