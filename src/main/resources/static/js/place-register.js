var mapContainer = document.getElementById("map"), // 지도를 표시할 div
            mapOption = {
              center: new daum.maps.LatLng(35.154556, 126.849474), // 지도의 중심좌표
              level: 5, // 지도의 확대 레벨
              mapTypeId: kakao.maps.MapTypeId.ROADMAP, // 지도종류
            };

          //지도를 미리 생성
          var map = new daum.maps.Map(mapContainer, mapOption);
          //주소-좌표 변환 객체를 생성
          var geocoder = new daum.maps.services.Geocoder();
          //마커를 미리 생성
          var marker = new daum.maps.Marker({
            position: new daum.maps.LatLng(35.154556, 126.849474),
            map: map,
          });

          // 마커 위에 표시할 인포윈도우를 생성한다
          var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="padding:5px 15px;">TEAM SUMMER</div>', // 인포윈도우에 표시할 내용
          });
          // 인포윈도우를 지도에 표시한다
          infowindow.open(map, marker);

          function addressSearch() {
            new daum.Postcode({
              oncomplete: function (data) {
                var addr = data.address; // 최종 주소 변수

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("addressName").value = addr;

                // 주소로 상세 정보를 검색
                geocoder.addressSearch(data.address, function (results, status) {
                  // 정상적으로 검색이 완료됐으면
                  if (status === daum.maps.services.Status.OK) {
                    var result = results[0]; //첫번째 결과의 값을 활용

                    // 해당 주소에 대한 좌표를 받아서
                    var coords = new daum.maps.LatLng(result.y, result.x);

                    $("#coordX").val(coords.La);
                    $("#coordY").val(coords.Ma);

                    // 지도를 보여준다.
                    mapContainer.style.display = "block";
                    map.relayout();
                    // 지도 중심을 변경한다.
                    map.setCenter(coords);
                    // 마커를 결과값으로 받은 위치로 옮긴다.
                    marker.setPosition(coords);
                  }
                });
              },
            }).open();
          }

          Dropzone.autoDiscover = false;
                $(".dropzone").dropzone({
                  addRemoveLinks: true,
                  removedfile: function(file) {
                    var name = file.name;
                    var _ref;
                    return (_ref = file.previewElement) != null ? _ref.parentNode.removeChild(file.previewElement) : void 0;
                  }
                });