package projeto;

public class SistemaBancario {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Loja loja1 = new Loja("Loja 1", banco);
        Loja loja2 = new Loja("Loja 2", banco);

        Funcionario func1 = new Funcionario("Funcionário 1", loja1, banco);
        Funcionario func2 = new Funcionario("Funcionário 2", loja1, banco);
        Funcionario func3 = new Funcionario("Funcionário 3", loja2, banco);
        Funcionario func4 = new Funcionario("Funcionário 4", loja2, banco);

        loja1.adicionarFuncionario(func1);
        loja1.adicionarFuncionario(func2);
        loja2.adicionarFuncionario(func3);
        loja2.adicionarFuncionario(func4);

        Cliente[] clientes = new Cliente[10];
        for (int i = 0; i < 10; i++) {
            clientes[i] = new Cliente("Cliente " + (i + 1), loja1, loja2, banco);
        }

        func1.start();
        func2.start();
        func3.start();
        func4.start();

        for (Cliente cliente : clientes) {
            cliente.start();
        }

        for (Cliente cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Saldo final da loja 1: R$" + loja1.getConta().getSaldo());
        System.out.println("Saldo final da loja 2: R$" + loja2.getConta().getSaldo());
        System.out.println("Saldo final do funcionário 1 (salário): R$" + func1.getContaSalario().getSaldo());
        System.out.println("Saldo final do funcionário 2 (salário): R$" + func2.getContaSalario().getSaldo());
        System.out.println("Saldo final do funcionário 3 (salário): R$" + func3.getContaSalario().getSaldo());
        System.out.println("Saldo final do funcionário 4 (salário): R$" + func4.getContaSalario().getSaldo());
    }
}