package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sales.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>
{
	/* Do not need to manually implement anything here because the function findAll which is called
	 * in the BookRepository is contained in the CrudRepository interface
	 */
}// BookRepository
