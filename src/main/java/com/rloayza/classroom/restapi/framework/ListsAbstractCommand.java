package com.rloayza.classroom.restapi.framework;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public abstract class ListsAbstractCommand implements Command {

    private Integer pageSize;

    private Integer pageNumber;

    private String search;


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public final Pageable getPageable() {

        if(null == getPageSize()) {
            return Pageable.unpaged();
        }

        return PageRequest.of(getPageNumber(), getPageSize());
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
