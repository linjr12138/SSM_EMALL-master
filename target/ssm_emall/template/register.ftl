<!DOCTYPE html>
<html>
<#include "/include/head.ftl">
<body>
<#include "/include/support.ftl">
<#include "/include/header.ftl">
<form class="m-form m-form-ht n-login" id="registerForm" onsubmit="return false;" autocomplete="off">
    <div class="fmitem">
        <label class="fmlab">用户名：</label>
        <div class="fmipt">
            <input class="u-ipt" name="userName" autofocus/>
        </div>
    </div>
    <div class="fmitem">
        <label class="fmlab">密码：</label>
        <div class="fmipt">
            <input class="u-ipt" type="password" name="password"/>
        </div>
    </div>
    <div class="fmitem">
        <label class="fmlab">昵称：</label>
        <div class="fmipt">
            <input class="u-ipt" name="nickName" autofocus/>
        </div>
    </div>
    <div class="fmitem fmitem-nolab fmitem-btn">
        <div class="fmipt">
            <button type="submit" class="u-btn u-btn-primary u-btn-lg u-btn-block">注 册</button>
        </div>
    </div>
</form>
<#include "/include/footer.ftl">
<script type="text/javascript" src="js/md5.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/register3.js"></script>
</body>
</html>