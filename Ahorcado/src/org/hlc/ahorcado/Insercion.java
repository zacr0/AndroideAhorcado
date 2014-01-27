package org.hlc.ahorcado;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class Insercion extends Activity {
	private TextView titulo, subtitulo;
	private Button botonInsertar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.insertar_palabra);
		
		// Obtencion de las vistas:
		titulo = (TextView) findViewById(R.id.titulo_insertar);
		subtitulo = (TextView) findViewById(R.id.subtitulo_insertar);
		botonInsertar = (Button) findViewById(R.id.boton_insertar);
		
		// Modificacion de la fuente:
		Typeface tf = Typeface.createFromAsset(getAssets(), "tiza.ttf");
		titulo.setTypeface(tf, Typeface.BOLD);
		subtitulo.setTypeface(tf, Typeface.BOLD);
		botonInsertar.setTypeface(tf, Typeface.BOLD);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insercion, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			// TODO
		}
		return super.onOptionsItemSelected(item);
	}

}
