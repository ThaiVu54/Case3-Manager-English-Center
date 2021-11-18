package service.ministryService;

import model.Ministry;

import java.sql.SQLException;
import java.util.List;

public interface IMinistry4 {
    List<Ministry> showMinistry4();

    void addMinistry4(Ministry ministry) throws SQLException;

    boolean updateMinistry4(Ministry ministry) throws SQLException;

    boolean deleteMinistry4(int id) throws SQLException;

    Ministry findById (int id);
}
