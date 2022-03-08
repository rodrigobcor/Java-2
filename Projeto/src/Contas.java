package dio_project;

public abstract class Contas {

	private static final int AGENCIA_PADRAO = 0001;
	private static int SEQUENCIAL = 00001;

	protected String nome;
	protected long cpf;
	protected int agencia;
	protected int numero;
	protected String senha;

	public Contas(String nome, long cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.agencia = Contas.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.senha = Long.toHexString(cpf);
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.nome));
		System.out.println(String.format("CPF: %s", this.cpf));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
	}
	
	public String getNome() {
		return nome;
	}

	public long getCpf() {
		return cpf;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}
	
	public boolean verificarSenha(String senha, int tentativas) {
		if (this.senha.equals(senha)) {
			System.out.println("Senha Correta!");
		} else if (tentativas == 4){
			System.out.println("Fim das tentativas");
			return false;
		} else {
			System.out.printf("Senha invalida. Tente novamente: ");
			verificarSenha(senha, tentativas + 1);
		}
		return true;
	}
	
	public void novaSenha(String novaSenha) {
		this.senha = novaSenha;
	}
	
	protected abstract void depositar(double valorDeposito);
	
	protected abstract void sacar(double valorSaque);
	
	protected abstract void imprimirExtrato();

	protected abstract void transferir(double valorTransferencia, Contas contas);

}
