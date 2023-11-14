package arvore_Binaria_1;

public class NoArvore {

	int info;
	NoArvore direita = null;
	NoArvore esquerda = null;
	
	static void Imp_Ordem(NoArvore tree) { 
		if(tree != null) {
			Imp_Ordem(tree.esquerda);
			System.out.println(tree.info);
			Imp_Ordem(tree.direita);
		}
	}
	
	static void Imp_Pos(NoArvore tree) {
		if(tree != null) {
			Imp_Pos(tree.direita);
			Imp_Pos(tree.esquerda);
			System.out.println(tree.info);
		}
	}
	
	static void Imp_Pre(NoArvore tree) {
		if(tree != null) {
			System.out.println(tree.info);
			Imp_Pre(tree.esquerda);
			Imp_Pre(tree.direita);
		}
	}
	
	static NoArvore Search(NoArvore tree, int valor) {
		if(tree == null) {
			return null; //Chegou numa folha e não tem subarcos abaixo, ultimo elemento
		} else if(tree.info > valor) {
			return(Search(tree.esquerda, valor)); 
		} else if(tree.info < valor) {
			return(Search(tree.direita, valor));
		} else {
			return(tree);
		}
	}
	
	static NoArvore VerificaVazio(NoArvore tree) {
		if(tree == null) {
			return null;
		} else {
			return(tree);
		}
	}
	
	static NoArvore InsereRaiz(NoArvore tree, int valor) { //Arvóre vazia
		tree.info = valor;
		tree.direita = null;
		tree.esquerda = null;
		return(tree);
	}
	
	static NoArvore Insere(NoArvore tree, int valor) { 
		if(tree == null) {//Se arvore tiver vazia, vai criar um novo nó 
			tree = new NoArvore();
			tree.info = valor;
			tree.direita = null;
			tree.esquerda = null;
		} else if(valor < tree.info) { 
			tree.esquerda = Insere(tree.esquerda, valor); //pegar subarvore a esquerda, encontrar a posição correta
		} else {
			tree.direita = Insere(tree.direita, valor);
		}
	
		return(tree); //retorna a posição em que foi colocado
	}

	static NoArvore Retira(NoArvore tree, int valor) {
		if(tree == null) {
			System.out.println("Elemento não encontrado: " + valor);
			return(null);
		} else if(tree.info > valor) {
			tree.esquerda = Retira(tree.esquerda, valor);
		} else if(tree.info < valor) {
			tree.direita = Retira(tree.direita, valor);
		} else {
			//Nó sem filhos
			if((tree.esquerda == null) && (tree.direita == null)) {
				tree = null;
			} else if(tree.esquerda == null) {
				//Nó só tem filho a direita
				NoArvore novo = tree;
				tree = tree.direita; 
			} else if(tree.direita == null) {
				//Só tem filho a esquerda
				NoArvore novo = tree; //Novo receber o endereço da árvore
				tree = tree.esquerda; //Arvore recebe o elemento da esquerda
			} else {
				//Nó tem dois filhos
				//Logica do predecessor
				NoArvore novo = tree.esquerda;//primeira esquerda
				while(novo.direita != null) { //Depois toda a direita
					novo = novo.direita;
				}
				tree.info = novo.info; //Troca as informações de lugar de lugar
				novo.info = valor;// retira a referencia
			}
		}
		
		return(tree);
	}
	
}
