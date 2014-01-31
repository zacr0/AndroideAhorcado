package org.hlc.ahorcado;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Insercion extends Activity {
	private EditText campoInsertar;
	private LinearLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.insertar_palabra);

		// Obtencion de las vistas:
		layout = (LinearLayout) findViewById(R.id.LinearLayout2);
		campoInsertar = (EditText) findViewById(R.id.campo_insertar);

		// Modificacion de la fuente:
		Typeface tf = Typeface.createFromAsset(getAssets(), "tiza.ttf");
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

	public void insertarYSalir(View view) {
		String palabra = getPalabra();

		if (palabra.matches("[a-z]+")) {
			MainActivity.palabra = palabra;
			finish();
		} else {
			Toast.makeText(this, R.string.error_formato_palabra,
					Toast.LENGTH_LONG).show();
		}
	}

	public String getPalabra() {
		return campoInsertar.getText().toString().trim();
	}

}
