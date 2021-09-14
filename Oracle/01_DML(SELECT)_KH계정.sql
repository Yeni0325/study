/*
    < SELECT >
    ������ ��ȸ�� �� ���Ǵ� ���� 
    
    >> RESULT SET : SELECT���� ���� ��ȸ�� ����� (��, ��ȸ�� ����� ������ �ǹ�)
    
    [ǥ����]
    SELECT ��ȸ�ϰ����ϴ��÷�, �÷�, �÷�, .. 
    FROM ���̺��;
*/

-- EMPLOYEE ���̺� ��� �÷�(*) ��ȸ
SELECT *
FROM EMPLOYEE;

-- EMPLOYEE ���̺� ���, �̸�, �޿����� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE;

select emp_id, emp_name, salary
from employee;
-- oracle�� Ű����, ���̺��, �÷��� ���� ��ҹ��� ������ ����!! (���������� ����)

-- JOB ���̺� ��� �÷� ��ȸ
SELECT *
FROM JOB;

------------------------ �ǽ����� --------------------
-- 1. JOB ���̺� ���޸� �÷��� ��ȸ
SELECT JOB_NAME
FROM JOB;
-- 2. DEPARTMENT ���̺��� ��� �÷� ��ȸ
SELECT *
FROM DEPARTMENT;
-- 3. DEPARTMENT ���̺� �μ��ڵ�, �μ��� ��ȸ
SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT;
-- 4. EMPLOYEE ���̺� �����, �̸���, ��ȭ��ȣ, �Ի���, �޿� ��ȸ
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE, SALARY
FROM EMPLOYEE;

-- --------------------------------------------------------------

/*
    < �÷����� ���� ������� >
    SELECT �� �÷��� �ۼ��κп� ������� ��� ���� (�̶� �������� ��� ��ȸ)
*/
-- EMPLOYEE�� �����, ����� ����(�޿�*12) ��ȸ
SELECT EMP_NAME, SALARY * 12
FROM EMPLOYEE;

-- EMPLOYEE�� �����, �޿�, ���ʽ�, ����, ���ʽ����Եȿ���((�޿� + ���ʽ�*�޿�) * 12) ��ȸ
SELECT EMP_NAME, SALARY, BONUS, SALARY * 12, (SALARY + BONUS * SALARY) * 12
FROM EMPLOYEE;
--> ������� ���� �� NULL���� ������ ��� ��������� ����� ������ ������ NULL������ ����!

-- EMPLOYEE�� �����, �Ի���, �ٹ��ϼ�(���ó�¥ - �Ի���)
-- DATE���ĳ����� ���� ����! 
-- * ���ó�¥ : SYSDATE 
SELECT EMP_NAME, HIRE_DATE, SYSDATE - HIRE_DATE
FROM EMPLOYEE;
-- DATE - DATE : ������� �� ������ ����! 
-- ��, ���� �������� ������ DATE������ ��/��/��/��/��/�� ������ �ð����������� ������ �ϱ� ����!

-- ���� �ý��� ��¥ �� �ð��� ��ȸ 
SELECT SYSDATE 
FROM DUAL; -- ����Ŭ���� �����ϴ� �������̺�(�������̺�)

--------------------------------------------------------------------

/*
    < �÷��� ��Ī �����ϱ� >
    ��������� �ϰ� �Ǹ� �÷��� ��������.. �̶� �÷������� ��Ī �ο��ؼ� ����ϰ� ������
    
    [ǥ����]
    �÷��� ��Ī / �÷��� AS ��Ī / �÷��� "��Ī" / �÷��� AS "��Ī"
    
    AS ���̵� �Ⱥ��̵簣�� �ο��ϰ��� �ϴ� ��Ī�� ���� Ȥ�� Ư�����ڰ� ���Ե� ��� �ݵ�� ���������̼�("")�� ����ؾߵ�!
*/
SELECT EMP_NAME �����, SALARY AS �޿�, SALARY*12 "����(��)", (SALARY + BONUS*SALARY)*12 AS "�� �ҵ�"
FROM EMPLOYEE;

------------------------------------------------------------------------------

/*
    < ���ͷ� >
    ���Ƿ� ������ ���ڿ�('')
    
    SELECT ���� ���ͷ��� �����ϸ� ��ġ ���̺�� �����ϴ� ������ ó�� ��ȸ ���� 
    ��ȸ�� RESULT SET�� ��� �࿡ �ݺ������� ���� ���
*/
-- EMPLOYEE�� ���, �����, �޿� ��ȸ 
SELECT EMP_ID, EMP_NAME, SALARY, '��' AS ����
FROM EMPLOYEE;

/*
    < ���� ������ : || >
    ���� �÷������� ��ġ �ϳ��� �÷��ΰ�ó�� �����ϰų�, �÷����� ���ͷ��� ������ �� ����
    
    System.out.println("num : " + num); // ���⼭�� + ����
*/
-- ���, �̸�, �޿��� �ϳ��� �÷����� ��ȸ
SELECT EMP_ID || EMP_NAME || SALARY
FROM EMPLOYEE;

-- �÷����̶� ���ͷ��� ����
-- XXX�� ������ XXX�� �Դϴ�.
SELECT EMP_NAME || '�� ������ ' || SALARY || '�� �Դϴ�.' "�޿� ����"
FROM EMPLOYEE;

--------------------------------------------------------------------------

/*
    < DISTINCT > 
    �÷��� �ߺ��� ������ �ѹ����� ǥ���ϰ��� �� �� ���
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

-- ���ǻ��� : DISTINCT�� SELECT���� �� �ѹ��� ��� ���� 
/* ���� ����
SELECT DISTINCT JOB_CODE, DISTINCT DEPT_CODE
FROM EMPLOYEE;
*/

SELECT DISTINCT JOB_CODE, DEPT_CODE
FROM EMPLOYEE;
-- (JOB_CODE, DEPT_CODE) ������ ��� �ߺ� �Ǻ� 

-- ==============================================================================
/*
    < WHERE �� >
    ��ȸ�ϰ��� �ϴ� ���̺�κ��� Ư�� ���ǿ� �����ϴ� �����͸��� ��ȸ�ϰ��� �� �� ��� 
    �̶� WHERE���� ���ǽ��� �����ϰԵ� 
    ���ǽĿ����� �پ��� �����ڵ� ��밡��!
    
    [ǥ����]
    SELECT ��ȸ�ϰ����ϴ��÷�, �÷�, �������, ... 
    FROM ���̺��
    WHERE ���ǽ�;
    
    >> �񱳿����� <<
    >, <, >=, <=      --> ��Һ�
    =                 --> ��������
    !=, ^=, <>        --> ������������
*/
-- EMPLOYEE���� �μ��ڵ尡 'D9'�� ����鸸 ��ȸ (�̶�, ��� �÷� ��ȸ)
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- EMPLOYEE���� �μ��ڵ尡 'D1'�� ������� �����, �޿�, �μ��ڵ常 ��ȸ
SELECT EMP_NAME, SALARY  --, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1';

-- �μ��ڵ尡 'D1'�� �ƴ� ������� ���, �����, �μ��ڵ� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
--WHERE DEPT_CODE != 'D1';
--WHERE DEPT_CODE ^= 'D1';
WHERE DEPT_CODE <> 'D1';

-- �޿��� 400���� �̻��� ������� �����, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 4000000;

-- EMPLOYEE���� ������(ENT_YN �÷����� 'N'��)�� ������� ���, �̸�, �Ի��� 
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE ENT_YN = 'N';

------------------------------ �ǽ����� -------------------------------------
-- 1. �޿��� 300���� �̻��� ������� �����, �޿�, �Ի���, ���� ��ȸ
SELECT EMP_NAME, SALARY, HIRE_DATE, SALARY*12
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- 2. ������ 5000���� �̻��� ������� �����, �޿�, ����, �μ��ڵ� ��ȸ
SELECT EMP_NAME, SALARY, SALARY*12 "����", DEPT_CODE
FROM EMPLOYEE
WHERE SALARY*12 >= 50000000;
--WHERE ���� >= 50000000; -- ����(WHERE�������� SELECT���� �ۼ��� ��Ī ���Ұ�!!)
-- ������� : FROM�� => WHERE�� => SELECT�� 

-- 3. �����ڵ尡 'J3'�� �ƴ� ������� ���, �����, �����ڵ�, ��翩�� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, ENT_YN
FROM EMPLOYEE
WHERE JOB_CODE != 'J3';

---------------------------------------------------------------------------------

/*
    < �� ������ >
    �������� ������ ��� �����ϰ��� �� �� ���
    
    AND (~�̸鼭, �׸���) 
    OR (~�̰ų�, �Ǵ�)
*/
-- �μ��ڵ尡 'D9'�̸鼭 �޿��� 500���� �̻��� ������� �����, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9' AND SALARY >= 5000000;

-- �μ��ڵ尡 'D6'�̰ų� �޿��� 300���� �̻��� ������� �����, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' OR SALARY >= 3000000;

-- �޿��� 350���� �̻� 600���� ���ϸ� �޴� ������� �����, ���, �޿� ��ȸ
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
-- WHERE 3500000 <= SALARY <= 6000000; -- �����߻�
WHERE SALARY >= 3500000 AND SALARY <= 6000000;

--------------------------------------------------------------------------------

/*
    < BETWEEN AND >
    ���ǽĿ��� ���Ǵ� ����
    �� �̻� �� ������ ������ ���� ������ �����Ҷ� ���Ǵ� ������ 
    
    [ǥ����]
    �񱳴���÷� BETWEEN ���Ѱ� AND ���Ѱ�
    => �ش� �÷����� ���Ѱ� �̻��̰� ���Ѱ� ������ ��� 
*/
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000; -- 6�� 

SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
--WHERE SALARY < 3500000 OR SALARY > 6000000;
--WHERE NOT SALARY BETWEEN 3500000 AND 6000000;
WHERE SALARY NOT BETWEEN 3500000 AND 6000000;
-- NOT : ������������
-- �÷��� �� �Ǵ� BETWEEN �տ� ���԰���

-- �Ի����� '90/01/01' ~ '01/01/01'
SELECT *
FROM EMPLOYEE
--WHERE HIRE_DATE >= '90/01/01' AND HIRE_DATE <= '01/01/01'; -- DATE������ ��Һ� ����! 
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';

--------------------------------------------------------------------------------

/*
    < LIKE > 
    ���ϰ����ϴ� �÷����� ���� ������ Ư�� ���Ͽ� ������ ��� ��ȸ 
    
    [ǥ����]
    �񱳴���÷� LIKE 'Ư������'
    
    - Ư������ ���ý� '%', '_'�� ���ϵ� ī��� ����� �� ���� 
    >> '%' : 0���� �̻�
    EX) �񱳴���÷� LIKE '����%'   => �񱳴���� �÷����� ���ڷ� "����"�Ǵ°� ��ȸ 
        �񱳴���÷� LIKE '%����'   => �񱳴���� �÷����� ���ڷ� "��"���� �� ��ȸ
        �񱳴���÷� LIKE '%����%'  => �񱳴���� �÷����� ���ڰ� "����"�Ǵ� �� ��ȸ (Ű���� �˻�)
    
    >> '_' : 1���� 
    EX) �񱳴���÷� LIKE '_����'   => �񱳴���� �÷����� ���ھտ� ������ �ѱ��ڰ� �� ��� ��ȸ 
        �񱳴���÷� LIKE '__����'  => �񱳴���� �÷����� ���ھտ� ������ �α��ڰ� �� ��� ��ȸ
        �񱳴���÷� LIKE '_����_'  => �񱳴���� �÷����� ���� �հ� �ڿ� ������ �ѱ��ھ� �� ��� ��ȸ 
        
*/
-- ����� �� ���� ������ ������� �����, �޿�, �Ի��� ��ȸ
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '��%';

-- �̸� �߿� �� �� ���Ե� ������� �����, �ֹι�ȣ, ��ȭ��ȣ ��ȸ
SELECT EMP_NAME, EMP_NO, PHONE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��%';

-- �̸��� ��� ���ڰ� �� �� ������� �����, ��ȭ��ȣ ��ȸ
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '_��_';

-- ��ȭ��ȣ�� 3��° �ڸ��� 1�� ������� ���, �����, ��ȭ��ȣ, �̸��� ��ȸ 
-- ���ϵ�ī�� : _(1����), %(0�����̻�)
SELECT EMP_ID, EMP_NAME, PHONE, EMAIL
FROM EMPLOYEE
WHERE PHONE LIKE '__1%'; 

-- �̸��� �� _ �ձ��ڰ� 3������ ������� ���, �̸�, �̸��� ��ȸ 
-- EX) sim_bs@kh.or.kr , sun_di@kh.or.kr
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '____%'; -- ���ߴ� ��� ���� ����!
-- ���ϵ� ī��� ���ǰ� �ִ� ���ڿ� �÷����� ��� ���ڰ� �����ϱ� ������ ����� ��ȸ �ȵ�! (�� ���ϵ�ī�� _�� �ν���!)
--> ��� ���ϵ� ī��� ��� �����Ͱ����� ��������ߵ�! 
--> �����Ͱ����� ����ϰ����ϴ� �� �տ� ������ ���ϵ� ī�带 �����ϰ� ������ ���ϵ�ī�带 ESCAPE OPTION���� ����ؾߵ�!
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___$_%' ESCAPE '$';

-- ���� ������� �ƴ� �� ���� ����� ��ȸ 
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE NOT EMAIL LIKE '___$_%' ESCAPE '$';
-- NOT�� �÷��� �� �Ǵ� LIKE �տ� ���԰���

--------------------------- �ǽ����� --------------------------------------
-- 1. EMPLOYEE���� �̸��� '��'���� ������ ������� �����, �Ի��� ��ȸ
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��';

-- 2. EMPLOYEE���� ��ȭ��ȣ ó�� 3�ڸ��� 010�� �ƴ� ������� �����, ��ȭ��ȣ ��ȸ
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';

-- 3. EMPLOYEE���� �̸��� '��'�� ���ԵǾ��ְ� �޿��� 240���� �̻��� ������� �����, �޿� ��ȸ
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��%' AND SALARY >= 2400000;

-- 4. DEPARTMENT���� �ؿܿ������� �μ����� �μ��ڵ�, �μ��� ��ȸ 
SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '�ؿܿ���%';

----------------------------------------------------------------------------------

/*
    < IS NULL / IS NOT NULL >
    �÷����� NULL�� ���� ��� NULL�� �񱳿� ���Ǵ� ������ 
*/
-- ���ʽ��� ���� �ʴ� ���(BONUS���� NULL��)���� ���, �̸�, �޿�, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
--WHERE BONUS = NULL; -- ���������� ��ȸ �ȵ�
WHERE BONUS IS NULL;

-- ���ʽ��� �޴� ���(BONUS���� NULL�� �ƴ�)���� ���, �̸�, �޿�, ���ʽ� ��ȸ 
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
--WHERE BONUS != NULL; -- ���������� ��ȸ �ȵ�
--WHERE BONUS IS NOT NULL; -- ���������� ��ȸ��
WHERE NOT BONUS IS NULL;
-- NOT�� �÷��� �� �Ǵ� IS �ڿ� ���԰��� 

-- ����� ���� ���(MANAGER_ID���� NULL��)���� �����, ������, �μ��ڵ� ��ȸ
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL;

-- �μ���ġ�� ���� ���� �ʰ� �ٵ� ���ʽ��� �޴� ������� �̸�, ���ʽ�, �μ��ڵ� ��ȸ
SELECT EMP_NAME, BONUS, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL AND BONUS IS NOT NULL;

-------------------------------------------------------------------------------

/*
    < IN >
    �񱳴���÷����� ���� ������ ����߿� ��ġ�ϴ� ���� �ִ��� 
    
    [ǥ����]
    �񱳴���÷� IN ('��1', '��2', '��3', ...)
*/
-- �μ��ڵ尡 D6�̰ų� D8�̰ų� D5�� �μ������� �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
--WHERE DEPT_CODE = 'D6' OR DEPT_CODE = 'D8' OR DEPT_CODE = 'D5';
WHERE DEPT_CODE IN ('D6', 'D8', 'D5');

-- �׿��� ����� 
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE NOT IN ('D6', 'D8', 'D5');

--==============================================================================

/*
    < ������ �켱���� > 
    0. ()
    1. ��������� 
    2. ���Ῥ���� 
    3. �񱳿�����
    4. IS NULL / LIKE 'Ư������' / IN 
    5. BETWEEN AND 
    6. NOT(��������)
    7. AND(��������)
    8. OR(��������)
*/
-- ** OR���� AND�� ���� �����!!
-- �����ڵ尡 J7�̰ų� J2�� ����� �� �޿��� 200���� �̻��� ������� ��� �÷� ��ȸ
SELECT * 
FROM EMPLOYEE
WHERE (JOB_CODE = 'J7' OR JOB_CODE = 'J2') AND SALARY >= 2000000;

--------------------------- �ǽ����� ----------------------------------------
-- 1. ����� ���� �μ���ġ�� ���� ���� ������� (�����, ������, �μ��ڵ�) ��ȸ
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL 
  AND DEPT_CODE IS NULL;

-- 2. ����(���ʽ�����X)�� 3000���� �̻��̰� ���ʽ��� ���� �ʴ� ������� (���, �����, �޿�, ���ʽ�) ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE SALARY * 12 >= 30000000 
  AND BONUS IS NULL;

-- 3. �Ի����� '95/01/01'�̻��̰� �μ���ġ�� ���� ������� (���, �����, �Ի���, �μ��ڵ�) ��ȸ
SELECT EMP_ID, EMP_NAME, HIRE_DATE, DEPT_CODE
FROM EMPLOYEE
WHERE HIRE_DATE >= '95/01/01'
  AND DEPT_CODE IS NOT NULL;

-- 4. �޿��� 200���� �̻� 500���� ���ϰ� �Ի����� '01/01/01'�̻��̰� ���ʽ��� ���� �ʴ� ������� 
--   (���, �����, �޿�, �Ի���, ���ʽ�) ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE, BONUS
FROM EMPLOYEE
WHERE SALARY BETWEEN 2000000 AND 5000000
  AND HIRE_DATE >= '01/01/01'
  AND BONUS IS NULL;

-- 5. ���ʽ����Կ����� NULL�� �ƴϰ� �̸��� '��'�� ���ԵǾ��ִ� ������� (���, �����, �޿�, ���ʽ����Կ���) ��ȸ (��Ī�ο�)
SELECT EMP_ID, EMP_NAME, SALARY, (SALARY + SALARY*BONUS) * 12 "���ʽ����� ����"
FROM EMPLOYEE
WHERE (SALARY + SALARY*BONUS) * 12 IS NOT NULL
  AND EMP_NAME LIKE '%��%';










