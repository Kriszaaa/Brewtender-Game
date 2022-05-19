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
