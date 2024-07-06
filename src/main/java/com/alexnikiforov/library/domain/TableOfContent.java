package com.alexnikiforov.library.domain;

import java.util.List;

public class TableOfContent {
    List<TableOfContentItem> items;

    private record TableOfContentItem(
            int chapterNumber,
            String chapterName,
            String description,
            int pageNumber
    ) {
    }
}
