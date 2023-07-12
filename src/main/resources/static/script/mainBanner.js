/**
 * author : BHS
 */


$(function(){
	var bannerSize = document.getElementById('bannerSize').value;
	let imgIndex = 0;
	let playFlag = false;
	let setFunction;
	function move(){
		$(".main_banner").animate({left:(-imgIndex * 1470)}, 100);
	}
	function run(){
		imgIndex++;
		imgIndex %= bannerSize;
		move();
	}
	function stop() {
		clearInterval(setFunction);
	}
	function play() {
		clearInterval(setFunction);
		setFunction = setInterval(run, 5000);
	}
	function slide(n){
		if (playFlag) return;
		imgIndex += n;
		if (imgIndex < 0) imgIndex = 0;
		else if (imgIndex > (bannerSize-1)) imgIndex = (bannerSize-1);
		move();
	}
	$("#lbutton").click(function(){
		slide(-1);
	});
	$("#rbutton").click(function(){
		slide(1);
	});
	$("#play_btn").click(function(){
		if (playFlag) {
			stop();
			$("#play_btn").text("▶");
		} else {
			play();
			$("#play_btn").text("∥");
		}
		playFlag = !playFlag;
	}).trigger("click");
});
