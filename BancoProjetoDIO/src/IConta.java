public interface IConta {

    boolean saque(double valor);

    void deposito(double valor);

    void tranferencia(double valor, Conta contaDestino);

    void extrato();
}
