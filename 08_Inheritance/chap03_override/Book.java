package com.kh.chap03_override.model.vo;

public class Book /*extend Object*/ {
	
	private String title;
	private String author;
	private int price;
	
	// �⺻������
	public Book() {
		
	}
	
	// �Ű����� ������
	
	public Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	//setter
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	//getter
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getPrice() {
		return price;
	}
	
	/*
	 * * �������̵�
	 * - �ڽ�Ŭ������ ��ӹް� �ִ� �θ�Ŭ������ �޼ҵ带 ������(���ۼ�)�ϴ� ��
	 * - �θ� �����ϰ� �ִ� �޼ҵ带 �ڽ��� �Ϻ� ���ļ� ����ϰڴٴ� �ǹ�
	 *   �ڽ� ��ü�� ���� ���� �� �ڽĸ޼ҵ尡 �켱���� ����!!
	 *   
	 * * �������̵� ���� ����
	 * - �θ�޼ҵ��� �����ϰ� �ۼ�
	 * - �Ű����� ����, �ڷ���, ���� ���� (�Ű��������� �������)
	 * - �θ�޼ҵ��� ��ȯ�� ����(jdk �������� �Ǹ鼭 �θ�޼ҵ��� ��ȯ���� �ڽ� �ڷ�����δ� ����)
	 * - �θ�޼ҵ��� ���������ں��� ������ ���ų� Ŀ���Ѵ�!
	 *   ex) �θ�޼ҵ��� ���������ڰ� protected�� ��� �������̵��ϴ� �ڽ�Ŭ������ �޼ҵ� ���������ڴ�
	 *       protected, public �� �߿� �����ϴ�!
	 *       
	 *  
	 *  => ��Ģ�� ������ �� ����(�ʰ� �������Ҳ��� �� ������ ��Ģ�� ������!!)
	 *  
	 * * @Override ������̼�
	 * - ���� ���� �� (������� �ʾƵ� �������)
	 * - ������̼��� ���̴� ���� 
	 *   >> �θ� �޼ҵ���̳� �Ű������� ���� �� ��� => ������ �����ٷ� ǥ�õǱ� ������ ã�ƺ��� ����! 
	 *      �ڽ� �޼ҵ� ��� �� ��Ÿ�� ���� ��� => ã�ƺ��� ����
	 *   >> ���� �ش� �޼ҵ带 �������̵� �� �޼ҵ��� �˸��� �; 
	 */
	
	@Override
	public String toString() {
		return "title= " + title + ", author= " + author + ", price" + price;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
