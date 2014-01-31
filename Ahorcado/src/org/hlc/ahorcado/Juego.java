package org.hlc.ahorcado;

import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
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
	// Vistas:
	private LinearLayout layout;
	private TextView tvContador, tvSolucion;

	// Variables de juego:
	/*
	 * letrasPalabra: un array compuesto por las letras que componen la palabra
	 * solución. caracteresSolucion: conforme el usuario vaya acertando letras,
	 * insertaremos estas en la misma posicion que ocupan en letrasPalabra.
	 * fallos: contador de fallos que ha tenido el usuario. LIMITE_FALLOS:
	 * máximo de fallos permitidos
	 */
	//private List<char[]> letrasPalabra = Arrays.asList(MainActivity.palabra
			//.toCharArray());
	private char[] letrasPalabra = MainActivity.palabra.toCharArray();
	private char[] caracteresSolucion = new char[letrasPalabra.length];
	private int fallos = 0;
	private static final int LIMITE_FALLOS = 6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.juego);

		// Obtencion de las vistas:
		layout = (LinearLayout) findViewById(R.id.LinearLayout3);
		tvContador = (TextView) findViewById(R.id.contador);
		tvSolucion = (TextView) findViewById(R.id.solucion);

		// Modificacion de la fuente:
		Typeface tf = Typeface.createFromAsset(getAssets(), "tiza.ttf");

		for (int i = 0; i < layout.getChildCount(); i++) {
			View vista = layout.getChildAt(i);
			if (vista.getClass() == TextView.class
					|| vista.getClass() == Button.class) {
				((TextView) vista).setTypeface(tf, Typeface.BOLD);
			}
		}

		// Inicializacion del array solucion:
		for (int i = 0; i < caracteresSolucion.length; i++) {
			caracteresSolucion[i] = '_';
		}

		actualizarSolucion();

		// Contador a 0:
		actualizarContador();
	}

	public void comprobarSolucion(View view) {
		// Obtenemos la letra que corresponde al boton:
		Button boton = (Button) view;
		char letra = boton.getText().toString().charAt(0);
		// Desactivamos el boton:
		boton.setEnabled(false);
		/*
		 * Si la palabra contiene la letra, modificamos el array solucion, si
		 * no, se aumenta el contador de fallos. En ambos casos, comprobamos
		 * despues si el estado de ambos array, para determinar si ha ganado, ha
		 * perdido, o si debe continuar adivinando.
		 */
		if (Arrays.asList(letrasPalabra).contains(letra)) {
			for (int i = 0; i < letrasPalabra.length - 1; i++) {
				if (Arrays.asList(letrasPalabra).get(i).equals(letra)) {
					caracteresSolucion[i] = letra;
				}
			}

			actualizarSolucion();
			comprobarResultado();

		} else {
			fallos++;

			actualizarContador();
			actualizarSolucion();

			comprobarResultado();
		}
	}

	public void actualizarContador() {
		tvContador.setText("" + fallos);
	}

	public void actualizarSolucion() {
		tvSolucion.setText(Arrays.toString(caracteresSolucion));
	}

	public void comprobarResultado() {
		boolean haGanado = false;

		if (fallos >= LIMITE_FALLOS) {
			Intent intent = new Intent(this, Resultado.class);
			intent.putExtra("resultado", haGanado);
			fallos = 0;
			finish();
			startActivity(intent);
		//} else if (letrasPalabra.equals(caracteresSolucion)) {
		} else if (Arrays.equals(letrasPalabra, caracteresSolucion)) {
			haGanado = true;

			Intent intent = new Intent(this, Resultado.class);
			intent.putExtra("resultado", haGanado);
			fallos = 0;
			finish();
			startActivity(intent);
		}

	}

}
