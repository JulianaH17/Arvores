public class ArvoreBinaria {
    No raiz;    //Necessário para iniciar a árvore (definir a raiz)

    public ArvoreBinaria() {
        this.raiz = new No(null);   //A raiz começa null
        System.out.println("Árvore binária criada com sucesso!");
    }

    public void inserir(Integer conteudo) {
        //Se o conteúdo da raiz for null, setamos o conteúdo passado como parâmetro como a raiz (início)
        if (this.raiz.getConteudo() == null) {
            this.raiz.setConteudo(conteudo);
            System.out.println("Raiz: " + raiz.getConteudo());
            return;
        }
        No atual = this.raiz;   //Criando um nó atual que recebe a raiz

        while (true) {  //Enquanto for verdadeiro
            if (conteudo < atual.getConteudo()) {   //Se o conteúdo passado como parâmetro for menor que o conteúdo atual

                if (atual.getEsquerda() == null) {      //Verificamos se a esquerda do nó atual está vazia
                    No esquerda = new No(conteudo);     //Criamos um novo nó (chamado esquerda)
                    atual.setEsquerda(esquerda);        //Conectamos o nó esquerda, na esquerda do nó atual
                    System.out.println("Nó esquerdo: " + esquerda.getConteudo());
                    break;
                }
                else {
                    atual = atual.getEsquerda();        //O nó atual vira esse nó esquerdo
                    System.out.println("Nó atual: " + atual.getConteudo());
                }
            }
            else if (conteudo > atual.getConteudo()) {  //Se o conteúdo passado como parâmetro for maior que o conteúdo atual

                if (atual.getDireita() == null) {       //Verifica se a direita do nó atual está vazia
                    No direita = new No(conteudo);      //Criamos um novo nó (chamado direita)
                    atual.setDireita(direita);          //Conectamos o nó direita, na direita do nó atual
                    System.out.println("Nó direito: " + direita.getConteudo());
                    break;
                }
                else {
                    atual = atual.getDireita();         //O nó atual vira esse nó direito
                    System.out.println("Nó atual: " + atual.getConteudo());
                }
            }
            else {
                System.out.println("Não foi possível adicionar esse nó: " + conteudo);
                break;
            }
        }
    }
}
