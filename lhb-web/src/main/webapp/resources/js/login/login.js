var login={
    /**
     * 校验密码：只能输入6-20个字母、数字、下划线
     * @param s
     * @returns {boolean}
     */
    isPasswd : function(s){
       var patrn=/^(\w){4,20}$/;
       if (!patrn.exec(s)){
          return false;
       }
       return true
    },
    /**
     * 登录验证，成功则登陆
     */
    loginCheck:function(){
        //common.alertInfo("开发中。。。");
        var account = $("input[name='account']").eq(0).val();
        var password = $("input[name='password']").eq(0).val();
        var parameter={
            account:account,
            password:password
        };

        $(".error_style").hide();
        if(!login.isPasswd(account)){
            $(".form").css("padding-top","0");
            $(".error_style").show();
            $(".error_style").html("账号输入有误");
            $("input[name='account']").eq(0).focus();
            return;
        }
        if(!login.isPasswd(password)){
            $(".form").css("padding-top","0");
            $(".error_style").show();
            $(".error_style").html("密码输入有误");
            $("input[name='password']").eq(0).focus();
            return;
        }

        common.postData(basePath+"/login/login.do",parameter,function(data){
            switch (data.ret){
                case 0:
                    $(".form").css("padding-top","0");
                    $(".error_style").show();
                    $(".error_style").html("账号或密码输入有误");
                    break;
                case -1:
                    $(".form").css("padding-top","0");
                    $(".error_style").show();
                    $(".error_style").html("系统开小差了");
                    break;
                case 1:
                    window.location.href=basePath+"/bsc/welcome.do";
                    break;
            }
        });

    }
};

$(function(){
    $("body").keydown(function() {
        if (event.keyCode == "13") {//keyCode=13是回车键
            login.loginCheck();
        }
    });
});

