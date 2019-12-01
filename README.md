# Citron's Library
스프링부트의 다양한 기능들을 사용해 웹 어플리케이션을 개발해보기 위해 만들어진 토이 프로젝트입니다.
이 어플리케이션에는 다음과 같은 기능들을 사용 혹은 사용 예정입니다.
* SpringBootWeb
* SpringDataJpa
* Thymeleaf
* SpringSecurity

## Domain Rule
다음과 같은 엔티티를 정의했습니다.
* Item (확장성 고려)
    * Book
    * DVD(추가예정)
* NewArrival
* ItemCategory
    * Item과 Category의 N:M 관계를 위한 엔티티
    
* Category

* Member
* Ban
* Rental
* Reservation

* Post
* Authorization
---
다음과 같은 규칙을 정했습니다.
### 아이템
* 하나의 아이템은 여러 개의 카테고리에 속할 수 있다.
* 대출 중인 아이템에 한해서만 예약이 가능하다
* 하나의 아이템은 한 번에 하나의 대여에만 속할 수 있다.

### 회원
* 하나의 회원은 여러 개의 대여를 할 수 있다.
* 회원 등급에 따라 빌릴 수 있는(혹은 예약할 수 있는) 아이템의 갯수가 다르다.
    * NORMAL: 3
    * SILVER: 5
    * GOLD: 7
    * VIP: 10
* 반납 예정일을 넘긴 회원은 넘긴 날자에 따라 대여가 정지된다.
* 누적 대여가 다음과 같을 때 회원 등급이 오른다.
    * NORMAL -> SILVER: 10권
    * SILVER -> GOLD: 50권
    * GOLD -> VIP: 200권
 * 회원은 여러 개의 포스트를 작성할 수 있다.
 
### 대여
* 하나의 대여는 여러 개의 아이템을 가질 수 있다.

### 카테고리
* 하나의 카테고리는 여러 개의 아이템을 가질 수 있다.

### 포스트
* 하나의 포스트는 하나의 회원에 속한다.



 
 