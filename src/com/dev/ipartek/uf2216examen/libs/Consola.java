package com.dev.ipartek.uf2216examen.libs;

import java.util.Scanner;

public class Consola {
	private static final Scanner sc = new Scanner(System.in);

	public static final boolean OPCIONAL = true;
	public static final boolean OBLIGATORIO = false;

	public static String leerString(String mensaje, boolean esOpcional) {
		String texto;
		boolean repetir = true;

		do {
			System.out.print(mensaje + ": ");
			texto = sc.nextLine().trim();

			if (!esOpcional && texto.length() == 0) {
				System.out.println("Este dato es obligatorio");
			} else {
				repetir = false;
			}
		} while (repetir);

		return texto.length() > 0 ? texto : null;
	}

	public static String leerString(String mensaje) {
		return leerString(mensaje, OBLIGATORIO);
	}
	
	public static Boolean leerBoolean(String mensaje) {
		String texto = leerString(mensaje + " [DIGITAL|PAPEL]");
		
		Boolean b = "DIGITAL".equalsIgnoreCase(texto);
		
		return b;
	}

	public static Long leerLong(String mensaje) {
		return leerLong(mensaje, OBLIGATORIO);
	}

	public static Long leerLong(String mensaje, boolean opcional) {
		boolean hayError = true;
		long l = 0;

		do {
			try {
				String dato = leerString(mensaje, opcional);

				if (dato == null) {
					return null;
				}

				l = Long.parseLong(dato);
				hayError = false;
			} catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero entre " + Long.MIN_VALUE + " y " + Long.MAX_VALUE);
			}
		} while (hayError);

		return l;
	}

	public static Integer leerInt(String mensaje) {
		return leerInt(mensaje, OBLIGATORIO);
	}

	public static Integer leerInt(String mensaje, boolean opcional) {
		return leerInt(mensaje, opcional, null, null);
	}

	public static Integer leerInt(String mensaje, boolean opcional, Integer minimo, Integer maximo) {
		boolean hayError = true;
		int i = 0;

		if (minimo == null) {
			minimo = Integer.MIN_VALUE;
		}

		if (maximo == null) {
			maximo = Integer.MAX_VALUE;
		}

		do {
			try {
				String dato = leerString(mensaje, opcional);

				if (dato == null) {
					return null;
				}

				i = Integer.parseInt(dato);

				if (i < minimo || i > maximo) {
					System.out.println("El valor está fuera de límites");
				} else {
					hayError = false;
				}
			} catch (NumberFormatException e) {
				System.out
						.println("El número debe ser un entero entre " + Integer.MIN_VALUE + " y " + Integer.MAX_VALUE);
			}
		} while (hayError);

		return i;
	}


	
}
