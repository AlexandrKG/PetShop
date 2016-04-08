function changeSelect() {
	createTable(this.value);
}

function createSelect(id) {
	var selectID = id;
	var selectSubcateg = document.createElement('select');
	selectSubcateg.id = 'sc';
	var maxArr = categ.subcategs.length;
	for(var k = 0; k < maxArr; k++) {
		if(k == selectID) {
			selectSubcateg.options[k] = 
				new Option(categ.subcategs[k].name, k,false,true);
		} else {
			selectSubcateg.options[k] = 
				new Option(categ.subcategs[k].name, k,false,false);			
		}
	}
	selectSubcateg.onchange = changeSelect;//
	var tagForContent = document.getElementById('td-content');
	tagForContent.appendChild(selectSubcateg); 
	tagForContent.appendChild(document.createElement('BR'));
	tagForContent.appendChild(document.createElement('BR'));
}

function createTable(selectSubcateg) {
	var tagForContent = document.getElementById('td-content');
	
	var tagForm = document.getElementById('fgoods');
	if(tagForm !=undefined && tagForm !=null) {
		tagForContent.removeChild(tagForm);
	}
		
	tagForm = document.createElement('form'); 
	tagForm.id = 'fgoods';
	tagForm.action = choiseGoods.action;
	tagForm.method="GET";
	tableGoods = document.createElement('table');
	tableGoods.id='tgoods';
	tableGoods.style.display='table';
	tableGoods.style.margin='0 auto';
	tableGoods.style.border='1px solid black'; 
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
	tbCell[3] = tbRow[0].insertCell(3);
	tbCell[3].innerHTML="Select goods";	
	var k = 1;
	for(; k <= maxArr; k++) {
		var tbCell = [];
		tbRow[k]=tableGoods.insertRow(k);	
		tbCell[0] = tbRow[k].insertCell(0);
		tbCell[0].innerHTML=categ.subcategs[selectSubcateg].goods[k-1].name;
		tbCell[1] = tbRow[k].insertCell(1);
		tbCell[1].innerHTML=categ.subcategs[selectSubcateg].goods[k-1].number;
		tbCell[2] = tbRow[k].insertCell(2);
		tbCell[2].innerHTML=categ.subcategs[selectSubcateg].goods[k-1].price;	
		tbCell[3] = tbRow[k].insertCell(3);
		
		var radioButt = document.createElement('input');
//		radioButt.id = categ.subcategs[selectSubcateg].goods[k-1].id;
		radioButt.type = 'radio';
		radioButt.name='gid';
		radioButt.value = categ.subcategs[selectSubcateg].goods[k-1].id;	
		tbCell[3].appendChild(radioButt);		
	}
	
	tbRow[k]=tableGoods.insertRow(k); 
	var tbLastCell = tbRow[k].insertCell(0);
	tbLastCell.colSpan = "4";
	var spinBox = document.createElement('input');
	spinBox.name = 'goodsnum';
	spinBox.type = 'number';
	spinBox.min = 0;
	spinBox.max = 100;
	spinBox.step = 1;
	spinBox.size = 3;
	spinBox.value = 0;
	spinBox.style.width = '100%';
	spinBox.onchange = spinnerChange;
	tbLastCell.appendChild(spinBox);
	k++;
	tbRow[k]=tableGoods.insertRow(k); 
	var tbButCell = tbRow[k].insertCell(0);
	tbButCell.colSpan = "4";
	var buttonBuy = document.createElement('input');
	buttonBuy.type = 'button';
	buttonBuy.style.width = '100%';
	buttonBuy.onclick = buyGoods;
	buttonBuy.value='Buy';
	tbButCell.appendChild(buttonBuy);
	
	var tagInput = document.createElement('input');
	tagInput.type = 'hidden';
	tagInput.id = 'hidclient';
	tagInput.name = 'idcl';
	tagInput.value = 0;
		
	tagForm.appendChild(tableGoods);
	tagForm.appendChild(tagInput);
	tagForContent.appendChild(tagForm);
}

function buyGoods() {
	var rb = document.getElementsByName('gid');
    for (var i = 0; i < rb.length; i++) {
        if (rb[i].checked) {
        	choiseGoods.idgoods = rb[i].value;  	
        }
    }
    
    choiseGoods.idclient = document.getElementById('clid').value;
    document.getElementById('hidclient').value = choiseGoods.idclient;
    
    if(choiseGoods.idclient <= 0 || choiseGoods.idclient == "SELECT") {
    	alert("You must choose client!");
    } else if(choiseGoods.idgoods <= 0) {
    	alert("You must choose goods!");
    } else if (choiseGoods.num <= 0) {
    	alert("You must choose number of goods!");
    } else {
//    	alert("choiseGoods.idclient = " + choiseGoods.idclient);
//    	alert("choiseGoods.idgoods = " + choiseGoods.idgoods);
//    	alert("choiseGoods.num = " + choiseGoods.num);
//    	alert("choiseGoods.action = " + choiseGoods.action);
    	document.getElementById('fgoods').submit();
    }
} 

function spinnerChange() {
	choiseGoods.num = this.value;	
}