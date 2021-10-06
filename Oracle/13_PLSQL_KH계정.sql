/*

    < PL/SQL >
    PROCEDURE LANGUAGE EXTENSION TO SQL
    
    오라클 자체에 내장되어 있는 절차적 언어
    SQL문장 내에서 변수의 정의, 조건처리(IF), 반복처리(LOOP, FOR, WHILE) 등을 지원하여 SQL의 단점을 보완
    다수의 SQL문을 한번에 실행 가능 (BLOCK 구조)
    
    * PL/SQL 구조
    - [선언부 (DECLARE SECTION)]      : DECLARE 키워드로 시작, 변수나 상수를 선언 및 초기화하는 부분 
    - 실행부 (EXECUTABLE SECTION)     : BEGIN 키워드로 시작, SQL문 또는 제어문(조건문, 반복문)등의 로직을 기술하는 부분
    - [예외처리부 (EXCEPTION SECTION)] : EXCEPTION 키워드로 시작, 예외발생 시 해결하기 위한 구문을 미리 기술해둘 수 있는 부분

*/

-- * 간단하게 화면에 HELLO ORACLE 출력
SET SERVEROUTPUT ON;

BEGIN 
    -- System.out.println("HELLO ORACLE"); -- 자바  
    DBMS_OUTPUT.PUT_LINE('HELLO ORACLE'); 
END;
/
------------------------------------------------------------------------------------------

/*
    1. DECLARE 선언부
       변수 및 상수 선언 하는 공간 (선언과 동시에 초기화도 가능)
       일반타입변수, 레퍼런스타입변수, ROW타입변수
       
       1_1) 일반타입 변수 선언 및 초기화
            [표현법] DECLARE 변수명 자료형 [CONSTANT][:= 값];   --> SQL에서 대입연산자는 ':='
                                                              --> CONSTANT 상수               
*/

DECLARE                           
    EID NUMBER;
    ENAME VARCHAR2(20);
    PI CONSTANT NUMBER := 3.14;
BEGIN                             
    --EID := 800;
    --ENAME := '배장남';
    
    EID := &번호;
    ENAME := '&이름';
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);   
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('PI : ' || PI);
END;
/

---------------------------------------------------------------------------------------

-- 1_2) 레퍼런스 타입 변수 선언 및 초기화 (어떤 테이블의 어떤 컬럼의 데이터타입을 참조해서 그 타입으로 지정)
--      [표현법] DECLARE 변수명 테이블명.컬럼명%TYPE;
DECLARE 
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
BEGIN
    --EID := '300';
    --ENAME := '김빠꾸';
    --SAL := 3000000;
    
    -- 사번이 200번인 사원의 사번, 사원명, 급여 조회해서 각 변수에 대입
    SELECT EMP_ID, EMP_NAME, SALARY
      INTO EID, ENAME, SAL
      FROM EMPLOYEE
     --WHERE EMP_ID = 200;
     WHERE EMP_ID = &사번;

    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('SAL : ' || SAL);
END;
/

--------------------------------------- 실습문제 1 -------------------------------------
/*
    레퍼런스타입변수로 EID, ENAME, JCODE, SAL, DTITLE를 선언하고
    각 자료형은 EMPLOYEE(EMP_ID, EMP_NAME, JOB_CODE, SALARY), DEPARTMENT(DEPT_TITLE) 들을 참조하도록
    
    사용자가 입력한 사번의 사원의 사번, 사원명, 직급코드, 급여, 부서명 조회한 후 각 변수에 담아서 결과 출력
*/
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    JCODE EMPLOYEE.JOB_CODE%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY, DEPT_TITLE
      INTO EID, ENAME, JCODE, SAL, DTITLE
      FROM EMPLOYEE E, DEPARTMENT D
     WHERE E.DEPT_CODE = D.DEPT_ID
       AND EMP_ID = &사번;
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('JCODE : ' || JCODE);
    DBMS_OUTPUT.PUT_LINE('SAL : ' || SAL);
    DBMS_OUTPUT.PUT_LINE('DTITLE : '|| DTITLE);
    
    DBMS_OUTPUT.PUT_LINE(EID || ', ' || ENAME || ', ' || JCODE || ', '|| SAL || ', ' || DTITLE );
    
END;
/

-----------------------------------------------------------------------------------------

-- 1_3) ROW타입 변수 선언 (ROW : 한 행)
--      테이블의 한 행에 대한 모든 컬럼값을 한꺼번에 담을 수 있는 변수
--      [표현법] DECLARE 변수명 테이블명%ROWTYPE;

DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    SELECT *                    -- ROW타입 변수 선언 시 무조건 '*'로 해야한다.
      INTO E
      FROM EMPLOYEE
     WHERE EMP_ID = &사번;
     
     DBMS_OUTPUT.PUT_LINE('사원명 : ' || E.EMP_NAME);
     DBMS_OUTPUT.PUT_LINE('급여 : ' || E.SALARY);
     DBMS_OUTPUT.PUT_LINE('보너스 : ' || NVL(E.BONUS,0));
     -- 출력문 내에서 함수활용 가능
END;
/

----------------------------------------------------------------------------------------

-- 2. BEGIN 실행부

-- < 조건문 >

-- 1) [표현법] IF 조건식 THEN TRUE일때실행내용 END IF; (자바에서의 단일 IF문)(IF로 시작하면 END IF로 끝난다)

-- 사번 입력받은 후 해당 사원의 사번, 이름, 급여, 보너스율(%) 출력
-- 단, 보너스를 받지 않는 사원은 보너스율 출력 전 '보너스를 지급받지 않는 사원입니다' 출력

DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS, 0)
    INTO EID, ENAME, SALARY, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || SALARY );
    
    IF BONUS = 0 
        THEN DBMS_OUTPUT.PUT_LINE('보너스를 지급받지 않는 사원입니다.');
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('보너스율 : ' || BONUS * 100 || '%');
    
END;
/

-- 2) [표현법] IF 조건식 THEN TRUE일때실행내용 ELSE FALSE일때실행내용 END IF; (자바에서의 IF - ELSE문)
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS, 0)
      INTO EID, ENAME, SALARY, BONUS
      FROM EMPLOYEE
     WHERE EMP_ID = &사번;
     
     DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
     DBMS_OUTPUT.PUT_LINE('이름 : ' || ENAME);
     DBMS_OUTPUT.PUT_LINE('급여 : ' || SALARY || '원');
     
     IF BONUS = 0
        THEN DBMS_OUTPUT.PUT_LINE('보너스를 지급받지 않는 사원입니다.');
     ELSE
        DBMS_OUTPUT.PUT_LINE('보너스율 : ' || BONUS * 100 || '%');
     END IF;    
END;
/

------------------------------------------ 실습문제 -----------------------------------------
DECLARE
    -- 레퍼런스타입변수 (EID, ENAME, DTITLE, NCODE)
    -- 참조할컬럼 (EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE)
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
    NCODE LOCATION.NATIONAL_CODE%TYPE;
    
    -- 일반타입변수 (TEAM 문자열)  <= 이따가 조회된 사원이 '국내팀' 또는 '해외팀'인지 담을 예정
    TEAM VARCHAR2(20);
BEGIN
    -- 사용자가 입력한 사번의 사원의 사번, 이름, 부서명, 근무국가코드 조회 후 각 변수에 대입
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE
    INTO EID, ENAME, DTITLE, NCODE
    FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
    WHERE EMP_ID = &사번;
    
    -- NCODE 값이 KO일 경우 => TEAM에 '국내팀' 대입
    -- 그게 아닐 경우       => TEAM에 '해외팀' 대입
    IF NCODE = 'KO'
        THEN TEAM := '국내팀';
    ELSE
        TEAM := '해외팀';
    END IF;
    -- 최종적으로 사번, 이름, 부서명, 소속에 대해 출력
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('DTITLE : ' || DTITLE);
    DBMS_OUTPUT.PUT_LINE('TEAM : ' || TEAM);
END;
/

-- 3) [표현법] IF 조건식1 THEN 실행내용1 ELSIF 조건식2 THEN 실행내용2 ... [ELSE 실행내용N] END IF; (자바에서의 IF - ELSE IF - ELSE문)

DECLARE
    SCORE NUMBER;
    GRADE VARCHAR2(1);
BEGIN
    SCORE := &점수;
    
    IF SCORE >= 90 THEN GRADE := 'A';
    ELSIF SCORE >= 80 THEN GRADE := 'B';
    ELSIF SCORE >= 70 THEN GRADE := 'C';
    ELSIF SCORE >= 60 THEN GRADE := 'D';
    ELSE GRADE := 'F';
    END IF;
    
    -- 당신의 점수는 XX점이고, 학점은 X학점입니다.
    DBMS_OUTPUT.PUT_LINE('당신의 점수는 ' || SCORE || '점이고, 학점은 ' || GRADE || '학점입니다.');
    
END;
/

-------------------------------------- 실습문제 ------------------------------------------

-- 사용자에게 입력받은 사번의 사원의 급여를 조회해서 SAL 변수에 대입
-- SAL에 담겨있는 값이 500만원 이상이면 '고급'
--                   300만원 이상이면 '중급'
--                   300만원 미만이면 '초급'
--'해당 사원의 급여등급은 XX입니다.' 라고 출력되도록

DECLARE
    SAL EMPLOYEE.SALARY%TYPE;
    GRADE VARCHAR2(10);
BEGIN
    SELECT SALARY
      INTO SAL
      FROM EMPLOYEE
     WHERE EMP_ID = &사번;
    
    IF SAL >= 5000000 THEN GRADE := '고급';
    ELSIF SAL >= 3000000 THEN GRADE := '중급';
    ELSE GRADE := '초급';
    END IF;

    DBMS_OUTPUT.PUT_LINE('해당 사원의 급여등급은 ' || GRADE || '입니다.');
END;
/

--------------------------------------------------------------------------------------------

-- 4) [표현법] CASE 비교대상자 WHEN 동등비교할값1 THEN 결과값1 WHEN 비교값2 WHEN 결과값2 ... ELSE 결과값 END; (자바에서의 SWITCH문)

DECLARE
    EMP EMPLOYEE%ROWTYPE;
    DNAME VARCHAR2(30);
BEGIN
    SELECT *
      INTO EMP
      FROM EMPLOYEE
     WHERE EMP_ID = &사번;
     
     DNAME := CASE EMP.DEPT_CODE
                WHEN 'D1' THEN '인사팀'
                WHEN 'D2' THEN '회계팀'
                WHEN 'D3' THEN '마케팅팀'
                WHEN 'D4' THEN '국내영업팀'
                WHEN 'D9' THEN '총무팀'
                ELSE '해외영업팀'
              END;
              
    DBMS_OUTPUT.PUT_LINE(EMP.EMP_NAME || '은 ' || DNAME || '입니다.');
END;
/