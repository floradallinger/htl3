package at.htl.su_2025_03_12_contactmanager.database;

import at.htl.su_2025_03_12_contactmanager.model.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactRepository {
    private Connection connection;

    public ContactRepository() {
        connection = Database.getInstance().getConnection();
    }

    public List<Contact> getAllContact() {
        List<Contact> contactList = new ArrayList<>();
        String sql = "SELECT * FROM contact";

        try(Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql)
        ) {
            while (rs.next()) {
                contactList.add(new Contact(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("address")
                        )

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactList;
    }

    public void addContact(String name, String phone, String address) {
        String sql = "INSERT INTO contact (name, phone, address) VALUES(?, ?, ?)";

        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setString(3, address);
            pstmt.executeUpdate();

            // get auto-generated ID
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateContact(Contact contact) {
        // TODO
    }

    public void deleteContact(int id) {
        // TODO
    }
}
