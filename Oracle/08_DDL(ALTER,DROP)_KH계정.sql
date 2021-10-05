/*
    DDL (DATE DEFINITION LANGUAGUE) : ������ ���� ���
    
    ��ü���� ����(CREATE), ����(ALTER), ����(DROP)�ϴ� ����
    
    < ALTER >
    ��ü�� �����ϴ� ����
    
    [ǥ����]
    ALTER TABLE ���̺�� �����ҳ���;
    
    * �����ҳ���
    1) �÷� �߰� / ���� / ����
    2) �������� �߰� / ���� => �������� ������ �Ұ�! (�����ϰ��� �Ѵٸ� ���� �� ������ �߰��ϸ��)
    3) �÷��� / �������Ǹ� / ���̺�� ���� 

*/

-- 1) �÷� �߰� / ���� / ����

-- 1-1) �÷� �߰�(ADD) :  ALTER TABLE ���̺�� ADD �÷��� ������Ÿ�� [DEFAULT �⺻��]
-- DEPT_COPY �� CNAME �÷� �߰� 
ALTER TABLE DEPT_COPY ADD CNAME VARCHAR2(20);
--> ���ο� �÷��� ��������� �⺻������ NULL�� ä����

-- DEPT_COPY�� LNAME �÷� �߰� (�⺻���� ������ä��)
ALTER TABLE DEPT_COPY ADD LNAME VARCHAR2(20) DEFAULT '�ѱ�';
--> ���ο� �÷��� ��������� ���� ������ �⺻������ ä����

-- 1-2) �÷� ����(MODIFY) 

--   [ǥ����]
--    > ������ Ÿ�� ���� : ALTER TABLE ���̺�� MODIFY �÷��� �ٲٰ����ϴµ�����Ÿ��

--    > DEFAULT�� ����  : ALTER TABLE ���̺�� MODIFY �÷��� DEFAULT �ٲٰ����ϴ±⺻��

-- DEPT_COPY ���̺� DEPT_ID�÷��� DATA_TYPE�� CHAR(2)���� CHAR(3)���� ����
ALTER TABLE DEPT_COPY MODIFY DEPT_ID CHAR(3);

-- DEPT_COPY ���̺� DEPT_ID�÷��� DATA_TYPE�� NUMBERŸ������ ����
ALTER TABLE DEPT_COPY MODIFY DEPT_ID NUMBER;
--> �����߻� : "column to be modified must be empty to change datatype" 
--            CHAR���� NUMBERŸ������ �����ϰ��� �Ѵٸ� �����ϴ� ������ ���� ������Ѵ�.

-- DEPT_COPY ���̺� DEPT_TITLE�÷��� DATA_TYPE�� VARCHAR2(35) -> VARCHAR2(10)���� ����
ALTER TABLE DEPT_COPY MODIFY DEPT_TITLE VARCHAR2(10);
--> �����߻� : "cannot decrease column length because some value is too big"
--             ����ִ� �����Ͱ����� �̹� 10����Ʈ ũ�⸦ �ѱ� �����̱� ������ �����߻�
--             ����Ʈ ���� �ø��°� ������ ���� ������ ���϶��� ����ִ� ������ ���� ����ؾ��Ѵ�!

-- DEPT_COPY ���̺� DEPT_TITLE�÷��� DATA_TYPE�� VARCHAR2(35) -> VARCHAR2(40)���� ����
-- DEPT_COPY ���̺� LOCATION_ID�÷��� DATA_TYPE�� CHAR(2) -> VARCHAR2(2)���� ����
-- DEPT_COPY ���̺� LNAME�÷��� �⺻���� '�̱�'���� ����
ALTER TABLE DEPT_COPY 
    MODIFY DEPT_TITLE VARCHAR2(40)
    MODIFY LOCATION_ID VARCHAR2(2)
    MODIFY LNAME DEFAULT '�̱�';
    

-- 1_3) �÷� ����(DROP COLUMN) : ALTER TABLE ���̺�� DROP COLUMN �����ϰ����ϴ��÷���
CREATE TABLE DEPT_COPY2
AS SELECT * FROM DEPT_COPY;

-- DEPT_COPY2 ���̺� �ִ� DEPT_ID �÷� �����
ALTER TABLE DEPT_COPY2 DROP COLUMN DEPT_ID;

-- DEPT_COPY2 ���̺� �ִ� DEPT_TITLE �÷� �����
ALTER TABLE DEPT_COPY2 DROP COLUMN DEPT_TITLE;

-- DEPT_COPY2 ���̺� �ִ� CNAME �÷� �����
ALTER TABLE DEPT_COPY2 DROP COLUMN CNAME;

-- DEPT_COPY2 ���̺� �ִ� LNAME �÷� �����
ALTER TABLE DEPT_COPY2 DROP COLUMN LNAME;

-- DEPT_COPY2 ���̺� �ִ� LOCATION_ID �÷� �����
ALTER TABLE DEPT_COPY2 DROP COLUMN LOCATION_ID;
-- �����߻� : cannot drop all columns in a table
--           �ּ� �Ѱ��� �÷��� �����ؾ��ϱ� ������ ������ �߻�

-----------------------------------------------------------------------------------------
-- 2) �������� �߰� / ����

/*
    2_1) �������� �߰� 
    PRIMARY KEY :  ALTER TABLE ���̺�� ADD PRIMARY KEY(�÷���)
    FOREIGN KEY :  ALTER TABLE ���̺�� ADD FOREIGN KEY(�÷���) REFERENCES ���������̺��[(�÷���)]
    UNIQUE      :  ALTER TABLE ���̺�� ADD UNIQUE(�÷���)
    CHECK       :  ALTER TABLE ���̺�� ADD CHECK(�÷��� ���� ����)
    NOT NULL    :  ALTER TABLE ���̺�� MODIFY �÷��� NULL | NOT NULL
    
    �������Ǹ��� �����ϰ��� �Ѵٸ� [CONSTRAINT �������Ǹ�] ��������
*/

-- DEPT_COPY ���̺� DEPT_ID�� PRIMARY KEY �������� �߰� ADD
-- DEPT_COPY ���̺� DEPT_TITLE�� UNIQUE �������� �߰� ADD
-- DEPT_COPY ���̺� NOT NULL �������� �߰� MODIFY
ALTER TABLE DEPT_COPY 
    ADD CONSTRAINT DCOPY_PK PRIMARY KEY(DEPT_ID)
    ADD CONSTRAINT DCOPY_UQ UNIQUE(DEPT_TITLE)
    MODIFY LNAME CONSTRAINT DCOPY_NL NOT NULL;

-- 2_2) �������� ���� : ALTER TABLE ���̺�� DROP CONSTRAINT �������Ǹ�
--                    ALTER TABLE ���̺�� MODIFY �÷��� NULL (NOT NULL ���������� ���)
ALTER TABLE DEPT_COPY DROP CONSTRAINT DCOPY_PK;

ALTER TABLE DEPT_COPY DROP CONSTRAINT DCOPY_UQ
                      MODIFY LNAME NULL;
                      
------------------------------------------------------------------------------------------

-- 3) �÷��� / �������Ǹ� / ���̺�� ���� (RENAME)

-- 3_1) �÷��� ���� : ALTER TABLE ���̺�� RENAME COLUMN �����÷��� TO �ٲ��÷���
-- DEPT_TITLE => DEPT_NAME
ALTER TABLE DEPT_COPY RENAME COLUMN DEPT_TITLE TO DEPT_NAME;

-- 3_2) �������Ǹ� ���� : ALTER TABLE ���̺�� RENAME CONSTRAINT �����������Ǹ� TO �ٲ��������Ǹ�
-- SYS_C007165 => DCOPY_LID_NM
ALTER TABLE DEPT_COPY RENAME CONSTRAINT SYS_C007165 TO DCOPY_LID_NM;

-- 3_3) ���̺�� ���� : ALTER TABLE ���̺�� RENAME TO �ٲ����̺��
-- DEPT_COPY => DEPT_TEST
ALTER TABLE DEPT_COPY RENAME TO DEPT_TEST;

------------------------------------------------------------------------------------------


-- ���̺� ����
DROP TABLE DEPT_TEST;

-- ��, ��𼱰� �����ǰ� �ִ� �θ����̺��� ��� �Ժη� ������ �ȵ�
-- ���࿡ �����ϰ��� �Ѵٸ�
-- ��� 1. �ڽ����̺��� ���� ������ �� �θ����̺��� �����ϴ� ���
-- ��� 2. �׳� �θ����̺� �����ϴµ� �������Ǳ��� ���� �����ϴ� ���

