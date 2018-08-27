package com.reactSpringboot1.SpringReactdemo.payLoads;

import java.util.List;

public class PagedResponse<T> {

	private List<T>content;
	private int page;
	private int size;
	private Long totalElements;
	public PagedResponse(List<T> content, int page, int size,
			Long totalElements, Long totalPages, boolean last) {

		this.content = content;
		this.page = page;
		this.size = size;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.last = last;
	}
	public PagedResponse() {
	
	}
	private Long totalPages;
	private boolean last;
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	public Long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
}
