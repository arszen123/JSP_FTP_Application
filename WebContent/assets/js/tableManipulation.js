var back = {"filename":"..","fileType":"glyphicon-folder-open","lastMTime":"-","size":"0"};
var hidden = true;
function initNavigation(){
	$(".glyphicon").dblclick(function(){
		var path = $(this).children("#name").html();
		makeRequest(path);
	});

	$("#select").click(function(){
		chkBox = $("input:checkbox");
		execute = $("#executions");
		if(!hidden){
			chkBox.hide();
			execute.hide();
			hidden = true;
		}else{
			chkBox.prop('checked',false);
			chkBox.show();
			execute.show();
			hidden = false;
		}
	});
}

function makeRequest(path){	
	$.ajax({
		url:"getFiles?path="+path,
		success:function(result){
			parseResult(result);
		}
	});
}

function parseResult(result){
	obj = JSON.parse(result);
	tableBody = $(".tg");
	initTbody(tableBody);
	for(i=0;i<obj.length;i++){
		fileType="glyphicon-"+obj[i].type;
		if(obj[i].type=="folder")
			fileType += "-open";
		obj[i].fileType = fileType;
		obj[i].num = i+1;
		appendRow(tableBody,obj[i]);
	}
	initNavigation();
}

function initTbody(table){
	table.html("<tr>" +
			"<th class=\"tg-yw4l\">Name</th>" +
			"<th class=\"tg-yw4l\">Modified Time</th>" +
			"<th class=\"tg-yw4l\">Size</th>" +
		"</tr>");
	appendRow(table,back);
}

function appendRow(table, data){
	table.append("<tr>" +
			"<td class=\"tg-yw4l\">" +
			"<input type=\"checkbox\" id=\"file_"+data.num+"\" name=\"files\" style=\"display:none\">" +
			"<span class=\"glyphicon "+data.fileType+"\">" +
				"\x0a\x09\x09\x20\x20\x20\x20\x20\x09\x09<label for=\"file_"+data.num+"\" id=\"name\">"+data.filename+"</label>" +
			"</span>" +
		"</td><td class=\"tg-j2zy align-text-center\">" +
			data.lastMTime +
		"</td><td class=\"tg-yw4l align-text-center\">" +
			data.size +
		"</td></tr>");
}
