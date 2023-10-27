package br.com.fiap.epictask.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public void addScore(User user, Integer score) {
        var opt = repository.findById(user.getId());

        if (opt.isEmpty())
            throw new RuntimeException("usuário não encontrado");

        var userDb = opt.get();

        userDb.setScore(userDb.getScore() + score);
        repository.save(userDb);

    }
    
}
