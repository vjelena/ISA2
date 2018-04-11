$("#dugmeRegistrujSe").click(function(){		
	var provera = true;	
	var forma = $('form[id="formaRegistrujSe"]');
	var email = forma.find('[name=email]').val();
	var lozinka1 = forma.find('[name=lozinka1]').val();
	var lozinka2 = forma.find('[name=lozinka2]').val();
	var ime = forma.find('[name=ime]').val();
	var prezime = forma.find('[name=prezime]').val();
	var grad = forma.find('[name=grad]').val();
	var ulica = forma.find('[name=ulica]').val();
	var broj = forma.find('[name=broj]').val();
	var brojTelefona = forma.find('[name=brojTelefona]').val();
	
	alert("hhhhhh");
	
	if(!email) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti e-mail adresu.</label>');
		return false;
	}	
	if(!lozinka1) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti lozinku.</label>');
		return false;
	}	
	if(!lozinka2) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Ponovo morate uneti lozinku.</label>');
		return false;
	}	
	if(lozinka1 != lozinka2) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Lozinka mora biti ista u oba polja.</label>');
		return false;
	}	
	if(!ime) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti ime.</label>');
		return false;
	}	
	if(!prezime) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti prezime.</label>');
		return false;
	}	
	if(!grad) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti grad.</label>');
		return false;
	}	
	if(!ulica) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti ulicu.</label>');
		return false;
	}
	if(!broj) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti broj.</label>');
		return false;
	}
	if(!brojTelefona) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti broj telefona.</label>');
		return false;
	}	
	if(isNaN(brojTelefona)) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Broj moze sadrzati samo cifre.</label>');
		return false;
	}

	if(provera) {
		$('#divValidacija').empty();
	
		
		formDataAdresa = JSON.stringify({
			//jos tri polja u formi grad ulica broj
			grad:$("#formaRegistrujSe [name='grad']").val(),
			ulica:$("#formaRegistrujSe [name='ulica']").val(),
			broj:$("#formaRegistrujSe [name='broj']").val(),
		});
		
		formData = JSON.stringify({
			email:$("#formaRegistrujSe [name='email']").val(),
			lozinka:$("#formaRegistrujSe [name='lozinka1']").val(),
			ime:$("#formaRegistrujSe [name='ime']").val(),
			prezime:$("#formaRegistrujSe [name='prezime']").val(),			
			adresa : formDataAdresa,
			brojTelefona:$("#formaRegistrujSe [name='brojTelefona']").val()
		   });
		$.ajax({
			url: "http://localhost:8080/korisnik/registracija",
			type: "POST",
			data: formData,
			contentType: "application/json",
			datatype: 'json',
			success: function(data){
				if(data){
					alert("Registracija uspesna.");
					location.href = "http://localhost:8080/index.html"				
				}else
					alert("Registracija NIJE uspela.");
			}
		});
		alert(lozinka1)
	}
	
});

