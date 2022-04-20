
    $(function () {
        console.log([[${searchDTO}]]);
        const today = new Date();
        const handlePick = function(ev, picker){

        $("#checkinDate").val(picker.startDate.format("YYYY-MM-DD"));
        $("#checkoutDate").val(picker.endDate.format("YYYY-MM-DD"));
      };
       $("#dates").daterangepicker({
        alwaysShowCalendars: true,
        minDate: today,
        locale: {
          format: "YYYY-MM-DD",
          separator: " ~ ",
          applyLabel: "확인",
          cancelLabel: "취소",
          daysOfWeek: ["일", "월", "화", "수", "목", "금", "토"],
          monthNames: [
            "1월",
            "2월",
            "3월",
            "4월",
            "5월",
            "6월",
            "7월",
            "8월",
            "9월",
            "10월",
            "11월",
            "12월",
          ],
        },
      });

        $("#dates").on("hide.daterangepicker", handlePick);
        $(".custom-select2").select2({
          ajax: {
            url: "https://dapi.kakao.com/v2/local/search/address.json",
            type: "GET",
            headers: {
              Authorization: "KakaoAK 5515f022981cb25e056392bfba8e6b4a",
            },
            data: function (params) {
              var result = {
                query: params.term,
              };
              return result;
            },
            processResults: function (data) {
              console.log(data);
              results = data.documents.map((item, index) => {
                return {
                  id: item.x + " " + item.y + " " + item.address_name,
                  text: item.address_name,
                };
              });
              // Transforms the top-level key of the response object from 'items' to 'results'
              return {
                results: results,
              };
            },
          },
        });

        $("#addressName").on("change", () => {
          const coordXY = $("#addressName").val().split(" ");
          $("#coordX").val(coordXY[0]);
          $("#coordY").val(coordXY[1]);
          $("#region1depth").val(coordXY[2] ? coordXY[2] : "");
          $("#region2depth").val(coordXY[3] ? coordXY[3] : "");
          $("#region3depth").val(coordXY[4] ? coordXY[4] : "");
        });

        $("#demo3_22").on("change", ()=>{$("#maxGuest").val($("#demo3_22").val())});

    });


