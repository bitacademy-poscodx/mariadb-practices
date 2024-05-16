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
 -- 실습문제1
 -- 현재, 전체 사원의 평균 연봉보다 적은 급여를 받는 사원의 이름과 급여를 출력 하세요.
 select avg(salary)
   from salaries
  where to_date = '9999-01-01'; 
 
  select a.first_name, b.salary
    from employees a, salaries b
   where a.emp_no = b.emp_no
	 and b.to_date = '9999-01-01'
     and b.salary < (select avg(salary)
                       from salaries
                      where to_date = '9999-01-01')
order by b.salary desc;                     

-- 실습문제2
-- 현재, 직책별 평균급여 중에 가장 적은 직책의 직책이름과 그 평균급여를 출력해 보세요.  
-- 1) 직책별 평균 급여
select a.title, avg(salary)
  from titles a, salaries b
 where a.emp_no = b.emp_no
   and a.to_date = '9999-01-01'
   and b.to_date = '9999-01-01'
group by a.title;
   
-- 2) 직책별 가장 적은 평균 급여: from절 subquery
select min(avg_salary)
  from (  select a.title, avg(salary) as avg_salary
            from titles a, salaries b
           where a.emp_no = b.emp_no
             and a.to_date = '9999-01-01'
             and b.to_date = '9999-01-01'
        group by a.title) a;

-- 3) sol1: where절 subquery(=) 
select a.title, avg(salary)
  from titles a, salaries b
 where a.emp_no = b.emp_no
   and a.to_date = '9999-01-01'
   and b.to_date = '9999-01-01'
group by a.title
  having avg(salary) = (select min(avg_salary)
                          from (  select a.title, avg(salary) as avg_salary
                                    from titles a, salaries b
                                   where a.emp_no = b.emp_no
                                     and a.to_date = '9999-01-01'
                                     and b.to_date = '9999-01-01'
								group by a.title) a); 
 
 
 -- 3-2) 복수행 연산자: in, not in, 비교연산자any, 비교연산자all