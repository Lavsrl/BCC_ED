package arvore_Binaria_1;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		int valores;
		NoArvore noArvore = new NoArvore();

		for(int i = 0; i < 20; i++) {
			valores = random.nextInt(101);
			if(NoArvore.VerificaVazio(noArvore) == null) {
				NoArvore.InsereRaiz(noArvore, valores);
			} else {
				NoArvore.Insere(noArvore, valores);
			}
			
		}
		
		System.out.println("Sequência de pré-ordem: ");
		NoArvore.Imp_Pre(noArvore);
		
		System.out.println("____");
		System.out.println("Sequência em-ordem:");
		NoArvore.Imp_Ordem(noArvore);
		
		System.out.println("____");
		System.out.println("Sequência de pós-ordem:");
		NoArvore.Imp_Pos(noArvore);
		System.out.println("____");
		
		for(int i = 0; i < 5; i++) {
			int valoresRetirados = random.nextInt(101);
			while (NoArvore.Search(noArvore, valoresRetirados) == null) {
				valoresRetirados = random.nextInt(101);
			}
			NoArvore.Retira(noArvore, valoresRetirados);
		}
		
		System.out.println("5 elementos retirados da árvore...");
		System.out.println("Sequência de pré-ordem: ");
		NoArvore.Imp_Pre(noArvore);
		
		System.out.println("____");
		System.out.println("Sequência em-ordem:");
		NoArvore.Imp_Ordem(noArvore);
		
		System.out.println("____");
		System.out.println("Sequência de pós-ordem:");
		NoArvore.Imp_Pos(noArvore);
	}

}
