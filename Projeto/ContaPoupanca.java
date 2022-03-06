package dio_project;

public class ContaPoupanca extends Contas implements IConta {
	
	protected double saldoCP;

	public ContaPoupanca(String nome, long cpf, double depositoInicial) {
		super(nome, cpf);
		this.saldoCP += depositoInicial;
	}

	public void depositar(double valorDeposito) {
		saldoCP += valorDeposito;
	}

	
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupança ===");
		super.imprimirInfosComuns();
		System.out.println(String.format("Saldo Conta Poupanca: %.2f", this.saldoCP));
	}

	public void sacar(double valorSaque) {
		saldoCP -= valorSaque;
	}

	public void transferir(double valorTransferencia, Contas contaDestino) {	
		this.sacar(valorTransferencia);
		contaDestino.depositar(valorTransferencia);
	}

}
