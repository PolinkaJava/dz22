package by.teachmeskills.polinka.repository;

import by.teachmeskills.polinka.entity.User;

import java.util.Collection;

public interface ShopRepository {
    public  void  add(User user);

    void deleteById(Long userId);

    public Collection<User>allUsers();


}