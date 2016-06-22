package me.moriya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by andre on 6/22/16.
 */
@NoRepositoryBean
public interface GenericRepository<T> extends JpaRepository<T, Long> {
}
