package component;

import javafx.scene.image.Image;

public class Beverage extends Ingredient implements Edible{
	
	
	public Beverage(String name,String description,int concentration) {
		super(name,description);
		this.setConcentration(concentration);
	}
	public Beverage(String name) {
		super(name);
	}
	
	public static Beverage setCondense(Beverage beverage,int concentration) {
		Beverage newBeverage = new Beverage(beverage.getName());
		newBeverage.setConcentration(concentration);
		return newBeverage;
	}
	
	public void canServe() {
		
	}
}
