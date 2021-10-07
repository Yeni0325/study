/*

    < PL/SQL >
    PROCEDURE LANGUAGE EXTENSION TO SQL
    
    ����Ŭ ��ü�� ����Ǿ� �ִ� ������ ���
    SQL���� ������ ������ ����, ����ó��(IF), �ݺ�ó��(LOOP, FOR, WHILE) ���� �����Ͽ� SQL�� ������ ����
    �ټ��� SQL���� �ѹ��� ���� ���� (BLOCK ����)
    
    * PL/SQL ����
    - [����� (DECLARE SECTION)]      : DECLARE Ű����� ����, ������ ����� ���� �� �ʱ�ȭ�ϴ� �κ� 
    - ����� (EXECUTABLE SECTION)     : BEGIN Ű����� ����, SQL�� �Ǵ� ���(���ǹ�, �ݺ���)���� ������ ����ϴ� �κ�
    - [����ó���� (EXCEPTION SECTION)] : EXCEPTION Ű����� ����, ���ܹ߻� �� �ذ��ϱ� ���� ������ �̸� ����ص� �� �ִ� �κ�

*/

-- * �����ϰ� ȭ�鿡 HELLO ORACLE ���
SET SERVEROUTPUT ON;

BEGIN 
    -- System.out.println("HELLO ORACLE"); -- �ڹ�  
    DBMS_OUTPUT.PUT_LINE('HELLO ORACLE'); 
END;
/
------------------------------------------------------------------------------------------

/*
    1. DECLARE �����
       ���� �� ��� ���� �ϴ� ���� (����� ���ÿ� �ʱ�ȭ�� ����)
       �Ϲ�Ÿ�Ժ���, ���۷���Ÿ�Ժ���, ROWŸ�Ժ���
       
       1_1) �Ϲ�Ÿ�� ���� ���� �� �ʱ�ȭ
            [ǥ����] DECLARE ������ �ڷ��� [CONSTANT][:= ��];   --> SQL���� ���Կ����ڴ� ':='
                                                              --> CONSTANT ���               
*/

DECLARE                           
    EID NUMBER;
    ENAME VARCHAR2(20);
    PI CONSTANT NUMBER := 3.14;
BEGIN                             
    --EID := 800;
    --ENAME := '���峲';
    
    EID := &��ȣ;
    ENAME := '&�̸�';
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);   
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('PI : ' || PI);
END;
/

---------------------------------------------------------------------------------------

-- 1_2) ���۷��� Ÿ�� ���� ���� �� �ʱ�ȭ (� ���̺��� � �÷��� ������Ÿ���� �����ؼ� �� Ÿ������ ����)
--      [ǥ����] DECLARE ������ ���̺��.�÷���%TYPE;
DECLARE 
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
BEGIN
    --EID := '300';
    --ENAME := '�����';
    --SAL := 3000000;
    
    -- ����� 200���� ����� ���, �����, �޿� ��ȸ�ؼ� �� ������ ����
    SELECT EMP_ID, EMP_NAME, SALARY
      INTO EID, ENAME, SAL
      FROM EMPLOYEE
     --WHERE EMP_ID = 200;
     WHERE EMP_ID = &���;

    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('SAL : ' || SAL);
END;
/

--------------------------------------- �ǽ����� 1 -------------------------------------
/*
    ���۷���Ÿ�Ժ����� EID, ENAME, JCODE, SAL, DTITLE�� �����ϰ�
    �� �ڷ����� EMPLOYEE(EMP_ID, EMP_NAME, JOB_CODE, SALARY), DEPARTMENT(DEPT_TITLE) ���� �����ϵ���
    
    ����ڰ� �Է��� ����� ����� ���, �����, �����ڵ�, �޿�, �μ��� ��ȸ�� �� �� ������ ��Ƽ� ��� ���
*/
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    JCODE EMPLOYEE.JOB_CODE%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY, DEPT_TITLE
      INTO EID, ENAME, JCODE, SAL, DTITLE
      FROM EMPLOYEE E, DEPARTMENT D
     WHERE E.DEPT_CODE = D.DEPT_ID
       AND EMP_ID = &���;
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('JCODE : ' || JCODE);
    DBMS_OUTPUT.PUT_LINE('SAL : ' || SAL);
    DBMS_OUTPUT.PUT_LINE('DTITLE : '|| DTITLE);
    
    DBMS_OUTPUT.PUT_LINE(EID || ', ' || ENAME || ', ' || JCODE || ', '|| SAL || ', ' || DTITLE );
    
END;
/

-----------------------------------------------------------------------------------------

-- 1_3) ROWŸ�� ���� ���� (ROW : �� ��)
--      ���̺��� �� �࿡ ���� ��� �÷����� �Ѳ����� ���� �� �ִ� ����
--      [ǥ����] DECLARE ������ ���̺��%ROWTYPE;

DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    SELECT *                    -- ROWŸ�� ���� ���� �� ������ '*'�� �ؾ��Ѵ�.
      INTO E
      FROM EMPLOYEE
     WHERE EMP_ID = &���;
     
     DBMS_OUTPUT.PUT_LINE('����� : ' || E.EMP_NAME);
     DBMS_OUTPUT.PUT_LINE('�޿� : ' || E.SALARY);
     DBMS_OUTPUT.PUT_LINE('���ʽ� : ' || NVL(E.BONUS,0));
     -- ��¹� ������ �Լ�Ȱ�� ����
END;
/

----------------------------------------------------------------------------------------

-- 2. BEGIN �����

-- < ���ǹ� >

-- 1) [ǥ����] IF ���ǽ� THEN TRUE�϶����೻�� END IF; (�ڹٿ����� ���� IF��)(IF�� �����ϸ� END IF�� ������)

-- ��� �Է¹��� �� �ش� ����� ���, �̸�, �޿�, ���ʽ���(%) ���
-- ��, ���ʽ��� ���� �ʴ� ����� ���ʽ��� ��� �� '���ʽ��� ���޹��� �ʴ� ����Դϴ�' ���

DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS, 0)
    INTO EID, ENAME, SALARY, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = &���;
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || SALARY );
    
    IF BONUS = 0 
        THEN DBMS_OUTPUT.PUT_LINE('���ʽ��� ���޹��� �ʴ� ����Դϴ�.');
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('���ʽ��� : ' || BONUS * 100 || '%');
    
END;
/

-- 2) [ǥ����] IF ���ǽ� THEN TRUE�϶����೻�� ELSE FALSE�϶����೻�� END IF; (�ڹٿ����� IF - ELSE��)
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS, 0)
      INTO EID, ENAME, SALARY, BONUS
      FROM EMPLOYEE
     WHERE EMP_ID = &���;
     
     DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
     DBMS_OUTPUT.PUT_LINE('�̸� : ' || ENAME);
     DBMS_OUTPUT.PUT_LINE('�޿� : ' || SALARY || '��');
     
     IF BONUS = 0
        THEN DBMS_OUTPUT.PUT_LINE('���ʽ��� ���޹��� �ʴ� ����Դϴ�.');
     ELSE
        DBMS_OUTPUT.PUT_LINE('���ʽ��� : ' || BONUS * 100 || '%');
     END IF;    
END;
/

------------------------------------------ �ǽ����� -----------------------------------------
DECLARE
    -- ���۷���Ÿ�Ժ��� (EID, ENAME, DTITLE, NCODE)
    -- �������÷� (EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE)
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
    NCODE LOCATION.NATIONAL_CODE%TYPE;
    
    -- �Ϲ�Ÿ�Ժ��� (TEAM ���ڿ�)  <= �̵��� ��ȸ�� ����� '������' �Ǵ� '�ؿ���'���� ���� ����
    TEAM VARCHAR2(20);
BEGIN
    -- ����ڰ� �Է��� ����� ����� ���, �̸�, �μ���, �ٹ������ڵ� ��ȸ �� �� ������ ����
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE
    INTO EID, ENAME, DTITLE, NCODE
    FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
    WHERE EMP_ID = &���;
    
    -- NCODE ���� KO�� ��� => TEAM�� '������' ����
    -- �װ� �ƴ� ���       => TEAM�� '�ؿ���' ����
    IF NCODE = 'KO'
        THEN TEAM := '������';
    ELSE
        TEAM := '�ؿ���';
    END IF;
    -- ���������� ���, �̸�, �μ���, �Ҽӿ� ���� ���
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('DTITLE : ' || DTITLE);
    DBMS_OUTPUT.PUT_LINE('TEAM : ' || TEAM);
END;
/

-- 3) [ǥ����] IF ���ǽ�1 THEN ���೻��1 ELSIF ���ǽ�2 THEN ���೻��2 ... [ELSE ���೻��N] END IF; (�ڹٿ����� IF - ELSE IF - ELSE��)

DECLARE
    SCORE NUMBER;
    GRADE VARCHAR2(1);
BEGIN
    SCORE := &����;
    
    IF SCORE >= 90 THEN GRADE := 'A';
    ELSIF SCORE >= 80 THEN GRADE := 'B';
    ELSIF SCORE >= 70 THEN GRADE := 'C';
    ELSIF SCORE >= 60 THEN GRADE := 'D';
    ELSE GRADE := 'F';
    END IF;
    
    -- ����� ������ XX���̰�, ������ X�����Դϴ�.
    DBMS_OUTPUT.PUT_LINE('����� ������ ' || SCORE || '���̰�, ������ ' || GRADE || '�����Դϴ�.');
    
END;
/

-------------------------------------- �ǽ����� ------------------------------------------

-- ����ڿ��� �Է¹��� ����� ����� �޿��� ��ȸ�ؼ� SAL ������ ����
-- SAL�� ����ִ� ���� 500���� �̻��̸� '���'
--                   300���� �̻��̸� '�߱�'
--                   300���� �̸��̸� '�ʱ�'
--'�ش� ����� �޿������ XX�Դϴ�.' ��� ��µǵ���

DECLARE
    SAL EMPLOYEE.SALARY%TYPE;
    GRADE VARCHAR2(10);
BEGIN
    SELECT SALARY
      INTO SAL
      FROM EMPLOYEE
     WHERE EMP_ID = &���;
    
    IF SAL >= 5000000 THEN GRADE := '���';
    ELSIF SAL >= 3000000 THEN GRADE := '�߱�';
    ELSE GRADE := '�ʱ�';
    END IF;

    DBMS_OUTPUT.PUT_LINE('�ش� ����� �޿������ ' || GRADE || '�Դϴ�.');
END;
/

--------------------------------------------------------------------------------------------

-- 4) [ǥ����] CASE �񱳴���� WHEN ������Ұ�1 THEN �����1 WHEN �񱳰�2 WHEN �����2 ... ELSE ����� END; (�ڹٿ����� SWITCH��)

DECLARE
    EMP EMPLOYEE%ROWTYPE;
    DNAME VARCHAR2(30);
BEGIN
    SELECT *
      INTO EMP
      FROM EMPLOYEE
     WHERE EMP_ID = &���;
     
     DNAME := CASE EMP.DEPT_CODE
                WHEN 'D1' THEN '�λ���'
                WHEN 'D2' THEN 'ȸ����'
                WHEN 'D3' THEN '��������'
                WHEN 'D4' THEN '����������'
                WHEN 'D9' THEN '�ѹ���'
                ELSE '�ؿܿ�����'
              END;
              
    DBMS_OUTPUT.PUT_LINE(EMP.EMP_NAME || '�� ' || DNAME || '�Դϴ�.');
END;
/

------------------------------------------------------------------------------------------

-- < �ݺ��� >

/*
    1) BAISC LOOP ��
    
    [ǥ����]
    LOOP 
        �ݺ������� ������ ����;                => (�⺻������ ���ѹݺ�, �ڹٿ����� WHILE��)
        * �ݺ����� �������� �� �ִ� ����`
    END LOOP;
    
    * �ݺ����� �������� �� �ִ� ���� (2����)
    1) IF ���ǽ� THEN EXIT; END IF;    => �ش� ���ǽ��� ���ϰ�� EXIT�� ���� ���������ڴ�.
    2) EXIT WHEN ���ǽ�;               => EXIT ���������ڴ�. WHEN? �ش� ���ǽ��� ���ϰ�� 
    
*/

-- 1~5���� ���������� 1�� �����ϴ� ���� ���
SET SERVEROUTPUT ON;
DECLARE
    I NUMBER := 1;     --> ���԰� ���ÿ� �ʱ�ȭ
BEGIN
    
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
        I := I + 1;                   --> �ڹٿ����� I++��� ���������ڰ� ���������� SQL������ �̿Ͱ��� ǥ���ؾ���
        
        -- IF I = 6 THEN EXIT; END IF;
        EXIT WHEN I = 6;
    END LOOP;
    
END;
/

-----------------------------------------------------------------------------------------

/*
    2) FOR LOOP ��
    
    [ǥ����]
    FOR ���� IN [REVERSE] �ʱⰪ..������         => �ʱⰪ���� ���������� �Ź� 1�� �����ϸ鼭 �˾Ƽ� �ݺ��� �ȴ�. 
    LOOP                                       =>  REVERSE �� ���̸� ���������� �ʱⰪ���� 1�� ���ҵȴ�. 
        �ݺ������� ������ ����;                   => (�ڹٿ����� FOR��)
    END LOOP;
*/
-- FOR LOOP���� ��� FOR LOOP�� �ȿ��� ������ �����ϴ� ������ �����ϹǷ� DECLEAR ����� ������ �����ϴ�.
BEGIN
    FOR I IN 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
    END LOOP;
END;
/

BEGIN
    FOR I IN REVERSE 1..5             --> ���������� �ʱⰪ���� 1�� ���ҵ� �� ���
    
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
    END LOOP;
END;
/

DROP TABLE TEST;

CREATE TABLE TEST(
    TNO NUMBER PRIMARY KEY,
    TDATE DATE
);

CREATE SEQUENCE SEQ_TNO
START WITH 1
INCREMENT BY 2
MAXVALUE 1000
NOCYCLE
NOCACHE;

-- TEST ���̺� �ݺ����� Ȱ���ؼ� ������ �� �ֱ�
BEGIN
    FOR I IN 1..100
    LOOP
        INSERT INTO TEST VALUES(SEQ_TNO.NEXTVAL, SYSDATE);
    END LOOP;
    
END;
/

SELECT * FROM TEST;

------------------------------------------------------------------------------------------

/*
    3) WHILE LOOP ��
    
    [ǥ����]
    WHILE �ݺ����̼��������      --> ���̾�� �ݺ����� ����ǰ�, �����̵Ǵ� ���� �ݺ����� ��������
    LOOP
        �ݺ������� ������ ����;
    END LOOP;
*/

DECLARE
    I NUMBER := 1;
BEGIN
    
    WHILE I < 6
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
        I := I + 1;
    END LOOP;
END;
/

---------------------------------------------------------------------------------------

/*
    3. EXCEPTION SECTION ����ó����
    
    ����(EXCEPTION) : ���� �� �߻��ϴ� ����
    
    [ǥ����]
    EXCEPTION                                 => �ڹٿ����� TRY~CATCH��
        WHEN ���ܸ�1 THEN ����ó������1;        => TRY�� BEGIN���� �ش�, WHEN ~ THEN �κ��� CATCH���� �ش� 
        WHEN ���ܸ�2 THEN ����ó������2;
        ...
        WHEN OTHERS THEN ����ó������N;         => � ���ܰ� �߻��ϴ����� OTHERS�� ����ϸ� ��� ���ܿ� ���� ����ó������ �ۼ��� �����ϴ�.

        
        * �ý��� ���� (����Ŭ���� �̸� �����ص� ����)
        - NO_DATA_FOUND : SELECT�� ����� �� �൵ ���� ���
        - TOO_MANY_ROWS : SELECT�� ����� �������� ���
        - ZERO_DEVIDE : 0���� ���� �� 
        - DUP_VAL_ON_INDEX : UNIQUE �������ǿ� ����Ǿ��� ��� (�ߺ��� ���� �ִ�)
        ... 
*/

-- ����ڰ� �Է��� ���� ������ ������ ��� ���
DECLARE
    RESULT NUMBER;
BEGIN
    RESULT := 10 / &����;
    DBMS_OUTPUT.PUT_LINE('��� : ' || RESULT);
EXCEPTION
    --WHEN ZERO_DIVIDE THEN DBMS_OUTPUT.PUT_LINE('������ ���� �� 0���� ���� �� �����ϴ�.');
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('������ ���� �� 0���� ���� �� �����ϴ�.');
END;
/

-- UNIQUE �������� ����
BEGIN
    UPDATE EMPLOYEE
       SET EMP_ID = '&�����һ��'
     WHERE EMP_NAME = '���ö';
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN DBMS_OUTPUT.PUT_LINE('�̹� �����ϴ� ����Դϴ�.');
END;
/

DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME
      INTO EID, ENAME
      FROM EMPLOYEE
     WHERE MANAGER_ID = &������;
     
     DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
     DBMS_OUTPUT.PUT_LINE('�̸� : ' || ENAME);
EXCEPTION
    WHEN TOO_MANY_ROWS THEN DBMS_OUTPUT.PUT_LINE('�ʹ� ���� ���� ��ȸ�Ǿ����ϴ�.');
    WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('��ȸ ����� �����ϴ�.');
END;
/















