import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.nio.file.*;

public class RSA_Algorithm extends Modular_Exponentiation{
	
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		int decision = 0;
		
		//Asking user for the name of the message file
		System.out.println("Please enter the filename that you want to encrypt/decrypt.");
		String message = reader.nextLine();
		
		//Asking user if they want to encrypt or decrypt the file
		while(decision != 1 && decision != 2){
			System.out.println("Would you like to encrypt or decrypt this file? 1 = Encrypt, 2 = Decrypt");
			decision = reader.nextInt();
		}
		reader.close();
		
		//Setting the file names for e,n, and d
		String e = "e.txt";
		String n = "n.txt";
		String d = "d.txt";
		String value = "";
		String next = "";
		
		try{
			//Reading in e as a string and converting it to BigInteger
			FileInputStream eInputStream = new FileInputStream(e);
			BufferedReader eReader = new BufferedReader(new InputStreamReader(eInputStream));
			while((next = eReader.readLine()) != null){
				value = value + next;
			}
			BigInteger eBigInteger = new BigInteger(value);
			
			//Reading in n as a string and converting it to BigInteger
			value = "";
			FileInputStream nInputStream = new FileInputStream(n);
			BufferedReader nReader = new BufferedReader(new InputStreamReader(nInputStream));
			while((next = nReader.readLine()) != null){
				value = value + next;
			}
			BigInteger nBigInteger = new BigInteger(value);
			
			//Reading in d as a string and converting it to BigInteger
			value = "";
			FileInputStream dInputStream = new FileInputStream(d);
			BufferedReader dReader = new BufferedReader(new InputStreamReader(dInputStream));
			while((next = dReader.readLine()) != null){
				value = value + next;
			}
			BigInteger dBigInteger = new BigInteger(value);
			
			//Reading in the message as a byte array and converting it to BigInteger
			File file = new File(message);
			byte[] messageByteArray = new byte[(int)file.length()];
			InputStream messageInputStream = new FileInputStream(message);
			messageInputStream.read(messageByteArray);
			BigInteger messageBigInteger = new BigInteger(messageByteArray);

			//Encrypting or Decrypting switch
			switch(decision){
			
				//Encrypting
				case 1:	BigInteger encrypted = modularExponentiation(messageBigInteger,eBigInteger,nBigInteger);
						byte[] encryptedBytes = encrypted.toByteArray();
						try{
							OutputStream outputStream = new FileOutputStream("EncryptedFile.txt");
							outputStream.write(encryptedBytes);
							outputStream.close();
							System.out.println("The encrypted file name is 'EncryptedFile.txt'");
						}
						catch(IOException ex){
							ex.printStackTrace();
						}
						break;
							
				//Decrypting
				case 2:	BigInteger decrypted = modularExponentiation(messageBigInteger,dBigInteger,nBigInteger);
						byte[] decryptedBytes = decrypted.toByteArray();
						try{
							OutputStream outputStream = new FileOutputStream("DecryptedFile.txt");
							outputStream.write(decryptedBytes);
							outputStream.close();
							System.out.println("The decrypted file name is 'DecryptedFile.txt'");
						}
						catch(IOException ex){
							ex.printStackTrace();
						}
						break;
				
			}
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
}