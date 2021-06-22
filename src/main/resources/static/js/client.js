$('document').ready(function() {

$('.table #editButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (client, status) {
            $('#idEdit').val(client.id);
            $('#nameEdit').val(client.name);
            $('#ddlCountryEdit').val(client.countryid);
            $('#ddlStateEdit').val(client.stateid);
            $('#detailsEdit').val(client.details);
            $('#websiteEdit').val(client.website);
            $('#addressEdit').val(client.address);
            $('#cityEdit').val(client.city);
            $('#phoneEdit').val(client.phone);
            $('#mobileEdit').val(client.mobile);
            $('#emailEdit').val(client.email);
            $('#codeEdit').val(client.code);
            $('#nameEdit').val(client.name);
            $('#detailsEdit').val(client.details);
        });
        $('#editModal').modal();
    });

     $('.table #deleteButton').on('click', function (event) {
            event.preventDefault();
            var href = $(this).attr('href');

            $('#confirmDeleteButton').attr('href', href);

            $('#deleteModal').modal();
        });

});