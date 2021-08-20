package com.kh.chap05_constructor.model.vo;

public class User {
	
	private String userId;
	private String userPwd;
	private String userName;
	private int age;
	private char gender;           // => �ʵ�  => new��� Ŭ������ ����� �� �޸𸮻� �ö�
	
	
	/*
	 * * ������
	 * 
	 *   public Ŭ������([�Ű�����, �Ű�����, ...]) {
	 *   
	 *   }
	 * 
	 * * �����ڸ� �ۼ��ϴ� ����
	 *   1. �ش� Ŭ������ ������ ��ü�� �����ϱ� ���� ����
	 * 
	 * * ������ �ۼ� �� ���ǻ���
	 *   1. �ݵ�� �����ڸ��� Ŭ������� �����ؾߵ�!!
	 *   2. �����ڴ� ��ȯ���� �������� ���� (���� ��ȯ���� �ۼ��� ���, �����ڰ� �ƴϰԵȴ� => �޼ҵ�� �ν�)
	 *   3. �Ű����� �����ڸ� ��������� �ۼ��ϰ� �Ǹ� �⺻ �����ڸ� JVM�� �ڵ����� ��������� ����
	 *      ��, �⺻�����ڴ� �׻� �ۼ��ϴ� ������ ������!!
	 */
	
	public User() {
		// �⺻ ������ (�Ű����� ���� ������)
		// ���� ��ü �������� �������� �� �� ���
		//System.out.println("�̰� ����ǳ�?");
		//�⺻ �����ڸ� �������� ��� => jvm�� �ڵ����� ���������� �����ڸ� �������
	}
	
	// �Ű�����������
	// ��ü ������ ���ÿ� ���ް����� �Ű������� �޾Ƽ� �ش� �� ������ �ʱ�ȭ�� ����
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
		 * ���� ���� �ߵ��Ǵ� ������ �ʱ�ȭ�ϴ� ������ �����ڰ� �̹� ������ ��� 
		 * this() ������ Ȱ�� ����
		 * => ���� Ŭ���� ���� �����ڿ��� �� �ٸ� �����ڸ� ȣ���ϰ��� �� �� ����
		 * * * ���ǻ��� : �ݵ�� ��ġ�� �ش� �ʵ带 ù �ٿ� �ۼ��ؾߵ�!!
		 */                                  
		 // this���� �ش� ��ü�� �ּҰ� ����� �ִ�.
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
	
	
	
	
	
	
	