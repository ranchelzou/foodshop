<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
        <#-- 边栏-->
           <#include "../common/nav.ftl"></include>

        <#--主要内容-->
        <div id="page-content-wrapper">
            <div class="container-fluid">
             <div class="row clearfix">
               <div class="col-md-4 column">
                <table class="table table-bordered table-condensed">
                    <thead>
                    <tr>
                        <th>订单id</th>
                        <th>订单总金额</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${orderDto.oid}</td>
                        <td>${orderDto.oamount}</td>
                    </tr>
                    </tbody>
                </table>
            </div>

        <#--订单详情表数据-->
            <div class="col-md-12 column">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>商品id</th>
                        <th>商品名称</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>总额</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list orderDto.orderDetailsList as orderDetail>
                        <tr>
                            <td>${orderDetail.fid}</td>
                            <td>${orderDetail.fname}</td>
                            <td>${orderDetail.fprice}</td>
                            <td>${orderDetail.fquantity}</td>
                            <td>${orderDetail.fquantity * orderDetail.fprice}</td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>

        <#--操作-->
            <div class="col-md-12 column">
                <#if orderDto.getOrderStatusEnum().message == "新订单">
                    <a href="/foodshop/seller/order/finish?oid=${orderDto.oid}" type="button" class="btn btn-default btn-primary">完结订单</a>
                    <a href="/foodshop/seller/order/cancel?oid=${orderDto.oid}" type="button" class="btn btn-default btn-danger">取消订单</a>
                </#if>
            </div>
             </div>
        </div>
        </div>
</div>

</body>
</html>