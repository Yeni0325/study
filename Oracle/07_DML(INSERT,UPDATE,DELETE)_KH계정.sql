/*
    DQL (QUERY ������ ���� ���) : SELECT
    
    DML (MANIPULATION ������ ���� ���) : [SELECT], INSERT, UPDATE, DELETE
    DDL (DEFINITION ������ ���� ���) : CREATE, ALTER, DROP
    DCL (CONTROL ������ ���� ���) : GRANT, REVOKE, [COMMIT, ROLLBACK] 
    
    TCL (TRANSACTION Ʈ����� ���� ���) : COMMIT, ROLLBACK
    
    < DML : DATE MANIPULATION LANGUAGE >
    ������ ���� ���
    
    ���̺� ���� ����(INSERT)�ϰų�, ����(UPDATE)�ϰų�, ����(DELETE)�ϴ� ����
    
*/

/*
    1. INSERT
       ���̺� ���ο� ���� �߰��ϴ� ����
       
       [ǥ����]
       1) INSERT INTO ���̺�� VALUES(��, ��, ��, ��, ��, ...); -> �ش� ���̺� �����ϴ� ��� �÷��� ���� ���� 
          ���̺� ��� �÷��� ���� ���� ���� �����ؼ� �� ���� INSERT�ϰ��� �� �� ���
          �÷� ������ ���Ѽ� VALUES�� ���� �����ؾ��Ѵ�.
          
          �����ϰ� ���� �������� ��� => not enough value ���� �߻�
          ���� �� ���� �������� ��� => too many values ���� �߻�
*/

INSERT INTO EMPLOYEE
VALUES(900, '��ä��', '980914-2451321', 'jang_ch@kh.or.kr', '01011112222', 'D1', 'J7', 4000000, 0.2, 200, SYSDATE, NULL, DEFAULT);

SELECT * FROM EMPLOYEE;

/*
    2) INSERT INTO ���̺��(�÷���, �÷���, �÷���) VALUES(��, ��, ������);
       ���̺� ���� ������ �÷��� ���� ���� INSERT�� �� ���
       �׷��� �� �� ������ �߰��Ǳ� ������ ���þȵ� �÷��� �⺻������ NULL�� ����.
       => NOT NULL ���������� �ɷ��ִ� �÷��� �ݵ�� �����ؼ� ���� �� �����ؾߵ� 
       ��, �⺻��(DEFAULT)�� �����Ǿ� ������ NULL�� �ƴ� �⺻���� ��
*/

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, HIRE_DATE) VALUES(901, '������', '940325-2142513', 'J7', SYSDATE);

SELECT * FROM EMPLOYEE;

INSERT
  INTO EMPLOYEE
       (
         EMP_ID
       , EMP_NAME
       , EMP_NO
       , JOB_CODE
       , HIRE_DATE
       ) 
VALUES
       (
        901
        , '������'
        , '940325-2142513'
        , 'J7'
        , SYSDATE
        );

------------------------------------------------------------------------------------------

/*
    3) INSERT INTO ���̺�� (��������); 
       VALUES �� ���� ���� ����ϴ°� ��ſ�
       ���������� ��ȸ�� ������� ��°�� INSERT���� ! (��, ������ INSERT ����)
*/

-- ���ο� ���̺� ����
CREATE TABLE EMP_01 (
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(20),
    DEPT_TITLE VARCHAR2(20)
);

SELECT * FROM EMP_01;

-- ��ü ������� ���, �̸�, �μ��� ��ȸ
INSERT INTO EMP_01
    (SELECT EMP_ID, EMP_NAME, DEPT_TITLE
     FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID));
     
----------------------------------------------------------------------------------------

/*
    2. INSERT ALL
       �ΰ� �̻��� ���̺� ���� INSERT�� �� 
       �� �� ���Ǵ� ���������� ������ ��� ���
*/
--> �켱 �׽�Ʈ�� ���̺� ����
CREATE TABLE EMP_DEPT
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
    FROM EMPLOYEE
    WHERE 1=0;
    
CREATE TABLE EMP_MANAGER
AS SELECT EMP_ID, EMP_NAME, MANAGER_ID
    FROM EMPLOYEE
    WHERE 1=0;
    
SELECT * FROM EMP_DEPT;
SELECT * FROM EMP_MANAGER;

-- �μ��ڵ尡 D1�� ������� ���, �̸�, �μ��ڵ�, �Ի���, ������ ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1';

/*
    [ǥ����]
    INSERT ALL
    INTO ���̺��1 VALUES(�÷���, �÷���, ...)
    INTO ���̺��2 VALUES(�÷���, �÷���, ...)
        ��������;
*/
INSERT ALL
INTO EMP_DEPT VALUES(EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE)
INTO EMP_MANAGER VALUES(EMP_ID, EMP_NAME, MANAGER_ID)
    SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
    FROM EMPLOYEE
    WHERE DEPT_CODE = 'D1';
    
SELECT * FROM EMP_DEPT;
SELECT * FROM EMP_MANAGER;