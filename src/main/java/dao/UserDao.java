package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public boolean registerUser(User user){

        boolean flag = false;

        try {
            String query = "insert into user(firstname, lastname, email, mobile, dob, address, gender, city, password) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getMobile());
            preparedStatement.setString(5, user.getDob());
            preparedStatement.setString(6, user.getAddress());
            preparedStatement.setString(7, user.getGender());
            preparedStatement.setString(8, user.getCity());
            preparedStatement.setString(9, user.getPassword());

            preparedStatement.executeUpdate();
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

    public List<User> getAllUsers(){

        List<User> users = new ArrayList<>();
    try {
        String query = "select * from user";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        ResultSet set = preparedStatement.executeQuery();
        while (set.next()){
            User user = new User(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getString(8), set.getString(9), set.getString(10));
            users.add(user);
        }
    }catch (Exception e){
        e.printStackTrace();
        }
        return users;
    }


}
