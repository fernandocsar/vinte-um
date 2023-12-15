package vinteUm;

import java.util.Scanner;

public class VinteUm {

	public static void main(String[] args) throws InterruptedException {

		//criação do baralho
		int[] baralho = new int[52];
		for(int naipe=0; naipe<=3; naipe++) {
			for(int numero=1; numero<=13; numero++) {
				baralho[(naipe * 13) + numero - 1] = numero;
			}
		}
		
		//embaralhamento
		for(int i=0; i<52; i++) {
			int carta = baralho[i];
			int novaPosicao = (int)(Math.random() * 52);
			baralho[i] = baralho[novaPosicao];
			baralho[novaPosicao] = carta;
		}
		
		Scanner teclado = new Scanner(System.in);
		int pontosJogador = 0;
		int proximaCarta = 0;
		int cartaAtual = 0;
		boolean maisCarta = true;
		
		do {
			cartaAtual = baralho[proximaCarta++];
			System.out.println("Você sacou um " + cartaAtual);
			pontosJogador += cartaAtual;
			System.out.println("Sua pontuação atual é " + pontosJogador);
			System.out.println("Digite 1 para sacar mais uma carta ou qualquer outro número para parar.");
			maisCarta = teclado.nextInt() == 1;
		}while(maisCarta);
		
		if(pontosJogador == 21) {
			System.out.println("Na mosca, você venceu!");
			return;
		}
		else if(pontosJogador > 21) {
			System.out.println("Sinto muito, não foi dessa vez!");
			return;
		}
		else
			System.out.println("Você fez " + pontosJogador + " pontos. Agora é a vez da banca!");
		
		int pontosCpu = 0;
		cartaAtual = 0;
		
		do {
			System.out.println("A CPU vai sacar a carta!");
			Thread.sleep(2000);
			cartaAtual = baralho[proximaCarta++];
			System.out.println("A CPU sacou um " + cartaAtual);
			pontosCpu += cartaAtual;
			System.out.println("A pontuação da CPU é " + pontosCpu);
			
			if(pontosCpu > 21) {
				System.out.println("A CPU perdeu!");
				break;
			}else if(pontosCpu > pontosJogador) {
				System.out.println("A CPU ganhou!");
				break;
			}
		} while (true);

}

}