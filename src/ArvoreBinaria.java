public class ArvoreBinaria {
    No raiz;    //Necessário para iniciar a árvore (definir a raiz)

    public ArvoreBinaria() {
        this.raiz = new No(null);   //A raiz começa null
        System.out.println("Árvore binária criada com sucesso!\n");
    }

    /**
     * Métod0 {@code inserirIterativo} que insere um novo elemento (do tipo {@code Integer}) na árvore binária de forma iterativa.
     * <p>
     * O métod0 percorre a árvore comparando o valor informado com os nós existentes:
     * <ul>
     *     <li>Se o valor for menor que o nó atual, segue para a subárvore esquerda.</li>
     *     <li>Se o valor for maior que o nó atual, segue para a subárvore direita.</li>
     *     <li>Se o valor já existir na árvore, o elemento não é inserido.</li>
     * </ul>
     * Caso a árvore esteja vazia, o valor informado será definido como raiz.
     *
     * @param conteudo Valor inteiro que será inserido na árvore.
     */
    public void inserirIterativo(Integer conteudo) {
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
                    System.out.println("\nNó atual: " + atual.getConteudo());
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
                    System.out.println("\nNó atual: " + atual.getConteudo());
                }
            }
            else {
                System.out.println("Não foi possível adicionar esse nó: " + conteudo);
                break;
            }
        }
    }

    public void inserirRecursivo(Integer conteudo) {
        No novoNo = new No(conteudo);

        if (this.raiz.getConteudo() == null) {
            this.raiz = novoNo;        //Caso o elemento inserido seja o primeiro da árvore, ele é definido como raiz
            System.out.println("Raiz: " + raiz.getConteudo());
        }
        else {                                  //Se ele não for o primeiro:
            inserirR(novoNo, this.raiz);        //Chamada do métod0 recursivo p/ inserir
        }
    }

    /**
     * Métod0 {@code inserirR} que faz parte do métod0 {@code inserirRecursivo}, onde é inserido um novo
     * elemento (do tipo {@code Integer}) na árvore binária de forma recursiva (chamando a si mesma).
     <p>
     * O métod0 compara o conteúdo do novo nó com o nó atual.
     * <ul>
     *      <li>Se o valor for menor, a inserção é realizada na subárvore esquerda.</li>
     *      <li>Se o valor for maior, a inserção é realizada na subárvore direita.</li>
     *      <li>Caso já exista um nó com o mesmo valor, a inserção não é realizada.</li>
     * </ul>
     * Caso a árvore esteja vazia, o valor informado será definido como raiz.
     *
     * @param novoNo nó que será inserido na árvore.
     * @param atual nó atual utilizado como referência durante a navegação recursiva.
     */
    public void inserirR(No novoNo, No atual) {
        if (novoNo.getConteudo() < atual.getConteudo()) {       //Se o conteúdo do novoNo for menor que o conteúdo do nó atual
            if (atual.getEsquerda() == null) {                  //E se a esquerda do nó atual estiver vazia
                atual.setEsquerda(novoNo);                      //Setamos a esquerda do nó atual para o conteúdo inserido
                System.out.println("\nNó atual: " + atual.getConteudo());
                System.out.println("Nó esquerdo: " + novoNo.getConteudo());
                return;
            }
            else {
                inserirR(novoNo, atual.getEsquerda());          //Chamada do métod0 recursivo caso a esquerda do nó atual não esteja vazia
            }
        }
        else if (novoNo.getConteudo() > atual.getConteudo()) {  //Caso o conteúdo do novoNo seja maior que o conteúdo do nó atual
            if (atual.getDireita() == null) {                   //E se a direita do nó atual estiver vazia
                atual.setDireita(novoNo);                       //Setamos a direita do nó atual para o conteúdo inserido
                System.out.println("\nNó atual: " + atual.getConteudo());
                System.out.println("Nó direito: " + novoNo.getConteudo());
                return;
            }
            else {
                inserirR(novoNo, atual.getDireita());           //Chamada do métod0 recursivo caso a esquerda do nó atual não estiver vazia
            }
        }
        else {
            System.out.println("Não foi possível adicionar esse nó: " + novoNo.getConteudo());
        }
    }
}
