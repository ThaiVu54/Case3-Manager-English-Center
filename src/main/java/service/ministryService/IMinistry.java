package service.ministryService;

import model.Ministry;

import java.sql.SQLException;
import java.util.List;

public interface IMinistry {
     List<Ministry> showMinistry();

     void addMinistry(Ministry ministry) throws SQLException;

     boolean updateMinistry(Ministry ministry) throws SQLException;

     boolean deleteMinistry(int id) throws SQLException;

     Ministry findById (int id);

     List<Ministry> showUserPass() throws SQLException;

     List<Ministry> showAllMinistry() throws SQLException;
}
