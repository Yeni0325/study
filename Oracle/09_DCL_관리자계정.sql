/*
    < DCL : DATE CONTROL LANGUAGE >
    ������ ���� ���
    
    �������� �ý��۱��� �Ǵ� ��ü���ٱ����� �ο�(GRANT)�ϰų� ȸ��(REVOKE)�ϴ� ���� 
    
    > �ý��� ���� : DB�� �����ϴ� ���� , ��ü ���� ������ �� �ִ� ���� 
    > ��ü���ٱ��� : Ư�� ��ü���� ������ �� �ִ� ���� 

*/

/*
    * �ý��۱��� ����
    - CREATE SESSION  : ������ �� �ִ� ���� (������ ���� ����)
    - CREATE TABLE    : ���̺��� ������ �� �ִ� ����
    - CREATE VIEW     : �並 ������ �� �ִ� ����
    - CREATE SEQUENCE : �������� ������ �� �ִ� ����
    ...
*/

-- 1. ���ο� ���� ���� (SAMPLE / SAMPLE ���� ����)
CREATE USER SAMPLE IDENTIFIED BY SAMPLE;
-- 2. ������ ���� CREATE SESSION ���� �ο�
GRANT CREATE SESSION TO SAMPLE;

-- 3-1. ���̺��� ������ �� �ִ� CREATE TABLE ���� �ο�
GRANT CREATE TABLE TO SAMPLE;
-- 3-2. ���̺� ������ ������ �� �ִ� TABLESPACE ���� �Ҵ� �ޱ� (SAMPLE������ �����ϱ� ������ ALTER��)
ALTER USER SAMPLE QUOTA 2M ON SYSTEM;
-- SAMPLE�̶�� USER(����)�� �����ϰڴ�.

----------------------------------------------------------------------------------------

/*
    * ��ü ���� ���� ����
    Ư�� ��ü�� �����ؼ� ������ �� �ִ� ���� 
    
    ��������              Ư����ü
    SELECT        TABLE, VIEW, SEQUENCE
    INSERT        TABLE, VIEW
    UPDATE        TABLE, VIEW
    DELETE        TABLE, VIEW
    ...
    
    [ǥ����]
    GRANT �������� ON ������Ư����ü TO ������;
*/

-- 4.  KH������ EMPLOYEE���̺� �����ؼ� ��ȸ�� �� �ִ� ���� : SELECT ON KH.EMPLOYEE���� �ο��ޱ�
GRANT SELECT ON KH.EMPLOYEE TO SAMPLE;

-- 5. KH������ DEPARTMENT���̺� �����ؼ� ������ �� �ִ� ����
GRANT INSERT ON KH.DEPARTMENT TO SAMPLE;

-- ���� ȸ��
-- [ǥ����] REVOKE ȸ���ұ��� FROM ������;
REVOKE SELECT ON KH.EMPLOYEE FROM SAMPLE;

---------------------------------------------------------------------------------------

GRANT CONNECT, RESOURCE TO ������;

/*
    < �� ROLE >
    - Ư�� ���ѵ��� �ϳ��� �������� ��Ƴ��� �� 
    
    CONNECT  : ������ �� �ִ� ���� (CREATE SESSION)
    RESOURCE : Ư�� ��ü���� ������ �� �ִ� ����(CREATE TABLE, CREATE SEQUENCE, ...) 
*/

SELECT * 
FROM ROLE_SYS_PRIVS
WHERE ROLE IN ('CONNECT', 'RESOURCE')
ORDER BY 1;


-- �ǽ��� ���� ���� ���� (FINAL/FINAL)
CREATE USER FINAL IDENTIFIED BY FINAL;
GRANT CONNECT, RESOURCE TO FINAL;









