package com.kh.chap02_set.part01_hashSet.model.vo;

public class Student {
	
	private String name;
	private int age;
	private int score;
	
	public void Student() {
		
	}

	public Student(String name, int age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}
	
	@Override //������̼�
	public int hashCode() { //��� �ʵ忡 ��� ���� ��ġ�ϸ� ������ hashCode��ȯ�ǵ���
		String str = name + age + score; // "����43100" , "�踻��2640", "ȫ�浿2420", "����43100"
		//�ش� �� ��ü�� �ʵ尪���� �ϳ��� ���ڿ��� ��ħ
		return str.hashCode();
		//StringŬ���������� ������ ���ڿ��� ������ ������ hashCode()���� ��������
	}
	
	//Student��ü.equals(Student��ü) �̷������� ȣ��ɲ���
	@Override
	public boolean equals(Object obj) { //���簴ü�� ���޹��� ��ü�� �� �ʵ尪���� ��� ��ġ�ϸ� true, �ϳ��� ��ġ���� ������ false��ȯ
		
		// this(����ü)   vs  obj(���޹��� ��ü)
		// StudentŸ��                      ObjectŸ��
		Student other = (Student)obj;
		
		// this(����ü)  vs  other(���޹��� ��ü)
		// this.name�ʵ�� other.name�ʵ尡 ��ġ�ϴ��� ��
		// this.age�ʵ�� other.age�ʵ尡 ��ġ�ϴ��� ��
		// this. score�ʵ�� other.score�ʵ尡 ��ġ�ϴ��� ��
		if(this.name.equals(other.name) && this.age == other.age && this.score == other.score) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
