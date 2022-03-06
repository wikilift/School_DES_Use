package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import javax.crypto.Cipher;

import javax.swing.JOptionPane;

import Model.MyAwesomePojo;

public class ControllerImpl implements Controller {

	private MyAwesomePojo pojo;

	public ControllerImpl(MyAwesomePojo pojo) {

		this.pojo = pojo;
	}

	@Override
	public boolean readTxt() {
		// TODO Auto-generated method stub
		String lineOfText = "";
		String result = "";
		File f2 = new File(pojo.getPlainTextPath());
		try {
			if (f2.exists()) {
				FileReader fr = new FileReader(f2);
				BufferedReader br = new BufferedReader(new FileReader(f2));
				while ((lineOfText = br.readLine()) != null) {

					result += lineOfText + "\n";

				}
				fr.close();
				pojo.setOriginal(result);
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean encrypt() {
		try {
			if (this.readTxt()) {
				Cipher eCipher = Cipher.getInstance("DES");
				eCipher.init(Cipher.ENCRYPT_MODE, pojo.getKEY());
				byte[] encoded = eCipher.doFinal(pojo.getOriginal().getBytes());
				pojo.setEncoded(encoded);

				File file = new File(pojo.getEncodedPath());

				try (FileOutputStream fos = new FileOutputStream(file)) {
					fos.write(encoded);
					System.out.println("Fichero encriptado guardado correctamente");
					fos.close();
					return true;
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				JOptionPane.showConfirmDialog(null, "NO SE ENCUENTRA NINGÚN FICHERO CON EL LA RUTA ESTABLECIDA",
						"ATENCIÓN", JOptionPane.DEFAULT_OPTION);
			}

		} catch (Exception e) {

		}

		return false;
	}

	@Override
	public String decrypt() {
		Cipher dCipher;
		try {
			dCipher = Cipher.getInstance("DES");
			dCipher.init(Cipher.DECRYPT_MODE, pojo.getKEY());
			if(readBinary()!=null) {
				byte[] decoded=dCipher.doFinal(pojo.getEncoded());
				writeTxt(new String(decoded), 1);
				return new String(decoded);
				
			}
			else {
				JOptionPane.showConfirmDialog(null, "AÚN NO HAY NINGUN FICHERO ENCRIPTADO",
						"ATENCIÓN", JOptionPane.DEFAULT_OPTION);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public byte[] readBinary() {
		byte[] bytes;
		File file = new File(pojo.getEncodedPath());
		if (file.exists()) {
			try (FileInputStream fis = new FileInputStream(file)) {
				bytes = new byte[(int) file.length()];
				int i = 0;
				for (byte b : bytes) {
					bytes[i] = b;
					i++;
				}
				pojo.setDecoded(bytes);
				return bytes;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public boolean writeTxt(String message,int mode) {
		// TODO Auto-generated method stub
		File f=null;
		if(mode==0) {
			f=new File(pojo.getPlainTextPath());
		}else {
			 f=new File(pojo.getDecodedOutputPath());
		}
		
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter(f));
			writer.write(message);
			writer.close();
			return true;
		}catch(Exception e) {
			
		}

		
		return false;
	}

}
