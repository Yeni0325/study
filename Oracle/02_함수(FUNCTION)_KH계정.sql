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
    
    INSTR(컬럼|'문자열값', '찾고자하는문자', [찾을위치의 시작값, [순번]])    => 결과값 : NUMBER 타입
    
    찾을위치의 시작값
    1 : 해당 문자를 문자열로부터 앞에서부터 찾겠다는 의미
    -1 : 해당 문자를 문자열로부터 뒤에서부터 찾겠다는 의미 
    
    순번 : 몇번째에 위치하는 값부터 찾을 건지 작성
    
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