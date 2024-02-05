
/**
 Realizar un programa que permita gestionar el saldo de una cuenta corriente. Una
 vez introducido el saldo inicial, se mostrará un menú que permitirá efectuar las
 siguientes operaciones:
	1. Hacer un reintegro, se pedirá la cantidad a retirar.
	2. Hacer un ingreso, se pedirá la cantidad a ingresar.
	3. Consultar el saldo y el número de reintegros e ingresos realizados.
	4. Finalizar las operaciones. Debe confirmar si realmente desea salir e
       informar del saldo al final de todas las operaciones.

 Debe realizarse una clase Cuenta y la clase Principal.
*/
public class Cuenta {

	private double saldo;
	private int contadorIngresos;
	private int contadorReintegros;
	
	private static double totalDineroSacado=0;

	// Contructores
	
	public Cuenta() {
		saldo = 0;
		contadorIngresos = 0;
		contadorReintegros = 0;
		
		
	}
	
	public static double  gettotalDineroSacado() {
		return totalDineroSacado;
	}

	public Cuenta(double saldo) throws CuentaException{
		if (saldo < 0) {
			// Aquí lo suyo sería lanzar una excepción
			throw new CuentaException("No se puede crear una cuenta con saldo negativo.");
		} 
		else {
			this.saldo = saldo;
			contadorIngresos = 0;
			contadorReintegros = 0;
		}
	}

	// Métodos gets
	
	public double getSaldo() {
		return this.saldo;
	}

	public int getContadorIngresos() {
		return this.contadorIngresos;
	}

	public int getContadorReintegros() {
		return this.contadorReintegros;
	}

	/**
	 * Método que realiza un reintegro en la cuenta.
	 * @param reintegro
	 */
	public void realizarReintegro(double reintegro) throws CuentaException{
		if (reintegro <= 0)
			// Debería tratarse en una excepción
			throw new CuentaException("El reintegro solo puede realizarse con cantidades positivas.");
		else {
			if (reintegro > this.saldo) {
				// Debería tratarse en una excepción
				throw new CuentaException("No tienes suficiente saldo.");
			} 
			else {
				this.saldo = this.saldo - reintegro;
				this.contadorReintegros++;
				
				totalDineroSacado=totalDineroSacado + reintegro;
			}
		}
	}

	/**
	 * Método que realiza un ingreso en la cuenta
	 * @param ingreso
	 */
	public void realizarIngreso(double ingreso) throws CuentaException{
		if (ingreso <= 0) {
			// Debería tratarse en una excepción
			throw new CuentaException("El ingreso solo puede realizarse con cantidades positivas.");
		}
			this.saldo = this.saldo + ingreso;
			this.contadorIngresos++;
		
	}
	
	/**
	 * Método que muestra el saldo y el número de ingresos y reintegros.
	 */
	public String toString() {
		return "Cuenta con saldo " + saldo + " .Se han realizado " 
				+ contadorIngresos + " ingresos y " + contadorReintegros + " reintegros.";
	}
}
