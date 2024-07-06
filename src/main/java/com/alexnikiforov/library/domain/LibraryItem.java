package com.alexnikiforov.library.domain;

public abstract class LibraryItem {
    private static long idCounter = 1;
    protected Long id;
    protected String title;

    protected Member borrower;

    public LibraryItem(String title) {
        this.title = title;
        id = generateId();
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

    public void setName(String title) {
        this.title = title;
    }

    public void borrow(Member member) {
        this.borrower = member;
    }

    public String getBorrowerName() {
        return borrower != null ? borrower.getName() : "No borrower";
    }

    private Long generateId() {
        return idCounter++;
    }
}
