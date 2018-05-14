<!DOCTYPE html>
<html lang="en">
<#--边栏sidebar-->
<#include "../common/buyerheader.ftl">
<body>
	<!-- 滚动头部 -->
	<div id="move-top">
		<div class="m-main">
			<div class="m-logo"><a href="index.html"></a></div>

			<div class="m-search">
				<input  class ="search-text" type="text" placeholder="输入商品名／编号／拼音">
				<button>搜索</button><a href="#">美心月饼</a><a href="#">冰淇淋</a><a href="#">奇异果</a><a href="#">榴莲</a><a href="#">墨鱼水饺</a>
			</div>
			<div class="m-cart">
				<a href="shopping-cart.html">
					<b><i>0</i></b>
					<span class="totlePrice">0.0</span>
				</a>
				<!-- 购物车详情 -->
				<div class="move-list">
					<div class="m-nogoods">购物车中还没有商品，赶紧选购吧！
					</div>
					<div class="goods">
						<ul></ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 头部  开始-->
	<div class="header">
		<!-- 顶部导航 -->
		<div class="site-nav">
			<div class="nav-left">
				<span class="f1">欢迎光临易果生鲜！</span>
			</div>
			<div class = "nav-right">
				<ul >
					<li><a href="#" class="login">[登录]</a></li>
					<li><a href="#"  class="signin">[注册]</a></li>
                    <li><a href="#">我的订单</a></li>

				</ul>

			</div>
		</div>
	</div>
	<!-- 头部结束 -->
	<!-- 搜索栏 -->
	<div class="search-bg">
		<div class="search">
			<div class="logo"><a href="index.html"></a></div>

			<div class="search-box">
				<p>
					<input class ="search-text" type="text" placeholder="输入商品名／编号／拼音">
					<button>搜索</button>
				</p>
				<p class="search-keywords">
					 <a href="#">美心月饼</a>
                    <a href="#">冰淇淋</a><a href="#">奇异果</a><a href="#">榴莲</a><a href="#">墨鱼水饺</a><a href="#">进口饮用水</a><a href="#">澳大利亚脐橙</a><a href="#">新西兰苹果</a>
				</p>
			</div>

			<div class="shopping-cart">
				<a href="shopping-cart.html">
					<b><i>0</i></b>
					<span class="totlePrice">0.0</span>
				</a>
				<!-- 购物车详情 -->
				<div class="shopping-list">
					<div class="nogoods">购物车中还没有商品，赶紧选购吧！
					</div>
					<div class="goods">
						<ul></ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 广告窗 -->
	<div class="banner-bg">
		<!-- 轮播图 -->
		<div class="banner">
			 <div><img src="/foodshop/images/banner/1.jpg"  class="animate"></div>
			<div><img src="/foodshop/images/banner/2.jpg"></div>
			<div><img src="/foodshop/images/banner/3.jpg"></div>
			<div><img src="/foodshop/images/banner/4.jpg"></div>
			<div><img src="/foodshop/images/banner/5.jpg"></div>
			<div><img src="/foodshop/images/banner/6.jpg"></div>
			<div><img src="/foodshop/images/banner/7.jpg"></div>
			<div><img src="/foodshop/images/banner/8.jpg"></div>
			<div class="prev"></div>
			<div class="next"></div>
			<div class="b-dot">
				<ul>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</div>
		</div>
		<!-- 商品分类 -->
		<div class="sort-bg">
			<div class="sort-wrap">
				<div class="catalogs">
					<b>全部商品分类▼</b>
                    <#--<div class="dropdown">-->
                        <#--<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 商品▼ <span class="caret"></span></a>-->
                        <div class="catalogs-list" >
						 <div class="item">
							<p><s>></s></p>
							<#--<a href="#"><i></i>${category.cname}</a>-->
							 <a href="#"><i></i>dabaicai</a>
							<div class ="catalogs-sub" >
								<h4><a href="#">dabaicai</a></h4>
								<div class="sub-list"></div>
								<div class="sub-img">
									<a href="#"><img src="/foodshop/images/sort/1.png" alt=""></a>
								</div>
							</div>

						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

	<!-- 底部 -->
	<div class="footer_service">
		<div class="foot-wrap">
			<ul>
				<li class="s1">
					<b>全球精选</b>
					<span>一站式生鲜购物方案</span>
				</li>
				<li class="s2">
					<b>多仓直发</b>
					<span>特有次日达配送服务</span>
				</li>
				<li class="s3">
					<b>源头直采</b>
					<span>精选正宗品质好食材</span>
				</li>
				<li class="s4">
					<b>天天底价</b>
					<span>会员专属优惠购不停</span>
				</li>
			</ul>
		 </div>
	</div>

</body>
<script type = "text/javascript"
        src = "/foodshop/js/require.js"
        defer async = "true" data-main = "/foodshop/js/main.js" charset="utf-8"></script>
</html>
