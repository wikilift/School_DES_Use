import java.util.Scanner;

import Model.MyAwesomePojo;
import controller.Controller;
import controller.ControllerImpl;

public class Start {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Controller repo = new ControllerImpl(new MyAwesomePojo());
		loadSteticMenu();
		System.out.println();
		System.out.println();
		while (true) {
		
			System.out.println("Bienvenido");
			System.out.println();
			System.out.println("\tPulse 1 cifrar");
			System.out.println("\tPulse 2 descifrar");
			System.out.println("\tPulse 3 salir");
			
			int input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.println("Introduzca el mensaje a cifrar");
				sc.nextLine();
				repo.writeTxt(sc.nextLine(),0);
				sleep();
				System.out.println();
				repo.encrypt();
				break;
			case 2:
				System.out.println("Desencriptando...");
				sleep();
				System.out.println("Su mensaje descifrado es: "+repo.decrypt()); 
				break;
			case 3:
				System.out.println("Gracias y hasta pronto!");
				sc.close();
				sleep();
				System.exit(0);
				break;
			}
		}

	}
	private static void loadSteticMenu() {
		for (String e : MyAwesomePojo.steticHeader) {
			System.out.println(e);
			sleep();
		}

	}
	private static void sleep() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
