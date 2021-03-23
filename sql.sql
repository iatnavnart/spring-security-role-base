select staff_name 
from staff s 
where s.salary in (
	select max(st.salary) 
	from staff st 
	group by st.department
	having s.department = st.department 
)
order by staff_name  asc

select
	s.staff_name,
	s.ranksalary,
	s.department
from
	(
	select
		rank() over (partition by department
	order by
		salary desc) ranksalary,
		salary,
		staff_name,
		department
	from
		staff ) s
where
	s.ranksalary = 1
