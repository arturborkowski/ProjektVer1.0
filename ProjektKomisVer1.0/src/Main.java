import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.*;
import repositories.IBuyerRepository;
import repositories.ICarRepository;
import repositories.IOfferRepository;
import repositories.IRepositoriesCatalog;
import repositories.IRepository;
import repositories.ISellerRepository;
import repositories.ITransactionRepository;
import repositories.impl.DummyRepositoriesCatalog;
import repositories.impl.mySqlImpl.BuyerBuilder;
import repositories.impl.mySqlImpl.BuyerRepository;
import repositories.impl.mySqlImpl.CarBuilder;
import repositories.impl.mySqlImpl.CarRepository;
import repositories.impl.mySqlImpl.IEntityBuilder;
import repositories.impl.mySqlImpl.OfferBuilder;
import repositories.impl.mySqlImpl.OfferRepository;
import repositories.impl.mySqlImpl.SellerBuilder;
import repositories.impl.mySqlImpl.SellerRepository;
import repositories.impl.mySqlImpl.TransactionBuilder;
import repositories.impl.mySqlImpl.TransactionRepository;
import unitofwork.IUnitOfWork;
import unitofwork.UnitOfWork;


public class Main {

	public static void main(String args[]){
		
		String user = "root";
		String password = "towdeyukf";
		
		String url = "jdbc:mysql://localhost:3306/projekt_java";
		
		Car volvo = new Car();
		volvo.setMark("Volvo");
		volvo.setModel("S80");
		volvo.setProductionYear("2004");
		volvo.setEngine("B 2.5");
		volvo.setMileage("175900 km");
		volvo.setBodyNumber("12371947281947284");
		volvo.setOfferId(1);
		
		Offer oferta = new Offer();
		oferta.setCarId(1);
		oferta.setPrice(8500.00);	
		
		
		Buyer leszek = new Buyer();
		leszek.setFirstName("Leszek");
		leszek.setLastName("Nowak");
		leszek.setPesel("89031507258");
		leszek.setPhoneNumber("+48 798-297-118");
		
		Seller marian = new Seller();
		marian.setFirstName("Marian");
		marian.setLastName("Wierzchowski");
		marian.setPesel("56091804123");
		marian.setPhoneNumber("+48 550-243-189");
		
		Car audi = new Car();
		audi.setMark("Audi");
		audi.setModel("A8");
		audi.setProductionYear("2004");
		audi.setEngine("B 4.2");
		audi.setMileage("85678 km");
		audi.setBodyNumber("19283910467284610");
		
		Transaction transakcja = new Transaction();
		transakcja.setBuyerId(1);
		transakcja.setSellerId(1);
		transakcja.setTotalPrice(oferta.getPrice());
		transakcja.setOfferId(1);
		transakcja.setDateOf("20-11-2014");
		
		
		
		
		try {
			
			// tworzymy po³¹czenie z baz¹ danych za pomoc¹ URL, nazwy u¿ytkownika i has³a
			Connection connection = DriverManager.getConnection(url,user,password);
			
			
			UnitOfWork uow = new UnitOfWork(connection);
			
			// tworzymy polecenia do stworzenia tablic (zapytania MYSQL)
			String createTableBuyers = 					
					"CREATE TABLE buyers("
					+ "id int AUTO_INCREMENT PRIMARY KEY,"
					+ "firstName VARCHAR(20),"
					+ "lastName VARCHAR(40),"
					+ "pesel CHAR(11),"
					+ "phoneNumber VARCHAR(15)"
					+ ")";
			
			String createTableSellers = 
					"CREATE TABLE sellers("
					+ "id int AUTO_INCREMENT PRIMARY KEY,"
					+ "firstName VARCHAR(20),"
					+ "lastName VARCHAR(40),"
					+ "pesel CHAR(11),"
					+ "phoneNumber VARCHAR(15)"
					+ ")";
			
			String createTableCars = 					
					"CREATE TABLE cars("
					+ "id int AUTO_INCREMENT PRIMARY KEY,"
					+ "mark VARCHAR(20),"
					+ "model VARCHAR(40),"
					+ "productionYear CHAR(4),"
					+ "engine VARCHAR(10),"
					+ "mileage VARCHAR(10),"
					+ "bodyNumber VARCHAR(17),"
					+ "offerId INT"
					+ ")";
			
			String createTableOffers = 
					"CREATE TABLE offers("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "carId INT,"
					+ "price DOUBLE(7,2)"
					+ ")";
			
			String createTableTransactions = 
					"CREATE TABLE transactions("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "buyerId INT,"
					+ "sellerId INT,"
					+ "totalPrice DOUBLE(7,2),"
					+ "dateOf VARCHAR(10),"
					+ "offerId INT"
					+ ")";
			
			// u¿ywamy wczeœniej stworzonych poleceñ do faktycznego ich wywo³ania w bazie (tworzymy tablice)
			Statement stmt = connection.createStatement();		
				stmt.executeUpdate(createTableBuyers); 
				stmt.executeUpdate(createTableCars); 
				stmt.executeUpdate(createTableOffers);
				stmt.executeUpdate(createTableSellers);
				stmt.executeUpdate(createTableTransactions);
						
			
			
				
		// repozytoria do pracy na tablicach

			IBuyerRepository buyers = new BuyerRepository(connection, new BuyerBuilder(), uow);
			ICarRepository cars = new CarRepository(connection, new CarBuilder(), uow);
			ISellerRepository sellers = new SellerRepository(connection, new SellerBuilder(), uow);
			IOfferRepository offers = new OfferRepository(connection, new OfferBuilder(), uow);
			ITransactionRepository transactions = new TransactionRepository(connection, new TransactionBuilder(), uow);
			

	
			
			 //insert
			buyers.add(leszek);
			sellers.add(marian);
			cars.add(volvo);
			cars.add(audi); 
			offers.add(oferta);
			transactions.add(transakcja);
				
				// za pomoc¹ metody commit() ³adujemy wszystkie zmiany z "lokalnego repozutorium" do bazy danych
			uow.commit();
			
			//update
			Car nowy = new Car();
			nowy = cars.get(2);
			nowy.setMark("Volksvagen");
			nowy.setModel("Golf");
			cars.update(nowy); 
			
			
			
			Buyer stefan = new Buyer();
			stefan = buyers.get(1);
			stefan.setFirstName("Stefan");
			stefan.setLastName("Kowalski");
			buyers.update(stefan);
			
				//ponownie u¿ywamy commit(), aby zaktualizowane lokalnie dane umieœciæ w bazie danych
			uow.commit();
			/* 
			 * 
			 * 
			 * 				W poni¿szych metodach nie ma potrzeby korzystania z commitu, poniewa¿ u¿ywamy jedynie
			 * 				metod "wyci¹gaj¹cych" rekordy z bazy danych, nie wprowadzamy ju¿ tam zmian
			 * 
			 * 
			 * */
			
			//selectByid
			System.out.println(buyers.get(1).getFirstName()+" "+buyers.get(1).getLastName()+" lubi jeŸdziæ "+cars.get(1).getMark()
					+" "+cars.get(1).getModel()+", ale "+sellers.get(1).getFirstName()+" "+sellers.get(1).getLastName()+" "+"chce go kupiæ.\n");
			
			
			
			//tu mamy po³¹czenie samochodu z ofert¹
			//i wyciagniecie danych za pomoca metod byOfferId() oraz withCarId()
			System.out.println("Cena za "+cars.byOfferId(1).getMark()+" wynosi: "+offers.withCarId(1).getPrice()+"\n");
			
			
			
			// imie i nazwisko sprzedawcy oraz data wykonania transakcji - dane wyciagniete za pomoc¹ trzech ró¿nych metod:
			// transactions.ofOffer(), transactions.ofBuyer() i transactions.get()
			// natomiast cena ca³kowita za pomoc¹ metody  transactions.ofSeller().getTotalPrice()
			System.out.println(sellers.get(transactions.ofOffer(1).getSellerId()).getFirstName()+" "
					+ sellers.get(transactions.ofBuyer(1).getSellerId()).getLastName()+" "
					+ transactions.get(1).getDateOf()+" "
					+ transactions.ofSeller(1).getTotalPrice() +"\n");
			
			
			
			//selectAll
			List<Car> carsFromDb = new ArrayList<Car>();
			carsFromDb = cars.getAll();
			
			for(Car c: carsFromDb) {
				System.out.println(c.getMark()+" "+c.getModel());
			}
			System.out.println();
			
			
			
			//delete
			cars.delete(nowy);
	
			carsFromDb = cars.getAll();
			for(Car c: carsFromDb) {
				System.out.println(c.getMark()+" "+c.getModel());
			}
			System.out.println();
			
			
		// na koniec testu usuwam tabele
			String dropTableCars =
					"DROP TABLE cars";
			
			String dropTableBuyers =
					"DROP TABLE buyers";
			
			String dropTableSellers =
					"DROP TABLE sellers";
			
			String dropTableOffers =
					"DROP TABLE offers";
			
			String dropTableTransactions = 
					"DROP TABLE transactions";
			
			
			
			stmt.executeUpdate(dropTableBuyers);
			stmt.executeUpdate(dropTableCars);
			stmt.executeUpdate(dropTableOffers);
			stmt.executeUpdate(dropTableSellers);
			stmt.executeUpdate(dropTableTransactions);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Koniec!");
		
		
		
		
		
		
	/*	
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
		kupiec.getTransactions().add(transakcja);
		sprzedawca.getTransactions().add(transakcja);
	
		
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
		*/
		
	}

}
