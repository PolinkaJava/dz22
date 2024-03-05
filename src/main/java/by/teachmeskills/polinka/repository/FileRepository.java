
package by.teachmeskills.polinka.repository;

import by.teachmeskills.polinka.entity.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileRepository implements UserRepository {
    private final String filePath = "C:\\Users\\user\\Desktop\\Maven\\project2\\src\\main\\resources\\Users";
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
    public List<User> allUsers() {
        return users;
    }

    public User authentication(String login, String password){
        for (User user: users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new RuntimeException("Пользователь с таким логином не найдены");
    }
    public long userIdGenerator(){
        return users.size()+1;
    }
    private void serializeUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(users);

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


