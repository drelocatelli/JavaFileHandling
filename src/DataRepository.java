import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.Data;

public class DataRepository extends Data {
	private static final String FILENAME = "data.txt";
	private static final long serialVersionUID = 1L;

	public <T> DataRepository(T data) {
		super(data);
	}
	
	// Método para salvar dados em um arquivo de texto
    public static <T> void saveData(List<Data<T>> dataList) {
        try (FileOutputStream fileOut = new FileOutputStream(FILENAME);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(dataList);
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para ler dados de um arquivo de texto
    public static <T> List<Data<T>> readData() {
        List<Data<T>> dataList = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(FILENAME);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            dataList = (List<Data<T>>) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    // Método para adicionar novos dados
    public static <T> void addData(T newData) {
        List<Data<T>> dataList = readData();
        dataList.add(new Data<>(newData));
        saveData(dataList);
    }

    // Método para atualizar dados existentes
    public static <T> void updateData(int index, T updatedData) {
        List<Data<T>> dataList = readData();
        if (index >= 0 && index < dataList.size()) {
            dataList.set(index, new Data<>(updatedData));
            saveData(dataList);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Método para remover dados existentes
    public static <T> void removeData(int index) {
        List<Data<T>> dataList = readData();
        if (index >= 0 && index < dataList.size()) {
            dataList.remove(index);
            saveData(dataList);
        } else {
            System.out.println("Índice inválido.");
        }
    }
    
    public static void deleteAll() {
        try {
            File file = new File(FILENAME);

            // Check if the file exists
            if (!file.exists()) {
                System.out.println("Arquivo não existe.");
                return;
            }
            
            // Truncate the file (empty its contents)
            FileWriter writer = new FileWriter(file);
            writer.write("");
            writer.close();

            System.out.println("Dados apagados com sucesso.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
