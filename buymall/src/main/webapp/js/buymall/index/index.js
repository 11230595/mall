$(function() {
	// 获取要定位元素距离浏览器顶部的距离
	var navH = $(".skyblue").offset().top;

	// 滚动条事件
	$(window).scroll(function() {
		// 获取滚动条的滑动距离
		var scroH = $(this).scrollTop();
		// 滚动条的滑动距离大于等于定位元素距离浏览器顶部的距离，就固定，反之就不固定
		if (scroH >= navH) {
			$(".skyblue").css({
				"position" : "fixed",
				"top" : 0,
				"z-index":999,
				"width":"1170px"
			});
		} else if (scroH < navH) {
			$(".skyblue").css({
				"position" : "absolute",
				"top":''
			});
		}
	})
})
