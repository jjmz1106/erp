/**
 * 
 */


function $(selector){
	var obj = document.querySelector(selector);
	obj.text = function(str){
		if(str){
			obj.innerText = str;
		}else{
			return obj.innerText;	
		}
	}
	return obj;
}