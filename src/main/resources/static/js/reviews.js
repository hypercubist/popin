$(function () {
        const coloredStar = {
          color: "red",
        };
        const emptyStar = {
          color: "lightgray",
        };

        $("#star1").on("click", () => {
          $("#star1").css(coloredStar);
          $("#star1").nextAll().css(emptyStar);
          $("#rating").val(1);
        });
        $("#star2").on("click", () => {
          $("#star2").css(coloredStar);
          $("#star2").prevUntil().css(coloredStar);
          $("#star2").nextAll().css(emptyStar);
          $("#rating").val(2);
        });
        $("#star3").on("click", () => {
          $("#star3").css(coloredStar);
          $("#star3").prevUntil().css(coloredStar);
          $("#star3").nextAll().css(emptyStar);
          $("#rating").val(3);
        });
        $("#star4").on("click", () => {
          $("#star4").css(coloredStar);
          $("#star4").prevUntil().css(coloredStar);
          $("#star4").nextAll().css(emptyStar);
          $("#rating").val(4);
        });
        $("#star5").on("click", () => {
          $("#star5").css(coloredStar);
          $("#star5").prevUntil().css(coloredStar);
          $("#star5").nextAll().css(emptyStar);
          $("#rating").val(5);
        });
      });