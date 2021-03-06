/*
    < JONIN >
    두 개 이상의 테이블에서 데이터를 조회하고자 할 때 사용되는 구문
    조회 결과는 하나의 결과물(RESULT SET)로 나옴
    
    관계형 데이터베이스는 최소한의 데이터로 각각의 테이블에 담고 있음 (중복을 최소화하기 위해 최대한 쪼개서 관리함)
    
    => 관계형 데이터베이스에서 SQL문을 이용한 테이블간 "관계"를 맺는 방법
    (무작정 다 조회를 해오는게 아니라 각 테이블간 연결고리로써의 데이터를 매칭시켜서 조회해야됨!!)
    
    JOIN은 크게 "오라클전용구문"과 "ANSI구문"으로 분류 (ANSI == 미국국립표준협회)
    
    
                                   [JOIN 용어 정리]
                 오라클전용구문            |                      ANSI구문                   
-------------------------------------------------------------------------------------------------------
                 등가 조인                |      내부 조인(INNER JOIN)  => JOIN USING / ON      
                (EQUAL JOIN)             |      자연 조인(NATURAL JOIN) => JOIN USING
-------------------------------------------------------------------------------------------------------
                 포괄 조인                |           왼쪽 외부 조인 (LEFT OUTER JOIN)
                (LEFT OUTER)             |         오른쪽 외부 조인 (RIGHT OUTER JOIN)
               (RIGHT OUTER)             |           전체 외부 조인 (FULL OUTER JOIN)
--------------------------------------------------------------------------------------------------------
             자체 조인(SELF JOIN)         |                     JOIN ON
         비등가 조인(NON EQUAL JOIN)      |
--------------------------------------------------------------------------------------------------------
         카테시안 곱(CARTESIAN PRODUCT)   |                  교차 조인 (CROSS JOIN) 
                       
                       
*/

-- 전체 사원들의 사번, 사원명, 부서코드(EMPLOYEE테이블), 부서명(DEPARTMENT테이블)을 조회하고자 할 때 
SELECT EMP_ID, EMP_NAME, DEPT_CODE 
FROM EMPLOYEE;

SELECT DEPT_ID,DEPT_TITLE
FROM DEPARTMENT;

-- 전체 사원들의 사번, 사원명, 직급코드, 직급명 조회하고자 할 때
SELECT EMP_ID, EMP_NAME, JOB_CODE
FROM EMPLOYEE;

SELECT JOB_CODE, JOB_NAME
FROM JOB;

/*
    1. 등가 조인(EQUAL JOIN) / 내부 조인(INNER JOIN) => JOIN USING/ON
       연결시키는 컬럼의 값이 일치하는 행들만 조인되서 조회 ( => 일치하는 값이 없는 행은 조회에서 제외)
*/
-- >> 오라클 전용 구문
--    FROM절에 조회하고자 하는 테이블들을 나열 (, 구분자로)
--    WHERE절에 매칭시킬 칼럼(연결고리)에 대한 조건을 제시함

-- 1) 연결할 두 컬럼명이 다른 경우 (EMPLOYEE : DEPT_CODE / DEPARTMENT : DEPT_ID)
--    사번, 사원명, 부서코드, 부서명을 하나의 결과물로 같이 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;
--> 일치하는 값이 없는 행은 조회에서 제외된 것 확인 가능!
-- EMPLYEE 테이블에 DEPT_CODE가 NULL인 사원은 조회X, DEPARTMENT 테이블에 DEPT_ID가 D3, D4, D7 조회X

-- 2) 연결할 두 컬럼명이 같은 경우 (EMPLOYEE : JOB_CODE / JOB : JOB_CODE)
--    사번, 사원명, 직급코드, 직급명을 하나의 결과물로 같이 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE, JOB
WHERE JOB_CODE = JOB_CODE;
-- ambiguously : 애매하다, 모호하다 => 컬럼명이 똑같기 때문

-- 해결방법 1) 테이블명을 이용하는 방법
SELECT EMP_ID, EMP_NAME, EMPLOYEE.JOB_CODE, JOB_NAME
FROM EMPLOYEE, JOB
WHERE EMPLOYEE.JOB_CODE = JOB.JOB_CODE;

-- 해결방법 2) 테이블에 별칭을 부여해서 이용하는 방법
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE;

-->> ANSI 구문
--   FROM절에 기준이 되는 테이블을 하나 기술 한 후 
--   JOIN절에 같이 조회하고자하는 테이블 기술 + 매칭시킬 컬럼에 대한 조건 기술
--   JOIN USING, JOIN ON

-- 1) 연결할 두 컬럼명이 다른 경우 (EMPLOYEE : DEPT_CODE / DEPARTMENT : DEPT_ID)
--    오로지 JOIN ON구문으로만 작성 가능!!
--    사번, 사원명, 부서코드, 부서명을 하나의 결과물로 같이 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

-- 2) 연결할 두 컬럼명이 같은 경우 (EMPLOYEE : JOB_CODE / JOB : JOB_CODE)
--    JOIN ON, JOIN USING 구문 사용 가능!
--    사번, 사원명, 직급코드, 직급명을 하나의 결과물로 같이 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
JOIN JOB ON (JOB_CODE = JOB_CODE);

-- 해결방법1) 테이블명 또는 별칭을 이용해서 하는 방법
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E
/*INNER*/JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE);

-- 해결방법2) JOIN USING 구문 사용하는 방법 (두 컬럼명이 일치할때만 사용가능)
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE 
/*INNER*/JOIN JOB USING (JOB_CODE);

---- [참고사항] ----
-- 자연조인(NATURAL JOIN) : 각 테이블마다 동일한 컬럼이 한 개만 존재할 경우
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
NATURAL JOIN JOB;

-- 추가적인 조건도 당연히 제시 가능하다.
-- 직급이 대리인 사원의 사번, 이름, 직급명, 급여 조회
-->> 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE AND JOB_NAME = '대리';

--> ANSI 구문
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리';

------------------------------------실습문제--------------------------------------
-- 1. 부서가 인사관리부인 사원들의 사번, 이름, 보너스 조회
-- EMPLOYEE : DEPT_CODE / DEPARTMENT : DEPT_ID
-->> 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID 
  AND DEPT_TITLE = '인사관리부'; --> SELECT절에 DEPARTMENT테이블에 조회할게 딱히 없는데 JOIN해야하는 이유? WHERE절에 부서명이 인사관리부를 제시해야하기 때문에 
                                                        --  각각의 사원들마다 어떤 부서명을 가지고 있는지 JOIN해서 알아내야한다!
-->> ANSI 구문
SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE = '인사관리부';

-- 2. DEPARTMENT테이블과 LOCATION테이블을 참고해서 전체 부서의 부서코드, 부서명, 지역코드, 지역명 조회
-- DEPARTMENT : LOCATION_ID, LOCATION : LOCAL_CODE
--> 오라클 전용 구문
SELECT DEPT_ID, DEPT_TITLE, LOCAL_CODE, LOCAL_NAME
FROM DEPARTMENT, LOCATION
WHERE LOCATION_ID = LOCAL_CODE;
--> ANSI 구문
SELECT DEPT_ID, DEPT_TITLE, LOCAL_CODE, LOCAL_NAME
FROM DEPARTMENT
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);

-- 3. 보너스를 받는 사원들의 사번, 사원명, 보너스, 부서명 조회
-- EMPLOYEE : DEPT_CODE , DEPARTMENT : DEPT_ID
--> 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID 
  AND BONUS IS NOT NULL;
--> ANSI 구문
SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE BONUS IS NOT NULL;

-- 4. 부서가 총무부가 아닌 사원들의 사원명, 급여 조회
-- EMPLOYEE : DEPT_CODE , DEPARTMENT : DEPT_ID
--> 오라클 전용 구문
SELECT EMP_NAME, SALARY
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID
  AND DEPT_TITLE != '총무부';
--> ANSI 구문
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE NOT DEPT_TITLE = '총무부';
---------------------------------------------------------------------------------------------

/*
    2. 포괄 조인 / 외부 조인 (OUTER JOIN)
    두 테이블간의 JOIN시 일치하지 않는 행도 포함시켜서 조회 가능
    단, 반드시 LEFT/RIGHT를 지정해야됨!! (기준이 되는 테이블 지정)
*/

-- 외부조인과 비교할반한 INNER JOIN 조회해두기!
-- 사원명, 부서명, 급여, 연봉 조회
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
-- 부서 배치가 아직 안된 사원 2명에 대한 정보는 조회X
-- 부서에 배정된 사원이 없는 부서도 조회 X

-- 1) LEFT [OUTER] JOIN : 두 테이블 중 왼편에 기술된 테이블을 기준으로 
-->>  ANSI구문
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
-- 부서 배치를 받지 않았던 2명의 사원 정보도 조회됨

-->> 오라클 전용 구문
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+); -- 기준으로 삼고자하는 테이블의 반대편 테이블의 컬럼 뒤에 (+) 붙이기

-- 2) RIGHT [OUTER] JOIN : 두 테이블 중 오른편에 기술된 테이블을 기준으로 JOIN
-->> ANSI 구문
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
RIGHT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

-->> 오라클 전용 구문
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID;

-- 3) FULL [OUTER] JOIN : 두 테이블이 가진 모든 행을 조회할 수 있음 (단, 오라클전용구문으로는 불가)
-->> ANSI구문
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
FULL JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

------------------------------------------------------------------------------------------

/*
    3. 비등가 조인 (NON EQUAL JOIN)
    매칭시킬 컬럼에 대한 조건 작성 시 '='(등호)를 사용하지 않는 조인문
    ANSI구문으로는 JOIN ON으로만 사용가능!
*/
SELECT EMP_NAME, SALARY   -- SALARY
FROM EMPLOYEE;

SELECT SAL_LEVEL, MIN_SAL, MAX_SAL -- MIN_SAL, MAX_SAL
FROM SAL_GRADE;

-- 사원명, 급여, 급여레벨 조회
-->> 오라클 구문
SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE, SAL_GRADE
--WHERE SALARY >= MIN_SAL AND SALARY <= MAX_SAL;
WHERE SALARY BETWEEN MIN_SAL AND MAX_SAL;

-->> ANSI구문
SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE
JOIN SAL_GRADE ON (SALARY BETWEEN MIN_SAL AND MAX_SAL);

-----------------------------------------------------------------------------------------

/*
    4. 자체 조인 (SELF JOIN)
    같은 테이블을 다시 한번 조인하는 경우
*/
SELECT * FROM EMPLOYEE;

-- 전체 사원의 사원사번, 사원명, 사원부서코드   => EMPLOYEE E
--            사수사번, 사수명, 사수부서코드  => EMPLOYEE M
--> 오라클 전용 구문
SELECT E.EMP_ID "사원사번", E.EMP_NAME "사원명", E.DEPT_CODE "사원부서코드",
       M.EMP_ID "사수사번", M.EMP_NAME "사수명", M.DEPT_CODE "사수부서코드"
FROM EMPLOYEE E, EMPLOYEE M
WHERE E.MANAGER_ID = M.EMP_ID;

-->> ANSI구문
SELECT E.EMP_ID "사원사번", E.EMP_NAME "사원명", E.DEPT_CODE "사원부서코드",
       M.EMP_ID "사수사번", M.EMP_NAME "사수명", M.DEPT_CODE "사수부서코드"
FROM EMPLOYEE E
JOIN EMPLOYEE M ON (E.MANAGER_ID = M.EMP_ID);

--------------------------------------------------------------------------------------
/*
    < 다중 JOIN >
    2개 이상의 테이블을 가지고 JOIN할 때 
*/

-- 사번, 사원명, 부서명, 직급명 조회
SELECT * FROM EMPLOYEE;   -- DEPT_CODE   JOB_CODE
SELECT * FROM DEPARTMENT; -- DEPT_ID
SELECT * FROM JOB;        --             JOB_CODE

--> 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E, DEPARTMENT, JOB J
WHERE DEPT_CODE = DEPT_ID 
  AND E.JOB_CODE = J.JOB_CODE;

--> ANSI 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE); -- 매칭시킬 컬럼명이 동일하기 때문에 JOB USING 사용 가능


-- 사번, 사원명, 부서명, 지역명 조회
SELECT * FROM EMPLOYEE;           -- DEPT_CODE
SELECT * FROM DEPARTMENT;         -- DEPT_ID        LOCATION_ID
SELECT * FROM LOCATION;           --                LOCAL_CODE

--> 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE, DEPARTMENT, LOCATION
WHERE DEPT_CODE = DEPT_ID AND LOCATION_ID = LOCAL_CODE;

--> ANSI 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);
-- ANSI구문에서는 다중 조인 순서 중요!

-------------------------------------------실습문제------------------------------------------
-- 1. 사번, 사원명, 부서명, 지역명, 국가명 조회 (EMPLOYEE, DEPARTMENT, LOCATION, NATIONAL 조인)
-- EMPLOYEE    : DEPT_CODE
-- DEPARTMENT  : DEPT_ID      LOCATION_ID
-- LOCATION    :              LOCAL_CODE     NATIONAL_CODE
-- NATIONAL    :                             NATIONAL_CODE

-->> 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE E, DEPARTMENT D, LOCATION L, NATIONAL N
WHERE E.DEPT_CODE = D.DEPT_ID 
  AND D.LOCATION_ID = L.LOCAL_CODE
  AND L.NATIONAL_CODE = N.NATIONAL_CODE;

-->> ANSI 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE);

-- 2. 사번, 사원명, 부서명, 직급명, 지역명, 국가명, 급여등급 조회 (모든 테이블 다 조인)
-- EMPLOYEE    :  DEPT_CODE     JOB_CODE                                       SALARY
-- DEPARTMENT  :  DEPT_ ID                    LOCATION_ID
-- JOB         :                JOB_CODE
-- LOCATION    :                             LOCAL_CODE     NATIONAL_CODE
-- NATIONAL    :                                            NATIONAL_CODE
-- SAL_GRADE   :                                                               SAL_LEVEL
-->> 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, LOCAL_NAME, NATIONAL_NAME, SAL_LEVEL
FROM EMPLOYEE E, DEPARTMENT D, JOB J, LOCATION L, NATIONAL N, SAL_GRADE S
WHERE E.DEPT_CODE = D.DEPT_ID
  AND E.JOB_CODE = J.JOB_CODE
  AND D.LOCATION_ID = L.LOCAL_CODE
  AND L.NATIONAL_CODE = N.NATIONAL_CODE
  AND E.SALARY BETWEEN S.MIN_SAL AND S.MAX_SAL;


-->>  ANSI 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, LOCAL_NAME, NATIONAL_NAME, SAL_LEVEL
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (DEPT_CODE = DEPT_ID)
JOIN JOB J USING (JOB_CODE)
JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
JOIN NATIONAL N USING (NATIONAL_CODE)
JOIN SAL_GRADE S ON (E.SALARY BETWEEN S.MIN_SAL AND S.MAX_SAL);