package unitofwork;

import domain.Entity;

public interface IUnitOfWork {

	public void commit();   // metoda "wrzucaj�ca" list� zmian (hashMap�) na serwer bazy danych
	public void rollback();	// czy�li list� zmian do wprowadzenia
	
	 //poni�sze metody ustawiaj� flag� encji na odpowiedni symbol (New, Changed, Deleted) i dodaj� encj� do listy (hashmapy) zmian do wprowadzenia
	public void markAsNew(Entity entity, IUnitOfWorkRepository repository); 
	public void markAsDirty(Entity entity, IUnitOfWorkRepository repository);
	public void markAsDeleted(Entity entity, IUnitOfWorkRepository repository);
	
}
