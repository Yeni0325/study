/*
    < VIEW �� >
    
    SELECT��(������)�� �����ص� �� �ִ� ��ü
    (���� ���� �� SELECT���� �����صθ� �� �� SELECT���� �Ź� �ٽ� ����� �ʿ䰡 ����)
    �ӽ����̺� ���� ���� (���� �����Ͱ� ����ִ°� �ƴ�!! => ������ ���̺�)

*/

-- '�ѱ�'���� �ٹ��ϴ� ������� ���, �̸�, �μ���, �޿�, �ٹ������� ��ȸ
-- ����Ŭ ���� ����
SELECT EMP_ID "���", EMP_NAME "�̸�", DEPT_TITLE "�μ���", SALARY "�޿�", NATIONAL_NAME "�ٹ�������"
  FROM EMPLOYEE E, DEPARTMENT D, LOCATION L, NATIONAL N
 WHERE E.DEPT_CODE = D.DEPT_ID
   AND D.LOCATION_ID = L.LOCAL_CODE
   AND L.NATIONAL_CODE = N.NATIONAL_CODE
   AND NATIONAL_NAME = '�ѱ�';
  
-- ANSI ���� ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
  FROM EMPLOYEE E
  JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
  JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
  JOIN NATIONAL USING(NATIONAL_CODE)
 WHERE NATIONAL_NAME = '�ѱ�';
 
-- '���þ�'���� �ٹ��ϴ� ������� ���, �̸�, �μ���, �޿�, �ٹ������� ��ȸ
SELECT EMP_ID "���", EMP_NAME "�̸�", DEPT_TITLE "�μ���", SALARY "�޿�", NATIONAL_NAME "�ٹ�������"
  FROM EMPLOYEE E
  JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
  JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
  JOIN NATIONAL USING(NATIONAL_CODE)
 WHERE NATIONAL_NAME = '���þ�';
 
-- '�Ϻ�'���� �ٹ��ϴ� ������� ���, �̸�, �μ���, �޿�, �ٹ������� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
  FROM EMPLOYEE E
  JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
  JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
  JOIN NATIONAL USING(NATIONAL_CODE)
 WHERE NATIONAL_NAME = '�Ϻ�';
 
------------------------------------------------------------------------------------------

/*
    1. VIEW ���� ���
    
    [ǥ����]
    CREATE [OR REPLACE] VIEW ���
    AS ��������;
    
    [OR REPLACE] : �� ���� �� ������ �ߺ��� �̸��� �䰡 ���ٸ� ������ �並 �����ϰ�,
                             ������ �ߺ��� �̸��� �䰡 �ִٸ� �ش� �並 ����(����)�ϴ� �ɼ�
*/

CREATE VIEW VW_EMPLOYEE -- ����� ���� �տ� VW_�� ����
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
     FROM EMPLOYEE E
     JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
     JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
     JOIN NATIONAL USING(NATIONAL_CODE);
     -- VIEW ��ü�� ������ �� �ִ� ������ ������ �����߻�
     -- "insufficient privileges" ������ ������մϴ�. 
     
GRANT CREATE VIEW TO KH;  --> ���Ѻο����̱� ������ �����ڰ������� �����ؾ���!

SELECT *
FROM VW_EMPLOYEE;
-- �Ʒ��� ���� �ƶ�
SELECT *
FROM (SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
        FROM EMPLOYEE E
        JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
        JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
        JOIN NATIONAL USING(NATIONAL_CODE));

-- ��� ������ ���� ���̺�! (���������� �����͸� �����ϰ� ���� ����!!)

-- '�ѱ�', '���þ�', '�Ϻ�'�� �ٹ��ϴ� ���
SELECT * 
  FROM VW_EMPLOYEE
 WHERE NATIONAL_NAME = '�ѱ�';

SELECT * 
  FROM VW_EMPLOYEE
 WHERE NATIONAL_NAME = '���þ�';
  
SELECT * 
  FROM VW_EMPLOYEE
 WHERE NATIONAL_NAME = '�Ϻ�';
 
-- [����]
SELECT * FROM USER_VIEWS; -- �ش� ������ ������ �ִ� VIEW�� ����;

-- BONUS�� �߰��ؼ� �ٽ� VIEW ���� (CREATE OR REPLACE VIEW)
CREATE OR REPLACE VIEW VW_EMPLOYEE -- ����� ���� �տ� VW_�� ����
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME, BONUS
     FROM EMPLOYEE E
     JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
     JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
     JOIN NATIONAL USING(NATIONAL_CODE);

----------------------------------------------------------------------------------------

/*
    * �� �÷��� ��Ī �ο�
      ���������� SELET���� �Լ����̳� ���������� ����Ǿ����� ��� �ݵ�� ��Ī �����ؾߵ�!!
*/

-- �� ����� ���, �̸�, ���޸�, ����(��/��), �ٹ������ ��ȸ�� �� �ִ� SELECT���� ��(VW_EMP_JOB)�� ����
CREATE OR REPLACE VIEW VW_EMP_JOB
AS SELECT EMP_ID, EMP_NAME, JOB_NAME, 
          DECODE(SUBSTR(EMP_NO, 8, 1), '1', '��', '2', '��') "����",
          EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) "�ٹ����"
     FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE);
-- �����߻� : must name this expression with a column alias : alias(��Ī)
          
-- �Ʒ��� ���� ������ε� ��Ī �ο�����
CREATE OR REPLACE VIEW VW_EMP_JOB(���, �̸�, ���޸�, ����, �ٹ����)
AS SELECT EMP_ID, EMP_NAME, JOB_NAME, 
          DECODE(SUBSTR(EMP_NO, 8, 1), '1', '��', '2', '��'),
          EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
     FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE);
     
SELECT * FROM VW_EMP_JOB;

SELECT �̸�, ���޸�
  FROM VW_EMP_JOB
 WHERE ���� = '��';
 
SELECT * 
  FROM VW_EMP_JOB
 WHERE �ٹ���� >= 20;
 
-- �� �����ϰ��� �Ѵٸ�
DROP VIEW VW_EMP_JOB;

------------------------------------------------------------------------------------------

-- ������ �並 �̿��ؼ� DML(INSERT, UPDATE, DELETE) ��밡��
-- �並 ���ؼ� �����ϰ� �Ǹ� ���� �����Ͱ� ����ִ� ���̽����̺� �ݿ���

CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_CODE, JOB_NAME
     FROM JOB;
     
SELECT * FROM VW_JOB; -- ������ ���̺� (���������Ͱ� ������� ����)
SELECT * FROM JOB;    -- ���������Ͱ� ��� ���̺��� JOB���̺�(���̽� ���̺�)

-- �並 ���ؼ� INSERT 
INSERT INTO VW_JOB VALUES('J8', '����');

-- �並 ���ؼ� UPDATE
UPDATE VW_JOB
   SET JOB_NAME = '�˹�'
 WHERE JOB_CODE = 'J8';
 
-- �並 ���ؼ� DELETE
DELETE
  FROM VW_JOB
 WHERE JOB_CODE = 'J8';

-- �並 ���ؼ� DML�ϰ� �Ǹ� ���� ���̽����̺� �� �ݿ��� �ȴ�.

-----------------------------------------------------------------------------------------

/*
    * ��, DML ��ɾ�� ������ �Ұ����� ��찡 �� ����!!
    1) �信 ���ǵǾ����� ���� �÷��� �����Ϸ��� �ϴ� ���
    2) �信 ���ǵǾ����� ���� �÷� �߿� ���̽����̺� �� NOT NULL ���������� �����Ǿ��ִ� ���
    3) �������� �Ǵ� �Լ������� ���ǵǾ��ִ� ���
    4) �׷��Լ��� GROUP BY ���� ���Ե� ���
    5) DISTINCT ������ ���Ե� ���
    6) JOIN�� �̿��ؼ� ���� ���̺��� ������ѳ��� ���
    
*/

-- 1) �信 ���ǵǾ����� ���� �÷��� �����Ϸ��� �ϴ� ���
CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_CODE
     FROM JOB;

SELECT * FROM VW_JOB;  -- ������ ���̺�
SELECT * FROM JOB;     -- ���̽����̺�

-- INSERT (����)
INSERT INTO VW_JOB(JOB_CODE, JOB_NAME) VALUES('J8', '����');
-- �����߻� "JOB_NAME": invalid identifier --> "JOB_NAME" ���̺��� �ĺ��� �� ���ٴ� �����߻�

-- UPDATE (����)
UPDATE VW_JOB
   SET JOB_NAME = '����'
 WHERE JOB_CODE = 'J7';
-- �����߻� "JOB_NAME": invalid identifier --> "JOB_NAME" ���̺��� �ĺ��� �� ���ٴ� �����߻� 

-- DELETE (����)
DELETE
  FROM VW_JOB
 WHERE JOB_NAME = '���';
-- �����߻� "JOB_NAME": invalid identifier --> "JOB_NAME" ���̺��� �ĺ��� �� ���ٴ� �����߻�

-- 2) �信 ���ǵǾ����� ���� �÷� �߿� ���̽����̺� �� NOT NULL ���������� �����Ǿ��ִ� ���
CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_NAME
     FROM JOB;

SELECT * FROM VW_JOB;  -- ������ ���̺�
SELECT * FROM JOB;     -- ���̽����̺�

-- INSERT (����)
INSERT INTO VW_JOB VALUES('����'); -- ���� �������̺� INSERT�� (NULL, '����') �߰� 
-- cannot insert NULL into ("KH"."JOB"."JOB_CODE")
-- VW_JOB�� ���ǵǾ����� ���� JOB���̺��� JOB_CODE�÷��� NOT NULL���������� �ɷ��ֱ� ������ �����߻�

-- UPDATE (����)
UPDATE VW_JOB
   SET JOB_NAME = '�˹�'
 WHERE JOB_NAME = '���';
 
ROLLBACK;

-- DELETE
DELETE 
  FROM VW_JOB
 WHERE JOB_NAME = '���';
-- �����߻� : integrity constraint (KH.SYS_C007154) violated - child record found
-- �ش� �����͸� ����ϰ� �ִ� �ڽĵ����Ͱ� �����ϱ� ������ �������� / ��, ���ٸ� ���� �ߵ�

-- 3) �������� �Ǵ� �Լ������� ���ǵǾ��ִ� ���
CREATE OR REPLACE VIEW VW_EMP_SAL
AS SELECT EMP_ID, EMP_NAME, SALARY, SALARY * 12 ����
     FROM EMPLOYEE;
     
SELECT * FROM VW_EMP_SAL; -- ������ ���̺�
SELECT * FROM EMPLOYEE;   -- ���̽� ���̺�

-- INSERT (����)
INSERT INTO VW_EMP_SAL VALUES(400, '������', 3000000, 36000000);
-- �����߻� : virtual column not allowed here
-- ���, �����, �޿��� ���̽����̺��� EMPLOYEE ���̺� �����ϴ� �÷�������, SALARY * 12�� ���� ���̺��� EMPLOYEE ���̺� �������� �ʱ� ������ ������ �߻��Ѵ�.

-- UPDATE 
-- 200�� ����� ������ 8000�������� ���� (����)
UPDATE VW_EMP_SAL
   SET ���� = 80000000
 WHERE EMP_ID = 200;
-- �����߻� : virtual column not allowed here
-- ���, �����, �޿��� ���̽����̺��� EMPLOYEE ���̺� �����ϴ� �÷�������, SALARY * 12�� ���� ���̺��� EMPLOYEE ���̺� �������� �ʱ� ������ ������ �߻��Ѵ�.

-- 200�� ����� �޿��� 700�������� ���� (����)
UPDATE VW_EMP_SAL
   SET SALARY = 7000000
 WHERE EMP_ID = 200;

ROLLBACK; 
-- DELETE (����)
DELETE FROM VW_EMP_SAL
WHERE ���� = 72000000;

-- 4) �׷��Լ� �Ǵ� GROUP BY ���� �����ϴ� ���
CREATE OR REPLACE VIEW VW_GROUPDEPT
AS SELECT DEPT_CODE, SUM(SALARY) "�հ�", FLOOR(AVG(SALARY)) "���"
     FROM EMPLOYEE
 GROUP BY DEPT_CODE;

SELECT * FROM VW_GROUPDEPT; -- ������ ���̺�
SELECT * FROM EMPLOYEE;     -- ���̽� ���̺�

-- INSERT (����)
INSERT INTO VW_GROUPDEPT VALUES('D3', 8000000, 4000000);
-- �����߻� : virtual column not allowed here
-- �հ�, ����� EMPLOYEE���̺� �������� �ʱ� ������ �����߻�

-- UPDATE (����)
UPDATE VW_GROUPDEPT
  SET �հ� = 8000000
 WHERE DEPT_CODE = 'D1';
-- �����߻� : data manipulation operation not legal on this view
-- �հ� �÷��� ���ؼ��� ���� ������ ���� ��ģ���̴ٺ��� �ش絥������ ���� ������ �� ����. 

-- DELETE (����)
DELETE FROM VW_GROUPDEPT
WHERE �հ� = 5210000;
-- �����߻� : data manipulation operation not legal on this view
-- �̹� �׷��� ������ �����̱� ������ ���ۺҰ�

-- 5) DISTINCT ������ ���Ե� ���
CREATE OR REPLACE VIEW VW_DT_JOB
AS SELECT DISTINCT JOB_CODE
     FROM EMPLOYEE;
     
SELECT * FROM VW_DT_JOB; -- ������ ���̺�
SELECT * FROM EMPLOYEE;  -- ���̽����̺�

-- INSERT (����) 
INSERT INTO VW_DT_JOB VALUES('J8');
-- �����߻� : data manipulation operation not legal on this view
-- JOB_CODE �÷��� �ߺ����Ÿ� �� ����̱� ������ �Ұ�

-- UPDATE (����)
UPDATE VW_DT_JOB 
   SET JOB_CODE = 'J8'
 WHERE JOB_CODE = 'J7';
-- �����߻� : data manipulation operation not legal on this view

-- DELETE (����)
DELETE
  FROM VW_DT_JOB
 WHERE JOB_CODE = 'J4';
-- �����߻� : data manipulation operation not legal on this view

-- 6) JOIN�� �̿��ؼ� ���� ���̺��� ������ѳ��� ���
CREATE OR REPLACE VIEW VW_JOINEMP
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE
     FROM EMPLOYEE
     JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);
    
SELECT * FROM VW_JOINEMP; -- ������ ���̺�

-- INSERT (����)
INSERT INTO VW_JOINEMP VALUES(300, '������', '�ѹ���');
-- �����߻� : "cannot modify more than one base table through a join view"
-- DEPT_TITLE�� EMPLOYEE���̺� �������� �ʱ� ������ �����߻�

-- UPDATE 
UPDATE VW_JOINEMP
   SET EMP_NAME = '������'
 WHERE EMP_ID = '200';
 
UPDATE VW_JOINEMP
   SET DEPT_TITLE = 'ȸ���'
 WHERE EMP_ID = 200;
 -- �����߻� : cannot modify a column which maps to a non key-preserved table
 
-- DELETE (����)
DELETE FROM VW_JOINEMP
WHERE EMP_ID = 200;
 
SELECT * FROM EMPLOYEE;

ROLLBACK;

---------------------------------------------------------------------------------------

/*
    * VIEW �ɼ�
    
    [��ǥ����]
    CREATE [OR REPLACE] [FORCE|"NOFORCE"] VIEW ���
    AS ��������
    [WITH CHECK OPTION]
    [WITH READ ONLY];
    
    1) OR REPLACE : ������ ������ �䰡 ���� ��� ���Ž�Ű��, �������� ������ ���� �����ϴ� �ɼ�
    2) FORCE | NOFORCE 
        > FORCE   : ���������� ����� ���̺��� �������� �ʾƵ� �䰡 �����ǰ� �ϴ� �ɼ�
        > NOFORCE : ���������� ����� ���̺��� �����ϴ� ���̺��̿��߸� �䰡 �����ǰ� �ϴ� �ɼ�
    3) WITH CHECK OPTION : DML �� ���������� ����� ���ǿ� ������ �����θ� DML �����ϵ��� �ϴ� �ɼ�
    4) WITH READ ONLY : �信 ���� ��ȸ�� ���� (DML�� ����Ұ�)
*/


-- 2) FORCE | NOFORCE
--    NOFORCE : ���������� ����� ���̺��� �����ϴ� ���̺��̿��߸� �䰡 �����ǰ� �ϴ� �ɼ�
CREATE OR REPLACE /*NOFORCE*/VIEW VW_EMP
AS SELECT TCODE, TNAME, TCONTENT
     FROM TT;
-- �����߻� : table or view does not exist

--  FORCE : ���������� ����� ���̺��� �������� �ʾƵ� �䰡 �����ǰ� �ϴ� �ɼ�
CREATE OR REPLACE FORCE VIEW VW_EMP
AS SELECT TCODE, TNAME, TCONTENT
     FROM TT;
     
SELECT * FROM VW_EMP;

-- TT���̺��� �����ؾ߸� �׶����� VIEW Ȱ�� ����
CREATE TABLE TT(
    TCODE NUMBER,
    TNAME VARCHAR2(20),
    TCON
);

-- 3)  WITH CHECK OPTION : DML �� ���������� ����� ���ǿ� ������ �����θ� DML �����ϵ��� �ϴ� �ɼ�
--                         ���������� ����� ���ǿ� �������� �ʴ� ������ ���� �� ���� �߻�

-- WITH CHECK OPTION �Ⱦ���
CREATE OR REPLACE VIEW VW_EMP
AS SELECT *
     FROM EMPLOYEE
    WHERE SALARY >= 3000000;
    
SELECT * FROM VW_EMP; -- 9�� ��ȸ

-- 200�� ����� �޿��� 200�������� ���� (���������� ���ǿ� ���յ��� �ʴ� ������ ����õ�) => �� ����ȴ�.
UPDATE VW_EMP
   SET SALARY = 2000000
 WHERE EMP_ID = 200;
 
SELECT * FROM EMPLOYEE;

ROLLBACK;

-- WITH CHECK OPTION ����
CREATE OR REPLACE VIEW VW_EMP
AS SELECT *
     FROM EMPLOYEE
    WHERE SALARY >= 3000000
WITH CHECK OPTION;

SELECT * FROM VW_EMP; -- 9�� ��ȸ

-- 200�� ����� �޿��� 200�������� ����
UPDATE VW_EMP
   SET SALARY = 2000000
 WHERE EMP_ID = 200;
-- �����߻� : view WITH CHECK OPTION where-clause violation
-- �並 ������ �� �ش� ��� 300���� �̻��� �޿��� ������ �����Ǿ� �ֱ� ������ ���� �߻�
-- ���������� ����� ���ǿ� ���յ��� �ʱ� ������ ���� �Ұ�

-- 200�� ����� �޿��� 400�������� ����
UPDATE VW_EMP
   SET SALARY = 4000000
 WHERE EMP_ID = 200;
-- ���������� ����� ���ǿ� �����ϱ� ������ �������� �����ȴ�.

SELECT * FROM EMPLOYEE;

ROLLBACK;

-- 4) WITH READ ONLY : �信 ���� ��ȸ�� ���� (DML�� ����Ұ�)
CREATE OR REPLACE VIEW VW_EMP
AS SELECT EMP_ID, EMP_NAME, BONUS
     FROM EMPLOYEE
    WHERE BONUS IS NOT NULL;
    
SELECT * FROM VW_EMP;

-- ����� 200���� ��� ������ ����
DELETE FROM VW_EMP
WHERE EMP_ID = 200;
-- �����߻� : cannot perform a DML operation on a read-only view
-- �ش��� ��ȸ�� �����ϰ� ��������� ������ DML������ �Ұ����ϴٴ� ���� �߻�