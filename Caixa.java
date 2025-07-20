import java.util.HashMap;
import java.util.Map;

class Caixa {
    private static Caixa instancia = new Caixa();
    private double saldo;

    private Caixa() {
        saldo = 0.0;
    }

    public static Caixa getInstancia() {
        return instancia;
    }

    public void adicionarDinheiro(double valor) {
        saldo += valor;
        System.out.println("R$ " + valor + " adicionados ao caixa.");
    }

    public double consultarSaldo() {
        return saldo;
    }
}
