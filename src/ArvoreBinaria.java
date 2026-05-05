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
            System.out.println(raiz.getConteudo());
        }
        else {
            //Inserção do lado esquerdo da raiz (números menores que ela)
            if (conteudo < raiz.getConteudo() && raiz.getEsquerda() == null) {
                No esquerda = new No(conteudo);
                raiz.setEsquerda(esquerda);
                System.out.println(esquerda.getConteudo());
            }
            //Inserção do lado direito da raiz (números maiores que ela)
            else if (conteudo > raiz.getConteudo() && raiz.getDireita() == null) {
                No direita = new No(conteudo);
                raiz.setDireita(direita);
                System.out.println(direita.getConteudo());
            }
            else {
                System.out.println("Não é possível adicionar esse nó!");
            }
        }
    }
}
