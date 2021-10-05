/*
    < VIEW 뷰 >
    
    SELECT문(쿼리문)을 저장해둘 수 있는 객체
    (자주 쓰는 긴 SELECT문을 저장해두면 그 긴 SELECT문을 매번 다시 기술할 필요가 없음)
    임시테이블 같은 존재 (실제 데이터가 담겨있는건 아님!! => 논리적인 테이블)

*/

-- '한국'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
-- 오라클 전용 구문
SELECT EMP_ID "사번", EMP_NAME "이름", DEPT_TITLE "부서명", SALARY "급여", NATIONAL_NAME "근무국가명"
  FROM EMPLOYEE E, DEPARTMENT D, LOCATION L, NATIONAL N
 WHERE E.DEPT_CODE = D.DEPT_ID
   AND D.LOCATION_ID = L.LOCAL_CODE
   AND L.NATIONAL_CODE = N.NATIONAL_CODE
   AND NATIONAL_NAME = '한국';
  
-- ANSI 전용 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
  FROM EMPLOYEE E
  JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
  JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
  JOIN NATIONAL USING(NATIONAL_CODE)
 WHERE NATIONAL_NAME = '한국';
 
-- '러시아'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT EMP_ID "사번", EMP_NAME "이름", DEPT_TITLE "부서명", SALARY "급여", NATIONAL_NAME "근무국가명"
  FROM EMPLOYEE E
  JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
  JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
  JOIN NATIONAL USING(NATIONAL_CODE)
 WHERE NATIONAL_NAME = '러시아';
 
-- '일본'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
  FROM EMPLOYEE E
  JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
  JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
  JOIN NATIONAL USING(NATIONAL_CODE)
 WHERE NATIONAL_NAME = '일본';
 
------------------------------------------------------------------------------------------

/*
    1. VIEW 생성 방법
    
    [표현법]
    CREATE [OR REPLACE] VIEW 뷰명
    AS 서브쿼리;
    
    [OR REPLACE] : 뷰 생성 시 기존에 중복된 이름의 뷰가 없다면 새로이 뷰를 생성하고,
                             기존에 중복된 이름의 뷰가 있다면 해당 뷰를 변경(갱신)하는 옵션
*/

CREATE VIEW VW_EMPLOYEE -- 뷰명은 보통 앞에 VW_를 붙임
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
     FROM EMPLOYEE E
     JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
     JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
     JOIN NATIONAL USING(NATIONAL_CODE);
     -- VIEW 객체를 생성할 수 있는 권한이 없으면 오류발생
     -- "insufficient privileges" 권한이 불충분합니다. 
     
GRANT CREATE VIEW TO KH;  --> 권한부여문이기 때문에 관리자계정에서 실행해야함!

SELECT *
FROM VW_EMPLOYEE;
-- 아래와 같은 맥락
SELECT *
FROM (SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
        FROM EMPLOYEE E
        JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
        JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
        JOIN NATIONAL USING(NATIONAL_CODE));

-- 뷰는 논리적인 가상 테이블! (실질적으로 데이터를 저장하고 있지 않음!!)

-- '한국', '러시아', '일본'에 근무하는 사원
SELECT * 
  FROM VW_EMPLOYEE
 WHERE NATIONAL_NAME = '한국';

SELECT * 
  FROM VW_EMPLOYEE
 WHERE NATIONAL_NAME = '러시아';
  
SELECT * 
  FROM VW_EMPLOYEE
 WHERE NATIONAL_NAME = '일본';
 
-- [참고]
SELECT * FROM USER_VIEWS; -- 해당 계정이 가지고 있는 VIEW의 종류;

-- BONUS를 추가해서 다시 VIEW 생성 (CREATE OR REPLACE VIEW)
CREATE OR REPLACE VIEW VW_EMPLOYEE -- 뷰명은 보통 앞에 VW_를 붙임
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME, BONUS
     FROM EMPLOYEE E
     JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
     JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
     JOIN NATIONAL USING(NATIONAL_CODE);

----------------------------------------------------------------------------------------

/*
    * 뷰 컬럼에 별칭 부여
      서브쿼리의 SELET절에 함수식이나 산술연산식이 기술되어있을 경우 반드시 별칭 지정해야됨!!
*/

-- 전 사원의 사번, 이름, 직급명, 성별(남/여), 근무년수를 조회할 수 있는 SELECT문을 뷰(VW_EMP_JOB)로 정의
CREATE OR REPLACE VIEW VW_EMP_JOB
AS SELECT EMP_ID, EMP_NAME, JOB_NAME, 
          DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여') "성별",
          EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) "근무년수"
     FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE);
-- 오류발생 : must name this expression with a column alias : alias(별칭)
          
-- 아래와 같은 방식으로도 별칭 부여가능
CREATE OR REPLACE VIEW VW_EMP_JOB(사번, 이름, 직급명, 성별, 근무년수)
AS SELECT EMP_ID, EMP_NAME, JOB_NAME, 
          DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여'),
          EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
     FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE);
     
SELECT * FROM VW_EMP_JOB;

SELECT 이름, 직급명
  FROM VW_EMP_JOB
 WHERE 성별 = '여';
 
SELECT * 
  FROM VW_EMP_JOB
 WHERE 근무년수 >= 20;
 
-- 뷰 삭제하고자 한다면
DROP VIEW VW_EMP_JOB;

------------------------------------------------------------------------------------------

-- 생성된 뷰를 이용해서 DML(INSERT, UPDATE, DELETE) 사용가능
-- 뷰를 통해서 조작하게 되면 실제 데이터가 담겨있는 베이스테이블에 반영됨

CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_CODE, JOB_NAME
     FROM JOB;
     
SELECT * FROM VW_JOB; -- 논리적인 테이블 (실제데이터가 담겨있진 않음)
SELECT * FROM JOB;    -- 실제데이터가 담긴 테이블은 JOB테이블(베이스 테이블)

-- 뷰를 통해서 INSERT 
INSERT INTO VW_JOB VALUES('J8', '인턴');

-- 뷰를 통해서 UPDATE
UPDATE VW_JOB
   SET JOB_NAME = '알바'
 WHERE JOB_CODE = 'J8';
 
-- 뷰를 통해서 DELETE
DELETE
  FROM VW_JOB
 WHERE JOB_CODE = 'J8';

-- 뷰를 통해서 DML하게 되면 실제 베이스테이블에 다 반영이 된다.

-----------------------------------------------------------------------------------------

/*
    * 단, DML 명령어로 조작이 불가능한 경우가 더 많음!!
    1) 뷰에 정의되어있지 않은 컬럼을 조작하려고 하는 경우
    2) 뷰에 정의되어있지 않은 컬럼 중에 베이스테이블 상에 NOT NULL 제약조건이 지정되어있는 경우
    3) 산술연산식 또는 함수식으로 정의되어있는 경우
    4) 그룹함수나 GROUP BY 절이 포함된 경우
    5) DISTINCT 구문이 포함된 경우
    6) JOIN을 이용해서 여러 테이블을 연결시켜놓은 경우
    
*/

-- 1) 뷰에 정의되어있지 않은 컬럼을 조작하려고 하는 경우
CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_CODE
     FROM JOB;

SELECT * FROM VW_JOB;  -- 논리적인 테이블
SELECT * FROM JOB;     -- 베이스테이블

-- INSERT (에러)
INSERT INTO VW_JOB(JOB_CODE, JOB_NAME) VALUES('J8', '인턴');
-- 오류발생 "JOB_NAME": invalid identifier --> "JOB_NAME" 테이블을 식별할 수 없다는 오류발생

-- UPDATE (에러)
UPDATE VW_JOB
   SET JOB_NAME = '인턴'
 WHERE JOB_CODE = 'J7';
-- 오류발생 "JOB_NAME": invalid identifier --> "JOB_NAME" 테이블을 식별할 수 없다는 오류발생 

-- DELETE (에러)
DELETE
  FROM VW_JOB
 WHERE JOB_NAME = '사원';
-- 오류발생 "JOB_NAME": invalid identifier --> "JOB_NAME" 테이블을 식별할 수 없다는 오류발생

-- 2) 뷰에 정의되어있지 않은 컬럼 중에 베이스테이블 상에 NOT NULL 제약조건이 지정되어있는 경우
CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_NAME
     FROM JOB;

SELECT * FROM VW_JOB;  -- 논리적인 테이블
SELECT * FROM JOB;     -- 베이스테이블

-- INSERT (에러)
INSERT INTO VW_JOB VALUES('인턴'); -- 실제 테이테이블에 INSERT시 (NULL, '인턴') 추가 
-- cannot insert NULL into ("KH"."JOB"."JOB_CODE")
-- VW_JOB에 정의되어있지 않은 JOB테이블의 JOB_CODE컬럼에 NOT NULL제약조건이 걸려있기 때문에 오류발생

-- UPDATE (성공)
UPDATE VW_JOB
   SET JOB_NAME = '알바'
 WHERE JOB_NAME = '사원';
 
ROLLBACK;

-- DELETE
DELETE 
  FROM VW_JOB
 WHERE JOB_NAME = '사원';
-- 오류발생 : integrity constraint (KH.SYS_C007154) violated - child record found
-- 해당 데이터를 사용하고 있는 자식데이터가 존재하기 때문에 삭제제한 / 단, 없다면 삭제 잘됨

-- 3) 산술연산식 또는 함수식으로 정의되어있는 경우
CREATE OR REPLACE VIEW VW_EMP_SAL
AS SELECT EMP_ID, EMP_NAME, SALARY, SALARY * 12 연봉
     FROM EMPLOYEE;
     
SELECT * FROM VW_EMP_SAL; -- 논리적인 테이블
SELECT * FROM EMPLOYEE;   -- 베이스 테이블

-- INSERT (에러)
INSERT INTO VW_EMP_SAL VALUES(400, '정진훈', 3000000, 36000000);
-- 오류발생 : virtual column not allowed here
-- 사번, 사원명, 급여는 베이스테이블인 EMPLOYEE 테이블에 존재하는 컬럼이지만, SALARY * 12인 연봉 테이블은 EMPLOYEE 테이블에 존재하지 않기 때문에 오류가 발생한다.

-- UPDATE 
-- 200번 사원의 연봉을 8000만원으로 변경 (에러)
UPDATE VW_EMP_SAL
   SET 연봉 = 80000000
 WHERE EMP_ID = 200;
-- 오류발생 : virtual column not allowed here
-- 사번, 사원명, 급여는 베이스테이블인 EMPLOYEE 테이블에 존재하는 컬럼이지만, SALARY * 12인 연봉 테이블은 EMPLOYEE 테이블에 존재하지 않기 때문에 오류가 발생한다.

-- 200번 사원의 급여를 700만원으로 변경 (성공)
UPDATE VW_EMP_SAL
   SET SALARY = 7000000
 WHERE EMP_ID = 200;

ROLLBACK; 
-- DELETE (성공)
DELETE FROM VW_EMP_SAL
WHERE 연봉 = 72000000;

-- 4) 그룹함수 또는 GROUP BY 절을 포함하는 경우
CREATE OR REPLACE VIEW VW_GROUPDEPT
AS SELECT DEPT_CODE, SUM(SALARY) "합계", FLOOR(AVG(SALARY)) "평균"
     FROM EMPLOYEE
 GROUP BY DEPT_CODE;

SELECT * FROM VW_GROUPDEPT; -- 논리적인 테이블
SELECT * FROM EMPLOYEE;     -- 베이스 테이블

-- INSERT (에러)
INSERT INTO VW_GROUPDEPT VALUES('D3', 8000000, 4000000);
-- 오류발생 : virtual column not allowed here
-- 합계, 평균은 EMPLOYEE테이블에 존재하지 않기 때문에 오류발생

-- UPDATE (에러)
UPDATE VW_GROUPDEPT
  SET 합계 = 8000000
 WHERE DEPT_CODE = 'D1';
-- 오류발생 : data manipulation operation not legal on this view
-- 합계 컬럼에 대해서는 실제 값들을 전부 합친값이다보니 해당데이터의 값을 수정할 수 없다. 

-- DELETE (에러)
DELETE FROM VW_GROUPDEPT
WHERE 합계 = 5210000;
-- 오류발생 : data manipulation operation not legal on this view
-- 이미 그룹이 지어진 내용이기 때문에 조작불가

-- 5) DISTINCT 구문이 포함된 경우
CREATE OR REPLACE VIEW VW_DT_JOB
AS SELECT DISTINCT JOB_CODE
     FROM EMPLOYEE;
     
SELECT * FROM VW_DT_JOB; -- 논리적인 테이블
SELECT * FROM EMPLOYEE;  -- 베이스테이블

-- INSERT (에러) 
INSERT INTO VW_DT_JOB VALUES('J8');
-- 오류발생 : data manipulation operation not legal on this view
-- JOB_CODE 컬럼은 중복제거를 한 결과이기 때문에 불가

-- UPDATE (에러)
UPDATE VW_DT_JOB 
   SET JOB_CODE = 'J8'
 WHERE JOB_CODE = 'J7';
-- 오류발생 : data manipulation operation not legal on this view

-- DELETE (에러)
DELETE
  FROM VW_DT_JOB
 WHERE JOB_CODE = 'J4';
-- 오류발생 : data manipulation operation not legal on this view

-- 6) JOIN을 이용해서 여러 테이블을 연결시켜놓은 경우
CREATE OR REPLACE VIEW VW_JOINEMP
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE
     FROM EMPLOYEE
     JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);
    
SELECT * FROM VW_JOINEMP; -- 논리적인 테이블

-- INSERT (에러)
INSERT INTO VW_JOINEMP VALUES(300, '조세오', '총무부');
-- 오류발생 : "cannot modify more than one base table through a join view"
-- DEPT_TITLE은 EMPLOYEE테이블에 존재하지 않기 때문에 오류발생

-- UPDATE 
UPDATE VW_JOINEMP
   SET EMP_NAME = '서동일'
 WHERE EMP_ID = '200';
 
UPDATE VW_JOINEMP
   SET DEPT_TITLE = '회계부'
 WHERE EMP_ID = 200;
 -- 오류발생 : cannot modify a column which maps to a non key-preserved table
 
-- DELETE (성공)
DELETE FROM VW_JOINEMP
WHERE EMP_ID = 200;
 
SELECT * FROM EMPLOYEE;

ROLLBACK;

---------------------------------------------------------------------------------------

/*
    * VIEW 옵션
    
    [상세표현식]
    CREATE [OR REPLACE] [FORCE|"NOFORCE"] VIEW 뷰명
    AS 서브쿼리
    [WITH CHECK OPTION]
    [WITH READ ONLY];
    
    1) OR REPLACE : 기존에 동일한 뷰가 있을 경우 갱신시키고, 존재하지 않으면 새로 생성하는 옵션
    2) FORCE | NOFORCE 
        > FORCE   : 서브쿼리에 기술된 테이블이 존재하지 않아도 뷰가 생성되게 하는 옵션
        > NOFORCE : 서브쿼리에 기술된 테이블이 존재하는 테이블이여야만 뷰가 생성되게 하는 옵션
    3) WITH CHECK OPTION : DML 시 서브쿼리에 기술된 조건에 부합한 값으로만 DML 가능하도록 하는 옵션
    4) WITH READ ONLY : 뷰에 대해 조회만 가능 (DML문 수행불가)
*/


-- 2) FORCE | NOFORCE
--    NOFORCE : 서브쿼리에 기술된 테이블이 존재하는 테이블이여야만 뷰가 생성되게 하는 옵션
CREATE OR REPLACE /*NOFORCE*/VIEW VW_EMP
AS SELECT TCODE, TNAME, TCONTENT
     FROM TT;
-- 오류발생 : table or view does not exist

--  FORCE : 서브쿼리에 기술된 테이블이 존재하지 않아도 뷰가 생성되게 하는 옵션
CREATE OR REPLACE FORCE VIEW VW_EMP
AS SELECT TCODE, TNAME, TCONTENT
     FROM TT;
     
SELECT * FROM VW_EMP;

-- TT테이블을 생성해야만 그때부터 VIEW 활용 가능
CREATE TABLE TT(
    TCODE NUMBER,
    TNAME VARCHAR2(20),
    TCON
);

-- 3)  WITH CHECK OPTION : DML 시 서브쿼리에 기술된 조건에 부합한 값으로만 DML 가능하도록 하는 옵션
--                         서브쿼리에 기술된 조건에 부합하지 않는 값으로 수정 시 오류 발생

-- WITH CHECK OPTION 안쓰고
CREATE OR REPLACE VIEW VW_EMP
AS SELECT *
     FROM EMPLOYEE
    WHERE SALARY >= 3000000;
    
SELECT * FROM VW_EMP; -- 9명 조회

-- 200번 사원의 급여를 200만원으로 변경 (서브쿼리의 조건에 부합되지 않는 값으로 변경시도) => 잘 변경된다.
UPDATE VW_EMP
   SET SALARY = 2000000
 WHERE EMP_ID = 200;
 
SELECT * FROM EMPLOYEE;

ROLLBACK;

-- WITH CHECK OPTION 쓰고
CREATE OR REPLACE VIEW VW_EMP
AS SELECT *
     FROM EMPLOYEE
    WHERE SALARY >= 3000000
WITH CHECK OPTION;

SELECT * FROM VW_EMP; -- 9명 조회

-- 200번 사원의 급여를 200만원으로 변경
UPDATE VW_EMP
   SET SALARY = 2000000
 WHERE EMP_ID = 200;
-- 오류발생 : view WITH CHECK OPTION where-clause violation
-- 뷰를 생성할 때 해당 뷰는 300만원 이상인 급여만 들어가도록 설정되어 있기 때문에 오류 발생
-- 서브쿼리에 기술된 조건에 부합되지 않기 때문에 변경 불가

-- 200번 사원의 급여를 400만원으로 변경
UPDATE VW_EMP
   SET SALARY = 4000000
 WHERE EMP_ID = 200;
-- 서브쿼리의 기술한 조건에 부합하기 때문에 문제없이 수정된다.

SELECT * FROM EMPLOYEE;

ROLLBACK;

-- 4) WITH READ ONLY : 뷰에 대해 조회만 가능 (DML문 수행불가)
CREATE OR REPLACE VIEW VW_EMP
AS SELECT EMP_ID, EMP_NAME, BONUS
     FROM EMPLOYEE
    WHERE BONUS IS NOT NULL;
    
SELECT * FROM VW_EMP;

-- 사번이 200번인 사원 데이터 삭제
DELETE FROM VW_EMP
WHERE EMP_ID = 200;
-- 오류발생 : cannot perform a DML operation on a read-only view
-- 해당뷰는 조회만 가능하게 만들어졌기 때문에 DML조작이 불가능하다는 오류 발생