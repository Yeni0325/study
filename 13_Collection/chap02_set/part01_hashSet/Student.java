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
	
	//hashCode(), equals() �޼ҵ� => alt + shift + s => h(hashCode&equals) => enter
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		// this vs obj
		
		if (this == obj) // ����ü�� �񱳴��ü�� �ּҰ��� ��ġ�� ���(���� ���� ���� == �ʵ尪�� ��ġ) 
			return true; // => �� �ʵ�� ������ ���� �ʿ� ���� �׳� ture ��ȯ
		if (obj == null) // �񱳴���� null�� ���, ���� ��ġ�� ���� false ��ȯ
			return false;
		if (/*this.*/getClass() != obj.getClass()) // �� ��ü�� Ŭ���� Ÿ�԰� �񱳴��ü�� Ŭ���� Ÿ���� �ٸ� ���
			return false;                          // ���� ��ġ�� ���� false��ȯ 
		//�� ��ü�� �ּҰ��� �ٸ���, �񱳴��ü�� null�� �ƴϰ�(�������� ��ü), �� ��ü�� Ŭ���� Ÿ���� ��ġ�� ���
		// => ���������� �� �ʵ尪���� ���Ҳ���!
		
		Student other = (Student) obj;             
		if (age != other.age) // �� ��ü�� age �ʵ�� ���޹��� ��ü�� age�ʵ尡 �ٸ� ��� false��ȯ
			return false;
		
		if (name == null) { // �� ��ü�� name�ʵ尡 null�� ���
			if (other.name != null) // ���޹��� ��ü�� name�ʵ尡 null�� �ƴ� ��� false��ȯ
				return false;
		} else if (!name.equals(other.name)) // �� ��ü�� name�ʵ尡 null�� �ƴϰ�
			return false;                    // �� ���ڿ��� ���޹��� ��ü�� name�ʵ幮�ڿ��� ��ġ���� �������
		
		if (score != other.score) // �� ��ü�� score �ʵ�� ���޹�����ü�� score�ʵ尡 �ٸ� ��� false ��ȯ
			return false;
		
		return true;
	}
	
	/*
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
	*/
	
	
	//��Ŭ���� �󿡼� hashCode()�� equals()�޼ҵ尡 �ڵ��ϼ����� �������̵� �Ǿ�����
	
	
}
