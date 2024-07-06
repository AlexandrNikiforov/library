package com.alexnikiforov.library.domain;


public class Member {
    public String name;

    private LibraryItem borrowedItem;

    public Member(String name) {
        this.name = name;
    }

    public void borrowItem(LibraryItem item) {
        this.borrowedItem = item;
        item.borrow(this);
    }

    public String getBorrowedItemTitle() {
        return borrowedItem != null ? borrowedItem.getTitle() : "No item borrowed";
    }

    public String getName() {
        return name;
    }
}
