$.ajax({
	url: "http://localhost:8080/bioskopi/prikaziBioskope",
	type: "GET",
	contentType: "application/json",
	datatype: 'json',
	success: function(data){
		if(data){
			console.log("GET ZAHTEV");
			console.log(data);
			$.each(data, function(index, val){
				console.log(index, val);
				$("#sviBioskopiAdmin").append('<option value="' + val.id + '">' + val.naziv + '</option>');
			});
							
		}else
			alert("GRESKA");
	}
});

$("#dugmeRegistrujAdmina").click(function(){
	
				var provera = true;
				var forma = $('form[id="formaRegistrujAdmina"]');
				var email = forma.find('[name=email]').val();
				var lozinka1 = forma.find('[name=lozinka1]').val();
				var lozinka2 = forma.find('[name=lozinka2]').val();
				var ime = forma.find('[name=ime]').val();
				var prezime = forma.find('[name=prezime]').val();
				var ulica = forma.find('[name=ulica]').val();
				var broj = forma.find('[name=broj]').val();
				var grad = forma.find('[name=grad]').val();
				var brojTelefona = forma.find('[name=brojTelefona]').val();
				var tip = forma.find('[name=tip]').val();
				
				if(!email) {
					$('#divValidacija').empty();
					$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti e-mail adresu.</label>');
					provera = false;
				}	
				if(!lozinka1) {
					$('#divValidacija').empty();
					$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti lozinku.</label>');
					provera = false;
				}	
				if(!lozinka2) {
					$('#divValidacija').empty();
					$('#divValidacija').append('<label class="col-lg-8 control-label">Ponovo morate uneti lozinku.</label>');
					provera = false;
				}	
				if(lozinka1 != lozinka2) {
					$('#divValidacija').empty();
					$('#divValidacija').append('<label class="col-lg-8 control-label">Lozinka mora biti ista u oba polja.</label>');
					provera = false;
				}	
				if(!ime) {
					$('#divValidacija').empty();
					$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti ime.</label>');
					provera = false;
				}	
				if(!prezime) {
					$('#divValidacija').empty();
					$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti prezime.</label>');
					provera = false;
				}		
				if(!ulica) {
					$('#divValidacija').empty();
					$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti naziv ulice.</label>');
					provera = false;
				}
				if(!broj) {
					$('#divValidacija').empty();
					$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti broj.</label>');
					provera = false;
				}
				if(isNaN(broj)) {
					$('#divValidacija').empty();
					$('#divValidacija').append('<label class="col-lg-8 control-label">Broj moze sadrzati samo cifre.</label>');
					provera = false;
				}
				if(!grad) {
					$('#divValidacija').empty();
					$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti naziv grada.</label>');
					provera = false;
				}
				if(!brojTelefona) {
					$('#divValidacija').empty();
					$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti broj telefona.</label>');
					provera = false;
				}	
				if(isNaN(brojTelefona)) {
					$('#divValidacija').empty();
					$('#divValidacija').append('<label class="col-lg-8 control-label">Broj moze sadrzati samo cifre.</label>');
					provera = false;
				}

				if(!tip) {
					$('#divValidacija').empty();
					$('#divValidacija').append('<label class="col-lg-8 control-label">Morate odabrati tip.</label>');
					provera = false;
				}
				
				if(provera) {
					$('#divValidacija').empty();
					
					var adresaJSON = {"ulica":$("#formaRegistrujAdmina [name='ulica']").val(), 
									  "broj":$("#formaRegistrujAdmina [name='broj']").val(),
									  "grad":$("#formaRegistrujAdmina [name='grad']").val()};
						
					formData = JSON.stringify({
						email:$("#formaRegistrujAdmina [name='email']").val(),
						lozinka:$("#formaRegistrujAdmina [name='lozinka1']").val(),
						ime:$("#formaRegistrujAdmina [name='ime']").val(),
						prezime:$("#formaRegistrujAdmina [name='prezime']").val(),
						grad:$("#formaRegistrujAdmina [name='grad']").val(),
						ulica:$("#formaRegistrujAdmina [name='ulica']").val(), 
						broj:$("#formaRegistrujAdmina [name='broj']").val(),
						brojTelefona:$("#formaRegistrujAdmina [name='brojTelefona']").val(),
						uloga:$("#formaRegistrujAdmina [name='tip']").val(),
						bioskop:$("#formaRegistrujAdmina [name='bioskopAdmin']").val()
					   });
					console.log(formData)
					$.ajax({
						url: "http://localhost:8080/admin/dodajAdmina",
						type: "POST",
						data: formData,
						contentType: "application/json",
						datatype: 'json',
						success: function(data){
							if(data){
								location.href = "http://localhost:8080/adminHomePage.html"				
							}else
								alert("Registracija NIJE uspela.");
						},
						error: function(data){
							alert('GRESKA PRILIKOM REGISTRACIJE!!!')
						}
					});
				}
			});
