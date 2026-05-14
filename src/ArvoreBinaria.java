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

    //Percursos nas árvores binárias

    private void preOrdem(No no) {          //Percurso 1
        if (no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    private void emOrdem(No no) {           //Percurso 2
        if (no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    private void posOrdem(No no) {          //Percurso 3
        if (no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }

    /**
     * Métod0 {@code exibirPercursos} que funciona como um encapsulamento dos métod0s privados
     * {@code preOrdem}, {@code emOrdem} e {@code posOrdem}.
     * <p>
     *     Ao ser informado o número correspondente ao percurso:
     *     <ol>
     *         <li>preOrdem</li>
     *         <li>emOrdem</li>
     *         <li>posOrdem</li>
     *     </ol>
     *     Ele retornará a sequência correspondente.
     * </p>
     * @param percurso percurso que será informado pelo usuário.
     */
    public void exibirPercursos(String percurso) {
        switch (percurso){
            case("1"):
                System.out.println("\n===== PRÉ ORDEM =====");
                preOrdem(this.raiz);
                break;
            case("2"):
                System.out.println("\n===== EM ORDEM =====");
                emOrdem(this.raiz);
                break;
            case("3"):
                System.out.println("\n===== PÓS ORDEM =====");
                posOrdem(this.raiz);
                break;
        }
    }

    private No buscarNo(int procurado, No atual) {
        if (atual == null) {
            return null;
        }
        if (procurado == atual.getConteudo()) {         //Se o nó atual for igual ao valor que estamos buscando
            System.out.println("\nNó encontrado: " + procurado);
            return atual;                               //Ele retorna o Nó
        }
        else if (procurado < atual.getConteudo()) {     //Se o valor procurado for menor que o conteúdo do nó atual
            buscarNo(procurado, atual.getEsquerda());   //Busca recursiva pra esquerda
        }
        else {
            buscarNo(procurado, atual.getDireita());    //Caso não seja nenhuma dessas condicionais, busca recursiva pra direita
        }
        return null;
    }

    private No buscarPaiNo (int procurado, No atual) {
        if (atual == null) {        //Caso o nó atual seja nulo, apenas retornamos null
            return null;
        }
        if (atual.getEsquerda() != null && procurado == atual.getEsquerda().getConteudo()) {    //Verifica se o filho esquerdo existe e se ele é o procurado
            System.out.println("\nPai encontrado: " + atual.getConteudo());                     //Encontramos o nó pai
            return atual;                                                                       //Retornamos o nó pai do nó procurado
        }
        if (atual.getDireita() != null && procurado == atual.getDireita().getConteudo()) {     //Verifica se o filho direito existe e se ele é o procurado
            System.out.println("\nPai encontrado: " + atual.getConteudo());                    //Encontramos o nó pai
            return atual;                                                                      //Retornamos o nó pai do nó procurado
        }
        if (procurado < atual.getConteudo()) {      //Caso o valor procurado seja menor do que o atual
            return buscarPaiNo(procurado, atual.getEsquerda());     //Busca recursiva para esquerda
        }
        else {                                      //Caso o valor procurado seja maior que o atual
            return buscarPaiNo(procurado, atual.getDireita());      //Busca recursiva para direita
        }
    }


    public void buscar(Integer valor){
        buscarNo(valor, this.raiz);
    }

    public void buscarPai(Integer valor){
        buscarPaiNo(valor, this.raiz);
    }
    //buscar -> classificar o tipo de nó -> remover de acordo com a classificação
}
