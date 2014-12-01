package repositories.impl.mySqlImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Entity;

public interface IEntityBuilder<TEntity extends Entity> {
	
	
// metoda tworz�ca obiekt danego typu (TEntity) z p�l pozyskanych z zapytania sql-owego 
//    i przechowywanych w Result Secie
	public TEntity build(ResultSet rs) throws SQLException;
}
