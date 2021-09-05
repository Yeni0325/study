package com.kh.chap01_oneVSmany.run;

import java.util.Scanner;

import com.kh.chap01_oneVSmany.model.vo.Book;

public class ObjectArrayRun {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// ��ü �迭 Ȱ���ؼ� �غ���!!
		// �� ���� Book ��ü�� �����Ѵٸ�?
		
		Book[] books = new Book[3];
		
		// �� ������ ���� ������ �ݺ������� �Է¹޾� �� �ε����� ��ü ����
		for(int i=0; i<books.length; i++) { // i=0, i=1, i=2
			
			System.out.println((i+1) + "��° ���� ���� �Է�");
			
			System.out.print("������ : ");
			String title = sc.nextLine();
			
			System.out.print("���ڸ� : ");
			String author = sc.nextLine();
			
			System.out.print("���� : ");
			int price = sc.nextInt();
			
			sc.nextLine();
			
			System.out.print("���ǻ� : ");
			String publisher = sc.nextLine();
			
			// ������ �ε����� �������� ��ü ����
			books[i] = new Book(title, author, price, publisher);
			
		}
		// ��ü ���� ��
		
		// ��ü ���� ������ ��ȸ�ϱ� => �ݺ��� Ȱ�� ����
		/*
		System.out.println(books[0].information());
		System.out.println(books[1].information());
		System.out.println(books[2].information());
		*/
		
		//���� 3���� �Ʒ��� ���� ���ٷ� ǥ�� ����!
		for(int i=0; i<books.length; i++) {
			System.out.println(books[i].information());
		}
		
		//���� �������� �˻��ϴ� ����
		System.out.print("�˻��� å ���� : ");
		String search = sc.nextLine();
		
		/*
		if(books[0].getTitle().equals(search)) {
			System.out.println(books[0].information());
		}
		
		if(books[1].getTitle().equals(search)) {
			System.out.println(books[1].information());
		}
		
		if(books[2].getTitle().equals(search)) {
			System.out.println(books[2].information());
		}
		*/
		
		//���� if�� 3���� �Ʒ��� ���� ǥ�� ����!
		
		for(int i=0;i<books.length;i++) {
			if(books[i].getTitle().equals(search)) {
				System.out.println(books[i].information());
			}
		}
		
		
		
	}

}
