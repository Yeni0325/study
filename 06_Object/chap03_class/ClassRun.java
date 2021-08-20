package com.kh.chap03_class.run;
import com.kh.chap03_class.model.vo.Person;
import com.kh.chap03_class.model.vo.Product;

public class ClassRun {
	
	public static void main(String[] args) {
		
		Person a = new Person();
		System.out.println("===== �Ű����� ������ ���� ======");
		Person kim = new Person("ye325", "0325", "�迹��");
		
		Person park = new Person("����@gmail.com", "010-7777-7777");
		
		System.out.println(kim.information());
		System.out.println(park.information());
		
		System.out.println("=============================");
		
		a.setId("yeeun0325");
		a.setPwd("1234");
		a.setName("�迹��");
		a.setAge(28);
		a.setGender('F');
		a.setPhone("010-9977-9422");
		a.setEmail("yeeun032%@naver.com");
		
		System.out.println(a.getId());
		System.out.println(a.getPwd());
		System.out.println(a.getName());
		System.out.println(a.getAge());
		System.out.println(a.getGender());
		System.out.println(a.getPhone());
		System.out.println(a.getEmail());
		
		//////////////////////////////////////
		
		
		// * ù��° ��� : �Ű����� �����ڷ� ������ ���ÿ� �� �ʱ�ȭ
		Product p1 = new Product("������", 1200000, "�Ｚ");
		System.out.println(p1.information());
		
		Product abc = new Product("������", 100, "�ƹ��ų��귣��", "ȫ�浿");
		System.out.println(abc.information());
		
		//�ǽ�����
		System.out.println("=== �ǽ����� ===");
		
		// * �ι�° ��� : �⺻������ ���� �� setter �̿��ؼ� �� �ʱ�ȭ
		p1.setpName("������");
		p1.setPrice(1200000);
		p1.setBrand("�Ｚ");
		
		Product p2 = new Product("������", 130000, "����");
		
		p2.setpName("������");
		p2.setPrice(1300000);
		p2.setBrand("����");
		
		// pName : xxx, Price : xxx, brand : xxx �������� ���
		
		//System.out.println("pName : " + p1.getpName() + ", Price : " + p1.getPrice() + ", brand : " + p1.getBrand());
		//System.out.println("pName : " + p2.getpName() + ", Price : " + p2.getPrice() + ", brand : " + p2.getBrand());
		
		System.out.println(p1.information());
		System.out.println(p2.information());
		
		System.out.println("===");
		System.out.println(a.information());
	}
}
