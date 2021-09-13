/*
    < SELECT > - DQL(DATA QUERY LANGUAGUE)
    데이터를 조회할 때 사용되는 구문
    
    >> RESULT SET : SELECT문을 통해 조회된 결과물 (즉, 조회된 행들의 집합을 의미)
    
    [표현법]
    SELECT 조회하고자하는컬럼, 컬럼, 컬럼, ... 
    FROM 테이블명;
    
    실제 데이터들이 담긴 공간은 '테이블'인데, 어떤 공간으로부터 조회할건지 테이블명을 작성해줘야한다.
    컬럼은 반드시 해당 테이블에 존재하는 컬럼이어야한다.
*/

-- EMPLOYEE 테이블에 모든 컬럼 조회 (모든 데이터 조회)
SELECT *
FROM EMPLOYEE;    --테이블로부터 존재하는 모든 칼럼을 조회하고자 할때

-- EMPLOYEE 테이블에 사번, 이름, 급여만을 조회 (특정 컬럼 조회)
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE;

-- JOB 테이블에 모든 컬럼 조회
SELECT *
FROM JOB;

----------------------- 실습문제 --------------------------
-- 1. JOB 테이블의 직급명 컬럼만 조회
SELECT JOB_NAME
FROM JOB;
-- 2. DEPARTMENT 테이블의 모든 컬럼 조회
SELECT *
FROM DEPARTMENT;
-- 3. DEPARTMENT 테이블의 부서코드, 부서명만 조회
SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT;
-- 4. EMPLOYEE  테이블의 사원명, 이메일, 전화번호, 입사일, 급여 조회
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE, SALARY
FROM EMPLOYEE;
-----------------------------------------------------------

/*
    < 컬럼값을 통한 산술연산 >
    SELECT 절 컬럼명 작성부분에 산술연산 기술 가능 (이때 산술연산된 결과 조회)
*/
-- EMPLOYEE에 사원명, 사원의 연봉(급여*12) 조회
SELECT EMP_NAME, SALARY*12
FROM EMPLOYEE;

-- EMPLOYEE에 사원명, 급여, 보너스, 연봉, 보너스가포함된연봉((급여+보너스*급여)*12) 조회
SELECT EMP_NAME, SALARY, BONUS, SALARY*12, (SALARY+BONUS*SALARY)*12
FROM EMPLOYEE;
--> 산술연산 과정 중 NULL값이 존재할 경우 산술연산한 결과값 마저도 무조건 MULL값으로 나옴!

-- EMPLOYEE에 사원명, 입사일, 근무일수(오늘날짜 - 입사일)
-- DATE형식끼리도 연산이 가능!
-- * 오늘날짜 : SYSDATE
SELECT EMP_NAME, HIRE_DATE, SYSDATE-HIRE_DATE 
FROM EMPLOYEE;
-- DATE - DATE : 결과값은 일 단위가 맞음!
-- 단, 값이 지저분한 이유는 DATE형식은 년/월/일/시/분/초 단위로 시간정보까지도 관리를 하기 때문

-------------------------------------------------------------------------------------

/*
    < 컬럼명에 별칭 지정하기 >
    산술연산을 하게 되면 컬럼명 지저분함... 이때 컬럼명으로 별칭 부여해서 깔끔하게 보여줄 수 있음
    
    [표현법]
    컬럼명 별칭 / 컬럼명 AS 별칭 / 컬럼명 "별칭" / 컬렴명 AS "별칭"
    
    AS 붙이든 안붙이든간에 부여하고자 하는 별칭에 띄어쓰기 혹은 특수문자가 포함될 경우 반드시 더블쿼테이션("")로 기술해야됨!
*/
SELECT EMP_NAME 사원명, SALARY AS 급여, SALARY*12 "연봉(원)", (SALARY + BONUS*SALARY)*12 AS "총 소득"
FROM EMPLOYEE;

--------------------------------------------------------------------------------------

/*
    < 리터럴 >
    임의로 지정한 문자열('')
    
    SELECT 절에 리터럴을 제시하면 마치 테이블상에 존재하는 데이터처럼 조회 가능
    조회된 RESULT SET의 모든 행에 반복적으로 같이 출력
*/
-- EMPLOYEE에 사번, 사원명, 급여 조회
SELECT EMP_ID, EMP_NAME, SALARY, '원' AS 단위
FROM EMPLOYEE;

