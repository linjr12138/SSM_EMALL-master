 $(function () {
        $('button').on('click',function () {
            let judge=$('#userName,#password,#Reconfirm').val();
            let pass=$('#password').val();
            let Reconfirm=$('#Reconfirm').val();
            if(judge==''){
                alert("请输入账号或密码");
                return false;
            }
            if (pass==Reconfirm){
                $('#subform').submit();
            }else{
                alert('2次密码必须一致');
                return false;
            }
        })
    });
 function Submission() {
     $('button').on('click',function () {
         // var username=$('#username').val
         $.ajax({
             data:{
                 username:$('#userName').val(),
                 password:$('#password').val(),
                 Nickname:$('#nickName').val()
             },
                 url:'api/register',
                 type:'post',
                success:function(result){
                    loading.hide();
                    location.href = '/login';
                },
                error:function(message){
                 loading.result(message||'登录失败');
             }
             }
         )

     })
 };
