import java.math.BigInteger;

public class Pseudoprime extends Modular_Exponentiation{
	public static void main(String[] args) {
		BigInteger a = new BigInteger("104729");
		System.out.println(a + " is " + pseudoprime(a));

	}
	
	public static String pseudoprime(BigInteger n){
		BigInteger one = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		
		if(!modularExponentiation(two,n.subtract(one),n).equals(one.mod(n))){
			return "composite";
		}
		else{
			return "prime";
		}
	}
}
