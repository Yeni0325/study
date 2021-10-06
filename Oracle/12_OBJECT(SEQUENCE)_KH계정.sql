/*
    < 시퀀스 SEQUENCE >
    자동으로 번호를 발생시켜주는 역할을 하는 객체
    정수값을 순차적으로 일정값씩 증가시키면서 생성해줌
    
    EX) 회원번호, 사원번호, 게시글번호, ...
*/

/*
    1. 시퀀스 객체 생성
    
    [표현법]
    CREATE SEQUENCE 시퀀스명
    [START WITH 시작숫자]       --> 처음 발생시킬 시작값 지정 (생략 시 기본값 1)
    [INCREMENT BY 숫자]        --> 몇 씩 증가시킬건지 지정 (생략 시 기본값 1)
    [MAXVALUE 숫자]            --> 최대값 지정 (생략 시 기본값 엄청큼)
    [MINVALUE 숫자]            --> 최소값 지정 (생략 시 기본값 1)
    [CYCLE|NOCYCLE]            --> 값 순환 여부 지정 (생략 시 기본값 NOCYCLE)
    [NOCACHE|CACHE 바이트크기]  --> 캐시메모리 할당 (생략 시 기본값 CACHE 20) 
    
    * 캐시메모리 : 미리 발생될 값들을 생성해서 저장해두는 공간
                  매번 호출될때마다 새로이 번호를 생성하는게 아니라 
                  캐시메모리 공간에 미리 생성된 값들을 가져다 쓸 수 있음 (속도가 빨라짐)
                  접속이 해제되면 => 캐시메모리에 미리 만들어 둔 번호들은 다 날라감 (휘발성)

    테이블명 : TB_
    뷰명    : VW_
    시퀀스명 : SEQ_
    트리거명 : TRG_
*/

CREATE SEQUENCE SEQ_TEST;

-- [참고] 현재 접속한 계정이 소유하고 있는 시퀀스들의 전반적인 구조를 보고자 할 때 
SELECT * FROM USER_SEQUENCES;

CREATE SEQUENCE SEQ_EMPNO
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCYCLE
NOCACHE;

/*
    2. 시퀀스 사용
    
    [표현법]
    시퀀스명.CURRVAL : 현재 시퀀스의 값 (마지막으로 성공적으로 수행된 NEXTVAL의 값)
    시퀀스명.NEXTVAL : 시퀀스의 값에 일정값을 증가시켜서 발생된 값
                      현재 시퀀스 값에서 INCREMENT BY 값 만큼 증가된 값
                      == 시퀀스명.CURRVAL + INCREMENT BY 값
*/

SELECT SEQ_EMPNO.CURRVAL FROM DUAL;
-- 오류발생 : sequence SEQ_EMPNO.CURRVAL is not yet defined in this session
-- NEXTVAL을 단 한번도 수행하지 않는 이상 CURRVAL 할 수 없음
-- 왜? : CURRVAL은 마지막으로 성공적으로 수행된 NEXTVAL의 값을 저장해서 보여주는 임시값

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 300
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 300

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 305
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 310

SELECT * FROM USER_SEQUENCES;

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 지정한 NAXVALUE값을 초과했기 때문에 오류 발생 (실패)
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 310

/*
    3. 시퀀스 구조 변경
    
    [표현법]
    ALTER SEQUENCE 시퀀스명
    [INCREMENT BY 숫자]        --> 몇 씩 증가시킬건지 지정 (생략 시 기본값 1)
    [MAXVALUE 숫자]            --> 최대값 지정 (생략 시 기본값 엄청큼)
    [MINVALUE 숫자]            --> 최소값 지정 (생략 시 기본값 1)
    [CYCLE|NOCYCLE]            --> 값 순환 여부 지정 (생략 시 기본값 NOCYCLE)
    [NOCACHE|CACHE 바이트크기]  --> 캐시메모리 할당 (생략 시 기본값 CACHE 20) 

    * START WITH 은 변경 불가!    
*/

ALTER SEQUENCE SEQ_EMPNO
INCREMENT BY 10
MAXVALUE 400;

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 310 + 10 => 320

-- 4. 시퀀스 삭제
DROP SEQUENCE SEQ_EMPNO;

------------------------------------------------------------------------------------------

-- 사원번호로 활용할 시퀀스 생성
CREATE SEQUENCE SEQ_EID
START WITH 400
NOCACHE;

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
         SEQ_EID.NEXTVAL
       , '홍길동'
       , '111111-1111111'
       , 'J7'
       , SYSDATE
        );

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
         SEQ_EID.NEXTVAL
       , '강개순'
       , '222222-2222222'
       , 'J6'
       , SYSDATE
        );







