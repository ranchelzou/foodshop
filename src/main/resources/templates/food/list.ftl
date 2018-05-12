<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "../common/nav.ftl">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>商品id</th>
                            <th>名称</th>
                            <#--<th>图片</th>-->
                            <th>单价</th>
                            <th>描述</th>
                            <th>类目</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list foodInfoPage.content as foodInfo>
                        <tr>
                            <td>${foodInfo.fid}</td>
                            <td>${foodInfo.fname}</td>
                            <#--<td><img height="100" width="100" src="${foodInfo.fimage}" alt=""></td>-->
                            <td>${foodInfo.fprice}</td>
                            <td>${foodInfo.fdescription}</td>
                            <td>${foodInfo.ctype}</td>
                            <td>${foodInfo.fcreatetime}</td>
                            <td>${foodInfo.fupdatetime}</td>
                            <td><a href="/foodshop/seller/food/index?fid=${foodInfo.fid}">修改</a></td>
                            <td>
                            <#if foodInfo.getFoodStatusEnum().message == "在架">
                                <a href="/foodshop/seller/food/off_sale?fid=${foodInfo.fid}">下架</a>
                            <#else>
                                <a href="/foodshop/seller/food/on_sale?fid=${foodInfo.fid}">上架</a>
                            </#if>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

            <#--分页-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/foodshop/seller/food/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..foodInfoPage.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/foodshop/seller/food/list?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte foodInfoPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/foodshop/seller/order/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>