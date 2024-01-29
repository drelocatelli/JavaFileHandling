
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.Data;

public class Program {
	private static Scanner input = new Scanner(System.in);

    public static void menu() {
    	System.out.printf("1 - Adicionar dado\n2 - Atualizar dado\n3 - Remover dado\n4 - Verificar dados\n5 - Apagar tudo\n");
    	System.out.printf("Escolha uma opção: ");
    	int opt = input.nextInt();
    	
    	switch(opt) {
    		case 1:
    			System.out.printf("Adicione um dado:\nDigite: ");
    			input.nextLine();
    			String data = input.nextLine();
    			DataRepository.addData(data);
    		break;
    		case 2:
    			System.out.printf("Atualize um dado\n");
    			System.out.println("Digite um índice:");
    			int updatedIdx = input.nextInt();
    			input.nextLine();
    			System.out.println("Digite o valor novo:");
    			String updatedData = input.nextLine();
    			DataRepository.updateData(updatedIdx, updatedData);
    		break;
    		case 3:
    			System.out.printf("Remova um dado\n");
    			System.out.println("Digite um índice:");
    			int removedIdx = input.nextInt();
    			input.nextLine();
    			DataRepository.removeData(removedIdx);
    		break;
    		case 4:
    			System.out.println(DataRepository.readData());
    		break;
    		case 5:
    			DataRepository.deleteAll();
    		break;
    	}
    	System.out.println("Digite enter para continuar");
    	input.nextLine();
    	menu();
    }

    public static void main(String[] args) {
    	menu();
    }
}
