# 기본 이미지 설정
FROM openjdk:17-jdk-alpine

# 필요한 패키지 설치
RUN apk add --no-cache curl zip bash

# SDKMAN 설치
RUN curl -s "https://get.sdkman.io" | bash

# SDKMAN 초기화 및 Gradle 설치
RUN chmod +x /root/.sdkman/bin/sdkman-init.sh && /root/.sdkman/bin/sdkman-init.sh && \
    /bin/bash -c "source /root/.sdkman/bin/sdkman-init.sh && sdk install gradle"

# 작업 디렉토리 설정
WORKDIR /app

# 소스 코드 복사
COPY . .

# 포트 포워딩 설정
EXPOSE 8081

# 실행할 명령 설정
CMD ["java", "-jar", "build/libs/GYMFIT-0.0.1-SNAPSHOT.jar"]
