public class LojaApp {
    public static void main(String[] args) {
        Estoque estoque = Estoque.getInstancia();

        Produto arroz = new Produto("Arroz", 5.00);
        Produto feijao = new Produto("Feijão", 7.50);
        Produto leite = new Produto("Leite", 3.20);

        estoque.adicionarProduto(arroz, 10);
        estoque.adicionarProduto(feijao, 5);
        estoque.adicionarProduto(leite, 20);

        Carrinho carrinhoCliente = new Carrinho();

        carrinhoCliente.adicionarItem(arroz, 2);
        carrinhoCliente.adicionarItem(feijao, 1);
        carrinhoCliente.adicionarItem(leite, 5);

        boolean compraOk = carrinhoCliente.finalizarCompra();

        if(compraOk) {
            System.out.println("Saldo no caixa após compra: R$ " + Caixa.getInstancia().consultarSaldo());
            System.out.println("Estoque restante de arroz: " + estoque.consultarQuantidade(arroz));
        }
    }
}
