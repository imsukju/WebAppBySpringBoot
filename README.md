
# GettingStart 프로젝트

Spring Boot와 JPA를 활용하여 사용자 관리와 기본 RESTful API를 구현한 프로젝트입니다.

## 프로젝트 구조
```
GettingStart/
├── src/main/java/com/example2/GettingStart/
│   ├── GettingStartApplication.java       # 메인 애플리케이션 클래스
│   ├── config/
│   │   └── Appconfig.java                 # 애플리케이션 전반 설정
│   ├── controller/
│   │   ├── CustomUsersController.java     # 사용자 관련 커스텀 컨트롤러
│   │   └── UserController.java            # 기본 사용자 컨트롤러
│   ├── dto/
│   │   └── UserDTO.java                   # 사용자 데이터 전송 객체
│   ├── entity/
│   │   ├── AbstractEntity.java            # 공통 엔티티 속성 정의
│   │   ├── BaseEntity.java                # 기본 엔티티
│   │   ├── Person.java                    # Person 엔티티
│   │   └── User.java                      # 사용자 엔티티
│   ├── repository/
│   │   ├── PersonRepository.java          # Person 데이터 접근 레이어
│   │   ├── UserRepository.java            # 사용자 데이터 접근 레이어
│   │   └── UserRepositoryByJPA.java       # JPA 기반 사용자 리포지토리
│   ├── service/
│   │   ├── UserSerivce.java               # 사용자 서비스 레이어
│   │   └── UserService2.java              # 사용자 서비스 대안 구현
├── src/main/resources/application.yml     # 애플리케이션 설정 파일
```

### 주요 기능
1. **RESTful API**:
   - 사용자 및 Person 엔티티에 대한 CRUD 작업을 제공.
2. **JPA 리포지토리**:
   - 기본 및 커스텀 JPA 리포지토리를 통해 데이터베이스 연동.
3. **DTO 및 엔티티**:
   - DTO를 통해 데이터 전송 및 엔티티와 분리된 데이터 관리.

---

# SpringDemo1 프로젝트

Spring Boot의 DI(Dependency Injection)와 커스텀 설정을 다룬 프로젝트입니다.

## 프로젝트 구조
```
springDemo1/
├── src/main/java/com/example1/springDemo1/
│   ├── SpringDemo1Application.java        # 메인 애플리케이션 클래스
│   ├── config/
│   │   ├── AppConfig.java                 # 애플리케이션 설정
│   │   ├── DeferredConfig.java            # 지연된 설정
│   │   └── DelayedConfig.java             # 연기된 설정
│   ├── controller/
│   │   └── Hello.java                     # 간단한 Hello World 컨트롤러
├── src/main/resources/application.yml     # 애플리케이션 설정 파일
```

### 주요 기능
1. **DI 및 설정**:
   - DI와 연동된 커스텀 설정을 통해 유연한 애플리케이션 구성.
2. **간단한 API**:
   - `Hello.java` 컨트롤러를 통해 간단한 메시지를 반환.

---

# Sjspringbootdemo 프로젝트

Spring Boot를 사용하여 제품 관리 기능을 구현한 프로젝트입니다.

## 프로젝트 구조
```
sjspringbootdemo/
├── src/main/java/com/sjexample2/sjspringbootdemo/
│   ├── SjspringbootdemoApplication.java    # 메인 애플리케이션 클래스
│   ├── controller/
│   │   └── ProductController.java          # 제품 관리 API 컨트롤러
│   ├── entity/
│   │   └── Product.java                    # 제품 엔티티
│   ├── repository/
│   │   └── ProductRepository.java          # 제품 데이터 접근 레이어
│   ├── service/
│   │   └── ProductService.java             # 제품 서비스 레이어
├── src/main/resources/application.yml      # 애플리케이션 설정 파일
```

### 주요 기능
1. **RESTful API**:
   - 제품 CRUD 작업 API 제공.
2. **서비스 레이어**:
   - 비즈니스 로직 분리를 통해 모듈화된 관리.

---

# SpringBootDemo3 프로젝트

Spring Boot와 JPA를 사용하여 사용자 관리와 다양한 사용자 정의 리포지토리를 구현한 프로젝트입니다.

## 프로젝트 구조
```
SpringBootDemo3/
├── src/main/java/com/sjexample3/SpringBootDemo3/
│   ├── SpringBootDemo3Application.java     # 메인 애플리케이션 클래스
│   ├── config/
│   │   └── AppConfig.java                  # 애플리케이션 설정
│   ├── controller/
│   │   └── UserController.java             # 사용자 관리 API 컨트롤러
│   ├── entity/
│   │   └── User.java                       # 사용자 엔티티
│   ├── repository/
│   │   ├── UserRepository.java             # 기본 사용자 리포지토리
│   │   ├── UserRepositoryCustom.java       # 사용자 정의 리포지토리 인터페이스
│   │   ├── UserRepository2.java            # 추가 리포지토리 구현
│   │   └── UserRepository2impl.java        # 사용자 정의 리포지토리 구현체
├── src/main/resources/application.yml      # 애플리케이션 설정 파일
```

### 주요 기능
1. **커스텀 리포지토리**:
   - 사용자 정의 쿼리와 동적 데이터 접근 구현.
2. **사용자 관리 API**:
   - 사용자 CRUD 작업 지원.

---

# SpringBootDemo5 프로젝트

Spring Boot와 Spring Data JPA를 사용하여 주소 및 사용자 관리를 다룬 프로젝트입니다.

## 프로젝트 구조
```
SpringBootDemo5/
├── src/main/java/com/example4/SpringBootDemo4/
│   ├── SpringBootDemo4Application.java     # 메인 애플리케이션 클래스
│   ├── controller/
│   │   └── Controller.java                 # 기본 컨트롤러
│   ├── entity/
│   │   ├── Address.java                    # 주소 엔티티
│   │   ├── BaseEntity.java                 # 공통 엔티티
│   │   └── Person.java                     # 사람 엔티티
│   ├── repository/
│   │   └── PersonRepository.java           # 사람 데이터 접근 레이어
│   ├── service/
│   │   └── PersonService.java              # 사람 서비스 레이어
├── src/main/resources/application.yml      # 애플리케이션 설정 파일
```

### 주요 기능
1. **엔티티 관리**:
   - 사용자 및 주소 데이터를 관리.
2. **서비스 레이어**:
   - 데이터 관리와 비즈니스 로직 분리.

