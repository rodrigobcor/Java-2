package dio_project;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Contas[] contacc = new ContaCorrente[99999];
		Contas[] contacp = new ContaPoupanca[99999];

		int opcao;
		int contadorContas;
		do {
			System.out.println("MENU");
			System.out.println("1. NOVO CLIENTE");
			System.out.println("2. ACESSAR CONTA");
			System.out.println("0. SAIR");
			System.out.printf("Selecione a Opcao: ");
			opcao = sc.nextInt();
			contadorContas = 1;
			if (opcao == 1) {
				System.out.printf("Insira o nome do cliente: ");
				sc.nextLine();
				String nome = sc.nextLine();
				System.out.printf("Insira o CPF do cliente (sem ponto e traco): ");
				long cpf = sc.nextLong();
				contacc[contadorContas] = new ContaCorrente(nome, cpf);
				System.out.printf(String.format("Conta Corrente numero: %d%n", contacc[contadorContas].getNumero()));
				System.out.printf(String.format("Senha temporaria: %s%n", contacc[contadorContas].senha));				
				System.out.printf("Tambem deseja Conta Poupanca? (y/n): ");
				char temContaPoupanca = sc.next().charAt(0);
				if (temContaPoupanca == 'y') {
					System.out.printf("Insira deposito inicial obrigatorio: ");
					double depositoInicial = sc.nextDouble();
					contacp[contadorContas] = new ContaPoupanca(nome, cpf, depositoInicial);
				}
				System.out.println();
				contadorContas++;
			} else if (opcao == 2) {
				System.out.printf("Insira o numero da conta: ");
				int numeroConta = sc.nextInt();
				System.out.printf("Insira a senha: ");
				sc.nextLine();
				String testeSenha = sc.nextLine();
				if (contacc[numeroConta].verificarSenha(testeSenha, 1)) {
					do {
						System.out.println();
						System.out.println("MENU (2)");
						System.out.println("1. DEPOSITO");
						System.out.println("2. SAQUE");
						System.out.println("3. TRANSFERENCIA");
						System.out.println("4. EXTRATO");
						System.out.println("5. MUDAR SENHA");
						System.out.println("9. MENU ANTERIOR");
						System.out.printf("Selecione a Opcao: ");
						opcao = sc.nextInt();
						switch (opcao) {
						case 1:
							System.out.printf("Conta Corrente(cc) ou Poupanca(cp)? ");
							sc.nextLine();
							String qualConta = sc.nextLine();
							System.out.printf("Valor a Depositar: ");
							double valorDeposito = sc.nextInt();
							if (qualConta.equals("cc")) {
								contacc[numeroConta].depositar(valorDeposito);
							} else if (qualConta.equals("cp")) {
								contacp[numeroConta].depositar(valorDeposito);
							}
							contacc[numeroConta].imprimirExtrato();
							contacp[numeroConta].imprimirExtrato();
							continue;
						case 2:
							System.out.printf("Conta Corrente(cc) ou Poupanca(cp)? ");
							sc.nextLine();
							qualConta = sc.nextLine();
							System.out.printf("Valor a Sacar: ");
							double valorSaque = sc.nextInt();
							if (qualConta.equals("cc")) {
								contacc[numeroConta].sacar(valorSaque);
							} else if (qualConta.equals("cp")) {
								contacp[numeroConta].sacar(valorSaque);
							}
							contacc[numeroConta].imprimirExtrato();
							contacp[numeroConta].imprimirExtrato();
							continue;
						case 3:
							System.out.printf("Conta Corrente(cc) ou Poupanca(cp)? ");
							sc.nextLine();
							qualConta = sc.nextLine();
							System.out.printf("Conta Corrente de Destino: ");
							int contaDestino = sc.nextInt();
							System.out.printf("Valor a Transferir: ");
							double valorTransferencia = sc.nextInt();
							if (qualConta.equals("cc")) {
								contacc[numeroConta].transferir(valorTransferencia, contacc[contaDestino]);
							} else if (qualConta.equals("cp")) {
								contacp[numeroConta].transferir(valorTransferencia, contacc[contaDestino]);
							}
							contacc[numeroConta].imprimirExtrato();
							contacp[numeroConta].imprimirExtrato();
							continue;
						case 4:
							System.out.printf("Conta Corrente(cc) ou Poupanca(cp)? ");
							sc.nextLine();
							qualConta = sc.nextLine();
							if (qualConta.equals("cc")) {
								contacc[numeroConta].imprimirExtrato();
							} else if (qualConta.equals("cp")) {
								contacp[numeroConta].imprimirExtrato();
							}					
							continue;
						case 5:
							System.out.println("Insira a senha: ");
							sc.nextLine();
							testeSenha = sc.nextLine();
							if (contacc[numeroConta].verificarSenha(testeSenha, 1)) {
								System.out.printf("Insira a Nova Senha: ");
								sc.nextLine();
								String novaSenha = sc.nextLine();
								contacc[numeroConta].novaSenha(novaSenha);
							}
						case 9:
							System.out.println();
							opcao = 9;
							continue;
						default:
							System.out.printf("Opcao invalida. Selecione Novamente: ");
							continue;
						}
					} while (opcao != 9);	
				} else {
					opcao = 0;
				}	
			} else if (opcao != 0){
				System.out.printf("Opcao Invalida. Selecione Novamente: ");
				opcao = sc.nextInt();
			}
		} while (opcao != 0);
		System.out.println();
		System.out.println("FIM");

		sc.close();
	}
}
