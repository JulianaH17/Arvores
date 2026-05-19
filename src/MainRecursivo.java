public class MainRecursivo {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.inserirRecursivo(5);
        arvoreBinaria.inserirRecursivo(3);
        arvoreBinaria.inserirRecursivo(7);
        arvoreBinaria.inserirRecursivo(9);
        arvoreBinaria.inserirRecursivo(4);
        arvoreBinaria.inserirRecursivo(6);
        arvoreBinaria.inserirRecursivo(1);
        arvoreBinaria.inserirRecursivo(2);
        arvoreBinaria.inserirRecursivo(8);

//        arvoreBinaria.exibirPercursos("1");
//        arvoreBinaria.exibirPercursos("2");
//        arvoreBinaria.exibirPercursos("3");

//        arvoreBinaria.buscar(7);
//        arvoreBinaria.buscarPai(6);

//        arvoreBinaria.identificadorNo(9);
//        arvoreBinaria.removerFolha(2);
//        arvoreBinaria.removerFilhoEsquerda(9);

//        arvoreBinaria.identificadorNo(1);
//        arvoreBinaria.removerFilhoDireito(1);
//        arvoreBinaria.exibirPercursos("2");
//        arvoreBinaria.removerDoisFilhos(7);
//        arvoreBinaria.exibirPercursos("2");

        arvoreBinaria.identificadorNo(2);
        arvoreBinaria.identificadorNo(3);
        arvoreBinaria.remover(2);
        arvoreBinaria.remover(3);
        arvoreBinaria.exibirPercursos("2");
    }
}
