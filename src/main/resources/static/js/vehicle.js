$('document').ready(function() {
	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(vehicle, status){
			var acDate = vehicle.acquisitionDate.substr(0,10);
			$('#acquisitionDateEdit').val(acDate);
			$('#descriptionEdit').val(vehicle.description);
			$('#ddlEmployeeEdit').val(vehicle.employeeid);
			$('#fuelCapacityEdit').val(vehicle.fuelCapacity);
			$('#idEdit').val(vehicle.id);
			$('#ddlLocationEdit').val(vehicle.locationid);
			$('#nameEdit').val(vehicle.name);
			$('#netWeightEdit').val(vehicle.netWeight);
			$('#powerEdit').val(vehicle.power);
			var regDate = vehicle.registrationDate.substr(0,10);
			$('#registrationDateEdit').val(regDate);
			$('#remarksEdit').val(vehicle.remarks);
			$('#ddlVehicleMakeEdit').val(vehicle.vehiclemakeid);
			$('#ddlVehicleModelEdit').val(vehicle.vehiclemodelid);
			$('#vehicleNumberEdit').val(vehicle.vehicleNumber);
			$('#ddlVehicleStatusEdit').val(vehicle.vehiclestatusid);
			$('#ddlVehicleTypeEdit').val(vehicle.vehicletypeid);
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(vehicleType, status){
			$('#idDetails').val(vehicleType.id);
			$('#descriptionDetails').val(vehicleType.description);
			$('#detailsDetails').val(vehicleType.details);
			$('#lastModifiedByDetails').val(vehicleType.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicleType.lastModifiedDate.substr(0,19).replace("T", " "));
		});
		$('#detailsModal').modal();
	});

	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});

	$('.table #photoButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#photoModal #vehiclePhoto').attr('src', href);
		$('#photoModal').modal();
	});
});