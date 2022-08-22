package com.nxg.bean;


import java.util.Date;

/**
 * @author nxg
 * date 2022/8/8 08 18
 * @apiNote
 */
public class Book {
    private int bookId;
    private String bookName;
    private int issueCount;
    private Date issuedDate;
    private int bookState;

    public Book() {
    }

    public Book(int bookId, String bookName, int issueCount, Date issuedDate, int bookState) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.issueCount = issueCount;
        this.issuedDate = issuedDate;
        this.bookState = bookState;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getIssueCount() {
        return issueCount;
    }

    public void setIssueCount(int issueCount) {
        this.issueCount = issueCount;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public int getBookState() {
        return bookState;
    }

    public void setBookState(int bookState) {
        this.bookState = bookState;
    }
}
