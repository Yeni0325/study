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

------------------------------------------------------------------------------------------

-- ȸ����޿� ���� �����͸� ���� �����ϴ� ���̺�
CREATE TABLE MEM_GRADE(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);

INSERT INTO MEM_GRADE VALUES(10, '�Ϲ�ȸ��');
INSERT INTO MEM_GRADE VALUES(20, '���ȸ��');
INSERT INTO MEM_GRADE VALUES(30, 'Ư��ȸ��');

SELECT * FROM MEM_GRADE;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20) NOT NULL, 
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('��', '��')),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    GRADE_ID NUMBER --> ȸ����޹�ȣ�� ���� ������ �÷�
);

INSERT INTO MEM VALUES(1, 'user01', 'pass01', 'ȫ���', '��', null, null, null);
INSERT INTO MEM VALUES(2, 'user02', 'pass02', '�踻��', null, null, null, 10);
INSERT INTO MEM VALUES(3, 'user03', 'pass03', '������', null, null, null, 40);
--> ��ȿ�� ȸ����޹�ȣ�� �ƴԿ��� �ұ��ϰ� �� insert �ǹ���

------------------------------------------------------------------------------------------

/*
    * FOREIGN KEY(�ܷ�Ű) ��������
      �ٸ� ���̺� �����ϴ� ���� ���;��ϴ� Ư�� Į���� �ο��ϴ� ��������
      --> �ٸ� ���̺��� �����Ѵٰ� ǥ��
      --> �ַ� FOREIGN KEY �������ǿ� ���� ���̺� ���� ���谡 ������!
      
      > �÷��������
      �÷��� �ڷ��� [CONSTRAINT �������Ǹ�] REFERENCES ���������̺��(�������÷���)
      
      > ���̺������
      [CONSTRAINT �������Ǹ�] FOREIGN KEY(�÷���) REFERENCES ���������̺��(�������÷���)
      
      --> �������÷��� ���� �� ���������̺� PRIMARY KEY�� ������ �÷����� ��Ī!
*/

-- �ܷ�Ű �����ؼ� MEM���̺� ����
DROP TABLE MEM;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20) NOT NULL, 
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('��', '��')),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE) --> �÷��������
    --, FOREIGN KEY(GRADE_IN) REFERENCES MEM_GRADE(GRADE_CODE) --> ���̺������
);

INSERT INTO MEM VALUES(1, 'user01', 'pass01', 'ȫ���', '��', null, null, null);
--> �ܷ�Ű ���������� �ο��� �÷��� �⺻������ NULL ����
INSERT INTO MEM VALUES(2, 'user02', 'pass02', '�踻��', null, null, null, 10);
INSERT INTO MEM VALUES(3, 'user03', 'pass03', '������', null, null, null, 40); 
-- "parent key not found" ���� �߻� --> 40�̶�� ���� MEM_GRADE���̺��� �߰��� �� ���ٴ� ��
INSERT INTO MEM VALUES(3, 'user03', 'pass03', '������', null, null, null, 20);
INSERT INTO MEM VALUES(4, 'user04', 'pass04', 'ȫ�浿', null, null, null, 10); 

-- MEM_GRADE(�θ����̺�) -|--------<- MEM(�ڽ����̺�) : 1 �� �� ����

--> �̶� �θ����̺�(MEM_GRADE)���� �����Ͱ��� ������ ��� �����
-- ������ ���� : DELETE FROM ���̺�� WHERE ����;

--> MEM_GRADE ���̺��� 10�� ��� ����
DELETE FROM MEM_GRADE WHERE GRADE_CODE = 10;
--> �����߻� : �ڽ����̺�(MEM)�� 10�̶�� ���� ����ϱ� �ֱ� ������ ������ �ȵ�

DELETE FROM MEM_GRADE WHERE GRADE_CODE = 30;
--> �ڽ����̺�(MEM)�� 30�̶�� ���� ����ϰ� ���� �ʱ� ������ ������ �ߵ�

--> �ڽ����̺� �̹� ����ϰ� �ִ� ���� ���� ���
--  �θ����̺�κ��� ������ ������ �ȵǴ� "��������" �ɼ��� �ɷ����� 

ROLLBACK;

----------------------------------------------------------------------------------------

/*
    �ڽ����̺� ���� �� �ܷ�Ű ���������� �ο��� �� �����ɼ� ��������
    * �����ɼ� : �θ����̺��� ������ ���� �� �ش� �����͸� ����ϰ� �ִ� �ڽ����̺��� ���� 
                ��� ó���Ұ��� �����ϴ� �ɼ�
                
    - ON DELETE RESTRICTED(�⺻��) : �������ѿɼ�����, �ڽĵ����ͷ� ���̴� �θ����ʹ� ������ �ƿ� �ȵǰԲ� ����
    - ON DELETE SET NULL : �θ����� ���� �� �ش� �����͸� ���� �ִ� �ڽĵ������� ���� NULL�� �����Ű�� �ɼ�
    - ON DELETE CASCADE : �θ����� ���� �� �ش� �����͸� ���� �ִ� �ڽĵ����͵� ���� ������Ű�� �ɼ�
*/

DROP TABLE MEM;

-- ON DELETE SET NULL �����ɼ� �ο�
CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20) NOT NULL, 
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('��', '��')),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    GRADE_ID NUMBER REFERENCES MEM_GRADE ON DELETE SET NULL
);

INSERT INTO MEM VALUES(1, 'user01', 'pass01', 'ȫ���', '��', null, null, null);
--> �ܷ�Ű ���������� �ο��� �÷��� �⺻������ NULL ����
INSERT INTO MEM VALUES(2, 'user02', 'pass02', '�踻��', null, null, null, 10);
INSERT INTO MEM VALUES(3, 'user03', 'pass03', '������', null, null, null, 20);
INSERT INTO MEM VALUES(4, 'user04', 'pass04', 'ȫ�浿', null, null, null, 10);

-- 10�� ��� ����
DELETE FROM MEM_GRADE WHERE GRADE_CODE = 10;
--> �� ������ (��, 10�� ������ ���� �ִ� �ڽĵ����� ���� NULL�� ����)

ROLLBACK;
DROP TABLE MEM;

-- ON DELETE CASCADE �����ɼ� �ο�
CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20) NOT NULL, 
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('��', '��')),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    GRADE_ID NUMBER REFERENCES MEM_GRADE ON DELETE CASCADE
);

INSERT INTO MEM VALUES(1, 'user01', 'pass01', 'ȫ���', '��', null, null, null);
--> �ܷ�Ű ���������� �ο��� �÷��� �⺻������ NULL ����
INSERT INTO MEM VALUES(2, 'user02', 'pass02', '�踻��', null, null, null, 10);
INSERT INTO MEM VALUES(3, 'user03', 'pass03', '������', null, null, null, 20);
INSERT INTO MEM VALUES(4, 'user04', 'pass04', 'ȫ�浿', null, null, null, 10);

-- 10�� ��� ����
DELETE FROM MEM_GRADE WHERE GRADE_CODE = 10; 
--> �� ������ (��, �ش� �����͸� ����ϰ� �ִ� �ڽĵ����͵� ���� DELET��)

------------------------------------------------------------------------------------------

/*
    < DEFAULT �⺻�� > **�������� �ƴ�!! **
    �÷��� �������� �ʰ� INSERT�� NULL�� �ƴ� �⺻���� INSERT�ϰ��� �� �� �����ص� �� �ִ� ��
*/
DROP TABLE MEMBER;
-- �÷��� �ڷ��� DEFAULT �⺻��
CREATE TABLE MEMBER(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_NAME VARCHAR2(20) NOT NULL,
    MEM_AGE NUMBER, 
    HOBBY VARCHAR2(20) DEFAULT '����',
    ENROLL_DATE DATE DEFAULT SYSDATE -- ȸ��������
);

-- INSERT INTO ���̺�� VALUES(�÷���, �÷���, �÷���, ...);
INSERT INTO MEMBER VALUES(1, '���浿', 20, '�', '19/12/13');
INSERT INTO MEMBER VALUES(2, 'ȫ���', NULL, NULL, NULL);
INSERT INTO MEMBER VALUES(3, '�踻��', NULL, DEFAULT, DEFAULT);

-- INSERT INTO ���̺��(�÷���, �÷���) VALUES(�÷���, �÷���);
INSERT INTO MEMBER(MEM_NO, MEM_NAME) VALUES(4, '������');
--> ���õ��� ���� �÷����� �⺻������ NULL�� ��
--  ��, �ش� �÷��� DEFALUT���� �ο��Ǿ����� ��� NULL�� �ƴ� DEFAULT���� ��

--=========================================================================================

/*
    ======================================= KH ���� ========================================
    < SUBQUERY�� �̿��� ���̺� ����>
    ���̺� ����ߴ� ����
    
    [ǥ����]
    CREATE TABLE ���̺�� 
    AS ��������;
    
*/
-- EMPLOYEE ���̺��� ������ ���ο� ���̺� ���� 
CREATE TABLE EMPLOYEE_COPY
AS SELECT *
   FROM EMPLOYEE;
   
SELECT * FROM EMPLOYEE_COPY;
--> �÷�, �����Ͱ�, �������� ���� ��� NOT NULL�� �����

-- EMPLOYEE ���̺��� ������ ���ο� ���̺� ����2
CREATE TABLE EMPLOYEE_COPY2
AS SELECT EMP_ID, EMP_NAME, SALARY, BONUS
   FROM EMPLOYEE
   WHERE 1 = 0; --> �������� �����ϰ��� �� �� ���̴� ���� (��, �����Ͱ��� �ʿ䰡 ����, �÷��� �ʿ����� �� ���)

SELECT * FROM EMPLOYEE_COPY2;

-- EMPLOYEE ���̺��� ������ ���ο� ���̺� ����3
CREATE TABLE EMPLOYEE_COPYE3
AS SELECT EMP_ID, EMP_NAME, SALARY, SALARY * 12 "����"
   FROM EMPLOYEE;
-- "must name this expression with a column alias" : alias ��Ī �����߻�
-- �������� SELECT���� ����� �Ǵ� �Լ����� �ۼ��Ǿ����� ��� �ݵ�� ��Ī�� ��������� �Ѵ�.

SELECT EMP_NAME, ����
FROM EMPLOYEE_COPYE3;

---------------------------------------------------------------------------------------

/*
    * ���̺� �� ������ �Ŀ� �ڴʰ� �������� �߰��ϴ� ���
    
    ALTER TABLE ���̺�� �����ҳ���;
    
    - PRIMARY KEY �������� �߰�  : ALTER TABLE ���̺�� ADD PRIMARY KEY(�÷���);
    - FOREIGEN KEY �������� �߰� : ALTER TABLE ���̺�� ADD FOREIGN KEY(�÷���) REFERENCES ���������̺��[(�������÷���)];
    - UNIQUE �������� �߰�       : ALTER TABLE ���̺�� ADD UNIQUE(�÷���);
    - CHECK �������� �߰�        : ALTER TABLE ���̺�� ADD CHECK(�÷����������ǽ�);
    - NOT NULL �������� �߰�     : ALTER TABLE ���̺�� MODIFY �÷��� NOT NULL;
*/

-- EMPLOYEE_COPY ���̺� PRIMARY KEY �������� �߰� (EMP_ID)
ALTER TABLE EMPLOYEE_COPY ADD PRIMARY KEY(EMP_ID);

-- EMPLOYEE ���̺� DEPT_CODE�� �ܷ�Ű�������� �߰� (�����ϴ����̺�(�θ�) : DEPARTMENT(DEPT_ID))
ALTER TABLE EMPLOYEE ADD FOREIGN KEY(DEPT_CODE) REFERENCES DEPARTMENT; 
-- DEPT_ID�� RPIMARY KEY�� �����Ǿ��ֱ� ������ ��������

-- EMPLOYEE ���̺� JOB_CODE�� �ܷ�Ű�������� �߰� (JOB ���̺� ����)
ALTER TABLE EMPLOYEE ADD FOREIGN KEY(JOB_CODE) REFERENCES JOB;

-- DEPARTMENT ���̺� LOCATION_ID�� �ܷ�Ű�������� �߰� (LOCATION���̺� ����)
ALTER TABLE DEPARTMENT ADD FOREIGN KEY(LOCATION_ID) REFERENCES LOCATION;
