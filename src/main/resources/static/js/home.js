  $(function () {
        $("#btn-anywhere").on("click", function () {
          $("#search-form").submit();
        });
        $("#btn-seoul").on("click", function () {
          $("#region1depth").val("서울");
          $("#coordX").val("126.978652258309");
          $("#coordY").val("37.566826004661");
          $("#search-form").submit();
        });
        $("#btn-jeju").on("click", function () {
          $("#region1depth").val("제주특별자치도");
          $("#coordX").val("126.498229141199");
          $("#coordY").val("33.4889179032603");
          $("#search-form").submit();
        });
        $("#btn-busan").on("click", function () {
          $("#region1depth").val("부산");
          $("#coordX").val("129.075087492149");
          $("#coordY").val("35.1798200522868");
          $("#search-form").submit();
        });
        $("#btn-daejeon").on("click", function () {
          $("#region1depth").val("대전");
          $("#coordX").val("127.38483484675");
          $("#coordY").val("36.3505388992836");
          $("#search-form").submit();
        });
        $("#btn-daegu").on("click", function () {
          $("#region1depth").val("대구");
          $("#coordX").val("128.601805491072");
          $("#coordY").val("35.8713802646197");
          $("#search-form").submit();
        });
        $("#btn-gyeonju").on("click", function () {
          $("#region1depth").val("경북");
          $("#region2depth").val("경주시");
          $("#coordX").val("129.22478171309");
          $("#coordY").val("35.8562184605051");
          $("#search-form").submit();
        });
      });