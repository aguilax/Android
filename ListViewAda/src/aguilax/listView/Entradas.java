package aguilax.listView;

import android.widget.ImageView;

public class Entradas {
	private String titular;
	private String subtitulo;
	private String imagen;
	private Integer numEntradas;
	
	public Entradas(String tit,String sub,String imagen,Integer numEntradas){
		this.titular=tit;
		this.subtitulo =sub;
		this.imagen=imagen;
		this.numEntradas=numEntradas;
		
		
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
	public Integer getnumEntradas() {
		return numEntradas;
	}

   public void setNumEntradas(int e){
	   this.numEntradas=e;
   }
	

}
