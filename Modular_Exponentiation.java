import java.math.BigInteger;

public class Modular_Exponentiation {

	public static void main(String[] args) {
		BigInteger a = new BigInteger("3");
		BigInteger b = new BigInteger("300");
		BigInteger n = new BigInteger("47");

		BigInteger result = modularExponentiation(a,b,n);
		System.out.println(result);
	}

	
	public static BigInteger modularExponentiation(BigInteger a, BigInteger b, BigInteger n){
		BigInteger d = new BigInteger("1");
		String binaryString = b.toString(2);
		
		for(int i = 0; i < binaryString.length(); i++){
			d = (d.multiply(d)).mod(n);
			if(binaryString.charAt(i) == '1'){
				d = (d.multiply(a)).mod(n);
			}
		}
		return d;
	}
}

