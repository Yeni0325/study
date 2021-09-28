/*
    * DDL (DATA DEFINITION LANGUAGE) : ������ ���� ���
    ����Ŭ���� �����ϴ� ��ü(OBJECT)�� ������ �����(CREATE), ������ ����(ALTER)�ϰ�, ���� ��ü�� ����(DROP)�ϴ� ��� 
    ��, ���� ������ ���� �ƴ� ���� ��ü�� �����ϴ� ���
    �ַ� DB������ , �����ڰ� �����
    
    ����Ŭ������ ��ü(����) : ���̺�(TABLE), ��(VIEW), ������(SEQUENCE), 
                            �ε���(INDEX), ��Ű��(PACKAGE), Ʈ����(TRIGGER),
                            ���ν���(PROCEDUER), �Լ�(FUNCTION), ���Ǿ�(SYNONYM), �����(USER)
                            
    < CREATE >
    ��ü�� ������ �����ϴ� ����
    
*/

/*
    1. ���̺� ����
    - ���̺��̶�? : ��(ROW)�� ��(COLUMN)�� �����Ǵ� ���� �⺻���� �����ͺ��̽� ��ü
                   ��� �����͵��� ���̺��� ���ؼ� ����ȴ�!!
                   (DBMS ��� �� �ϳ���, �����͸� ������ ǥ ���·� ǥ���� ��)
                   
    [ǥ����]
    CREATE TABLE ���̺��(
        �÷��� �ش��÷����ڷ���(ũ��),           -> �������� ��쿡�� ũ�������� ���ش�
        �÷��� �ش��÷����ڷ���(ũ��),
        �÷��� �ش��÷����ڷ���,
        ...
    );
    
    * �ڷ���
    - ���� (CHAR(����Ʈũ��) | VARCHAR2(����Ʈũ��)) : �ݵ�� ũ�������� ������Ѵ�.
      > CHAR : �ִ� 2000BYTE���� ���� ���� / �������� (������ ũ�⺸�� �� ���� ���� ���͵� �������ζ� ä���� ó�� ������ ũ�⸸ŭ ����)
               ������ ���ڼ��� �����͸��� ��� ��� ���
      > VARCHAR2 : �ִ� 4000BYTE���� ���� ���� / �������� (��� ���� ���� ������ ũ�� ������)
                   ������� �����Ͱ� ������ �� ��� ���
    - ���� (NUMBER) : ����, �Ǽ� ����X
    
    - ��¥ (DATE)
    
*/  

--> ȸ���� ���� �����͸� ��� ���� MEMBER ���̺� �����ϱ�
CREATE TABLE MEMBER(
    MEM_NO NUMBER,
    MEM_ID VARCHAR2(20),
    MEM_PWD VARCHAR2(20),
    MEM_NAME VARCHAR2(20),
    GENDER CHAR(3),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE
);

SELECT * FROM MEMBER;

-- ������ ��ųʸ� : �پ��� ��ü���� ������ �����ϰ� �ִ� �ý��� ���̺��
-- [�������] USER_TABLES : ���� �ش� ������ ������ �ִ� ���̺��� �������� ������ Ȯ�� �� �� �ִ� �ý��� ���̺�
SELECT * FROM USER_TABLES; 
-- [�������] USER_TAB_COLUMNS : �ش� ������ ������ �ִ� ���̺� ���� ��� �÷��� �������� ������ Ȯ���� �� �ִ� �ý��� ���̺�
SELECT * FROM USER_TAB_COLUMNS;

------------------------------------------------------------------------------------------

/*
    2. �÷��� �ּ� �ޱ� (�÷��� ���� ��������)
    
    [ǥ����]
    COMMENT ON COLUMN ���̺��.�÷��� IS '�ּ�����';
    
    >> �߸� �ۼ��ؼ� �������� ��� ���� �� �ٽ� �����ϸ�ȴ�.

*/

COMMENT ON COLUMN MEMBER.MEM_NO IS 'ȸ����ȣ';
COMMENT ON COLUMN MEMBER.MEM_ID IS 'ȸ�����̵�';

COMMENT ON COLUMN MEMBER.MEM_PWD IS 'ȸ����й�ȣ';
COMMENT ON COLUMN MEMBER.MEM_NAME IS 'ȸ����';
COMMENT ON COLUMN MEMBER.GENDER IS '����(��/��)';
COMMENT ON COLUMN MEMBER.PHONE IS '��ȭ��ȣ';
COMMENT ON COLUMN MEMBER.EMAIL IS '�̸���';
COMMENT ON COLUMN MEMBER.MEM_DATE IS 'ȸ��������';

-- ���̺� �����ϰ��� �� �� : DROP TABLE ���̺��;

-- ���̺� �����͸� �߰���Ű�� ���� (DML : INSERT)
-- INSERT INTO ���̺�� VALUES(��, ��, ��, ...);
INSERT INTO MEMBER VALUES(1, 'user01', 'pass01', 'ȫ�浿', '��', '010-1111-2222', 'aaa@naver.com', '20/12/30');
INSERT INTO MEMBER VALUES(2, 'user02', 'pass02', 'ȫ���', '��', null, NULL, SYSDATE);

INSERT INTO MEMBER VALUES(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

---------------------------------------------------------------------------------------------

/*
    < �������� CONSTRAINTS >
    - ���ϴ� �����Ͱ�(��ȿ�� ������ ��)�� �����ϱ� ���ؼ� Ư�� �÷��� �����ϴ� ����
    - ������ ���Ἲ ������ �������� �Ѵ�.
    
    * ���� : NOT NULL, UNIQUE, CHECK(����), PRIMARY KEY, FOREIGN KEY
    
*/

/*
    * NOT NULL ��������
    �ش� �÷��� �ݵ�� ���� �����ؾ߸� �� ��� (��, �ش� �÷��� ���� NULL�� ���ͼ��� �ȵǴ� ���)
    ����/���� �� NULL���� ������� �ʵ��� ����

    ���������� �ο��ϴ� ����� ũ�� 2���� ���� (�÷�������� / ���̺������)
    * NOT NULL���������� ������ �÷�������� �ۿ� �ȵ�!
*/

-- �÷�������� : 
-- [ǥ����]
-- �÷��� �ڷ��� ��������

CREATE TABLE MEM_NOTNULL(
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(20) NOT NULL,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3),
    PHONE VARCHAR2(13), 
    EMAIL VARCHAR2(50)
);

INSERT INTO MEM_NOTNULL VALUES (1, 'user01', 'pass01', 'ȫ�浿', '��', null, null);
INSERT INTO MEM_NOTNULL VALUES(2, 'user02', null, '�踻��', '��', null, 'aaa@naver.com');
--> �ǵ��ߴ���� ������! (NOT NULL�������ǿ� ����Ǿ� ���� �߻�)

INSERT INTO MEM_NOTNULL VALUES(2, 'user01', 'pass02', '������', null, null, null);
--> ID�� �ߺ��Ǿ������� �ұ��ϰ� �� �߰���

----------------------------------------------------------------------------------------
 
 /*
    * UNIQUE ��������
    �ش� �÷��� �ߺ��� ���� ������ �ȵ� ��� �ο��ϴ� ��������
    �÷����� �ߺ����� �����ϴ� ��������
    ����/���� �� ������ �ִ� �����Ͱ� �� �ߺ����� ���� ��� ���� �߻�  
 */
 CREATE TABLE MEM_UNIQUE(
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE, --> �÷������������ �������� �ο�
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3),
    PHONE VARCHAR2(13), 
    EMAIL VARCHAR2(50)
);
DROP TABLE MEM_UNIQUE;

-- ���̺��� ��� : ��� �÷����� �� ������ �� �������� ���
--                 [ǥ����]
--                 ��������(�÷���)
 CREATE TABLE MEM_UNIQUE(
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(20) NOT NULL,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3),
    PHONE VARCHAR2(13), 
    EMAIL VARCHAR2(50),
    UNIQUE(MEM_ID)                  --> ���̺� ���� ���
);

INSERT INTO MEM_UNIQUE VALUES(1, 'user01', 'pass01', 'ȫ�浿', null, null, null);
INSERT INTO MEM_UNIQUE VALUES(2, 'user01', 'pass02', '������', null, null, null);
--> unique �������ǿ� ����Ǿ����Ƿ� insert ����!!
--> ���� ������ �������Ǹ����� �˷��� (Ư�� �÷��� � ������ �ִ��� ���� �˷����� ����)
--> ���� �ľ��ϱ� ��ƴ�
--> �������� �ο��� �������Ǹ��� ���������� ������ �ý��ۿ��� �˾Ƽ� ������ �������Ǹ��� �ο��ع���

/*
    * �������� �ο� �� �������Ǹ���� �����ִ� ���
    
    > �÷��������
    CREATE TABLE ���̺��(
        �÷��� �ڷ��� [CONSTRAINT �������Ǹ�] ��������, 
        �÷��� �ڷ���,
        ...
    );
    
    > ���̺������
    CREATE TABLE ���̺��)
        �÷��� �ڷ���,
        �÷��� �ڷ���,
        ...
        [CONSTRAINT �������Ǹ�] ��������(�÷���)
    );
    
*/
DROP TABLE MEM_UNIQUE;

CREATE TABLE MEM_UNIQUE(
    MEM_NO NUMBER CONSTRAINT MEMNO_NN NOT NULL,
    MEM_ID VARCHAR2(20) CONSTRAINT MEMID_NN NOT NULL, --> �÷������������ �������� �ο�
    MEM_PWD VARCHAR2(20) CONSTRAINT MEMPWD_NN NOT NULL,
    MEM_NAME VARCHAR2(20) CONSTRAINT MEMNAME_NN NOT NULL,
    GENDER CHAR(3),
    PHONE VARCHAR2(13), 
    EMAIL VARCHAR2(50),
    CONSTRAINT MEMID_UQ UNIQUE(MEM_ID) --> ���̺��� ���
);
INSERT INTO MEM_UNIQUE VALUES(1, 'user01', 'pass01', 'ȫ�浿', null, null, null);
INSERT INTO MEM_UNIQUE VALUES(2, 'user01', 'pass02', '������', null, null, null);

INSERT INTO MEM_UNIQUE VALUES(2, 'user02', 'pass02', 'ȫ�浿', null, null, null);

SELECT * FROM MEM_UNIQUE;

INSERT INTO MEM_UNIQUE VALUES(3, 'user03', 'pass03', 'ȫ���', '��', null, null);
--> ������ ��ȿ�� ���� �ƴѰ� ���͵� �� insert �ǹ���..

-----------------------------------------------------------------------------------

/*
    * CHECK(���ǽ�) ��������
    �ش� �÷��� ���� �� �ִ� ���� ���� ������ �����ص� �� ����!
    �ش� ���ǿ� �����ϴ� �����Ͱ��� ��� �� ����
*/

CREATE TABLE MEM_CHECK(
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL, 
    GENDER CHAR(3) CHECK(GENDER IN ('��', '��')), -- �÷��������
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50)
    --CHECK(GENDER IN ('��', '��')) -- ���̺������
);

INSERT INTO MEM_CHECK VALUES(1, 'user01', 'pass01', 'ȫ�浿', '��', null, null);
INSERT INTO MEM_CHECK VALUES(2, 'user02', 'pass02', 'ȫ���', '��', null, null);
--> check �������ǿ� ����Ǿ��� ������ ���� �߻�

INSERT INTO MEM_CHECK VALUES(2, 'user02', 'pass02', 'ȫ���', null, null, null);
--> ���� GENDER�÷��� ������ ���� �ְ��� �Ѵٸ� CHECK�������ǿ� �����ϴ� ���� �־�ߵ�
--> �Ӹ� �ƴ϶� NULL�� �����ϱ� ��!

SELECT * FROM MEM_CHECK;

INSERT INTO MEM_CHECK VALUES(2, 'user03', 'pass03', '������', '��', null, null);
--> ȸ����ȣ�� �����ص� ���������� insert �ǹ���...

---------------------------------------------------------------------------------------

/*
     * PRIMARY KEY(�⺻Ű) ��������
     ���̺��� �� ����� �ĺ��ϱ� ���� ���� �÷��� �ο��ϴ� �������� (�ĺ����� ����)
     
     EX) ȸ����ȣ, �й�, �����ȣ, �μ��ڵ�, �����ڵ�, �ֹ���ȣ, �����ȣ, ������ȣ, ...
     
     PRIMARY KEY ���������� �ο��ϸ� �� �÷��� �ڵ����� NOT NULL + UNIQUE ���������� �ǹ�
     
     * ���ǻ��� : �� ���̺� �� ������ �� ���� ���� ����
*/
CREATE TABLE MEM_PRI(
    MEM_NO NUMBER CONSTRAINT MEMNO_PK PRIMARY KEY, --> �÷������������ �������� �ο�
    MEM_ID VARCHAR2(20) CONSTRAINT MEMID_PK NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20) NOT NULL, 
    MEM_NAME VARCHAR2(20) NOT NULL, 
    GENDER CHAR(3) CHECK(GENDER IN ('��', '��')),
    PHONE VARCHAR2(13), 
    EMAIL VARCHAR2(50)
    --, CONSTRAINT MEMNO_PK PRIMARY KEY(MEM_NO) --> ���̺���������� �������� �ο�
);

INSERT INTO MEM_PRI VALUES(1, 'user01', 'pass01', '������', '��', '010-1111-2222', null);
INSERT INTO MEM_PRI VALUES(1, 'user02', 'pass02', '�̼���', '��', null, null);
--> �⺻Ű�� �ߺ����� �������� �� �� (unique �������ǿ� ����)

INSERT INTO MEM_PRI VALUES(null, 'user02', 'pass02', '�̼���', '��', null, null);
--> �⺻Ű�� null�� �������� �� �� (not null �������ǿ� ����)

INSERT INTO MEM_PRI VALUES(2, 'user02', 'pass02', '�̼���', '��', null, null);

SELECT * FROM MEM_PRI;

CREATE TABLE MEM_PRI2(
    MEM_NO NUMBER , 
    MEM_ID VARCHAR2(20) ,
    MEM_PWD VARCHAR2(20) NOT NULL, 
    MEM_NAME VARCHAR2(20) NOT NULL, 
    GENDER CHAR(3) CHECK(GENDER IN ('��', '��')),
    PHONE VARCHAR2(13), 
    EMAIL VARCHAR2(50),
    PRIMARY KEY(MEM_NO, MEM_ID)   --> 2���� �÷��� ��� PRIMARY KEY�������� �ο� (����Ű)
);

INSERT INTO MEM_PRI2 VALUES(1, 'user01', 'pass01', 'ȫ�浿', null, null, null);
INSERT INTO MEM_PRI2 VALUES(1, 'user02', 'pass02', 'ȫ���', null, null, null);
INSERT INTO MEM_PRI2 VALUES(2, 'user02', 'pass03', '���浿', null, null, null);
INSERT INTO MEM_PRI2 VALUES(null, 'user02', 'pass03', '���浿', null, null, null);
--> primary kry�� �����ִ� �� �÷����� ���� null�� ������� ����!!

-- ����Ű ��� ���� (� ȸ���� � ��ǰ�� ���ϴ����� ���� �����͸� �����ϴ� ���̺�)
CREATE TABLE TB_LIKE(
    MEM_NO NUMBER,
    PRODUCT_NAME VARCHAR2(10),
    LIKE_DATE DATE,
    PRIMARY KEY(MEM_NO, PRODUCT_NAME)
);

INSERT INTO TB_LIKE VALUES(1, 'A', SYSDATE);
INSERT INTO TB_LIKE VALUES(1, 'B', SYSDATE);
INSERT INTO TB_LIKE VALUES(1, 'A', SYSDATE);