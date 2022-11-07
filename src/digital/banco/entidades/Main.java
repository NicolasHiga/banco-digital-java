package digital.banco.entidades;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float valor;
        Scanner str = new Scanner(System.in);

        Cliente nicolas = new Cliente();
        nicolas.setNome("Nicolas");

        Conta cc = new ContaCorrente(nicolas);

        Conta cp = new ContaPoupanca(nicolas);

        System.out.println("Bem-vindo, " + nicolas.getNome() + "\n");
        System.out.println("Acessar: ");
        System.out.println("[1] Conta corrente\n" +
                            "[2] Conta poupanca\n" +
                            "[0] Sair");

        String choice = str.next();
        if (choice != "0") {
            //Runtime.exec("cls"); // windows
            String op = null;
            while (op != "0") {
                System.out.println("\nEscolha uma opção: ");
                System.out.println("[1] Sacar\n" +
                        "[2] Depositar\n" +
                        "[3] Transferir\n" +
                        "[4] Imprimir extrato\n" +
                        "[0] Sair");
                op = str.next();
                switch (op) {
                    case "1":
                        System.out.println("Sacar:\nR$");
                        valor = str.nextFloat();
                        if (choice == "1") {
                            cc.sacar(valor);
                        } else {
                            cp.sacar(valor);
                        }
                        break;
                    case "2":
                        System.out.println("Depositar:\nR$");
                        valor = str.nextFloat();
                        if (choice == "1") {
                            cc.depositar(valor);
                        } else {
                            cp.depositar(valor);
                        }
                        break;
                    case "3":
                        System.out.println("Transferir:\nR$");
                        valor = str.nextFloat();
                        if (choice == "1") {
                            cc.transferir(valor, cp);
                        } else {
                            cp.transferir(valor, cp);
                        }
                        break;
                    case "4":
                        if (choice == "1") {
                            cc.imprimirExtrato();
                        } else {
                            cp.imprimirExtrato();
                        }
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            }
        }

    }
}
