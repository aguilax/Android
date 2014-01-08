package aguilax.pruebas.listview;

import android.widget.ImageView;

public class Titular {
	private String titular;
	private String subtitulo;
	private String imagen;
	
	public Titular(String tit,String sub,String imagen){
		this.titular=tit;
		this.subtitulo =sub;
		this.imagen=imagen;
		
		
	}
	


	public String getTitular() {
		return titular;
	}


	public String getSubtitulo() {
		return subtitulo;
	}
	public String getImagen() {
		return imagen;
	}


	

}
