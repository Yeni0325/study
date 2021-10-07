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

------------------------------------------------------------------------------------------

-- < 반복문 >

/*
    1) BAISC LOOP 문
    
    [표현법]
    LOOP 
        반복적으로 실행할 구문;                => (기본적으로 무한반복, 자바에서의 WHILE문)
        * 반복문을 빠져나갈 수 있는 구문`
    END LOOP;
    
    * 반복문을 빠져나갈 수 있는 구문 (2가지)
    1) IF 조건식 THEN EXIT; END IF;    => 해당 조건식이 참일경우 EXIT을 통해 빠져나가겠다.
    2) EXIT WHEN 조건식;               => EXIT 빠져나가겠다. WHEN? 해당 조건식이 참일경우 
    
*/

-- 1~5까지 순차적으로 1씩 증가하는 값을 출력
SET SERVEROUTPUT ON;
DECLARE
    I NUMBER := 1;     --> 대입과 동시에 초기화
BEGIN
    
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
        I := I + 1;                   --> 자바에서는 I++라는 증감연산자가 존재했지만 SQL에서는 이와같이 표현해야함
        
        -- IF I = 6 THEN EXIT; END IF;
        EXIT WHEN I = 6;
    END LOOP;
    
END;
/

-----------------------------------------------------------------------------------------

/*
    2) FOR LOOP 문
    
    [표현법]
    FOR 변수 IN [REVERSE] 초기값..최종값         => 초기값부터 최종값까지 매번 1씩 증가하면서 알아서 반복이 된다. 
    LOOP                                       =>  REVERSE 를 붙이면 최종값부터 초기값까지 1씩 감소된다. 
        반복적으로 실행할 구문;                   => (자바에서의 FOR문)
    END LOOP;
*/
-- FOR LOOP문의 경우 FOR LOOP문 안에서 변수를 선언하는 구문이 존재하므로 DECLEAR 선언부 생략이 가능하다.
BEGIN
    FOR I IN 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
    END LOOP;
END;
/

BEGIN
    FOR I IN REVERSE 1..5             --> 최종값부터 초기값까지 1씩 감소된 값 출력
    
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
    END LOOP;
END;
/

DROP TABLE TEST;

CREATE TABLE TEST(
    TNO NUMBER PRIMARY KEY,
    TDATE DATE
);

CREATE SEQUENCE SEQ_TNO
START WITH 1
INCREMENT BY 2
MAXVALUE 1000
NOCYCLE
NOCACHE;

-- TEST 테이블에 반복문을 활용해서 데이터 값 넣기
BEGIN
    FOR I IN 1..100
    LOOP
        INSERT INTO TEST VALUES(SEQ_TNO.NEXTVAL, SYSDATE);
    END LOOP;
    
END;
/

SELECT * FROM TEST;

------------------------------------------------------------------------------------------

/*
    3) WHILE LOOP 문
    
    [표현법]
    WHILE 반복문이수행될조건      --> 참이어야 반복문이 수행되고, 거짓이되는 순간 반복문을 빠져나옴
    LOOP
        반복적으로 실행할 구문;
    END LOOP;
*/

DECLARE
    I NUMBER := 1;
BEGIN
    
    WHILE I < 6
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
        I := I + 1;
    END LOOP;
END;
/

---------------------------------------------------------------------------------------

/*
    3. EXCEPTION SECTION 예외처리부
    
    예외(EXCEPTION) : 실행 중 발생하는 오류
    
    [표현법]
    EXCEPTION                                 => 자바에서의 TRY~CATCH문
        WHEN 예외명1 THEN 예외처리구문1;        => TRY가 BEGIN문에 해당, WHEN ~ THEN 부분이 CATCH문에 해당 
        WHEN 예외명2 THEN 예외처리구문2;
        ...
        WHEN OTHERS THEN 예외처리구문N;         => 어떤 예외가 발생하던간에 OTHERS를 사용하면 모든 예외에 대한 예외처리구문 작성이 가능하다.

        
        * 시스템 예외 (오라클에서 미리 정의해둔 예외)
        - NO_DATA_FOUND : SELECT한 결과가 한 행도 없을 경우
        - TOO_MANY_ROWS : SELECT한 결과가 여러행일 경우
        - ZERO_DEVIDE : 0으로 나눌 때 
        - DUP_VAL_ON_INDEX : UNIQUE 제약조건에 위배되었을 경우 (중복된 값이 있다)
        ... 
*/

-- 사용자가 입력한 수로 나눗셈 연산한 결과 출력
DECLARE
    RESULT NUMBER;
BEGIN
    RESULT := 10 / &숫자;
    DBMS_OUTPUT.PUT_LINE('결과 : ' || RESULT);
EXCEPTION
    --WHEN ZERO_DIVIDE THEN DBMS_OUTPUT.PUT_LINE('나누기 연산 시 0으로 나눌 수 없습니다.');
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('나누기 연산 시 0으로 나눌 수 없습니다.');
END;
/

-- UNIQUE 제약조건 위배
BEGIN
    UPDATE EMPLOYEE
       SET EMP_ID = '&변경할사번'
     WHERE EMP_NAME = '노옹철';
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN DBMS_OUTPUT.PUT_LINE('이미 존재하는 사번입니다.');
END;
/

DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME
      INTO EID, ENAME
      FROM EMPLOYEE
     WHERE MANAGER_ID = &사수사번;
     
     DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
     DBMS_OUTPUT.PUT_LINE('이름 : ' || ENAME);
EXCEPTION
    WHEN TOO_MANY_ROWS THEN DBMS_OUTPUT.PUT_LINE('너무 많은 행이 조회되었습니다.');
    WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('조회 결과가 없습니다.');
END;
/















