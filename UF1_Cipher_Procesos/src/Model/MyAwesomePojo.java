package Model;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


public class MyAwesomePojo {
	
	private String original,encodedPath,plainTextPath,decodedOutputPath;
	private byte[] encoded,decoded;
	private   SecretKey key;
	public final static String[] steticHeader = { "____________________________________________",
			"|____________________________________________|", "|__||  ||___||  |_|___|___|__|  ||___||  ||__|",
			"||__|  |__|__|  |___|___|___||  |__|__|  |__||", "|__||  ||___||  |_|___|___|__|  ||___||  ||__|",
			"||__|  |__|__|  |C    || |    | |__|__|  |__||", "|__||  ||___||  | I   || |    | ||___||  ||__|",
			"||__|  |__|__|  |   P || |    | |__|__|  |__||", "|__||  ||___||  |    H|| |    | ||___||  ||__|",
			"||__|  |__|__|  |   E || |    | |__|__|  |__||", "|__||  ||___||  |   R || |O   | ||___||  ||__|",
			"||__|  |__|__|  | D   || |    | |__|__|  |__||", "|__||  ||___||  |A    || |    | ||___||  ||__|",
			"||__|  |__|__|__|__N_I||_|____| |__|__|  |__||", "|LLL|  |LLLLL|______________||  |LLLLL|  |LLL|",
			"|LLL|  |LLL|______________|  |  |LLLLL|  |LLL|", "|LLL|__|L|______________|____|__|LLLLL|__|LLL|" };
	
	
	public MyAwesomePojo() {
		this.encodedPath="Input/myAwesomeEncriptedMessage.TopSecret";
		this.plainTextPath="Input/myAwesomeEncriptedMessage.txt";
		this.decodedOutputPath="Output/myAwesomeDecriptedMessage.txt";
	
		
		try {
			key=KeyGenerator.getInstance("DES").generateKey();
			System.out.println("Su clave secreta de cifrado ha sido generada: "+key.toString());
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public byte[] getEncoded() {
		return encoded;
	}

	public void setEncoded(byte[] encoded) {
		this.encoded = encoded;
	}

	public byte[] getDecoded() {
		return decoded;
	}

	public void setDecoded(byte[] decoded) {
		this.decoded = decoded;
	}

	public SecretKey getKEY() {
		return key;
	}

	public void setKEY(SecretKey kEY) {
		key = kEY;
	}

	public String getEncodedPath() {
		return encodedPath;
	}

	public String getPlainTextPath() {
		return plainTextPath;
	}

	public String getDecodedOutputPath() {
		return decodedOutputPath;
	}

	
	

}
