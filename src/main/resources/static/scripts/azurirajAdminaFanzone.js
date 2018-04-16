$(document).ready(function(){
		$.ajax({
			url : "http://localhost:8080/korisnik/getTrenutnoAktivan"
		}).then(function(data){
			$("#emailA").append(data.email);
			$("#lozinkaA").append(data.lozinka);
			$("#lozinka2A").append(data.lozinka);
			$("#imeA").append(data.ime);
			$("#prezimeA").append(data.prezime);
			$("#ulicaA").append(data.adresa.ulica);
			$("#brojA").append(data.adresa.broj);
			$("#gradA").append(data.adresa.grad);
			$("#brojTelefonaA").append(data.brojTelefona);
		});
});	
		
		
			$("#dugmeAzurirajPodatke").click(function(){
				var provera = true;
				var forma = $('form[id="formaAzurirajKorisnika"]');
				var email = forma.find('[name=email]').val();
				var lozinka = forma.find('[name=lozinka]').val();
				var lozinka2 = forma.find('[name=lozinka2]').val();
				var ime = forma.find('[name=ime]').val();
				var prezime = forma.find('[name=prezime]').val();
				var ulica = forma.find('[name=ulica]').val();
				var broj = forma.find('[name=broj]').val();
				var grad = forma.find('[name=grad]').val();
				var brojTelefona = forma.find('[name=brojTelefona]').val();
				
				if(!email) {
					$('#divValidacija').empty();
					$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti e-mail adresu.</label>');
					provera = false;
				}	
				if(!lozinka) {
					$('#divValidacija').empty();
					$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti lozinku.</label>');
					provera = false;
				}	
				if(!lozinka2) {
					$('#divValidacija').empty();
					$('#divValidacija').append('<label class="col-lg-8 control-label">Ponovo morate uneti lozinku.</label>');
					provera = false;
				}	
				if(lozinka != lozinka2) {
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
				
				if(provera) {
					$('#divValidacija').empty();
					
					var adresaJSON = {"ulica":$("#formaAzurirajKorisnika [name='ulica']").val(), 
									  "broj":$("#formaAzurirajKorisnika [name='broj']").val(),
									  "grad":$("#formaAzurirajKorisnika [name='grad']").val()};
					
					formData = JSON.stringify({
						email:$("#formaAzurirajKorisnika [name='email']").val(),
						lozinka:$("#formaAzurirajKorisnika [name='lozinka']").val(),
						ime:$("#formaAzurirajKorisnika [name='ime']").val(),
						prezime:$("#formaAzurirajKorisnika [name='prezime']").val(),
						adresa:adresaJSON,
						brojTelefona:$("#formaAzurirajKorisnika [name='brojTelefona']").val()
					   });
					
					$.ajax({
						url: "http://localhost:8080/adminFanzona/azuriraj",
						type: "PUT",
						data: formData,
						contentType: "application/json",
						datatype: 'json',
						success: function(data){
							if(data){
								location.href = "http://localhost:8080/homePage.html"				
							}else
								alert("Azuriranje NIJE uspelo.");
						},
						error: function(data){
							alert('GRESKA PRILIKOM AZURIRANJA!!!')
						}
					});
				}
			});
			
			
			$("#dugmeOdustaniOdAzuriranja").click(function(){
				location.href = "http://localhost:8080/homePage.html"
			});