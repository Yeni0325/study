/*
    < �Լ� FUNCTION >
    ���޵� �÷����� �о�鿩�� �Լ��� ������ ����� ��ȯ��
    
    - ������ �Լ� : N���� ���� �����ϸ�, N���� ������� ���� (�� �ึ�� �Լ��� ������Ѽ� ����� ��ȯ����)
    - �׷� �Լ� : N���� ���� �����ص�, 1���� ������� ���� (�׷��� ���� �׷캰�� �Լ��� ������� ����� ��ȯ����)
    
    >> SELECT ���� ������ �Լ��� �׷��Լ��� �Բ� ��� ���Ѵ�.
        WHY? ��� ���� ������ �ٸ��� ������
    
    >> �Լ����� ����� �� �ִ� ��ġ : SELECT��, WHERE��, ORDER BY��, GROUP BY��, HAVING�� 
*/

--================================= < ������ �Լ� > ====================================
/*
    < ���� ó�� �Լ� >
    
    * LENGTH / LEGNTHB        => ����� : NUMBER Ÿ��
    
    [ǥ����]
    LENGTH(�÷�|'���ڿ���') : �ش� ���ڿ����� "���ڼ�" ��ȯ
    LENGTHB(�÷�|'���ڿ�') : �ش� ���ڿ����� "����Ʈ��" ��ȯ
    
    '��' '��' '��' �ѱ� �ѱ��ڴ� 3BYTE
    ������, ����, Ư������ �ѱ��ڴ� 1BYTE
*/

SELECT LENGTH('����Ŭ'), LENGTHB('����Ŭ')
FROM DUAL; -- ����Ŭ���� �����ϴ� �������̺�(�������̺�)!

SELECT LENGTH('ORACLE'), LENGTHB('ORACLE')
FROM DUAL;

-- EMPLOYEE���� ������� �̸��� �� ������� ���ڼ��� ����Ʈ ��, �̸��ϰ� �� ������� �̸��� ���� ����Ʈ �� ��ȸ
SELECT EMP_NAME, LENGTH(EMP_NAME), LENGTHB(EMP_NAME), EMAIL, LENGTH(EMAIL), LENGTHB(EMAIL)
FROM EMPLOYEE;

----------------------------------------------------------------------------------------------------

/*
    * INSTR
    ���ڿ��κ��� Ư�� ������ "������ġ"�� ã�Ƽ� ��ȯ (�ڹٿ��� �ε��� ������ġ�� 0, ����Ŭ������ 1���� ����)
    
    [ǥ����]
    INSTR(�÷�|'���ڿ���', 'ã�����ϴ¹���', [ã����ġ�� ���۰�, [����]])    => ����� : NUMBER Ÿ��
    
    - ã����ġ�� ���۰�
    1 : �ش� ���ڸ� ���ڿ��κ��� �տ������� ã�ڴٴ� �ǹ�
    -1 : �ش� ���ڸ� ���ڿ��κ��� �ڿ������� ã�ڴٴ� �ǹ� 
    
    - ���� : ���°�� ��ġ�ϴ� ������ ã�� ���� �ۼ�
    
    ã���� ������ ��ġ�� �տ������� ���� ��ȯ���ش�!!
    
*/

-- 'AABAACAABBAA' ���� 'B'��� ���ڸ� ã�ڴ�
SELECT INSTR('AABAACAABBAA', 'B')  -- 'ã�� ��ġ�� ���۰�'�� '����'�� ������ ��� �տ������� �ش� ���ڸ� ã��
FROM DUAL;                         -- ã�� ��ġ�� ���۰��� �⺻���� 1, ������ ������ �⺻���� 1


-- 'AABAACAABBAA' ���� 'B'��� ���ڸ� �տ������� ã�ڴ�
SELECT INSTR('AABAACAABBAA', 'B', 1)  -- '����' ������ �⺻���� 1
FROM DUAL; 

-- 'AABAACAABBAA' ���� 'B'��� ���ڸ� �ڿ������� ã�ڴ�
SELECT INSTR('AABAACAABBAA', 'B', -1)  -- '����' ������ �⺻���� 1
FROM DUAL;                             -- ã���� ������ ��ġ�� �տ������� ���� ��ȯ���ش�!!

-- 'AABAACAABBAA' ���� 'B'��� ���ڸ� �տ������� ã��, �ι�°�� �ش��ϴ� ���ڸ� ã�ڴ�
SELECT INSTR('AABAACAABBAA', 'B', 1, 2)
FROM DUAL;

-- 'AABAACAABBAA' ���� 'B'��� ���ڸ� �ڿ������� ã��, ����°�� �ش��ϴ� ���ڸ� ã�ڴ�
SELECT INSTR('AABAACAABBAA', 'B', -1, 3)
FROM DUAL;

-- EMPLOYEE���� �� ����� EMAIL���� ��ȸ
SELECT EMAIL
FROM EMPLOYEE;

-- EMPLOYEE���� �� ����� EMAIL���� �� '-'�� ��ġ�� '@'�� ��ġ ���� ��ȸ  
SELECT EMAIL, INSTR(EMAIL, '_', 1, 1) "_��ġ", INSTR(EMAIL, '@') "@��ġ"
FROM EMPLOYEE;

-------------------------------------------------------------------------------------

/*
    * SUBSTR
    ���ڿ����� Ư�� "���ڿ�"�� �����ؼ� ��ȯ�����ִ� �Լ� (�ڹٿ��� SUBSTRING()�޼ҵ�� ����)
    
    [ǥ����]
    SUBSTR(STRING, POSITION, [LENGTH])       => ����� : CHARACTERŸ��(���ڿ� Ÿ��)
    - STRING : ����Ÿ���÷� �Ǵ� '���ڿ���'
    - POSITION : ���ڿ��� ������ ������ġ�� (���������ε� ���� ����)
    - LENGTH : �����ϰ����ϴ� ������ ���� (������ ������ ����) (������ ���ý� �������Ѱ��� ���������Ƿ� NULL���� ����)
*/

-- 'SHOWMETHEMONEY' ���ڿ��κ��� 7��° ��ġ���� ������ �����ϰڴ�
SELECT SUBSTR('SHOWMETHEMONEY', 7) FROM DUAL;

-- 'SHOWMETHEMONEY' ���ڿ��κ��� 5��° ��ġ���� 2���ڸ� �����ϰڴ�.
SELECT SUBSTR('SHOWMETHEMONEY', 5, 2) FROM DUAL;

-- 'SHOWMETHEMONEY' ���ڿ��κ��� 1��° ��ġ���� 6���ڸ� �����ϰڴ�.
SELECT SUBSTR('SHOWMETHEMONEY', 1, 6) FROM DUAL;

-- 'SHOWMETHEMONEY' ���ڿ��κ��� �ڿ��� 8��° ��ġ���� 3���ڸ� �����ϰڴ�.
SELECT SUBSTR('SHOWMETHEMONEY', -8, 3) FROM DUAL;

-- EMPLOYEE���� ������� �����, �ֹι�ȣ ��ȸ
SELECT EMP_NAME, EMP_NO
FROM EMPLOYEE;

-- EMPLOYEE���� ������� �����, �ֹι�ȣ, �ֹι�ȣ �� ������ ��ȸ
SELECT EMP_NAME, EMP_NO, SUBSTR(EMP_NO, 8, 1) AS "����"
FROM EMPLOYEE;

-- EMPLOYEE���� ���ڻ���鸸 ��ȸ
SELECT EMP_NAME
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '2' OR SUBSTR(EMP_NO, 8, 1) = '4';   -- SELECT�� �ƴ϶� WHERE�������� �Լ� ����� �����ϴ�.

-- EMPLOYEE���� ���ڻ���鸸 ��ȸ
SELECT EMP_NAME
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '1' OR SUBSTR(EMP_NO, 8, 1) = '3';
-- WHERE SUBSTR(EMP_NO, 8, 1) IN ('1', '3');   => IN�� Ȱ���� ���ǽ����ε� Ȱ�밡��!
-- WHERE SUBSTR(EMP_NO, 8, 1) IN (1, 3) => SUBSTR( )�� ���ڿ�, IN ( ) �� ����Ÿ���̾ ����Ŭ���� ���������� �ڵ�����ȯ�� ����Ǽ� �������� ���� ����ȴ�.

-- EMPLOYEE���� ���ڻ���鸸 ������������ ��ȸ
SELECT EMP_NAME
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN (1, 3)
ORDER BY EMP_NAME;
-- ORDER BY 1 ASC;


-- �Լ� ��ø��� ����
-- �� ����� �̸��� �̸���('@'���� �ȳ�����) ��ȸ
SELECT EMP_NAME, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) AS "���̵�"
FROM EMPLOYEE;

-------------------------------------------------------------------------------------

/*
    * LPAD / RPAD (LPAD : ���� / RPAD : ������)
    ���ڿ��� ��ȸ�� �� ���ϰ��ְ� ��ȸ�ϰ��� �� �� ����ϴ� �Լ�
    
    [ǥ����]
    LPAD/RPAD(STRING, ���������� ��ȯ�� �����Ǳ���, [�����̰��� �ϴ� ����])    => ����� : CHARACTER Ÿ��(���ڿ� Ÿ��)
    - STRING : ����Ÿ���÷� �Ǵ� '���ڿ���'
    - �����̰��� �ϴ� ���� (��������, ���� �� �������� ä����)
    
    ���ڿ��� �����̰����ϴ� ���ڸ� LPAD�� ���ʿ�, RPAD�� �����ʿ� ���ٿ��� ���������� ���ϴ� N���̸�ŭ�� ���ڿ��� ��ȯ
*/

-- EMPLOYEE���� ������� �̸�, �̸���(����������) ��ȸ
SELECT EMP_NAME, LPAD(EMAIL, 20)    -- 20��ŭ�� ���� �� EMAIL�÷����� ���������� �����ϰ� �����̰����ϴ� ���ڸ� ���þ��߱� ������ ������ �κ��� �������� ���ʿ� ä����
FROM EMPLOYEE;

-- EMPLOYEE���� ������� �̸�, �̸���(����������, ���鿡 '#"ä����) ��ȸ
SELECT EMP_NAME, LPAD(EMAIL, 20, '#')
FROM EMPLOYEE;

-- EMPLOYEE���� ������� �̸�, �̸���(��������, ���鿡 '#"ä����) ��ȸ
SELECT EMP_NAME, RPAD(EMAIL, 20, '#')
FROM EMPLOYEE;

-- �ֹι�ȣ���� �����ڸ��ں��ʹ� '*'�� ��ȸ => �ֹι�ȣ �� ���� �� : 14����
SELECT RPAD('940325-2', 14, '*') FROM DUAL;

-- EMPLOYEE�� ��ü����� �����, �ֹι�ȣ(�����ڸ� ���ĺκ��� '*'�� ��ȸ) ��ȸ
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*') -- RPAD(�ֹι�ȣ������ �����ڸ����� ������ ���ڿ�, 14, '*')
FROM EMPLOYEE;

-- ���� ������ ����� �ٸ� ���(���Ῥ���� ���)���� ��ȸ
SELECT EMP_NAME, SUBSTR(EMP_NO, 1, 8) || '******'
FROM EMPLOYEE;

-----------------------------------------------------------------------------------------------------------

/*
    * LTRIM / RTRIM
    ���ڿ����� Ư�� ���ڸ� ������ �������� ��ȯ
    
    [ǥ����]
    LTRIM/RTRIM(STRING, [�����ϰ����ϴ� ���ڵ�])        => ����� : CHARACTERŸ��(���ڿ� Ÿ��)
    - STRING : ����Ÿ���÷� �Ǵ� '���ڿ���'
    - �����ϰ����ϴ� ���ڵ� : ���� �� ������ ã�Ƽ� �������ش�.
    
    ���ڿ��� ���� Ȥ�� �����ʿ��� �����ϰ����ϴ� ���ڵ��� ã�Ƽ� ���Ž�Ű��, ������ ������ ���ڿ��� ��ȯ���ִ� �Լ�
*/

-- ������ ���ڿ��� '   K H '���� ������ �����ϰ�, ���� �� ���ڿ��� ��ȸ 
SELECT LTRIM('   K H ') FROM DUAL;    -- => ���ʿ� �ִ� 3���� ������ ����, �߰��� ���� �ִ� ������ ���ŵ��� ����
                                      -- => ���ʿ� �ִ� ���� ���� �� �ٸ� ���ڸ� ������ ������ �Ŀ� �ش� ���� ��ȸ
                                      
-- ������ ���ڿ��� '123123KH123'���� ���ʿ��� '123'�� ���Ž�Ű��, ���� �� ���ڿ��� ��ȸ
SELECT LTRIM('123123KH123', '123') FROM DUAL;

-- ������ ���ڿ��� 'ACABACCKH' ���� ���ʿ��� 'ABC'�� ���Ž�Ű��, ���� �� ���ڿ��� ��ȸ
SELECT LTRIM('ACABACCKH', 'ABC') FROM DUAL;   --> 'ABC'��� ������ ���ڿ��� �������� �ʴµ�, 'ABC'�� ���� �ش� ���ڿ��κ��� 'A', 'B', 'C'�� ã�Ƽ� ������ ��� ��� �����ϴ�
                                              --> ���� ��������� 'KH'�� ��ȸ�ȴ�.

-- ������ ���ڿ��� '5782KH123'���� �����ʿ��� '0123456789'�� ���Ž�Ű��, ���� �� ���ڿ��� ��ȸ
SELECT RTRIM('5782KH123', '0123456789') FROM DUAL;

/*
    * TRIM
    ���ڿ����� ��/��/���ʿ� �ִ� Ư�� ���ڸ� ������ �������� ��ȯ
    �⺻������ ���ʿ� �ִ� ���ڵ� �� ã�Ƽ� �������ش�.
    
    [ǥ����]
    TRIM([ [LEADING|TRAILING|BOTH] �����ϰ����ϴ� ���ڵ� FROM ] STRING)        => ����� : CHARACTERŸ��(���ڿ� Ÿ��)
    - LEADING : ����
    - TRAILING : ����
    - STRING : ����Ÿ���÷� �Ǵ� '���ڿ���'
    - �����ϰ����ϴ� ���ڵ� : ���� �� ������ ã�Ƽ� �������ش�. 
*/

-- ������ ���ڿ��� '   K H   '���� ������ �����ϰ�, ���� �� ���ڿ��� ��ȸ
SELECT TRIM('   K H   ') FROM DUAL; 
-- TRIM : �⺻������ ���ʿ� �ִ� ���ڵ� �� ã�Ƽ� ����

-- ������ ���ڿ��� 'ZZZKHZZZ' ���� 'Z'�� �����ϰ�, ���� �� ���ڿ��� ��ȸ
SELECT TRIM('Z' FROM 'ZZZKHZZZ') FROM DUAL;
-- 'Z'��� ���ڿ��� �����Ұǵ� FROM 'ZZZKHZZZ'�κ��� �����ϰڴ�.

-- ������ ���ڿ��� 'ZZZKHZZZ' ���� 'Z'�� ���ʿ����� �����ϰ�, ���� �� ���ڿ��� ��ȸ
SELECT TRIM(LEADING 'Z' FROM 'ZZZKHZZZ') FROM DUAL;  -- LEADING : ��   => LTRIM�� ����

-- ������ ���ڿ��� 'ZZZKHZZZ' ���� 'Z'�� ���ʿ����� �����ϰ�, ���� �� ���ڿ��� ��ȸ
SELECT TRIM(TRAILING 'Z' FROM 'ZZZKHZZZ') FROM DUAL; -- TRAILING : ��  => RTRIM�� ����

-- ������ ���ڿ��� 'ZZZKHZZZ' ���� 'Z'�� �����ϰ�, ���� �� ���ڿ��� ��ȸ
SELECT TRIM(BOTH 'Z' FROM 'ZZZKHZZZ') FROM DUAL; -- BOTH : ����  => ���� �� �⺻ ��

-----------------------------------------------------------------------------------------

/*
    * LOWER / UPPER / INITCAP
    
    [ǥ����]
    LOWER/UPPER/INITCAP(STRING)     => ����� : CHARACTERŸ�� (���ڿ� Ÿ��)
    - LOWER : �� �ҹ��ڷ� ������ ���ڿ� ��ȯ (�ڹٿ����� toLowerCase()�޼ҵ�� ����)
    - UPPER : �� �빮�ڷ� ������ ���ڿ� ��ȯ (�ڹٿ����� toUpperCase()�޼ҵ�� ����)
    - INITCAP : �ܾ� �ձ��ڸ��� �빮�ڷ� ������ ���ڿ� ��ȯ
    - STRING : ����Ÿ���÷� �Ǵ� '���ڿ���'
*/

-- �ش� ���ڿ�()�� ���� �ҹ��ڷ� ������ ���ڿ� ��ȯ
SELECT LOWER('Welcome To My World!') FROM DUAL;

-- �ش� ���ڿ�()�� ���� �빮�ڷ� ������ ���ڿ� ��ȯ
SELECT LOWER('Welcome To My World!') FROM DUAL;

-- �ش� ���ڿ�()�� �ܾ� �ձ��ڸ��� �빮�ڷ� ������ ���ڿ� ��ȯ
SELECT INITCAP('welcome to myworld!') FROM DUAL;

----------------------------------------------------------------------------------------

/*
    * CONCAT
    ���ڿ� �ΰ� ���޹޾� �ϳ��� ��ģ �� ��� ��ȯ
    
    [ǥ����]
    CONCAT(STRING, STRING)  => ����� : CHARACTERŸ��(���ڿ� Ÿ��)
    - STRING : '���ڿ���'(������ 2��)
*/

-- �ΰ��� ���ڿ��� ��ģ �� ��ȸ
SELECT CONCAT('������', 'ABC') FROM DUAL;

-- ���� ������ ��� �� ��ȸ
SELECT '������'||'ABC' FROM DUAL;

-- 3���� ���ڿ��� ��ģ �� ��ȸ
SELECT CONCAT('������', 'ABC', '123') FROM DUAL; -- �����߻� : 2���� ���ڿ� �ۿ� �ȵ�
SELECT '������'||'ABC'||'123' FROM DUAL;

------------------------------------------------------------------------------------

/*
    * REPLACE
    
    [ǥ����]
    REPLACE(STRING, STR1, STR2)     => ����� : CHARACTERŸ�� (���ڿ� Ÿ��)
    - STRING : ������ ���ϴ� ���� ���Ե� ���ڿ�
    - STR1 : ������ ���ϴ� ��
    - STR2 : ������ ��
*/

-- EMPLOYEE���� ������� �̸��� �̸���('kh.or.kr'�κ��� 'gmail.com'�� �ٲ���) ��ȸ
SELECT EMP_NAME, REPLACE(EMAIL, 'kh.or.kr', 'gmail.com')
FROM EMPLOYEE;

------------------------------------------------------------------------------------

/*
    < ���� ó�� �Լ� >
    
    * ABS
    ������ ���밪�� �����ִ� �Լ�
    
    [ǥ����]
    ABS(NUMBER)         => ����� : NUMBERŸ�� (����Ŭ���� NUMBERŸ���� ����, �Ǽ��� �������� ����)
*/
SELECT ABS(-10) FROM DUAL;
SELECT ABS(-5.7) FROM DUAL;

-------------------------------------------------------------------------------------

/*
    * MOD
    �� ���� ���� ���������� ��ȯ���ִ� �Լ�
    
    [ǥ����]
    MOD(NUMBER, NUMBER)   => ����� : NUMBERŸ��
*/
SELECT MOD(10, 3) FROM DUAL;
SELECT MOD(10.9, 3) FROM DUAL;

--------------------------------------------------------------------------------------

/*
    * ROUND
    �ݿø��� ����� ��ȯ�����ִ� �Լ�
    
    [ǥ����]
    ROUND(NUMBER, [��ġ])    => ����� : NUMBERŸ��
    - ��ġ : �Ҽ��� ���°�ڸ����� ��Ÿ������(��������, �⺻���� 0)
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
    �ø�ó�����ִ� �Լ��� �ø���ġ�� ������ �� ����.
    ������ �������·� ��ȯ
    
    [ǥ����]
    CEIL(NUMBER) 
*/

SELECT CEIL(123.152) FROM DUAL;

-------------------------------------------------------------------------------------------

/*
    * FLOOR
    �Ҽ��� �Ʒ��� �� ����ó���ϴ� �Լ��� ������ġ�� ������ �� ����.
    ������ �������·� ��ȯ
    
    [ǥ����]
    FLOOR(NUMBER)
*/

SELECT FLOOR(123.152) FROM DUAL;
SELECT FLOOR(123.952) FROM DUAL;

--------------------------------------------------------------------------------------------

/*
    * TRUNC
    ��ġ ������ ������ ����ó�����ִ� �Լ�
    
    [ǥ����]
    TRUNC(NUMBER, [��ġ])
    - ��ġ : �Ҽ��� ���°�ڸ����� ��Ÿ������(��������, �⺻���� 0)
    
    ���ٸ� ��ġ������ ���� ���� ��� FLOOR�Լ��� �����ϴ�
*/

SELECT TRUNC(123.456) FROM DUAL;
SELECT TRUNC(123.456, 1) FROM DUAL;
SELECT TRUNC(123.456, -1) FROM DUAL;

-------------------------------------------------------------------------------------------

/*
    < ��¥ ó�� �Լ� >
*/

-- * SYSDATE : �ý��� ��¥ �� �ð��� ��ȯ ���ִ� �Լ� (���� ��¥ �� �ð�)
SELECT SYSDATE FROM DUAL;

-- * MONTHS_BETWEEN(DATE1, DATE2) : �� ��¥ ������ ���� ���� ��ȯ���ִ� �Լ� => ���������� DATE1 - DATE2 �� ������ 30, 31�� ����ȴ�
--   => ������� NUMBERŸ��
-- EMPLOYEE���� �����, �Ի���, �ٹ��ϼ�, �ٹ�������
SELECT EMP_NAME, HIRE_DATE, FLOOR(SYSDATE-HIRE_DATE) "�ٹ��ϼ�", CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) || '������' "�ٹ�������"
FROM EMPLOYEE;

-- * ADD_MONTHS(DATE, NUMBER) : Ư�� ��¥(DATE)�� �ش� ����(NUMBER)��ŭ�� �������� ���ؼ� �� ��¥�� �������ִ� �Լ�
--   => ������� DATEŸ��
-- ���ó�¥�κ��� 5���� ���� ��¥
SELECT ADD_MONTHS(SYSDATE, 5) FROM DUAL;

-- EMPLOYEE���� �����, �Ի���, �Ի��� �� 6������ ��¥
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE, 6)
FROM EMPLOYEE;

-- * NEXT DAY(DATE, ����(����|����)) : Ư�� ����(DATE) ���Ŀ� ����� �ش� ������ ��¥�� ��ȯ���ִ� �Լ�
--   => ������� DATEŸ��
-- ���ó�¥�κ��� ����� �ݿ����� ��¥
SELECT SYSDATE, NEXT_DAY(SYSDATE, '�ݿ���') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '��') FROM DUAL;
-- 1: �Ͽ���, 2: ������, ... 6 : �ݿ���, 7 : �����
SELECT SYSDATE, NEXT_DAY(SYSDATE, 6) FROM DUAL;

SELECT SYSDATE, NEXT_DAY(SYSDATE, 'FRIDAY') FROM DUAL; -- ���� (����� KOREAN�̱� ����)

-- ��� ����
ALTER SESSION SET NLS_LANGUAGE = AMERICAN;

SELECT SYSDATE, NEXT_DAY(SYSDATE, 'FRIDAY') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '�ݿ���') FROM DUAL; -- ����

-- ��� ����
ALTER SESSION SET NLS_LANGUAGE = KOREAN;

-- * LAST_DAY(DATE) : Ư�� ��¥(DATE)�� ���Ե� ���� ������ ��¥�� ��ȯ���ִ� �Լ�
--   => ����� DATEŸ��
-- �̹����� ������ ��¥
SELECT LAST_DAY(SYSDATE) FROM DUAL;

-- EMPLOYEE���� �����, �Ի���, �Ի��Ѵ��� ��������¥, �Ի��Ѵ޿� �ٹ��� �ϼ�
SELECT EMP_NAME, HIRE_DATE, LAST_DAY(HIRE_DATE), LAST_DAY(HIRE_DATE) - HIRE_DATE
FROM EMPLOYEE;

/*
    * EXTRACT
    Ư����¥�κ��� �⵵|��|�� ���� �����ؼ� ��ȯ�ϴ� �Լ�
    
    [ǥ����]
    EXTRACT(YEAR FROM DATE) : Ư����¥�κ��� �⵵���� ����
    EXTRACT(MONTH FROM DATE) : Ư����¥�κ��� ������ ����
    EXTRACT(DAY FROM DATE) : Ư����¥�κ��� �ϸ��� ����   
    
    => ������� NUMBERŸ��
*/

-- EMPLOYEE���� �����, �Ի�⵵, �Ի��, �Ի��� ��ȸ
SELECT EMP_NAME, 
       EXTRACT(YEAR FROM HIRE_DATE) "�Ի�⵵", 
       EXTRACT(MONTH FROM HIRE_DATE) "�Ի��", 
       EXTRACT(DAY FROM HIRE_DATE) "�Ի���"
FROM EMPLOYEE
ORDER BY �Ի�⵵, �Ի��, �Ի���;

-------------------------------------------------------------------------------------------

/*
    < ����ȯ �Լ� >
    
    * TO_CHAR
    ���� Ÿ�� �Ǵ� ��¥ Ÿ���� ���� ����Ÿ������ ��ȯ�����ִ� �Լ�
    
    [ǥ����]
    TO_CHAR(����|��¥, [����])   => ����� : CHARACTERŸ�� (���ڿ� Ÿ��)
    - ���� : '0': ���ڸ�ŭ�� ����Ȯ��, ��ĭ�� 0���� ä����
            '9': ���ڸ�ŭ�� ����Ȯ��, ��ĭ�� �������� ä����
            'L' : ���� ������ ����(LOACAL)�� ȭ������� ��ĭ���� ä���� 
            '$' : $�� ��ĭ���� ä����
*/

-- ����Ÿ�� => ����Ÿ��
SELECT TO_CHAR(1234) FROM DUAL; -- '1234' ���ڿ��� ��ȸ��

SELECT TO_CHAR(1234, '99999') FROM DUAL; -- 5ĭ¥�� ����Ȯ��, ����������, ��ĭ ����
SELECT TO_CHAR(1234, '00000') FROM DUAL; -- ��ĭ�� 0����
SELECT TO_CHAR(1234, 'L99999') FROM DUAL; -- ���� ������ ����(LOCAL)�� ȭ�����
SELECT TO_CHAR(1234, '$99999') FROM DUAL; 

SELECT TO_CHAR(1234, 'L99,999') FROM DUAL; -- ���ڸ� �������� ','�� �������� �� �� 

-- EMPLOYEE���� ������� �̸��� �޿�(��ȭǥ��, ���ڸ����� ','), ����(��ȭǥ��, ���ڸ����� ',') ��ȸ
SELECT EMP_NAME, TO_CHAR(SALARY, 'L999,999,999'), TO_CHAR(SALARY*12, 'L999,999,999')
FROM EMPLOYEE;

-- ��¥Ÿ�� => ����Ÿ��
SELECT SYSDATE FROM DUAL;
SELECT TO_CHAR(SYSDATE) FROM DUAL; -- '21/09/16' ��� ���ڿ��� ��ȸ��
SELECT TO_CHAR(SYSDATE, 'PM HH:MI:SS') FROM DUAL; -- HH(12�ð� ����) : �� / MI : �� / SS : ��
SELECT TO_CHAR(SYSDATE, 'PM HH24:MI:SS') FROM DUAL; -- HH24(24�ð� ����) : ��
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY') FROM DUAL; -- YYYY: �⵵ / MM : �� / DD : �� / DAY : ����
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DY') FROM DUAL; -- YYYY: �⵵ / MM : �� / DD : �� / DAY : ����
SELECT TO_CHAR(SYSDATE, 'MON, YYYY') FROM DUAL; -- MON : 'N'�� 

-- EMPLOYEE���� ������� �̸��� �Ի���('YY-MM-DD'����) ��ȸ
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YY-MM-DD') 
FROM EMPLOYEE;

-- EMPLOYEE���� ������� �Ի���('YYYYS�� MM�� DD��'����) ��ȸ
--SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY�� MM�� DD��') -- ���� �߻� : '��', '��', '��'�� �����ϴ� ������ �ƴ�, ���Ƿ� ������ ���ڰ��̱� ������ �������� �ݿ��� �Ұ����ϴ�.
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY"��" MM"��" DD"��"')
FROM EMPLOYEE;

-- �⵵�� ���õ� ����
SELECT TO_CHAR(SYSDATE, 'YYYY'),
       TO_CHAR(SYSDATE, 'YY'),
       TO_CHAR(SYSDATE, 'RRRR'),
       TO_CHAR(SYSDATE, 'RR'),
       TO_CHAR(SYSDATE, 'YEAR') 
FROM DUAL;
       
-- ���� ���õ� ����
SELECT TO_CHAR(SYSDATE, 'MM'),
       TO_CHAR(SYSDATE, 'MON'),
       TO_CHAR(SYSDATE, 'MONTH'),
       TO_CHAR(SYSDATE, 'RM') -- R : �θ���ȣ
FROM DUAL;

-- �ϰ� ���õ� ����
SELECT TO_CHAR(SYSDATE, 'DDD'), -- ����� ���� ����°
       TO_CHAR(SYSDATE, 'DD'), -- ����� ���� ����°
       TO_CHAR(SYSDATE, 'D') -- ��� �� ���� ����°
FROM DUAL;

-- ���ϰ� ���õ� ����
SELECT TO_CHAR(SYSDATE, 'DAY'), -- �����
       TO_CHAR(SYSDATE, 'DY')   -- ��
FROM DUAL;

-----------------------------------------------------------------------------------------

/*
    * TO_DATE 
    ����Ÿ�� �Ǵ� ����Ÿ�� �����͸� ��¥Ÿ������ ��ȯ�����ִ� �Լ�
    
    [ǥ����]
    TO_DATE(����|����, [����])    => ����� : DATEŸ��
*/
-- ���� => ��¥
SELECT TO_DATE(20100101) FROM DUAL;  -- �⺻������ 8�ڸ��� ���ڰ� ���õȴٸ� �տ� 4�ڸ��� �⵵, 2�ڸ��� ��, 2�ڸ��� �Ϸ� �ν��� �ȴ�
SELECT TO_DATE(100101) FROM DUAL;    -- 6�ڸ��� �����Ѵٸ� �տ� 2�ڸ� �⵵, 2�ڸ� ��, 2�ڸ��� �Ϸ� �ν��� �ȴ�.

SELECT TO_DATE(070101) FROM DUAL; -- �����߻� : 0���� �����ϴ� ���ڸ� �����ϸ� ������ �߻��Ѵ�.
SELECT TO_DATE('070101') FROM DUAL; -- �ذ��� : 0���� ������ ���� ���ڷ� �����ϸ� �ȴ�

-- ��/��/�� �ݿ�
SELECT TO_DATE('041030 143000') FROM DUAL; -- �����߻� : ����� ��Ϳ� �ش��ϴ��� ��Ȯ�� ���ø� ������Ѵ�.
SELECT TO_DATE('041030 143000', 'YYMMDD HH24MISS') FROM DUAL; -- �������� �� HH24�� �ƴ� HH���ý� �����߻� -> HH�� 12�ð� �����ε� ���õ� �ð��� 14�̱� ������

SELECT TO_DATE('140630', 'YYMMDD') FROM DUAL;
SELECT TO_DATE('980630', 'YYMMDD') FROM DUAL; -- YY : ������ ���缼��� �ݿ��� �⵵�� �ݿ�

SELECT TO_DATE('140630', 'RRMMDD') FROM DUAL;
SELECT TO_DATE('980630', 'RRMMDD') FROM DUAL; -- RR : �ش� ���ڸ� �⵵ ���� 50�̸��ϰ�� ���缼��� �ݿ�, 50 �̻��� ��� ���� ����� �ݿ�

--------------------------------------------------------------------------------------------------------------------------------

/*
    * TO_NUMBER 
    ����Ÿ���� �����͸� ����Ÿ������ ��ȯ�����ִ� �Լ��� ��¥Ÿ���� ���ڷδ� �����Ű�� ���Ѵ�.
    
    [ǥ����]
    TO_NUMBER(����, [����])     => ������� NUMBERŸ��
*/

-- ���� => ����
SELECT TO_NUMBER('05123475') FROM DUAL;

SELECT '1000000' + '550000' FROM DUAL;

SELECT '1,000,000' + '550,000' FROM DUAL; -- �����߻�
SELECT TO_NUMBER('1,000,000', '9,999,999') + TO_NUMBER('550,000', '999,999') FROM DUAL;

-----------------------------------------------------------------------------------------

/*
    < NULL ó�� �Լ� >
*/

-- * NVL(�÷�, �ش��÷����� NULL�� ��� ��ȯ�� ��)

-- EMPLOYEE���� �� ����� �̸�, 
SELECT EMP_NAME, NVL(BONUS, 0)
FROM EMPLOYEE;

-- EMPLOYEE�� �� ����� �̸�, ���ʽ��� ���Ե� ����(���ʽ��� ������ 0���� ǥ��)
SELECT EMP_NAME, (SALARY+SALARY*NVL(BONUS, 0))*12
FROM EMPLOYEE;

-- EMPLOYEE���� �� ����� �̸��� �μ���(�μ��� ������ '�μ�����'ǥ��) ��ȸ
SELECT EMP_NAME, NVL(DEPT_CODE, '�μ�����')
FROM EMPLOYEE;

-- * NVL2(�÷�, ��ȯ��1, ��ȯ��2) �ش� �÷��� NULL�ϼ��� �ְ�, ���� ���� �� ����
--   �÷����� ������ ��� ��ȯ��1 ��ȯ
--   �÷����� NULL�� ��� ��ȯ��2 ��ȯ

-- EMPLOYEE���� ����� �̸��� ���ʽ�, ���ʽ����� �����Ѵٸ� 0.7, ���ٸ� 0.1�� ��ȸ
SELECT EMP_NAME, BONUS,NVL2(BONUS, 0.7, 0.1)
FROM EMPLOYEE;

-- EMPLOYEE���� ����� �̸��� �μ��� �ִٸ� '�μ�����', ���ٸ� '�μ�����'�� ��ȸ
SELECT EMP_NAME, NVL2(DEPT_CODE, '�μ�����', '�μ�����') 
FROM EMPLOYEE;

-- * NULLIF(�񱳴��1, �񱳴��2)
--   �� ���� ���� ��ġ�ϸ� NULL�� ��ȯ���ִ� �Լ� 
--   �� ���� ���� ��ġ���� ������ �񱳴��1 ���� ��ȯ

SELECT NULLIF('123', '123') FROM DUAL;
SELECT NULLIF('123', '456') FROM DUAL;

------------------------------------------------------------------------------------------

/*
    < ���� �Լ� >
    
    * DECODE(���ϰ����ϴ´��(�÷�|�������|�Լ���), �񱳰�1, �����1, �񱳰�2, �����2, ..., �����N)
    
    �ڹٿ��� SWICH(�񱳴��) {
            CASE �񱳰� 1 :
            CASE �񱳰� 2 :
            ...
            DEFAULT : 
            } �� ���
*/

-- EMPLOYEE���� ������� ���, �����, �ֹι�ȣ, ����(1�̸� ����, 2�� ����) ��ȸ
SELECT EMP_ID, EMP_NAME, EMP_NO, DECODE(SUBSTR(EMP_NO, 8, 1), '1', '��', '2', '��') AS "����"
FROM EMPLOYEE;

-- EMPLOYEE���� �����, �����ڵ�, �����޿�, �λ�ȱ޿� ��ȸ
-- ������ �޿� ��ȸ �� �� ���޺��� �λ��ؼ� ��ȸ
-- J7�� ����� �޿��� 10% �λ� (SALARY*1.1)
-- J6�� ����� �޿��� 15% �λ� (SALARY*1.15)
-- J5�� ����� �޿��� 20% �λ� (SALARY*1.2)
-- �� ���� ����� �޿��� 5% �λ� (SALARY*1.05)
SELECT EMP_NAME, JOB_CODE, SALARY, 
       DECODE(JOB_CODE, 'J7', SALARY*1.1, 
                        'J6', SALARY*1.15, 
                        'J5', SALARY*1.2, 
                        SALARY*1.05)
FROM EMPLOYEE;

/*
    * CASE WHEN THEN
    
    [ǥ����]
    CASE WHEN ���ǽ�1 THEN �����1
         WHEN ���ǽ�2 THEN �����2
         ...
         ELSE �����N               => �ڹ��� IF-ELSE IF�� ����
     END
*/

-- EMPLOYEE���� ������� �̸�, �޿�, ����� ����(���, �߱� �ʱ�) ��ȸ
SELECT EMP_NAME, SALARY, 
       CASE WHEN SALARY >= 5000000 THEN '���'
            WHEN SALARY >= 3500000 THEN '�߱�'
            ELSE '�ʱ�'
        END
FROM EMPLOYEE;