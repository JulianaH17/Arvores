public class MainIterativo {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.inserirIterativo(5);
        arvoreBinaria.inserirIterativo(3);
        arvoreBinaria.inserirIterativo(7);
        arvoreBinaria.inserirIterativo(9);
        arvoreBinaria.inserirIterativo(4);
        arvoreBinaria.inserirIterativo(6);
        arvoreBinaria.inserirIterativo(1);

        arvoreBinaria.exibirPercursos("1");
        arvoreBinaria.exibirPercursos("2");
        arvoreBinaria.exibirPercursos("3");
    }
}
