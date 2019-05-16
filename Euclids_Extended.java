import java.math.BigInteger;

public class Euclids_Extended{
	
	public Euclids_Extended(){
		
	}
	
	public static void main(String[] args) {
		BigInteger a = new BigInteger("89");
		BigInteger b = new BigInteger("35");
		BigInteger [] result = extendedEuclid(a,b);
		
		for(int i = 0; i<result.length;i++){
			System.out.println(result[i]);
		}
	}
	
	public static BigInteger[] extendedEuclid(BigInteger a, BigInteger b){
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		BigInteger[] result = new BigInteger[]{a,one,zero};
		
		if(b.equals(BigInteger.ZERO)){
			return result;
		}
		else{
			result = extendedEuclid(b,a.mod(b));
			BigInteger[] returnResult = new BigInteger[]{result[0], result[2], result[1].subtract((a.divide(b)).multiply(result[2]))};
			return returnResult; //(d,x,y)
		}
	}
}

