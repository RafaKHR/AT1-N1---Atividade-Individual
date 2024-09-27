package projeto;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Conta {
    private double saldo;
    private final Lock lock = new ReentrantLock();

    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        lock.lock();
        try {
            saldo += valor;
            System.out.println(Thread.currentThread().getName() + " depositou: R$" + valor);
        } finally {
            lock.unlock();
        }
    }

    public boolean sacar(double valor) {
        lock.lock();
        try {
            if (saldo >= valor) {
                saldo -= valor;
                System.out.println(Thread.currentThread().getName() + " sacou: R$" + valor);
                return true;
            } else {
                System.out.println(Thread.currentThread().getName() + " tentou sacar: R$" + valor + " mas saldo insuficiente.");
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    public double getSaldo() {
        return saldo;
    }
}