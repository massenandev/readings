package br.com.massenan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.massenan.dto.BookDto;
import br.com.massenan.service.BookService;

@Controller
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/loadAll")
	public ResponseEntity<?> findAll(){
		
		try {
			return ResponseEntity.ok().body(BookDto.parse(bookService.findAll()));
		} catch (Exception ex) {
			logger.error("[LOADING-ALL-BOOKS]", ex.fillInStackTrace());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.ok(BookDto.parse(bookService.findById(id).get()));
	}
	
	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody BookDto bookDto) {
		
		try {
			bookService.create(BookDto.parse(bookDto));
			return new ResponseEntity<>(BookDto.parse(bookService.findAll()), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(BookDto bookDto){
		try {
			bookService.update(BookDto.parse(bookDto));
			return ResponseEntity.ok("Book updated successfully!");
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/status/{status}/id/{id}")
	public ResponseEntity<?> setStatus(@PathVariable boolean status, @PathVariable Long id){
		
		try {
			bookService.updateStatus(id, status);
			return ResponseEntity.ok().body(BookDto.parse(bookService.findAll()));
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
