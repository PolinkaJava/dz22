package by.teachmeskills.polinka;

import by.teachmeskills.polinka.entity.User;
import by.teachmeskills.polinka.repository.ShopRepository;

import java.util.Collection;
import java.io.*;
import java.util.*;

//import static jdk.internal.org.jline.utils.InfoCmp.Capability.user1;

public class FileRepository implements ShopRepository {
    private final String filePath = "resources/user.ser";
    private List<User> users;

    public FileRepository() {

        users = deserializeUsers();
    }

    @Override
    public void add(User user) {
        users.add(user);
        serializeUsers();
    }

    @Override
    public void deleteById(Long userId) {
        users.removeIf(user -> user.getId().equals(userId));
    serializeUsers();
    }


    @Override
    public Collection<User> allUsers() {
        return users;
    }




    private void serializeUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(users);
            System.out.println("Сериализация успешна. Количество пользователей: " + users.size());
        } catch (IOException e) {
            System.err.println("Ошибка при сериализации пользователей: " + e.getMessage());
        }
    }

    private List<User> deserializeUsers() {
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при десериализации пользователей: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
