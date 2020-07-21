package br.com.massenan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.massenan.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
	@Query("SELECT b FROM Book b WHERE b.id = ?1 AND b.status = ?2")
	Book findById(Long id, boolean status);

	@Transactional
	@Modifying
	@Query("UPDATE Book b SET b.status = ?1 WHERE b.id = ?2")
	public void updateStatus(boolean status, Long id);

}
