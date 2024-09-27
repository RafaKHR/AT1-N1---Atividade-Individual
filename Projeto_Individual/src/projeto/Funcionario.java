package projeto;

class Funcionario extends Thread {
    private final Conta contaSalario;
    private final Conta contaInvestimento;
    private final Loja loja;
    private final Banco banco;

    public Funcionario(String nome, Loja loja, Banco banco) {
        super(nome);
        this.contaSalario = new Conta(0);
        this.contaInvestimento = new Conta(0);
        this.loja = loja;
        this.banco = banco;
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public void investir() {
        double investimento = contaSalario.getSaldo() * 0.2;
        banco.transferir(contaSalario, contaInvestimento, investimento);
        System.out.println(getName() + " investiu: R$" + investimento);
    }

    @Override
    public void run() {
        while (true) {
            loja.pagarFuncionarios();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}