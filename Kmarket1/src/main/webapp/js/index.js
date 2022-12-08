
      $(function() {
        // 보이기 | 숨기기
        $(window).scroll(function() {
          if ($(this).scrollTop() > 250) { //스크롤이 250 넘으면 버튼 활성화
            $('#top').fadeIn();
            } else {
            $('#top').fadeOut();
        }
      });
        // 버튼 클릭시
        $("#top").click(function() {   
          $('html, body').animate({
            scrollTop : 0    // 0 까지 애니메이션 이동합니다.
          }, 400);          // 속도 400
          return false;
        });
      });
      $(document).ready(function() {
  slide();
});

var slideIndex = 0; //slide index

// HTML 로드가 끝난 후 동작
window.onload=function(){
  showSlides(slideIndex);

  // 배너 자동 슬라이드
  var sec = 3000;
  setInterval(function(){
    slideIndex++;
    showSlides(slideIndex);

  }, sec);
}


// Next/prev 버튼 controls
function moveSlides(n) {
  slideIndex = slideIndex + n
  showSlides(slideIndex);
}

// img controls
function currentSlide(n) {
  slideIndex = n;
  showSlides(slideIndex);
}

function showSlides(n) {

  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  var size = slides.length;

  if ((n+1) > size) {
    slideIndex = 0; n = 0;
  }else if (n < 0) {
    slideIndex = (size-1);
    n = (size-1);
  }

  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }

  slides[n].style.display = "block";
  dots[n].className += " active";
}