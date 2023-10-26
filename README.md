# AlgoSolved

## 프로젝트 목표

- 알고리즘 풀이를 찾을 수 있는 웹 서비스
- [저작권 등의 문제](https://help.acmicpc.net/rule)가 있을 수 있어 문제 링크를 가져오며, 풀이에 경우 기획에 따라 기능이 달라질 수 있습니다.
- 적용되는 풀이는 ICPC 등의 대회를 위주로 풀이 공유 기능을 확대하는 등으로 진행.
- ⚠️ 기획에 따라 변경될 수 있습니다.


## 개발환경

**Installation**

```
git clone https://github.com/rha6780/AlgoSolved.git
cd AlgoSolved
./gradlew clean build --exclude-task test
docker compose up -d
```
개발환경인 application-dev.properties는 필요에 따라 값을 변경해도 됩니다.

프론트 [localhost:3000](http://localhost:3000)

백엔드 [localhost:8080](http://localhost:8080)

<br>

**Docker**

수정한 코드를 Docker에 적용하려면 `./gradlew clean build --exclude-task test` 또는 아래와 같이 bootJar를 실행시켜야됩니다.
<img width="372" alt="JAR build" src="https://github.com/rha6780/AlgoSolved/assets/47859845/e427cd0e-a79b-4c8c-b16c-a1cbad70d9b7">

이후 Docker 컨테이너를 재시작합니다.

## 아키텍쳐

**디렉토리 구조**
```
.
├── gradle
│   └── wrapper
└── src
    ├── main
    │   ├── frontend : 프론트에 해당하는 폴더
    │   │   ├── public
    │   │   └── src
    │   │       ├── api
    │   │       │   └── v1
    │   │       ├── components
    │   │       │   ├── auth
    │   │       │   ├── common
    │   │       │   └── home
    │   │       └── routes
    │   ├── java : 백엔드에 해당하는 폴더
    │   │   └── com
    │   │       └── example
    │   │           └── algosolved
    │   └── resources : 정적 파일
    │       ├── static
    │       │   └── css
    │       └── templates
    │           └── errors
    └── test : 백엔드 테스트 폴더
        ├── java
        │   └── com
        │       └── example
        │           └── algosolved
        └── resources


```