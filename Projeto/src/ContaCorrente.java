package dio_project;

public class ContaCorrente extends Contas implements IConta {

	protected double saldoCC;

	public ContaCorrente(String nome, long cpf) {
		super(nome, cpf);
	}

	public void depositar(double valorDeposito) {
		saldoCC += valorDeposito;
	}

	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
		System.out.println(String.format("Saldo Conta Corrente: %.2f", this.saldoCC));
	}

	public void sacar(double valorSaque) {
		saldoCC -= valorSaque;
	}

	public void transferir(double valorTransferencia, Contas contaDestino) {
		this.sacar(valorTransferencia);
		contaDestino.depositar(valorTransferencia);
		}
		
}
