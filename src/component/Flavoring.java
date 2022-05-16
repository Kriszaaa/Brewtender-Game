package component;

import javafx.scene.image.Image;

public class Flavoring extends Ingredient{

	
	public Flavoring(String name,String description,int concentration) {
		super(name,description);
		this.setConcentration(concentration);
	}
	public Flavoring(String name) {
		super(name);
	}
	public static Flavoring setCondense(Flavoring flavoring,int concentration) {
		Flavoring newFlavoring = new Flavoring(flavoring.getName());
		newFlavoring.setConcentration(concentration);
		return newFlavoring;
	}
	
}

/*public String getFlavor() {
return flavor;
}
public void setFlavor(String name) {
if(name == "Milk") {
	this.flavor = "smooth";
}else if(name == "Cocoa Paste") {
	this.flavor = "aroma";
}else if(name == "Caramel") {
	this.flavor = "sweetness";
}else if(name == "Soda") {
	this.flavor = "fizzy";
}else if(name == "Lemon") {
	this.flavor = "sour";
}else if(name == "Mint") {
	this.flavor = "cooling";
}
}*/