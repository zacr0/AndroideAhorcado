package org.hlc.ahorcado;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Clase encargada de manejar el juego en si, cuando se introduce una palabra,
 * se permite al usuario iniciar esta actividad.
 * 
 * Al usuario le aparece la palabra (en forma de '-') y una serie de botones con
 * las distintas letras del abecedario, las cuales puede pulsar para intentar
 * adivinar la palabra.
 * 
 * En caso de fallar, se aumenta el contador de errores, el cual tiene un limite
 * definido: si el usuario lo alcanza, perdera la partida. En el caso de acertar
 * la palabra, se ganara la partida. En ambos casos, se llama a la actividad
 * Resultado.
 * 
 * @author Pablo Medina Suarez
 * @since 2014
 * 
 */
public class Juego extends Activity {
	private LinearLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.juego);

		// Obtencion de las vistas:
		layout = (LinearLayout) findViewById(R.id.LinearLayout);

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
		getMenuInflater().inflate(R.menu.juego, menu);
		return true;
	}

}
