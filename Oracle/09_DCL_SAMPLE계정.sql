
-- CREATE TABLE �� �� �ִ� ������ ��� ���� �߻�
-- 3_1. CREATE TABLE ���� �ο��ޱ�
-- 3_2. TABLESPACE ���� �Ҵ� �ޱ�
CREATE TABLE TEST(
    TEST_ID NUMBER,
    TEST_NAME VARCHAR2(10)
);

SELECT * FROM TEST;
INSERT INTO TEST VALUES(10, '�ȳ�');
-- CREATE TABLE ������ �ο��޴� ���� ���̺���� �ٷ� ���� ����

---------------------------------------------------------------------------------------
-- KH������ EMPLOYEE���̺� �����ؼ� ��ȸ�� �� �ִ� ���� ����
SELECT * 
FROM KH.EMPLOYEE; -- �����߻� : "table or view does not exist"

-- 4. SELECT ON KH.EMPLOYEE���� �ο��ޱ�
SELECT * 
FROM KH.EMPLOYEE;

-- 5. INSERT ON KH.DEPARTMENT ���� �ο��ޱ�
INSERT INTO KH.DEPARTMENT
VALUES('D0', 'ȸ���', 'L1');

ROLLBACK;
