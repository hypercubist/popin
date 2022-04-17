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

    $('#addressName').on('keyup',function(){
           $.ajax({
               url:'https://dapi.kakao.com/v2/local/search/address.json',
               type:'GET',
               headers: { 'Authorization': 'KakaoAK 5515f022981cb25e056392bfba8e6b4a' },
               data : {query : $('#addressName').val() },
           success:function(data){
               console.log(data);
               $('#map').empty();
               for(var i=0; i< data.documents.length; i++){
               var option = "<option>"+data.documents[i].address_name+"</option>";
                $('#map').append(option);
                $('#region1depth').val(data.documents[i].address.region_1depth_name);
                $('#region2depth').val(data.documents[i].address.region_2depth_name);
                $('#region3depth').val(data.documents[i].address.region_3depth_name);
                $('#coordX').val(data.documents[i].address.x);
                $('#coordY').val(data.documents[i].address.y);
               };

               $('select[id=map]').on('change',function(){
                    $('#addressName').val($(this).val());

               });
           },
           error : function(e){
               console.log(e);
           }
        });
    });

    $("#demo3_22").on("change", ()=>{$("#maxGuest").val($("#demo3_22").val())});
