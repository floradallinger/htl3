package at.htl.su_2025_03_12_contactmanager;

import at.htl.su_2025_03_12_contactmanager.database.ContactRepository;
import at.htl.su_2025_03_12_contactmanager.database.Database;
import at.htl.su_2025_03_12_contactmanager.model.Contact;

import java.util.List;

public class DbTest {

    public static void main(String[] args) {
        Database database = Database.getInstance();
        ContactRepository contactRepository = new ContactRepository();

        contactRepository.addContact("Hans", "1234", "Linz");
        contactRepository.addContact("Hans", "1234", "Linz");

        List<Contact> contacts = contactRepository.getAllContact();
        contacts.forEach(System.out::println);
    }
}
