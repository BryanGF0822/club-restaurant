package Exception;

@SuppressWarnings("serial")

/**
 * 
 * @author guapi
 *
 */
public class TwoResWithSameNitR extends Exception{
	
	/**
	 * 
	 */
	public TwoResWithSameNitR() {
		
		System.out.println("Ya existe un restaurante con este mismo nit.");
	}
}
