package mml.wallet.domain.repositories;

import mml.wallet.domain.entities.User;

public interface UserRepository {
    User findByDocumentNumber(String documentNumber);

    void save(User user);

    void update(User user);

    void delete(String documentNumber);
}
