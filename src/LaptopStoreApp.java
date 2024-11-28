public class LaptopStoreApp {
	
	public static Laptop[] laptopArray = new Laptop[30];
	public static Laptop[] laptopResultsArray = new Laptop[3];
	
	public static void main(String args[]){
		
		FileInput.readInput();
		
		//testing
		laptopResultsArray[0] = laptopArray[0];
		laptopResultsArray[1] = laptopArray[1];
		laptopResultsArray[2] = laptopArray[2];
		
		ResultsFrame resultsFrame = new ResultsFrame();
//		InventoryFrame inventoryFrame = new InventoryFrame();
	}
	
}