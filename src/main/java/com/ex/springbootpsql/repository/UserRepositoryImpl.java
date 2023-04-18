package com.ex.springbootpsql.repository;

import com.ex.springbootpsql.entity.QUser;
import com.ex.springbootpsql.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    private final EntityManager entityManager;

    @Override
    public List<User> findUserAll() {
        return jpaQueryFactory
                .selectFrom(QUser.user)
                .fetch();
    }

    @Override
    public User findUserBySeq(Long seq) {
        QUser user = QUser.user;
        return jpaQueryFactory
                .selectFrom(QUser.user)
                .where(user.userSeq.eq(seq))
                .fetchFirst();
    }

    @Override
    public void updateUser(Long seq, String updateId) {
        QUser user = QUser.user;
        long update = jpaQueryFactory
                .update(user)
                .set(user.userId, updateId)
                .where(user.userSeq.eq(seq))
                .execute();

        entityManager.flush();
        entityManager.clear();
    }

    @Override
    public void deleteUser(Long seq) {
        QUser user = QUser.user;
        long delete = jpaQueryFactory
                .delete(user)
                .where(user.userSeq.eq(seq))
                .execute();

        entityManager.flush();
        entityManager.clear();
    }

    @Override
    public void deleteUserAll() {
        QUser user = QUser.user;
        long delete = jpaQueryFactory
                .delete(user)
                .execute();

        entityManager.flush();
        entityManager.clear();
    }
}
