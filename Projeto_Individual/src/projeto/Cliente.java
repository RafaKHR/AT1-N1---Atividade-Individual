package projeto;

import java.util.Random;

public class Cliente extends Thread {
    private final Conta conta;
    private final Loja loja1;
    private final Loja loja2;
    private final Banco banco;
    private final Random random = new Random();

    public Cliente(String nome, Loja loja1, Loja loja2, Banco banco) {
        super(nome);
        this.conta = new Conta(2000);
        this.loja1 = loja1;
        this.loja2 = loja2;
        this.banco = banco;
    }

    public Conta getConta() {
        return conta;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            double valorCompra = 200 + random.nextDouble() * 300;
            banco.transferir(this.conta, loja1.getConta(), valorCompra);
            System.out.println(this.getName() + " fez uma compra de R$" + valorCompra + " na " + loja1.getNome());

            valorCompra = 200 + random.nextDouble() * 300;
            banco.transferir(this.conta, loja2.getConta(), valorCompra);
            System.out.println(this.getName() + " fez uma compra de R$" + valorCompra + " na " + loja2.getNome());
        }
    }
}