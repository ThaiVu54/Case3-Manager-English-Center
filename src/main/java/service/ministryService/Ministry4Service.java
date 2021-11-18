package service.ministryService;

import model.Ministry;

import java.sql.SQLException;
import java.util.List;

public class Ministry4Service implements IMinistry4 {
    @Override
    public List<Ministry> showMinistry4() {
        return null;
    }

    @Override
    public void addMinistry4(Ministry ministry) throws SQLException {

    }

    @Override
    public boolean updateMinistry4(Ministry ministry) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteMinistry4(int id) throws SQLException {
        return false;
    }

    @Override
    public Ministry findById(int id) {
        return null;
    }

}
