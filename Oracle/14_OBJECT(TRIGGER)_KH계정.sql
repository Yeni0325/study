/*
    < Ʈ���� TRIGGER >
    ���� ������ ���̺� INSERT, UPDATE, DELETE���� DML���� ���� ��������� ���涧
    (�ش� ���̺� �̺�Ʈ�� �߻����� ��)
    ���������� �Ź� ������ ������ �̸� �����ص� �� �ִ� ��ü
    
    EX)
    ȸ��Ż�� �� ������ ȸ�����̺� ������ DELETE �� ��ٷ� Ż��� ȸ���鸸 ���� �����ϴ� ���̺� �ڵ����� INSERT ó���ؾߵȴ�.
    �Ű�Ƚ���� ���� ���� �Ѿ��� �� ���������� �ش� ȸ���� ������Ʈ�� ó���ǰԲ�
    ����� ���� �����Ͱ� ��� (INSERT) �ɶ����� �ش� ��ǰ�� ���� �������� �Ź� ����(UPDATE)�ؾߵɶ�
    
    * Ʈ���� ����
    - SQL���� ����ñ⿡ ���� �з�
      > BEFORE TRIGGER : ���� ������ ���̺� �̺�Ʈ�� �߻��Ǳ� ���� Ʈ���� ����
      > AFTER TRIGGER : ���� ������ ���̺� �̺�Ʈ�� �߻��� �Ŀ� Ʈ���� ����
    
    - SQL���� ���� ������ �޴� �� �࿡ ���� �з�
      > STATEMENT TRIGGER(����Ʈ����) : �̺�Ʈ�� �߻��� SQL���� ���� �� �ѹ��� Ʈ���� ����
      > ROW TRIGGER(�� Ʈ����) : �ش� SQL�� ������ �� ���� �Ź� Ʈ���� ����
                                (FOR EACH ROW �ɼ� ����ؾߵ�)
                        > : OLD - BEFORE UPDATE(���� �� �ڷ�), BEFORE DELETE(���� �� �ڷ�) 
                        > : NEW - AFTER INSET(�߰��� �ڷ�), AFTER UPDATE(���� �� �ڷ�)
                        
    
    * Ʈ���� ���� ����
    
    [ǥ����]
    CREATE [OR REPLACE] TRIGGER Ʈ���Ÿ�
    BEFORE|AFTER  INSER|UPDATE|DELETE ON ���̺��        => BEFORE���� AFTER������ ���� BEFORE TRIGGER���� AFTER TRIGGER���� ���� / INSERT|UPDATE|DELETE : � �̺�Ʈ�� �߻��Ҷ� Ʈ���Ÿ� �����Ұ��� ���� 
    [FOR EACH ROW]
    [DECLARE                                             => �ڵ����� ������ ���� �Է� (PL / SQL�� �ۼ�)
        ���� ����;]
    BEGIN
        ���೻��(�ش� ���� ������ �̺�Ʈ �߻� �� ����������(�ڵ�����) ������ ����)
    [EXCEPTION
        ����ó������;]
    END;
    /
    
*/

-- EMPLOYEE ���̺� ���ο� ���� INSERT �� �� ���� �ڵ����� �޼����� ��µǴ� Ʈ���� ���� 

CREATE OR REPLACE TRIGGER TRQ_01
AFTER INSERT ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('���Ի���� ȯ���մϴ�!');
END;
/

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, DEPT_CODE, JOB_CODE, HIRE_DATE)
VALUES(500, '�̼���', '111111-2222222', 'D7', 'J7', SYSDATE);

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, DEPT_CODE, JOB_CODE, HIRE_DATE)
VALUES(501, '������', '222222-1111111', 'D8', 'J7', SYSDATE);

------------------------------------------------------------------------------------------

-- ��ǰ �԰� �� ��� ���� ����
-- >> �ʿ��� ���̺� �� ������ ����

-- 1. ��ǰ�� ���� �����͸� ������ ���̺� ���� (TB_PRODUCT)
CREATE TABLE TB_PRODUCT(
    PCODE NUMBER PRIMARY KEY,         -- ��ǰ��ȣ
    PNAME VARCHAR2(30) NOT NULL,      -- ��ǰ��
    BRAND VARCHAR2(30) NOT NULL,      -- �귣���
    PRICE NUMBER,                      -- ����
    STOCK NUMBER DEFAULT 0            -- ������
);

--  ��ǰ��ȣ�� �ߺ��ȵǰԲ� �Ź� ���ο� ��ȣ�� �߻���Ű�� ������ ���� (SEQ_PECODE)
CREATE SEQUENCE SEQ_PCODE
START WITH 200
INCREMENT BY 5
NOCACHE;

-- ���õ����� �߰� 
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '������20', '����', 1400000, DEFAULT);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '������13PRO', '���', 1300000, 10);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '�����', '������', 600000, 20);

SELECT * FROM TB_PRODUCT;

COMMIT;

-- 2. ��ǰ ����� ���� �� �̷��� ����ϴ� ���̺� ���� (TB_PRODETAIL)
--    � ��ǰ�� ���¥�� ��� �԰� �Ǵ� ��� �Ǿ������� ���� �����͸� ����ϴ� ���̺�
CREATE TABLE TB_PRODETAIL(
    DCODE NUMBER PRIMARY KEY,                  -- �̷¹�ȣ
    PCODE NUMBER REFERENCES TB_PRODUCT,        -- ���� �����ϰ� �ִ� ��ǰ��ȣ�� ��ϵǾ��ϱ⶧���� TB_PRODUCT���̺��� PCODE�÷� ���� ������ �ܷ�Ű ���� (PCODE�� PRIMARY KEYF�� �����Ǿ��ֱ� ������ ���� ����)
    PDATE DATE NOT NULL,                       -- ��ǰ�������
    AMOUNT NUMBER NOT NULL,                    -- ����� ����
    STATUS CHAR(6) CHECK(STATUS IN ('�԰�', '���'))  -- ����(�԰�/���)
);

-- �̷¹�ȣ�� �Ź� ���ο� ��ȣ �߻����Ѽ� �� �� �ְ� �����ִ� ������ ���� (SEQ_DCODE)
CREATE SEQUENCE SEQ_DCODE
NOCACHE;

-- �԰� / ���Ǵ� ���� TB_PRODETAIL���̺� �ۼ�(INSERT)�ǰ� TB_PRODUCT�� STOCK ��� �÷��� ������ ����(UPDATE)�ȴ�. 

-- 200�� ��ǰ�� ���ó�¥�� 10�� �԰� (TB_PRODETAIL ���̺�)
INSERT INTO TB_PRODETAIL 
VALUES(SEQ_DCODE.NEXTVAL, 200, SYSDATE, 10 , '�԰�');

-- 200�� ��ǰ�� �������� 10 ���� (TB_PRODUCT���̺�)
UPDATE TB_PRODUCT
   SET STOCK = STOCK + 10
 WHERE PCODE = 200;
 
 COMMIT;

-- 210�� ��ǰ�� ���ó�¥�� 5�� ��� (TB_PRODETAIL ���̺�)
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DCODE.NEXTVAL, 210, SYSDATE, 5, '���');

-- 210�� ��ǰ�� �������� 5 ���� (TB_PRODUCT ���̺�)
UPDATE TB_PRODUCT
   SET STOCK = STOCK - 5
 WHERE PCODE = 210;
 
COMMIT;

-- 205�� ��ǰ�� ���ó�¥�� 20�� �԰� (TB_PRODETAIL ���̺�)
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DCODE.NEXTVAL, 205, SYSDATE, 20, '�԰�');
-- 205�� ��ǰ�� �������� 20 �߰� (TB_PRODUCT ���̺�)
UPDATE TB_PRODUCT
   SET STOCK = STOCK + 20
 WHERE PCODE = 200;              -- INSERT�� ���ߴµ� UPDATE���� �ٸ� ��ǰ�� �������� �÷����� (����)
 
ROLLBACK;      --> ���� UPDATE�� �߸��߱� ������ �� ���󺹱�

-- 205�� ��ǰ�� ���ó�¥�� 20�� �԰� (TB_PRODETAIL ���̺�)
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DCODE.NEXTVAL, 205, SYSDATE, 20, '�԰�');
-- 205�� ��ǰ�� �������� 20 �߰� (TB_PRODUCT ���̺�)
UPDATE TB_PRODUCT
   SET STOCK = STOCK + 20
 WHERE PCODE = 205;   

COMMIT;

-- TB_PRODETAIL ���̺� INSERT �̺�Ʈ �߻� �� 
-- TB_PRODUCT ���̺� �Ź� �ڵ����� ������ UPDATE�ǰԲ� Ʈ���� ����

/*
    - ��ǰ�� �԰�� ��� => �ش� ��ǰã�Ƽ� �������� ������Ű�� UPDATE
    UPDATE TB_PRODUCT
       SET STOCK = STOCK + �����԰�ȼ���(INSERT�� �ڷ��� AMOUNT�� ��ŭ)
     WHERE PCODE = �԰�Ȼ�ǰ��ȣ(INSERT�� �ڷ��� PCODE��);
     
     - ��ǰ�� ���� ��� => �ش� ��ǰã�Ƽ� �������� ���ҽ�Ű�� UPDATE
     UPDATE TB_PRODUCT
        SET STOCK = STOCK - �������ȼ���(INSERT�� �ڷ��� AMOUNT�� ��ŭ)
      WHERE PCODE = ���Ȼ�ǰ��ȣ (INSERT�� �ڷ��� PCODE��);
*/

CREATE OR REPLACE TRIGGER TRG_O2
AFTER INSERT ON TB_PRODETAIL 
FOR EACH ROW
BEGIN
    -- ��ǰ�� �԰�� ��� => ������ ����
    IF (:NEW.STATUS = '�԰�') 
        THEN 
            UPDATE TB_PRODUCT
               SET STOCK = STOCK + :NEW.AMOUNT
             WHERE PCODE = :NEW.PCODE;
    END IF;
    
    -- ��ǰ�� ���� ��� => ������ ����
    IF (:NEW.STATUS = '���')
        THEN
            UPDATE TB_PRODUCT
               SET STOCK = STOCK - :NEW.AMOUNT
             WHERE PCODE = :NEW.PCODE;
    END IF;
END;
/

-- 210�� ��ǰ�� ���ó�¥�� 7�� ��� (TB_PRODETAIL ���̺�)
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DCODE.NEXTVAL, 210, SYSDATE, 7, '���');

-- 200�� ��ǰ�� ���ó�¥�� 100�� �԰� (TB_PRODETAIL ���̺�)
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DCODE.NEXTVAL, 200, SYSDATE, 100, '�԰�');







