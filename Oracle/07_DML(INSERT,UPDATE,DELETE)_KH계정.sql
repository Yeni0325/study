/*
    DQL (QUERY 데이터 질의 언어) : SELECT
    
    DML (MANIPULATION 데이터 조작 언어) : [SELECT], INSERT, UPDATE, DELETE
    DDL (DEFINITION 데이터 정의 언어) : CREATE, ALTER, DROP
    DCL (CONTROL 데이터 제어 언어) : GRANT, REVOKE, [COMMIT, ROLLBACK] 
    
    TCL (TRANSACTION 트랜잭션 제어 언어) : COMMIT, ROLLBACK
    
    < DML : DATE MANIPULATION LANGUAGE >
    데이터 조작 언어
    
    테이블에 값을 삽입(INSERT)하거나, 수정(UPDATE)하거나, 삭제(DELETE)하는 구문
    
*/

/*
    1. INSERT
       테이블에 새로운 행을 추가하는 구문
       
       [표현식]
       1) INSERT INTO 테이블명 VALUES(값, 값, 값, 값, 값, ...); -> 해당 테이블에 존재하는 모든 컬럼에 값을 제시 
          테이블에 모든 컬럼에 대한 값을 직접 제시해서 한 행을 INSERT하고자 할 때 사용
          컬럼 순번을 지켜서 VALUES에 값을 나열해야한다.
          
          부족하게 값을 제시했을 경우 => not enough value 오류 발생
          값을 더 많이 제시했을 경우 => too many values 오류 발생
*/

INSERT INTO EMPLOYEE
VALUES(900, '장채현', '980914-2451321', 'jang_ch@kh.or.kr', '01011112222', 'D1', 'J7', 4000000, 0.2, 200, SYSDATE, NULL, DEFAULT);

SELECT * FROM EMPLOYEE;

/*
    2) INSERT INTO 테이블명(컬럼명, 컬럼명, 컬럼명) VALUES(값, 값, ㅏㄱㅄ);
       테이블에 내가 선택한 컬럼에 대한 값만 INSERT할 때 사용
       그래도 한 행 단위로 추가되기 때문에 선택안된 컬럼은 기본적으로 NULL이 들어간다.
       => NOT NULL 제약조건이 걸려있는 컬럼은 반드시 선택해서 직접 값 제시해야됨 
       단, 기본값(DEFAULT)이 지정되어 있으면 NULL이 아닌 기본값이 들어감
*/

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, HIRE_DATE) VALUES(901, '강람보', '940325-2142513', 'J7', SYSDATE);

SELECT * FROM EMPLOYEE;

INSERT
  INTO EMPLOYEE
       (
         EMP_ID
       , EMP_NAME
       , EMP_NO
       , JOB_CODE
       , HIRE_DATE
       ) 
VALUES
       (
        901
        , '강람보'
        , '940325-2142513'
        , 'J7'
        , SYSDATE
        );

------------------------------------------------------------------------------------------

/*
    3) INSERT INTO 테이블명 (서브쿼리); 
       VALUES 로 값을 직접 명시하는것 대신에
       서브쿼리로 조회된 결과값을 통째로 INSERT가능 ! (즉, 여려행 INSERT 가능)
*/

-- 새로운 테이블 세팅
CREATE TABLE EMP_01 (
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(20),
    DEPT_TITLE VARCHAR2(20)
);

SELECT * FROM EMP_01;

-- 전체 사원들의 사번, 이름, 부서명 조회
INSERT INTO EMP_01
    (SELECT EMP_ID, EMP_NAME, DEPT_TITLE
     FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID));
     
----------------------------------------------------------------------------------------

/*
    2. INSERT ALL
       두개 이상의 테이블에 각각 INSERT할 때 
       이 때 사용되는 서브쿼리가 동일할 경우 사용
*/
--> 우선 테스트할 테이블 생성
CREATE TABLE EMP_DEPT
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
    FROM EMPLOYEE
    WHERE 1=0;
    
CREATE TABLE EMP_MANAGER
AS SELECT EMP_ID, EMP_NAME, MANAGER_ID
    FROM EMPLOYEE
    WHERE 1=0;
    
SELECT * FROM EMP_DEPT;
SELECT * FROM EMP_MANAGER;

-- 부서코드가 D1인 사원들의 사번, 이름, 부서코드, 입사일, 사수사번 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1';

/*
    [표현식]
    INSERT ALL
    INTO 테이블명1 VALUES(컬럼명, 컬럼명, ...)
    INTO 테이블명2 VALUES(컬럼명, 컬럼명, ...)
        서브쿼리;
*/
INSERT ALL
INTO EMP_DEPT VALUES(EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE)
INTO EMP_MANAGER VALUES(EMP_ID, EMP_NAME, MANAGER_ID)
    SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
    FROM EMPLOYEE
    WHERE DEPT_CODE = 'D1';
    
SELECT * FROM EMP_DEPT;
SELECT * FROM EMP_MANAGER;