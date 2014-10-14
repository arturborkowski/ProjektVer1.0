import java.util.List;

import domain.*;
import repositories.IRepositoriesCatalog;
import repositories.impl.DummyRepositoriesCatalog;


public class Main {

	public static void main(String args[]){
		
		Seller sprzedawca = new Seller();
		Buyer kupiec = new Buyer();
		Car volvo = new Car();
		
		Offer oferta = new Offer();
		oferta.setCar(volvo);
		volvo.setOffer(oferta);
		oferta.setId(1);
		oferta.setPrice(25000);
		
		Transaction transakcja = new Transaction();
		transakcja.setBuyer(kupiec);
		transakcja.setSeller(sprzedawca);
		transakcja.getOffers().add(oferta);
		kupiec.addTransaction(transakcja);
		sprzedawca.addTransaction(transakcja);
	
		
		IRepositoriesCatalog catalog = new DummyRepositoriesCatalog();
		catalog.getCar().add(volvo);
		catalog.getOffers().add(oferta);
		catalog.getTransaction().add(transakcja);
		catalog.getBuyer().add(kupiec);
		catalog.getSeller().add(sprzedawca);
		
		System.out.println(catalog.getSeller().ofTransaction(transakcja).getFirstName()+" "+catalog.getSeller().ofTransaction(1).getLastName()
				+" sprzedaje Panu o nazwisku "+catalog.getBuyer().get(1).getFirstName()+" "+catalog.getBuyer().get(1).getLastName()
				+" \nsamochod "+catalog.getCar().byOffer(oferta).getMark()+" "+catalog.getCar().byOffer(1).getModel()
				+" w cenie "+catalog.getOffers().withCar(volvo).getPrice()+" PLN.");
		
		
	}

}
