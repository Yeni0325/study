
-- CREATE TABLE 할 수 있는 권한이 없어서 문제 발생
-- 3_1. CREATE TABLE 권한 부여받기
-- 3_2. TABLESPACE 공간 할당 받기
CREATE TABLE TEST(
    TEST_ID NUMBER,
    TEST_NAME VARCHAR2(10)
);

SELECT * FROM TEST;
INSERT INTO TEST VALUES(10, '안녕');
-- CREATE TABLE 권한을 부여받는 순간 테이블들을 바로 조작 가능

---------------------------------------------------------------------------------------
-- KH계정의 EMPLOYEE테이블에 접근해서 조회할 수 있는 권한 없음
SELECT * 
FROM KH.EMPLOYEE; -- 오류발생 : "table or view does not exist"

-- 4. SELECT ON KH.EMPLOYEE권한 부여받기
SELECT * 
FROM KH.EMPLOYEE;

-- 5. INSERT ON KH.DEPARTMENT 권한 부여받기
INSERT INTO KH.DEPARTMENT
VALUES('D0', '회계부', 'L1');

ROLLBACK;
