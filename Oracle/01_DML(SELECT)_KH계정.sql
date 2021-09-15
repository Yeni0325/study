/*
    < SELECT >
    �����͸� ��ȸ�� �� ���Ǵ� ����
    
    >> RESULT SET : SELECT���� ���� ��ȸ�� ����� (��, ��ȸ�� ����� ������ �ǹ�)
    
    [ǥ����]
    SELECT ��ȸ�ϰ����ϴ��÷�, �÷�, �÷�, ... 
    FROM ���̺��;
    
    ���� �����͵��� ��� ������ '���̺�'�ε�, � �������κ��� ��ȸ�Ұ��� ���̺���� �ۼ�������Ѵ�.
    �÷��� �ݵ�� �ش� ���̺� �����ϴ� �÷��̾���Ѵ�.
*/

-- EMPLOYEE ���̺� ��� �÷� ��ȸ (��� ������ ��ȸ)
SELECT *
FROM EMPLOYEE;    --���̺�κ��� �����ϴ� ��� Į���� ��ȸ�ϰ��� �Ҷ�

-- EMPLOYEE ���̺� ���, �̸�, �޿����� ��ȸ (Ư�� �÷� ��ȸ)
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE;

-- JOB ���̺� ��� �÷� ��ȸ
SELECT *
FROM JOB;

----------------------- �ǽ����� --------------------------
-- 1. JOB ���̺��� ���޸� �÷��� ��ȸ
SELECT JOB_NAME
FROM JOB;
-- 2. DEPARTMENT ���̺��� ��� �÷� ��ȸ
SELECT *
FROM DEPARTMENT;
-- 3. DEPARTMENT ���̺��� �μ��ڵ�, �μ��� ��ȸ
SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT;
-- 4. EMPLOYEE  ���̺��� �����, �̸���, ��ȭ��ȣ, �Ի���, �޿� ��ȸ
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE, SALARY
FROM EMPLOYEE;
-----------------------------------------------------------

/*
    < �÷����� ���� ������� >
    SELECT �� �÷��� �ۼ��κп� ������� ��� ���� (�̶� �������� ��� ��ȸ)
*/
-- EMPLOYEE�� �����, ����� ����(�޿�*12) ��ȸ
SELECT EMP_NAME, SALARY*12
FROM EMPLOYEE;

-- EMPLOYEE�� �����, �޿�, ���ʽ�, ����, ���ʽ������Եȿ���((�޿�+���ʽ�*�޿�)*12) ��ȸ
SELECT EMP_NAME, SALARY, BONUS, SALARY*12, (SALARY+BONUS*SALARY)*12
FROM EMPLOYEE;
--> ������� ���� �� NULL���� ������ ��� ��������� ����� ������ ������ MULL������ ����!

-- EMPLOYEE�� �����, �Ի���, �ٹ��ϼ�(���ó�¥ - �Ի���)
-- DATE���ĳ����� ������ ����!
-- * ���ó�¥ : SYSDATE
SELECT EMP_NAME, HIRE_DATE, SYSDATE-HIRE_DATE 
FROM EMPLOYEE;
-- DATE - DATE : ������� �� ������ ����!
-- ��, ���� �������� ������ DATE������ ��/��/��/��/��/�� ������ �ð����������� ������ �ϱ� ����

-- ���� �ý��� ��¥ �� �ð��� ���� ��ȸ
SELECT SYSDATE
FROM DUAL; -- ����Ŭ���� �����ϴ� �������̺�(�������̺�)! SYSDATE�� ���� �ý��� �ð��� �˷��ִ� ��ɾ�� ������ ������ ���Ե� ���̺��� �������� �ʴ´�. �׷��� ���� ���̺��� �������ش�!

-------------------------------------------------------------------------------------

/*
    < �÷��� ��Ī �����ϱ� >
    ��������� �ϰ� �Ǹ� �÷��� ��������... �̶� �÷������� ��Ī �ο��ؼ� ����ϰ� ������ �� ����
    
    [ǥ����]
    �÷��� ��Ī / �÷��� AS ��Ī / �÷��� "��Ī" / �÷Ÿ� AS "��Ī"
    
    AS ���̵� �Ⱥ��̵簣�� �ο��ϰ��� �ϴ� ��Ī�� ���� Ȥ�� Ư�����ڰ� ���Ե� ��� �ݵ�� ���������̼�("")�� ����ؾߵ�!
*/
SELECT EMP_NAME �����, SALARY AS �޿�, SALARY*12 "����(��)", (SALARY + BONUS*SALARY)*12 AS "�� �ҵ�"
FROM EMPLOYEE;

--------------------------------------------------------------------------------------

/*
    < ���ͷ� >
    ���Ƿ� ������ ���ڿ�('')
    
    SELECT ���� ���ͷ��� �����ϸ� ��ġ ���̺�� �����ϴ� ������ó�� ��ȸ ����
    ��ȸ�� RESULT SET�� ��� �࿡ �ݺ������� ���� ���
*/
-- EMPLOYEE�� ���, �����, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, '��' AS ����
FROM EMPLOYEE;

select emp_id, emp_name, salary
from employee;
-- oracle�� Ű����, ���̺��, �÷��� ���� ��ҹ��ڸ� ������ ����!(���������� ����)
-- ��, ���� �����Ͱ��� ���ϴ� ��Ȳ������ ��ҹ��ڸ� ������.

/*
    < ���� ������ : || >
    ���� �÷������� ��ġ �ϳ��� �÷��ΰ�ó�� �����ϰų�, �÷����� ���ͷ��� ������ �� ����
    
    System.out.println("num : " + num); => �ڹٿ��� �ϳ��� ���ڿ�ó�� �����ؼ� ����߾��µ� ���⼭�� "+" ����
*/

-- EMPLOYEE�� ���, �̸�, �޿��� �ϳ��� Į������ ��ȸ
SELECT EMP_ID || EMP_NAME || SALARY
FROM EMPLOYEE;

-- �÷����̶� ���ͷ� ����
-- "XXX�� ������ XXX�� �Դϴ�."
SELECT EMP_NAME || '�� ������ ' || SALARY || '�� �Դϴ�.' "�޿� ����" 
FROM EMPLOYEE;
-- ����Ŭ���� ���ڿ� ���ڿ��� ����X, ����(��) ���ý� ''�� ����Ѵ�.


---------------------------------------------------------------------------------------------

/*
    < DISTINCT >
    �÷��� �ߺ��� ������ �ѹ����� ǥ���ϰ��� �� �� ����ϴ� Ű����
*/
-- EMPLOYEE�� �����ڵ� ��ȸ
SELECT JOB_CODE
FROM EMPLOYEE;

-- EMPLOYEE�� �����ڵ� (�ߺ�����) ��ȸ
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE; -- 7�� ��ȸ

-- EMPLOYEE�� �μ��ڵ� (�ߺ�����) ��ȸ
SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

-- DISTINCT ���ǻ��� : DISTINCT�� SELECT���� �� �ѹ��� ��� �����ϴ�.
/* �������� �߻�
SELECT DISTINCT JOB_CODE, DISTINCT DEPT_CODE
FROM EMPLOYEE;
*/

SELECT DISTINCT JOB_CODE, DEPT_CODE
FROM EMPLOYEE;
-- JOB_CODE���� DEPT_CODE���� ������ ��� �ߺ� �Ǻ�

-- ============================================================================================

/*
    < WHERE �� >
    ��ȸ�ϰ��� �ϴ� ���̺�κ��� Ư�� ���ǿ� �����ϴ� �����͸��� ��ȸ�ϰ��� �� �� ���
    �� �� WHERE���� ���ǽ��� �����ϰԵ�
    ���ǽĿ����� �پ��� �����ڵ� ��밡��!
    
    [ǥ����]
    SELECT  ��ȸ�ϰ����ϴ��÷�, �÷�, �������, ...
    FROM ���̺��
    WHERE ���ǽ�;
    
    >> �񱳿����� <<
    >, <, >=, <=    --> ��Һ�
    =               --> ������ ��(�ڹٿ����� ����񱳽� '=='�̾�����, ����Ŭ������ '=')
    !=, ^=, <>      --> ���� ������ ��(�ڹٿ����� ���� ������ �񱳽�, '!='�̾�����, ����Ŭ������ '!=', '^=', '<>"
*/

-- EMPLOYEE���� �μ��ڵ尡 'D9'�� ����鸸 ��ȸ (�� ��, ��� �÷� ��ȸ)
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9'; --�񱳴�� �÷� ���� --�������� ���ڿ��� �����ϹǷ� Ȭ����ǥ ''�� ���� �����ؾ��Ѵ�. ''�� �������� ������� �÷����� �ν��ϰ� �ȴ�.

-- EMPLOYEE���� �μ��ڵ尡 'D1'�� ������� �����, �޿�, �μ��ڵ� ��ȸ
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1';

-- EMPLOYEE���� �μ��ڵ尡 'D1'�� �ƴ� ������� ���, �����, �μ��ڵ� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
--WHERE DEPT_CODE != 'D1';
--WHERE DEPT_CODE ^= 'D1';
WHERE DEPT_CODE <> 'D1';

-- EMPLOYEE���� �޿��� 400���� �̻��� ������� �����, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 4000000;

-- EMPLOYEE���� ��������(ENT_YN �÷����� 'N'��) ������� ���, �̸�, �Ի��� ��ȸ
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE ENT_YN = 'N';

--------------------- �ǽ����� ----------------------------
-- 1. EMPLOYEE���� �޿��� 300���� �̻��� ������� �����, �޿�, �Ի���, ���� ��ȸ
SELECT EMP_NAME "�����", SALARY "�޿�", HIRE_DATE "�Ի���", SALARY*12 "����"
FROM EMPLOYEE
WHERE SALARY >= 3000000;
-- 2. EMPLOYEE���� ������ 5000���� �̻��� ������� �����, �޿�, ����, �μ��ڵ� ��ȸ
SELECT EMP_NAME "�����", SALARY "�޿�", SALARY*12 "����", DEPT_CODE "�μ��ڵ�"
FROM EMPLOYEE
WHERE SALARY*12 >= 50000000;
-- WHERE ���� >= 50000000; -- ����(WHERE�������� SELECT���� �ۼ��� ��Ī ���Ұ�!)

-- ������� : FROM�� => WHERE�� => SELECT��
-- ���������� FROM���� ���� ������ �Ǵµ� FROM���� ��� �����͸� ������ �� �� �ึ�� WHERE���� ���ǰ˻縦 �����Ѵ�. 
-- WHERE���� �� ������ ���ǿ� �����Ǵ� ������ �߷����µ� �������� ����Ǵ°� SELECT���̴�. 
-- ���� SELECT���� ����Ǵ� ���� �� �� ��Ī�� �ο��Ǳ� ������ WHERE���� ����Ǵ� ��ÿ��� ��Ī�� ������� ���Ѵ�.


-- 3. EMPLOYEE���� �����ڵ尡 'J3'�� �ƴ� ������� ���, �����, �����ڵ�, ��翩�� ��ȸ
SELECT EMP_ID "���", EMP_NAME "�����", JOB_CODE "�����ڵ�", ENT_YN "��翩��"
FROM EMPLOYEE
WHERE JOB_CODE != 'J3';

------------------------------------------------------------------------------------------------------------

/*
    < �� ������ >
    �������� ������ ��� �����ϰ��� �� �� ���
    
    AND (~�̸鼭, �׸���)
    OR  (~�̰ų�, �Ǵ�)
*/

-- EMPLOYEE���� �μ��ڵ尡 'D9'�̸鼭 �޿��� 500���� �̻��� ������� �����, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9' AND SALARY >= 5000000;

-- EMPLOYEE���� �μ��ڵ尡 'D6'�̰ų� �޿��� 300���� �̻��� ������� �����, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' OR SALARY >= 3000000;

-- EMPLOYEE���� �޿��� 350���� �̻� 600���� ���ϸ� �޴� ������� �����, ���, �޿� ��ȸ
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
-- WHERE SALARY 3500000 <= SALARY < 6000000; --> ���ļ� ������ �Ұ� (���� �߻�)
WHERE SALARY >= 3500000 AND SALARY <= 6000000;

----------------------------------------------------------------------------------------------

/*
    < BETWEEN AND >
    ���ǽĿ��� ���Ǵ� ����
    �� �̻� �� ������ ������ ���� ������ ������ �� ���Ǵ� ������ (�� �ʰ� �� �̸��� �Ұ�X)
    
    [ǥ����]
    �񱳴���÷� BETWEEN ���Ѱ� AND ���Ѱ�
    => �ش� �÷����� ���Ѱ� �̻��̰� ���Ѱ� ������ ���
*/

-- EMPLOYEE���� �޿��� 350���� �̻� 600���� ���ϸ� �޴� ������� �����, ���, �޿� ��ȸ
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000; -- 6��

-- EMPLOYEE���� �޿��� 350���� �̸� 600���� �ʰ��� �޴� ������� �����, ���, �޿� ��ȸ
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
--WHERE SALARY < 3500000 OR SALARY > 6000000;
--WHERE NOT SALARY BETWEEN 3500000 AND 6000000; 
WHERE SALARY NOT BETWEEN 3500000 AND 6000000;
-- NOT : ������ �ݴ�� �ٲٴ� ������, �÷��� �տ� Ȥ�� BETWEEN�տ� ��ġ�� �� �ִ�.
-- �ڹٿ��� �����������ڴ� ! , ����Ŭ������ �����������ڴ� NOT

-- �Ի����� '90/01/01' ~ '01/01/01' ����� ��ȸ
SELECT *
FROM EMPLOYEE
--WHERE HIRE_DATE >= '90/01/01' AND HIRE_DATE <= '01/01/01'; -- DATE ���� �� ��Һ� ����!
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';

----------------------------------------------------------------------------------

/*
    < LIKE >
    ���ϰ����ϴ� �÷����� ���� ������ Ư�� ���Ͽ� "����"�� ��� ��ȸ
    
    [ǥ����]
    �񱳴���÷� LIKE 'Ư������'
    
    - Ư������ ���� �� '%', '_'�� ���ϵ� ī��� ����� �� ����
    >> '%' : 0���� �̻�
    EX) �񱳴���÷� LIKE '����%'  =>  �񱳴���� �÷����� ���ڷ� "����"�Ǵ°� ��ȸ
        �񱳴���÷� LIKE '%����'  =>  �񱳴���� �÷����� ���ڷ� "��"���� �� ��ȸ
        �񱳴���÷� LIKE '%����%' =>  �񱳴���� �÷����� ���ڰ� "����"�Ǿ��ִ� �� ��ȸ
    
    >> '_' : ������ 1����
    EX) �񱳴��Į�� LIKE '_����'  => �񱳴���� �÷����� ���� �տ� ������ 1���ڰ� �� ��� ��ȸ
        �񱳴��Į�� LIKE '__����' => �񱳴���� �÷����� ���� �տ� ������ 2���ڰ� �� ��� ��ȸ
        �񱳴��Į�� LIKE '_����_' => �񱳴���� �÷����� ���� �հ� �ڿ� ������ 1���ھ� �� ��� ��ȸ
*/

-- ����� �� ���� ������ ������� �����, �޿�, �Ի��� ��ȸ
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '��%';
-- WHERE EMP_NAME = '��%' -> ����� �̸��� '��%'�� ��� ��ȸ

-- ����� �̸� �� �� �� ���Ե� ������� �����, �ֹι�ȣ, ��ȭ��ȣ ��ȸ
SELECT EMP_NAME, EMP_NO, PHONE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��%';

-- ����� �̸� �� ��� ���ڰ� '��'�� ������� �����, ��ȭ��ȣ ��ȸ
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '_��_';

-- ����� ��ȭ��ȣ �� ����° �ڸ��� '1'�� ������� ���, �����, ��ȭ��ȣ, �̸��� ��ȸ
-- ���ϵ�ī�� : _(1����), %(0�����̻�)
SELECT EMP_ID, EMP_NAME, PHONE, EMAIL
FROM EMPLOYEE
WHERE PHONE LIKE '__1%';

-- ����� �̸��� �� �ձ��ڰ� 3������ ������� ���, �̸�, �̸��� ��ȸ
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '____%'; -- ���ߴ� ��� ���� ����
-- ���ϵ� ī��� ���ǰ� �ִ� ���ڿ� �÷����� ��� ���ڰ� �����ϱ� ������ ����� ��ȸ �ȵ�
--> ��� ���ϵ� ī��� ��� �����Ͱ����� ���� ����ߵ�
--> �����Ͱ����� ����ϰ����ϴ� �� �տ� ������ ���ϵ�ī�带 �����ϰ� ������ ���ϵ�ī���� ���(ESCAPE OPTION)������Ѵ�.
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___$_%' ESCAPE '$';

-- ���� ������� �ƴ� �� ���� ����� ��ȸ
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE NOT EMAIL LIKE '___$_%' ESCAPE '$';
-- NOT�� �÷��� �� �Ǵ� LIKE �տ� ���԰���


---------------------------------�ǽ�����----------------------------------
-- 1. EMPLOYEE���� �̸��� '��'���� ������ ������� �����, �Ի��� ��ȸ
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��';
-- 2. EMPLOYEE���� ��ȭ��ȣ ó�� 3�ڸ��� 010�� �ƴ� ������� �����, ��ȭ��ȣ ��ȸ
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE NOT PHONE LIKE '010%';
-- 3. EMPLOYEE���� �̸��� '��'�� ���ԵǾ� �ְ� �޿��� 240���� �̻��� ������� �����, �޿� ��ȸ
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��%' AND SALARY >= 2400000;
-- 4. DEPARTMENT���� �ؿܿ������� �μ����� �μ��ڵ�, �μ��� ��ȸ
SELECT DEPT_ID, DEPT_TITLE 
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '�ؿܿ���%';  

-----------------------------------------------------------------------------------------

/*
    < IS NULL / IS NOT NULL >
    �÷����� NULL�� ���� ��� NULL �񱳿� ���Ǵ� ������
*/

-- ���ʽ��� ���� �ʴ� ���(BONUS���� NULL)���� ���, �̸� , �޿�, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
--WHERE BONUS = NULL; -- ���������� ��ȸ �ȵ�
WHERE BONUS IS NULL;

-- ���ʽ��� �޴� ���(BONUS���� NULL�� �ƴ�)���� ���, �̸� , �޿�, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
--WHERE BONUS != NULL; -- ���������� ��ȸ �ȵ�
--WHERE BONUS IS NOT NULL; -- ���������� ��ȸ��
WHERE NOT BONUS IS NULL;
-- NOT�� �÷��� �� �Ǵ� IS�ڿ� ���� ����

-- ����� ���� ���(MANAGER_ID���� NULL)���� �����, ������, �μ��ڵ� ��ȸ
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL;

-- �μ���ġ�� ���� ���� �ʰ� ���ʽ��� �޴� ������� �̸�, ���ʽ�, �μ��ڵ� ��ȸ
SELECT EMP_NAME, BONUS, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL AND BONUS IS NOT NULL;

------------------------------------------------------------------------------------

/*
    <IN>
    �񱳴���÷����� ���� ������ ����߿� ��ġ�ϴ� ���� �ִ��� 
    
    [ǥ����]
    �񱳴���÷� IN ('��1', '��2', '��3', ...) => ���� ������ �������� �� ����ϸ� ����
*/

-- �μ��ڵ尡 D6�̰ų� D8�̰ų� D5�� �μ������� �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
--WHERE DEPT_CODE = 'D6' OR DEPT_CODE = 'D8' OR DEPT_CODE = 'D5'; => �ش����ǵ� �� �� �߿� �ϳ��� �����ص� ��ȸ�� �ȴ�
WHERE DEPT_CODE IN ('D6', 'D8', 'D5');

-- �� ���� �����
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE NOT DEPT_CODE IN ('D6', 'D8', 'D5');

--=================================================================================================================

/*
  < ������ �켱���� >
  0. ()
  1. ��������� +, -, *, / ��
  2. ���Ῥ����  
  3. �񱳿�����(��Һ�, �����)
  4. IS NULL / LIKE 'Ư������' / IN
  5. BETWEEN AND 
  6. NOT(��������)
  7. AND(��������)
  8. OR(��������)
*/
-- ** OR���� AND�� ���� �����!!
-- ����� �� �����ڵ尡 J7�̰ų� J2�� ����� �� �޿��� 200���� �̻��� ������� ��� �÷� ��ȸ
SELECT *
FROM EMPLOYEE
--WHERE JOB_CODE = 'J7' OR JOB_CODE = 'J2' AND SALARY >= 2000000; -- ����� ��ȸ�� �ȵ� -> J7�� J2�鼭 �޿��� 200���� �̻��� ������� ���� ��ȸ
WHERE (JOB_CODE = 'J7' OR JOB_CODE = 'J2') AND SALARY >= 2000000;

--------------------------------------�ǽ�����-------------------------------------------------
-- 1. ����� ���� �μ���ġ�� ���� ���� ������� (�����, ������, �μ��ڵ�) ��ȸ
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL 
    AND DEPT_CODE IS NULL;
-- 2. ����(���ʽ�����X)�� 3000���� �̻��̰� ���ʽ��� ���� �ʴ� ������� (���, �����, �޿�, ���ʽ�) ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE (SALARY*12)>=30000000 
    AND BONUS IS NULL;
-- 3. �Ի����� '95/01/01'�̻��̰� �μ���ġ�� ���� ������� (���, �����, �Ի���, �μ��ڵ�) ��ȸ
SELECT EMP_ID, EMP_NAME, HIRE_DATE, DEPT_CODE
FROM EMPLOYEE
WHERE HIRE_DATE>='95/01/01' 
    AND DEPT_CODE IS NOT NULL;
-- 4. �޿��� 200���� �̻� 500���� ���ϰ� �Ի����� '01/01/01'�̻��̰� ���ʽ��� ���� �ʴ� ������� 
--   (���, �����, �޿�, �Ի���, ���ʽ�) ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE, BONUS
FROM EMPLOYEE
WHERE SALARY BETWEEN 2000000 AND 5000000  
    AND HIRE_DATE>='01/01/01' 
    AND BONUS IS NULL;
-- 5. ���ʽ����Կ����� NULL�� �ƴϰ� �̸��� '��'�� ���ԵǾ��ִ� ������� (���, �����, �޿�, ���ʽ����Կ���) ��ȸ (��Ī�ο�)
SELECT EMP_ID, EMP_NAME, SALARY, (SALARY+BONUS*SALARY)*12 "���ʽ����Կ���"
FROM EMPLOYEE
WHERE (SALARY+BONUS*SALARY)*12 IS NOT NULL  
    AND EMP_NAME LIKE '%��%';

----------------------------------------------------------------------------------------------------------------
SELECT EMP_ID, EMP_NAME, SALARY    -- 3
FROM EMPLOYEE                      -- 1
WHERE DEPT_CODE IS NULL;           -- 2

--==============================================================================================================

/*
    < ORDER BY �� >
    SELECT���� ���� ������ �ٿ� �ۼ� �� �Ӹ� �ƴ϶� ������� ���� �������� ����ȴ�.
    ��ȸ����� ���Ľ��Ѽ� ��ȸ�� �ǰԲ� �����ִ� ����
    
    [ǥ����]
    SELECT ��ȸ���÷�, �÷�, �������� AS "��Ī", ...
    FROM ��ȸ�ϰ����ϴ����̺��
    WHERE ���ǽ�
    ORDER BY ���ı������÷�|��Ī|�÷����� [ASC|DESC] [NULLS FIRST|NULLS LAST] => ASC : �������� / DESC : �������� (������ ��� �⺻ ���� ������������ �����ȴ�)
                                                                           => NULL���� �տ� ��ġ�Ұ���, �ڿ��Ұ��� ���� (��������)
    (ORDER BY���� SELECT�� �Ŀ� ����ǹǷ� "��Ī"����� ����! Ȥ�� �÷����� �ۼ� ����)
    
    - ASE : �������� ���� (���� �� �⺻��)
    - DESC : �������� ����
    
    - NULLS FIRST : �����ϰ��� �ϴ� �ö����� NULL�� ���� ��� �ش� �����͸� �� �� ��ġ (���� �� DESC���� �⺻��)
    - NULLS LAST : �����ϰ��� �ϴ� �÷����� NULL�� ���� ��� �ش� �����͸� �� �� ��ġ (���� �� ASC�϶��� �⺻��)
    
*/

-- EMPLOYEE�� ��ü����� ���� ������ ��ȸ
SELECT *
FROM EMPLOYEE
--ORDER BY BONUS ASC;  -- �������� ������ �� �⺻������ NULLS LAST!
--ORDER BY BONUS ASC NULLS FIRST;
--ORDER BY BONUS DESC;   -- �������� ������ �� �⺻������ NULLS FIRST!
ORDER BY BONUS DESC, SALARY ASC; -- ���ı����� ������ ���� ���� (ù��° ������ �÷����� ������ ��� �ι�° ������ �÷������� ����)

-- EMPLOYEE�� �� ����� �����, ���� ��ȸ (�� �� ������ �������� ���� ��ȸ)
SELECT EMP_NAME, SALARY*12 AS "����"
FROM EMPLOYEE
--ORDER BY SALARY*12 DESC;
--ORDER BY ���� DESC;    -- ��Ī ��� ����
ORDER BY 2 DESC;        -- �÷� ���� ��� ����