package br.com.minigame;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		GameService service = new GameService();

		service.carregaApresentacao();
		service.escolhaDificuldade();
		service.digitaTentativa();

	}
}
