package br.com.massenan.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.massenan.domain.Book;

public class BookDto {

	private Long id;
	private String title;
	private String author;
	private Integer year;
	private LocalDateTime initReadDt;
	private LocalDateTime updatedDt;
	private Long totalPages;
	private Long currentPage;
	private String genre;
	private boolean status;
	private Integer rate;

	public static Book parse(BookDto dto) {
		Book b = new Book();
		b.setTitle(dto.getTitle());
		b.setAuthor(dto.getAuthor());
		b.setYear(dto.getYear());
		b.setInitReadDt(dto.getInitReadDt());
		b.setUpdatedDt(dto.getUpdatedDt());
		b.setTotalPages(dto.getTotalPages());
		b.setCurrentPage(dto.getCurrentPage());
		b.setGenre(dto.getGenre());
		b.setStatus(dto.isStatus());
		b.setRate(dto.getRate());
		return b;
	}

	public static List<BookDto> parse(List<Book> books) {
		List<BookDto> bks = new ArrayList<BookDto>();
		books.forEach(b -> bks.add(parse(b)));
		return bks;
	}

	public static BookDto parse(Book book) {
		BookDto dto = new BookDto();
		dto.setTitle(book.getTitle());
		dto.setAuthor(book.getAuthor());
		dto.setYear(book.getYear());
		dto.setInitReadDt(book.getInitReadDt());
		dto.setUpdatedDt(book.getUpdatedDt());
		dto.setTotalPages(book.getTotalPages());
		dto.setCurrentPage(book.getCurrentPage());
		dto.setGenre(book.getGenre());
		dto.setStatus(book.isStatus());
		dto.setRate(book.getRate());
		return dto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public LocalDateTime getInitReadDt() {
		return initReadDt;
	}

	public void setInitReadDt(LocalDateTime initReadDt) {
		this.initReadDt = initReadDt;
	}

	public LocalDateTime getUpdatedDt() {
		return updatedDt;
	}

	public void setUpdatedDt(LocalDateTime updatedDt) {
		this.updatedDt = updatedDt;
	}

	public Long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}

	public Long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDto other = (BookDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookDto [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", initReadDt="
				+ initReadDt + ", updatedDt=" + updatedDt + ", totalPages=" + totalPages + ", currentPage="
				+ currentPage + ", genre=" + genre + ", status=" + status + ", rate=" + rate + "]";
	}

}
