$(document).on('submit', '#formaPrijaviSe', function(e) {
	
	e.preventDefault();
	
	var provera = true;	
	var forma = $('form[id="formaPrijaviSe"]');
	var email = forma.find('[name=email]').val();
	var lozinka = forma.find('[name=lozinka]').val();
	
	if(!lozinka) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti lozinku.</label>');
		provera = false;
	}
	if(!email) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti e-mail adresu.</label>');
		provera = false;
	}

	if(provera) {
		$('#divValidacija').empty();
		alert('Moras uraditi redirekciju na homePage PRIJAVELJNOG korisnika! (za sada ide na homePage.html)');
		location.href = "http://localhost:8080/homePage.html"		
	}
	
});
