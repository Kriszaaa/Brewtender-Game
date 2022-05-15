package logic;

import java.util.ArrayList;

import component.Ingredient;
import container.Glass;
import container.Size;
import exception.ServeFailedException;

public class DrinkValidator {
	
	
	public static boolean checkDrink(Customer customer,Glass glass) throws ServeFailedException{
		
		ArrayList<Ingredient> customerdrink = customer.getDrink();
		if(glass.getSize().equals(Size.EMPTY) || !glass.isServable()) {
			throw new ServeFailedException("Serve Failed!!");
		}else {
			for(Ingredient i:customerdrink) {
				boolean found = false;
				for(Ingredient j:glass.getDrink()) {
					if(i.checkSameIngredient(j)) {
						found = true;
					}
				}
				if (!found) {
					return false;
				}
			}
			return true;
		}
	}

}
