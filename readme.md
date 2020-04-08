# KAKAO
email을 입력받아 랜덤으로 쿠폰번호를 해주는 프로그램

## Getting Started
### 개발환경
* JDK1.8
* springframework.boot 2.2.5
* h2database 1.4.2

### 실행방법
#cmd
1. Go to the root of the application where pom.xml is available
2. run this command 'mvn spring-boot:run'

#Eclipse<br>
* run the project on Boot Dashboard

### Dependencies
'''xml

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mustache</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>bootstrap</artifactId>
			<version>4.4.1</version>
		</dependency>
		<dependency>
			<groupId>org.webjars.bower</groupId>
			<artifactId>jquery</artifactId>
			<version>3.4.1</version>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<version>1.4.200</version><!--$NO-MVN-MAN-VER$ -->
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
			<version>2.2.5.RELEASE</version><!--$NO-MVN-MAN-VER$ -->
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
			<version>2.2.5.RELEASE</version><!--$NO-MVN-MAN-VER$ -->
		</dependency>
		<dependency>
			<groupId>javax.validation</groupId>
			<artifactId>validation-api</artifactId>
		</dependency>
		<dependency>
			<groupId>org.hibernate.validator</groupId>
			<artifactId>hibernate-validator</artifactId>
		</dependency>
		<dependency>
			<groupId>org.hibernate.validator</groupId>
			<artifactId>hibernate-validator-annotation-processor</artifactId>
		</dependency>
		
'''

