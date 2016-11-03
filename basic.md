
# install open edx fullstack

## mac
http://edx.readthedocs.io/projects/edx-installing-configuring-and-running/en/latest/installation/fullstack/install_fullstack.html  

## windows

1. Microsoft Visual C++ 2010 재배포 가능 패키지(x64 및 x86)  설치

  https://www.microsoft.com/ko-kr/download/details.aspx?id=14632  
  https://www.microsoft.com/ko-kr/download/confirmation.aspx?id=5555  

2. 관리자 모드로 cmd창 실행

  검색창 -> cmd 입력 -> 명령 프롬프트 실행 아이콘에 우클릭 후 관리자 권한으로 실행  

    cd \
    vagrant up

  (설치 시간 약 20~30분)  


3. 웹페이지 확인 (ie나 크롬에서 확인, 크롬 권장)

  학습자 페이지:  
  http://192.168.33.10/
  교수자 페이지:  
  http://192.168.33.10:18010

  관리자 id/password: staff@example.com  / edx  
