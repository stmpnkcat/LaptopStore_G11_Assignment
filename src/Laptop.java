import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Laptop extends JLabel {
	private String brand;
	private String model;
	private int qualityRating;
	private String type;
	private double price;
	private String cpuBrand;
	private String cpuType;
	private String cpuModel;
	private int cpuCores;
	private double cpuSpeed;
	private int speedRating;
	private String gpuBrand;
	private String gpuModel;
	private String gpuType;
	private int storage;
	private int ram;
	private int memoryRating;
	private String connectivity;
	private String os;
	private double displaySize;
	private int vertRes;
	private int horRes;
	private boolean isTouchScreen;
	private double weight;
	private String link;
	private ImageIcon image;
	
	public Laptop(String brand, String model, int qualityRating, String type, double price, String cpuBrand,
			String cpuType, String cpuModel, int cpuCores, double cpuSpeed, int speedRating, String gpuBrand,
			String gpuModel, String gpuType, int storage, int ram, int memoryRating, String connectivity, String os, double displaySize,
			int vertRes, int horRes, boolean isTouchScreen, double weight, String link, ImageIcon image) {
		super();
		this.brand = brand;
		this.model = model;
		this.qualityRating = qualityRating;
		this.type = type;
		this.price = price;
		this.cpuBrand = cpuBrand;
		this.cpuType = cpuType;
		this.cpuModel = cpuModel;
		this.cpuCores = cpuCores;
		this.cpuSpeed = cpuSpeed;
		this.speedRating = speedRating;
		this.gpuBrand = gpuBrand;
		this.gpuModel = gpuModel;
		this.gpuType = gpuType;
		this.storage = storage;
		this.ram = ram;
		this.memoryRating = memoryRating;
		this.connectivity = connectivity;
		this.os = os;
		this.displaySize = displaySize;
		this.vertRes = vertRes;
		this.horRes = horRes;
		this.weight = weight;
		this.link = link;
		this.image = image;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public int getQualityRating() {
		return qualityRating;
	}


	public void setQualityRating(int qualityRating) {
		this.qualityRating = qualityRating;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getCpuBrand() {
		return cpuBrand;
	}


	public void setCpuBrand(String cpuBrand) {
		this.cpuBrand = cpuBrand;
	}


	public String getCpuType() {
		return cpuType;
	}


	public void setCpuType(String cpuType) {
		this.cpuType = cpuType;
	}


	public String getCpuModel() {
		return cpuModel;
	}


	public void setCpuModel(String cpuModel) {
		this.cpuModel = cpuModel;
	}


	public int getCpuCores() {
		return cpuCores;
	}


	public void setCpuCores(int cpuCores) {
		this.cpuCores = cpuCores;
	}


	public double getCpuSpeed() {
		return cpuSpeed;
	}


	public void setCpuSpeed(double cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}


	public int getSpeedRating() {
		return speedRating;
	}


	public void setSpeedRating(int speedRating) {
		this.speedRating = speedRating;
	}


	public String getGpuBrand() {
		return gpuBrand;
	}


	public void setGpuBrand(String gpuBrand) {
		this.gpuBrand = gpuBrand;
	}


	public String getGpuModel() {
		return gpuModel;
	}


	public void setGpuModel(String gpuModel) {
		this.gpuModel = gpuModel;
	}
	
	public String getGpuType() {
		return gpuType;
	}


	public void setGpuType(String gpuType) {
		this.gpuType = gpuType;
	}


	public int getStorage() {
		return storage;
	}


	public void setStorage(int storage) {
		this.storage = storage;
	}


	public int getRam() {
		return ram;
	}


	public void setRam(int ram) {
		this.ram = ram;
	}


	public int getMemoryRating() {
		return memoryRating;
	}


	public void setMemoryRating(int memoryRating) {
		this.memoryRating = memoryRating;
	}


	public String getConnectivity() {
		return connectivity;
	}


	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}


	public String getOs() {
		return os;
	}


	public void setOs(String os) {
		this.os = os;
	}


	public double getDisplaySize() {
		return displaySize;
	}


	public void setDisplaySize(double displaySize) {
		this.displaySize = displaySize;
	}


	public int getVertRes() {
		return vertRes;
	}


	public void setVertRes(int vertRes) {
		this.vertRes = vertRes;
	}


	public int getHorRes() {
		return horRes;
	}


	public void setHorRes(int horRes) {
		this.horRes = horRes;
	}
	
	public boolean getIsTouchScreen() {
		return isTouchScreen;
	}


	public void setIsTouchScreen(boolean isTouchScreen) {
		this.isTouchScreen = isTouchScreen;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}
	
	
	public ImageIcon getImage() {
		return image;
	}


	public void setImage(ImageIcon image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Laptop [brand=" + brand + ", model=" + model + ", qualityRating=" + qualityRating + ", type=" + type
				+ ", price=" + price + ", cpuBrand=" + cpuBrand + ", cpuType=" + cpuType + ", cpuModel=" + cpuModel
				+ ", cpuCores=" + cpuCores + ", cpuSpeed=" + cpuSpeed + ", speedRating=" + speedRating + ", gpuBrand="
				+ gpuBrand + ", gpuModel=" + gpuModel + ", gpuType=" + gpuType + ", storage=" + storage + ", ram=" + ram
				+ ", memoryRating=" + memoryRating + ", connectivity=" + connectivity + ", os=" + os + ", displaySize="
				+ displaySize + ", vertRes=" + vertRes + ", horRes=" + horRes + ", isTouchScreen=" + isTouchScreen
				+ ", weight=" + weight + ", link=" + link + "]";
	}

	public String getInfo(){
		return "Model: " + brand + "\nPrice: " + price;
	}
	
}