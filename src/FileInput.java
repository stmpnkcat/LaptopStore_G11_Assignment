import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class FileInput {
	
	public static void readInput(){
		
		Scanner inputFile;
		
		try {
			
			inputFile = new Scanner(new File("data/laptop_data.txt"));
			
			inputFile.useDelimiter(",|\r\n");
			
			for (int index = 0; index < 30; index++){
				
				String brand = inputFile.next();
				String model = inputFile.next();
				int qualityRating = inputFile.nextInt();
				String type = inputFile.next();
				double price = inputFile.nextDouble();
				String cpuBrand = inputFile.next();
				String cpuType = inputFile.next();
				String cpuModel = inputFile.next();
				int cpuCores = inputFile.nextInt();
				double cpuSpeed = inputFile.nextDouble();
				int speedRating = inputFile.nextInt();
				String gpuBrand = inputFile.next();
				String gpuModel = inputFile.next();
				String gpuType = inputFile.next();
				int storage = inputFile.nextInt();
				int ram = inputFile.nextInt();
				int memoryRating = inputFile.nextInt();
				String connectivity = inputFile.next();
				String os = inputFile.next();
				double displaySize = inputFile.nextDouble();
				int vertRes = inputFile.nextInt();
				int horRes = inputFile.nextInt();
				boolean isTouchScreen = inputFile.nextBoolean();
				double weight = inputFile.nextDouble();
				String link = inputFile.next();
				
				LaptopStoreApp.laptopArray[index] = new Laptop(brand, model, qualityRating, type, price, cpuBrand, cpuType, cpuModel, cpuCores, cpuSpeed, speedRating, gpuBrand, gpuModel, gpuType, storage, ram, memoryRating, connectivity, os, displaySize, vertRes, horRes, isTouchScreen, weight, link, new ImageIcon("images/laptop" + (index+1) + ".jpg"));
			
				LaptopStoreApp.laptopArray[index].setIcon(new ImageIcon("images/laptop" + (index+1) + ".jpg"));
				
				System.out.println(LaptopStoreApp.laptopArray[index].toString());
			}
			
			inputFile.close();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			
		}
		
	}
}