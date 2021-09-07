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
	
	//hashCode(), equals() 메소드 => alt + shift + s => h(hashCode&equals) => enter
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
		
		if (this == obj) // 현객체와 비교대상객체의 주소값이 일치할 경우(같은 곳을 참조 == 필드값이 일치) 
			return true; // => 각 필드들 일일히 비교할 필요 없이 그냥 ture 반환
		if (obj == null) // 비교대상이 null일 경우, 비교할 가치도 없이 false 반환
			return false;
		if (/*this.*/getClass() != obj.getClass()) // 현 객체의 클래스 타입과 비교대상객체의 클래스 타입이 다를 경우
			return false;                          // 비교할 가치도 없이 false반환 
		//각 객체의 주소값이 다르고, 비교대상객체가 null이 아니고(정상적인 객체), 두 객체의 클래스 타입이 일치할 경우
		// => 본격적으로 각 필드값으로 비교할꺼임!
		
		Student other = (Student) obj;             
		if (age != other.age) // 현 객체의 age 필드와 전달받은 객체의 age필드가 다를 경우 false반환
			return false;
		
		if (name == null) { // 현 객체의 name필드가 null일 경우
			if (other.name != null) // 전달받은 객체의 name필드가 null이 아닐 경우 false반환
				return false;
		} else if (!name.equals(other.name)) // 현 객체의 name필드가 null이 아니고
			return false;                    // 그 문자열과 전달받은 객체의 name필드문자열이 일치하지 않을경우
		
		if (score != other.score) // 현 객체의 score 필드와 전달받은객체의 score필드가 다를 경우 false 반환
			return false;
		
		return true;
	}
	
	/*
	@Override //어노테이션
	public int hashCode() { //모든 필드에 담긴 값이 일치하면 동일한 hashCode반환되도록
		String str = name + age + score; // "공유43100" , "김말똥2640", "홍길동2420", "공유43100"
		//해당 각 객체의 필드값들을 하나의 문자열로 합침
		return str.hashCode();
		//String클래스에서는 동일한 문자열을 가지고 동일한 hashCode()값을 돌려받음
	}
	
	//Student객체.equals(Student객체) 이런식으로 호출될꺼임
	@Override
	public boolean equals(Object obj) { //현재객체와 전달받은 객체의 각 필드값들이 모두 일치하면 true, 하나라도 일치하지 않으면 false반환
		
		// this(현객체)   vs  obj(전달받은 객체)
		// Student타입                      Object타입
		Student other = (Student)obj;
		
		// this(현객체)  vs  other(전달받은 객체)
		// this.name필드와 other.name필드가 일치하는지 비교
		// this.age필드와 other.age필드가 일치하는지 비교
		// this. score필드와 other.score필드가 일치하는지 비교
		if(this.name.equals(other.name) && this.age == other.age && this.score == other.score) {
			return true;
		} else {
			return false;
		}
		
	}
	*/
	
	
	//이클립스 상에서 hashCode()와 equals()메소드가 자동완성으로 오버라이딩 되어있음
	
	
}
