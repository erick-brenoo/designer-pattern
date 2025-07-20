import java.util.HashMap;
import java.util.Map;

class Estoque {
    private static Estoque instancia = new Estoque();

    // Mapa do produto para quantidade disponível
    private Map<Produto, Integer> produtos = new HashMap<>();

    private Estoque() {}

    public static Estoque getInstancia() {
        return instancia;
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        produtos.put(produto, produtos.getOrDefault(produto, 0) + quantidade);
        System.out.println(quantidade + " unidades de " + produto.getNome() + " adicionadas ao estoque.");
    }

    public boolean removerProduto(Produto produto, int quantidade) {
        int estoqueAtual = produtos.getOrDefault(produto, 0);
        if (estoqueAtual >= quantidade) {
            produtos.put(produto, estoqueAtual - quantidade);
            return true;
        }
        return false;
    }

    public int consultarQuantidade(Produto produto) {
        return produtos.getOrDefault(produto, 0);
    }
}
