/**
 * CuentaBancaria
 */
import java.util.Random;
public class CuentaBancaria {

    //  //// VARIABLES ///////////////////////////////////
    private double saldoCuentaCorriente;
    private double saldoCuentaAhorros;
    private long numeroCuenta;

    private static int numeroTotalCuentas = 0;
    private static double cantidadTotal= 0.0;
    // //// CONSTRUCTOR ////////////////////////////////
    public CuentaBancaria() {
        this.saldoCuentaCorriente = 0.0;
        this.saldoCuentaAhorros = 0.0;
        this.numeroCuenta = generateRamdomAccount();
        numeroTotalCuentas++;
    }
    // --------------- generar numero de cuenta 
        private long generateRamdomAccount(){
            Random rand = new Random();
            return (long)(rand.nextDouble()*10000000000L);
        }
    //------------ get static variables ----------------- 
    public static int getNumeroTotalCuentas(){
        return numeroTotalCuentas;
    }
    public static double getCantidadTotal(){
        return cantidadTotal;
    }
    //-------------- getters variables -----------------------
    public double getSaldoCuentaCorriente(){
        return this.saldoCuentaCorriente;
    } 
    public double getSaldoCuentaAhorros(){
        return this.saldoCuentaAhorros;
    }
    public long getNumeroCuenta(){
        return this.numeroCuenta;
    }
    //--------------  setters -------------------------------
    public void setCantidadTotal(){
        cantidadTotal = getSaldoCuentaAhorros()+getSaldoCuentaCorriente();
    }
    //-------------- depositar ------------------------------
    public void depositar(String claseDeposito, double montoDepositado) {
        if (claseDeposito.equals("corriente")) {
            this.saldoCuentaCorriente += montoDepositado;
        }else if(claseDeposito.equals("ahorros")){
            this.saldoCuentaAhorros += montoDepositado;
        }    
        setCantidadTotal();
    }
    public boolean isValidRetirar(double cantidadTotal,double monto ){
        if (cantidadTotal-monto>=0) {
            return true;
        } else {
            return false;
        }
    }
    public void retirarMonto (String claseDeposito, double monto){
        if (claseDeposito.equals("corriente")) {
            if (isValidRetirar(getSaldoCuentaCorriente(), monto)) {
                this.saldoCuentaCorriente -= monto;
            }else{
                System.out.println("No cuenta con saldo suficiente");
            }     
        }else if (claseDeposito.equals("ahorros")){
            if (isValidRetirar(getSaldoCuentaAhorros(), monto)) {
                this.saldoCuentaAhorros -= monto;
            }else{
                System.out.println("No cuenta con saldo suficiente");
            }
        }else{
            System.out.println("ingrese la clase de deposito valida");
        }
    }
    //-------------------- Display ----------------------
    public void display() {
        System.out.printf("---- Bank Account Num: %d ------------\n", getNumeroCuenta());
        System.out.printf("Cuenta corriente: $%.2f || Cuenta ahorros: $%.2f\n", getSaldoCuentaCorriente(), getSaldoCuentaAhorros());
        System.out.printf("Saldo Total: $%.2f\n", getCantidadTotal());
    }

}