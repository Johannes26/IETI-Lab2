package org.ada.school.repository;

import org.ada.school.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface UserRepository extends MongoRepository<UserDocument, String> {
    List<UserDocument> findByNameLikeOrLastNameLike(String queryText, String queryText2);

    List<UserDocument> findByCreatedAtAfter(Date startDate);
}


