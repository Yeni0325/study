/*
    < GROUP BY 절 >
    그룹기준을 제시할 수 있는 구문 (해당 그룹기분별로 여러 그룹을 묶을 수 있음)
    여러개의 값들을 하나의 그룹으로 묶어서 처리할 목적으로 사용한다.
*/
SELECT SUM(SALARY) 
FROM EMPLOYEE; --> 전체 사원을 하나의 그룹으로 묶어서 총합을 구한 결과

-- EMPLOYEE에서 각 부서별 급여의 총합 조회
SELECT DEPT_CODE, SUM(SALARY) -- 예외적으로 DEPT_CODE를 GROUP BY절에 사용했기 때문에 SELECT절에 GROUP BY절에 사용된 컬럼인 DEPT_CODE를 작성 가능하다.
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- EMPLOYEE에 각 부서별 사원 수 조회
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- EMPLOYEE에 각 부서별 사원 수와 해당 부서별 급여 조회
SELECT DEPT_CODE, COUNT(*), SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 실행순서
SELECT DEPT_CODE, SUM(SALARY)    -- 3
FROM EMPLOYEE                    -- 1 (FROM절이 항상 제일 먼저 실행)
GROUP BY DEPT_CODE               -- 2
ORDER BY DEPT_CODE;              -- 4 (ORDER BY절이 항상 SELECT절의 맨 마지막에 실행)
-- 오름차순 정렬 (NULL 뒤쪽 배치)

-- EMPLOYEE에 중복값을 제거한 후 각 직급별 조회
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

-- EMPLOYEE에 각 직급별로 그룹을 묶은 후 사원 수와 급여 합 조회
SELECT JOB_CODE, COUNT(*), SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

-- EMPLOYEE에 각 직급별로 총 사원수, 보너스를 받는 사원 수, 급여 합, 평균급여, 최저급여, 최대급여 조회
SELECT JOB_CODE, COUNT(*) "총 사원수", COUNT(BONUS) "보너스를 받는 사원수", 
       SUM(SALARY) "총 급여 합", FLOOR(AVG(SALARY)) "평균급여", 
       MIN(SALARY) "최저급여", MAX(SALARY) "최대급여"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE; -- 1이라고 해도 동일하게 정렬됨

-- EMPLOYEE에 각 부서별로 총 사원수, 보너스를 받는 사원 수, 급여 합, 평균급여, 최저급여, 최대급여 조회
SELECT DEPT_CODE, COUNT(*) "총 사원수", COUNT(BONUS) "보너스를 받는 사원수", 
       SUM(SALARY) "총 급여 합", FLOOR(AVG(SALARY)) "평균급여", 
       MIN(SALARY) "최저급여", MAX(SALARY) "최대급여"
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE; -- 1이라고 해도 동일하게 정렬됨

-- GROUP BY 절에 함수식 기술 가능!
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여'), COUNT(*)
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO, 8, 1);

-- GROUP BY 절에 여러개의 컬럼 기술 가능!
-- DEPT_CODE와 JOB_CODE가 같은 사원의 수와 급여 합 조회
SELECT DEPT_CODE, JOB_CODE, COUNT(*), SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE;

------------------------------------------------------------------------------------------
/*
    < HAVING 절 >
    그룹에 대한 조건을 제시할 때 사용되는 구문 (주로 그룹함수식을 가지고 조건을 제시할 때 사용)
*/

-- EMPLOYEE에 각 부서별 평균 급여 조회 (부서코드, 평균급여)
SELECT DEPT_CODE, FLOOR(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 각 부서별 평균 급여가 300만원 이상인 부서들만 조회
SELECT DEPT_CODE, FLOOR(AVG(SALARY))
FROM EMPLOYEE 
WHERE AVG(SALARY) >= 3000000 -- 오류 발생 (그룹함수가지고 조건제시시 WHERE절에서는 안됨!)
GROUP BY DEPT_CODE;

SELECT DEPT_CODE, ROUND(AVG(SALARY))  -- 4
FROM EMPLOYEE                         -- 1
GROUP BY DEPT_CODE                    -- 2
HAVING AVG(SALARY) >= 3000000;        -- 3

-- 직급별 총 급여합 (단, 직급별 급여합이 1000만원 이상인 직급만을 조회) 직급코드, 급여합 조회
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING  SUM(SALARY) >= 10000000;

-- 부서별로 보너스를 받는 사원이 없는 부서만을 조회 부서코드만 조회
SELECT DEPT_CODE
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0;

-----------------------------------------------------------------------------------------
/*
    < SELECT문 실행순서 >
    5 : SELECT     * | 조회하고자하는 컬럼 AS 별칭 | 산술식 "별칭" | 함수식 AS "별칭"
    1 : FROM       조회하고자하는 테이블명
    2 : WHERE      조건식 (연산자들 가지고 기술)
    3 : GROUP BY   그룹기준으로 삼을 컬럼 | 함수식
    4 : HAVING     조건식 (그룹함수를 가지고 기술)
    6 : ORDER BY   컬럼 | 별칭 | 컬럼순번 [ASC|DESC] [NULLS FIRST | NULLS LAST]
    
*/

-------------------------------------------------------------------------------------------

/*
    < 집계 함수 >
    그룹별 산출된 결과 값에 중간집계를 계산해주는 함수
    
    ROLLUP, CUBE
    
    => GROUP BY 절에 기술하는 함수
*/

-- 각 직급별 급여합
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

-- 마지막 행으로 전체 총 급여합까지 같이 조회하고자 할 때
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(JOB_CODE)
ORDER BY JOB_CODE;

SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(JOB_CODE)
ORDER BY JOB_CODE;
-- 그룹기준의 컬럼이 하나일 때는 CUBE, ROLLUP의 차이점이 딱히 없음!

-- 두 차이점을 보고자 한다면 그룹기준의 컬럼이 두개는 있어야함!
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE
ORDER BY DEPT_CODE;

-- ROLL UP(컬럼1, 컬럼2) : 컬럼1을 가지고 다시 중간집계를 내는 함수
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE)
ORDER BY DEPT_CODE;

-- CUBE(컬럼1, 컬럼2) : 컬럼1을 가지고 중간집계도 내고, 컬럼2를 가지고 중간집계를 냄
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE)
ORDER BY DEPT_CODE;

---------------------------------------------------------------------------------------------

/*
    < 집합 연산자 == SET OPERATION >
    
    여러개의 쿼리문을 가지고 하나의 쿼리문으로 만드는 연산자
    
    - UNION      : OR연산으로 대체 가능  | 합집합 (두 쿼리문 수행한 결과값을 더한 후 중복되는 값은 한번만 더해지도록)
    - INTERSECT  : AND연산으로 대체 가능 | 교집합 (두 쿼리문 수행한 결과값의 중복된 결과값)
    - UNION ALL  : 합집합 + 교집합 (두 쿼리문 수행한 결과값을 더하되, 중복값이 두번 표현된다)
    - MINUS      : 차집합 (선행 결과값에서 후행 결과값을 뺀 나머지) 
*/
-- 1. UNION
-- 부서코드가 D5인 사원 또는 급여가 300만원 초과인 사원들 조회 (사번, 이름, 부서코드, 급여)

-- 부서코드가 D5인 사원들만 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'; -- 6개 행 (박나라, 하이유, 김해술, "심봉선", 윤은해, "대북혼")

-- 급여가 300만원 초과인 사원들만 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000; -- 8개 행 (선동일, 송중기, 노옹철, 유재식, "심봉선", "대북혼", 전지연)

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' -- 6개
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000; -- 8개
--> 12개 행

-- 위의 쿼리문 대신 아래처럼 WHERE절에 OR써도 해결가능!!!
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR SALARY > 3000000;

-- 2. INTERSECT (교집합)
-- 부서코드가 D5이면서 급여까지도 300만원 초과인 사원 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- 위의 쿼리문 대신 아래처럼 WHERE절에 AND써도 해결가능!!!
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' AND SALARY > 3000000;

----------------------------------------------------------------------------------------------
-- 집합연산자 사용 시 유의사항
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' -- 6개
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE SALARY > 3000000;
-- 각 쿼리문의 SELECT절에 작성되어있는 컬럼 갯수 동일해야됨!!

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' -- 6개
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY > 3000000;
-- 컬럼 갯수 뿐만 아니라 각 컬럼자리마다 동일한 타입으로 기술해야함!!


SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' -- 6개
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000
ORDER BY EMP_NAME;
-- ORDER BY 절을 붙이고자 한다면 마지막에 기술해야함!!
--------------------------------------------------------------------------------------------

-- 3. UNION ALL (합집합 + 교집합)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' -- 6개
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000; -- 8개
-- 14개 행 조회

-- 4. MINUS (차집합)
-- 부서코드가 D5인 사원들 중 급여가 300만원 초과인 사원을 제외해서 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' -- 선행SELECT문
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000; -- 후행 SELECT문

-- 아래처럼도 가능하긴 함!!
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' AND SALARY <= 3000000;
