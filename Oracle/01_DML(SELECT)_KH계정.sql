/*
    < SELECT >
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

-- 현재 시스템 날짜 및 시간에 대해 조회
SELECT SYSDATE
FROM DUAL; -- 오라클에서 제공하는 가상테이블(더미테이블)! SYSDATE는 현재 시스템 시간을 알려주는 명령어기 때문에 별도로 포함된 테이블이 존재하지 않는다. 그래서 가상 테이블을 생성해준다!

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

select emp_id, emp_name, salary
from employee;
-- oracle의 키워드, 테이블명, 컬럼명 들은 대소문자를 가리지 않음!(정상적으로 실행)
-- 단, 실제 데이터값을 비교하는 상황에서는 대소문자를 가린다.

/*
    < 연결 연산자 : || >
    여러 컬럼값들을 마치 하나의 컬럼인것처럼 연결하거나, 컬럼값과 리터럴을 연결할 수 있음
    
    System.out.println("num : " + num); => 자바에서 하나의 문자열처럼 연결해서 출력했었는데 여기서의 "+" 느낌
*/

-- EMPLOYEE에 사번, 이름, 급여를 하나의 칼럼으로 조회
SELECT EMP_ID || EMP_NAME || SALARY
FROM EMPLOYEE;

-- 컬럼값이랑 리터럴 연결
-- "XXX의 월급은 XXX원 입니다."
SELECT EMP_NAME || '의 월급은 ' || SALARY || '원 입니다.' "급여 정보" 
FROM EMPLOYEE;
-- 오라클에서 문자와 문자열을 구분X, 문자(열) 제시시 ''를 사용한다.


---------------------------------------------------------------------------------------------

/*
    < DISTINCT >
    컬럼에 중복된 값들은 한번씩만 표시하고자 할 때 사용하는 키워드
*/
-- EMPLOYEE에 직급코드 조회
SELECT JOB_CODE
FROM EMPLOYEE;

-- EMPLOYEE에 직급코드 (중복제거) 조회
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE; -- 7행 조회

-- EMPLOYEE에 부서코드 (중복제거) 조회
SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

-- DISTINCT 유의사항 : DISTINCT는 SELECT절에 딱 한번만 기술 가능하다.
/* 구문오류 발생
SELECT DISTINCT JOB_CODE, DISTINCT DEPT_CODE
FROM EMPLOYEE;
*/

SELECT DISTINCT JOB_CODE, DEPT_CODE
FROM EMPLOYEE;
-- JOB_CODE값과 DEPT_CODE값을 쌍으로 묶어서 중복 판별

-- ============================================================================================

/*
    < WHERE 절 >
    조회하고자 하는 테이블로부터 특정 조건에 만족하는 데이터만을 조회하고자 할 때 사용
    이 때 WHERE절에 조건식을 제시하게됨
    조건식에서는 다양한 연산자들 사용가능!
    
    [표현법]
    SELECT  조회하고자하는컬럼, 컬럼, 산술연산, ...
    FROM 테이블명
    WHERE 조건식;
    
    >> 비교연산자 <<
    >, <, >=, <=    --> 대소비교
    =               --> 같은지 비교(자바에서는 동등비교시 '=='이었지만, 오라클에서는 '=')
    !=, ^=, <>      --> 같지 않은지 비교(자바에서는 같지 않은지 비교시, '!='이었지만, 오라클에서는 '!=', '^=', '<>"
*/

-- EMPLOYEE에서 부서코드가 'D9'인 사원들만 조회 (이 때, 모든 컬럼 조회)
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9'; --비교대상 컬럼 제시 --실제값인 문자열을 제시하므로 홑따옴표 ''에 값을 제시해야한다. ''에 제시하지 않을경우 컬럼으로 인식하게 된다.

-- EMPLOYEE에서 부서코드가 'D1'인 사원들의 사원명, 급여, 부서코드 조회
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1';

-- EMPLOYEE에서 부서코드가 'D1'이 아닌 사원들의 사번, 사원명, 부서코드 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
--WHERE DEPT_CODE != 'D1';
--WHERE DEPT_CODE ^= 'D1';
WHERE DEPT_CODE <> 'D1';

-- EMPLOYEE에서 급여가 400만원 이상인 사원들의 사원명, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 4000000;

-- EMPLOYEE에서 재직중인(ENT_YN 컬럼값이 'N'인) 사원들의 사번, 이름, 입사일 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE ENT_YN = 'N';

--------------------- 실습문제 ----------------------------
-- 1. EMPLOYEE에서 급여가 300만원 이상인 사원들의 사원명, 급여, 입사일, 연봉 조회
SELECT EMP_NAME "사원명", SALARY "급여", HIRE_DATE "입사일", SALARY*12 "연봉"
FROM EMPLOYEE
WHERE SALARY >= 3000000;
-- 2. EMPLOYEE에서 연봉이 5000만원 이상인 사원들의 사원명, 급여, 연봉, 부서코드 조회
SELECT EMP_NAME "사원명", SALARY "급여", SALARY*12 "연봉", DEPT_CODE "부서코드"
FROM EMPLOYEE
WHERE SALARY*12 >= 50000000;
-- WHERE 연봉 >= 50000000; -- 오류(WHERE절에서는 SELECT절에 작성된 별칭 사용불가!)

-- 실행순서 : FROM절 => WHERE절 => SELECT절
-- 내부적으로 FROM절이 먼저 실행이 되는데 FROM절의 모든 데이터를 가져온 후 매 행마다 WHERE절로 조건검사를 실행한다. 
-- WHERE절이 다 끝나면 조건에 만족되는 값들이 추려지는데 마지막에 실행되는게 SELECT절이다. 
-- 따라서 SELECT절이 실행되는 순간 그 떄 별칭이 부여되기 때문에 WHERE절이 실행되는 당시에는 별칭을 사용하지 못한다.


-- 3. EMPLOYEE에서 직급코드가 'J3'이 아닌 사원들의 사번, 사원명, 직급코드, 퇴사여부 조회
SELECT EMP_ID "사번", EMP_NAME "사원명", JOB_CODE "직급코드", ENT_YN "퇴사여부"
FROM EMPLOYEE
WHERE JOB_CODE != 'J3';

------------------------------------------------------------------------------------------------------------

/*
    < 논리 연산자 >
    여러개의 조건을 엮어서 제시하고자 할 때 사용
    
    AND (~이면서, 그리고)
    OR  (~이거나, 또는)
*/

-- EMPLOYEE에서 부서코드가 'D9'이면서 급여가 500만원 이상인 사원들의 사원명, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9' AND SALARY >= 5000000;

-- EMPLOYEE에서 부서코드가 'D6'이거나 급여가 300만원 이상인 사원들의 사원명, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' OR SALARY >= 3000000;

-- EMPLOYEE에서 급여가 350만원 이상 600만원 이하를 받는 사원들의 사원명, 사번, 급여 조회
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
-- WHERE SALARY 3500000 <= SALARY < 6000000; --> 합쳐서 연산은 불가 (오류 발생)
WHERE SALARY >= 3500000 AND SALARY <= 6000000;

----------------------------------------------------------------------------------------------

/*
    < BETWEEN AND >
    조건식에서 사용되는 구문
    몇 이상 몇 이하인 범위에 대한 조건을 제시할 때 사용되는 연산자 (몇 초과 몇 미만은 불가X)
    
    [표현법]
    비교대상컬럼 BETWEEN 하한값 AND 상한값
    => 해당 컬럼값이 하한값 이상이고 상한값 이하인 경우
*/

-- EMPLOYEE에서 급여가 350만원 이상 600만원 이하를 받는 사원들의 사원명, 사번, 급여 조회
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000; -- 6명

-- EMPLOYEE에서 급여가 350만원 미만 600만원 초과를 받는 사원들의 사원명, 사번, 급여 조회
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
--WHERE SALARY < 3500000 OR SALARY > 6000000;
--WHERE NOT SALARY BETWEEN 3500000 AND 6000000; 
WHERE SALARY NOT BETWEEN 3500000 AND 6000000;
-- NOT : 조건을 반대로 바꾸는 연산자, 컬럼명 앞에 혹은 BETWEEN앞에 위치할 수 있다.
-- 자바에서 논리부정연산자는 ! , 오라클에서의 논리부정연산자는 NOT

-- 입사일이 '90/01/01' ~ '01/01/01' 사원들 조회
SELECT *
FROM EMPLOYEE
--WHERE HIRE_DATE >= '90/01/01' AND HIRE_DATE <= '01/01/01'; -- DATE 형식 간 대소비교 가능!
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';

----------------------------------------------------------------------------------

/*
    < LIKE >
    비교하고자하는 컬럼값이 내가 제시한 특정 패턴에 "만족"할 경우 조회
    
    [표현법]
    비교대상컬럼 LIKE '특정패턴'
    
    - 특정패턴 제시 시 '%', '_'를 와일드 카드로 사용할 수 있음
    >> '%' : 0글자 이상
    EX) 비교대상컬럼 LIKE '문자%'  =>  비교대상의 컬럼값이 문자로 "시작"되는걸 조회
        비교대상컬럼 LIKE '%문자'  =>  비교대상의 컬럼값이 문자로 "끝"나는 걸 조회
        비교대상컬럼 LIKE '%문자%' =>  비교대상의 컬럼값에 문자가 "포함"되어있는 걸 조회
    
    >> '_' : 무조건 1글자
    EX) 비교대상칼럼 LIKE '_문자'  => 비교대상의 컬럼값에 문자 앞에 무조건 1글자가 올 경우 조회
        비교대상칼럼 LIKE '__문자' => 비교대상의 컬럼값에 문자 앞에 무조건 2글자가 올 경우 조회
        비교대상칼럼 LIKE '_문자_' => 비교대상의 컬럼값에 문자 앞과 뒤에 무조건 1글자씩 올 경우 조회
*/

-- 사원들 중 성이 전씨인 사원들의 사원명, 급여, 입사일 조회
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%';
-- WHERE EMP_NAME = '전%' -> 사원의 이름이 '전%'인 사람 조회

-- 사원들 이름 중 하 가 포함된 사원들의 사원명, 주민번호, 전화번호 조회
SELECT EMP_NAME, EMP_NO, PHONE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';

-- 사원들 이름 중 가운데 글자가 '하'인 사원들의 사원명, 전화번호 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '_하_';

-- 사원들 전화번호 중 세번째 자리가 '1'인 사원들의 사번, 사원명, 전화번호, 이메일 조회
-- 와일드카드 : _(1글자), %(0글자이상)
SELECT EMP_ID, EMP_NAME, PHONE, EMAIL
FROM EMPLOYEE
WHERE PHONE LIKE '__1%';

-- 사원들 이메일 중 앞글자가 3글자인 사원들의 사번, 이름, 이메일 조회
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '____%'; -- 원했던 결과 도출 못함
-- 와일드 카드로 사용되고 있는 문자와 컬럼값에 담긴 문자가 동일하기 때문에 제대로 조회 안됨
--> 어떤게 와일드 카드고 어떤게 데이터값인지 구분 지어야됨
--> 데이터값으로 취급하고자하는 값 앞에 나만의 와일드카드를 제시하고 나만의 와일드카드라고 등록(ESCAPE OPTION)해줘야한다.
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___$_%' ESCAPE '$';

-- 위의 사원들이 아닌 그 외의 사원들 조회
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE NOT EMAIL LIKE '___$_%' ESCAPE '$';
-- NOT은 컬럼명 앞 또는 LIKE 앞에 기입가능


---------------------------------실습문제----------------------------------
-- 1. EMPLOYEE에서 이름이 '연'으로 끝나는 사원들의 사원명, 입사일 조회
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';
-- 2. EMPLOYEE에서 전화번호 처음 3자리가 010이 아닌 사원들의 사원명, 전화번호 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE NOT PHONE LIKE '010%';
-- 3. EMPLOYEE에서 이름에 '하'가 포함되어 있고 급여가 240만원 이상인 사원들의 사원명, 급여 조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%' AND SALARY >= 2400000;
-- 4. DEPARTMENT에서 해외영업부인 부서들의 부서코드, 부서명 조회
SELECT DEPT_ID, DEPT_TITLE 
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '해외영업%';  

-----------------------------------------------------------------------------------------

/*
    < IS NULL / IS NOT NULL >
    컬럼값에 NULL이 있을 경우 NULL 비교에 사용되는 연산자
*/

-- 보너스를 받지 않는 사원(BONUS값이 NULL)들의 사번, 이름 , 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
--WHERE BONUS = NULL; -- 정상적으로 조회 안됨
WHERE BONUS IS NULL;

-- 보너스를 받는 사원(BONUS값이 NULL이 아닌)들의 사번, 이름 , 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
--WHERE BONUS != NULL; -- 정상적으로 조회 안됨
--WHERE BONUS IS NOT NULL; -- 정상적으로 조회됨
WHERE NOT BONUS IS NULL;
-- NOT은 컬럼명 앞 또는 IS뒤에 기입 가능

-- 사수가 없는 사원(MANAGER_ID값이 NULL)들의 사원명, 사수사번, 부서코드 조회
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL;

-- 부서배치를 아직 받지 않고 보너스는 받는 사원들의 이름, 보너스, 부서코드 조회
SELECT EMP_NAME, BONUS, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL AND BONUS IS NOT NULL;

------------------------------------------------------------------------------------

/*
    <IN>
    비교대상컬럼값이 내가 제시한 목록중에 일치하는 값이 있는지 
    
    [표현법]
    비교대상컬럼 IN ('값1', '값2', '값3', ...) => 비교할 값들이 여러개일 때 사용하면 좋음
*/

-- 부서코드가 D6이거나 D8이거나 D5인 부서원들의 이름, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
--WHERE DEPT_CODE = 'D6' OR DEPT_CODE = 'D8' OR DEPT_CODE = 'D5'; => 해당조건들 중 셋 중에 하나만 만족해도 조회가 된다
WHERE DEPT_CODE IN ('D6', 'D8', 'D5');

-- 그 외의 사원들
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE NOT DEPT_CODE IN ('D6', 'D8', 'D5');

--=================================================================================================================

/*
  < 연산자 우선순위 >
  0. ()
  1. 산술연산자 +, -, *, / 등
  2. 연결연산자  
  3. 비교연산자(대소비교, 동등비교)
  4. IS NULL / LIKE '특정패턴' / IN
  5. BETWEEN AND 
  6. NOT(논리연산자)
  7. AND(논리연산자)
  8. OR(논리연산자)
*/
-- ** OR보다 AND가 먼저 연산됨!!
-- 사원들 중 직급코드가 J7이거나 J2인 사원들 중 급여가 200만원 이상인 사원들의 모든 컬럼 조회
SELECT *
FROM EMPLOYEE
--WHERE JOB_CODE = 'J7' OR JOB_CODE = 'J2' AND SALARY >= 2000000; -- 제대로 조회가 안됨 -> J7과 J2면서 급여가 200만원 이상인 사원들의 정보 조회
WHERE (JOB_CODE = 'J7' OR JOB_CODE = 'J2') AND SALARY >= 2000000;

--------------------------------------실습문제-------------------------------------------------
-- 1. 사수가 없고 부서배치도 받지 않은 사원들의 (사원명, 사수사번, 부서코드) 조회
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL 
    AND DEPT_CODE IS NULL;
-- 2. 연봉(보너스포함X)이 3000만원 이상이고 보너스를 받지 않는 사원들의 (사번, 사원명, 급여, 보너스) 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE (SALARY*12)>=30000000 
    AND BONUS IS NULL;
-- 3. 입사일이 '95/01/01'이상이고 부서배치를 받은 사원들의 (사번, 사원명, 입사일, 부서코드) 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE, DEPT_CODE
FROM EMPLOYEE
WHERE HIRE_DATE>='95/01/01' 
    AND DEPT_CODE IS NOT NULL;
-- 4. 급여가 200만원 이상 500만원 이하고 입사일이 '01/01/01'이상이고 보너스를 받지 않는 사원들의 
--   (사번, 사원명, 급여, 입사일, 보너스) 조회
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE, BONUS
FROM EMPLOYEE
WHERE SALARY BETWEEN 2000000 AND 5000000  
    AND HIRE_DATE>='01/01/01' 
    AND BONUS IS NULL;
-- 5. 보너스포함연봉이 NULL이 아니고 이름에 '하'가 포함되어있는 사원들의 (사번, 사원명, 급여, 보너스포함연봉) 조회 (별칭부여)
SELECT EMP_ID, EMP_NAME, SALARY, (SALARY+BONUS*SALARY)*12 "보너스포함연봉"
FROM EMPLOYEE
WHERE (SALARY+BONUS*SALARY)*12 IS NOT NULL  
    AND EMP_NAME LIKE '%하%';

----------------------------------------------------------------------------------------------------------------
SELECT EMP_ID, EMP_NAME, SALARY    -- 3
FROM EMPLOYEE                      -- 1
WHERE DEPT_CODE IS NULL;           -- 2

--==============================================================================================================

/*
    < ORDER BY 절 >
    SELECT문의 가장 마지막 줄에 작성 될 뿐만 아니라 실행순서 또한 마지막에 실행된다.
    조회결과를 정렬시켜서 조회가 되게끔 도와주는 구문
    
    [표현법]
    SELECT 조회할컬럼, 컬럼, 산술연산식 AS "별칭", ...
    FROM 조회하고자하는테이블명
    WHERE 조건식
    ORDER BY 정렬기준의컬럼|별칭|컬럼순번 [ASC|DESC] [NULLS FIRST|NULLS LAST] => ASC : 오름차순 / DESC : 내림차순 (생략할 경우 기본 값이 오름차순으로 설정된다)
                                                                           => NULL값을 앞에 배치할건지, 뒤에할건지 선택 (생략가능)
    (ORDER BY절은 SELECT절 후에 실행되므로 "별칭"사용이 가능! 혹은 컬럼순번 작성 가능)
    
    - ASE : 오름차순 정렬 (생략 시 기본값)
    - DESC : 내림차순 정렬
    
    - NULLS FIRST : 정렬하고자 하는 컬람값에 NULL이 있을 경우 해당 데이터를 맨 앞 배치 (생략 시 DESC때의 기본값)
    - NULLS LAST : 정렬하고자 하는 컬럼값에 NULL이 있을 경우 해당 데이터를 맨 뒤 배치 (생략 시 ASC일때의 기본값)
    
*/

-- EMPLOYEE에 전체사원에 대한 데이터 조회
SELECT *
FROM EMPLOYEE
--ORDER BY BONUS ASC;  -- 오름차순 정렬일 때 기본적으로 NULLS LAST!
--ORDER BY BONUS ASC NULLS FIRST;
--ORDER BY BONUS DESC;   -- 내림차순 정렬일 때 기본적으로 NULLS FIRST!
ORDER BY BONUS DESC, SALARY ASC; -- 정렬기준을 여러개 제시 가능 (첫번째 기준의 컬럼값이 동일할 경우 두번째 기준의 컬럼가지고 정렬)

-- EMPLOYEE에 전 사원의 사원명, 연봉 조회 (이 때 연봉별 내림차순 정렬 조회)
SELECT EMP_NAME, SALARY*12 AS "연봉"
FROM EMPLOYEE
--ORDER BY SALARY*12 DESC;
--ORDER BY 연봉 DESC;    -- 별칭 사용 가능
ORDER BY 2 DESC;        -- 컬럼 순번 사용 가능