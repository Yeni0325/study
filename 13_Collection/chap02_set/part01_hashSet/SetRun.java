package com.kh.chap02_set.part01_hashSet.run;

import java.util.HashSet;

import com.kh.chap02_set.part01_hashSet.model.vo.Student;

public class SetRun {

	public static void main(String[] args) {
		
		//Object�� equals() => �� ��ü�� "�ּҰ�"�� ���ؼ� ��ġ�ϸ� true/��ġ���� ������ false��ȯ
		//Object�� hashCode() => �ش� ��ü�� "�ּҰ�"�� ������ 10������ ���·� ���� ��ȯ
		
		//�ټ��� ��ü�� ������ �� �ִ� �÷����� �� ����
		HashSet hs1 = new HashSet();
		//hs1�̶�� ���� ����
		
		//ArrayList�� HashSet�� ���ο� ���� �߰��Ϸ��� add()�޼ҵ带 ����ϴµ�
		//�������� Collection �θ� ������ �����鼭 add()�� �������̵� �Ǿ��� ����!
		hs1.add("�ݰ����ϴ�.");
		hs1.add(new String("�ݰ����ϴ�."));
		hs1.add(new String("������"));
		hs1.add(new String("�ȳ��ϼ���"));
		hs1.add(new String("������"));
		
		//String�� hashCode()�޼ҵ�� �������̵� �Ǿ�����! => "���� ��� ���ڿ�"�� ������ 10������ ���·� ���� ��ȯ
		//String�� equals()�޼ҵ�� �������̵� �Ǿ�����! => "���� ��� ���ڿ�"�� ������ ���ؼ� ��ġ�ϸ� true / ��ġ���� ������ false ��ȯ
		
		System.out.println(hs1); // ���� ���� ���� �ȵ�!(�ε��� ����X) �ߺ��� ������(���ϰ�ü) ���� �Ұ���
		
		HashSet hs2 = new HashSet();
		
		hs2.add(new Student("����", 43, 100));
		hs2.add(new Student("�踻��", 26, 40));
		hs2.add(new Student("ȫ�浿", 24, 20));
		hs2.add(new Student("����", 43, 100));
		
		System.out.println(hs2); // ���� ���� ���� �ȵ� / �ߺ�����x => ��? ���ϰ�ü�� �Ǵ��� �ȵǰ� �־!
		
		// HashSet �̶�� ������ ��ü�� �߰��ɶ����� ���ϰ�ü���� ��!
		// ���ϰ�ü : �� ��ü���� hashCode()�޼ҵ� ȣ�� ����� ��ġ�ϰ�, equals()�޼ҵ�� �񱳽� true�� ���
		
		// Student�� equals() �������̵� => "���� �� �ʵ忡 ��� ������"���� �� ��ġ�ϸ� true, ��ġ���� ������ false��ȯ
		// Student�� hashCode() �������̵� => "���� �� �ʵ忡 ��� ������"���� ��ġ�ϸ� ������ 10������ ���¸� ��ȯ
		
		System.out.println(new Student("����", 43, 100).hashCode());
		System.out.println(new Student("����", 43, 100).hashCode());
		System.out.println(new Student("����", 43, 100).equals(new Student("����", 43, 100)));
		
		
		
	}

}
