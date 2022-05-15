package logic;

import java.util.ArrayList;

import component.Ingredient;
import container.Size;

public class Customer {
	private String description;
	private ArrayList<Ingredient> drink;
	private Size size;
	public Customer(String description,ArrayList<Ingredient> drink,Size size) {
		this.setDescription(description);
		this.setDrink(drink);
		this.setSize(size);
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
