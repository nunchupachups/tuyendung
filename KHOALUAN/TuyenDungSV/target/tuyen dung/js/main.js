var slideIndex;

$(document).ready(function(){
  var w=$('.taocv-right').width();
        $('.taocv-huongdan').css('width',w);
  
});

   
function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  slides[slideIndex].style.display = "block";
  //chuyển đến slide tiếp theo
  slideIndex++;
}

showSlides((slideIndex = 0));

function currentSlide(n) {
  showSlides((slideIndex = n));
}

function showHuongdan(muc){
  var items=document.getElementsByClassName("taocv-huongdan-item");
  for (i = 0; i < items.length; i++) {
    items[i].style.display = "none";
  }

  var m=document.getElementsByClassName(muc);
  m[0].style.display = "block";
}