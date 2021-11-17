package service.accountMinistryService;

import model.Ministry;
import model.MinistryAccout;

import java.sql.SQLException;
import java.util.List;

public interface IAccountMinistry {
    List<MinistryAccout> showAccMinistry() throws SQLException;

    void addAccMinistry(Ministry ministry) throws SQLException;

    boolean updateAccMinistry(Ministry ministry) throws SQLException;

    boolean deleteAccMinistry(int id) throws SQLException;
}
