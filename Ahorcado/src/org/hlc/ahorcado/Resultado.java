package org.hlc.ahorcado;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Actividad donde se muestra al usuario el resultado tras finalizar la partida,
 * pudiendo haber ganado (acertando la palabra) o perdiendo (llegando al máximo
 * de intentos).
 * 
 * En función de dicho resultado, se le muestra un texto indicándolo, con un
 * color acompañándolo.
 * 
 * A continuación, se le muestran dos botones para elegir salir o insertar una
 * nueva palabra, para seguir jugando.
 * 
 * @author Pablo Medina Suarez
 * @since 2014
 * 
 */
public class Resultado extends Activity {
	private LinearLayout layout;
	private TextView vistaResultado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultado);

		// Obtencion de las vistas:
		layout = (LinearLayout) findViewById(R.id.LinearLayout4);
		vistaResultado = (TextView) findViewById(R.id.resultado);

		// Obtencion del resultado
		Bundle extras = getIntent().getExtras();
		boolean resultado = extras.getBoolean("resultado");

		// Mostramos un texto u otro en funcion del resultado, con un color
		if (resultado) {
			vistaResultado.setText(R.string.resultado_ganar);
			vistaResultado.setTextColor(Color.GREEN);
		} else {
			vistaResultado.setText(R.string.resultado_perder);
			vistaResultado.setTextColor(Color.RED);
		}

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
	
	public void lanzarInsercion(View view) {
		Intent intent = new Intent(this, Insercion.class);
		startActivity(intent);
	}
	
	public void lanzarMenu(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

}
