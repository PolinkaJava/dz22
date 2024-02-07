package by.teachmeskills.polinka.repository;

import by.teachmeskills.polinka.entity.User;
import by.teachmeskills.polinka.repository.FileRepository;
import by.teachmeskills.polinka.repository.ShopRepository;

import java.security.cert.Extension;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       FileRepository repository = new FileRepository() {
            @Override
            public void deleteById(Long userId) {

            }
        };


        User user1 = new User();
        user1.setId(1L);
        user1.setName("Иван");
        user1.setSurname("Иванов");
        user1.setLogin("ivanov");
        user1.setPassword("password1");

        User user2 = new User();
        user2.setId(2l);
        user2.setName("Петр");
        user2.setSurname("Петров");
        user2.setLogin("petrov");
        user2.setPassword("password2");

        repository.add(user1);
        repository.add(user2);
        System.out.println("Все пользователи:");
        for (User user : repository.allUsers()) {
            System.out.println(user);
        }
        repository.deleteById(1l);



    }
}



