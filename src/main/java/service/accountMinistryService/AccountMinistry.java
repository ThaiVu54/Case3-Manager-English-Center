package service.accountMinistryService;

import config.ConnectSingleton;
import model.Ministry;
import model.MinistryAccout;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountMinistry implements IAccountMinistry {
    private Ministry ministry = new Ministry();
    private MinistryAccout ministryAccout = new MinistryAccout();
    public static final String SELECT_FROM_MINISTRYACCOUNT = "select * from ministryaccount";

    @Override
    public List<MinistryAccout> showAccMinistry() throws SQLException {
        List<MinistryAccout> accoutList = new ArrayList<>();
        Connection connection = ConnectSingleton.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_MINISTRYACCOUNT);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("username");
            String password = resultSet.getString("password");
            int ministry_id = resultSet.getInt("ministry_id");
            accoutList.add(new MinistryAccout(name, password, ministry_id));
        }
        return accoutList;
    }

    @Override
    public void addAccMinistry(Ministry ministry) throws SQLException {

    }

    @Override
    public boolean updateAccMinistry(MinistryAccout ministryAccout) throws SQLException {
        boolean rowUpdated = false;
        Connection connection = ConnectSingleton.getConnection();
        String query = "{CALL update_account_ministry(?,?,1)}";
        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setString(1,ministryAccout.getUserName());
        callableStatement.setString(2,ministryAccout.getPassword());

        rowUpdated=callableStatement.executeUpdate()>0;


        return rowUpdated;
    }

    @Override
    public boolean deleteAccMinistry(int id) throws SQLException {
        return false;
    }
}
