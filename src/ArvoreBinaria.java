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
    private void inserirR(No novoNo, No atual) {
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

    /**
     * Métod0 {@code buscarNo} que procura o nó informado pelo usuário dentro da Árvore Binária utilizando
     * chamadas recursivas:
     * <ul>
     *     <li>Valores menores seguem para a esquerda.</li>
     *     <li>Valores maiores seguem para a direita.</li>
     * </ul>
     * @param procurado valor do nó que será buscado.
     * @param atual nó atual da busca recursiva.
     * @return o nó encontrado ou null caso não exista.
     */
    private No buscarNo(int procurado, No atual) {
        if (atual == null) {
            System.out.println("\nNão foi possível encontrar o nó: " + procurado + ", na Árvore!");
            return null;
        }
        if (procurado == atual.getConteudo()) {         //Se o nó atual for igual ao valor que estamos buscando
            System.out.println("\nNó encontrado: " + procurado);
            return atual;                               //Ele retorna o Nó
        }
        else if (procurado < atual.getConteudo()) {     //Se o valor procurado for menor que o conteúdo do nó atual
            return buscarNo(procurado, atual.getEsquerda());   //Busca recursiva pra esquerda
        }
        else {
            return buscarNo(procurado, atual.getDireita());    //Caso não seja nenhuma dessas condicionais, busca recursiva pra direita
        }
    }

    /**
     * Métod0 {@code buscarPaiNo} que busca o nó pai de um valor informado na Árvore Binária.
     * <p>
     *    O métod0 percorre recursivamente a árvore verificando se o valor procurado corresponde ao filho esquerdo ou direito do nó atual.
     * </p>
     * @param procurado valor do nó cujo o pai será procurado.
     * @param atual nó atual que será utilizado na busca recursiva.
     * @return o nó pai do valor procurado ou null caso ele não exista/não possua pai.
     */
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

    //Métod0s para instanciar na Main (teste)

    public void buscar(Integer valor){
        buscarNo(valor, this.raiz);
    }

    public void buscarPai(Integer valor){
        buscarPaiNo(valor, this.raiz);
    }

    /**
     * Métod0 {@code identificadorDeNo} que identifica o tipo de nó informado, dentro da Árvore Binária, a partir
     * da quantidade de filhos que ele possui.
     * <p>
     *     O métod0 verifica se:
     * </p>
     * <ul>
     *     <li>O nó é folha (não possui filhos).</li>
     *     <li>Se possui apenas um filho à esquerda.</li>
     *     <li>Se possui apenas um filho à direita.</li>
     *     <li>Se possui dois filhos.</li>
     * </ul>
     * @param procurado nó que será identificado.
     * @param atual nó atual que será utilizado na busca recursiva.
     * @return o nó identificado ou null caso o valor não exista na árvore
     */
    private No identificadorDeNo(int procurado, No atual) {
        No noEncontrado = buscarNo(procurado, atual);       //Busco o nó
            if (noEncontrado != null) {                     //Verifico se ele não é nulo
                if (noEncontrado.getEsquerda() == null && noEncontrado.getDireita() == null) {          //Nó sem filhos (nó folha)
                    System.out.println("Este nó é folha! Ele não possui nenhum filho.");
                    return noEncontrado;
                }
                else if (noEncontrado.getEsquerda() != null && noEncontrado.getDireita() == null) {     //Nó com um filho (apenas à esquerda)
                    System.out.println("Este nó possui filho à esquerda: " + noEncontrado.getEsquerda().getConteudo());
                    return noEncontrado;
                }
                else if (noEncontrado.getEsquerda() == null && noEncontrado.getDireita() != null) {     //Nó com um filho (apenas à direita)
                    System.out.println("Este nó possui filho à direita: " + noEncontrado.getDireita().getConteudo());
                    return noEncontrado;
                }
                else {                                                                                  //Nó com dois filhos
                    System.out.println("Este nó possui dois filhos: " + noEncontrado.getEsquerda().getConteudo() + " (esquerda) e " +
                            noEncontrado.getDireita().getConteudo() + " (direita)");
                    return noEncontrado;
                }
            }
        return null;
    }

    //Métod0 para instanciar na Main (teste)

    public void identificadorNo(Integer valor){
        identificadorDeNo(valor, this.raiz);
    }

    private void removerFolha(int procurado, No noEncontrado) {
        No paiDaFolha = buscarPaiNo(procurado, noEncontrado);

        if(paiDaFolha == null) {
            System.out.println("Nó folha: " + noEncontrado.getConteudo() + " removido com sucesso!");
            this.raiz = null;                                       //Caso a folha seja a raiz
        }
        else if (paiDaFolha.getEsquerda() == noEncontrado) {        //Caso a folha esteja a esquerda do pai
            System.out.println("Nó folha: " + noEncontrado.getConteudo() + " removido com sucesso!");
            paiDaFolha.setEsquerda(null);
        }
        else {                                                      //Caso a folha esteja a direita do pai
            System.out.println("Nó folha: " + noEncontrado.getConteudo() + " removido com sucesso!");
            paiDaFolha.setDireita(null);
        }
    }

    private void removerFilhoEsquerdo(int procurado, No noEncontrado) {
        No paiDoNo = buscarPaiNo(procurado, noEncontrado);

        if(paiDoNo == null) {
            System.out.println("Nó com filho à esquerda: " + noEncontrado.getConteudo() + " removido com sucesso!");
            this.raiz = noEncontrado.getEsquerda();                 //Caso o nó que queremos remover seja a raiz, a raiz se tornará o filho esquerdo
        }
        else if (paiDoNo.getEsquerda() == noEncontrado) {           //Caso o nó removido esteja a esquerda do pai
            System.out.println("Nó com filho à esquerda: " + noEncontrado.getConteudo() + " removido com sucesso!");
            paiDoNo.setEsquerda(noEncontrado.getEsquerda());
        }
        else {
            System.out.println("Nó com filho à esquerda: " + noEncontrado.getConteudo() + " removido com sucesso!");
            paiDoNo.setDireita(noEncontrado.getEsquerda());         //Caso o nó removido esteja a direita do pai
        }
    }

    private void removerFilhoDireita(int procurado, No noEncontrado) {
        No paiDoNo = buscarPaiNo(procurado, noEncontrado);

        if (paiDoNo == null) {
            System.out.println("Nó com filho à direita: " + noEncontrado.getConteudo() + " removido com sucesso!");
            this.raiz = noEncontrado.getDireita();                  //Caso o nó que queremos remover seja a raiz, pegamos o sucessor dele
        }
        else if (paiDoNo.getEsquerda() == noEncontrado) {           //Caso o nó removido esteja a esquerda do pai
            System.out.println("Nó com filho à direita: " + noEncontrado.getConteudo() + " removido com sucesso!");
            paiDoNo.setEsquerda(noEncontrado.getDireita());         //Setamos o pai do nó removido para apontar para o filho direito do nó removido
        }
        else {
            System.out.println("Nó com filho à direita: " + noEncontrado.getConteudo() + " removido com sucesso!");
            paiDoNo.setDireita(noEncontrado.getDireita());          //Caso o nó removido estaja a direita do pai
        }
    }

    public void removerFolha(Integer valor){
        No noEncontrado = buscarNo(valor, this.raiz);
        removerFolha(valor, noEncontrado);
    }
}
