/*
    < GROUP BY �� >
    �׷������ ������ �� �ִ� ���� (�ش� �׷��к��� ���� �׷��� ���� �� ����)
    �������� ������ �ϳ��� �׷����� ��� ó���� �������� ����Ѵ�.
*/
SELECT SUM(SALARY) 
FROM EMPLOYEE; --> ��ü ����� �ϳ��� �׷����� ��� ������ ���� ���

-- EMPLOYEE���� �� �μ��� �޿��� ���� ��ȸ
SELECT DEPT_CODE, SUM(SALARY) -- ���������� DEPT_CODE�� GROUP BY���� ����߱� ������ SELECT���� GROUP BY���� ���� �÷��� DEPT_CODE�� �ۼ� �����ϴ�.
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- EMPLOYEE�� �� �μ��� ��� �� ��ȸ
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- EMPLOYEE�� �� �μ��� ��� ���� �ش� �μ��� �޿� ��ȸ
SELECT DEPT_CODE, COUNT(*), SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- �������
SELECT DEPT_CODE, SUM(SALARY)    -- 3
FROM EMPLOYEE                    -- 1 (FROM���� �׻� ���� ���� ����)
GROUP BY DEPT_CODE               -- 2
ORDER BY DEPT_CODE;              -- 4 (ORDER BY���� �׻� SELECT���� �� �������� ����)
-- �������� ���� (NULL ���� ��ġ)

-- EMPLOYEE�� �ߺ����� ������ �� �� ���޺� ��ȸ
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

-- EMPLOYEE�� �� ���޺��� �׷��� ���� �� ��� ���� �޿� �� ��ȸ
SELECT JOB_CODE, COUNT(*), SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

-- EMPLOYEE�� �� ���޺��� �� �����, ���ʽ��� �޴� ��� ��, �޿� ��, ��ձ޿�, �����޿�, �ִ�޿� ��ȸ
SELECT JOB_CODE, COUNT(*) "�� �����", COUNT(BONUS) "���ʽ��� �޴� �����", 
       SUM(SALARY) "�� �޿� ��", FLOOR(AVG(SALARY)) "��ձ޿�", 
       MIN(SALARY) "�����޿�", MAX(SALARY) "�ִ�޿�"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE; -- 1�̶�� �ص� �����ϰ� ���ĵ�

-- EMPLOYEE�� �� �μ����� �� �����, ���ʽ��� �޴� ��� ��, �޿� ��, ��ձ޿�, �����޿�, �ִ�޿� ��ȸ
SELECT DEPT_CODE, COUNT(*) "�� �����", COUNT(BONUS) "���ʽ��� �޴� �����", 
       SUM(SALARY) "�� �޿� ��", FLOOR(AVG(SALARY)) "��ձ޿�", 
       MIN(SALARY) "�����޿�", MAX(SALARY) "�ִ�޿�"
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE; -- 1�̶�� �ص� �����ϰ� ���ĵ�

-- GROUP BY ���� �Լ��� ��� ����!
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1', '��', '2', '��'), COUNT(*)
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO, 8, 1);

-- GROUP BY ���� �������� �÷� ��� ����!
-- DEPT_CODE�� JOB_CODE�� ���� ����� ���� �޿� �� ��ȸ
SELECT DEPT_CODE, JOB_CODE, COUNT(*), SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE;

------------------------------------------------------------------------------------------
/*
    < HAVING �� >
    �׷쿡 ���� ������ ������ �� ���Ǵ� ���� (�ַ� �׷��Լ����� ������ ������ ������ �� ���)
*/

-- EMPLOYEE�� �� �μ��� ��� �޿� ��ȸ (�μ��ڵ�, ��ձ޿�)
SELECT DEPT_CODE, FLOOR(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- �� �μ��� ��� �޿��� 300���� �̻��� �μ��鸸 ��ȸ
SELECT DEPT_CODE, FLOOR(AVG(SALARY))
FROM EMPLOYEE 
WHERE AVG(SALARY) >= 3000000 -- ���� �߻� (�׷��Լ������� �������ý� WHERE�������� �ȵ�!)
GROUP BY DEPT_CODE;

SELECT DEPT_CODE, ROUND(AVG(SALARY))  -- 4
FROM EMPLOYEE                         -- 1
GROUP BY DEPT_CODE                    -- 2
HAVING AVG(SALARY) >= 3000000;        -- 3

-- ���޺� �� �޿��� (��, ���޺� �޿����� 1000���� �̻��� ���޸��� ��ȸ) �����ڵ�, �޿��� ��ȸ
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING  SUM(SALARY) >= 10000000;

-- �μ����� ���ʽ��� �޴� ����� ���� �μ����� ��ȸ �μ��ڵ常 ��ȸ
SELECT DEPT_CODE
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0;

-----------------------------------------------------------------------------------------
/*
    < SELECT�� ������� >
    5 : SELECT     * | ��ȸ�ϰ����ϴ� �÷� AS ��Ī | ����� "��Ī" | �Լ��� AS "��Ī"
    1 : FROM       ��ȸ�ϰ����ϴ� ���̺��
    2 : WHERE      ���ǽ� (�����ڵ� ������ ���)
    3 : GROUP BY   �׷�������� ���� �÷� | �Լ���
    4 : HAVING     ���ǽ� (�׷��Լ��� ������ ���)
    6 : ORDER BY   �÷� | ��Ī | �÷����� [ASC|DESC] [NULLS FIRST | NULLS LAST]
    
*/

-------------------------------------------------------------------------------------------

/*
    < ���� �Լ� >
    �׷캰 ����� ��� ���� �߰����踦 ������ִ� �Լ�
    
    ROLLUP, CUBE
    
    => GROUP BY ���� ����ϴ� �Լ�
*/

-- �� ���޺� �޿���
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

-- ������ ������ ��ü �� �޿��ձ��� ���� ��ȸ�ϰ��� �� ��
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(JOB_CODE)
ORDER BY JOB_CODE;

SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(JOB_CODE)
ORDER BY JOB_CODE;
-- �׷������ �÷��� �ϳ��� ���� CUBE, ROLLUP�� �������� ���� ����!

-- �� �������� ������ �Ѵٸ� �׷������ �÷��� �ΰ��� �־����!
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE
ORDER BY DEPT_CODE;

-- ROLL UP(�÷�1, �÷�2) : �÷�1�� ������ �ٽ� �߰����踦 ���� �Լ�
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE)
ORDER BY DEPT_CODE;

-- CUBE(�÷�1, �÷�2) : �÷�1�� ������ �߰����赵 ����, �÷�2�� ������ �߰����踦 ��
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE)
ORDER BY DEPT_CODE;

---------------------------------------------------------------------------------------------

/*
    < ���� ������ == SET OPERATION >
    
    �������� �������� ������ �ϳ��� ���������� ����� ������
    
    - UNION      : OR�������� ��ü ����  | ������ (�� ������ ������ ������� ���� �� �ߺ��Ǵ� ���� �ѹ��� ����������)
    - INTERSECT  : AND�������� ��ü ���� | ������ (�� ������ ������ ������� �ߺ��� �����)
    - UNION ALL  : ������ + ������ (�� ������ ������ ������� ���ϵ�, �ߺ����� �ι� ǥ���ȴ�)
    - MINUS      : ������ (���� ��������� ���� ������� �� ������) 
*/
-- 1. UNION
-- �μ��ڵ尡 D5�� ��� �Ǵ� �޿��� 300���� �ʰ��� ����� ��ȸ (���, �̸�, �μ��ڵ�, �޿�)

-- �μ��ڵ尡 D5�� ����鸸 ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'; -- 6�� �� (�ڳ���, ������, ���ؼ�, "�ɺ���", ������, "���ȥ")

-- �޿��� 300���� �ʰ��� ����鸸 ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000; -- 8�� �� (������, ���߱�, ���ö, �����, "�ɺ���", "���ȥ", ������)

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' -- 6��
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000; -- 8��
--> 12�� ��

-- ���� ������ ��� �Ʒ�ó�� WHERE���� OR�ᵵ �ذᰡ��!!!
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR SALARY > 3000000;

-- 2. INTERSECT (������)
-- �μ��ڵ尡 D5�̸鼭 �޿������� 300���� �ʰ��� ��� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- ���� ������ ��� �Ʒ�ó�� WHERE���� AND�ᵵ �ذᰡ��!!!
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' AND SALARY > 3000000;

----------------------------------------------------------------------------------------------
-- ���տ����� ��� �� ���ǻ���
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' -- 6��
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE SALARY > 3000000;
-- �� �������� SELECT���� �ۼ��Ǿ��ִ� �÷� ���� �����ؾߵ�!!

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' -- 6��
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY > 3000000;
-- �÷� ���� �Ӹ� �ƴ϶� �� �÷��ڸ����� ������ Ÿ������ ����ؾ���!!


SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' -- 6��
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000
ORDER BY EMP_NAME;
-- ORDER BY ���� ���̰��� �Ѵٸ� �������� ����ؾ���!!
--------------------------------------------------------------------------------------------

-- 3. UNION ALL (������ + ������)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' -- 6��
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000; -- 8��
-- 14�� �� ��ȸ

-- 4. MINUS (������)
-- �μ��ڵ尡 D5�� ����� �� �޿��� 300���� �ʰ��� ����� �����ؼ� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' -- ����SELECT��
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000; -- ���� SELECT��

-- �Ʒ�ó���� �����ϱ� ��!!
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' AND SALARY <= 3000000;
