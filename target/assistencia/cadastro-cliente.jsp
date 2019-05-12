<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastro de Clientes</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/bootstrap-theme.min.css">
		<link rel="stylesheet" href="css/style.css">
		<script src="js/jquery-3.3.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</head>
	<body>
		<nav class="navbar navbar-default">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Home</a>
                </div>
            
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Clientes <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Cadastro de clientes</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Controle de clientes</a></li>
                    </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                    </li>
                </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <div class="container principal-container">
            <div class="col-md-12">
                <h3>Informe os dados do cliente.</h3>
                <form id="cadastroClientes" class="col-md-10 col-md-offset-1">
                    <h5 class="col-md-12">Informações basicas</h5>
                    <div class="col-md-4">
                        <input type="text" name="nome" required>
                        <label>Nome completo do cliente</label>
                    </div>
                    <div class="col-md-4">
                        <input type="text" name="cpf" required>
                        <label>CPF:</label>
                    </div>
                    <div class="col-md-4">
                        <input type="text" name="telefone" required>
                        <label>Telefone</label>
                    </div>
                    <div class="col-md-4">
                        <input type="text" name="email" required>
                        <label>Email</label>
                    </div>
                    <div class="form-group col-md-4">
                        <select class="form-control" name="sexo">
                            <option>Selecione o sexo</option>
                            <option>Feminino</option>
                            <option>Masculino</option>
                            <option>Prefere não informar</option>
                        </select>
                    </div> 
                    <h5 class="col-md-12">Dados de endereço</h5>
                    <div class="col-md-4">
                        <input type="text" name="cep" required>
                        <label>Cep</label>
                    </div>
                    <div class="col-md-6">
                        <input type="text" name="rua" required>
                        <label>Rua</label>
                    </div>
                    <div class="col-md-2">
                        <input type="text" name="numero" required>
                        <label>Numero</label>
                    </div>
                    <div class="col-md-8">
                        <input type="text" name="complemento" required>
                        <label>Complemento</label>
                    </div>
                    <div class="col-md-4">
                        <input type="text" name="bairro" required>
                        <label>Bairro</label>
                    </div>
                    <div class="col-md-4">
                        <input type="text" name="cidade" required>
                        <label>Cidade</label>
                    </div>

                    <div class="col-md-12 btn">
                        <button class="btn-cadastrar" type="submit" value="inserirCliente">Cadastrar cliente</button>
                    </div>
                </form>
            </div>
        </div>
	</body>
</html>