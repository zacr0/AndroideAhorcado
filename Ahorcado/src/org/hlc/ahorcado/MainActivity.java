package org.hlc.ahorcado;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Clase principal del juego del Ahorcado, permite al usuario elegir entre
 * insertar la palabra con la que se jugará a las adivinanzas. Una vez
 * introducida, se permitirá jugar a adivinarla. Contiene además un botón para
 * salir de la aplicación.
 * 
 * @author Pablo Medina Suárez
 * @since 2014
 */
public class MainActivity extends Activity {
	private TextView titulo, subtitulo;
	private Button botonInsertar, botonJugar, botonSalir;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Obtencion de las vistas:
		titulo = (TextView) findViewById(R.id.titulo);
		subtitulo = (TextView) findViewById(R.id.subtitulo);
		botonInsertar = (Button) findViewById(R.id.boton_palabra);
		botonJugar = (Button) findViewById(R.id.boton_jugar);
		botonSalir = (Button) findViewById(R.id.boton_salir);

		// Modificacion de la fuente para las vistas:
		Typeface tf = Typeface.createFromAsset(getAssets(), "tiza.ttf");
		titulo.setTypeface(tf, Typeface.BOLD);
		subtitulo.setTypeface(tf, Typeface.BOLD);
		botonInsertar.setTypeface(tf, Typeface.BOLD);
		botonJugar.setTypeface(tf, Typeface.BOLD);
		botonSalir.setTypeface(tf, Typeface.BOLD);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_salir:
			salir(null);
			break;
		}
		return true;
	}
	
	private void lanzarInsertar(View view) {
		// TODO
	}
	
	private void lanzarJugar(View view) {
		// TODO
	}

	public void salir(View view) {
		finish();
	}

}
