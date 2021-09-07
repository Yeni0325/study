package com.kh.chap03_map.part01_hashMap.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.chap03_map.part01_hashMap.model.vo.Snack;

public class MapRun {

	public static void main(String[] args) {
		
		//���� ���� �Ұ�, Ű �� �ߺ� �Ұ�(value�� �ߺ� ����)
		HashMap<String, Snack> hm = new HashMap<>(); // key == String  / value == Snack
		//<key, value> Ÿ�� �ۼ�
		
		//���������� ����
		//List�迭, Set �迭�� Ŭ�������� Collection�� ������ Ŭ������.
		// => ��ü�� �߰��ϰ��� �� �� ���������� add�޼ҵ� �̿�!
		
		//Map�迭�� Collection�� ������ Ŭ������ �ƴ�!
		// => �߰��ϰ��� �� �� put �޼ҵ� �̿� (�̶� key + value ��Ʈ�� ��ƾ���!)
		
		//1. put(K key , V value) : �÷��ǿ� key value ��Ʈ�� �߰������ִ� �޼ҵ�
		hm.put("������", new Snack("���ڸ�", 1500));
		hm.put("ĭ��", new Snack("�ܸ�", 600));
		hm.put("�����", new Snack("§��", 500));
		
		hm.put("��������Ĩ", new Snack("§��", 500));
		
		System.out.println(hm); // {Ű=���, Ű=���, ...}
		// ����Ǵ� ���� ���� �ȵ�! value���� �ߺ��ǵ� key���� �ߺ��ȵǸ� �� ����ȴ�!
		
		hm.put("�����", new Snack("�ſ��", 700));
		System.out.println(hm);
		//������ Ű������ �ٽ� �߰��ϴ� ��� value���� ���������! (value�� �ߺ�����)
		
		//2. get(Object key) : V => �÷��ǿ��� �ش� Key���� ������ value���� ��ȯ�����ִ� �޼ҵ�
		Snack s = /*(Snack)*/hm.get("������"); // => Object Ÿ���� Snack Ÿ�Կ� �������� �ϸ� typemismatch ���� �߻�
		System.out.println(s);
		
		//3. size() : �÷��ǿ� ����ִ� ��ü���� ���� ��ȯ
		System.out.println("�� �� : " + hm.size());
		
		//4. replace(K key, V value) => �÷��ǿ��� �ش� key ���� ã�Ƽ� �ٽ� ������ value������ ���������ִ� �޼ҵ�
		hm.replace("��������Ĩ", new Snack("�̳� §��", 1000));
		System.out.println(hm);
		
		//5. remove(Object key) => �÷��ǿ��� �ش� key���� ã�Ƽ� key-value ��Ʈ�� ���������ִ� �ޙ�,
		hm.remove("��������Ĩ");
		System.out.println(hm);
		
		System.out.println("=================================================");
		//map ������ ��� ��� key���� value���� �� ����ϰ��� �� ��
		//for each�� �ȵ�!
		/*
		for( :hm) {
		
		}
		*/
		
		//ArrayList�ε� �ȵ�!
		//ArrayList list = new ArrayList(hm);
		
		//Iterator �ݺ��ڸ� �̿�!
		//Iterator it = hm.iterator(); //��ٷ� iterator() ȣ�� ����! ��? iterator()�� List�迭 �Ǵ� Set�迭������ �� �� �ִ� �޼ҵ�!
		
		//Map�� Set���� �ٲ��ִ� �޼ҵ� ����!(2��)
		//Map => Set�迭 => Iterator
		
		//���1. keySet()�޼ҵ� �̿��ϴ� ���
		// 1) keySet()�޼ҵ带 ȣ�� �ϴ� ���� hm(hashMap)�� ��� key���鸸 set�迭 �÷���(Ű���� ���� ����)�� ����
		Set<String> KeySet = hm.keySet();
		
		// 2) set�迭�� iterator() �޼ҵ� Ȱ���� �����ϱ� ������ iterator()�� ���� �Űܴ��
		//    �ٸ� set�迭 �÷����� keyset�� ���� Ű���� ������Ƿ� iterator() �޼ҵ� �ȿ��� key���� ����ִ�.
		//    keySet.iterator() : Iterator
		Iterator<String> itKey = KeySet.iterator();
		
		// 3) �ݺ����� ���ؼ� �̱�
		while(itKey.hasNext()) {
			 String key = /*(String)*/itKey.next();
			 //get()�޼ҵ带 Ȱ���� �ش� key���� �ش��ϴ� value���� ������ �� ����
			 Snack value = /*(Snack)*/hm.get(key);
			 System.out.println(key + "=" + value);
		}
		
		System.out.println("=================================================");
		
		//���2. entrySet()�޼ҵ� �̿��ϴ� ���
		// 1) entrySet()�޼ҵ� ȣ�� ����, Set�迭�� ������ ���� => hm(hashMap)�� ��� key+value��Ʈ�� Entry(k+v)
		//    ��, Entry�� �������� Set�迭�� �Ѿ�´�.
		Set<Entry<String, Snack>> entrySet = hm.entrySet(); //key+value ��Ʈ�� ����
		
		// 2) iterator()�޼ҵ� ȣ���� ���� set������ ��� entryŸ���� key+value���� �Ѿ�´�
		//    entrySet.iterator() : Iterator
		Iterator<Entry<String, Snack>> itEntry = entrySet.iterator();
		
		// 3) �ݺ����� ���ؼ� �̱�
		while(itEntry.hasNext()) {
			Entry<String, Snack> entry = /*(Entry)*/itEntry.next(); 
			// itEntry.next()�� key+value ��Ʈ�� EntryŸ���� ������ ���´�.
			
			String key = /*(String)*/entry.getKey(); //Entry.getKey() : Entry���� �����ϴ� �޼ҵ��, key���� �̾ƿ��� �޼ҵ�
			Snack value = /*(Snack)*/entry.getValue(); //Entry.getValue() : value���� �̾ƿ��� �޼ҵ�
			System.out.println(key + "=" + value);
		}
		
		
		
	}

}
