package com.model.library;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import model.DateConveter;

@Entity
@Table(name = "lib_book_stock", uniqueConstraints = @UniqueConstraint(columnNames = {"BOOK_ID", "BOOK_SN"}, name = "BOOK_ID"))
public class LibBookStock implements java.io.Serializable {

    @Id
    @Column(name = "ID", columnDefinition = "VARCHAR(13)")
    private String id;
    @Column(name = "ISBN", columnDefinition = "VARCHAR(100)")
    private String isbn;
    @Column(name = "BOOK_ID")
    private Long bookId;
    @Column(name = "BOOK_SN")
    private Integer bookSn;
    @Column(name = "PROGRAM")
    private Long program;
    @Column(name = "CLASS_ID")
    private Long classId;
    @Column(name = "BOOK_TYPE")
    private Long bookType;
    @Column(name = "SUBJECT")
    private Long subject;
    @Column(name = "QUANTITY")
    private Long quantity;
    @Column(name = "NAME", columnDefinition = "TEXT CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String name;
    @Column(name = "PUBLICATION")
    private String publication;
    @Column(name = "LANGUAGE")
    private String language;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "EDITION")
    private String edition;
    @Column(name = "PAGES")
    private Integer pages;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "RACK_NO")
    private String rackNo;
    @Column(name = "vendor")
    private String vendor;
    @Column(name = "PURCHASE_DATE")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

    public LibBookStock() {
    }

    public LibBookStock(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookId() {
        try {
            return bookId.toString();
        } catch (Exception e) {
        }
        return "null";
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getBookSn() {
        return bookSn;
    }

    public void setBookSn(Integer bookSn) {
        this.bookSn = bookSn;
    }

    public String getProgram() {
        try {
            if (program == null) {
                return "";
            }
        } catch (Exception e) {
        }
        return program.toString();
    }

    public void setProgram(Long program) {
        this.program = program;
    }

    public String getClassId() {
        try {
            if (classId == null) {
                return "";
            }
        } catch (Exception e) {
        }
        return classId.toString();
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getBookType() {
        return bookType;
    }

    public void setBookType(Long bookType) {
        this.bookType = bookType;
    }

    public String getSubject() {
        try {
            if (subject == null) {
                return "";
            }
        } catch (Exception e) {
        }
        return subject.toString();
    }

    public void setSubject(Long subject) {
        this.subject = subject;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRackNo() {
        return rackNo;
    }

    public void setRackNo(String rackNo) {
        this.rackNo = rackNo;
    }

    public String getPurchaseDate() {
        return DateConveter.adToBs(purchaseDate);
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = DateConveter.bsToAdDate(purchaseDate);
    }

    public Date getPurchaseDateAd() {
        return purchaseDate;
    }

    public void setPurchaseDateAd(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"bookId\": \"" + bookId + "\",\"language\": \"" + language + "\",\"isbn\": \"" + isbn + "\",\"quantity\": \"" + quantity + "\",\"bookSn\": \"" + bookSn + "\",\"program\": \"" + program + "\",\"classId\": \"" + classId + "\",\"bookType\": \"" + bookType + "\",\"subject\": \"" + subject + "\",\"name\": \"" + name + "\",\"publication\": \"" + publication + "\",\"language\": \"" + language + "\",\"author\": \"" + author + "\",\"edition\": \"" + edition + "\",\"pages\": \"" + pages + "\",\"price\": \"" + price + "\",\"rackNo\": \"" + rackNo + "\",\"language\": \"" + language + "\"}";
    }
}
