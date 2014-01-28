package org.hlc.ahorcado;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Insercion extends Activity {
	private Button botonInsertar;
	private LinearLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.insertar_palabra);

		// Obtencion de las vistas:
		/*
		 * titulo = (TextView) findViewById(R.id.titulo_insertar); subtitulo =
		 * (TextView) findViewById(R.id.subtitulo_insertar); botonInsertar =
		 * (Button) findViewById(R.id.boton_insertar);
		 */
		layout = (LinearLayout) findViewById(R.id.LinearLayout);
		botonInsertar = (Button) findViewById(R.id.boton_insertar);

		// Modificacion de la fuente:
		Typeface tf = Typeface.createFromAsset(getAssets(), "tiza.ttf");
		/*
		 * titulo.setTypeface(tf, Typeface.BOLD); subtitulo.setTypeface(tf,
		 * Typeface.BOLD); botonInsertar.setTypeface(tf, Typeface.BOLD);
		 */
		for (int i = 0; i < layout.getChildCount(); i++) {
			View vista = layout.getChildAt(i);
			if (vista.getClass() == TextView.class
					|| vista.getClass() == Button.class) {
				((TextView) vista).setTypeface(tf, Typeface.BOLD);
			}
		}
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
		case R.id.action_volver:
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void insertarYSalir(View view) {
		String palabra = getPalabra();
		
		if (palabra.equals("")) {
			Toast.makeText(this, R.string.error_falta_palabra, Toast.LENGTH_LONG).show();
		} else if (palabra.matches(".*\\s+.*")) {
			Toast.makeText(this, R.string.error_formato_palabra, Toast.LENGTH_LONG).show();
		} else {
			MainActivity.palabra = palabra;
			finish();
		}
	}

	private String getPalabra() {
		return botonInsertar.getText().toString().trim();

	}

}
