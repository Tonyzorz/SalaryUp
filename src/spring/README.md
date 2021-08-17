https://www.youtube.com/watch?v=WQLy3oFvGjo&list=PLY9pe3iUjRrTU0_V-98glnEur5-t9N7be&ab_channel=ITExpert

1. MVC pattern의 이해와 실습 =====================================================================
	
학생 테이블 
학번
이름 
전공
학년

oracle : 

	create table student (
		student_no varchar2(50) primary key,
		name varchar2(50) not null,
		major varchar2(50) not null,
		year number(1) default 1
	)
	
	insert into student values('2021001', '철수', '국사', 1);
	insert into student values('2021002', '김철수', '전산', 1);
	insert into student values('2021003', '박철수', '영문', 1);
	
	select * from student;
	
	commit; 

mysql : 

	create table student (
		student_no varchar(50) primary key,
		name varchar(50) not null,
		major varchar(50) not null,
		year int(1) default 1
	);
	
	insert into student values('2021001', '철수', '국사', 1);
	insert into student values('2021002', '김철수', '전산', 1);
	insert into student values('2021003', '박철수', '영문', 1);
	
	select * from student;
	
	commit; 

========
new -> spring legacy project -> spring 	mvc project -> com.example.student 

root-context.xml : 디비 연결 설정 
	라이브러리 필요 : mysql, mybatis, dbcp, spring-jdbc, mybatis-spring
	
StudentController.java 

StudentDTO.java
StudentDAO.java
src/main/resources
		mybatis-config.xml
		mappers
				student.xml

views/student/list.jsp
views/student/write.jsp


classpath = src/main/resources


web.xml = 웹프로젝트의 설정 파일 

*제일 먼저 읽는게 web.xml

- root-context.xml 서블릿 이외의 설정, DB연결 
- servlet mapping 
	/(urlpattern에 /로 appServlet 실행 ) => 서블릿 호출 => 스프링 프레임워크에 내장된 DispatcherServlet실행 
		=> servlet-context.xml 호출 
			=> 접두사 및 접미사 설정해주기
			=> 코딩량을 줄려주기 위한 제공
			
			context:component-scan base-package=""
			=> 패키지 이하의 클래스들의 component 검색 
				ex. @Controller, @Service, @Repo
			=> 자동으로 메모리에 로딩 

@RequestMapping = url 과 method 연결 
			
http://localhost:8089/student/
					/컨택스패스/

모델에 자료 저장
model.addAttribute("serverTime", formattedDate);

return "home"; => 접두사  + home + 접미사 			
servlet-context.xml 
prefix = /WEB-INF/views/
suffix = .jsp

경로 = /WEB-INF/views/home.jsp
	
mvc1 (model1) = jsp 위주의 개발 방식
	index.jsp => list.jsp => write.jsp => insert.jsp 구식 방식 
	
	장점 : 빠르다, 소형 프로젝트/개인 프로젝트 에 적합한 방식
	단점 : 유지보수가 어렵다, 보안이 취약함 
	
mvc2 (model2) = 서블릿 위주의 개발 방식 
	자바코드와 html 분리 
	대형 프로젝트에 적합 
	
	장점 : 유지보수가 쉽고 보안성이 향상된다, 규격화된 패턴이다 보니 협업에 유리하다
	단점 : 복잡하고 개발 시간이 오래 걸림 
	

WEB-INF = 외부접속 금지 
	classes 파일들어감 
	spring 관련 설정 파일 들어감 

http://localhost:8089/student/WEB-INF/views/home.jsp
	- 외부에서 접속 금지 
	- .do, .action etc 
	- 무조건 서블릿 경유해서 jsp 출력해야한다
		
http://localhost:8089/student/test.jsp
	- 공격 위험성 있음
	- .jsp 로 보이는 사이트들은 개발한지 오래된 사이트일 가능성이 높다, mvc1으로 개발된 확율도 있다
	
jsp, html, js, css, png, jpg 웹페이지 

나머지 확장자 *.do *.action => / => 서블릿 

@Controller 붙히면 servlet-context.xml의 context:component-scan통해서 클래스들을 메모리에 올림.


** IoC **
Inversion of Control 제어의 역전 
	
	MemberDao dao = new MemberDao();
	만약 MemberDao가 변경되면 dao 관련 모든 인스턴스를 변경해줘야한다. 
	
	- 객체에 대한 제어권
	- 기존에는 개발자에게 제어권이 있었음(new 연산자)
	- 객체의 제어권을 스프링에게 넘김 
	- 인스턴스의 라이프 사이클(생성부터 소멸까지)을 개발자가 아닌 스프링 프레임웍이 담당 
	
DI(Dependency Injection, 의존관계 주입)
	- 객체 간의 의존성을 개발자가 설정하는 것이 아닌 스프링 컨테이너가 주입시켜 주는 기능 
	- 객체를 쉽게 확장하고 재사용할 수 있음 



2. MVC pattern의 이해와 실습2 =====================================================================
	
	<a href="/student/input.jsp">[학생등록]</a>
	/컨텍스트패스/페이지
	
	컨텍스트패스 - 웹프로젝트의 식별자 
	
	갈수는 있지만 다 controller를 들려서 통일하는게 좋다 
	<a href="/student/input.do">[학생등록]</a>
	
	정적인 컨텐츠 - html, css, js, image
	동적인 컨텐츠 - jsp, 서블릿 
	
	정적인 컨텐츠는 서버에서 직접 전달 
	동적인 컨텐츠는 코드 실행 후 전달 
	
	구식 방식으로 받는 방법 
		jsp -> Controller 로 받을때 
		HttpServletRequest request을 통한 
		String student_no = request.getParameter("student_no");
	
	현재 방식으로 받는 방법 
		@RequestParam String student_no 
		or 
		이름이 똑같으면 String student_no 
		or 
		@ModelAttribute StudentDTO dto 
	

	자바코드, xml 변경 => 서버 재시작 
	jsp 변경 => 재시작 필요 없음 
	
	설정에 Project => Build Automatically 체크하면 코드 변경시 서버 재시작 
	
	
	@RequestMapping("view/{student_no}")
								/|\
								 |__Path variable
	
	
3. 안드로이드와 스프링 연동(xml, json 파싱) ===========================================================

4. Spring Project를 Ubuntu Linux에 배포하는 방법 ====================================================




















