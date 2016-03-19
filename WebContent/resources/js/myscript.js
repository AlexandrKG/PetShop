function count_rabbits() {
	for (var i = 1; i <= 3; i++) {
		alert("Hello rabbit number " + i + " !");
	}
}

function showDoc() {
	alert("function showObject!!!");

	if (document == null) {
		alert("document null!!!");
	} else if (document == undefined) {
		alert("document undefined!!!");
	} else {
		alert("document exist!!!");

		for ( var key in document) {
			alert("Key: " + key + " value: " + document[key]);
		}
	}
}

function createTable(obj,selectSubcateg) {
	alert("categ: " + obj.name + "  selectSubcateg = " + selectSubcateg);
	
	var tableGoods = document.createElement('table');
	tableGoods.id='tgoods';
	tableGoods.display='table';
	tableGoods.margin='0 auto';
	tableGoods.border=1; 
//	tableGoods.class='center';
	var maxArr = categ.subcategs[selectSubcateg].goods.length;
	var tbRow = [];
	var tbCell = [];
	tbRow[0]=tableGoods.insertRow(0);
	tbCell[0] = tbRow[0].insertCell(0);
	tbCell[0].innerHTML="Goods";
	tbCell[1] = tbRow[0].insertCell(1);
	tbCell[1].innerHTML="Number";
	tbCell[2] = tbRow[0].insertCell(2);
	tbCell[2].innerHTML="Price";
	for(var k = 1; k <= maxArr; k++) {
		var tbCell = [];
		tbRow[k]=tableGoods.insertRow(k);	
		tbCell[0] = tbRow[k].insertCell(0);
		tbCell[0].innerHTML=categ.subcategs[selectSubcateg].goods[k-1].name;
		tbCell[1] = tbRow[k].insertCell(1);
		tbCell[1].innerHTML=categ.subcategs[selectSubcateg].goods[k-1].number;
		tbCell[2] = tbRow[k].insertCell(2);
		tbCell[2].innerHTML=categ.subcategs[selectSubcateg].goods[k-1].price;	
	}

		
	var tagForContent = document.getElementById('td-content');
	tagForContent.appendChild(tableGoods); 
}

function showBean(bean) {
	alert("function showBean!!!");
	var obj = bean;
	
//	if (document == null) {
//		alert("document null!!!");
//	} else if (document == undefined) {
//		alert("document undefined!!!");
//	} else {
//		alert("document exist!!!");
//
//		for ( var key in document) {
//			alert("Key: " + key + " value: " + document[key]);
//		}
//	}
	
	function showObject(obj) {
		alert("function showBean!!!");
	}
	
	
//	var listOfObjects = [];
//	var a = ["car", "bike", "scooter"];
//	a.forEach(function(entry) {
//	    var singleObj = {}
//	    singleObj['type'] = 'vehicle';
//	    singleObj['value'] = entry;
//	    listOfObjects.push(singleObj);
//	});
	
//	var a = ["car", "bike", "scooter"];
//	a.map(function(entry) {
//	    var singleObj = {}
//	    singleObj['type'] = 'vehicle';
//	    singleObj['value'] = entry;
//	    return singleObj;
//	});
}