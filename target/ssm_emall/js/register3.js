(function(w,d,u){
	var loginForm = util.get('registerForm');
	if(!loginForm){
		return;
	}
	var userName = registerForm['userName'];
	var password = registerForm['password'];
	var nickName = registerForm['nickName'];
	var isSubmiting = false;
	var loading = new Loading();
	var page = {
		init:function(){
			loginForm.addEventListener('submit',function(e){
				if(!isSubmiting && this.check()){
					var value1 = userName.value;
					var value2 = md5(password.value);
					var value3 = nickName.value;
					isSubmiting = true;
					loading.show();
					ajax({
						data:{userName:value1,password:value2,nickName:value3},
						url:'api/register',
						success:function(result){
							location.href = 'login';
						},
						error:function(message){
							loading.result(message||'注册失败');
							isSubmiting = false;
						}
					});
				}
			}.bind(this),false);
			[userName,password].forEach(function(item){
				item.addEventListener('input',function(e){
					item.classList.remove('z-err');
				}.bind(this),false);
			}.bind(this));
		},
		check:function(){
			var result = true;
			[
				[userName,function(value){return value == ''}],
				[password,function(value){return value == ''}],
				[nickName,function(value){return value == ''}]
			].forEach(function(item){
				var value = item[0].value.trim();
				if(item[1](value)){
					item[0].classList.add('z-err');
					result = false;
				}
				item[0].value = value;
			});
			return result;
		}
	};
	page.init();
})(window,document);