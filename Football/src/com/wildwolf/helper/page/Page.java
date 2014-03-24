package com.wildwolf.helper.page;

public class Page {
	
	private boolean isPage = false;
	
	public long getBeginRow() {
		return beginRow;
	}

	public void setBeginRow(long beginRow) {
		this.beginRow = beginRow;
	}

	public long getEndRow() {
		return endRow;
	}

	public void setEndRow(long endRow) {
		this.endRow = endRow;
	}

	private long beginRow;
	
	private  long endRow;

	public boolean isPage() {
		return isPage;
	}

	public void setPage(boolean isPage) {
		this.isPage = isPage;
	}

}
