package com.book.online.entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{
    private static final long serialVersionUID = -6896474871318208110L;
    private Long bookId;
    private String isbn;
    private String bookName;
    private String author;
    private String publisher;
    private Date publish_date;
    private double oldPrice;
    private double newPrice;
    private String author_loc;
    private BookStyle style_id;
    private String info;
    private String imageUrl;
    public Book() {
        super();
    }
    public Book(String isbn, String bookName, String author, String publisher, Date publish_date, double oldPrice,
            double newPrice, String author_loc, BookStyle style_id, String info, String imageUrl) {
        super();
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.publish_date = publish_date;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.author_loc = author_loc;
        this.style_id = style_id;
        this.info = info;
        this.imageUrl = imageUrl;
    }
    public Long getBookId() {
        return bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public Date getPublish_date() {
        return publish_date;
    }
    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }
    public double getOldPrice() {
        return oldPrice;
    }
    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }
    public double getNewPrice() {
        return newPrice;
    }
    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }
    public String getAuthor_loc() {
        return author_loc;
    }
    public void setAuthor_loc(String author_loc) {
        this.author_loc = author_loc;
    }
    public BookStyle getStyle_id() {
        return style_id;
    }
    public void setStyle_id(BookStyle style_id) {
        this.style_id = style_id;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
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
        Book other = (Book) obj;
        if (bookId == null) {
            if (other.bookId != null)
                return false;
        } else if (!bookId.equals(other.bookId))
            return false;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", isbn=" + isbn + ", bookName=" + bookName + ", author=" + author
                + ", publisher=" + publisher + ", publish_date=" + publish_date + ", oldPrice=" + oldPrice
                + ", newPrice=" + newPrice + ", author_loc=" + author_loc + ", style_id=" + style_id + ", info=" + info
                + ", imageUrl=" + imageUrl + "]";
    }
    
}
