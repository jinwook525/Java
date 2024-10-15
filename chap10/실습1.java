package chap10;

import java.util.Arrays;

//Book 클래스

class Book {

	private String title;
	private String author;
	private int publicationYear;
	private String isbn;
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
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Book(String title, String author, int publicationYear, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}
	public Book() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
				+ "]";
	}
	
}



//Library 클래스

class Library {

	static final int CAPACITY = 20;
	private Book[] books;
	private int top;
	public void printBooks(String msg) {
		System.out.println(msg + " 도서숫자 = " + top);
		for(int i=0; i <top ; i++) {
			System.out.println(books[i].toString());
		}
		
	}
	
	 

	public Library() {
		books = new Book[CAPACITY];
		}

	public Book[] getBooks() {
		return books;
	}
	public void setBooks(Book[] books) {
		this.books = books;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public Library(Book[] books, int top) {
		super();
		this.books = books;
		this.top = top;
	}
	public void sortBooksByTitle(){
		//String의 compareTo() 사용
		Arrays.sort(books, 0, top, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));//9.3.3 Arrays 클래스
	}
	public void sortBooksByISBN(){
		Arrays.sort(books, 0, top, (b1, b2) -> b1.getIsbn().compareTo(b2.getIsbn()));
	}
	public Book searchBookByTitle(String title) {
		for (int i = 0; i < top; i++) {
	        if (books[i].getTitle().equals(title)) {
	            return books[i];
	        }
	    }
	    return null;
	}

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		 if (top < CAPACITY) {
		        books[top++] = book;
		    } else {
		        System.out.println("가득 찼습니다.");
		    }
	}
}

public class 실습1 {

	public static void main(String[] args) {
		Object obj = new Book();
		obj.hashCode();
		Book bk = new Book();

		Library library = new Library();
		String st = "java";
		String st2 = "java";//string interning

		//the process of storing one unique instance of each distinct string value in a pool to optimize memory,

		//so that multiple references to the same string literal point to the same memory location.

		if (st.equals(st2))

			System.out.println("st == st2");

		//5개의 Book 객체 초기화

		//5개의 책 객체 초기화

		Book book1 = new Book("자바", "강감찬", 1995, "12");
		Book book2 = new Book("파이썬", "이순신", 2008, "9");
		Book book3 = new Book("자바스크립트", "을지문덕", 2008, "8");
		Book book4 = new Book("자료구조", "연개소문", 1994, "45");
		Book book5 = new Book("리액트", "김춘추", 1999, "7");

		//책 추가

		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		library.addBook(book5);

		//도서 목록 출력

		library.printBooks("\n제목정렬전");
		//도서 목록 정렬
		library.sortBooksByTitle();
		//정렬된 도서 목록 출력
		library.printBooks("\n제목정렬후");
		//특정 제목으로 도서 검색
		library.printBooks("\nISBN정렬전");
		//도서 목록 정렬
		library.sortBooksByISBN();
		//정렬된 도서 목록 출력
		library.printBooks("\nISBN정렬후");
		//특정 제목으로 도서 검색

		String searchTitle = "자바";
		Book foundBook = library.searchBookByTitle(searchTitle);

		if (foundBook == null)
			System.out.println("\n자바 책이 없다");
		else
			System.out.println("\n도서명으로 검색한 도서" + foundBook.toString());

	}

}
 
