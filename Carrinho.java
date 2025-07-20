import java.util.HashMap;
import java.util.Map;

class Carrinho {
    private Map<Produto, Integer> itens = new HashMap<>();

    public void adicionarItem(Produto produto, int quantidade) {
        itens.put(produto, itens.getOrDefault(produto, 0) + quantidade);
        System.out.println(quantidade + " unidades de " + produto.getNome() + " adicionadas ao carrinho.");
    }

    public double calcularTotal() {
        double total = 0;
        for (Map.Entry<Produto, Integer> item : itens.entrySet()) {
            total += item.getKey().getPreco() * item.getValue();
        }
        return total;
    }

    public boolean finalizarCompra() {
        Estoque estoque = Estoque.getInstancia();

        // Verificar estoque suficiente para todos os itens
        for (Map.Entry<Produto, Integer> item : itens.entrySet()) {
            int estoqueDisp = estoque.consultarQuantidade(item.getKey());
            if (estoqueDisp < item.getValue()) {
                System.out.println("Estoque insuficiente para o produto: " + item.getKey().getNome());
                return false;
            }
        }

        // Deduzir do estoque
        for (Map.Entry<Produto, Integer> item : itens.entrySet()) {
            estoque.removerProduto(item.getKey(), item.getValue());
        }

        // Adicionar ao caixa
        Caixa caixa = Caixa.getInstancia();
        caixa.adicionarDinheiro(calcularTotal());

        System.out.println("Compra finalizada. Total pago: R$ " + calcularTotal());
        itens.clear();
        return true;
    }
}
