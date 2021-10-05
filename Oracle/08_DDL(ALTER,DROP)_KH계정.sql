/*
    DDL (DATE DEFINITION LANGUAGUE) : 데이터 정의 언어
    
    객체들을 생성(CREATE), 변경(ALTER), 삭제(DROP)하는 구문
    
    < ALTER >
    객체를 변경하는 구문
    
    [표현식]
    ALTER TABLE 테이블명 변경할내용;
    
    * 변경할내용
    1) 컬럼 추가 / 수정 / 삭제
    2) 제약조건 추가 / 삭제 => 제약조건 수정은 불가! (수정하고자 한다면 삭제 후 새로이 추가하면됨)
    3) 컬럼명 / 제약조건명 / 테이블명 변경 

*/

-- 1) 컬럼 추가 / 수정 / 삭제

-- 1-1) 컬럼 추가(ADD) :  ALTER TABLE 테이블명 ADD 컬럼명 데이터타입 [DEFAULT 기본값]
-- DEPT_COPY 에 CNAME 컬럼 추가 
ALTER TABLE DEPT_COPY ADD CNAME VARCHAR2(20);
--> 새로운 컬럼이 만들어지고 기본적으로 NULL로 채워짐

-- DEPT_COPY에 LNAME 컬럼 추가 (기본값을 지정한채로)
ALTER TABLE DEPT_COPY ADD LNAME VARCHAR2(20) DEFAULT '한국';
--> 새로운 컬럼이 만들어지고 내가 지정한 기본값으로 채워짐

-- 1-2) 컬럼 수정(MODIFY) 

--   [표현법]
--    > 데이터 타입 수정 : ALTER TABLE 테이블명 MODIFY 컬럼명 바꾸고자하는데이터타입

--    > DEFAULT값 수정  : ALTER TABLE 테이블명 MODIFY 컬럼명 DEFAULT 바꾸고자하는기본값

-- DEPT_COPY 테이블에 DEPT_ID컬럼의 DATA_TYPE을 CHAR(2)에서 CHAR(3)으로 변경
ALTER TABLE DEPT_COPY MODIFY DEPT_ID CHAR(3);

-- DEPT_COPY 테이블에 DEPT_ID컬럼의 DATA_TYPE을 NUMBER타입으로 변경
ALTER TABLE DEPT_COPY MODIFY DEPT_ID NUMBER;
--> 오류발생 : "column to be modified must be empty to change datatype" 
--            CHAR에서 NUMBER타입으로 변경하고자 한다면 존재하는 데이터 값이 없어야한다.

-- DEPT_COPY 테이블에 DEPT_TITLE컬럼의 DATA_TYPE을 VARCHAR2(35) -> VARCHAR2(10)으로 변경
ALTER TABLE DEPT_COPY MODIFY DEPT_TITLE VARCHAR2(10);
--> 오류발생 : "cannot decrease column length because some value is too big"
--             담겨있는 데이터값들이 이미 10바이트 크기를 넘긴 상태이기 때문에 오류발생
--             바이트 수를 늘리는건 문제가 되지 않지만 줄일때는 담겨있는 데이터 수를 고려해야한다!

-- DEPT_COPY 테이블에 DEPT_TITLE컬럼의 DATA_TYPE을 VARCHAR2(35) -> VARCHAR2(40)으로 변경
-- DEPT_COPY 테이블에 LOCATION_ID컬럼의 DATA_TYPE을 CHAR(2) -> VARCHAR2(2)으로 변경
-- DEPT_COPY 테이블에 LNAME컬럼의 기본값을 '미국'으로 변경
ALTER TABLE DEPT_COPY 
    MODIFY DEPT_TITLE VARCHAR2(40)
    MODIFY LOCATION_ID VARCHAR2(2)
    MODIFY LNAME DEFAULT '미국';
    

-- 1_3) 컬럼 삭제(DROP COLUMN) : ALTER TABLE 테이블명 DROP COLUMN 삭제하고자하는컬럼명
CREATE TABLE DEPT_COPY2
AS SELECT * FROM DEPT_COPY;

-- DEPT_COPY2 테이블에 있는 DEPT_ID 컬럼 지우기
ALTER TABLE DEPT_COPY2 DROP COLUMN DEPT_ID;

-- DEPT_COPY2 테이블에 있는 DEPT_TITLE 컬럼 지우기
ALTER TABLE DEPT_COPY2 DROP COLUMN DEPT_TITLE;

-- DEPT_COPY2 테이블에 있는 CNAME 컬럼 지우기
ALTER TABLE DEPT_COPY2 DROP COLUMN CNAME;

-- DEPT_COPY2 테이블에 있는 LNAME 컬럼 지우기
ALTER TABLE DEPT_COPY2 DROP COLUMN LNAME;

-- DEPT_COPY2 테이블에 있는 LOCATION_ID 컬럼 지우기
ALTER TABLE DEPT_COPY2 DROP COLUMN LOCATION_ID;
-- 오류발생 : cannot drop all columns in a table
--           최소 한개의 컬럼은 존재해야하기 때문에 오류가 발생

-----------------------------------------------------------------------------------------
-- 2) 제약조건 추가 / 삭제

/*
    2_1) 제약조건 추가 
    PRIMARY KEY :  ALTER TABLE 테이블명 ADD PRIMARY KEY(컬럼명)
    FOREIGN KEY :  ALTER TABLE 테이블명 ADD FOREIGN KEY(컬럼명) REFERENCES 참조할테이블명[(컬럼명)]
    UNIQUE      :  ALTER TABLE 테이블명 ADD UNIQUE(컬럼명)
    CHECK       :  ALTER TABLE 테이블명 ADD CHECK(컬럼에 대한 조건)
    NOT NULL    :  ALTER TABLE 테이블명 MODIFY 컬럼명 NULL | NOT NULL
    
    제약조건명을 지정하고자 한다면 [CONSTRAINT 제약조건명] 제약조건
*/

-- DEPT_COPY 테이블에 DEPT_ID에 PRIMARY KEY 제약조건 추가 ADD
-- DEPT_COPY 테이블에 DEPT_TITLE에 UNIQUE 제약조건 추가 ADD
-- DEPT_COPY 테이블에 NOT NULL 제약조건 추가 MODIFY
ALTER TABLE DEPT_COPY 
    ADD CONSTRAINT DCOPY_PK PRIMARY KEY(DEPT_ID)
    ADD CONSTRAINT DCOPY_UQ UNIQUE(DEPT_TITLE)
    MODIFY LNAME CONSTRAINT DCOPY_NL NOT NULL;

-- 2_2) 제약조건 삭제 : ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건명
--                    ALTER TABLE 테이블명 MODIFY 컬럼명 NULL (NOT NULL 제약조건일 경우)
ALTER TABLE DEPT_COPY DROP CONSTRAINT DCOPY_PK;

ALTER TABLE DEPT_COPY DROP CONSTRAINT DCOPY_UQ
                      MODIFY LNAME NULL;
                      
------------------------------------------------------------------------------------------

-- 3) 컬럼명 / 제약조건명 / 테이블명 변경 (RENAME)

-- 3_1) 컬럼명 변경 : ALTER TABLE 테이블명 RENAME COLUMN 기존컬럼명 TO 바꿀컬럼명
-- DEPT_TITLE => DEPT_NAME
ALTER TABLE DEPT_COPY RENAME COLUMN DEPT_TITLE TO DEPT_NAME;

-- 3_2) 제약조건명 변경 : ALTER TABLE 테이블명 RENAME CONSTRAINT 기존제약조건명 TO 바꿀제약조건명
-- SYS_C007165 => DCOPY_LID_NM
ALTER TABLE DEPT_COPY RENAME CONSTRAINT SYS_C007165 TO DCOPY_LID_NM;

-- 3_3) 테이블명 변경 : ALTER TABLE 테이블명 RENAME TO 바꿀테이블명
-- DEPT_COPY => DEPT_TEST
ALTER TABLE DEPT_COPY RENAME TO DEPT_TEST;

------------------------------------------------------------------------------------------


-- 테이블 삭제
DROP TABLE DEPT_TEST;

-- 단, 어디선가 참조되고 있는 부모테이블의 경우 함부로 삭제가 안됨
-- 만약에 삭제하고자 한다면
-- 방법 1. 자식테이블을 먼저 삭제한 후 부모테이블을 삭제하는 방법
-- 방법 2. 그냥 부모테이블만 삭제하는데 제약조건까지 같이 삭제하는 방법

