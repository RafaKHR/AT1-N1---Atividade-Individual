package projeto;

import java.util.ArrayList;
import java.util.List;

class Loja {
    private final Conta conta;
    private final String nome;
    private final Banco banco;
    private final List<Funcionario> funcionarios = new ArrayList<>();

    public Loja(String nome, Banco banco) {
        this.conta = new Conta(0);
        this.nome = nome;
        this.banco = banco;
    }
    
    public String getNome() {
        return nome;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void realizarCompra(Cliente cliente, double valor) {
        banco.transferir(cliente.getConta(), this.conta, valor);
    }

    public void pagarFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            if (conta.getSaldo() >= 1400) {
                banco.transferir(this.conta, funcionario.getContaSalario(), 1400);
                funcionario.investir();
            }
        }
    }

    public Conta getConta() {
        return conta;
    }
}