package projeto;

class Banco {
    public void transferir(Conta origem, Conta destino, double valor) {
        synchronized (this) {
            if (origem.sacar(valor)) {
                destino.depositar(valor);
                System.out.println("Transferência de R$" + valor + " realizada com sucesso.");
            } else {
                System.out.println("Falha na transferência de R$" + valor + ". Saldo insuficiente.");
            }
        }
    }
}