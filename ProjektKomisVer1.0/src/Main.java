import java.util.List;

import domain.*;
import repositories.IRepositoriesCatalog;
import repositories.impl.DummyRepositoriesCatalog;


public class Main {

	public static void main(String args[]){
		
		IRepositoriesCatalog catalog = new DummyRepositoriesCatalog();
		Car volvo = new Car();
		Offer oferta = new Offer();
		oferta.setCar(volvo);
		oferta.setId(1);
		oferta.setPrice(25000);
	
		catalog.getCars().add(volvo);
		List<Car> samochody = catalog.getCars().getAll();
		for(Car x: samochody){
			System.out.println(x.getMark()+" "+x.getModel());
		}
		
		
	}

}
