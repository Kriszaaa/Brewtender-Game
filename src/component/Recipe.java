package component;

import java.util.ArrayList;

public class Recipe {
	
	private String description;
	private ArrayList<Ingredient> listofingredient;
	public Recipe(String description,ArrayList<Ingredient> listofingredient) {
		this.setDescription(description);
		this.setListofingredient(listofingredient);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Ingredient> getListofingredient() {
		return listofingredient;
	}
	public void setListofingredient(ArrayList<Ingredient> listofingredient) {
		this.listofingredient = listofingredient;
	}
	
}
