<img width="597" alt="Awards" src="https://github.com/GreenTinCan/Bobfull-server/assets/37647483/a0f19df0-6032-49d3-b7b8-268c3e562149">



## 팀 초록 깡통

### 벡엔드 서버 저장소

- 모든 벡엔드 자원을 관리 하는 목적의 저장소

### 서버 실행 방법

- BobFull.jar 파일 실행

  $ java -jar -Duser.timezone=Asia/Seoul ./BobFull.jar

#### 폴더 구조

- gather : 매칭 관련 영역

- member : 회원 관련 영역

- common : 유틸성 기능 영역

  - Error Handler
  - API response Handler

- infra :
  - aws s3 : 폴더별 image handle , CRUD
  - google fcm : push alarm handle

### Back-end Stack

---

| Category  | stack                                     |
| --------- | ----------------------------------------- |
| Language  | Java 17                                   |
| Framework | Spring Boot 2.7.7                         |
| ORM       | JPA/Hibernate                             |
| Database  | MySQL 8.0.                                |
| Build     | Gradle 7.6.1                              |
| Infra     | AWS EC2 ,S3 ,Rds , FireBase Cloud Message |
