# 프로젝트 소개
누구나 숙소를 등록하고 예약할 수 있는 에어비엔비를 모티브로 한 웹사이트


# 개발환경

- BACKEND
    - JAVA JDK11
    - springboot 2.6.5
    - gradle
    - oracle 11g
    - mybatis
- FRONTEND
    - html, css, js, jquery
    - thymeleaf
- DEPLOY
    - git
    - oracle cloud VM
    - oracle cloud ADW
- TOOLS
    - intellij
    - VSC
    
    
# 기능 및 요구사항 설계

| 주요 기능 | 세부 기능 | 요구사항 | 사용기술 및 부가설명 |
| --- | --- | --- | --- |
| 회원가입 | *이메일 | *이메일로 가입할 수 있어야 한다.  | SPRING SECURITY |
|  | 소셜(구글, 카카오, *깃허브) |  |  |
|  |  | 회원가입 폼 작성시 실시간으로 비밀번호 요구사항 검증을 진행한다.  |  |
|  |  | 회원가입 폼 아래에 “이미 가입하셨나요?” 바로 로그인 창으로 이동 할 수 있도록 한다.  |  |
| 로그인 |  | *이메일계정으로 가입한 경우 고객이 설정한 비밀번호로 로그인 할 수 있도록 한다.  |  |
|  | *비밀번호 | 8자리 이상, 대소문자 혼용, 특수문자포함, 숫자 포함 |  |
|  |  | 로그인이 필요한 경우 로그인 창으로 이동시키고  데이터 가지고 redirect + 기존 페이지 |  |
| 회원인증 | 이메일인증 |  | SMTP , UUID |
|  | 휴대폰인증 |  | https://beam307.github.io/2017/12/08/sendSMS/ |
| 프로필 |  | 프로필 페이지에서 인증 내역을 표시 |  |
|  | 프로필 사진 업로드 | 프로필 사진을 업로드 할 수 있다. | AWS S3 |
|  |  | *사용자가 작성한 후기 목록을 확인할 수 있다. |  |
|  |  | 프로필 내용을 수정하는 기능(이름, 소개, 개인정보 등) |  |
|  |  |  |  |
| 목록 | 나의 예약 | 로그인 안된 사용자가 예약하기를 누르면 로그인 페이지로 이동시킨다.   | paging |
|  |  | 로그인이 완료되면 데이터(인원, 선택 날짜)를 가지고 redirect + 기존 페이지 |  |
|  |  | 예약리스트를 누르면 예약 상세페이지로 이동한다. (로그인 된 사용자에게만 예약리스트 탭 보여줌) |  |
|  | 숙소 목록 | 클라이언트의 검색어에 맞춰 리스트를 보여준다.  | paging |
|  | 즐겨찾기 목록 | 하트를 누르면 즐겨찾기 목록에 추가한다.  |  |
|  |  | 하트를 취소하면 그 숙소가 바로 목록에서 지워지게 한다.  |  |
|  | *최근 본 숙소 | *검색한 숙소 리스트 아래에 최근 본 숙소를 보여준다.  |  |
| 숙소 등록 | 숙소 종류 선택  | 숙소 종류를 선택 할 수 있게 한다. (APT, house...) |  |
|  | 숙소 이름 정하기  | * ”(호스트 이메일)의 특별한 숙소”를 placeholder로 보여준다.  |  |
|  |  | 숙소 이름은 한글로 30자 이내로 설정하도록 한다. *textbox밑에 0/30자 기능 추가 |  |
|  | 숙소 설명 | 한글로 500자 이내로 작성하도록 한다. *textbox밑에 0/500자 기능 추가 |  |
|  | 파일업로드 | 숙소 사진을 다섯장 이상 등록하도록 한다.  |  |
|  |  | 첫번째 사진이 숙소 상세페이지의 main사진이 되도록 한다.  |  |
|  | 숙소 가격 설정 | 평일 가격과 성수기 가격을 다르게 설정할 수 있도록 한다. (요일별, 월별) |  |
|  | 가용 인원 설정 | 최대 인원을 설정할 수 있도록 한다.  |  |
|  |  | 인원추가가 가능한지 불가능한지, 가능하다면 1인당 얼마가 추가되는지 설정할 수 있도록 한다.  |  |
|  | 숙소 위치 등록 | 숙소 주소를 입력할 수 있도록 한다.   | 카카오 지도 API |
|  | 숙소 기본 시설 등록 | 침대 개수(종류별), 침실 개수, 욕실 개수 등을 설정가능하게 하되 -/+버튼으로 조절 가능하게 한다. |  |
|  | 숙소 편의시설 등록 | 숙소 편의시설을 탭으로 보여주고 선택시 추가되게 한다.  |  |
|  | * | *호스트가 첫 숙소 등록을 완료하면 “(host이름)님, POPIN호스트가 되신것을 환영합니다🎉” 문구를 띄워준다.  |  |
|  |  | 호스트가 숙소 등록을 완료하면 호스트 페이지로 이동하게 한다.  |  |
| 호스트 페이지 | 예약 탭  | 예약 탭에 들어오면  ‘현재 호스팅 중’, ‘체크인 예정’,  ‘체크아웃 예정’ 탭을 위쪽에 보여준다. | https://www.airbnb.co.kr/hosting |
|  |  | 예약 탭에 들어오면 ‘모든 예약(*건)’ 탭을 보여준다.  | https://www.airbnb.co.kr/hosting |
|  | 메뉴 탭 | 메뉴 탭에 마우스를 올리면 숙소 관리, 게스트와의 메세지, 수입관리, 새로운 숙소 등록이 뜨게한다.  |  |
|  |  |  |  |
| 예약 | 지도api(카카오) |  |  |
|  | 달력api |  |  |
|  | 메세지 | 게스트가 예약을 하면 해당 숙소 호스트에게 메세지가 가도록 한다(”~님이 4/25-4/28(3박) 예약을 완료하였습니다.”) | AWS S3 |
|  | 메일링 | 예약이 완료되면 호스트와 게스트에게 알림 메일을 발송한다 | SMTP |
|  | 취소 | 게스트가 예약을 취소하면 전액 환불해준다. |  |
|  | 날짜 | 예약불가능한 날짜는 흐리게 처리한다.  |  |
| 결제 | 페이팔 |  |  |
|  | 카카오페이 |  |  |
|  |  |  |  |
| 검색 | 카테고리 분류 | 검색 페이지에서 검색 조건에 맞는 데이터 찾고 숙소 리스트 보여주기, 검색조건은 페이지가 넘어가도 저장 |  |
|  | 일정별 | 사용자가 설정한 일정에 이용가능한 숙소가 있다면 가까운 거리를 기준으로 보여준다.  |  |
|  | 지역별 | 지도 위치를 옮길때마다 숙소 목록 갱신 | 위치기반 GPS, ajax |
|  | 종류별 | 사용자가 선택한 지역 내에서, 해당하는 숙소의 종류 찾아서 보여준다.  |  |
|  | 테마별 |  | paging, 하우스 테이블에 테마별 추천을 위한 컬럼 넣기(business, relaxing, dynamic, nature, etc..)   |
|  | 필터기능 : 옵션별 검색 | 사용자가 원하는 옵션별로 숙소를 필터링 해서 보여준다.  |  |
|  | *유연한 검색 | 유연한 검색은 휴양지(relaxing, nature)컬럼을 기준으로 나열한다. (거리 상관x) |  |
|  |  | *유연한 검색은 숙소 리스트 위에 좀 더 디테일한 숙소를 위한 탭을 보여준다. ex) 수영장, 바다근처, 사용자 근처, 아파트, 주택 등.. |  |
| 추천 | *날씨api | 사용자의 접속 위치의 날씨정보를 받아와서 추천 |  |
| 평점 | 평점 | 숙소가 받은 평점을 종합해서 보여준다.  |  |
| 통계 | 데이터 수집 | 사용자에게 유용한 데이터를 미리 수집하여 확인할 수 있도록 함 | 서버스케줄러, 통계를 위한 테이블 |
|  | 시각화 api | 호스트인 사용자는 수입, 평점 등에 대한 정보를 차트로 확인할 수 있다. |  |
|  | *CSV파일 다운로드 제공 | 안내된 통계 정보는 필요한 경우 다운로드할 수 있도록 한다. |  |
|  |  |  |  |
| 메시지 | 리얼타임 | 호스트와 게스트 간 상호 메시지 송/수신 가능 | websocket |
|  | 알림 | 예약 시 호스트와 게스트에게 모두 예약에 대한 정보 메시지 발송 |  |
|  |  | 수신자 별로 메시지방 구분 및 선택 가능 |  |
|  |  | 읽지 않은 메시지는 상단에 노출 |  |
|  |  | 수신된 메시지가 없는 경우 “메시지가 없습니다” 표시 |  |
| 후기 | *답글 기능 | 후기글은 한번만 작성 / *후기글에 답글도 호스트가 한번 작성 가능 |  |
|  |  | 더보기 클릭 시 10개씩 추가로 보여준다. |  |
| 평점 | 숙소에 대한 종합평가 | 후기 작성 시 별점으로 1~5점까지 해당 숙소에 대한 평가를 할 수 있다. |  |
|  |  | 모든 게스트의 평점은 평균내어 예약 상세 페이지에서 확인 할 수 있다. |  |
| 즐겨찾기 |  | 마음에 드는 숙소를 즐겨찾기해두고 한 곳에서 모아볼 수 있다. | 즐겨찾기 테이블 |
|  |  |  |  |
| 메시지 | *메시지 | 화면에 보이는 단어는 메시지화하여 간단하게 수정할 수 있도록 한다. |  |
|  | *국제화 | 외국인 사용자도 이용 가능하도록 영어를 지원한다. |  |
|  |  |  |  |
| 관리자페이지 | 사용자에게 전체 메일발송 |  |  |
|  | 예약 취소 |  | 예약 테이블에 STATUS추가 |
|  | 이용 정지 |  | 회원 테이블에 STATUS추가 |
|  | 숙소 예약 비활성화 |  | 하우스 테이블에 STATUS추가 |
|  | 사이트 이용자 통계확인 |  |  |
|  | 사용자 및 숙소 검색 |  |  |

# 패키지 구조, 네이밍 컨벤션

java > resources >

application.yml

- java > io >
    - summer
        - popin
            - domain
                - member
                    - controller
                        
                        XxxController.java
                        
                    - service
                        
                        XxxService.java
                        
                    - dao
                        
                        XxxDAO.java
                        
                        XxxMapper.java
                        
                    - vo
                        
                        XxxVO.java
                        
                    - dto
                        
                        XxxDTO.java
                        
                    - exception
                        
                        XxxException.java
                        
                - reservation
                - message
                - payment
                - searching
                - model
                    
                    xxxType.Enum
                    
                    xxxStatus.Enum
                    
            - global
                - vo
                    
                    XxxVO.java
                    
                - config
                    
                    XxxConfig.java
                    
                - util
                    
                    XxxUtil.java
                    
                - error

https://www.notion.so/ERD-e478d0e0cfc643d8a482d529eea7fa6c#724135056ff64e15bf2943d587a2b305

# URL 설계

/ GET : 홈페이지

/ POST : 장소 검색

/ login = 로그인

/ logout = 로그아웃

/ join = 회원가입

/ members GET : 회원 프로필 조회 (로그인된 멤버의 정보), 비로그인 시 로그인 또는 회원가입으로 안내

/ members / {memberNo} GET : 특정 회원 프로필 조회, 현재 로그인된 유저와 no가 동일할 경우 어떤 방식으로 표현할 건지 생각

/ members / update GET : 회원 프로필 수정/삭제 페이지

/ members / update PATCH : 회원 프로필 수정 redirect:/members

/ members / update DELETE : 회원 프로필 삭제(탈퇴) redirect:/ 

/ places GET : 내가 호스팅 하는 장소 리스트 조회 → 호스트 유저만 접근 가능, 심사 통과 여부, 비활성화 상태 등 확인가능

/ places / {placeNo} GET : 특정 장소 조회 

/ places / {placeNo} POST : 예약 요청, redirect:/reservation/payment

/ places / register GET : 장소 등록 페이지

/ places / register POST : 장소 등록  redirect:/places/{placeNo}

/ places / {placeNo} / update GET : 장소 수정/삭제 페이지

/ places / {placeNo} / update PATCH : 장소 수정 redirect:/places/{placeNo}

/ places / {placeNo} / update DELETE : 장소 삭제 redirect:/

/ reservations / guest GET : 나의 예약(게스트) 리스트 조회

/ reservations / host GET : 나의 예약(호스트) 리스트 조회, 호스트, 관리자만 접근, 예약 상태 확인가능

/ reservations / {reservationNo} GET : 특정 예약 조회 ,예약 당사자(게스트, 호스트), 관리자만 접근

/ reservations / {reservationNo} DELETE : 예약 삭제(취소)

/ reservations /  payment GET : 선택한 예약정보 재확인, 결제대기 페이지 조회

/ reservations /  payment POST : 결제 요청, redirect:카카오 결제페이지

/ reservations /  payment / success GET : 결제 성공 시, 예약 저장, redirect:/reservation/{reservationNo}

/ reservations /  payment / cancel GET : 결제 취소 시 보여질 화면 → 다시 예약페이지로?

/ reservations /  payment / cancel GET : 결제 실패 시 보여질 화면 → 다시 예약페이지로?

/ reviews GET : 후기 작성 페이지

/ reviews POST : 후기 작성

/ search GET : 검색된 장소 리스트 조회(쿼리스트링으로 필터링) // get 추천장소 보여주기 or 없음

/ search POST : 이미 검색된 페이지에서 장소 검색

/ management GET : 관리자 전용페이지

/ messages GET : 메시지 리스트 조회

/ message POST : 메시지 보내기

/ message/detail : 메세지 상세정보 조회 (1대1 채팅방)

/ favorites GET :  즐겨찾기 목록 조회

/ favorites POST : 즐겨찾기 페이지에서 색이 빈 하트를 누르면 색이 채워지고 즐겨찾기 추가 api요청

/ favorites DELETE : 즐겨찾기 페이지에서 색이 채워진 하트를 누르면 빈 하트로 바뀌고 즐겨찾기 삭제 api요청

/ statistics GET :  호스팅 통계, 호스트, 관리자만 접근
