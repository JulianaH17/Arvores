public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
        System.out.println("Árvore binária criada com sucesso!");
    }

    public void inserir(Integer conteudo) {
        if (this.raiz.getConteudo() == null) {
            this.raiz.setConteudo(conteudo);
            System.out.println(raiz.getConteudo());
        }
        else {
            if (conteudo < raiz.getConteudo()) {
                No esquerda = new No(conteudo);
                System.out.println(esquerda.getConteudo());
            }
            else if (conteudo > raiz.getConteudo()) {
                No direita = new No(conteudo);
                System.out.println(direita.getConteudo());
            }
            else {
                System.out.println("Não é possível adicionar esse nó!");
            }
        }
    }
}
