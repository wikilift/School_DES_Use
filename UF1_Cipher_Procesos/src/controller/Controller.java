package controller;

import java.util.ArrayList;

public interface Controller {
	
	boolean readTxt();
	boolean encrypt();
	String decrypt();
	byte[] readBinary();
	boolean writeTxt(String message,int mode);

}
