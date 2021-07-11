CREATE TABLE restaurant(
    rname varchar2(20) primary key,
    wname varchar2(10),
    hpnum varchar2(30),
    grade number(10)
    
);
desc restaurant;

INSERT INTO restaurant VALUES('학땡','정문','02-000-7979',NULL);
INSERT INTO restaurant VALUES('윤스쿡','정문','02-888-8282',NULL);
INSERT INTO restaurant VALUES('한끼철판','정문','02-212-4200',NULL);
INSERT INTO restaurant VALUES('작은집','후문','02-942-5322',NULL);
INSERT INTO restaurant VALUES('배불뚜기','후문','02-321-0027',NULL);
INSERT INTO restaurant VALUES('하늘푸름','후문','02-678-0018',NULL);

select * from restaurant;

drop table menu;

CREATE TABLE menu(
    rname varchar2(20) ,
    fname varchar2(30)primary key,
    price number(10)
);
desc menu;

INSERT INTO menu VALUES('학땡','돈순',5000);
INSERT INTO menu VALUES('학땡','칼순',5000);
INSERT INTO menu VALUES('학땡','쫄순',5000);
INSERT INTO menu VALUES('학땡','얼큰칼국수',5000);
INSERT INTO menu VALUES('학땡','제육덮밥',5000);

INSERT INTO menu VALUES('윤스쿡','윤스쿡정식',7000);
INSERT INTO menu VALUES('윤스쿡','왕돈까스',7000);
INSERT INTO menu VALUES('윤스쿡','윤스쿡돈까스',6500);
INSERT INTO menu VALUES('윤스쿡','직화제육덮밥',6000);
INSERT INTO menu VALUES('윤스쿡','직화쭈꾸미덮밥',6500);

INSERT INTO menu VALUES('한끼철판','제육철판',5000);
INSERT INTO menu VALUES('한끼철판','김치제육철판',5000);
INSERT INTO menu VALUES('한끼철판','삼겹살철판',6000);
INSERT INTO menu VALUES('한끼철판','닭고기철판',5000);
INSERT INTO menu VALUES('한끼철판','김치삼겹철판',6000);
INSERT INTO menu VALUES('한끼철판','오징어철판',7000);

INSERT INTO menu VALUES('작은집','소불뚝',5000);
INSERT INTO menu VALUES('작은집','부대뚝',5000);
INSERT INTO menu VALUES('작은집','제육뚝',5000);
INSERT INTO menu VALUES('작은집','콩불',5000);
INSERT INTO menu VALUES('작은집','짜글이',5000);

INSERT INTO menu VALUES('배불뚜기','닭갈비정식',5000);
INSERT INTO menu VALUES('배불뚜기','삼겹살정식',5000);
INSERT INTO menu VALUES('배불뚜기','돼지갈비정식',5000);
INSERT INTO menu VALUES('배불뚜기','부대찌개',4500);
INSERT INTO menu VALUES('배불뚜기','김치찌개',4000);
INSERT INTO menu VALUES('배불뚜기','뚝배기불고기',5000);
INSERT INTO menu VALUES('배불뚜기','순두부찌개',4500);

INSERT INTO menu VALUES('하늘푸름','왕돈까스',5500);
INSERT INTO menu VALUES('하늘푸름','매콤돈까스',5500);
INSERT INTO menu VALUES('하늘푸름','카레돈까스',5500);
INSERT INTO menu VALUES('하늘푸름','파왕돈까스',5500);
INSERT INTO menu VALUES('하늘푸름','파카레돈까스',5500);
INSERT INTO menu VALUES('하늘푸름','파매콤돈까스',5500);

select * from menu;
delete menu;
--drop table menu;

CREATE TABLE KMEMBER(
        EMAIL varchar2(30) NOT NULL,
        NICKNAME varchar2(20) primary key,
        PASSWORD varchar2(20) NOT NULL
        ); -- 회원 정보
        
DROP TABLE KMEMBER; -- 테이블 버리기
desc kmember;    
-- 멤버 확인
select * from kmember;

select EMAIL AS 이메일, NICKNAME AS 닉네임, PASSWORD AS 비밀번호 from kmember; 
-- 테이블 확인
delete from kmember;

commit;

CREATE TABLE PMEMBER(
        EMAIL varchar2(30) NOT NULL,
        NICKNAME varchar2(20) primary key,
        PASSWORD varchar2(20) NOT NULL
        ); -- 회원 정보
        
DROP TABLE PMEMBER; -- 테이블 버리기
DESC pmember;      
select * from pmember;
update pmember set rname = '윤스쿡' where email = 'a';
-- 테이블 확인
delete from pmember;

CREATE TABLE KGRADE(
        RNAME VARCHAR2(20) NOT NULL,
        EMAIL VARCHAR2(20) NOT NULL,
        GRADE NUMBER(20) NOT NULL
        );
select * from KGRADE;
delete kgrade;

CREATE TABLE RANDP(
        RNAME VARCHAR2(20),
        EMAIL VARCHAR2(20)
        );
select * from RANDP;
delete from randp;
insert into randp values('하늘푸름','a');
commit;