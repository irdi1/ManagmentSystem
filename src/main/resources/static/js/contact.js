$('document').ready(function() {

	$('.table .btn-primary').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(contact, status){
			$('#emailEdit').val(contact.email);
			$('#firstNameEdit').val(contact.firstname);
			$('#idEdit').val(contact.id);
			$('#lastNameEdit').val(contact.lastname);
			$('#mobileEdit').val(contact.mobile);
			$('#phoneEdit').val(contact.phone);
			$('#remarksEdit').val(contact.remarks);
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(country, status){
			$('#idDetails').val(country.id);
			$('#descriptionDetails').val(country.description);
			$('#codeDetails').val(country.code);
			$('#lastModifiedByDetails').val(country.lastModifiedBy);
			$('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
		});
		$('#detailsModal').modal();
	});

	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});
});