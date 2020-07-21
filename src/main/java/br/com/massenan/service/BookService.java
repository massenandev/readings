package br.com.massenan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.massenan.domain.Book;
import br.com.massenan.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	public List<Book> findAll(){
		return repository.findAll();
	}
	
	public void create(Book book) {
		repository.save(book);
	}
	
	public Book findById(Long id, boolean status) {
		return repository.findById(id, status);
	}

	public Optional<Book> findById(Long id){
		return repository.findById(id);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public void update(Book book) {
		repository.saveAndFlush(book);
	}
	
	public void updateStatus(Long id, boolean status) {
		repository.updateStatus(status, id);;
	}

}
