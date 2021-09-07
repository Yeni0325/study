package com.kh.chap02_set.part01_hashSet.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import com.kh.chap02_set.part01_hashSet.model.vo.Student;

public class SetRun {

	public static void main(String[] args) {
		
		//Object�� equals() => �� ��ü�� "�ּҰ�"�� ���ؼ� ��ġ�ϸ� true/��ġ���� ������ false��ȯ
		//Object�� hashCode() => �ش� ��ü�� "�ּҰ�"�� ������ 10������ ���·� ���� ��ȯ
		
		//�ټ��� ��ü�� ������ �� �ִ� �÷����� �� ����
		HashSet<String> hs1 = new HashSet<>();
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
		
		//===============================================================================
		
		HashSet<Student> hs2 = new HashSet<>();
		
		hs2.add(new Student("����", 43, 100));
		hs2.add(new Student("�踻��", 26, 40));
		hs2.add(new Student("ȫ�浿", 24, 20));
		hs2.add(new Student("����", 43, 100));
		
		System.out.println(hs2); // ���� ���� ���� �ȵ� / �ߺ�����x => ��? ���ϰ�ü�� �Ǵ��� �ȵǰ� �־!
		
		// HashSet �̶�� ������ ��ü�� �߰��ɶ����� ���ϰ�ü���� ��!
		// ���ϰ�ü : �� ��ü���� hashCode()�޼ҵ� ȣ�� ����� ��ġ�ϰ�, equals()�޼ҵ�� �񱳽� true�� ���
		
		/*
		System.out.println(new Student("����", 43, 100).hashCode());
		System.out.println(new Student("����", 43, 100).hashCode());
		System.out.println(new Student("����", 43, 100).equals(new Student("����", 43, 100)));
		*/
		
		//hs2.get(1); => set�� �ε����� ���䵵 ���� get �޼ҵ� ��ü�� ���� �Ǿ� ���� ����!(�� ��ü�� �̾ƿ� �� ����) 
		
		//HashSet�� ��� ��� ��ü�鿡 ���������� ���� ����
		//�ϳ����� ���� �� ����
		//1. for�� ��� ����! (��, �ε��� ������ ���� ������ for-each�����θ� ����!)
		for(Student s : hs2) { //Student s Ÿ������ �޾��� ��� hs2�� object�� ��ȯ�Ǳ� ������ typemismatch�� �߻�
			System.out.println(s);
		}
		
		System.out.println("=========================================");
		
		//2. ArrayList�� �Ű� ���� �� �ش� ArrayList�� �ݺ��� �������� �����ϴ� ��� 
		//2-1. ArrayList�� ��� ù��° ��� : ArryList ���� �� addAll() �޼ҵ� �̿��ؼ� ��°�� �߰��ϱ�
		ArrayList<Student> list = new ArrayList<>();
		list.addAll(hs2); 
		//addAll�� �÷��� Ÿ�� �ۼ��� �����ϰ�, List�� Set�� Collection�� ���� �θ�� ��� �ֱ� ������ HashSet�� hs2�� ����� �� �ִ�.
		
		//2-2. ArryList�� ��� �� ��° ��� : ArrayList ������ ���ÿ� ��°�� �߰��ϱ�
		ArrayList<Student> list2 = new ArrayList<>(hs2); //ArryList�� HashSet��ü�� hs2�� �Ű����������ڷ� �ٷ� ���
		
		//ArryList�� ��� ���� �ε��� ���ð� �����ϱ� ������ for-loopȰ�� ����!
		for(int i=0; i<list2.size(); i++) {
			System.out.println(list2.get(i));
		}
		
		System.out.println("=========================================");
		
		//3. Iterator �ݺ��ڸ� �̿��ؼ� ���������� �����ϴ� ���
		// Collection���� Iterable�θ� ����
		// �������� ���� �� �ִ� �ݺ���
		Iterator<Student> it = hs2.iterator(); // iterator Ÿ������ ��ȯ�Ǳ� ������ IteratorŸ���� it��� ������ ����ش�
		//hs2�� ����ִ� ��ü���� Iterator(�ݺ���)�� �������� ��� ����
		//hs2�� ����ִ� ��ü���� ������°� �ƴ� Iterator������ ����Ǵ� ����!
		//�ٸ�, Iterator���� �ϳ��ϳ� �����ö��� �̾ƿ��� �����̱� ������ it�������� �������.
		
		while(it.hasNext()) {//iterator.hasNext() : it��� ������ ������ ���������� true, ������ false��ȯ�ϴ� �޼ҵ�
			Student s = /*(Student)*/it.next(); //iterator.next() : iterator������ ���� �ϳ��� �̾ƿ��� �޼ҵ�
			System.out.println(s);
		}
		//StringTokenizer�� ����� ����!
		
		//it.next(); 
		//�� �̻� ���� ���� ���µ� �������� �� �� 'NoSuchElementException' ���� �߻�
		
		
	}

}
