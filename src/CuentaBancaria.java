public class CuentaBancaria {

    private String titular;
    private double saldo;
    private String numeroCuenta;


    public CuentaBancaria() {
    }

    public CuentaBancaria(String titular, double saldo, String numeroCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                '}';
    }

    public void depositarDinero (double monto){
        this.saldo += monto;
    }

    public void retirarDinero (double monto){
        this.saldo -= monto;
    }

    public void mostrarInformacion(){
        System.out.println("EL NOMBRE DEL TITULAR ES: " + this.titular);
        System.out.println("EL SALDO DE LA CUENTA ES: " + this.saldo);
        System.out.println("EL NUMERO DE LA CUENTA ES: " + this.numeroCuenta);
    }

    public boolean transferirDinero(CuentaBancaria destino, double monto) {
        if (this.saldo >= monto) {
            this.saldo -= monto;
            destino.saldo += monto;
            System.out.println("Transferencia exitosa. Nuevo saldo: " + this.saldo);
            return true;
        } else {
            System.out.println("Saldo insuficiente para la transferencia.");
            return false;
        }
    }
}
