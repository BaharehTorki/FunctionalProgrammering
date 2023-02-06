package org.example.service;

import org.example.model.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import static org.example.service.QueryConstant.*;

public class DaoImpl implements Dao {
    Properties properties = new Properties();
    String host, databaseName, username, pass, url;
    Connection conn;
    Statement statement;

    public DaoImpl() {
        loadData();
        try {
            conn = DriverManager.getConnection(url, username, pass);
            System.out.println("Ansluten till databasen lyckades!");
        } catch (SQLException e) {
            System.out.println("Ansluten till databasen misslyckades!");
            e.printStackTrace();
        }
    }

    @Override
    public User findUserById(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement(KUND_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        getAddressById(rs.getInt(6)),
                        map(rs.getDate(7))
                        );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
 @Override
    public User findUserByUsername(String username) {
        try {
            PreparedStatement ps = conn.prepareStatement(KUND_BY_USERNAME);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        getAddressById(rs.getInt(6)),
                        map(rs.getDate(7))
                        );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    private Address getAddressById(int addressId) {

        try {
            PreparedStatement ps = conn.prepareStatement(ADDRESS_BY_ID);
            ps.setInt(1, addressId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Address(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        map(rs.getDate(4)),
                        map(rs.getDate(5))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean availableUser(String name, String pass) {
        return getAllUsers().stream().anyMatch((item) ->
                item.getUsername().equalsIgnoreCase(name) &&
                        item.getPass().equalsIgnoreCase(pass));
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(ALL_KUND);
            while (rs.next()) {
                users.add(new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        getAddressById(rs.getInt(6)),
                        map(rs.getDate(7))
                ));
            }
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Product findProductById(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement(PRODUCT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Product(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        CategoryType.getCategoryByValue(rs.getInt(6)),
                        SectionType.getSectionTypeByValue(rs.getInt(7)),
                        map(rs.getDate(8)),
                        map(rs.getDate(9))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> allProducts = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(ALL_PRODUCTS);
            while (rs.next()) {
                allProducts.add(new Product(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        CategoryType.getCategoryByValue(rs.getInt(6)),
                        SectionType.getSectionTypeByValue(rs.getInt(7)),
                        map(rs.getDate(8)),
                        map(rs.getDate(9))
                ));
            }
            return allProducts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Lager> getAllInLager() {
        List<Lager> lagers = new ArrayList<>();

        try (Statement statement1 = conn.createStatement()) {
            ResultSet rs = statement1.executeQuery(ALL_IN_LAGER);
            while (rs.next()) {
                lagers.add(new Lager(
                        rs.getInt(1),
                        findProductById(rs.getInt(2)),
                        rs.getInt(3),
                        map(rs.getDate(4))
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lagers;
    }

    @Override
    public List<Order> getAllOrder() {
        List<Order> orders = new ArrayList<>();

        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery(ALL_ORDERS);
            while (rs.next()) {
                orders.add(new Order(
                        rs.getString(2),
                        map(rs.getDate(3)),
                        findProductById(rs.getInt(4)),
                        findUserById(rs.getInt(5)),
                        map(rs.getDate(6))
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    @Override
    public List<Order> getAllOrderByUserId(int userId) {
        List<Order> orders = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(ALL_ORDERS_BY_USER);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                orders.add(new Order(
                        rs.getString(2),
                        map(rs.getDate(3)),
                        findProductById(rs.getInt(4)),
                        findUserById(rs.getInt(5)),
                        map(rs.getDate(6))
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    @Override
    public boolean addToCart(int kid, String bId, int pId) {
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call AddToCart(?,?,?)}");
            cs.setInt(1, kid);
            cs.setString(2, bId);
            cs.setInt(3, pId);
            cs.executeQuery();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

      private void loadData() {
        String path = this.getClass().getClassLoader().getResource("settings.properties").getPath();
        try {
            properties.load(new FileInputStream(path));
            host = properties.getProperty("host");
            databaseName = properties.getProperty("database_name");
            username = properties.getProperty("username");
            pass = properties.getProperty("password");
            url = host + databaseName;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LocalDate map(Date date) {
        if (Objects.nonNull(date)) {
            return date.toLocalDate();
        }
        return null;
    }
}
