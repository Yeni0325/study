/*
    * �������� (SUBQUERY)
    - �ϳ��� SQL�� �ȿ� ���Ե� �Ǵٸ� SELECT��
    - ���� SAL���� ���� ���� ������ �ϴ� ������
*/

-- ������ �������� ���� 1.
-- ���ö ����� ���� �μ��� ���� ������� ��ȸ�ϰ� ����!

-- 1) ���� ���ö ����� �μ��ڵ� ��ȸ
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '���ö';   -- ���ö ����� 'D9'�ΰ� �˾Ƴ�!!

-- 2) �μ��ڵ尡 D9�� ����� ��ȸ 
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

--> ���� 2�ܰ踦 �ϳ��� ���������� ���ĺ���
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '���ö'); --�μ��ڵ尡 ���ö ����� ��ġ�ϴ� �μ��ڵ�
                    
                    
-- ������ �������� ���� 2.
-- �� ������ ��� �޿����� �� ���� �޿��� �޴� ������� ���, �̸�, �����ڵ�, �޿� ��ȸ

-- 1) �� ������ ��� �޿� ��ȸ
SELECT AVG(SALARY)
FROM EMPLOYEE;  --> �� �������� ��ձ޿��� �뷫 3047663�� �ΰ� �˾Ƴ�

-- 2) �޿����� 3047663�� �̻��� ����� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3047663;

-- ���� 2�ܰ踦 �ϳ��� ���������� ���ĺ���
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= (SELECT AVG(SALARY)
                 FROM EMPLOYEE);

----------------------------------------------------------------------------------------------

/*
    * ���������� ����
      ���������� ������ ������� �� �� �� ���̳Ŀ� ���� ���������� ������ ���еȴ�.
      
      - ������ �������� : ���������� ��ȸ ������� ������ ������ 1���� �� (�� ��, �� ��)
      - ������ �������� : ���������� ��ȸ ������� �������� �� (���� ��, �� ��)
      - ���߿� �������� : ���������� ��ȸ ������� �� �������� �÷��� �������� �� (�� ��, ���� ��)
      - ������ ���߿� �������� : ���������� ��ȸ ������� ���� ��, ���� �÷��� �� (���� ��, ���� ��)
      
      => ���������� ������ ���Ŀ� ���� �������� �տ� �ٴ� �����ڰ� �޶�����.
*/
/*
    1. ������ �������� (SINGLE ROW SUBQUERY)
    ���������� ��ȸ ������� ������ ������ 1���� �� (�� ��, �� ��)
    �Ϲ� �񱳿����� ��밡��
    = != ^= > < >=, ...
*/
-- 1) �� ������ ��ձ޿����� �޿��� �� ���� �޴� ������� �����, �����ڵ�, �޿� ��ȸ
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < (SELECT AVG(SALARY)
                FROM EMPLOYEE)
ORDER BY SALARY;

-- 2) ���� �޿��� �޴� ����� ���, �̸�, �޿�, �Ի��� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY)
                FROM EMPLOYEE);
                
-- 3) ���ö ����� �޿����� �� ���� �޴� ������� ���, �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '���ö');

-- JOIN�� ���
-- ���ö ����� �޿����� �� ���� �޴� ������� ���, �̸�, �μ��ڵ�, �޿�, �μ��� ��ȸ
-->> ����Ŭ ���� ����
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '���ö')
  AND DEPT_CODE = DEPT_ID;

-->> ANSI ����
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '���ö');

-- 4) �μ��� �޿����� ���� ū �μ��� �μ��ڵ�, �޿� �� ��ȸ
-- 4-1) ���� �μ��� �޿��� �߿����� ���� ū �� �ϳ��� ��ȸ
SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE; -- 17700000�ΰ� �˾Ƴ�

-- 4-2) �μ��� �޿����� 17700000���� �μ� ��ȸ
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = 17700000;

-- ���� �� �ܰ踦 �ϳ��� ���������� ���ĺ���
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                      FROM EMPLOYEE
                      GROUP BY DEPT_CODE);
                      

-- 5) ������ ����� ���� �μ������� ���, �����, ��ȭ��ȣ, �Ի���, �μ��� ��ȸ
--    ��, �������� ����

-->> ����Ŭ ���� ����
SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID 
  AND DEPT_CODE = (SELECT DEPT_CODE
                   FROM EMPLOYEE
                   WHERE EMP_NAME = '������')
 AND EMP_NAME != '������';                        
 
-->> ANSI ���� ����
SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE DEPT_CODE = (SELECT DEPT_CODE
                   FROM EMPLOYEE
                   WHERE EMP_NAME = '������')
  AND EMP_NAME != '������';
  
----------------------------------------------------------------------------------------
/*
    2. ������ �������� (MULTI ROW SUBQUERY)
    ���������� ������ ������� ���� ���� �� (�÷��� �Ѱ�!)
    
    - 1) IN �������� : �������� ����� �߿��� �Ѱ��� ��ġ�ϴ� ���� �ִٸ�
    
    - > ANY �������� : �������� ����� �߿��� "�Ѱ���" Ŭ ��� ��ȸ(�������� ����� �߿��� ���� ���������� Ŭ ���)
    - < ANY �������� : �������� ����� �߿��� "�Ѱ���" ���� ��� ��ȸ(�������� ����� �߿��� ���� ū������ ���� ���)
    
        �񱳴�� > ANY (��1, ��2, ��3)
        �񱳴�� > ��1 OR �񱳴�� > ��2 OR �񱳴�� > ��3
        => ANY�� OR�� �ؼ��� �ȴ�.
        
    - > ALL �������� : �������� "���" ������� ���� Ŭ ��� ��ȸ
    - < ALL �������� : �������� "���" ������� ���� ���� ��� ��ȸ 
    
        �񱳴�� > ALL (��1, ��2, ��3)
        �񱳴�� > ��1 AND �񱳴�� > ��2 AND �񱳴�� > ��3
        => ALL�� AND�� �ؼ��� �ȴ�.
*/

-- 1) ����� �Ǵ� ������ ����� ���� ������ ������� ���, �����, �����ڵ�, �޿� ��ȸ
-- 1-1) ����� �Ǵ� ������ ����� � �������� ��ȸ
SELECT JOB_CODE
FROM EMPLOYEE
WHERE EMP_NAME IN ('�����', '������'); -- J3, J7

-- 1-2) J3, J7 ������ ����� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN ('J3', 'J7');

-- ���� 2�ܰ踦 �ϳ��� ���������� ���ĺ���
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN (SELECT JOB_CODE
                   FROM EMPLOYEE
                   WHERE EMP_NAME IN ('�����', '������'));

-- ��� => �븮 => ���� => ���� => ���� ...
-- 2) �븮 �����ӿ��� �ұ��ϰ� ���� ���� �޿��� �� �ּ� �޿����� ���� �޴� �������� ���, �̸�, ����, �޿� ��ȸ
-- 2-1) ���� ���� ������ ������� �޿� ��ȸ
SELECT SALARY
FROM EMPLOYEE 
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '����'; -- 2200000, 2500000, 3760000

-- 2-2) ������ �븮�̸鼭 �޿����� ���� ��ϵ� �� �ϳ��� ū ���
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '�븮' 
  AND SALARY > ANY (2200000, 2500000, 3760000);
 
-- ���� 2�ܰ踦 �ϳ��� ���������� ���ĺ���
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '�븮' 
  AND SALARY > ANY (SELECT SALARY
               FROM EMPLOYEE 
               JOIN JOB USING (JOB_CODE)
               WHERE JOB_NAME = '����');
               
--> ������ ���������ε� ����!
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '�븮' 
  AND SALARY > (SELECT MIN(SALARY)
               FROM EMPLOYEE 
               JOIN JOB USING (JOB_CODE)
               WHERE JOB_NAME = '����');
    
-- 3) ���������ӿ��� �ұ��ϰ� ���������� ������� ��� �޿����ٵ� �� ���� �޴� ������� ���, �����, ���޸�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '����'
  AND SALARY > ALL (SELECT SALARY
                    FROM EMPLOYEE
                    JOIN JOB USING (JOB_CODE)
                    WHERE JOB_NAME = '����');
                    
-----------------------------------------------------------------------------------------

/*
    3. ���߿� ��������
    ������� ���������� ������ �÷����� �������� ���
*/

-- 1) ������ ����� ���� �μ��ڵ�, ���� �����ڵ忡 �ش��ϴ� ������� �����, �μ��ڵ�, �����ڵ�, �Ի��� ��ȸ
-->> ������ ���������ε� �����ϱ��ϴ�
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                   FROM EMPLOYEE
                   WHERE EMP_NAME = '������') -- 'D5'
  AND JOB_CODE = (SELECT JOB_CODE
                  FROM EMPLOYEE
                  WHERE EMP_NAME = '������'); -- 'J5'

-->> ���߿� ��������
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE
                               FROM EMPLOYEE
                               WHERE EMP_NAME = '������');
                               
-- 2) �ڳ��� ����� ���� �����ڵ�, ���� ����� ������ �ִ� ������� ���, �����, �����ڵ�, ������ ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE (JOB_CODE, MANAGER_ID) = (SELECT JOB_CODE, MANAGER_ID
                                FROM EMPLOYEE
                                WHERE EMP_NAME = '�ڳ���');
                                
----------------------------------------------------------------------------------------------

/*
    4. ������ ���߿� ��������
    �������� ��ȸ ������� ������ �������� ���
*/

-- 1) �� ���޺� �ּұ޿��� �޴� ����� ���, �����, �����ڵ�, �޿� ��ȸ
-- 1-1) �� ���޺� �ּұ޿� ��ȸ
SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE = 'J2' AND SALARY = 3700000
   OR JOB_CODE = 'J7' AND SALARY = 1380000
   OR JOB_CODE = 'J3' AND SALARY = 3400000
   ...;
   
-- ���� ������ �ٸ��� ǥ��  
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) = ('J2', 3700000)
   OR (JOB_CODE, SALARY) = ('J7', 1380000)
   OR (JOB_CODE, SALARY) = ('J3', 3400000)
   ...;
   
-- �������� ����
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, MIN(SALARY)
                             FROM EMPLOYEE
                             GROUP BY JOB_CODE);
                             
-- 2) �� �μ��� �ְ�޿��� �޴� ������� ���, �����, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, MAX(SALARY)
                              FROM EMPLOYEE
                              GROUP BY DEPT_CODE);
                              
-------------------------------------------------------------------------------------------

/*
    5. �ζ��� �� (INLINE - VIEW)
    FROM ���� ���������� �ۼ��� ��
    
    ���������� ������ ����� ��ġ ���̺�ó�� ���

*/

-- ������� ���, �̸�, ���ʽ����Կ���(��Ī�ο�), �μ��ڵ� ��ȸ => ���ʽ����Կ����� ���� NULL�� ������ �ʵ���!
-- ��, ���ʽ����Կ����� 3000���� �̻��� ����鸸 ��ȸ
SELECT EMP_ID, EMP_NAME, (SALARY+SALARY*NVL(BONUS,0))*12 "����", DEPT_CODE  -- 3
FROM EMPLOYEE                                                               -- 1
WHERE (SALARY+SALARY*NVL(BONUS,0))*12 >= 30000000;                          -- 2 (WHERE������ �ٷ� ��Ī ��� ����)

SELECT *
FROM (SELECT EMP_ID, EMP_NAME, (SALARY+SALARY*NVL(BONUS,0))*12 "����", DEPT_CODE 
FROM EMPLOYEE)
WHERE ���� >= 30000000;

SELECT EMP_NAME, DEPT_CODE, ����
FROM (SELECT EMP_ID, EMP_NAME, (SALARY+SALARY*NVL(BONUS,0))*12 "����", DEPT_CODE 
FROM EMPLOYEE)
WHERE ���� >= 30000000;

SELECT EMP_NAME, DEPT_CODE, MANAGER_ID -- �����߻� : �Ʒ� ���̺��� MANAGER_ID�� �������� �ʱ� ����
FROM (SELECT EMP_ID, EMP_NAME, (SALARY+SALARY*NVL(BONUS,0))*12 "����", DEPT_CODE 
FROM EMPLOYEE)
WHERE ���� >= 30000000;

-->> �ζ��� �並 �ַ� ����ϴ� �� => TOP-N �м�

-- 1) �� ���� �� �޿��� ���� ���� ���� 5�� ��ȸ
-- * ROWNUM : ����Ŭ���� �������ִ� �÷����� ��ȸ�� ������� 1������ ������ �ο����ִ� �÷�
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC;
-- FROM --> SELECT ROWNUM (�� �� ���� �ο��� => ���ĵ� �ϱ����� �̹� ���� �ο�) --> ORDER BY

SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE ROWNUM <= 5
ORDER BY SALARY DESC;
--> �������� ����� ��ȸ���� ����! (������ �Ǳ⵵ ���� 5���� �߷����� ���� ����)

--> ORDER BY���� �� ����� ����� ������ ROWNUM �ο� �� 5�� �߷�����!
SELECT ROWNUM, E.*
FROM (SELECT EMP_NAME, SALARY, DEPT_CODE
      FROM EMPLOYEE
      ORDER BY SALARY DESC) E
WHERE ROWNUM <= 5;

-- 2) ���� �ֱٿ� �Ի��� ��� 5���� �����, �޿�, �Ի��� ��ȸ
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM (SELECT *
      FROM EMPLOYEE
      ORDER BY HIRE_DATE DESC)
WHERE ROWNUM <= 5;

-- 3) �� �μ��� ��ձ޿��� ���� 3���� �μ� ��ȸ 
SELECT DEPT_CODE, FLOOR(��ձ޿�)
FROM (SELECT DEPT_CODE, AVG(SALARY) "��ձ޿�"
      FROM EMPLOYEE
      GROUP BY DEPT_CODE
      ORDER BY AVG(SALARY) DESC)
WHERE ROWNUM <=3;

---------------------------------------------------------------------------------------

/*
    * ������ �ű�� �Լ� (WINDOW FUNCTION)
   
   [ǥ����] 
    RANK() OVER(���ı���) | DENSE_RANK() OVER(���ı���) => ���������� ���� ���Ĺ���� �ٸ�
    
    - RANK() OVER(���ı���) : ������ ���� ������ ����� ������ �ο� �� ��ŭ �ǳʶ�� ���� ���
                             EX) ���� 1���� 2���̸� �� ���� ������ 3��
    - DENSE_RANK() OVER(���ı���) : ������ ������ �ִ� �ص� �� ���� ������ ������ 1�� ������Ŵ
                                   EX) ���� 1���� 2���̴��� �� ���� ������ 2��
    
    >> �� �Լ��� ������ SELECT�������� ��� ����!!
*/

-- 1) �޿��� ���� ����� ������ �Űܼ� ��ȸ
-- RANK() OVER(���ı���)
SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "����"
FROM EMPLOYEE;
--> ���� 19�� 2�� �� ���� ������ 21��

-- DENSE_RANK() OVER(���ı���)
SELECT EMP_NAME, SALARY, DENSE_RANK() OVER(ORDER BY SALARY DESC) "����"
FROM EMPLOYEE;
--> ���� 19�� 2�� �� ���� ������ 20��

-- �޿� ���� 5�� ��ȸ
SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "����"
FROM EMPLOYEE
WHERE RANK() OVER(ORDER BY SALARY DESC) <= 5;  -- ������! (WHERE���� ��� ����)

-->> �ζ��κ並 �� �� �ۿ� ����
SELECT *
FROM (SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "����"
      FROM EMPLOYEE)
WHERE ���� <= 5;