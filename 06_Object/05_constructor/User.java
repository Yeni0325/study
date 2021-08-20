package com.kh.chap05_constructor.model.vo;

public class User {
	
	private String userId;
	private String userPwd;
	private String userName;
	private int age;
	private char gender;           // => 필드  => new라는 클래스를 사용할 때 메모리상에 올라감
	
	
	/*
	 * * 생성자
	 * 
	 *   public 클래스명([매개변수, 매개변수, ...]) {
	 *   
	 *   }
	 * 
	 * * 생성자를 작성하는 목적
	 *   1. 해당 클래스를 가지고 객체를 생성하기 위한 목적
	 * 
	 * * 생성자 작성 시 주의사항
	 *   1. 반드시 생성자명은 클래스명과 동일해야됨!!
	 *   2. 생성자는 반환형이 존재하지 않음 (만일 반환형을 작성할 경우, 생성자가 아니게된다 => 메소드로 인식)
	 *   3. 매개변수 생성자를 명시적으로 작성하게 되면 기본 생성자를 JVM이 자동으로 만들어주지 않음
	 *      즉, 기본생성자는 항상 작성하는 습관을 들이자!!
	 */
	
	public User() {
		// 기본 생성자 (매개변수 없는 생성자)
		// 단지 객체 생성만을 목적으로 할 때 사용
		//System.out.println("이게 실행되나?");
		//기본 생성자를 생략했을 경우 => jvm이 자동으로 내부적으로 생성자를 만들어줌
	}
	
	// 매개변수생성자
	// 객체 생성과 동시에 전달값들을 매개변수로 받아서 해당 각 필으데 초기화할 목적
	public User(String userId, String userPwd, String userName) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
	}
	
	public User(String userId, String userPwd, String userName, int age, char gender) {
		/*
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		*/
		this(userId, userPwd, userName);  
		/*
		 * 위와 같이 중독되는 동일한 초기화하는 내용의 생성자가 이미 존재할 경우 
		 * this() 생성자 활용 가능
		 * => 같은 클래스 내에 생성자에서 또 다른 생성자를 호출하고자 할 때 사용됨
		 * * * 유의사항 : 반드시 겹치는 해당 필드를 첫 줄에 작성해야됨!!
		 */                                  
		 // this에는 해당 객체의 주소가 담겨져 있다.
		this.age = age;
		this.gender = gender;
	}
	
	
	//setter
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	//getter
	public String getUserId() {
		return userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public String getUserName() {
		return userName;
	}
	
	public int getAge() {
		return age;
	}
	
	public char getGender() {
		return gender;
	}
	
	
	public String information() {
		return "userId : " + userId + ", userPwd : " + userPwd + 
				", userName : " + userName + ", age : " + age + ", gender : " + gender;
	}
	
}
	
	
	
	
	
	
	