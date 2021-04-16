
var r = document.getElementById("myRangeR");
var b = document.getElementById("myRangeB");
var g = document.getElementById("myRangeG");
var output = document.getElementById("demo");

var intervalId = window.setInterval(function(){
    document.getElementById("page").style.backgroundColor = "rgb("+r.value + "," + g.value + "," + b.value + ")";
    document.getElementById("rgb").innerHTML = "RGB("+r.value+","+g.value+","+b.value+")";
  }, 50);
//clearInterval(intervalId)  to stop the loop


