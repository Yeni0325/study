/*
    < 함수 FUNCTION >
    전달된 컬럼값을 읽어들여서 함수를 실행한 결과를 반환함
    
    - 단일행 함수 : N개의 값을 전달하면, N개의 결과값을 리턴 (매 행마다 함수를 실행시켜서 결과를 반환해줌)
    - 그룹 함수 : N개의 값을 전달해도, 1개의 결과값을 리턴 (그룹을 지어 그룹별로 함수를 실행시켜 결과를 반환해줌)
    
    >> SELECT 절에 단일행 함수와 그룹함수를 함께 사용 못한다.
        WHY? 결과 행의 갯수가 다르기 때문에
    
    >> 함수식을 기술할 수 있는 위치 : SELECT절, WHERE절, ORDER BY절, GROUP BY절, HAVING절 
*/

--================================= < 단일행 함수 > ====================================
/*
    < 문자 처리 함수 >
    
    * LENGTH / LEGNTHB        => 결과값 : NUMBER 타입
    
    [표현법]
    LENGTH(컬럼|'문자열값') : 해당 문자열값의 "글자수" 반환
    LENGTHB(컬럼|'문자열') : 해당 문자열값의 "바이트수" 반환
    
    '강' '나' 'ㄱ' 한글 한글자당 3BYTE
    영문자, 숫자, 특수문자 한글자당 1BYTE
*/

SELECT LENGTH('오라클'), LENGTHB('오라클')
FROM DUAL; -- 오라클에서 제공하는 가상테이블(더미테이블)!

SELECT LENGTH('ORACLE'), LENGTHB('ORACLE')
FROM DUAL;

-- EMPLOYEE에서 사원들의 이름과 각 사원들의 글자수와 바이트 수, 이메일과 각 사원들의 이메일 수와 바이트 수 조회
SELECT EMP_NAME, LENGTH(EMP_NAME), LENGTHB(EMP_NAME), EMAIL, LENGTH(EMAIL), LENGTHB(EMAIL)
FROM EMPLOYEE;

----------------------------------------------------------------------------------------------------

/*
    * INSTR
    문자열로부터 특정 문자의 "시작위치"를 찾아서 반환 (자바에서 인덱스 시작위치는 0, 오라클에서는 1부터 시작)
    
    [표현법]
    INSTR(컬럼|'문자열값', '찾고자하는문자', [찾을위치의 시작값, [순번]])    => 결과값 : NUMBER 타입
    
    - 찾을위치의 시작값
    1 : 해당 문자를 문자열로부터 앞에서부터 찾겠다는 의미
    -1 : 해당 문자를 문자열로부터 뒤에서부터 찾겠다는 의미 
    
    - 순번 : 몇번째에 위치하는 값부터 찾을 건지 작성
    
    찾아진 문자의 위치는 앞에서부터 세서 반환해준다!!
    
*/

-- 'AABAACAABBAA' 에서 'B'라는 문자를 찾겠다
SELECT INSTR('AABAACAABBAA', 'B')  -- '찾을 위치의 시작값'과 '순번'을 생략할 경우 앞에서부터 해당 문자를 찾음
FROM DUAL;                         -- 찾을 위치의 시작값의 기본값은 1, 순번도 생략시 기본값은 1


-- 'AABAACAABBAA' 에서 'B'라는 문자를 앞에서부터 찾겠다
SELECT INSTR('AABAACAABBAA', 'B', 1)  -- '순번' 생략시 기본값은 1
FROM DUAL; 

-- 'AABAACAABBAA' 에서 'B'라는 문자를 뒤에서부터 찾겠다
SELECT INSTR('AABAACAABBAA', 'B', -1)  -- '순번' 생략시 기본값은 1
FROM DUAL;                             -- 찾아진 문자의 위치는 앞에서부터 세서 반환해준다!!

-- 'AABAACAABBAA' 에서 'B'라는 문자를 앞에서부터 찾되, 두번째로 해당하는 문자를 찾겠다
SELECT INSTR('AABAACAABBAA', 'B', 1, 2)
FROM DUAL;

-- 'AABAACAABBAA' 에서 'B'라는 문자를 뒤에서부터 찾되, 세번째로 해당하는 문자를 찾겠다
SELECT INSTR('AABAACAABBAA', 'B', -1, 3)
FROM DUAL;

-- EMPLOYEE에서 전 사원의 EMAIL정보 조회
SELECT EMAIL
FROM EMPLOYEE;

-- EMPLOYEE에서 전 사원의 EMAIL정보 중 '-'의 위치와 '@'의 위치 정보 조회  
SELECT EMAIL, INSTR(EMAIL, '_', 1, 1) "_위치", INSTR(EMAIL, '@') "@위치"
FROM EMPLOYEE;

-------------------------------------------------------------------------------------

/*
    * SUBSTR
    문자열에서 특정 "문자열"을 추출해서 반환시켜주는 함수 (자바에서 SUBSTRING()메소드와 유사)
    
    [표현법]
    SUBSTR(STRING, POSITION, [LENGTH])       => 결과값 : CHARACTER타입(문자열 타입)
    - STRING : 문자타입컬럼 또는 '문자열값'
    - POSITION : 문자열을 추출할 시작위치값 (음수값으로도 제시 가능)
    - LENGTH : 추출하고자하는 문자의 갯수 (생략시 끝까지 추출) (음수값 제시시 부적합한값을 제시했으므로 NULL값이 추출)
*/

-- 'SHOWMETHEMONEY' 문자열로부터 7번째 위치부터 추출을 시작하겠다
SELECT SUBSTR('SHOWMETHEMONEY', 7) FROM DUAL;

-- 'SHOWMETHEMONEY' 문자열로부터 5번째 위치부터 2글자를 추출하겠다.
SELECT SUBSTR('SHOWMETHEMONEY', 5, 2) FROM DUAL;

-- 'SHOWMETHEMONEY' 문자열로부터 1번째 위치부터 6글자를 추출하겠다.
SELECT SUBSTR('SHOWMETHEMONEY', 1, 6) FROM DUAL;

-- 'SHOWMETHEMONEY' 문자열로부터 뒤에서 8번째 위치부터 3글자를 추출하겠다.
SELECT SUBSTR('SHOWMETHEMONEY', -8, 3) FROM DUAL;

-- EMPLOYEE에서 사원들의 사원명, 주민번호 조회
SELECT EMP_NAME, EMP_NO
FROM EMPLOYEE;

-- EMPLOYEE에서 사원들의 사원명, 주민번호, 주민번호 중 성별만 조회
SELECT EMP_NAME, EMP_NO, SUBSTR(EMP_NO, 8, 1) AS "성별"
FROM EMPLOYEE;

-- EMPLOYEE에서 여자사원들만 조회
SELECT EMP_NAME
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '2' OR SUBSTR(EMP_NO, 8, 1) = '4';   -- SELECT뿐 아니라 WHERE절에서도 함수 사용이 가능하다.

-- EMPLOYEE에서 남자사원들만 조회
SELECT EMP_NAME
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '1' OR SUBSTR(EMP_NO, 8, 1) = '3';
-- WHERE SUBSTR(EMP_NO, 8, 1) IN ('1', '3');   => IN을 활용한 조건식으로도 활용가능!
-- WHERE SUBSTR(EMP_NO, 8, 1) IN (1, 3) => SUBSTR( )은 문자열, IN ( ) 은 숫자타입이어도 오라클에서 내부적으로 자동형변환이 진행되서 정상적인 값이 추출된다.

-- EMPLOYEE에서 남자사원들만 오름차순으로 조회
SELECT EMP_NAME
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN (1, 3)
ORDER BY EMP_NAME;
-- ORDER BY 1 ASC;


-- 함수 중첩사용 가능
-- 전 사원의 이름과 이메일('@'부터 안나오게) 조회
SELECT EMP_NAME, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) AS "아이디"
FROM EMPLOYEE;

-------------------------------------------------------------------------------------

/*
    * LPAD / RPAD (LPAD : 왼쪽 / RPAD : 오른쪽)
    문자열을 조회할 때 통일감있게 조회하고자 할 때 사용하는 함수
    
    [표현법]
    LPAD/RPAD(STRING, 최종적으로 반환할 문자의길이, [덧붙이고자 하는 문자])    => 결과값 : CHARACTER 타입(문자열 타입)
    - STRING : 문자타입컬럼 또는 '문자열값'
    - 덧붙이고자 하는 문자 (생략가능, 생략 시 공백으로 채워짐)
    
    문자열에 덧붙이고자하는 문자를 LPAD시 왼쪽에, RPAD시 오른쪽에 덧붙여서 최종적으로 원하는 N길이만큼의 문자열을 반환
*/

-- EMPLOYEE에서 사원들의 이름, 이메일(오른쪽정렬) 조회
SELECT EMP_NAME, LPAD(EMAIL, 20)    -- 20만큼의 길이 중 EMAIL컬럼값은 오른쪽으로 정렬하고 덧붙이고자하는 문자를 제시안했기 때문에 나머지 부분은 공백으로 왼쪽에 채워짐
FROM EMPLOYEE;

-- EMPLOYEE에서 사원들의 이름, 이메일(오른쪽정렬, 공백에 '#"채워서) 조회
SELECT EMP_NAME, LPAD(EMAIL, 20, '#')
FROM EMPLOYEE;

-- EMPLOYEE에서 사원들의 이름, 이메일(왼쪽정렬, 공백에 '#"채워서) 조회
SELECT EMP_NAME, RPAD(EMAIL, 20, '#')
FROM EMPLOYEE;

-- 주민번호에서 성별자리뒤부터는 '*'로 조회 => 주민번호 총 글자 수 : 14글자
SELECT RPAD('940325-2', 14, '*') FROM DUAL;

-- EMPLOYEE에 전체사원의 사원명, 주민번호(성별자리 이후부분은 '*'로 조회) 조회
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*') -- RPAD(주민번호값으로 성별자리까지 추출한 문자열, 14, '*')
FROM EMPLOYEE;

-- 위와 동일한 결과를 다른 방법(연결연산자 사용)으로 조회
SELECT EMP_NAME, SUBSTR(EMP_NO, 1, 8) || '******'
FROM EMPLOYEE;

-----------------------------------------------------------------------------------------------------------

/*
    * LTRIM / RTRIM
    문자열에서 특정 문자를 제거한 나머지를 반환
    
    [표현법]
    LTRIM/RTRIM(STRING, [제거하고자하는 문자들])        => 결과값 : CHARACTER타입(문자열 타입)
    - STRING : 문자타입컬럼 또는 '문자열값'
    - 제거하고자하는 문자들 : 생략 시 공백을 찾아서 제거해준다.
    
    문자열의 왼쪽 혹은 오른쪽에서 제거하고자하는 문자들을 찾아서 제거시키고, 제거한 나머지 문자열을 반환해주는 함수
*/

-- 임의의 문자열인 '   K H '에서 공백을 제거하고, 제거 후 문자열을 조회 
SELECT LTRIM('   K H ') FROM DUAL;    -- => 왼쪽에 있던 3개의 공백이 제거, 중간과 끝에 있는 공백은 제거되지 않음
                                      -- => 왼쪽에 있는 공백 제거 후 다른 문자를 만나면 종료한 후에 해당 값을 조회
                                      
-- 임의의 문자열인 '123123KH123'에서 왼쪽에서 '123'을 제거시키고, 제거 후 문자열을 조회
SELECT LTRIM('123123KH123', '123') FROM DUAL;

-- 임의의 문자열인 'ACABACCKH' 에서 왼쪽에서 'ABC'를 제거시키고, 제거 후 문자열을 조회
SELECT LTRIM('ACABACCKH', 'ABC') FROM DUAL;   --> 'ABC'라는 연이은 문자열이 존재하지 않는데, 'ABC'의 뜻은 해당 문자열로부터 'A', 'B', 'C'를 찾아서 지워줘 라는 뜻과 동일하다
                                              --> 따라서 결과값으로 'KH'가 조회된다.

-- 임의의 문자열인 '5782KH123'에서 오른쪽에서 '0123456789'를 제거시키고, 제거 후 문자열을 조회
SELECT RTRIM('5782KH123', '0123456789') FROM DUAL;

/*
    * TRIM
    문자열에서 앞/뒤/양쪽에 있는 특정 문자를 제거한 나머지를 반환
    기본적으로 양쪽에 있는 문자들 다 찾아서 제거해준다.
    
    [표현법]
    TRIM([ [LEADING|TRAILING|BOTH] 제거하고자하는 문자들 FROM ] STRING)        => 결과값 : CHARACTER타입(문자열 타입)
    - LEADING : 앞쪽
    - TRAILING : 뒤쪽
    - STRING : 문자타입컬럼 또는 '문자열값'
    - 제거하고자하는 문자들 : 생략 시 공백을 찾아서 제거해준다. 
*/

-- 임의의 문자열인 '   K H   '에서 공백을 제거하고, 제거 후 문자열을 조회
SELECT TRIM('   K H   ') FROM DUAL; 
-- TRIM : 기본적으로 양쪽에 있는 문자들 다 찾아서 제거

-- 임의의 문자열인 'ZZZKHZZZ' 에서 'Z'를 제거하고, 제거 후 문자열을 조회
SELECT TRIM('Z' FROM 'ZZZKHZZZ') FROM DUAL;
-- 'Z'라는 문자열을 제거할건데 FROM 'ZZZKHZZZ'로부터 제거하겠다.

-- 임의의 문자열인 'ZZZKHZZZ' 에서 'Z'를 앞쪽에서만 제거하고, 제거 후 문자열을 조회
SELECT TRIM(LEADING 'Z' FROM 'ZZZKHZZZ') FROM DUAL;  -- LEADING : 앞   => LTRIM과 유사

-- 임의의 문자열인 'ZZZKHZZZ' 에서 'Z'를 뒤쪽에서만 제거하고, 제거 후 문자열을 조회
SELECT TRIM(TRAILING 'Z' FROM 'ZZZKHZZZ') FROM DUAL; -- TRAILING : 뒤  => RTRIM과 유사

-- 임의의 문자열인 'ZZZKHZZZ' 에서 'Z'를 제거하고, 제거 후 문자열을 조회
SELECT TRIM(BOTH 'Z' FROM 'ZZZKHZZZ') FROM DUAL; -- BOTH : 양쪽  => 생략 시 기본 값

-----------------------------------------------------------------------------------------

/*
    * LOWER / UPPER / INITCAP
    
    [표현법]
    LOWER/UPPER/INITCAP(STRING)     => 결과값 : CHARACTER타입 (문자열 타입)
    - LOWER : 다 소문자로 변경한 문자열 반환 (자바에서의 toLowerCase()메소드와 유사)
    - UPPER : 다 대문자로 변경한 문자열 반환 (자바에서의 toUpperCase()메소드와 유사)
    - INITCAP : 단어 앞글자마다 대문자로 변경한 문자열 반환
    - STRING : 문자타입컬럼 또는 '문자열값'
*/

-- 해당 문자열()을 전부 소문자로 변경한 문자열 반환
SELECT LOWER('Welcome To My World!') FROM DUAL;

-- 해당 문자열()을 전부 대문자로 변경한 문자열 반환
SELECT LOWER('Welcome To My World!') FROM DUAL;

-- 해당 문자열()을 단어 앞글자마다 대문자로 변경한 문자열 반환
SELECT INITCAP('welcome to myworld!') FROM DUAL;

----------------------------------------------------------------------------------------

/*
    * CONCAT
    문자열 두개 전달받아 하나로 합친 후 결과 반환
    
    [표현법]
    CONCAT(STRING, STRING)  => 결과값 : CHARACTER타입(문자열 타입)
    - STRING : '문자열값'(무조건 2개)
*/

-- 두개의 문자열을 합친 값 조회
SELECT CONCAT('가나다', 'ABC') FROM DUAL;

-- 위와 동일한 결과 값 조회
SELECT '가나다'||'ABC' FROM DUAL;

-- 3개의 문자열을 합친 값 조회
SELECT CONCAT('가나다', 'ABC', '123') FROM DUAL; -- 오류발생 : 2개의 문자열 밖에 안됨
SELECT '가나다'||'ABC'||'123' FROM DUAL;

------------------------------------------------------------------------------------

/*
    * REPLACE
    
    [표현법]
    REPLACE(STRING, STR1, STR2)     => 결과값 : CHARACTER타입 (문자열 타입)
    - STRING : 변경을 원하는 값이 포함된 문자열
    - STR1 : 변경을 원하는 값
    - STR2 : 변경할 값
*/

-- EMPLOYEE에서 사원들의 이름과 이메일('kh.or.kr'부분이 'gmail.com'로 바껴서) 조회
SELECT EMP_NAME, REPLACE(EMAIL, 'kh.or.kr', 'gmail.com')
FROM EMPLOYEE;

------------------------------------------------------------------------------------

/*
    < 숫자 처리 함수 >
    
    * ABS
    숫자의 절대값을 구해주는 함수
    
    [표현법]
    ABS(NUMBER)         => 결과값 : NUMBER타입 (오라클에서 NUMBER타입은 정수, 실수를 구분짓지 않음)
*/
SELECT ABS(-10) FROM DUAL;
SELECT ABS(-5.7) FROM DUAL;

-------------------------------------------------------------------------------------

/*
    * MOD
    두 수를 나눈 나머지값을 반환해주는 함수
    
    [표현법]
    MOD(NUMBER, NUMBER)   => 결과값 : NUMBER타입
*/
SELECT MOD(10, 3) FROM DUAL;
SELECT MOD(10.9, 3) FROM DUAL;

--------------------------------------------------------------------------------------

/*
    * ROUND
    반올림한 결과를 반환시켜주는 함수
    
    [표현법]
    ROUND(NUMBER, [위치])    => 결과값 : NUMBER타입
    - 위치 : 소수점 몇번째자리까지 나타낼건지(생략가능, 기본값은 0)
*/
SELECT ROUND(123.456) FROM DUAL;
SELECT ROUND(123.456, 0) FROM DUAL;
SELECT ROUND(123.456, 1) FROM DUAL;
SELECT ROUND(123.456, 5) FROM DUAL;
SELECT ROUND(123.456, -1) FROM DUAL;
SELECT ROUND(123.456, -2) FROM DUAL;

------------------------------------------------------------------------------------------

/*
    * CEIL
    올림처리해주는 함수로 올림위치를 지정할 수 없다.
    무조건 정수형태로 반환
    
    [표현법]
    CEIL(NUMBER) 
*/

SELECT CEIL(123.152) FROM DUAL;

-------------------------------------------------------------------------------------------

/*
    * FLOOR
    소수점 아래를 다 버림처리하는 함수로 버림위치를 지정할 수 없다.
    무조건 정수형태로 반환
    
    [표현법]
    FLOOR(NUMBER)
*/

SELECT FLOOR(123.152) FROM DUAL;
SELECT FLOOR(123.952) FROM DUAL;

--------------------------------------------------------------------------------------------

/*
    * TRUNC
    위치 지정이 가능한 버림처리해주는 함수
    
    [표현법]
    TRUNC(NUMBER, [위치])
    - 위치 : 소수점 몇번째자리까지 나타낼건지(생략가능, 기본값은 0)
    
    별다른 위치지정을 하지 않을 경우 FLOOR함수와 동일하다
*/

SELECT TRUNC(123.456) FROM DUAL;
SELECT TRUNC(123.456, 1) FROM DUAL;
SELECT TRUNC(123.456, -1) FROM DUAL;

-------------------------------------------------------------------------------------------

/*
    < 날짜 처리 함수 >
*/

-- * SYSDATE : 시스템 날짜 및 시간을 반환 해주는 함수 (현재 날짜 및 시간)
SELECT SYSDATE FROM DUAL;

-- * MONTHS_BETWEEN(DATE1, DATE2) : 두 날짜 사이의 개월 수를 반환해주는 함수 => 내부적으로 DATE1 - DATE2 후 나누기 30, 31이 진행된다
--   => 결과값은 NUMBER타입
-- EMPLOYEE에서 사원명, 입사일, 근무일수, 근무개월수
SELECT EMP_NAME, HIRE_DATE, 
       FLOOR(SYSDATE-HIRE_DATE) "근무일수", 
       CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) || '개월차' "근무개월수"
FROM EMPLOYEE;

-- * ADD_MONTHS(DATE, NUMBER) : 특정 날짜(DATE)에 해당 숫자(NUMBER)만큼의 개월수를 더해서 그 날짜를 리턴해주는 함수
--   => 결과값은 DATE타입
-- 오늘날짜로부터 5개월 후의 날짜
SELECT ADD_MONTHS(SYSDATE, 5) FROM DUAL;

-- EMPLOYEE에서 사원명, 입사일, 입사일 후 6개월된 날짜
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE, 6)
FROM EMPLOYEE;

-- * NEXT DAY(DATE, 요일(문자|숫자)) : 특정 날자(DATE) 이후에 가까운 해당 요일의 날짜를 반환해주는 함수
--   => 결과값은 DATE타입
-- 오늘날짜로부터 가까운 금요일의 날짜
SELECT SYSDATE, NEXT_DAY(SYSDATE, '금요일') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '금') FROM DUAL;
-- 1: 일요일, 2: 월요일, ... 6 : 금요일, 7 : 토요일
SELECT SYSDATE, NEXT_DAY(SYSDATE, 6) FROM DUAL;

SELECT SYSDATE, NEXT_DAY(SYSDATE, 'FRIDAY') FROM DUAL; -- 에러 (현재언어가 KOREAN이기 때문)

-- 언어 변경
ALTER SESSION SET NLS_LANGUAGE = AMERICAN;

SELECT SYSDATE, NEXT_DAY(SYSDATE, 'FRIDAY') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '금요일') FROM DUAL; -- 에러

-- 언어 변경
ALTER SESSION SET NLS_LANGUAGE = KOREAN;

-- * LAST_DAY(DATE) : 특정 날짜(DATE)가 포함된 달의 마지막 날짜를 반환해주는 함수
--   => 결과값 DATE타입

-- 이번달의 마지막 날짜
SELECT LAST_DAY(SYSDATE) FROM DUAL;

-- EMPLOYEE에서 사원명, 입사일, 입사한달의 마지막날짜, 입사한달에 근무한 일수
SELECT EMP_NAME, HIRE_DATE, LAST_DAY(HIRE_DATE), LAST_DAY(HIRE_DATE) - HIRE_DATE
FROM EMPLOYEE;

/*
    * EXTRACT
    특정날짜로부터 년도|월|일 값을 추출해서 반환하는 함수
    
    [표현법]
    EXTRACT(YEAR FROM DATE) : 특정날짜로부터 년도만을 추출
    EXTRACT(MONTH FROM DATE) : 특정날짜로부터 월만을 추출
    EXTRACT(DAY FROM DATE) : 특정날짜로부터 일만을 추출   
    
    => 결과값은 NUMBER타입
*/

-- EMPLOYEE에서 사원명, 입사년도, 입사월, 입사일 조회
SELECT EMP_NAME, 
       EXTRACT(YEAR FROM HIRE_DATE) "입사년도", 
       EXTRACT(MONTH FROM HIRE_DATE) "입사월", 
       EXTRACT(DAY FROM HIRE_DATE) "입사일"
FROM EMPLOYEE
ORDER BY 입사년도, 입사월, 입사일;

-------------------------------------------------------------------------------------------

/*
    < 형변환 함수 >
    
    * TO_CHAR
    숫자 타입 또는 날짜 타입의 값을 문자타입으로 변환시켜주는 함수
    
    [표현법]
    TO_CHAR(숫자|날짜, [포맷])   => 결과값 : CHARACTER타입 (문자열 타입)
    - 포맷 : '0': 숫자만큼의 공간확보, 빈칸은 0으로 채워짐
            '9': 숫자만큼의 공간확보, 빈칸은 공백으로 채워짐
            'L' : 현재 설정된 나라(LOACAL)의 화폐단위가 빈칸으로 채워짐 
            '$' : $가 빈칸으로 채워짐
*/

-- 숫자타입 => 문자타입
SELECT TO_CHAR(1234) FROM DUAL; -- '1234' 문자열로 조회됨

SELECT TO_CHAR(1234, '99999') FROM DUAL; -- 5칸짜리 공간확보, 오른쪽정렬, 빈칸 공백
SELECT TO_CHAR(1234, '00000') FROM DUAL; -- 빈칸을 0으로
SELECT TO_CHAR(1234, 'L99999') FROM DUAL; -- 현재 설정된 나라(LOCAL)의 화폐단위
SELECT TO_CHAR(1234, '$99999') FROM DUAL; 

SELECT TO_CHAR(1234, 'L99,999') FROM DUAL; -- 세자리 단위마다 ','가 찍혔으면 할 때 

-- EMPLOYEE에서 사원들의 이름과 급여(원화표시, 세자리마다 ','), 연봉(원화표시, 세자리마다 ',') 조회
SELECT EMP_NAME, TO_CHAR(SALARY, 'L999,999,999'), TO_CHAR(SALARY*12, 'L999,999,999')
FROM EMPLOYEE;

-- 날짜타입 => 문자타입
SELECT SYSDATE FROM DUAL;
SELECT TO_CHAR(SYSDATE) FROM DUAL; -- '21/09/16' 라는 문자열로 조회됨
SELECT TO_CHAR(SYSDATE, 'PM HH:MI:SS') FROM DUAL; -- HH(12시간 형식) : 시 / MI : 분 / SS : 초
SELECT TO_CHAR(SYSDATE, 'PM HH24:MI:SS') FROM DUAL; -- HH24(24시간 형식) : 시
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY') FROM DUAL; -- YYYY: 년도 / MM : 월 / DD : 일 / DAY : 요일
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DY') FROM DUAL; -- YYYY: 년도 / MM : 월 / DD : 일 / DAY : 요일
SELECT TO_CHAR(SYSDATE, 'MON, YYYY') FROM DUAL; -- MON : 'N'월 

-- EMPLOYEE에서 사원들의 이름과 입사일('YY-MM-DD'형식) 조회
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YY-MM-DD') 
FROM EMPLOYEE;

-- EMPLOYEE에서 사원들의 입사일('YYYY년 MM월 DD일'형식) 조회
--SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY년 MM월 DD일') -- 오류 발생 : '년', '월', '일'은 제공하는 포맷이 아닌, 임의로 제시한 문자값이기 때문에 포맷으로 반영이 불가능하다.
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일"')
FROM EMPLOYEE;

-- 년도와 관련된 포맷
SELECT TO_CHAR(SYSDATE, 'YYYY'),
       TO_CHAR(SYSDATE, 'YY'),
       TO_CHAR(SYSDATE, 'RRRR'),
       TO_CHAR(SYSDATE, 'RR'),
       TO_CHAR(SYSDATE, 'YEAR') 
FROM DUAL;
       
-- 월과 관련된 포맷
SELECT TO_CHAR(SYSDATE, 'MM'),
       TO_CHAR(SYSDATE, 'MON'),
       TO_CHAR(SYSDATE, 'MONTH'),
       TO_CHAR(SYSDATE, 'RM') -- R : 로마기호
FROM DUAL;

-- 일과 관련된 포맷
SELECT TO_CHAR(SYSDATE, 'DDD'), -- 요번년 기준 몇일째
       TO_CHAR(SYSDATE, 'DD'), -- 요번월 기준 몇일째
       TO_CHAR(SYSDATE, 'D') -- 요번 주 기준 몇일째
FROM DUAL;

-- 요일과 관련된 포맷
SELECT TO_CHAR(SYSDATE, 'DAY'), -- 목요일
       TO_CHAR(SYSDATE, 'DY')   -- 목
FROM DUAL;

-----------------------------------------------------------------------------------------

/*
    * TO_DATE 
    숫자타입 또는 문자타입 데이터를 날짜타입으로 변환시켜주는 함수
    
    [표현법]
    TO_DATE(숫자|문자, [포맷])    => 결과값 : DATE타입
*/
-- 숫자 => 날짜
SELECT TO_DATE(20100101) FROM DUAL;  -- 기본적으로 8자리의 숫자가 제시된다면 앞에 4자리는 년도, 2자리는 월, 2자리는 일로 인식이 된다
SELECT TO_DATE(100101) FROM DUAL;    -- 6자리를 제시한다면 앞에 2자리 년도, 2자리 월, 2자리는 일로 인식이 된다.

SELECT TO_DATE(070101) FROM DUAL; -- 오류발생 : 0으로 시작하는 숫자를 제시하면 에러가 발생한다.
SELECT TO_DATE('070101') FROM DUAL; -- 해결방법 : 0으로 시작할 때는 문자로 제시하면 된다

-- 시/분/초 반영
SELECT TO_DATE('041030 143000') FROM DUAL; -- 오류발생 : 어떤것이 어떤것에 해당하는지 정확히 제시를 해줘야한다.
SELECT TO_DATE('041030 143000', 'YYMMDD HH24MISS') FROM DUAL; -- 포맷제시 시 HH24가 아닌 HH제시시 오류발생 -> HH는 12시간 기준인데 제시된 시간은 14이기 때문에

SELECT TO_DATE('140630', 'YYMMDD') FROM DUAL;
SELECT TO_DATE('980630', 'YYMMDD') FROM DUAL; -- YY : 무조건 현재세기로 반영된 년도를 반영

SELECT TO_DATE('140630', 'RRMMDD') FROM DUAL;
SELECT TO_DATE('980630', 'RRMMDD') FROM DUAL; -- RR : 해당 두자리 년도 값이 50미만일경우 현재세기로 반영, 50 이상일 경우 이전 세기로 반영

--------------------------------------------------------------------------------------------------------------------------------

/*
    * TO_NUMBER 
    문자타입의 데이터를 숫자타입으로 변환시켜주는 함수로 날짜타입을 숫자로는 변경시키지 못한다.
    
    [표현법]
    TO_NUMBER(문자, [포맷])     => 결과값은 NUMBER타입
*/

-- 문자 => 숫자
SELECT TO_NUMBER('05123475') FROM DUAL;

SELECT '1000000' + '550000' FROM DUAL;

SELECT '1,000,000' + '550,000' FROM DUAL; -- 에러발생
SELECT TO_NUMBER('1,000,000', '9,999,999') + TO_NUMBER('550,000', '999,999') FROM DUAL;

-----------------------------------------------------------------------------------------

/*
    < NULL 처리 함수 >
*/

-- * NVL(컬럼, 해당컬럼값이 NULL일 경우 반환할 값)

-- EMPLOYEE에서 전 사원의 이름, 보너스(보너스가 없으면 0으로 표시) 조회
SELECT EMP_NAME, NVL(BONUS, 0)
FROM EMPLOYEE;

-- EMPLOYEE에 전 사원의 이름, 보너스가 보함된 연봉(보너스가 없으면 0으로 표시) 조회
SELECT EMP_NAME, (SALARY+SALARY*NVL(BONUS, 0))*12
FROM EMPLOYEE;

-- EMPLOYEE에서 전 사원의 이름과 부서명(부서가 없으면 '부서없음'표시) 조회
SELECT EMP_NAME, NVL(DEPT_CODE, '부서없음')
FROM EMPLOYEE;

-- * NVL2(컬럼, 반환값1, 반환값2) 해당 컬럼이 NULL일수도 있고, 값이 있을 수 있음
--   컬럼값이 존재할 경우 반환값1 반환
--   컬럼값이 NULL일 경우 반환값2 반환

-- EMPLOYEE에서 사원의 이름과 보너스, 보너스값이 존재한다면 0.7, 없다면 0.1값 조회
SELECT EMP_NAME, BONUS,NVL2(BONUS, 0.7, 0.1)
FROM EMPLOYEE;

-- EMPLOYEE에서 사원의 이름과 부서가 있다면 '부서있음', 없다면 '부서없음'값 조회
SELECT EMP_NAME, NVL2(DEPT_CODE, '부서있음', '부서없음') 
FROM EMPLOYEE;

-- * NULLIF(비교대상1, 비교대상2)
--   두 개의 값이 일치하면 NULL을 반환해주는 함수 
--   두 개의 값이 일치하지 않으면 비교대상1 값을 반환

SELECT NULLIF('123', '123') FROM DUAL;
SELECT NULLIF('123', '456') FROM DUAL;

------------------------------------------------------------------------------------------

/*
    < 선택 함수 >
    
    * DECODE(비교하고자하는대상(컬럼|산술연산|함수식), 비교값1, 결과값1, 비교값2, 결과값2, ..., 결과값N)
    
    자바에서 SWICH(비교대상) {
            CASE 비교값 1 :
            CASE 비교값 2 :
            ...
            DEFAULT : 
            } 와 비슷
*/

-- EMPLOYEE에서 사원들의 사번, 사원명, 주민번호, 성별(1이면 남자, 2면 여자) 조회
SELECT EMP_ID, EMP_NAME, EMP_NO, DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여') AS "성별"
FROM EMPLOYEE;

-- EMPLOYEE에서 사원명, 직급코드, 기존급여, 인상된급여 조회
-- 직원의 급여 조회 시 각 직급별로 인상해서 조회
-- J7인 사원은 급여을 10% 인상 (SALARY*1.1)
-- J6인 사원은 급여를 15% 인상 (SALARY*1.15)
-- J5인 사원은 급여를 20% 인상 (SALARY*1.2)
-- 그 외의 사원은 급여를 5% 인상 (SALARY*1.05)
SELECT EMP_NAME, JOB_CODE, SALARY, 
       DECODE(JOB_CODE, 'J7', SALARY*1.1, 
                        'J6', SALARY*1.15, 
                        'J5', SALARY*1.2, 
                        SALARY*1.05)
FROM EMPLOYEE;

/*
    * CASE WHEN THEN
    
    [표현법]
    CASE WHEN 조건식1 THEN 결과값1
         WHEN 조건식2 THEN 결과값2
         ...
         ELSE 결과값N               => 자바의 IF-ELSE IF와 유사
     END
*/

-- EMPLOYEE에서 사원들의 이름, 급여, 사원의 수준(고급, 중급 초급) 조회
SELECT EMP_NAME, SALARY, 
       CASE WHEN SALARY >= 5000000 THEN '고급'
            WHEN SALARY >= 3500000 THEN '중급'
            ELSE '초급'
        END
FROM EMPLOYEE;

------------------------------------ < 그룹함수 > ----------------------------------------
-- 1. SUM(숫자타입컬럼) : 해당 컬럼 값들의 총 합계를 구해서 반환해주는 함수

-- EMPLOYEE에 전사원의 총 급여합
SELECT SUM(SALARY)
FROM EMPLOYEE; -- 전체사원이 하나의 그룹으로 묶여있음


-- EMPLOYEE에 남자사원들의 총 급여합
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('1','3'); -- 남자사원들이 한 그룹으로 묶임

-- EMPLOYEE에 부서코드가 D5인 사원들의 총 연봉합
SELECT SUM(SALARY * 12) --, EMP_NAME   -- 오류발생 -->  SUM(SALARY * 12) 와 EMP_NAME의 결과값의 행 수가 동일하지 않기 때문에 오류가 발생!
FROM EMPLOYEE                         --              그룹함수와 일반컬럼, 단일행함수는 함께 사용하지 못한다!                
WHERE DEPT_CODE = 'D5';

-- 2. AVG(숫자타입컬럼) : 해당 컬럼값들의 평균값을 구해서 반환해주는 함수

-- EMPLOYEE에 전체 사원의 평균 급여 조회
SELECT ROUND(AVG(SALARY))  --> 결과값이 숫자타입이기 때문에 숫자타입함수 사용가능!
FROM EMPLOYEE;


-- 3. MIN(모든타입컬럼) : 해당 컬럼값들 중에 가장 작은 값을 구해서 반환해주는 함수

-- EMPLOYEE에 사원들 중 가장 작은 이름과 현재 급여값들 중 최저급여, 가장 먼저 입사한 날짜 조회
SELECT MIN(EMP_NAME), MIN(SALARY), MIN(HIRE_DATE)
FROM EMPLOYEE;

-- 4. MAX(모든타입컬럼) : 해당 컬럼값들 중에 가장 큰 값을 구해서 반환해주는 함수

-- EMPLOYEE에 사원들 중 가장 큰 이름과 현재 급여값들 중 최대급여, 가장 늦게 입사한 날짜 조회
SELECT MAX(EMP_NAME), MAX(SALARY), MAX(HIRE_DATE)
FROM EMPLOYEE;

-- COUNT(*|컬럼|DISTINCT 컬럼) : 조회된 행 갯수를 세서 반환해주는 함수 
-- COUNT(*) : 조회된 결과의 모든 행 갯수를 세서 반환
-- COUNT(컬럼) : 제시한 해당 컬럼값이 NULL이 아닌 것만 행 갯수를 세서 반환
-- COUNT(DISTINCT 컬럼) : 해당 컬럼값에 중복을 제거한 후 행 갯수를 세서 반환

-- EMPLOYEE에 전체 사원 수 조회
SELECT COUNT(*)
FROM EMPLOYEE;

-- EMPLOYEE에 여자 사원 수 조회
SELECT COUNT(*)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('2','4');

-- EMPLOYEE에 보너스를 받고 있는 사원 수 조회
SELECT COUNT(BONUS)
FROM EMPLOYEE;

-- EMPLOYEE에 부서배치를 받은 사원 수 조회
SELECT COUNT(DEPT_CODE)
FROM EMPLOYEE;

-- EMPLOYEE에 현재 사원들이 총 몇개의 부서에 분포되어있는지 조회
SELECT COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE;
