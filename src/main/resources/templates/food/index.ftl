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
                    <form role="form" method="post" action="/foodshop/seller/food/save">
                        <div class="form-group">
                            <label>名称</label>
                            <input name="fname" type="text" class="form-control" value="${(foodInfo.fname)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>价格</label>
                            <input name="fprice" type="text" class="form-control" value="${(foodInfo.fprice)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input name="fdescription" type="text" class="form-control" value="${(foodInfo.fdescription)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>图片</label>
                            <img height="100" width="100" src="${(foodInfo.fimage)!''}" alt="">
                            <input name="productIcon" type="text" class="form-control" value="${(foodInfo.fimage)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>类目</label>
                            <select name="ctype" class="form-control">
                                <#list categoryList as category>
                                    <option value="${category.ctype}"
                                            <#if (foodInfo.ctype)?? && foodInfo.ctype == category.ctype>
                                                selected
                                            </#if>
                                        >${category.cname}
                                    </option>
                                </#list>
                            </select>
                        </div>
                        <input hidden type="text" name="fid" value="${(foodInfo.fid)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>