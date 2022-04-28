package com.gagoo.faq.vo;

public class FaqVO {
	private Long no;
	private String title, contnet, writer, writeDate;
	private Long hit;
	
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContnet() {
		return contnet;
	}
	public void setContnet(String contnet) {
		this.contnet = contnet;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public Long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	@Override
	public String toString() {
		return "FaqVO [no=" + no + ", title=" + title + ", contnet=" + contnet + ", writer=" + writer + ", writeDate="
				+ writeDate + ", hit=" + hit + "]";
	}
	
	

}
