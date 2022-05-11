$(document).ready(function() {
	$("#alertSuccess").hide();
	$("#alertError").hide();
});

// SAVE ============================================
$(document).on("click", "#btnSave", function(event) {

	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	// Form validation-------------------
	var status = validateItemForm();

	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	
	
	// If valid------------------------
	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "BillAPI",
		type : type,
		data : $("#formItem").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onItemSaveComplete(response.responseText, status);
		}
	});
});


function onItemSaveComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidItemIDSave").val("");
	$("#formItem")[0].reset();
}



// UPDATE==========================================
$(document)
		.on(
				"click",
				".btnUpdate",
				function(event) {

					$("#hidItemIDSave").val(
							$(this).closest("tr").find('#hidItemIDUpdate')
									.val());
					$("#docId").val(
							$(this).closest("tr").find('td:eq(0)').text());
					$("#docName").val(
					        $(this).closest("tr").find('td:eq(1)').text());
					$("#docUnit").val(
							$(this).closest("tr").find('td:eq(2)').text());
					$("#docAmount").val(
							$(this).closest("tr").find('td:eq(3)').text());
					

				});
				
$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "BillAPI",
		type : "DELETE",
		data : "docId=" + $(this).data("itemid"),
		dataType : "text",
		complete : function(response, status) {
			onItemDeleteComplete(response.responseText, status);
		}
	});
});


function onItemDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}


function validateItemForm() {

	// CODE
	if ($("#docId").val().trim() == "") {
		return "Insert Id.";
	}
	if ($("#docName").val().trim() == "") {
		return "Insert Name.";
	}

	
	if ($("#docUnit").val() == "0") {
		return "insert Unit.";
	}
	if ($("#docAmount").val() == "0") {
		return "insert Amount.";
	}
	
	

	return true;
}
