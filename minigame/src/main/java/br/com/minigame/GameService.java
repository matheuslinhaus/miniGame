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
	String mensagemDificuldade = "Dificuldade escolhida incorreta. Use as opções abaixo:\n F para Fácil\n M para Médio\n D para Difícil";
	String dificuldadeSemAcento;
	int escolhido = 2;
	int aleatorio = 4;
	boolean temDificuldade = false;
	boolean acertou = false;
	int totalTentativas = 0;
	Scanner sc = new Scanner(System.in);

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
		while (!temDificuldade) {
			System.out.print("Digite a dificuldade: ");
			dificuldadeEscolhida = sc.nextLine();
			validaEscolha();
		}
	}

	public void validaEscolha() {
		dificuldadeSemAcento = semAcento(dificuldadeEscolhida);
		if (!dificuldadeSemAcento.equalsIgnoreCase("F") && !dificuldadeSemAcento.equalsIgnoreCase("M")
				&& !dificuldadeSemAcento.equalsIgnoreCase("D")
				&& !dificuldadeSemAcento.equalsIgnoreCase("FACIL")
				&& !dificuldadeSemAcento.equalsIgnoreCase("MEDIO")
				&& !dificuldadeSemAcento.equalsIgnoreCase("DIFICIL")) {
			System.out.println(mensagemDificuldade);
			temDificuldade = false;
		} else {
			temDificuldade = true;
		}
	}

	// https://www.devmedia.com.br/remova-caracteres-acentuados-de-uma-string-em-java/17500
	public static String semAcento(String str) {
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}

	public void processaDificuldade() {
		if (dificuldadeSemAcento.equalsIgnoreCase("FACIL") || dificuldadeSemAcento.equalsIgnoreCase("F")) {
			dificuldadeFacil();
		} else {
			if (dificuldadeSemAcento.equalsIgnoreCase("MEDIO") || dificuldadeSemAcento.equalsIgnoreCase("M")) {
			} else {
				if (dificuldadeSemAcento.equalsIgnoreCase("DIFICIL")
						|| dificuldadeSemAcento.equalsIgnoreCase("D")) {
				}
			}
		}
	}

	public void dificuldadeFacil() {
		if (escolhido != aleatorio) {
			if (escolhido > aleatorio) {
				System.out.println("Que pena você errou. Tente um número menor!!");
				totalTentativas += 1;
			} else {
				System.out.println("Que pena você errou. Tente um número maior!!");
				totalTentativas += 1;
			}
		} else {
			acertou = true;
		}
	}

	public void digitaTentativa() {
		while (!acertou) {
			System.out.print("Escolha um número: ");
			escolhido = sc.nextInt();
			processaDificuldade();
		}
	}
}
