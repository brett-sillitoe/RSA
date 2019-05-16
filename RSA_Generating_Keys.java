import java.util.Random;
import java.math.BigInteger;

public class RSA_Generating_Keys extends Pseudoprime{

	public static void main(String[] args) {
		Euclids_Extended alg = new Euclids_Extended();
		Random random = new Random();
		BigInteger p = new BigInteger(1024,1,random);
		BigInteger q = new BigInteger(1024,1,random);
		BigInteger n = p.multiply(q);
		BigInteger e = new BigInteger("65537");
		BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		
		System.out.println("p = " + p + " and is " + pseudoprime(p));
		System.out.println("q = " + q + " and is " + pseudoprime(q));
		System.out.println("n = " + n);
		System.out.println("e = " + e);
		System.out.println("phi = " + phi);
		
		if(phi.mod(e).equals(BigInteger.ZERO)){
			System.out.println("Sorry, " + e + " evenly divides " + phi);
		}
		
		BigInteger[] result = alg.extendedEuclid(e, phi); //returns (d,x,y) we want x
		BigInteger d = result[1];
		
		System.out.println("d = " + d);
		System.out.println("or if d is negative use this: " + d.add(phi));
	}

}
