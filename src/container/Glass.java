package container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import component.Beverage;
import component.Edible;
import component.Flavoring;
import component.Ingredient;

public class Glass {
	
	private ArrayList<Ingredient> drink;
	private int MaxIngredient = 5;
	private int Capacity;
	private Size size = Size.EMPTY;
	
	public Glass() {
		ArrayList<Ingredient> drink = new ArrayList<Ingredient>();
		this.setDrink(drink);
		this.setCapacity(0);
	}
	
	public void addIngredient(Ingredient ingredient) {

		if(this.Capacity < this.MaxIngredient) {
			ArrayList<Ingredient> drink = this.getDrink();
			boolean Notfound = true;
			for(Ingredient i:drink) {
				if(i.getName().equals(ingredient.getName())) {
					i.setConcentration(i.getConcentration()+1);
					Notfound = false;
				}
			}
			if(Notfound) {
				if(ingredient instanceof Edible) {
					Beverage newingredient = (Beverage) ingredient;
					drink.add(newingredient);
				}else {
					Flavoring newingredient = (Flavoring) ingredient;
					drink.add(newingredient);
				}
				
			}
			this.setDrink(drink);
			this.setCapacity(this.getCapacity()+1);
		}
	}
	public void clearGlass() {
		ArrayList<Ingredient> drink = new ArrayList<Ingredient>();
		this.setDrink(drink);
		this.setCapacity(0);
	}
	
	public boolean isServable() {
		for(Ingredient i:this.getDrink()) {
			if(i instanceof Edible) {
				return true;
			}
		}
		return false;
	}
	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}
	
	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}

	public ArrayList<Ingredient> getDrink() {
		return drink;
	}

	public void setDrink(ArrayList<Ingredient> drink) {
		this.drink = drink;
	}
	
	
}
