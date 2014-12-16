package unitofwork;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import domain.Entity;
import domain.EntityState;

public class UnitOfWork implements IUnitOfWork {

	private Connection connection;
	
		// Jest to mapa, która przechowuje "rekordy" w postaci encja-repozytorium, przygotowane do za³adowania do bazy danych
	private HashMap<Entity, IUnitOfWorkRepository> entities =
			new LinkedHashMap<Entity, IUnitOfWorkRepository>();
	
	
	public UnitOfWork(Connection connection) {
		this.connection = connection;
		
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void commit() {
		
		/* Dla ka¿dej encji ze zbioru dodanych wczeœniej do mapy oraz oznaczonych odpowiedni¹ "flaga"
		 *  za pomoc¹ metod add, update i delete wykonujemy (z pomoc¹ switcha) odpowiednie dla ka¿dego
		 *  z oznaczeñ metodê (persist...()), która z kolei wykonuje ju¿ faktyczne zapytanie SQL, natomiast
		 *  NIE WPROWADZA jeszcze zmian na serwerze. Czeka na komendê connection.commit(), gdy¿ automatyczny 
		 *  commit zosta³ zawieszony w konstruktorze tej klasy (connection.setAutoCommit(false)) */
		
		for(Entity entity: entities.keySet()) {
			
			switch(entity.getState()) {
			
			case Changed:
				entities.get(entity).persistUpdate(entity);
				break;
			case Deleted:
				entities.get(entity).persistDelete(entity);
				break;
			case New:
				entities.get(entity).persistAdd(entity);
				break;
			case Unchanged:
				break;
			default:
				break;
			
			}
		}
			
		
			try {
				
				// w tym miejscu wykonujemy faktyczny "update" bazy danych
				connection.commit();
				// czyœcimy listê zapytañ do wprowadzenia
				entities.clear();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void rollback() {

		entities.clear();		
	}

	@Override
	public void markAsNew(Entity entity, IUnitOfWorkRepository repository) {

		entity.setState(EntityState.New);
		entities.put(entity, repository);
		
	}

	@Override
	public void markAsDirty(Entity entity, IUnitOfWorkRepository repository) {
		
		entity.setState(EntityState.Changed);
		entities.put(entity, repository);
		
	}

	@Override
	public void markAsDeleted(Entity entity, IUnitOfWorkRepository repository) {
		
		entity.setState(EntityState.Deleted);
		entities.put(entity, repository);
		
	}

	public HashMap<Entity, IUnitOfWorkRepository> getEntities() {
		return entities;
	}

	public void setEntities(HashMap<Entity, IUnitOfWorkRepository> entities) {
		this.entities = entities;
	}
	
	
	

}
