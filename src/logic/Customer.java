package logic;

import java.util.ArrayList;

import component.Ingredient;
import container.Size;

public class Customer {
	private String description;
	private ArrayList<Ingredient> drink;
	private Size size;
	private String recipes = "";
	
	public Customer(String description,ArrayList<Ingredient> drink,Size size) {
		this.setDescription(description);
		this.setDrink(drink);
		this.setSize(size);
	}
	public Customer(String description,ArrayList<Ingredient> drink,Size size,String recipes) {
		this.setDescription(description);
		this.setDrink(drink);
		this.setSize(size);
		this.setRecipes(recipes);
	}
	
	public String getRecipes() {
		return recipes;
	}
	public void setRecipes(String recipes) {
		this.recipes = recipes;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Ingredient> getDrink() {
		return drink;
	}
	public void setDrink(ArrayList<Ingredient> drink) {
		this.drink = drink;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
}
