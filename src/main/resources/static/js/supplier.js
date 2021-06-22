/**
 *
 */

$('document').ready(function() {

	$('.table .btn-primary').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(supplier, status){
			$('#addressEdit').val(supplier.address);
			$('#cityEdit').val(supplier.city);
			$('#countryEdit').val(supplier.countryid);
			$('#detailsEdit').val(supplier.details);
			$('#emailEdit').val(supplier.email);
			$('#idEdit').val(supplier.id);
			$('#mobileEdit').val(supplier.mobile);
			$('#nameEdit').val(supplier.name);
			$('#phoneEdit').val(supplier.phone);
			$('#stateEdit').val(supplier.stateid);
			$('#websiteEdit').val(supplier.website);
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