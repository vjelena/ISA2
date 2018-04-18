$(document).ready(function(){
		$.ajax({
			url : "http://localhost:8080/korisnik/getTrenutnoAktivan"
		}).then(function(data){
			$("#lozinkaA").append(data.lozinka);
			$("#lozinka2A").append(data.lozinka);
		});
});	

$("#dugmeAzurirajPodatke").click(function(){
				var provera = true;
				var forma = $('form[id="formaAzurirajKorisnika"]');
				var lozinka = forma.find('[name=lozinka]').val();
				var lozinka2 = forma.find('[name=lozinka2]').val();
				
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
				
				if(provera) {
					$('#divValidacija').empty();
					
					formData = JSON.stringify({
						lozinka:$("#formaAzurirajKorisnika [name='lozinka']").val()
					});
					
					$.ajax({
						url: "http://localhost:8080/adminFanzona/promenaLozinke",
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