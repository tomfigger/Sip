package com.feige.init.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PageList<T> {
    @SerializedName("result")
    private List<T> list;
    @SerializedName("page")
    private PageDTO page;
    @SerializedName("pageIndex")
    private Integer pageIndex;
    @SerializedName("pageSize")
    private Integer pageSize;
    @SerializedName("totalCount")
    private Integer totalCount;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }


    public PageDTO getPage() {
        return page;
    }

    public void setPage(PageDTO page) {
        this.page = page;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public static class PageDTO {
        @SerializedName("pageIndex")
        private Integer pageIndex;
        @SerializedName("pageSize")
        private Integer pageSize;
        @SerializedName("totalCount")
        private Integer totalCount;

        public Integer getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(Integer pageIndex) {
            this.pageIndex = pageIndex;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public Integer getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }
    }
}
