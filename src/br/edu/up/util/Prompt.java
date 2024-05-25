package br.edu.up.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Um classe utilitária para imprimir e ler textos, números inteiros e decimais
 * no prompt de comandos.
 * 
 * @version 1.0 Mar 2023
 * @author Geucimar Briatore
 */
public class Prompt {

	/**
	 * Imprime a mensagem enviada no console.
	 */
	public static void imprimir(String mensagem) {
		System.out.println(mensagem);
		System.out.flush();
	}

	/**
	 * Imprime o objeto enviado no console.
	 */
	public static void imprimir(Object object) {
		System.out.println(object);
		System.out.flush();
	}

	/**
	 * Imprime uma linha separadora no console.
	 */
	public static void separador() {
		imprimir("---------------------------------------------------");
	}

	/**
	 * Imprime uma linha em branco no console.
	 */
	public static void linhaEmBranco() {
		System.out.println();
		System.out.flush();
	}

	/**
	 * Imprime a mensagem enviada, faz a leitura do texto digitado no prompt de
	 * comandos e retorna uma String no formato ISO-8859-1 Latin ou UTF-8.
	 * 
	 * @return String
	 */
	public static String lerLinha(String mensagem) {
		imprimir(mensagem);
		return lerLinha();
	}

	/**
	 * Faz a leitura de texto digitado no prompt de comandos e retorna uma String no
	 * formato ISO-8859-1 Latin ou UTF-8.
	 * 
	 * @return String
	 */
	public static String lerLinha() {
		while (true) {
			try {
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				return br.readLine();
			} catch (IOException e) {
				System.out.println("Texto inválido, digite novamente...");
			}
		}
	}


	/**
	 * Faz a leitura de um caractere digitado no prompt de comandos e retorna no
	 * formato ISO-8859-1 Latin ou UTF-8.
	 * 
	 * Vai retornar o caractere com espaço vazio ' ' se o valor digitado for inválido!
	 * 
	 * @return String
	 */
	public static char lerCaractere(String mensagem) {
		imprimir(mensagem);
		return lerCaractere();
	}


	/**
	 * Faz a leitura de um caractere digitado no prompt de comandos e retorna no
	 * formato ISO-8859-1 Latin ou UTF-8.
	 * 
	 * Vai retornar o caractere com espaço vazio ' ' se o valor digitado for inválido!
	 * 
	 * @return String
	 */
	public static char lerCaractere(){
		char caractere = ' ';
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			caractere = (char) br.read();
		} catch (IOException e) {			
		}
		return caractere;
	}

	/**
	 * Imprime a mensagem enviada, faz a leitura do número digitado no prompt de
	 * comandos e retorna um int.
	 * 
	 * @return int
	 */
	public static int lerInteiro(String mensagem) {
		imprimir(mensagem);
		return lerInteiro();
	}

	/**
	 * Faz a leitura do número digitado no prompt de comandos e retorna um int.
	 * 
	 * @return int
	 */
	public static int lerInteiro() {
		while (true) {
			try {
				String linha = lerLinha();
				if (linha.isEmpty()) {
					return 0;
				}
				return Integer.parseInt(linha);
			} catch (NumberFormatException tExcept) {
				System.out.println("Inteiro inválido, digite novamente...");
			}
		}
	}

	/**
	 * Imprime a mensagem enviada, faz a leitura do número digitado no prompt de
	 * comandos e retorna um double.
	 * 
	 * @return double
	 */
	public static double lerDecimal(String mensagem) {
		imprimir(mensagem);
		return lerDecimal();
	}

	/**
	 * Faz a leitura do número digitado no prompt de comandos e retorna um double.
	 * 
	 * @return double
	 */
	public static double lerDecimal() {
		while (true) {
			try {
				String linha = lerLinha();
				if (linha.isEmpty()) {
					return 0;
				}
				return Double.parseDouble(linha);
			} catch (NumberFormatException e) {
				System.out.println("Decimal inválido, digite novamente...");
			}
		}
	}

	/**
	 * Faz uma pausa no processamento e pede para o usuário pressionar enter para
	 * continuar.
	 */
	public static void pressionarEnter() {
		System.out.print("Pressione ENTER para continuar...");
		lerLinha();
	}
}
