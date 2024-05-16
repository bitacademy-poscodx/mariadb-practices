--
-- subquery
--

--
-- 1) select 절, insert into t1 values(...)
-- 

--
-- 2) from 절의 서브쿼리
-- 
select now() as n, sysdate() as s, 3 + 1 as r from dual;
select n, s
  from (select now() as n, sysdate() as s, 3 + 1 as r from dual) a;

--
-- 3) where 절의 서브쿼리
-- 

-- 예제) 현재, 'Fai Bale'이 근무하는 부서에서 근무하는 다른 직원의 사번과 이름을 출력하세요.
select b.dept_no
  from employees a, dept_emp b
 where a.emp_no = b.emp_no
   and b.to_date = '9999-01-01'
   and concat(a.first_name, ' ', a.last_name) = 'Fai Bale';

-- 'd004'   

select a.emp_no, a.first_name
  from employees a, dept_emp b
 where a.emp_no = b.emp_no
   and b.to_date = '9999-01-01'
   and b.dept_no = 'd004';

 
select a.emp_no, a.first_name
  from employees a, dept_emp b
 where a.emp_no = b.emp_no
   and b.to_date = '9999-01-01'
   and b.dept_no = (select b.dept_no
                      from employees a, dept_emp b
                     where a.emp_no = b.emp_no
                       and b.to_date = '9999-01-01'
                       and concat(a.first_name, ' ', a.last_name) = 'Fai Bale');
 
 -- 3-1) 단일행 연산자: =, >, <, >=, <=, <>, !=
 
 -- 3-2) 복수행 연산자: in, not in, 비교연산자any, 비교연산자all