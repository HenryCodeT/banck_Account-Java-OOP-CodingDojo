
public class Test {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria();
        CuentaBancaria cuenta2 = new CuentaBancaria();
        CuentaBancaria cuenta3 = new CuentaBancaria();
        
        cuenta1.depositar("ahorros", 1000);
        cuenta1.depositar("corriente", 1000);
        cuenta1.display();
        
        cuenta2.depositar("ahorros", 2000);
        cuenta2.depositar("corriente", 1000);
        cuenta2.display();
        
        cuenta3.depositar("ahorros", 4000);
        cuenta3.depositar("corriente", 1000);
        cuenta3.display();
    }
}
