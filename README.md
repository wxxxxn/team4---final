# 🤯 개발자 키우기


![화면 캡처 2023-03-24 104757](https://user-images.githubusercontent.com/119999556/227832887-bd0bf15e-433b-4939-826a-d66cf79aa694.png)

## 💡 프로젝트 소개
- 흡연자들이 뭉쳐서 만든, 오직 재미를 위한 개발자 키우기 게임
- 여러 가지 게임 내 활동을 통하여 LevelUp 및 재화를 획득하고 취업 시 게임 Clear

## ⌛ 개발 기간

- 23.01.05. ~ 23.01.16.

### ⚙ 개발 환경

- `Java 8`
- `JDK 1.8.0`
- **Server** : Apache Tomcat 9.0
- **Database** : MySQL

### 💻 실행 환경

- Apache Tomcat 9.0

## 📌 주요기능

- 여러 개의 Timer를 활용해 캐릭터의 활동을 실시간 구현
- 경험치 표현 progressbar 구현 및 경험치를 획득하기 위한 미니게임 3종 구현

## 🌟 담당업무

- 프론트 80%

- 미니게임
    - 두더지 잡기(Thread)
![152](https://user-images.githubusercontent.com/119999556/227833132-4b9726bc-9096-4593-89ef-8c007c6e0252.png)

        
    
    게임 화면에서 두더지가 나타날 위치를 랜덤으로 결정하고, 일정 시간마 다 새로운 위치에서 두더지가 나타나도록 구현
    
    - 틀린그림찾기

        ![12312421](https://user-images.githubusercontent.com/119999556/227833171-53c34f11-9aa3-4975-9113-a896d623ce31.png)

    
    - 다른그림찾기
    ![화면 캡처 2023-03-24 113157](https://user-images.githubusercontent.com/119999556/227833212-07af14d4-a504-4799-8489-1eae0b8a4b91.png)


    게임 화면에서 이미지를 보여주고, 사용자가 좌표값의 오차범위 안을 클릭하면 부분 동그라미를 렌더링
    
- 활동으로 인한 progressbar 수치 조정(Thread)
- ![화면 캡처 2023-03-24 105028](https://user-images.githubusercontent.com/119999556/227833237-ace9fd47-d02a-484f-ab92-f5e30707881b.png)

