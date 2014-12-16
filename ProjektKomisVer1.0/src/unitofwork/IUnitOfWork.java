package unitofwork;

import domain.Entity;

public interface IUnitOfWork {

	public void commit();   // metoda "wrzucaj¹ca" listê zmian (hashMapê) na serwer bazy danych
	public void rollback();	// czyœli listê zmian do wprowadzenia
	
	 //poni¿sze metody ustawiaj¹ flagê encji na odpowiedni symbol (New, Changed, Deleted) i dodaj¹ encjê do listy (hashmapy) zmian do wprowadzenia
	public void markAsNew(Entity entity, IUnitOfWorkRepository repository); 
	public void markAsDirty(Entity entity, IUnitOfWorkRepository repository);
	public void markAsDeleted(Entity entity, IUnitOfWorkRepository repository);
	
}
