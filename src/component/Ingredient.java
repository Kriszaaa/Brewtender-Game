package component;

import javafx.scene.image.Image;

public class Ingredient {
	
	private String name;
	private String description;
	private int concentration = 1;
	
	public Ingredient(String name,String description) {
		this.setName(name);
		this.setDescription(description);
	}
	
	public Ingredient(String name) {
		this.setName(name);
		this.setDescription("");
		this.setConcentration(concentration);
	}
	/*public static Ingredient setCondense(Ingredient ingredient,int concentration) {
		Ingredient newIngredient = ingredient;
		newIngredient.setConcentration(concentration);
		return newIngredient;
	}*/
	
	public boolean checkSameIngredient(Ingredient i) {
		if(this.getName().equals(i.getName()) && this.getConcentration() ==  i.getConcentration()) {
			return true;
		}
		return false;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public int getConcentration() {
		return concentration;
	}

	public void setConcentration(int concentration) {
		this.concentration = concentration;
	}

	
}
