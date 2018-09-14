function search(name){
	$.ajax({
		url:"/student/students/"+name,
		method:"GET",
		success:function(data){
			var tblData = "<tr><th>usn</th><th>name</th><th>college</th><th>sslcMarks</th><th>pucMarks</th><th>beMarks</th><th>Update</th><tr>";
			for(var i in data){
				tblData = tblData + "<tr><td>"+data[i].usn+"</td><td>"+data[i].name+"</td>" +
						"<td>" +data[i].college+ "</td>" +
						"<td>" +data[i].marks.sslcMarks+ "</td>" +
						"<td>" +data[i].marks.pucMarks+ "</td>" +
						"<td>" +data[i].marks.beMarks+ "</td>" +
						"<td class='update'>Update</td></tr>";
			}
			
			$("#tblStudents").html(tblData);
			
			$(".update").click(function(){
				var that = $(this);
				var usn = $(that.parent().html())[0].innerHTML;
				getSudentData(usn);
			});
			
		},
		error:function(){
			alert("Error in Gateway!!");
		}
	});
}

function getSudentData(usn){
	$.ajax({
		url:"/student/student/"+usn,
		method:"GET",
		success:function(data){
			$("#inpUsn").val(data.usn);
			$("#inpName").val(data.name);
			$("#inpCollege").val(data.college);
			$("#inpBe").val(data.marks.beMarks);
			$("#inpSslc").val(data.marks.sslcMarks);
			$("#inpPuc").val(data.marks.pucMarks);
		},
		error:function(){
			alert("Error");
		}
	});
}

function insertData(data){
	$.ajax({
		url:"/student/student",
		method:"POST",
		contentType:"application/json",
		data:JSON.stringify(data),
		success:function(data){
			alert("Success");
			clearData();
			search("*")
		},
		error:function(){
			alert("Error");
		}
	});
}

function clearData(){
	$("#inpUsn").val("");
	$("#inpName").val("");
	$("#inpCollege").val("");
	$("#inpSslc").val("");
	$("#inpPuc").val("");
	$("#inpBe").val("");
}

//init Load
search("*");

$("#btnSearch").click(function(){
	var searchVal = $("#inpSearch").val();
	if(searchVal==""){
		searchVal = "*";
	}
	
	search(searchVal);
});

$("#btnClear").click(function(){
	clearData();
});

$("#btnInsertData").click(function(){
	var data = {marks:{}};
	data.usn = $("#inpUsn").val();
	data.name = $("#inpName").val();
	data.college = $("#inpCollege").val();
	data.marks.usn = $("#inpUsn").val();
	data.marks.sslcMarks = $("#inpSslc").val();
	data.marks.pucMarks = $("#inpPuc").val();
	data.marks.beMarks = $("#inpBe").val();
	insertData(data);
});