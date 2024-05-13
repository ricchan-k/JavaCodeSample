package repository;

import domain.User;

public interface UserRepository {
    User findUserById(String userId);
}