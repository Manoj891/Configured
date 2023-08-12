package com.model.library;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lib_book_issue")
public class LibBookIssue implements java.io.Serializable {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "BOOK_ID")
    private String bookId;
    @Column(name = "STU_ID", nullable = true)
    private Long stuId;
    @Column(name = "STAFF_ID", nullable = true)
    private Long staffId;
    @Column(name = "ISSUE_DATE", nullable = false)
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date issueDate;
    @Column(name = "ISSUE_FOR_DAY")
    private Integer issueForDay;
    @Column(name = "BOOK_ISSUE_ID", unique = true, nullable = true)
    private String bookIssueId;
    @Column(name = "RETURN_DATE", nullable = true)
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date returnDate;
    @Column(name = "ISSUE_BY")
    private String issueBy;
    @Column(name = "RETURN_BY")
    private String returnBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Integer getIssueForDay() {
        return issueForDay;
    }

    public void setIssueForDay(Integer issueForDay) {
        this.issueForDay = issueForDay;
    }

    public String getBookIssueId() {
        return bookIssueId;
    }

    public void setBookIssueId(String bookIssueId) {
        this.bookIssueId = bookIssueId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getIssueBy() {
        return issueBy;
    }

    public void setIssueBy(String issueBy) {
        this.issueBy = issueBy;
    }

    public String getReturnBy() {
        return returnBy;
    }

    public void setReturnBy(String returnBy) {
        this.returnBy = returnBy;
    }

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"bookId\": \"" + bookId + "\",\"stuId\": \"" + stuId + "\",\"staffId\": \"" + staffId + "\",\"issueDate\": \"" + issueDate + "\",\"issueForDay\": \"" + issueForDay + "\",\"bookIssueId\": \"" + bookIssueId + "\",\"returnDate\": \"" + returnDate + "\"}";
    }
}
