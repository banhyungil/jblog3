function addCategory(){
	var sendData = $("#form-cat-add").serialize();
	var contextPath = $("#contextPath").val();
	var catListLength = Number($("#catListLength").val());
	var userId = $("#userId").val();
	$("#name").val("");
	$("#description").val("");
	console.log(contextPath + userId);
	$.ajax({
		url : contextPath + "/blog/api/" + userId + "/insertCategory",
		type : "POST",
		dataType : "json",
		data : sendData,
		success : function(response){
			$("#category-list").append("<tr>"+ 
										"<td>"+ (catListLength + 1) + "</td>" +
										"<td>"+ response.data.name + "</td>" +
										"<td>"+ 0 + "</td>" +
										"<td>"+ response.data.description + "</td>" +
										"<td>" +
										"<img src='" + contextPath + "/assets/images/delete.jpg' " + "value='" +
										response.data.no + "' onclik='deleteCategory()'>" +  
        								"</td></tr>");
			
		},
		error : function(xhr, error){

		}
	});
}

function deleteCategory(thisObj){
	var contextPath = $("#contextPath").val();
	var userId = $("#userId").val();
	var categoryNo = thisObj.getAttribute('id');

	$.ajax({
		url : contextPath + "/blog/api/" + userId + "/deleteCategory",
		type : "POST",
		dataType : "json",
		data : {"categoryNo" : categoryNo},
		success : function(response){
			$("#tr-contain-img"+categoryNo).remove();
		},
		error : function(xhr, error){
			
		}
	})
}
		


