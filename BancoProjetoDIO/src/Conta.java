public abstract class Conta implements IConta {
    
    private static int SEQUENCIAL = 1;
    private static final int AGENCIA_PADRAO = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;  
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public boolean saque(double valor){
        if(valor <= saldo){
            saldo = saldo - valor;
            System.out.println("Saque de R$" + valor + ", Saldo atual: R$" + saldo);
            return true;
        }else{
            System.out.println("Saldo insuficiente!");
            return false;
        }
    }

    public void deposito(double valor){
        saldo = saldo + valor;
        System.out.println("Depósito de R$" + valor + ", Saldo atual: R$" + saldo);
    }

    public void tranferencia(double valor, Conta contaDestino){
        boolean saqueExecutado = saque(valor);
        if(saqueExecutado){
        contaDestino.deposito(valor);
        System.out.println("Transferência Realizada!");
    } else {
        System.out.println("Transferencia não realizada, Saldo Insuficiente!");
    }
}
    public int getAgencia() {
        return agencia;
    }
    public int getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }

    protected void ImprimirInfo(){
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
