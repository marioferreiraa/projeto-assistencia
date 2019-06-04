$(function(){
	
	var maskTel = "(99) 99999-9999";
	var maskCPF = "999.999.999-99"
	
	$('.telefone').on('change', function(){
		if($(this).val().length == 11){
			$(this).mask(maskTel);
		}
	})
	
	$('.cpf').on('change', function(){
		var _this = $(this);
		if(_this.val().length == 11){
			if(validarCPF(_this.val()))
				_this.mask(maskCPF);
			else{
				alert("CPF INVÁLIDO");
				_this.val('');
			}
		}	
	});
	
	$('.email').on('blur', function(){
		if(!IsEmail($(this).val())){
			alert('O EMAIL DIGITADO É INVÁLIDO');
			$(this).val('');
		}
	});
	
	function IsEmail(email){
	    var regex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	    if(regex.test(email)){
	    	return true;
	    }
	    return false;
	}
	
	function validarCPF(cpf) {	
		cpf = cpf.replace(/[^\d]+/g,'');	
		if(cpf == '') return false;	
		// Elimina CPFs invalidos conhecidos	
		if (cpf.length != 11 || 
			cpf == "00000000000" || 
			cpf == "11111111111" || 
			cpf == "22222222222" || 
			cpf == "33333333333" || 
			cpf == "44444444444" || 
			cpf == "55555555555" || 
			cpf == "66666666666" || 
			cpf == "77777777777" || 
			cpf == "88888888888" || 
			cpf == "99999999999")
				return false;		
		// Valida 1o digito	
		add = 0;	
		for (i=0; i < 9; i ++)		
			add += parseInt(cpf.charAt(i)) * (10 - i);	
			rev = 11 - (add % 11);	
			if (rev == 10 || rev == 11)		
				rev = 0;	
			if (rev != parseInt(cpf.charAt(9)))		
				return false;		
		// Valida 2o digito	
		add = 0;	
		for (i = 0; i < 10; i ++)		
			add += parseInt(cpf.charAt(i)) * (11 - i);	
		rev = 11 - (add % 11);	
		if (rev == 10 || rev == 11)	
			rev = 0;	
		if (rev != parseInt(cpf.charAt(10)))
			return false;		
		return true;   
	}
	
	$(".cep").on('keyup',function() {
		console.log("alterou");
		if($(this).val().length == 8){
			console.log("tentando...");
	        var cep = $(this).val().replace(/\D/g, '');
	        if (cep != "") {
	            var validacep = /^[0-9]{8}$/;
	            if(validacep.test(cep)) {
	                $(".rua").val("...");
	                $(".bairro").val("...");
	                $(".cidade").val("...");
	                $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {
	                    if (!("erro" in dados)) {
	                        $(".rua").val(dados.logradouro);
	                        $(".bairro").val(dados.bairro);
	                        $(".cidade").val(dados.localidade);
	                    }else {
	                        limpa_formulário_cep();
	                        alert("CEP não encontrado.");
	                    }
	                });
	            }else {
	                limpa_formulário_cep();
	                alert("Formato de CEP inválido.");
	            }
	        }else {
	            limpa_formulário_cep();
	        }
		}
    });
	
	function limpa_formulário_cep() {
        $(".rua").val("");
        $(".bairro").val("");
        $(".cidade").val("");
    }
	
});