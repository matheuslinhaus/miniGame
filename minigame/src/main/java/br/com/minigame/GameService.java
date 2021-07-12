package br.com.minigame;

import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Matheus Linhaus
 *
 */
public class GameService {
	String barras = "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=";
	String dificuldadeEscolhida = null;
	String mensagemDificuldade = "Dificuldade escolhida incorreta. Use as opções abaixo: F para Fácil\n M para Médio\n D para Difícil";
	boolean temDificuldade = false;

	public void carregaApresentacao() {
		System.out.println(barras);
		System.out.println("=-=-=-=Advinhe o número-=-=-=");
		System.out.println(barras);
		System.out.println("Regras do jogo: ");
		System.out.println("1- Utilize apenas números de 1 até 100");
		System.out.println("2- Escolha a dificuldade desejada abaixo");
		System.out.println(" F para Fácil - Dica para cada tentativa");
		System.out.println(" M para Médio - Dica a cada 5 tentativas");
		System.out.println(" D para Difícil - Opção de ter 1 dica na 15 tentativa");
		System.out.println("\nEntão vamos começar!!");
		return;
	}

	public void escolhaDificuldade() {
		Scanner sc = new Scanner(System.in);
		while (!temDificuldade) {
			System.out.print("Digite a dificuldade: ");
			dificuldadeEscolhida = sc.nextLine();
			validaEscolha();
		}
		sc.close();
	}

	public void validaEscolha() {
		String dificuldadeSemAcento = semAcento(dificuldadeEscolhida);
		if (dificuldadeSemAcento.length() == 1) {
			if (!dificuldadeSemAcento.toUpperCase().equals("F") && !dificuldadeSemAcento.toUpperCase().equals("M")
					&& !dificuldadeSemAcento.toUpperCase().equals("D")) {
				System.out.println(mensagemDificuldade);
				temDificuldade = false;
			} else {
				temDificuldade = true;
			}
		} else {
			if (!dificuldadeSemAcento.toUpperCase().equals("FACIL")
					&& !dificuldadeSemAcento.toUpperCase().equals("MEDIO")
					&& !dificuldadeSemAcento.toUpperCase().equals("DIFICIL")) {
				System.out.println(mensagemDificuldade);
				temDificuldade = false;
			} else {
				temDificuldade = true;
			}
		}
	}

	// https://www.devmedia.com.br/remova-caracteres-acentuados-de-uma-string-em-java/17500
	public static String semAcento(String str) {
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}

	public void teste() {
//		System.out.println(dificuldadeEscolhida);
	}

}
