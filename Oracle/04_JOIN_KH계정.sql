/*
    < JONIN >
    �� �� �̻��� ���̺��� �����͸� ��ȸ�ϰ��� �� �� ���Ǵ� ����
    ��ȸ ����� �ϳ��� �����(RESULT SET)�� ����
    
    ������ �����ͺ��̽��� �ּ����� �����ͷ� ������ ���̺� ��� ���� (�ߺ��� �ּ�ȭ�ϱ� ���� �ִ��� �ɰ��� ������)
    
    => ������ �����ͺ��̽����� SQL���� �̿��� ���̺� "����"�� �δ� ���
    (������ �� ��ȸ�� �ؿ��°� �ƴ϶� �� ���̺� ������ν��� �����͸� ��Ī���Ѽ� ��ȸ�ؾߵ�!!)
    
    JOIN�� ũ�� "����Ŭ���뱸��"�� "ANSI����"���� �з� (ANSI == �̱�����ǥ����ȸ)
    
    
                                   [JOIN ��� ����]
                 ����Ŭ���뱸��            |                      ANSI����                   
-------------------------------------------------------------------------------------------------------
                 � ����                |      ���� ����(INNER JOIN)  => JOIN USING / ON      
                (EQUAL JOIN)             |      �ڿ� ����(NATURAL JOIN) => JOIN USING
-------------------------------------------------------------------------------------------------------
                 ���� ����                |           ���� �ܺ� ���� (LEFT OUTER JOIN)
                (LEFT OUTER)             |         ������ �ܺ� ���� (RIGHT OUTER JOIN)
               (RIGHT OUTER)             |           ��ü �ܺ� ���� (FULL OUTER JOIN)
--------------------------------------------------------------------------------------------------------
             ��ü ����(SELF JOIN)         |                     JOIN ON
         �� ����(NON EQUAL JOIN)      |
--------------------------------------------------------------------------------------------------------
         ī�׽þ� ��(CARTESIAN PRODUCT)   |                  ���� ���� (CROSS JOIN) 
                       
                       
*/

-- ��ü ������� ���, �����, �μ��ڵ�(EMPLOYEE���̺�), �μ���(DEPARTMENT���̺�)�� ��ȸ�ϰ��� �� �� 
SELECT EMP_ID, EMP_NAME, DEPT_CODE 
FROM EMPLOYEE;

SELECT DEPT_ID,DEPT_TITLE
FROM DEPARTMENT;

-- ��ü ������� ���, �����, �����ڵ�, ���޸� ��ȸ�ϰ��� �� ��
SELECT EMP_ID, EMP_NAME, JOB_CODE
FROM EMPLOYEE;

SELECT JOB_CODE, JOB_NAME
FROM JOB;

/*
    1. � ����(EQUAL JOIN) / ���� ����(INNER JOIN) => JOIN USING/ON
       �����Ű�� �÷��� ���� ��ġ�ϴ� ��鸸 ���εǼ� ��ȸ ( => ��ġ�ϴ� ���� ���� ���� ��ȸ���� ����)
*/
-- >> ����Ŭ ���� ����
--    FROM���� ��ȸ�ϰ��� �ϴ� ���̺���� ���� (, �����ڷ�)
--    WHERE���� ��Ī��ų Į��(�����)�� ���� ������ ������

-- 1) ������ �� �÷����� �ٸ� ��� (EMPLOYEE : DEPT_CODE / DEPARTMENT : DEPT_ID)
--    ���, �����, �μ��ڵ�, �μ����� �ϳ��� ������� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;
--> ��ġ�ϴ� ���� ���� ���� ��ȸ���� ���ܵ� �� Ȯ�� ����!
-- EMPLYEE ���̺� DEPT_CODE�� NULL�� ����� ��ȸX, DEPARTMENT ���̺� DEPT_ID�� D3, D4, D7 ��ȸX

-- 2) ������ �� �÷����� ���� ��� (EMPLOYEE : JOB_CODE / JOB : JOB_CODE)
--    ���, �����, �����ڵ�, ���޸��� �ϳ��� ������� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE, JOB
WHERE JOB_CODE = JOB_CODE;
-- ambiguously : �ָ��ϴ�, ��ȣ�ϴ� => �÷����� �Ȱ��� ����

-- �ذ��� 1) ���̺���� �̿��ϴ� ���
SELECT EMP_ID, EMP_NAME, EMPLOYEE.JOB_CODE, JOB_NAME
FROM EMPLOYEE, JOB
WHERE EMPLOYEE.JOB_CODE = JOB.JOB_CODE;

-- �ذ��� 2) ���̺� ��Ī�� �ο��ؼ� �̿��ϴ� ���
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE;

-->> ANSI ����
--   FROM���� ������ �Ǵ� ���̺��� �ϳ� ��� �� �� 
--   JOIN���� ���� ��ȸ�ϰ����ϴ� ���̺� ��� + ��Ī��ų �÷��� ���� ���� ���
--   JOIN USING, JOIN ON

-- 1) ������ �� �÷����� �ٸ� ��� (EMPLOYEE : DEPT_CODE / DEPARTMENT : DEPT_ID)
--    ������ JOIN ON�������θ� �ۼ� ����!!
--    ���, �����, �μ��ڵ�, �μ����� �ϳ��� ������� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

-- 2) ������ �� �÷����� ���� ��� (EMPLOYEE : JOB_CODE / JOB : JOB_CODE)
--    JOIN ON, JOIN USING ���� ��� ����!
--    ���, �����, �����ڵ�, ���޸��� �ϳ��� ������� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
JOIN JOB ON (JOB_CODE = JOB_CODE);

-- �ذ���1) ���̺�� �Ǵ� ��Ī�� �̿��ؼ� �ϴ� ���
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E
/*INNER*/JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE);

-- �ذ���2) JOIN USING ���� ����ϴ� ��� (�� �÷����� ��ġ�Ҷ��� ��밡��)
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE 
/*INNER*/JOIN JOB USING (JOB_CODE);

---- [�������] ----
-- �ڿ�����(NATURAL JOIN) : �� ���̺��� ������ �÷��� �� ���� ������ ���
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
NATURAL JOIN JOB;

-- �߰����� ���ǵ� �翬�� ���� �����ϴ�.
-- ������ �븮�� ����� ���, �̸�, ���޸�, �޿� ��ȸ
-->> ����Ŭ ���� ����
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE AND JOB_NAME = '�븮';

--> ANSI ����
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '�븮';

------------------------------------�ǽ�����--------------------------------------
-- 1. �μ��� �λ�������� ������� ���, �̸�, ���ʽ� ��ȸ
-- EMPLOYEE : DEPT_CODE / DEPARTMENT : DEPT_ID
-->> ����Ŭ ���� ����
SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID 
  AND DEPT_TITLE = '�λ������'; --> SELECT���� DEPARTMENT���̺� ��ȸ�Ұ� ���� ���µ� JOIN�ؾ��ϴ� ����? WHERE���� �μ����� �λ�����θ� �����ؾ��ϱ� ������ 
                                                        --  ������ ����鸶�� � �μ����� ������ �ִ��� JOIN�ؼ� �˾Ƴ����Ѵ�!
-->> ANSI ����
SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE = '�λ������';

-- 2. DEPARTMENT���̺�� LOCATION���̺��� �����ؼ� ��ü �μ��� �μ��ڵ�, �μ���, �����ڵ�, ������ ��ȸ
-- DEPARTMENT : LOCATION_ID, LOCATION : LOCAL_CODE
--> ����Ŭ ���� ����
SELECT DEPT_ID, DEPT_TITLE, LOCAL_CODE, LOCAL_NAME
FROM DEPARTMENT, LOCATION
WHERE LOCATION_ID = LOCAL_CODE;
--> ANSI ����
SELECT DEPT_ID, DEPT_TITLE, LOCAL_CODE, LOCAL_NAME
FROM DEPARTMENT
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);

-- 3. ���ʽ��� �޴� ������� ���, �����, ���ʽ�, �μ��� ��ȸ
-- EMPLOYEE : DEPT_CODE , DEPARTMENT : DEPT_ID
--> ����Ŭ ���� ����
SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID 
  AND BONUS IS NOT NULL;
--> ANSI ����
SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE BONUS IS NOT NULL;

-- 4. �μ��� �ѹ��ΰ� �ƴ� ������� �����, �޿� ��ȸ
-- EMPLOYEE : DEPT_CODE , DEPARTMENT : DEPT_ID
--> ����Ŭ ���� ����
SELECT EMP_NAME, SALARY
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID
  AND DEPT_TITLE != '�ѹ���';
--> ANSI ����
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE NOT DEPT_TITLE = '�ѹ���';
---------------------------------------------------------------------------------------------

/*
    2. ���� ���� / �ܺ� ���� (OUTER JOIN)
    �� ���̺��� JOIN�� ��ġ���� �ʴ� �൵ ���Խ��Ѽ� ��ȸ ����
    ��, �ݵ�� LEFT/RIGHT�� �����ؾߵ�!! (������ �Ǵ� ���̺� ����)
*/

-- �ܺ����ΰ� ���ҹ��� INNER JOIN ��ȸ�صα�!
-- �����, �μ���, �޿�, ���� ��ȸ
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
-- �μ� ��ġ�� ���� �ȵ� ��� 2�� ���� ������ ��ȸX
-- �μ��� ������ ����� ���� �μ��� ��ȸ X

-- 1) LEFT [OUTER] JOIN : �� ���̺� �� ���� ����� ���̺��� �������� 
-->>  ANSI����
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
-- �μ� ��ġ�� ���� �ʾҴ� 2���� ��� ������ ��ȸ��

-->> ����Ŭ ���� ����
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+); -- �������� ������ϴ� ���̺��� �ݴ��� ���̺��� �÷� �ڿ� (+) ���̱�

-- 2) RIGHT [OUTER] JOIN : �� ���̺� �� ������ ����� ���̺��� �������� JOIN
-->> ANSI ����
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
RIGHT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

-->> ����Ŭ ���� ����
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID;

-- 3) FULL [OUTER] JOIN : �� ���̺��� ���� ��� ���� ��ȸ�� �� ���� (��, ����Ŭ���뱸�����δ� �Ұ�)
-->> ANSI����
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
FULL JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

------------------------------------------------------------------------------------------

/*
    3. �� ���� (NON EQUAL JOIN)
    ��Ī��ų �÷��� ���� ���� �ۼ� �� '='(��ȣ)�� ������� �ʴ� ���ι�
    ANSI�������δ� JOIN ON���θ� ��밡��!
*/
SELECT EMP_NAME, SALARY   -- SALARY
FROM EMPLOYEE;

SELECT SAL_LEVEL, MIN_SAL, MAX_SAL -- MIN_SAL, MAX_SAL
FROM SAL_GRADE;

-- �����, �޿�, �޿����� ��ȸ
-->> ����Ŭ ����
SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE, SAL_GRADE
--WHERE SALARY >= MIN_SAL AND SALARY <= MAX_SAL;
WHERE SALARY BETWEEN MIN_SAL AND MAX_SAL;

-->> ANSI����
SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE
JOIN SAL_GRADE ON (SALARY BETWEEN MIN_SAL AND MAX_SAL);

-----------------------------------------------------------------------------------------

/*
    4. ��ü ���� (SELF JOIN)
    ���� ���̺��� �ٽ� �ѹ� �����ϴ� ���
*/
SELECT * FROM EMPLOYEE;

-- ��ü ����� ������, �����, ����μ��ڵ�   => EMPLOYEE E
--            ������, �����, ����μ��ڵ�  => EMPLOYEE M
--> ����Ŭ ���� ����
SELECT E.EMP_ID "������", E.EMP_NAME "�����", E.DEPT_CODE "����μ��ڵ�",
       M.EMP_ID "������", M.EMP_NAME "�����", M.DEPT_CODE "����μ��ڵ�"
FROM EMPLOYEE E, EMPLOYEE M
WHERE E.MANAGER_ID = M.EMP_ID;

-->> ANSI����
SELECT E.EMP_ID "������", E.EMP_NAME "�����", E.DEPT_CODE "����μ��ڵ�",
       M.EMP_ID "������", M.EMP_NAME "�����", M.DEPT_CODE "����μ��ڵ�"
FROM EMPLOYEE E
JOIN EMPLOYEE M ON (E.MANAGER_ID = M.EMP_ID);

--------------------------------------------------------------------------------------
/*
    < ���� JOIN >
    2�� �̻��� ���̺��� ������ JOIN�� �� 
*/

-- ���, �����, �μ���, ���޸� ��ȸ
SELECT * FROM EMPLOYEE;   -- DEPT_CODE   JOB_CODE
SELECT * FROM DEPARTMENT; -- DEPT_ID
SELECT * FROM JOB;        --             JOB_CODE

--> ����Ŭ ���� ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E, DEPARTMENT, JOB J
WHERE DEPT_CODE = DEPT_ID 
  AND E.JOB_CODE = J.JOB_CODE;

--> ANSI ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE); -- ��Ī��ų �÷����� �����ϱ� ������ JOB USING ��� ����


-- ���, �����, �μ���, ������ ��ȸ
SELECT * FROM EMPLOYEE;           -- DEPT_CODE
SELECT * FROM DEPARTMENT;         -- DEPT_ID        LOCATION_ID
SELECT * FROM LOCATION;           --                LOCAL_CODE

--> ����Ŭ ���� ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE, DEPARTMENT, LOCATION
WHERE DEPT_CODE = DEPT_ID AND LOCATION_ID = LOCAL_CODE;

--> ANSI ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);
-- ANSI���������� ���� ���� ���� �߿�!

-------------------------------------------�ǽ�����------------------------------------------
-- 1. ���, �����, �μ���, ������, ������ ��ȸ (EMPLOYEE, DEPARTMENT, LOCATION, NATIONAL ����)
-- EMPLOYEE    : DEPT_CODE
-- DEPARTMENT  : DEPT_ID      LOCATION_ID
-- LOCATION    :              LOCAL_CODE     NATIONAL_CODE
-- NATIONAL    :                             NATIONAL_CODE

-->> ����Ŭ ���� ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE E, DEPARTMENT D, LOCATION L, NATIONAL N
WHERE E.DEPT_CODE = D.DEPT_ID 
  AND D.LOCATION_ID = L.LOCAL_CODE
  AND L.NATIONAL_CODE = N.NATIONAL_CODE;

-->> ANSI ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE);

-- 2. ���, �����, �μ���, ���޸�, ������, ������, �޿���� ��ȸ (��� ���̺� �� ����)
-- EMPLOYEE    :  DEPT_CODE     JOB_CODE                                       SALARY
-- DEPARTMENT  :  DEPT_ ID                    LOCATION_ID
-- JOB         :                JOB_CODE
-- LOCATION    :                             LOCAL_CODE     NATIONAL_CODE
-- NATIONAL    :                                            NATIONAL_CODE
-- SAL_GRADE   :                                                               SAL_LEVEL
-->> ����Ŭ ���� ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, LOCAL_NAME, NATIONAL_NAME, SAL_LEVEL
FROM EMPLOYEE E, DEPARTMENT D, JOB J, LOCATION L, NATIONAL N, SAL_GRADE S
WHERE E.DEPT_CODE = D.DEPT_ID
  AND E.JOB_CODE = J.JOB_CODE
  AND D.LOCATION_ID = L.LOCAL_CODE
  AND L.NATIONAL_CODE = N.NATIONAL_CODE
  AND E.SALARY BETWEEN S.MIN_SAL AND S.MAX_SAL;


-->>  ANSI ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, LOCAL_NAME, NATIONAL_NAME, SAL_LEVEL
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (DEPT_CODE = DEPT_ID)
JOIN JOB J USING (JOB_CODE)
JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
JOIN NATIONAL N USING (NATIONAL_CODE)
JOIN SAL_GRADE S ON (E.SALARY BETWEEN S.MIN_SAL AND S.MAX_SAL);