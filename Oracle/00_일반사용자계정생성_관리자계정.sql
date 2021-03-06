-- 한 줄 짜리 주석
/*
    여러 줄 주석
*/
SELECT * FROM DBA_USERS; --현재 존재하는 모든 계정들에 대해 조회하는 명령문
                         --하나의 명령문을 종료시키고자 할 때 ';'를 사용
--명령문 하나 실행(위쪽의 재생버튼 클릭 | CTRL + ENTER)

--일반 사용자계정 생성하는 구문 (오로지 관리자 계정에서만 할 수 있음)
--[표현법] CREATE USER 계정명 IDENTIFIED BY 비밀번호;(계정명은 대소문자를 가리지 않음, 비밀번호는 대소문자를 가림)
CREATE USER kh IDENTIFIED BY kh;

-- 위에서 생성된 일반 사용자계정에게 최소한의 권한(데이터관리, 접속) 부여해줘야함
-- [표현법] GRANT 권한1, 권한2, ... TO 계정명; => 여러개의 권한을 한꺼번에 줄 수 있다.
-- GRANT : 권한을 부여할 때 쓰는 명령문
GRANT RESOURCE, CONNECT TO KH; -- 계정명은 대소문자를 가리지 않음!
-- RESOURCE, CONNECT(해당 계정에 연결가능한 권한 부여) => 일반 사용자계정에게 줄 수 있는 최소한의 권한