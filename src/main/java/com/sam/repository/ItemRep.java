package com.sam.repository;

import com.sam.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by samchu on 2016/12/6.
 * http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 */
@RepositoryRestResource(path = "item", collectionResourceRel = "item")
public interface ItemRep extends PagingAndSortingRepository<Item, Long> {

    Page<Item> findByNameContaining(@Param("name") String name, Pageable pageable);

    Page<Item> findByPriceBetween(@Param("minprice")Integer minprice, @Param("maxprice")Integer maxprice, Pageable pageable);
}
