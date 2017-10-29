var back = {"filename":"..","fileType":"glyphicon-folder-open","lastMTime":"-","size":"0"};

function initNavigation(){
	$(".glyphicon #name").dblclick(function(){
		var path = $(this).html();
		console.log(path);
		makeRequest(path);
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
		fileType="glyphicon-file";
		if(obj[i].type=="folder")
			fileType="glyphicon-folder-open";
		obj[i].fileType = fileType;
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
			"<span class=\"glyphicon "+data.fileType+"\">" +
				"\x0a\x09\x09\x20\x20\x20\x20\x20\x09\x09<span id=\"name\">"+data.filename+"</span>" +
			"</span>" +
		"</td><td class=\"tg-j2zy align-text-center\">" +
			data.lastMTime +
		"</td><td class=\"tg-yw4l align-text-center\">" +
			data.size +
		"</td></tr>");
}